package com.google.android.gms.internal.pal;

import expo.modules.crypto.aes.AesConfig;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaqa implements zzarh {
    private static final ThreadLocal zza = new zzapz();
    private final SecretKeySpec zzb;
    private final int zzc;
    private final int zzd;

    public zzaqa(byte[] bArr, int i) throws GeneralSecurityException {
        if (!zzaco.zza(2)) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzarn.zza(bArr.length);
        this.zzb = new SecretKeySpec(bArr, AesConfig.CRYPTO_KEY_ALGORITHM);
        int blockSize = ((Cipher) zza.get()).getBlockSize();
        this.zzd = blockSize;
        if (i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.pal.zzarh
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int i = this.zzc;
        int length = bArr.length;
        int i2 = Integer.MAX_VALUE - i;
        if (length > i2) {
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 32);
            sb.append("plaintext length can not exceed ");
            sb.append(i2);
            throw new GeneralSecurityException(sb.toString());
        }
        byte[] bArr2 = new byte[i + length];
        byte[] bArrZza = zzajh.zza(i);
        System.arraycopy(bArrZza, 0, bArr2, 0, i);
        Cipher cipher = (Cipher) zza.get();
        byte[] bArr3 = new byte[this.zzd];
        System.arraycopy(bArrZza, 0, bArr3, 0, i);
        cipher.init(1, this.zzb, new IvParameterSpec(bArr3));
        if (cipher.doFinal(bArr, 0, length, bArr2, i) == length) {
            return bArr2;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
