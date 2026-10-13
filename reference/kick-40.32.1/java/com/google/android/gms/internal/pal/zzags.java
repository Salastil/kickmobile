package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzags implements zzagr {
    private static final byte[] zzb = {48, 46, 2, 1, 0, 48, 5, 6, 3, 43, 101, 110, 4, 34, 4, 32};
    private static final byte[] zzc = {48, 42, 48, 5, 6, 3, 43, 101, 110, 3, 33, 0};
    final Provider zza;

    private zzags(Provider provider) {
        this.zza = provider;
    }

    public static zzagr zzc() throws GeneralSecurityException {
        Provider providerZza = zzagw.zza();
        if (providerZza == null) {
            throw new GeneralSecurityException("Conscrypt is not available.");
        }
        KeyFactory.getInstance("XDH", providerZza);
        KeyAgreement.getInstance("XDH", providerZza);
        zzags zzagsVar = new zzags(providerZza);
        zzagsVar.zza();
        return zzagsVar;
    }

    @Override // com.google.android.gms.internal.pal.zzagr
    public final zzagq zza() throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("XDH", this.zza);
        keyPairGenerator.initialize(255);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        byte[] encoded = keyPairGenerateKeyPair.getPrivate().getEncoded();
        if (encoded.length != 48) {
            throw new GeneralSecurityException("Invalid encoded private key length");
        }
        if (!zzajp.zzc(zzb, encoded)) {
            throw new GeneralSecurityException("Invalid encoded private key prefix");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(encoded, 16, 48);
        byte[] encoded2 = keyPairGenerateKeyPair.getPublic().getEncoded();
        if (encoded2.length != 44) {
            throw new GeneralSecurityException("Invalid encoded public key length");
        }
        if (zzajp.zzc(zzc, encoded2)) {
            return new zzagq(bArrCopyOfRange, Arrays.copyOfRange(encoded2, 12, 44));
        }
        throw new GeneralSecurityException("Invalid encoded public key prefix");
    }

    @Override // com.google.android.gms.internal.pal.zzagr
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Provider provider = this.zza;
        KeyFactory keyFactory = KeyFactory.getInstance("XDH", provider);
        if (bArr.length != 32) {
            throw new InvalidKeyException("Invalid X25519 private key");
        }
        PrivateKey privateKeyGeneratePrivate = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(zzaqj.zza(zzb, bArr)));
        if (bArr2.length != 32) {
            throw new InvalidKeyException("Invalid X25519 public key");
        }
        PublicKey publicKeyGeneratePublic = keyFactory.generatePublic(new X509EncodedKeySpec(zzaqj.zza(zzc, bArr2)));
        KeyAgreement keyAgreement = KeyAgreement.getInstance("XDH", provider);
        keyAgreement.init(privateKeyGeneratePrivate);
        keyAgreement.doPhase(publicKeyGeneratePublic, true);
        return keyAgreement.generateSecret();
    }
}
