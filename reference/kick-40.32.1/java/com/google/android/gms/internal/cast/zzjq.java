package com.google.android.gms.internal.cast;

import android.os.Build;
import dalvik.system.VMStack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjq extends zzjm {
    private static final boolean zza = zza.zza();
    private static final boolean zzb;
    private static final zzjl zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
    final class zza {
        zza() {
        }

        static boolean zza() {
            return zzjq.zzp();
        }
    }

    static {
        boolean z = true;
        if (Build.FINGERPRINT != null && !"robolectric".equals(Build.FINGERPRINT)) {
            z = false;
        }
        zzb = z;
        zzc = new zzjl() { // from class: com.google.android.gms.internal.cast.zzjq.1
            @Override // com.google.android.gms.internal.cast.zzjl
            public String zza(Class cls) {
                StackTraceElement stackTraceElementZza;
                if (zzjq.zza) {
                    try {
                        if (cls.equals(zzjq.zzr())) {
                            return VMStack.getStackClass2().getName();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!zzjq.zzb || (stackTraceElementZza = zzkl.zza(cls, 1)) == null) {
                    return null;
                }
                return stackTraceElementZza.getClassName();
            }

            @Override // com.google.android.gms.internal.cast.zzjl
            public zzis zzb(Class<?> cls, int i) {
                return zzis.zza;
            }
        };
    }

    static boolean zzp() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", null);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> zzr() {
        return VMStack.getStackClass2();
    }

    @Override // com.google.android.gms.internal.cast.zzjm
    protected zzjl zzc() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzjm
    protected zzix zze(String str) {
        return zzju.zzb(str);
    }

    @Override // com.google.android.gms.internal.cast.zzjm
    protected zzjz zzg() {
        return zzjv.zza();
    }

    @Override // com.google.android.gms.internal.cast.zzjm
    protected String zzn() {
        return "platform: Android";
    }
}
