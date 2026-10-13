package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzafk implements zzafz {
    private final int zza;

    zzafk(int i) throws InvalidAlgorithmParameterException {
        if (i == 16 || i == 32) {
            this.zza = i;
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 24);
        sb.append("Unsupported key length: ");
        sb.append(i);
        throw new InvalidAlgorithmParameterException(sb.toString());
    }

    @Override // com.google.android.gms.internal.pal.zzafz
    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        int length = bArr.length;
        if (length != this.zza) {
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 23);
            sb.append("Unexpected key length: ");
            sb.append(length);
            throw new InvalidAlgorithmParameterException(sb.toString());
        }
        if (!zzaco.zza(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        SecretKey secretKeyZzb = zzaat.zzb(bArr);
        if (bArr2.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        AlgorithmParameterSpec algorithmParameterSpecZzc = zzaat.zzc(bArr2, 0, 12);
        Cipher cipherZza = zzaat.zza();
        cipherZza.init(1, secretKeyZzb, algorithmParameterSpecZzc);
        int length2 = bArr3.length;
        int outputSize = cipherZza.getOutputSize(length2);
        if (outputSize > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr5 = new byte[i + outputSize];
        if (cipherZza.doFinal(bArr3, 0, length2, bArr5, i) == outputSize) {
            return bArr5;
        }
        throw new GeneralSecurityException("not enough data written");
    }

    @Override // com.google.android.gms.internal.pal.zzafz
    public final int zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzafz
    public final byte[] zzb() throws GeneralSecurityException {
        int i = this.zza;
        if (i == 16) {
            return zzagm.zzi;
        }
        if (i == 32) {
            return zzagm.zzj;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }
}
