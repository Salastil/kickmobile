package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzagb implements zzvv {
    private zzagb(zzagg zzaggVar, zzage zzageVar, zzagd zzagdVar, zzafz zzafzVar, int i, zzarq zzarqVar) {
        zzarqVar.zzb();
    }

    public static zzvv zza(zzaek zzaekVar) throws GeneralSecurityException {
        int i;
        zzaej zzaejVarZze = zzaekVar.zze();
        zzage zzageVarZza = zzagh.zza(zzaejVarZze.zzc());
        zzagd zzagdVarZzb = zzagh.zzb(zzaejVarZze.zzd());
        zzafz zzafzVarZzc = zzagh.zzc(zzaejVarZze.zze());
        zzaeh zzaehVarZzc = zzaejVarZze.zzc();
        zzaeh zzaehVar = zzaeh.zzf;
        if (zzaehVarZzc.equals(zzaehVar)) {
            i = 32;
        } else if (zzaehVarZzc.equals(zzaeh.zza)) {
            i = 65;
        } else if (zzaehVarZzc.equals(zzaeh.zzb)) {
            i = 97;
        } else {
            if (!zzaehVarZzc.equals(zzaeh.zzc)) {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            i = 133;
        }
        int i2 = i;
        zzaeh zzaehVarZzc2 = zzaekVar.zze().zzc();
        if (zzaehVarZzc2.equals(zzaehVar) || zzaehVarZzc2.equals(zzaeh.zza) || zzaehVarZzc2.equals(zzaeh.zzb) || zzaehVarZzc2.equals(zzaeh.zzc)) {
            return new zzagb(new zzagg(zzarq.zza(zzaekVar.zzd().zzb(zzvx.zza())), zzaekVar.zzf().zzd()), zzageVarZza, zzagdVarZzb, zzafzVarZzc, i2, zzaekVar.zzf().zzg());
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }
}
