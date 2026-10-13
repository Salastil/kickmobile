package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaml {
    private final zzamw zza;

    public final <T> zzanl<T> zza(Class<T> cls) {
        zzano.zza((Class<?>) cls);
        zzamt zzamtVarZza = this.zza.zza(cls);
        if (zzamtVarZza.zzc()) {
            return zzanb.zza(zzano.zza(), zzalj.zza(), zzamtVarZza.zza());
        }
        return zzamz.zza(cls, zzamtVarZza, zzanf.zza(), zzamj.zza(), zzano.zza(), zzamo.zza[zzamtVarZza.zzb().ordinal()] != 1 ? zzalj.zza() : null, zzamu.zza());
    }

    public zzaml() {
        this(zzalr.zza());
    }

    private zzaml(zzamw zzamwVar) {
        this.zza = (zzamw) zzalw.zza(zzamwVar, "messageInfoFactory");
    }
}
