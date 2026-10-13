package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaex {
    zzaex() {
    }

    public static final boolean zza(Object obj) {
        return !((zzaew) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzaew zzaewVarZzc = (zzaew) obj;
        zzaew zzaewVar = (zzaew) obj2;
        if (!zzaewVar.isEmpty()) {
            if (!zzaewVarZzc.zze()) {
                zzaewVarZzc = zzaewVarZzc.zzc();
            }
            zzaewVarZzc.zzb(zzaewVar);
        }
        return zzaewVarZzc;
    }
}
