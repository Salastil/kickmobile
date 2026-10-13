package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzagu implements zzage {
    private final zzafy zza;
    private final zzagr zzb;

    zzagu(zzafy zzafyVar) {
        zzagr zzagtVar;
        this.zza = zzafyVar;
        try {
            zzagtVar = zzags.zzc();
        } catch (GeneralSecurityException unused) {
            zzagtVar = new zzagt(null);
        }
        this.zzb = zzagtVar;
    }

    @Override // com.google.android.gms.internal.pal.zzage
    public final zzagf zza(byte[] bArr) throws GeneralSecurityException {
        zzagr zzagrVar = this.zzb;
        zzagq zzagqVarZza = zzagrVar.zza();
        byte[] bArr2 = zzagqVarZza.zza;
        byte[] bArr3 = zzagqVarZza.zzb;
        byte[] bArrZzb = zzagrVar.zzb(bArr2, bArr);
        byte[] bArrZza = zzaqj.zza(bArr3, bArr);
        byte[] bArrZzb2 = zzagm.zzb(zzagm.zzb);
        zzafy zzafyVar = this.zza;
        return new zzagf(zzafyVar.zzc(null, bArrZzb, "eae_prk", bArrZza, "shared_secret", bArrZzb2, zzafyVar.zze()), bArr3);
    }

    @Override // com.google.android.gms.internal.pal.zzage
    public final byte[] zzb() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzd(), zzagm.zzf)) {
            return zzagm.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
