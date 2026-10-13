package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zznf implements zznb {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zznb
    public final zzne zza() throws GeneralSecurityException {
        byte[] bArrZza = zzaas.zza();
        return new zzne(bArrZza, zzaas.zza(bArrZza));
    }

    private zznf() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zznb
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzaas.zza(bArr, bArr2);
    }
}
