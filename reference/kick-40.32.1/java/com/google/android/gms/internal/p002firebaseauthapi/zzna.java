package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzna {
    public static zzbr zza(zzch zzchVar, zzqh<zzbr> zzqhVar) throws GeneralSecurityException {
        if (!zzqu.zza(zzchVar)) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        zzoq zzoqVar = (zzoq) zzchVar.zza(zzoq.class);
        zzot zzotVarZza = (zzoqVar == null || zzoqVar.zza()) ? zzow.zza : zzpc.zzb().zza().zza(zzchVar, zzoqVar, "hybrid_encrypt", "encrypt");
        zzck zzckVarZzc = zzchVar.zzc();
        return new zznc(new zzmz(zzqhVar.zza(zzckVarZzc), zzckVarZzc.zza()), zzotVarZza);
    }
}
