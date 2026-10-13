# Native libraries: what they are and the exact versions pinned

Machine-readable source of truth: [`native-deps.lock.json`](native-deps.lock.json) (read that, not this table, when scripting).
App: `com.kick.mobile` 40.32.1 (Expo SDK 58, React Native 0.88.0-rc.3, Hermes bytecode v99).

## Is any of the native code Kick's?

**No.** All 40 `.so` files in `config.arm64_v8a.apk` are third-party or generated framework glue, except `liba5c7.so`, whose owner is unknown.
- `libappmodules.so` looked like Kick's code at first; it is React Native codegen for third-party packages (see `native/libappmodules/`).
- `liba5c7.so` is an obfuscated protection-style library; disassembled in `native/liba5c7/`. Nothing in it names Kick.
- No library contains the string "kick".

Kick's own code that talks to native/platform APIs is **Kotlin/Java in Expo modules, already decompiled in `java/com/kick/`**:
`kickivsplayerv2` (Amazon IVS player wrapper, Mux + Datazoom analytics, Google PAL), `centrifugo` (`Kickcentrifugo` module: a Centrifugo
realtime client with `connectionUrl`/`connectionAuthUrl`/`channelAuthUrl`, join/leave/publication events), `kickappupdates`,
`airplayplayer`, `misclib`, `MainActivity`, `MainApplication`. Everything else (chat, API, UI) is in the Hermes JS bundle (`hermes/`).

## How to read this table

Confidence values: **exact** = version read from the APK itself and/or the shipped `.so` is byte-identical (sha256) to that published release
(`binary-verified`); **inferred** = taken from the framework pin the app was built with; **range** = Expo SDK 58 bundled range (true patch not
recoverable from the APK); **unresolved** = unknown. 22 of 40 libraries are binary-verified.

## Pins

