package com.google.android.gms.internal.pal;

import expo.modules.crypto.aes.AesConfig;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzalw implements zzalr {
    private final Key zza;
    private final Provider zzb;

    private zzalw(byte[] bArr, Provider provider) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode, as BoringCrypto module is not available");
        }
        this.zza = new SecretKeySpec(bArr, AesConfig.CRYPTO_KEY_ALGORITHM);
        this.zzb = provider;
    }

    public static zzalr zzb(zzalp zzalpVar) throws GeneralSecurityException {
        Provider providerZza = zzagw.zza();
        if (providerZza == null) {
            throw new GeneralSecurityException("Conscrypt not available");
        }
        Mac.getInstance("AESCMAC", providerZza);
        return new zzalw(zzalpVar.zzd().zzb(zzvx.zza()), providerZza);
    }

    @Override // com.google.android.gms.internal.pal.zzalr
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength must not be larger than 16");
        }
        Provider provider = this.zzb;
        Key key = this.zza;
        Mac mac = Mac.getInstance("AESCMAC", provider);
        mac.init(key);
        byte[] bArrDoFinal = mac.doFinal(bArr);
        return i == bArrDoFinal.length ? bArrDoFinal : Arrays.copyOf(bArrDoFinal, i);
    }
}
