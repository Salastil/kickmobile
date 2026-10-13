package com.google.android.gms.internal.pal;

import android.os.Build;
import dalvik.system.VMStack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrx extends zzrr {
    private static final boolean zza = zza.zza();
    private static final boolean zzb;
    private static final zzrq zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
    final class zza {
        zza() {
        }

        static boolean zza() {
            return zzrx.zzp();
        }
    }

    static {
        boolean z = true;
        if (Build.FINGERPRINT != null && !"robolectric".equals(Build.FINGERPRINT)) {
            z = false;
        }
        zzb = z;
        zzc = new zzrq() { // from class: com.google.android.gms.internal.pal.zzrx.1
            @Override // com.google.android.gms.internal.pal.zzrq
            public String zza(Class<? extends zzow<?>> cls) {
                StackTraceElement stackTraceElementZza;
                if (zzrx.zza) {
                    try {
                        if (cls.equals(zzrx.zzr())) {
                            return VMStack.getStackClass2().getName();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!zzrx.zzb || (stackTraceElementZza = zzte.zza(cls, 1)) == null) {
                    return null;
                }
                return stackTraceElementZza.getClassName();
            }

            @Override // com.google.android.gms.internal.pal.zzrq
            public zzpq zzb(Class<?> cls, int i) {
                return zzpq.zza;
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

    @Override // com.google.android.gms.internal.pal.zzrr
    protected zzrq zzc() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzrr
    protected zzqt zze(String str) {
        return zzsc.zze(str);
    }

    @Override // com.google.android.gms.internal.pal.zzrr
    protected zzsh zzg() {
        return zzsd.zza();
    }

    @Override // com.google.android.gms.internal.pal.zzrr
    protected String zzn() {
        return "platform: Android";
    }
}
