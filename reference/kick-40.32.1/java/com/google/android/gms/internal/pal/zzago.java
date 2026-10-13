package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzago implements zzvw {
    private final zzvw zza;
    private final byte[] zzb;

    private zzago(zzvw zzvwVar, byte[] bArr) {
        this.zza = zzvwVar;
        this.zzb = bArr;
    }

    public static zzvw zzb(zzaht zzahtVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzaje zzajeVarZzc = zzahtVar.zzc(zzvx.zza());
        zzvw zzvwVar = (zzvw) zzahj.zza().zzc(zzajeVarZzc.zze(), zzvw.class).zza(zzajeVarZzc.zza());
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
        return new zzago(zzvwVar, bArrZzb);
    }

    @Override // com.google.android.gms.internal.pal.zzvw
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr3.length;
        zzvw zzvwVar = this.zza;
        return length == 0 ? zzvwVar.zza(bArr, bArr2) : zzaqj.zza(bArr3, zzvwVar.zza(bArr, bArr2));
    }
}
