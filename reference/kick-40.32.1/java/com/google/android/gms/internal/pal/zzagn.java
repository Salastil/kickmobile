package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzagn implements zzvv {
    private zzagn(zzvv zzvvVar, byte[] bArr) {
    }

    public static zzvv zza(zzaht zzahtVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzaje zzajeVarZzc = zzahtVar.zzc(zzvx.zza());
        zzvv zzvvVar = (zzvv) zzahj.zza().zzc(zzajeVarZzc.zze(), zzvv.class).zza(zzajeVarZzc.zza());
        zzapm zzapmVarZzb = zzajeVarZzc.zzb();
        int iOrdinal = zzapmVarZzb.ordinal();
        if (iOrdinal == 1) {
            bArrZzb = zzaim.zzb(zzahtVar.zzb().intValue()).zzb();
        } else if (iOrdinal == 2) {
            bArrZzb = zzaim.zza(zzahtVar.zzb().intValue()).zzb();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                String strValueOf = String.valueOf(zzapmVarZzb);
                String.valueOf(strValueOf);
                throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(strValueOf)));
            }
            bArrZzb = zzaim.zza(zzahtVar.zzb().intValue()).zzb();
        } else {
            bArrZzb = zzaim.zza.zzb();
        }
        return new zzagn(zzvvVar, bArrZzb);
    }
}
