package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzafn implements zzafp {
    private final int zza;

    public zzafn(zzxw zzxwVar) throws GeneralSecurityException {
        if (zzxwVar.zzd() != zzxv.zzc) {
            throw new GeneralSecurityException("invalid variant");
        }
        this.zza = zzxwVar.zzc();
    }

    @Override // com.google.android.gms.internal.pal.zzafp
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzafp
    public final byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != this.zza) {
            throw new GeneralSecurityException("invalid key size");
        }
        SecretKey secretKeyZzb = zzaat.zzb(bArr);
        byte[] bArrZza = zzajh.zza(12);
        AlgorithmParameterSpec algorithmParameterSpecZzc = zzaat.zzc(bArrZza, 0, bArrZza.length);
        Cipher cipherZza = zzaat.zza();
        cipherZza.init(1, secretKeyZzb, algorithmParameterSpecZzc);
        int length = bArr4.length;
        int outputSize = cipherZza.getOutputSize(length);
        int length2 = bArr2.length;
        int length3 = bArr3.length;
        int i = length2 + length3;
        if (outputSize > 2147483635 - i) {
            throw new GeneralSecurityException("plaintext too long");
        }
        int i2 = i + 12;
        byte[] bArrCopyOf = Arrays.copyOf(bArr2, i2 + outputSize);
        System.arraycopy(bArr3, 0, bArrCopyOf, length2, length3);
        System.arraycopy(bArrZza, 0, bArrCopyOf, i, 12);
        if (cipherZza.doFinal(bArr4, 0, length, bArrCopyOf, i2) == outputSize) {
            return bArrCopyOf;
        }
        throw new GeneralSecurityException("not enough data written");
    }
}
