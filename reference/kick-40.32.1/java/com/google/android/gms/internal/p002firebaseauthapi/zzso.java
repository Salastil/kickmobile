package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzso {
    public static zzrd zza(zzch zzchVar, zzqh<zzrd> zzqhVar) throws GeneralSecurityException {
        zzaau zzaauVarZzd;
        if (!zzqu.zza(zzchVar)) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        zzck zzckVarZzc = zzchVar.zzc();
        zzpw zzpwVar = new zzpw();
        for (int i = 0; i < zzchVar.zza(); i++) {
            zzck zzckVarZza = zzchVar.zza(i);
            if (zzckVarZza.zzc().equals(zzbv.zza)) {
                zzrd zzrdVarZza = zzqhVar.zza(zzckVarZza);
                zzbt zzbtVarZzb = zzckVarZza.zzb();
                if (zzbtVarZzb instanceof zzrp) {
                    zzaauVarZzd = ((zzrp) zzbtVarZzb).zze();
                } else {
                    if (!(zzbtVarZzb instanceof zzon)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzbtVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzbtVarZzb.zza()));
                    }
                    zzaauVarZzd = ((zzon) zzbtVarZzb).zzd();
                }
                zzpwVar.zza(zzaauVarZzd, zzrdVarZza);
            }
        }
        return new zzsr(zzpwVar.zza(), zzqhVar.zza(zzckVarZzc));
    }
}
