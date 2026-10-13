package com.google.android.gms.internal.cast;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkl {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzkp zzb;

    static {
        zzkp zzkqVar;
        for (int i = 0; i < 2; i++) {
            zzkqVar = null;
            try {
                zzkqVar = (zzkp) Class.forName(zza[i]).asSubclass(zzkp.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (zzkqVar != null) {
                zzb = zzkqVar;
            }
        }
        zzkqVar = new zzkq();
        zzb = zzkqVar;
    }

    public static StackTraceElement zza(Class cls, int i) {
        zzkm.zza(cls, TypedValues.Attributes.S_TARGET);
        return zzb.zza(cls, 2);
    }
}
