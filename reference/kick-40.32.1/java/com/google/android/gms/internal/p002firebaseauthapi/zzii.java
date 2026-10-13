package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzii {
    public static zzbm zza(zzch zzchVar, zzqh<zzbm> zzqhVar) throws GeneralSecurityException {
        zzot zzotVarZza;
        zzot zzotVarZza2;
        zzaau zzaauVarZzd;
        if (!zzqu.zza(zzchVar)) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        zzpw zzpwVar = new zzpw();
        for (int i = 0; i < zzchVar.zza(); i++) {
            zzck zzckVarZza = zzchVar.zza(i);
            if (zzckVarZza.zzc().equals(zzbv.zza)) {
                zzbt zzbtVarZzb = zzckVarZza.zzb();
                if (zzbtVarZzb instanceof zzdm) {
                    zzaauVarZzd = ((zzdm) zzbtVarZzb).zzd();
                } else {
                    if (!(zzbtVarZzb instanceof zzon)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzbtVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzbtVarZzb.zza()));
                    }
                    zzaauVarZzd = ((zzon) zzbtVarZzb).zzd();
                }
                zzpwVar.zza(zzaauVarZzd, new zzih(zzqhVar.zza(zzckVarZza), zzckVarZza.zza()));
            }
        }
        zzoq zzoqVar = (zzoq) zzchVar.zza(zzoq.class);
        if (zzoqVar == null || zzoqVar.zza()) {
            zzotVarZza = zzow.zza;
            zzotVarZza2 = zzow.zza;
        } else {
            zzou zzouVarZza = zzpc.zzb().zza();
            zzotVarZza = zzouVarZza.zza(zzchVar, zzoqVar, "aead", "encrypt");
            zzotVarZza2 = zzouVarZza.zza(zzchVar, zzoqVar, "aead", "decrypt");
        }
        return new zzik(new zzih(zzqhVar.zza(zzchVar.zzc()), zzchVar.zzc().zza()), zzpwVar.zza(), zzotVarZza, zzotVarZza2);
    }
}
