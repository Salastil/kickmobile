#!/usr/bin/env python3
"""Fetch the upstream source/binaries for the pinned native libraries of the Kick APK.

Reads reference/kick-40.32.1/native-deps.lock.json and downloads each library's pinned
npm tarball or Maven artifact into vendor/upstream/ (gitignored), so you can read the real
upstream code at the exact version the app shipped instead of reversing the .so.

  python3 scripts/fetch_upstream.py list
  python3 scripts/fetch_upstream.py fetch libreanimated.so [libworklets.so ...]
  python3 scripts/fetch_upstream.py fetch --all
  python3 scripts/fetch_upstream.py verify [--write]   # byte-compare released AARs with the APK libs

Only the standard library is used. Downloads are untrusted data: they are extracted into their
own new directories and never executed.
"""
import http.client, io, json, pathlib, sys, tarfile, urllib.request, urllib.error, zipfile

ROOT = pathlib.Path(__file__).resolve().parent.parent
LOCK = ROOT / "reference/kick-40.32.1/native-deps.lock.json"
OUT = ROOT / "vendor/upstream"
REPOS = {"central": "https://repo1.maven.org/maven2", "google": "https://dl.google.com/android/maven2",
         "rn": "https://repo.reactnative.dev/maven2"}  # RN release candidates / Hermes live here


def get(url, tries=6):
    import time
    for i in range(tries):
        try:
            with urllib.request.urlopen(urllib.request.Request(url, headers={"User-Agent": "Mozilla/5.0 fetch_upstream"}), timeout=300) as r:
                return r.read()
        except urllib.error.HTTPError as e:
            if e.code not in (429, 503) or i == tries - 1:
                raise
            time.sleep(8 * (i + 1))  # Maven Central rate-limits bursts
        except (http.client.IncompleteRead, OSError):
            if i == tries - 1:  # large AARs sometimes get cut off by the proxy; just retry
                raise
            time.sleep(3)


def safe_extract_tar(data, dest):
    with tarfile.open(fileobj=io.BytesIO(data)) as t:
        for m in t.getmembers():
            p = (dest / m.name).resolve()
            if not str(p).startswith(str(dest.resolve())) or m.issym() or m.islnk():
                continue
            t.extract(m, dest, filter="data") if hasattr(tarfile, "data_filter") else t.extract(m, dest)


def safe_extract_zip(data, dest):
    with zipfile.ZipFile(io.BytesIO(data)) as z:
        for n in z.namelist():
            if str((dest / n).resolve()).startswith(str(dest.resolve())):
                z.extract(n, dest)


def fetch_source(src, label):
    t = src.get("type")
    if t == "npm":
        pkg, ver = src["package"], src["version"]
        meta = json.loads(get(f"https://registry.npmjs.org/{pkg.replace('/', '%2f')}"))
        v = meta["versions"].get(ver)
        if v is None:  # a range such as ~4.29.0: take the highest matching patch
            pre = ver.lstrip("~^")
            cands = [x for x in meta["versions"] if x.startswith(".".join(pre.split(".")[:2]) + ".")]
            cands.sort(key=lambda s: [int(p) if p.isdigit() else 0 for p in s.replace("-", ".").split(".")])
            if not cands:
                return print(f"  ! no npm version matches {pkg}@{ver}")
            print(f"  note: {pkg}@{ver} is a range; using {cands[-1]} (true patch unknown)")
            ver, v = cands[-1], meta["versions"][cands[-1]]
        dest = OUT / f"npm__{pkg.replace('/', '_')}@{ver}"
        if dest.exists():
            return print(f"  = {dest.relative_to(ROOT)} (already there)")
        dest.mkdir(parents=True)
        safe_extract_tar(get(v["dist"]["tarball"]), dest)
        print(f"  + {dest.relative_to(ROOT)}")
    elif t == "maven":
        coord = src["coordinate"]
        if "<unknown>" in coord:
            return print(f"  ! version unresolved for {coord}")
        g, a, v = coord.split(":")
        base = f"{REPOS[src['repo']]}/{g.replace('.', '/')}/{a}/{v}/{a}-{v}"
        aar = src.get("aar_suffix", "") + ".aar"
        dest = OUT / f"maven__{g}__{a}@{v}"
        if dest.exists():
            return print(f"  = {dest.relative_to(ROOT)} (already there)")
        dest.mkdir(parents=True)
        got = False
        for suffix, ex in (("-sources.jar", "sources"), (aar, "aar"), (".jar", "jar")):
            if suffix == "-sources.jar" and not src.get("has_sources_jar", True):
                continue
            try:
                data = get(base + suffix)
            except urllib.error.HTTPError:
                continue
            safe_extract_zip(data, dest / ex)
            print(f"  + {(dest / ex).relative_to(ROOT)}  ({suffix.lstrip('-.')})")
            got = True
            if suffix == "-sources.jar":
                break
        if not got:
            dest.rmdir()
            print(f"  ! nothing downloadable for {coord}")
    else:
        print(f"  - no fetchable source ({src.get('note', 'none')})")


def verify(lock, write):
    """Download the released AAR for each Maven-sourced lib and compare its arm64 .so with the APK's (sha256)."""
    import hashlib
    cache = {}
    for e in lock["libs"]:
        src = e.get("binary") or e["source"]
        if src.get("type") != "maven" or "<unknown>" in src["coordinate"]:
            continue
        g, a, v = src["coordinate"].split(":")
        url = f"{REPOS[src['repo']]}/{g.replace('.', '/')}/{a}/{v}/{a}-{v}{src.get('aar_suffix', '')}.aar"
        try:
            z = cache.get(url) or zipfile.ZipFile(io.BytesIO(get(url)))
            cache[url] = z
        except urllib.error.HTTPError as ex:
            print(f"{e['lib']:44} ?  cannot fetch {url} ({ex.code})")
            continue
        hit = [n for n in z.namelist() if n.endswith("arm64-v8a/" + e["lib"]) and n.startswith(("jni/", "lib/"))]
        if not hit:
            print(f"{e['lib']:44} -  not in {a}-{v}.aar")
            continue
        ok = hashlib.sha256(z.read(hit[0])).hexdigest() == e["sha256"]
        print(f"{e['lib']:44} {'IDENTICAL' if ok else 'DIFFERS  '} {src['coordinate']}")
        if write:
            e["binary_verified"] = ok
            e["verified_against"] = src["coordinate"] + (" (" + src["repo"] + ")")
            if ok and e["confidence"] == "inferred":
                e["confidence"] = "exact"
                e["evidence"].append("byte-identical (sha256) to the .so in " + e["verified_against"])
    if write:
        LOCK.write_text(json.dumps(lock, indent=2) + "\n")


def main():
    lock = json.loads(LOCK.read_text())
    libs = {e["lib"]: e for e in lock["libs"]}
    cmd = sys.argv[1] if len(sys.argv) > 1 else "list"
    if cmd == "list":
        for e in lock["libs"]:
            print(f"{e['lib']:46} {e['confidence']:10} {e['version']:34} {e['project']}")
        return
    if cmd == "verify":
        return verify(lock, "--write" in sys.argv)
    names = list(libs) if "--all" in sys.argv else [n if n.endswith(".so") else n + ".so" for n in sys.argv[2:]]
    done = set()
    for n in names:
        e = libs[n]
        key = json.dumps(e["source"], sort_keys=True)
        print(f"{n}: {e['project']} {e['version']}")
        if key in done:
            print("  (same source as an earlier lib)")
            continue
        done.add(key)
        fetch_source(e["source"], n)
        if "also" in e:
            fetch_source(e["also"], n)


main()
