package com.google.android.gms.internal.pal;

import expo.modules.crypto.aes.AesConfig;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaba implements zzvr {
    private static final byte[] zza = zzarg.zzb("7a806c");
    private static final byte[] zzb = zzarg.zzb("46bb91c3c5");
    private static final byte[] zzc = zzarg.zzb("36864200e0eaf5284d884a0e77d31646");
    private static final byte[] zzd = zzarg.zzb("bae8e37fc83441b16034566b");
    private static final byte[] zze = zzarg.zzb("af60eb711bd85bc1e4d3e0a462e074eea428a8");

    private zzaba(byte[] bArr, byte[] bArr2, zzaaz zzaazVar) throws GeneralSecurityException {
        zzarn.zza(bArr.length);
        new SecretKeySpec(bArr, AesConfig.CRYPTO_KEY_ALGORITHM);
    }

    public static boolean zzb(Cipher cipher) {
        try {
            byte[] bArr = zzd;
            cipher.init(2, new SecretKeySpec(zzc, AesConfig.CRYPTO_KEY_ALGORITHM), new GCMParameterSpec(128, bArr, 0, bArr.length));
            cipher.updateAAD(zzb);
            byte[] bArr2 = zze;
            return MessageDigest.isEqual(cipher.doFinal(bArr2, 0, bArr2.length), zza);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public static zzvr zzc(zzxy zzxyVar, zzaaz zzaazVar) throws GeneralSecurityException {
        if (zzb((Cipher) zzaazVar.zza())) {
            return new zzaba(zzxyVar.zze().zzb(zzvx.zza()), zzxyVar.zzc().zzb(), zzaazVar);
        }
        throw new IllegalStateException("Cipher does not implement AES GCM SIV.");
    }

    @Override // com.google.android.gms.internal.pal.zzvr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
