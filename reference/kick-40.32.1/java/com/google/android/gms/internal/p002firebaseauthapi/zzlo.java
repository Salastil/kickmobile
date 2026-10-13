package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzlo implements zzmf {
    private final int zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final int zzb() {
        return 12;
    }

    zzlo(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException("Unsupported key length: " + i);
        }
        this.zza = i;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zzc() throws GeneralSecurityException {
        int i = this.zza;
        if (i == 16) {
            return zzms.zzi;
        }
        if (i == 32) {
            return zzms.zzj;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != this.zza) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: " + bArr.length);
        }
        return new zzhy(bArr).zza(bArr2, bArr3, i, bArr4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != this.zza) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: " + bArr.length);
        }
        return new zzhy(bArr).zzb(bArr2, bArr3, i, bArr4);
    }
}
