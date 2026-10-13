package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabr {
    private final SecretKey zza;
    private final Provider zzb;

    private zzabr(byte[] bArr, Provider provider) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = new SecretKeySpec(bArr, "ChaCha20");
        this.zzb = provider;
    }

    public static zzabr zza(byte[] bArr) throws GeneralSecurityException {
        return new zzabr(bArr, zzabg.zzc().getProvider());
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) throws GeneralSecurityException {
        if (bArr2 == null) {
            throw new NullPointerException("plaintext is null");
        }
        if (bArr.length != 12) {
            throw new GeneralSecurityException("nonce length must be 12 bytes.");
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Provider provider = this.zzb;
        int i2 = zzabg.zza;
        SecretKey secretKey = this.zza;
        Cipher cipher = Cipher.getInstance("ChaCha20-Poly1305", provider);
        cipher.init(1, secretKey, ivParameterSpec);
        int length = bArr2.length;
        int outputSize = cipher.getOutputSize(length);
        if (outputSize > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr4 = new byte[i + outputSize];
        if (cipher.doFinal(bArr2, 0, length, bArr4, i) == outputSize) {
            return bArr4;
        }
        throw new GeneralSecurityException("not enough data written");
    }
}
