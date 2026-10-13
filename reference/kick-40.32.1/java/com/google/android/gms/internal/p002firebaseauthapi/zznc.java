package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zznc implements zzbr {
    private final zzmz zza;
    private final zzot zzb;

    zznc(zzmz zzmzVar, zzot zzotVar) {
        this.zza = zzmzVar;
        this.zzb = zzotVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (this.zza.zza == null) {
            this.zzb.zza();
            throw new GeneralSecurityException("keyset without primary key");
        }
        try {
            byte[] bArrZza = this.zza.zza.zza(bArr, bArr2);
            this.zzb.zza(this.zza.zzb, bArr.length);
            return bArrZza;
        } catch (GeneralSecurityException e) {
            this.zzb.zza();
            throw e;
        }
    }
}
