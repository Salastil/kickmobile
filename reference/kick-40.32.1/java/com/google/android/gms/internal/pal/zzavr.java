package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzavr {
    zzavr() {
    }

    public static final boolean zza(Object obj) {
        return !((zzavq) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzavq zzavqVarZzc = (zzavq) obj;
        zzavq zzavqVar = (zzavq) obj2;
        if (!zzavqVar.isEmpty()) {
            if (!zzavqVarZzc.zze()) {
                zzavqVarZzc = zzavqVarZzc.zzc();
            }
            zzavqVarZzc.zzb(zzavqVar);
        }
        return zzavqVarZzc;
    }
}
