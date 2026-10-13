package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzl {
    private final ECPublicKey zza;

    public final zzzo zza(String str, byte[] bArr, byte[] bArr2, int i, zzzp zzzpVar) throws GeneralSecurityException {
        KeyPair keyPairZza = zzzn.zza(this.zza.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairZza.getPublic();
        byte[] bArrZza = zzzn.zza((ECPrivateKey) keyPairZza.getPrivate(), this.zza);
        byte[] bArrZza2 = zzzn.zza(eCPublicKey.getParams().getCurve(), zzzpVar, eCPublicKey.getW());
        return new zzzo(bArrZza2, zzaai.zza(bArrZza2, bArrZza, str, bArr, bArr2, i));
    }

    public zzzl(ECPublicKey eCPublicKey) {
        this.zza = eCPublicKey;
    }
}
