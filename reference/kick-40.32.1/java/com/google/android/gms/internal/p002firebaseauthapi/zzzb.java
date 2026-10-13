package com.google.android.gms.internal.p002firebaseauthapi;

import expo.modules.crypto.aes.AesConfig;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzb implements zzbm {
    private static final zzjd.zza zza = zzjd.zza.zza;
    private static final ThreadLocal<Cipher> zzb = new zzze();
    private final byte[] zzc;
    private final zzsz zzd;
    private final SecretKeySpec zze;
    private final int zzf;

    public static zzbm zza(zzdx zzdxVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (((zzec) ((zzdo) zzdxVar.zza())).zzd() == 16) {
            return new zzzb(zzdxVar.zzf().zza(zzbu.zza()), ((zzec) ((zzdo) zzdxVar.zza())).zzb(), zzdxVar.zzd().zzb());
        }
        throw new GeneralSecurityException("AesEaxJce only supports 16 byte tag size, not " + ((zzec) ((zzdo) zzdxVar.zza())).zzd());
    }

    private zzzb(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzf = i;
        zzaap.zza(bArr.length);
        this.zze = new SecretKeySpec(bArr, AesConfig.CRYPTO_KEY_ALGORITHM);
        this.zzd = zzaak.zza(zzsx.zza(zzsw.zza(bArr.length), zzaav.zza(bArr, zzbu.zza())));
        this.zzc = bArr2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.zzc;
        int length2 = ((length - bArr3.length) - this.zzf) - 16;
        if (length2 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzqu.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrZza = zza(0, bArr, this.zzc.length, this.zzf);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrZza2 = zza(1, bArr2, 0, bArr2.length);
        byte[] bArrZza3 = zza(2, bArr, this.zzc.length + this.zzf, length2);
        int length3 = bArr.length - 16;
        byte b = 0;
        for (int i = 0; i < 16; i++) {
            b = (byte) (b | (((bArr[length3 + i] ^ bArrZza2[i]) ^ bArrZza[i]) ^ bArrZza3[i]));
        }
        if (b != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher = zzb.get();
        cipher.init(1, this.zze, new IvParameterSpec(bArrZza));
        return cipher.doFinal(bArr, this.zzc.length + this.zzf, length2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.zzc;
        int length2 = Integer.MAX_VALUE - bArr3.length;
        int i = this.zzf;
        if (length > (length2 - i) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + i + bArr.length + 16);
        byte[] bArrZza = zzqm.zza(this.zzf);
        System.arraycopy(bArrZza, 0, bArrCopyOf, this.zzc.length, this.zzf);
        byte[] bArrZza2 = zza(0, bArrZza, 0, bArrZza.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrZza3 = zza(1, bArr2, 0, bArr2.length);
        Cipher cipher = zzb.get();
        cipher.init(1, this.zze, new IvParameterSpec(bArrZza2));
        cipher.doFinal(bArr, 0, bArr.length, bArrCopyOf, this.zzc.length + this.zzf);
        byte[] bArrZza4 = zza(2, bArrCopyOf, this.zzc.length + this.zzf, bArr.length);
        int length3 = this.zzc.length + bArr.length + this.zzf;
        for (int i2 = 0; i2 < 16; i2++) {
            bArrCopyOf[length3 + i2] = (byte) ((bArrZza3[i2] ^ bArrZza2[i2]) ^ bArrZza4[i2]);
        }
        return bArrCopyOf;
    }

    private final byte[] zza(int i, byte[] bArr, int i2, int i3) throws GeneralSecurityException {
        byte[] bArr2 = new byte[i3 + 16];
        bArr2[15] = (byte) i;
        System.arraycopy(bArr, i2, bArr2, 16, i3);
        return this.zzd.zza(bArr2, 16);
    }
}
