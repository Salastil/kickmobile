package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzls implements zzlu {
    private final int zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlu
    public final int zza() {
        return this.zza;
    }

    zzls(zzel zzelVar) throws GeneralSecurityException {
        if (zzelVar.zzb() != 12) {
            throw new GeneralSecurityException("invalid IV size");
        }
        if (zzelVar.zzd() != 16) {
            throw new GeneralSecurityException("invalid tag size");
        }
        if (zzelVar.zzf() != zzel.zzb.zzc) {
            throw new GeneralSecurityException("invalid variant");
        }
        this.zza = zzelVar.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlu
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (bArr.length != this.zza) {
            throw new GeneralSecurityException("invalid key size");
        }
        SecretKey secretKeyZzb = zzhb.zzb(bArr);
        int i2 = i + 12;
        if (bArr2.length < i + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzhb.zza(bArr2, i, 12);
        Cipher cipherZza = zzhb.zza();
        cipherZza.init(2, secretKeyZzb, algorithmParameterSpecZza);
        return cipherZza.doFinal(bArr2, i2, (bArr2.length - i) - 12);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlu
    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != this.zza) {
            throw new GeneralSecurityException("invalid key size");
        }
        SecretKey secretKeyZzb = zzhb.zzb(bArr);
        byte[] bArrZza = zzqm.zza(12);
        AlgorithmParameterSpec algorithmParameterSpecZza = zzhb.zza(bArrZza);
        Cipher cipherZza = zzhb.zza();
        cipherZza.init(1, secretKeyZzb, algorithmParameterSpecZza);
        int outputSize = cipherZza.getOutputSize(bArr4.length);
        int length = bArr2.length + bArr3.length;
        if (outputSize > 2147483635 - length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        int i = length + 12;
        byte[] bArrCopyOf = Arrays.copyOf(bArr2, i + outputSize);
        System.arraycopy(bArr3, 0, bArrCopyOf, bArr2.length, bArr3.length);
        System.arraycopy(bArrZza, 0, bArrCopyOf, length, 12);
        if (cipherZza.doFinal(bArr4, 0, bArr4.length, bArrCopyOf, i) == outputSize) {
            return bArrCopyOf;
        }
        throw new GeneralSecurityException("not enough data written");
    }
}
