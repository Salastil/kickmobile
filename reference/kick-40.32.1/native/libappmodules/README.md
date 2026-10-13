# libappmodules.so - NOT Kick-owned

This is React Native's generated "app modules" library: codegen TurboModule/Fabric glue for the autolinked npm
packages (react-native-svg, -screens, -webview, -gesture-handler, -reanimated, -worklets, async-storage,
@react-native-firebase/*, google-signin, @datadog/mobile-react-native, react-native-share, get-random-values).
No Kick-specific symbols or strings exist in it. It was built against `react-android-0.88.0-rc.3`.

- `defined-symbols.demangled.txt`  the 4,425 symbols it defines (demangled), the useful index of what is inside
- `imported-symbols.demangled.txt` what it imports

It was not disassembled: it is generated boilerplate, and the packages above are pinned in `../../native-deps.lock.json`
so you can read the real upstream source with `python3 scripts/fetch_upstream.py fetch --all`.
