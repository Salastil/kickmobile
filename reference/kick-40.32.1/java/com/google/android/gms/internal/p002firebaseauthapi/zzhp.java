package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhp implements zzbm {
    private static final zzjd.zza zza = zzjd.zza.zza;
    private static final byte[] zzb = zzaaf.zza("808182838485868788898a8b8c8d8e8f909192939495969798999a9b9c9d9e9f");
    private static final byte[] zzc = zzaaf.zza("070000004041424344454647");
    private static final byte[] zzd = zzaaf.zza("a0784d7a4716f3feb4f64e7f4b39bf04");
    private final SecretKey zze;
    private final byte[] zzf;
    private final Provider zzg;

    public static zzbm zza(zzeu zzeuVar) throws GeneralSecurityException {
        return new zzhp(zzeuVar.zze().zza(zzbu.zza()), zzeuVar.zzd().zzb(), zza().getProvider());
    }

    static Cipher zza(Provider provider) throws GeneralSecurityException {
        return Cipher.getInstance("ChaCha20-Poly1305", provider);
    }

    static Cipher zza() throws GeneralSecurityException {
        Cipher cipherZza = zzzr.zza.zza("ChaCha20-Poly1305");
        if (zza(cipherZza)) {
            return cipherZza;
        }
        throw new GeneralSecurityException("JCE does not support algorithm: ChaCha20-Poly1305");
    }

    private zzhp(byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zze = new SecretKeySpec(bArr, "ChaCha20");
        this.zzf = bArr2;
        this.zzg = provider;
    }

    public static boolean zzb() {
        try {
            zza();
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    private static boolean zza(Cipher cipher) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(zzc);
            byte[] bArr = zzb;
            cipher.init(2, new SecretKeySpec(bArr, "ChaCha20"), ivParameterSpec);
            byte[] bArr2 = zzd;
            if (cipher.doFinal(bArr2).length != 0) {
                return false;
            }
            cipher.init(2, new SecretKeySpec(bArr, "ChaCha20"), ivParameterSpec);
            return cipher.doFinal(bArr2).length == 0;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        int length = bArr.length;
        byte[] bArr3 = this.zzf;
        if (length < bArr3.length + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzqu.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = new byte[12];
        System.arraycopy(bArr, this.zzf.length, bArr4, 0, 12);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        Cipher cipher = Cipher.getInstance("ChaCha20-Poly1305", this.zzg);
        cipher.init(2, this.zze, ivParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipher.updateAAD(bArr2);
        }
        byte[] bArr5 = this.zzf;
        return cipher.doFinal(bArr, bArr5.length + 12, (bArr.length - bArr5.length) - 12);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] bArrZza = zzqm.zza(12);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArrZza);
        Cipher cipher = Cipher.getInstance("ChaCha20-Poly1305", this.zzg);
        cipher.init(1, this.zze, ivParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipher.updateAAD(bArr2);
        }
        int outputSize = cipher.getOutputSize(bArr.length);
        byte[] bArr3 = this.zzf;
        if (outputSize > 2147483635 - bArr3.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + outputSize);
        System.arraycopy(bArrZza, 0, bArrCopyOf, this.zzf.length, 12);
        if (cipher.doFinal(bArr, 0, bArr.length, bArrCopyOf, this.zzf.length + 12) == outputSize) {
            return bArrCopyOf;
        }
        throw new GeneralSecurityException("not enough data written");
    }
}
