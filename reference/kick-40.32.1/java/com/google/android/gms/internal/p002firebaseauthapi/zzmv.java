package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzmv {
    public static zzbs zza(zzch zzchVar, zzqh<zzbs> zzqhVar) throws GeneralSecurityException {
        zzaau zzaauVarZzd;
        if (!zzqu.zza(zzchVar)) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        zzpw zzpwVar = new zzpw();
        for (int i = 0; i < zzchVar.zza(); i++) {
            zzck zzckVarZza = zzchVar.zza(i);
            if (zzckVarZza.zzc().equals(zzbv.zza)) {
                zzbs zzbsVarZza = zzqhVar.zza(zzckVarZza);
                zzbt zzbtVarZzb = zzckVarZza.zzb();
                if (zzbtVarZzb instanceof zzlm) {
                    zzaauVarZzd = ((zzlm) zzbtVarZzb).zzh();
                } else {
                    if (!(zzbtVarZzb instanceof zzon)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzbtVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzbtVarZzb.zza()));
                    }
                    zzaauVarZzd = ((zzon) zzbtVarZzb).zzd();
                }
                zzpwVar.zza(zzaauVarZzd, new zzmy(zzbsVarZza, zzckVarZza.zza()));
            }
        }
        zzoq zzoqVar = (zzoq) zzchVar.zza(zzoq.class);
        return new zzmx(zzpwVar.zza(), (zzoqVar == null || zzoqVar.zza()) ? zzow.zza : zzpc.zzb().zza().zza(zzchVar, zzoqVar, "hybrid_decrypt", "decrypt"));
    }
}
