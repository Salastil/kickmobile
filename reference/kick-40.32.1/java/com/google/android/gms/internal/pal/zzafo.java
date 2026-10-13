package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzafo implements zzafp {
    private final zzacz zza;
    private final int zzb;

    public zzafo(zzacz zzaczVar) {
        this.zza = zzaczVar;
        this.zzb = zzaczVar.zzc();
    }

    @Override // com.google.android.gms.internal.pal.zzafp
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzafp
    public final byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        zzacr zzacrVarZzc = zzacs.zzc();
        zzacrVarZzc.zza(this.zza);
        zzacrVarZzc.zzb(zzars.zza(bArr, zzvx.zza()));
        return zzaqj.zza(bArr2, bArr3, zzaqf.zzb(zzacrVarZzc.zzd()).zza(bArr4, zzafq.zza));
    }
}
