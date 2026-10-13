package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzado implements zzvu {
    private zzado(zzvu zzvuVar, zzapm zzapmVar, byte[] bArr) {
    }

    public static zzvu zzb(zzaht zzahtVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzaje zzajeVarZzc = zzahtVar.zzc(zzvx.zza());
        zzvu zzvuVar = (zzvu) zzahj.zza().zzc(zzajeVarZzc.zze(), zzvu.class).zza(zzajeVarZzc.zza());
        zzapm zzapmVarZzb = zzajeVarZzc.zzb();
        int iOrdinal = zzapmVarZzb.ordinal();
        if (iOrdinal == 1) {
            bArrZzb = zzaim.zzb(zzahtVar.zzb().intValue()).zzb();
        } else if (iOrdinal == 2) {
            bArrZzb = zzaim.zza(zzahtVar.zzb().intValue()).zzb();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                int iZza = zzapmVarZzb.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 27);
                sb.append("unknown output prefix type ");
                sb.append(iZza);
                throw new GeneralSecurityException(sb.toString());
            }
            bArrZzb = zzaim.zza(zzahtVar.zzb().intValue()).zzb();
        } else {
            bArrZzb = zzaim.zza.zzb();
        }
        return new zzado(zzvuVar, zzapmVarZzb, bArrZzb);
    }

    @Override // com.google.android.gms.internal.pal.zzvu
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
