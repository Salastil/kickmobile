package com.google.android.gms.internal.pal;

import expo.modules.crypto.aes.AesConfig;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzalg implements zzajz {
    private zzalg(zzajr zzajrVar, Provider provider) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        try {
            Mac.getInstance("AESCMAC", provider);
            zzajrVar.zze().zzb();
            zzajrVar.zzf();
            new SecretKeySpec(zzajrVar.zzd().zzb(zzvx.zza()), AesConfig.CRYPTO_KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new GeneralSecurityException("AES-CMAC not available.", e);
        }
    }

    public static zzajz zza(zzajr zzajrVar, Provider provider) throws GeneralSecurityException {
        return new zzalg(zzajrVar, provider);
    }
}
