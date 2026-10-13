package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzoo<P> extends zzol<P> implements zzcu<P> {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcu
    public final zzxg zzc(zzakb zzakbVar) throws GeneralSecurityException {
        Object objZza = zzpf.zza().zza(zzct.zza(this.zza, zzakbVar, zzqk.zza(this.zzb), zzqk.zza(zzyi.RAW), null), zzbu.zza());
        if (!(objZza instanceof zzcr)) {
            throw new GeneralSecurityException("Key not private key");
        }
        zzct zzctVarZza = zzpf.zza().zza(((zzcr) objZza).zzc(), zzbu.zza());
        return (zzxg) ((zzalt) zzxg.zza().zza(zzctVarZza.zze()).zza(zzctVarZza.zzc()).zza(zzqk.zza(zzctVarZza.zza())).zze());
    }

    zzoo(String str, Class<P> cls, zzani<? extends zzamv> zzaniVar) {
        super(str, cls, zzxg.zza.ASYMMETRIC_PRIVATE, zzaniVar);
    }
}
