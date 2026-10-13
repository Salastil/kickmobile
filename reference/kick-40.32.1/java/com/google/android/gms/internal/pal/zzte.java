package com.google.android.gms.internal.pal;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzte {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzti zzb;

    static {
        zzti zztjVar;
        for (int i = 0; i < 2; i++) {
            zztjVar = null;
            try {
                zztjVar = (zzti) Class.forName(zza[i]).asSubclass(zzti.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (zztjVar != null) {
                zzb = zztjVar;
            }
        }
        zztjVar = new zztj();
        zzb = zztjVar;
    }

    public static StackTraceElement zza(Class cls, int i) {
        zztf.zza(cls, TypedValues.Attributes.S_TARGET);
        return zzb.zza(cls, 2);
    }

    public static StackTraceElement[] zzb(Class cls, int i, int i2) {
        if (i > 0 || i == -1) {
            return zzb.zzb(cls, i, 2);
        }
        throw new IllegalArgumentException("invalid maximum depth: 0");
    }
}
