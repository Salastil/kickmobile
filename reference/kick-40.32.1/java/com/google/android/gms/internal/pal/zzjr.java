package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.soloader.MinElf;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjr {
    public static boolean zza(int i) {
        int i2 = i - 1;
        return i2 == 2 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x0113  */
    /* JADX WARN: Code duplicated, block: B:76:0x0116 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x0118 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x011a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x011c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0120  */
    /* JADX WARN: Code duplicated, block: B:82:0x0123  */
    /* JADX WARN: Code duplicated, block: B:83:0x0126  */
    /* JADX WARN: Code duplicated, block: B:84:0x0129  */
    /* JADX WARN: Code duplicated, block: B:85:0x012c  */
    /* JADX WARN: Code duplicated, block: B:86:0x012f  */
    /* JADX WARN: Code duplicated, block: B:87:0x0132  */
    public static final int zzb(Context context, zzjc zzjcVar) {
        int i;
        String str;
        String strZzd;
        File file = new File(new File(context.getApplicationInfo().dataDir), "lib");
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles(new zztq(Pattern.compile(".*\\.so$", 2)));
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                zzjcVar.zze(5017, "No .so");
            } else {
                try {
                    FileInputStream fileInputStream = new FileInputStream(fileArrListFiles[0]);
                    try {
                        byte[] bArr = new byte[20];
                        if (fileInputStream.read(bArr) == 20) {
                            byte[] bArr2 = {0, 0};
                            if (bArr[5] == 2) {
                                zzc(bArr, null, context, zzjcVar);
                            } else {
                                bArr2[0] = bArr[19];
                                bArr2[1] = bArr[18];
                                short s = ByteBuffer.wrap(bArr2).getShort();
                                if (s == 3) {
                                    i = 5;
                                } else if (s == 40) {
                                    i = 3;
                                } else if (s == 62) {
                                    i = 7;
                                } else if (s == 183) {
                                    i = 6;
                                } else if (s != 243) {
                                    zzc(bArr, null, context, zzjcVar);
                                    i = 1;
                                } else {
                                    i = 8;
                                }
                                fileInputStream.close();
                            }
                        }
                        fileInputStream.close();
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    zzc(null, e.toString(), context, zzjcVar);
                }
                i = 1;
            }
            if (i == 1000) {
                strZzd = zzd(context, zzjcVar);
                if (TextUtils.isEmpty(strZzd)) {
                    zzc(null, "Empty dev arch", context, zzjcVar);
                } else if (!strZzd.equalsIgnoreCase("i686") || strZzd.equalsIgnoreCase(MinElf.ISA.X86)) {
                    i = 5;
                } else if (strZzd.equalsIgnoreCase(MinElf.ISA.X86_64)) {
                    i = 7;
                } else if (strZzd.equalsIgnoreCase(MinElf.ISA.AARCH64)) {
                    i = 6;
                } else if (strZzd.equalsIgnoreCase(MinElf.ISA.ARM) || strZzd.equalsIgnoreCase("armv71")) {
                    i = 3;
                } else if (strZzd.equalsIgnoreCase("riscv64")) {
                    i = 8;
                } else {
                    zzc(null, strZzd, context, zzjcVar);
                }
                i = 1;
            }
            if (i != 1) {
                str = "UNSUPPORTED";
            } else if (i != 3) {
                str = "ARM7";
            } else if (i != 5) {
                str = "X86";
            } else if (i != 6) {
                str = "ARM64";
            } else if (i != 7) {
                str = "X86_64";
            } else if (i != 8) {
                str = AbstractJsonLexerKt.NULL;
            } else {
                str = "RISCV64";
            }
            zzjcVar.zze(5018, str);
            return i;
        }
        zzjcVar.zze(5017, "No lib/");
        i = 1000;
        if (i == 1000) {
            strZzd = zzd(context, zzjcVar);
            if (TextUtils.isEmpty(strZzd)) {
                zzc(null, "Empty dev arch", context, zzjcVar);
            } else if (strZzd.equalsIgnoreCase("i686")) {
                i = 5;
            } else {
                i = 5;
            }
            i = 1;
        }
        if (i != 1) {
            str = "UNSUPPORTED";
        } else if (i != 3) {
            str = "ARM7";
        } else if (i != 5) {
            str = "X86";
        } else if (i != 6) {
            str = "ARM64";
        } else if (i != 7) {
            str = "X86_64";
        } else if (i != 8) {
            str = AbstractJsonLexerKt.NULL;
        } else {
            str = "RISCV64";
        }
        zzjcVar.zze(5018, str);
        return i;
    }

    private static final void zzc(byte[] bArr, String str, Context context, zzjc zzjcVar) {
        StringBuilder sb = new StringBuilder("os.arch:");
        sb.append(zzmc.OS_ARCH.zza());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        zzjcVar.zze(4007, sb.toString());
    }

    private static final String zzd(Context context, zzjc zzjcVar) {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String strZza = zzmc.OS_ARCH.zza();
        if (!TextUtils.isEmpty(strZza) && hashSet.contains(strZza)) {
            return strZza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (IllegalAccessException e) {
            zzjcVar.zzc(2024, 0L, e);
        } catch (NoSuchFieldException e2) {
            zzjcVar.zzc(2024, 0L, e2);
        }
        return Build.CPU_ABI != null ? Build.CPU_ABI : Build.CPU_ABI2;
    }
}
