package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzmt implements zzmi {
    private final zzzq zza;
    private final zzmc zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmi
    public final zzml zza(byte[] bArr) throws GeneralSecurityException {
        KeyPair keyPairZza = zzzn.zza(zzzn.zza(this.zza));
        byte[] bArrZza = zzzn.zza((ECPrivateKey) keyPairZza.getPrivate(), zzzn.zza(this.zza, zzzp.UNCOMPRESSED, bArr));
        byte[] bArrZza2 = zzzn.zza(this.zza, zzzp.UNCOMPRESSED, ((ECPublicKey) keyPairZza.getPublic()).getW());
        return new zzml(zza(bArrZza, bArrZza2, bArr), bArrZza2);
    }

    static zzmt zza(zzzq zzzqVar) throws GeneralSecurityException {
        int i = zzmw.zza[zzzqVar.ordinal()];
        if (i == 1) {
            return new zzmt(new zzmc("HmacSha256"), zzzq.NIST_P256);
        }
        if (i == 2) {
            return new zzmt(new zzmc("HmacSha384"), zzzq.NIST_P384);
        }
        if (i == 3) {
            return new zzmt(new zzmc("HmacSha512"), zzzq.NIST_P521);
        }
        throw new GeneralSecurityException("invalid curve type: " + String.valueOf(zzzqVar));
    }

    private zzmt(zzmc zzmcVar, zzzq zzzqVar) {
        this.zzb = zzmcVar;
        this.zza = zzzqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmi
    public final byte[] zza(byte[] bArr, zzmk zzmkVar) throws GeneralSecurityException {
        return zza(zzzn.zza(zzzn.zza(this.zza, zzmkVar.zza().zzb()), zzzn.zza(this.zza, zzzp.UNCOMPRESSED, bArr)), bArr, zzmkVar.zzb().zzb());
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] bArrZza = zzzi.zza(bArr2, bArr3);
        byte[] bArrZza2 = zzms.zza(zza());
        zzmc zzmcVar = this.zzb;
        return zzmcVar.zza(null, bArr, "eae_prk", bArrZza, "shared_secret", bArrZza2, zzmcVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmi
    public final byte[] zza() throws GeneralSecurityException {
        int i = zzmw.zza[this.zza.ordinal()];
        if (i == 1) {
            return zzms.zzc;
        }
        if (i == 2) {
            return zzms.zzd;
        }
        if (i == 3) {
            return zzms.zze;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
