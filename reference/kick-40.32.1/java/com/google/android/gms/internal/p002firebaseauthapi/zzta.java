package com.google.android.gms.internal.p002firebaseauthapi;

import expo.modules.crypto.aes.AesConfig;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzta implements zzsz {
    private static final zzjd.zza zza = zzjd.zza.zza;
    private static final ThreadLocal<Cipher> zzb = new zztd();
    private final SecretKey zzc;
    private byte[] zzd;
    private byte[] zze;

    public static zzsz zza(zzsx zzsxVar) throws GeneralSecurityException {
        return new zzta(zzsxVar.zzd().zza(zzbu.zza()));
    }

    private static Cipher zza() throws GeneralSecurityException {
        if (zza.zza()) {
            return zzb.get();
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    private zzta(byte[] bArr) throws GeneralSecurityException {
        zzaap.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AesConfig.CRYPTO_KEY_ALGORITHM);
        this.zzc = secretKeySpec;
        Cipher cipherZza = zza();
        cipherZza.init(1, secretKeySpec);
        byte[] bArrZzb = zzse.zzb(cipherZza.doFinal(new byte[16]));
        this.zzd = bArrZzb;
        this.zze = zzse.zzb(bArrZzb);
    }

    private static void zza(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        for (int i2 = 0; i2 < 16; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2 + i]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzsz
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArrZza;
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher cipherZza = zza();
        cipherZza.init(1, this.zzc);
        int length = bArr.length;
        int i2 = length == 0 ? 1 : ((length - 1) / 16) + 1;
        if ((i2 << 4) == bArr.length) {
            bArrZza = zzzi.zza(bArr, (i2 - 1) << 4, this.zzd, 0, 16);
        } else {
            bArrZza = zzzi.zza(zzse.zza(Arrays.copyOfRange(bArr, (i2 - 1) << 4, bArr.length)), this.zze);
        }
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[16];
        for (int i3 = 0; i3 < i2 - 1; i3++) {
            zza(bArr2, bArr, i3 << 4, bArr3);
            if (cipherZza.doFinal(bArr3, 0, 16, bArr2) != 16) {
                throw new IllegalStateException("Cipher didn't write full block");
            }
        }
        zza(bArr2, bArrZza, 0, bArr3);
        if (cipherZza.doFinal(bArr3, 0, 16, bArr2) == 16) {
            return 16 == i ? bArr2 : Arrays.copyOf(bArr2, i);
        }
        throw new IllegalStateException("Cipher didn't write full block");
    }
}
