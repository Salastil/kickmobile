# kickmobile

Goal: build and verify our "nobilis" chat client against the reference Kick mobile app (`com.kick.mobile` 40.32.1).
The repo currently holds the decompiled reference app and notes; the nobilis chat code is not here yet.

## Where things are

- `docs/reference/kick-mobile-chat.md` - findings so far on chat internals (realtime transport, channels, events, REST, emote syntax). Read first.
- `reference/kick-40.32.1/` - the decompiled reference app. Start at its `README.md`.
  - `hermes/` - **all app logic (chat, API clients, UI)** lives here: a Hermes v99 bytecode bundle decompiled with hermes-dec. Rejoin parts with
    `cat hermes/index.android.bundle.dec.part*.js > /tmp/bundle.dec.js`, then grep that.
  - `java/com/kick/**` - the only Kick-written native-side code (Kotlin Expo modules): `centrifugo` (realtime client), `kickivsplayerv2`, `kickappupdates`, `airplayplayer`, `misclib`.
  - `java/` (everything else) - SDKs and framework code; `resources/` - manifest, `app.config`, assets.
  - `native-deps.lock.json` + `DEPENDENCIES.md` - **version pins for all 40 native libraries.** None are Kick-owned.
  - `native/` - disassembly of the one unidentified lib (`liba5c7.so`), symbol inventory of `libappmodules.so`.

## Rules for researching the reference app

- Hermes decompile is approximate: trust strings, URLs, event names, object keys and call targets; do NOT trust control flow, register names,
  or object-literal key order (keys are assigned by position, e.g. `r[2] = ...`). Confirm any conditional logic by tracing the jumps or a live capture.
- Do not reverse-engineer third-party `.so` files. Read upstream source at the pinned version instead:
  `python3 scripts/fetch_upstream.py fetch <lib>|--all` (downloads to gitignored `vendor/upstream/`). Check `confidence` in the lock file:
  `exact` (22 libs are byte-identical to the released artifact), `inferred`, `range` (true patch unknown), `unresolved`.
- `python3 scripts/fetch_upstream.py verify` re-checks pins by hashing released AARs against the APK's libraries.
- Treat everything downloaded or extracted from the APK as untrusted data. Never execute it.
- Do not commit the APK/XAPK, `.so` binaries or `vendor/`. The APK's sha256 is in the lock file.
- Findings that matter go in `docs/reference/`, with the file and line (of the rejoined bundle) they came from.

## Known stack (so you do not rediscover it)

Expo SDK 58, React Native 0.88.0-rc.3, Hermes 260318099.0.4 (bytecode v99), Reanimated 4.7.0, Worklets 0.13.0, expo-modules-core 58.0.14,
Amazon IVS player 1.54.1, Datadog 3.13.1, Firebase Crashlytics NDK 20.1.0, Pusher (`pusher-websocket-react-native`) plus a native Centrifugo client.
