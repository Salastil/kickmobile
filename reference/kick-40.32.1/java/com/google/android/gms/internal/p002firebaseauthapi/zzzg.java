package com.google.android.gms.internal.p002firebaseauthapi;

import expo.modules.crypto.aes.AesConfig;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzg implements zzbp, zzki {
    private static final zzjd.zza zza = zzjd.zza.zza;
    private static final byte[] zzb = new byte[16];
    private static final byte[] zzc = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private static final ThreadLocal<Cipher> zzd = new zzzf();
    private final zzsz zze;
    private final byte[] zzf;
    private final byte[] zzg;

    public static zzki zza(zzji zzjiVar) throws GeneralSecurityException {
        return new zzzg(zzjiVar.zzf().zza(zzbu.zza()), zzjiVar.zze());
    }

    private zzzg(byte[] bArr, zzaau zzaauVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (bArr.length != 32 && bArr.length != 64) {
            throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 32 or 64 bytes");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
        this.zzf = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
        this.zze = zzaak.zza(zzsx.zza(zzsw.zza(bArrCopyOfRange.length), zzaav.zza(bArrCopyOfRange, zzbu.zza())));
        this.zzg = zzaauVar.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbp
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[][] bArr3 = {bArr2};
        int length = bArr.length;
        byte[] bArr4 = this.zzg;
        if (length < bArr4.length + 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        if (!zzqu.zza(bArr4, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        Cipher cipher = zzd.get();
        byte[] bArr5 = this.zzg;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, bArr5.length, bArr5.length + 16);
        byte[] bArr6 = (byte[]) bArrCopyOfRange.clone();
        bArr6[8] = (byte) (bArr6[8] & 127);
        bArr6[12] = (byte) (bArr6[12] & 127);
        cipher.init(2, new SecretKeySpec(this.zzf, AesConfig.CRYPTO_KEY_ALGORITHM), new IvParameterSpec(bArr6));
        int length2 = this.zzg.length + 16;
        int length3 = bArr.length - length2;
        byte[] bArrDoFinal = cipher.doFinal(bArr, length2, length3);
        if (length3 == 0 && bArrDoFinal == null && zzaaq.zza()) {
            bArrDoFinal = new byte[0];
        }
        byte[][] bArr7 = (byte[][]) Arrays.copyOf(bArr3, 2);
        bArr7[1] = bArrDoFinal;
        if (MessageDigest.isEqual(bArrCopyOfRange, zza(bArr7))) {
            return bArrDoFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbp
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[][] bArr3 = {bArr2};
        if (bArr.length > 2147483631 - this.zzg.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipher = zzd.get();
        byte[][] bArr4 = (byte[][]) Arrays.copyOf(bArr3, 2);
        bArr4[1] = bArr;
        byte[] bArrZza = zza(bArr4);
        byte[] bArr5 = (byte[]) bArrZza.clone();
        bArr5[8] = (byte) (bArr5[8] & 127);
        bArr5[12] = (byte) (bArr5[12] & 127);
        cipher.init(1, new SecretKeySpec(this.zzf, AesConfig.CRYPTO_KEY_ALGORITHM), new IvParameterSpec(bArr5));
        byte[] bArr6 = this.zzg;
        byte[] bArrCopyOf = Arrays.copyOf(bArr6, bArr6.length + bArrZza.length + bArr.length);
        System.arraycopy(bArrZza, 0, bArrCopyOf, this.zzg.length, bArrZza.length);
        if (cipher.doFinal(bArr, 0, bArr.length, bArrCopyOf, this.zzg.length + bArrZza.length) == bArr.length) {
            return bArrCopyOf;
        }
        throw new GeneralSecurityException("not enough data written");
    }

    private final byte[] zza(byte[]... bArr) throws GeneralSecurityException {
        byte[] bArrZza;
        int length = bArr.length;
        zzsz zzszVar = this.zze;
        if (length == 0) {
            return zzszVar.zza(zzc, 16);
        }
        byte[] bArrZza2 = zzszVar.zza(zzb, 16);
        for (int i = 0; i < bArr.length - 1; i++) {
            byte[] bArr2 = bArr[i];
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            bArrZza2 = zzzi.zza(zzse.zzb(bArrZza2), this.zze.zza(bArr2, 16));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        if (bArr3.length >= 16) {
            if (bArr3.length < bArrZza2.length) {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            int length2 = bArr3.length - bArrZza2.length;
            bArrZza = Arrays.copyOf(bArr3, bArr3.length);
            for (int i2 = 0; i2 < bArrZza2.length; i2++) {
                int i3 = length2 + i2;
                bArrZza[i3] = (byte) (bArrZza[i3] ^ bArrZza2[i2]);
            }
        } else {
            bArrZza = zzzi.zza(zzse.zza(bArr3), zzse.zzb(bArrZza2));
        }
        return this.zze.zza(bArrZza, 16);
    }
}
