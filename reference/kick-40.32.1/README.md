# Kick 40.32.1 decompiled (com.kick.mobile, versionCode 60006965)

Source: XAPK from APKPure. Main APK SHA-256 `41b45d80108c01b4bf2ceafb07cfe916e20d7b929bf5fff1d3b3e21470c4d83d`.

- `java/` - jadx 1.5.6 output for all 11 dex files (native shell, SDKs, RN bridge modules).
  855 methods failed to decompile (jadx prints a note in those files).
- `resources/` - jadx-decoded resources: `AndroidManifest.xml`, `res/`, `assets/` (including the raw Hermes
  bundle `assets/index.android.bundle`, `app.config`, fonts, ML models).
- `hermes/` - `hermes-dec` 0.1.7 decompile of the Hermes v99 bundle, split into ~20 MB parts. Rejoin with
  `cat hermes/index.android.bundle.dec.part*.js > bundle.dec.js` (line numbers in the notes refer to the joined file).
  v99 is not formally supported by the tool; strings and call targets are reliable, control flow is approximate.
- `native/` - analysis of the two native libs that were not simply stock: `liba5c7.so` (disassembly) and `libappmodules.so` (symbol inventory). The `.so` binaries themselves are not committed; sha256 is in the lock file.

All app logic (chat, API clients) lives in the Hermes bundle. See `docs/reference/kick-mobile-chat.md`.

Native libraries: see `DEPENDENCIES.md` (what each is, exact pinned versions) and `native-deps.lock.json`. None are Kick-owned; Kick-owned code is `java/com/kick/**` plus the Hermes bundle. Disassembly of the one unidentified lib is in `native/liba5c7/`.
