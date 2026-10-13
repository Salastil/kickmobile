package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzm {
    private ECPrivateKey zza;

    public zzzm(ECPrivateKey eCPrivateKey) {
        this.zza = eCPrivateKey;
    }

    public final byte[] zza(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i, zzzp zzzpVar) throws GeneralSecurityException {
        return zzaai.zza(bArr, zzzn.zza(this.zza, zzzn.zza(this.zza.getParams(), zzzpVar, bArr)), str, bArr2, bArr3, i);
    }
}
