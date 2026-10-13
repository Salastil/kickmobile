# Native code NOT decompiled (Kick 40.32.1, arm64-v8a)

These 40 shared libraries ship in `config.arm64_v8a.apk` inside the XAPK. None were disassembled or
decompiled, and the `.so` files are not in this repo. The main APK has no native libraries. No other split
APK has any (the other 17 `config.*.apk` splits are language and screen-density resources).

Descriptions are inferred from library names and strings inside each file (not from disassembly).
"Kick app" marks code most likely written by Kick; everything else looks like a third-party library.

| Library | Size (bytes) | What it is | Origin | SHA-256 |
|---|---:|---|---|---|
| `libreactnative.so` | 7049088 | React Native core (Fabric/TurboModules, JSI glue) | third-party | `0a108cd36ab33974758ff4a1391cb278ceb8e1ed3710abb0a873271120fff52b` |
| `libbarhopper_v3.so` | 4946720 | Google ML Kit barcode scanning engine | third-party | `ec09597e9eb3aee0eb55ae3366da0d4ba416f5aa35a1af0b3811f50ff46743a1` |
| `libplayercore.so` | 3648752 | Amazon IVS player core (its JNI refs are com.amazonaws.ivs.player.*): live-stream video playback | third-party | `cdfc5ed12aed8f42c86a677d5e2daa87233cd8362184c3f696a15646f2c00ef8` |
| `libhermesvm.so` | 2704136 | Hermes JS engine that runs the bundle | third-party | `d4ccaf2523cd3b938e295646a5bcf927e134cbd6e4c4f9e3a6fd26d8d85e8217` |
| `libappmodules.so` | 2253672 | RN app-module registration (JNI_OnLoad); the app's own native/codegen glue. Highest-value one to inspect | Kick app (likely) | `eaacc6a45401c5d71e2449934f3178fe264543ebe619ca623b50878c8355e0cc` |
| `libreanimated.so` | 1654112 | react-native-reanimated | third-party | `d93293352691ff5ba6924bc293eb9189991b6a442ab2c1c798d6c58032a15633` |
| `libexpo-modules-core.so` | 1585512 | Expo modules core | third-party | `0d529465383c74f45fdeb9623f53e21ab841e481bfd1e4295ff504eaf69d8920` |
| `libc++_shared.so` | 1292904 | C++ standard library | third-party | `3e852764502d06e0cf1080d532ae7c608b7649d946a3a9d7e84e3d4b7d683214` |
| `libworklets.so` | 1288288 | react-native-worklets | third-party | `d63b30e8326e3209a312c0799896097853b0e1177f3ecdae97748a7af169037b` |
| `liba5c7.so` | 1243904 | Unidentified. Only JNI_OnLoad is visible in strings; name looks randomized/obfuscated | unknown | `3f049b7114f35ccb583b379c5ba5bce82a5c3d4c9bc721b04a11293e86781621` |
| `libreact_codegen_rnscreens.so` | 1214176 | react-native-screens codegen | third-party | `6f98dba5cdba81fcdab4e83a516c6ae903e84431fbff07c503e9eded5a917902` |
| `libcrashlytics-common.so` | 864616 | Firebase Crashlytics | third-party | `2f759a20ed003c50ff4120f7ca3ee56e603bfba6f656fdb617136561bc409ef7` |
| `libreact_codegen_rnsvg.so` | 768600 | react-native-svg codegen | third-party | `9f9dc39de2cb25da6769265c2067c13971b7ed71592f32a74f2bb1384e9b3998` |
| `libexpo-kolibri.so` | 759120 | Expo modules (kolibri) JSI object layer | third-party | `0e166adbc093a4ce9e307f8aeedc4decef65b70d27fad946ae5d1b437b43a446` |
| `libzstd-kmp.so` | 731872 | Zstandard compression (Kotlin Multiplatform binding) | third-party | `10ec47f13bee884450b0911066019ba7aa6b4164a4c1f8c33c9d30dd3fd8868a` |
| `libnative-imagetranscoder.so` | 585376 | Fresco image transcoder | third-party | `2aed28298a25afd52ac670cf9682398c6c7ba42a57195c01efd565e7ddfe17ca` |
| `libstatic-webp.so` | 502112 | Fresco WebP decoder | third-party | `bfce3139342fad716d25623b559d9901fc795d6b7622ebe21a417b4c84e3a92a` |
| `libjsi.so` | 412696 | JavaScript Interface (JSI) | third-party | `5fdfbabeee20b300fc084bc9bddfa55b7a3e46dafc1464a4309cf0c906f6b0eb` |
| `libreact_codegen_rngesturehandler_codegen.so` | 362288 | react-native-gesture-handler codegen | third-party | `8ed6f375389ee09edcd02bfb4f302a27dc7cb806e1c4bc6760e10b33e88e9d7b` |
| `libgifimage.so` | 319088 | Fresco GIF decoder | third-party | `cfbb51d1fe58ba985ad1f06d4ac0afa70e5323d25517642881f4833d7020e44f` |
| `libnative-filters.so` | 277744 | Fresco native image filters | third-party | `bb82aec5ab2a8ac4e1968f41c6477824f1f3fff90c0eeb2c90cdeb1923d69833` |
| `libdatadog-ndk.so` | 238504 | Datadog NDK crash reporting | third-party | `7229bbe64f40f33f8d12e583595486eaec7e9b32f241c92c36f4b12df5b60f62` |
| `libcrashlytics.so` | 231960 | Firebase Crashlytics | third-party | `d1f4639c66971f821e356e629fcedbba4ad1395ab0e38d0ca3b5070e7283feb7` |
| `libcrashlytics-handler.so` | 222056 | Firebase Crashlytics | third-party | `064bb16f99de2ea43e9c4f5dc3e94f411b96fbed709149b266479774da7f3f7c` |
| `libfbjni.so` | 177000 | Meta fbjni (JNI helpers) | third-party | `a9e35ba55d3f956920281f519385f8a72475ee24819799cb08375fdd4cce2b22` |
| `libreact_codegen_safeareacontext.so` | 154256 | react-native-safe-area-context codegen | third-party | `83bcc3083640fc061eb86cb691bf65eac3e08081067efdee66fe1afce6f5a269` |
| `libreact_codegen_RNKC.so` | 147976 | react-native-keyboard-controller codegen | third-party | `6830fb6286532734fa7f63d843364d07d81e87bda86b00ed95bcaf4e9920fe7f` |
| `libhermestooling.so` | 141216 | Hermes tooling/debug support | third-party | `52607cec46d60dbd4d46f41dc9870c55a87051b6d412f02ff71242d97fc45ec6` |
| `libexpo-modules-worklets.so` | 115912 | Expo worklets integration | third-party | `27538fb50228b57f487eaeab9215124adb8e1ce5863db471a2e8073e5245ac82` |
| `librnscreens.so` | 103928 | react-native-screens | third-party | `2e5c463e34a2bf2bb26e502e0c9a03466c7d21c9c72fe6dae5e522e888ba7841` |
| `libexpo-updates.so` | 101912 | Expo Updates (OTA updates) | third-party | `982edd6ad5c745e0d2a02d8b37d9b426a9cc585b11519bc7ae208062ee94137a` |
| `libgesturehandler.so` | 92000 | react-native-gesture-handler | third-party | `f22be1f9b406da8bb44afefc6d24d500bd38b5910434b0a25079ceab76792b24` |
| `libexpo-modules-jsi.so` | 90520 | Expo modules JSI | third-party | `c4169c47bd7e3e78adbeaf7b68d914a61fb7e2fc4f2a86fd4322e1a944187ca0` |
| `libfp.so` | 36416 | FingerprintJS Pro device fingerprinting (JNI refs are com.fingerprintjs.*) | third-party | `45ad9b24dda17327a301d6c16443c5b9d1b838f89cd888af73b43247af3fe78a` |
| `libimage_processing_util_jni.so` | 32528 | AndroidX CameraX image processing | third-party | `0292b063fafccf734472cbb59588e756c2dbca907c72021ba6fbf126385508a2` |
| `libandroidx.graphics.path.so` | 10096 | AndroidX graphics path | third-party | `41e9a793c43a0f4fddb19e33f346bace464f30f888ba7b9eaf96294ea115bfb6` |
| `libimagepipeline.so` | 8760 | Fresco image pipeline | third-party | `1b377992e4256fa9398ec057722f84a359c7d588e570c8a41f51d930c19ece7d` |
| `libdatastore_shared_counter.so` | 7112 | AndroidX DataStore | third-party | `d3e48717c9aa147e0ab21063ba0e8e0211cabf8bf40b222640829519edbf58e1` |
| `libsurface_util_jni.so` | 4896 | AndroidX CameraX surface util | third-party | `a5c9d1928ea92ec7a94dff8cf666e7739cd734198b9f0ae1d4e28ea3c86516ba` |
| `libcrashlytics-trampoline.so` | 4744 | Firebase Crashlytics | third-party | `908e549f7a9b02f71ea0a4bcb77dfbf8dbc1123378da8fc384582fc7608159be` |

## Priority if we go further

1. `libappmodules.so` - Kick's own native module glue.
2. `liba5c7.so` - unidentified; worth a look since the name is randomized.
3. Everything else is a stock library. Compare against the upstream version rather than reversing.

The chat logic itself is in the Hermes JS bundle (see `hermes/`), not in native code.
