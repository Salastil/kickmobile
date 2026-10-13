package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzalo implements zzwj {
    private zzalo(zzwj zzwjVar, zzapm zzapmVar, byte[] bArr) {
    }

    public static zzwj zzb(zzaht zzahtVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzaje zzajeVarZzc = zzahtVar.zzc(zzvx.zza());
        zzwj zzwjVar = (zzwj) zzahj.zza().zzc(zzajeVarZzc.zze(), zzwj.class).zza(zzajeVarZzc.zza());
        zzapm zzapmVarZzb = zzajeVarZzc.zzb();
        int iOrdinal = zzapmVarZzb.ordinal();
        if (iOrdinal == 1) {
            bArrZzb = zzaim.zzb(zzahtVar.zzb().intValue()).zzb();
        } else if (iOrdinal == 2) {
            bArrZzb = zzaim.zza(zzahtVar.zzb().intValue()).zzb();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrZzb = zzaim.zza(zzahtVar.zzb().intValue()).zzb();
        } else {
            bArrZzb = zzaim.zza.zzb();
        }
        return new zzalo(zzwjVar, zzapmVarZzb, bArrZzb);
    }

    @Override // com.google.android.gms.internal.pal.zzwj
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        throw null;
    }
}
