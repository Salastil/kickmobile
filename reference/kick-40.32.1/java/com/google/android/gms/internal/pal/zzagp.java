package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzagp implements zzage {
    private final zzaqp zza;
    private final zzafy zzb;

    private zzagp(zzafy zzafyVar, zzaqp zzaqpVar) {
        this.zzb = zzafyVar;
        this.zza = zzaqpVar;
    }

    static zzagp zzc(zzaqp zzaqpVar) throws GeneralSecurityException {
        int iOrdinal = zzaqpVar.ordinal();
        if (iOrdinal == 0) {
            return new zzagp(new zzafy("HmacSha256"), zzaqp.NIST_P256);
        }
        if (iOrdinal == 1) {
            return new zzagp(new zzafy("HmacSha384"), zzaqp.NIST_P384);
        }
        if (iOrdinal == 2) {
            return new zzagp(new zzafy("HmacSha512"), zzaqp.NIST_P521);
        }
        String strValueOf = String.valueOf(zzaqpVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("invalid curve type: ".concat(String.valueOf(strValueOf)));
    }

    @Override // com.google.android.gms.internal.pal.zzage
    public final zzagf zza(byte[] bArr) throws GeneralSecurityException {
        zzaqp zzaqpVar = this.zza;
        KeyPair keyPairZze = zzaqr.zze(zzaqr.zzd(zzaqpVar));
        zzaqq zzaqqVar = zzaqq.UNCOMPRESSED;
        ECParameterSpec eCParameterSpecZzd = zzaqr.zzd(zzaqpVar);
        byte[] bArrZzf = zzaqr.zzf((ECPrivateKey) keyPairZze.getPrivate(), (ECPublicKey) ((KeyFactory) zzaqx.zze.zzb("EC")).generatePublic(new ECPublicKeySpec(zzaqr.zzb(eCParameterSpecZzd.getCurve(), zzaqqVar, bArr), eCParameterSpecZzd)));
        byte[] bArrZzc = zzaqr.zzc(zzaqr.zzd(zzaqpVar).getCurve(), zzaqqVar, ((ECPublicKey) keyPairZze.getPublic()).getW());
        byte[] bArrZza = zzaqj.zza(bArrZzc, bArr);
        byte[] bArrZzb = zzagm.zzb(zzb());
        zzafy zzafyVar = this.zzb;
        return new zzagf(zzafyVar.zzc(null, bArrZzf, "eae_prk", bArrZza, "shared_secret", bArrZzb, zzafyVar.zze()), bArrZzc);
    }

    @Override // com.google.android.gms.internal.pal.zzage
    public final byte[] zzb() throws GeneralSecurityException {
        int iOrdinal = this.zza.ordinal();
        if (iOrdinal == 0) {
            return zzagm.zzc;
        }
        if (iOrdinal == 1) {
            return zzagm.zzd;
        }
        if (iOrdinal == 2) {
            return zzagm.zze;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
