package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabu implements zzvr {
    private zzabu(zzvr zzvrVar, byte[] bArr) {
        int length = bArr.length;
        if (length != 0 && length != 5) {
            throw new IllegalArgumentException("identifier has an invalid length");
        }
    }

    public static zzvr zzb(zzaht zzahtVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzaje zzajeVarZzc = zzahtVar.zzc(zzvx.zza());
        zzvr zzvrVar = (zzvr) zzahj.zza().zzc(zzajeVarZzc.zze(), zzvr.class).zza(zzajeVarZzc.zza());
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
        return new zzabu(zzvrVar, bArrZzb);
    }

    public static zzvr zzc(zzvr zzvrVar, zzarq zzarqVar) {
        return new zzabu(zzvrVar, zzarqVar.zzb());
    }

    @Override // com.google.android.gms.internal.pal.zzvr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
