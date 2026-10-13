package com.google.android.gms.internal.p002firebaseauthapi;

import expo.modules.crypto.aes.AesConfig;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsh implements zzrd {
    private static final zzjd.zza zza = zzjd.zza.zza;

    public static zzrd zza(zzqt zzqtVar, Provider provider) throws GeneralSecurityException {
        return new zzsh(zzqtVar, provider);
    }

    private zzsh(zzqt zzqtVar, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            throw new IllegalArgumentException("conscrypt is null");
        }
        if (!zza.zza()) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        try {
            Mac.getInstance("AESCMAC", provider);
            zzqtVar.zze().zzb();
            new SecretKeySpec(zzqtVar.zzf().zza(zzbu.zza()), AesConfig.CRYPTO_KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new GeneralSecurityException("AES-CMAC not available.", e);
        }
    }
}
