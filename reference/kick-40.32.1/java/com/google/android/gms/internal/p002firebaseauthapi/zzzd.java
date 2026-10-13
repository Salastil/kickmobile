package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzd implements zzbm {
    private static final zzjd.zza zza = zzjd.zza.zzb;
    private final SecretKey zzb;
    private final byte[] zzc;

    public static zzbm zza(zzee zzeeVar) throws GeneralSecurityException {
        if (((zzel) ((zzdo) zzeeVar.zza())).zzb() != 12) {
            throw new GeneralSecurityException("Expected IV Size 12, got " + ((zzel) ((zzdo) zzeeVar.zza())).zzb());
        }
        if (((zzel) ((zzdo) zzeeVar.zza())).zzd() == 16) {
            return new zzzd(zzeeVar.zzf().zza(zzbu.zza()), zzeeVar.zzd());
        }
        throw new GeneralSecurityException("Expected tag Size 16, got " + ((zzel) ((zzdo) zzeeVar.zza())).zzd());
    }

    private zzzd(byte[] bArr, zzaau zzaauVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zzb = zzhb.zzb(bArr);
        this.zzc = zzaauVar.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        int length = bArr.length;
        byte[] bArr3 = this.zzc;
        if (length < bArr3.length + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzqu.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzhb.zza(bArr, this.zzc.length, 12);
        Cipher cipherZza = zzhb.zza();
        cipherZza.init(2, this.zzb, algorithmParameterSpecZza);
        if (bArr2 != null && bArr2.length != 0) {
            cipherZza.updateAAD(bArr2);
        }
        byte[] bArr4 = this.zzc;
        return cipherZza.doFinal(bArr, bArr4.length + 12, (bArr.length - bArr4.length) - 12);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] bArrZza = zzqm.zza(12);
        AlgorithmParameterSpec algorithmParameterSpecZza = zzhb.zza(bArrZza);
        Cipher cipherZza = zzhb.zza();
        cipherZza.init(1, this.zzb, algorithmParameterSpecZza);
        if (bArr2 != null && bArr2.length != 0) {
            cipherZza.updateAAD(bArr2);
        }
        int outputSize = cipherZza.getOutputSize(bArr.length);
        byte[] bArr3 = this.zzc;
        if (outputSize > 2147483635 - bArr3.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + outputSize);
        System.arraycopy(bArrZza, 0, bArrCopyOf, this.zzc.length, 12);
        if (cipherZza.doFinal(bArr, 0, bArr.length, bArrCopyOf, this.zzc.length + 12) == outputSize) {
            return bArrCopyOf;
        }
        throw new GeneralSecurityException("not enough data written");
    }
}
