package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzib {
    private static final zzjd.zza zza = zzjd.zza.zza;
    private final SecretKey zzb;
    private final Provider zzc;

    public static zzib zza(byte[] bArr) throws GeneralSecurityException {
        return new zzib(bArr, zzhp.zza().getProvider());
    }

    private zzib(byte[] bArr, Provider provider) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zzb = new SecretKeySpec(bArr, "ChaCha20");
        this.zzc = provider;
    }

    public static boolean zza() {
        return zzhp.zzb();
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) throws GeneralSecurityException {
        if (bArr2 == null) {
            throw new NullPointerException("ciphertext is null");
        }
        if (bArr.length != 12) {
            throw new GeneralSecurityException("nonce length must be 12 bytes.");
        }
        if (bArr2.length < i + 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher cipherZza = zzhp.zza(this.zzc);
        cipherZza.init(2, this.zzb, ivParameterSpec);
        if (bArr3 != null && bArr3.length != 0) {
            cipherZza.updateAAD(bArr3);
        }
        return cipherZza.doFinal(bArr2, i, bArr2.length - i);
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) throws GeneralSecurityException {
        if (bArr2 == null) {
            throw new NullPointerException("plaintext is null");
        }
        if (bArr.length != 12) {
            throw new GeneralSecurityException("nonce length must be 12 bytes.");
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher cipherZza = zzhp.zza(this.zzc);
        cipherZza.init(1, this.zzb, ivParameterSpec);
        if (bArr3 != null && bArr3.length != 0) {
            cipherZza.updateAAD(bArr3);
        }
        int outputSize = cipherZza.getOutputSize(bArr2.length);
        if (outputSize > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr4 = new byte[i + outputSize];
        if (cipherZza.doFinal(bArr2, 0, bArr2.length, bArr4, i) == outputSize) {
            return bArr4;
        }
        throw new GeneralSecurityException("not enough data written");
    }
}
