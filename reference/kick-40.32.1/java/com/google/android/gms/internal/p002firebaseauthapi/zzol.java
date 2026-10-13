package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzol<P> implements zzbw<P> {
    final String zza;
    final zzxg.zza zzb;
    private final Class<P> zzc;

    public static <P> zzbw<P> zza(String str, Class<P> cls, zzxg.zza zzaVar, zzani<? extends zzamv> zzaniVar) {
        return new zzol(str, cls, zzaVar, zzaniVar);
    }

    public static <P> zzcu<P> zza(String str, Class<P> cls, zzani<? extends zzamv> zzaniVar) {
        return new zzoo(str, cls, zzaniVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbw
    public final zzxg zza(zzakb zzakbVar) throws GeneralSecurityException {
        zzct zzctVarZza = zzpf.zza().zza(zzoy.zza().zza(zzpf.zza().zza(zzcx.zza(this.zza, zzcv.zzd, zzakbVar)), (Integer) null), zzbu.zza());
        return (zzxg) ((zzalt) zzxg.zza().zza(zzctVarZza.zze()).zza(zzctVarZza.zzc()).zza(zzqk.zza(zzctVarZza.zza())).zze());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbw
    public final Class<P> zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbw
    public final P zzb(zzakb zzakbVar) throws GeneralSecurityException {
        return (P) zzpg.zza().zza(zzpf.zza().zza(zzct.zza(this.zza, zzakbVar, zzqk.zza(this.zzb), zzqk.zza(zzyi.RAW), null), zzbu.zza()), this.zzc);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbw
    public final String zzb() {
        return this.zza;
    }

    zzol(String str, Class<P> cls, zzxg.zza zzaVar, zzani<? extends zzamv> zzaniVar) {
        this.zza = str;
        this.zzc = cls;
        this.zzb = zzaVar;
    }
}
