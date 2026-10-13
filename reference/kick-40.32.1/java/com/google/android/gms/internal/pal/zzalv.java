package com.google.android.gms.internal.pal;

import expo.modules.crypto.aes.AesConfig;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzalv implements zzalr {
    private static final ThreadLocal zzd = new zzalu();
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    private zzalv(byte[] bArr) throws GeneralSecurityException {
        zzarn.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AesConfig.CRYPTO_KEY_ALGORITHM);
        this.zza = secretKeySpec;
        Cipher cipherZzc = zzc();
        cipherZzc.init(1, secretKeySpec);
        byte[] bArrZza = zzalf.zza(cipherZzc.doFinal(new byte[16]));
        this.zzb = bArrZza;
        this.zzc = zzalf.zza(bArrZza);
    }

    public static zzalr zzb(zzalp zzalpVar) throws GeneralSecurityException {
        return new zzalv(zzalpVar.zzd().zzb(zzvx.zza()));
    }

    private static Cipher zzc() throws GeneralSecurityException {
        if (zzaco.zza(1)) {
            return (Cipher) zzd.get();
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    private static void zzd(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        for (int i2 = 0; i2 < 16; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2 + i]);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzalr
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        SecretKey secretKey = this.zza;
        Cipher cipherZzc = zzc();
        cipherZzc.init(1, secretKey);
        int length = bArr.length;
        int i2 = length != 0 ? 1 + ((length - 1) >> 4) : 1;
        int i3 = i2 - 1;
        int i4 = i3 * 16;
        byte[] bArrZzb = i2 * 16 == length ? zzaqj.zzb(bArr, i4, this.zzb, 0, 16) : zzaqj.zzd(zzalf.zzb(Arrays.copyOfRange(bArr, i4, length)), this.zzc);
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[16];
        for (int i5 = 0; i5 < i3; i5++) {
            zzd(bArr2, bArr, i5 * 16, bArr3);
            if (cipherZzc.doFinal(bArr3, 0, 16, bArr2) != 16) {
                throw new IllegalStateException("Cipher didn't write full block");
            }
        }
        zzd(bArr2, bArrZzb, 0, bArr3);
        if (cipherZzc.doFinal(bArr3, 0, 16, bArr2) == 16) {
            return i == 16 ? bArr2 : Arrays.copyOf(bArr2, i);
        }
        throw new IllegalStateException("Cipher didn't write full block");
    }
}