| Library | What | Version | Confidence | Upstream |
|---|---|---|---|---|
| `libreactnative.so` | React Native | `0.88.0-rc.3` | exact + binary-verified | npm `react-native@0.88.0-rc.3` |
| `libbarhopper_v3.so` | Google ML Kit barcode scanning (bundled model) | `17.3.0` | exact + binary-verified | Maven `com.google.mlkit:barcode-scanning:17.3.0` (google) |
| `libplayercore.so` | Amazon IVS Player (Android) | `1.54.1` | exact + binary-verified | Maven `com.amazonaws:ivs-player:1.54.1` (central) |
| `libhermesvm.so` | Hermes JS engine | `260318099.0.4 (ships with RN 0.88.0-rc.3)` | exact + binary-verified | Maven `com.facebook.hermes:hermes-android:260318099.0.4` (rn) |
| `libappmodules.so` | RN app codegen aggregate (autolinked modules' TurboModule/Fabric glue) | `0.88.0-rc.3 codegen output` | exact | - |
| `libreanimated.so` | react-native-reanimated | `4.7.0` | exact | npm `react-native-reanimated@4.7.0` |
| `libexpo-modules-core.so` | expo-modules-core (core) | `58.0.14` | exact | npm `expo-modules-core@58.0.14` |
| `libc++_shared.so` | LLVM libc++ from Android NDK | `NDK 27.1.12297006` | exact + binary-verified | Maven `com.facebook.fbjni:fbjni:0.7.0` (central) |
| `libworklets.so` | react-native-worklets | `0.13.0` | exact | npm `react-native-worklets@0.13.0` |
| `liba5c7.so` | UNIDENTIFIED (protected/obfuscated native library) | `UNRESOLVED` | unresolved | - |
| `libreact_codegen_rnscreens.so` | react-native-screens codegen | `~4.29.0` | range | npm `react-native-screens@4.29.0` |
| `libcrashlytics-common.so` | Firebase Crashlytics NDK | `20.1.0` | exact + binary-verified | Maven `com.google.firebase:firebase-crashlytics-ndk:20.1.0` (google) |
| `libreact_codegen_rnsvg.so` | react-native-svg codegen | `15.15.5` | range | npm `react-native-svg@15.15.5` |
| `libexpo-kolibri.so` | expo-modules-core (kolibri JSI object layer) | `58.0.14` | exact | npm `expo-modules-core@58.0.14` |
| `libzstd-kmp.so` | zstd-kmp (Zstandard JNI binding, Square) | `0.4.0` | exact + binary-verified | Maven `com.squareup.zstd:zstd-kmp-android:0.4.0` (central) |
| `libnative-imagetranscoder.so` | Fresco (native image transcoder) | `3.7.0` | exact + binary-verified | Maven `com.facebook.fresco:nativeimagetranscoder:3.7.0` (central) |
| `libstatic-webp.so` | Fresco (static WebP) | `3.7.0` | exact + binary-verified | Maven `com.facebook.fresco:webpsupport:3.7.0` (central) |
| `libjsi.so` | React Native | `0.88.0-rc.3` | exact + binary-verified | npm `react-native@0.88.0-rc.3` |
| `libreact_codegen_rngesturehandler_codegen.so` | react-native-gesture-handler codegen | `~3.2.1` | range | npm `react-native-gesture-handler@3.2.1` |
| `libgifimage.so` | Fresco (GIF) | `3.7.0` | exact + binary-verified | Maven `com.facebook.fresco:animated-gif:3.7.0` (central) |
| `libnative-filters.so` | Fresco (native filters) | `3.7.0` | exact + binary-verified | Maven `com.facebook.fresco:nativeimagefilters:3.7.0` (central) |
| `libdatadog-ndk.so` | Datadog Android SDK NDK crash reporting | `3.13.1` | exact + binary-verified | Maven `com.datadoghq:dd-sdk-android-ndk:3.13.1` (central) |
| `libcrashlytics.so` | Firebase Crashlytics NDK | `20.1.0` | exact + binary-verified | Maven `com.google.firebase:firebase-crashlytics-ndk:20.1.0` (google) |
| `libcrashlytics-handler.so` | Firebase Crashlytics NDK | `20.1.0` | exact + binary-verified | Maven `com.google.firebase:firebase-crashlytics-ndk:20.1.0` (google) |
| `libfbjni.so` | fbjni | `0.7.0` | exact + binary-verified | Maven `com.facebook.fbjni:fbjni:0.7.0` (central) |
| `libreact_codegen_safeareacontext.so` | react-native-safe-area-context codegen | `~5.9.1` | range | npm `react-native-safe-area-context@5.9.1` |
| `libreact_codegen_RNKC.so` | react-native-keyboard-controller codegen | `1.22.4` | range | npm `react-native-keyboard-controller@1.22.4` |
| `libhermestooling.so` | Hermes JS engine | `260318099.0.4 (ships with RN 0.88.0-rc.3)` | exact + binary-verified | Maven `com.facebook.react:react-android:0.88.0-rc.3` (rn) |
| `libexpo-modules-worklets.so` | expo-modules-core (worklets adapter, built by the same package) | `58.0.14` | exact | npm `expo-modules-core@58.0.14` |
| `librnscreens.so` | react-native-screens | `~4.29.0` | range | npm `react-native-screens@4.29.0` |
| `libexpo-updates.so` | expo-updates | `~58.0.16` | range | npm `expo-updates@58.0.16` |
| `libgesturehandler.so` | react-native-gesture-handler | `~3.2.1` | range | npm `react-native-gesture-handler@3.2.1` |
| `libexpo-modules-jsi.so` | expo-modules-core (modules JSI) | `58.0.14` | exact | npm `expo-modules-core@58.0.14` |
| `libfp.so` | FingerprintJS Pro Android SDK (device fingerprinting) | `2.11.0` | inferred | - |
| `libimage_processing_util_jni.so` | AndroidX CameraX camera-core | `1.6.0` | exact + binary-verified | Maven `androidx.camera:camera-core:1.6.0` (google) |
| `libandroidx.graphics.path.so` | AndroidX graphics-path | `1.0.1` | exact + binary-verified | Maven `androidx.graphics:graphics-path:1.0.1` (google) |
| `libimagepipeline.so` | Fresco (image pipeline) | `3.7.0` | exact + binary-verified | Maven `com.facebook.fresco:imagepipeline-native:3.7.0` (central) |
| `libdatastore_shared_counter.so` | AndroidX DataStore | `1.1.7` | exact + binary-verified | Maven `androidx.datastore:datastore-core-android:1.1.7` (google) |
| `libsurface_util_jni.so` | AndroidX CameraX camera-core | `1.6.0` | exact + binary-verified | Maven `androidx.camera:camera-core:1.6.0` (google) |
| `libcrashlytics-trampoline.so` | Firebase Crashlytics NDK | `20.1.0` | exact | Maven `com.google.firebase:firebase-crashlytics-ndk:20.1.0` (google) |

## Using the pins when researching how the app works

1. **Do not reverse a third-party `.so`.** Read the upstream source at the pinned version:
   `python3 scripts/fetch_upstream.py fetch libreanimated libplayercore ...` (or `--all`) downloads into `vendor/upstream/` (gitignored).
2. Re-check the pins any time: `python3 scripts/fetch_upstream.py verify` downloads the released AARs and compares sha256 with the APK's libraries.
3. Closed-source pins (IVS player, ML Kit barcode, Crashlytics, FingerprintJS): only the binary AAR exists; use the Java API surface in `java/`.
4. `range` entries are real packages whose patch version is unknown. The fetcher picks the highest patch in that minor; treat details as approximate and
   confirm against `java/`/`hermes/` behavior.
5. `libhermesvm.so` is Hermes `260318099.0.4`, which is why bytecode is v99 (the bundle decompile in `hermes/` is approximate for that reason).

## Still open
- Exact patch versions for the 8 `range` libraries (6 packages: react-native-screens, -gesture-handler, -svg, -safe-area-context, -keyboard-controller, expo-updates).
- `libfp.so` is `inferred` (2.11.0 from a string constant; closed source, Maven coordinate not verified).
- Who loads `liba5c7.so`, and what it is. `libcrashlytics-trampoline.so` is the only Maven-sourced lib that did not match any Crashlytics NDK 20.x byte-for-byte (version still 20.1.0 by BuildConfig).
