package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabg implements zzvr {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = zzarg.zzb("808182838485868788898a8b8c8d8e8f909192939495969798999a9b9c9d9e9f");
    private static final byte[] zzc = zzarg.zzb("070000004041424344454647");
    private static final byte[] zzd = zzarg.zzb("a0784d7a4716f3feb4f64e7f4b39bf04");

    private zzabg(byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        new SecretKeySpec(bArr, "ChaCha20");
    }

    public static zzvr zzb(zzyg zzygVar) throws GeneralSecurityException {
        return new zzabg(zzygVar.zze().zzb(zzvx.zza()), zzygVar.zzc().zzb(), zzc().getProvider());
    }

    static Cipher zzc() throws GeneralSecurityException {
        Cipher cipher = (Cipher) zzaqx.zza.zzb("ChaCha20-Poly1305");
        if (zze(cipher)) {
            return cipher;
        }
        throw new GeneralSecurityException("JCE does not support algorithm: ChaCha20-Poly1305");
    }

    public static boolean zzd() {
        try {
            zzc();
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    private static boolean zze(Cipher cipher) {
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

    @Override // com.google.android.gms.internal.pal.zzvr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
