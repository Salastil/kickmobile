# liba5c7.so (arm64-v8a, 1,243,904 bytes) - unidentified, obfuscated

SHA-256 `see ../../native-deps.lock.json`. Nothing in the dex, resources or Hermes bundle references the name `a5c7`,
so the loader is unknown (it may be loaded by a protection SDK with an encrypted/computed name).

What the binary shows (no source available, not Kick's code as far as the strings tell):
- Exports only `JNI_OnLoad`, `__emutls_get_address`, `__emutls_register_common` (see `dynamic-symbols.txt`).
- Imports process/anti-debug/anti-tamper primitives: `fork`, `execv`, `waitpid`, `prctl`, `sigaction`, `sigsetjmp`,
  `dlopen/dlsym/dladdr`, `mprotect`, `__system_property_*`, `opendir/readdir`, `syscall`, `kill/killpg`. Typical of a
  runtime-protection / device-integrity / root-and-hook detection library.
- Code is obfuscated: constant-XOR opaque predicates and flattened control flow. radare2 recovers only 180 functions;
  `liba5c7.pseudo-c.txt` (radare2 `pdc`) is a rough pseudo-C of those 180 and should not be trusted for logic.

Files
- `liba5c7.disasm.txt`   full `llvm-objdump -d` AArch64 disassembly (the complete record; ~8.7 MB)
- `liba5c7.pseudo-c.txt` radare2 `pdc` pseudo-C for the 180 recovered functions (unreliable)
- `liba5c7.functions.txt` radare2 function list (`afl`)
- `dynamic-symbols.txt`, `readelf-dynamic.txt` ELF metadata
