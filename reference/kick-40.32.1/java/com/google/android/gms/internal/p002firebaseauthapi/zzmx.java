package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzmx implements zzbs {
    private final zzpu<zzmy> zza;
    private final zzot zzb;

    zzmx(zzpu<zzmy> zzpuVar, zzot zzotVar) {
        this.zza = zzpuVar;
        this.zzb = zzotVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzmy zzmyVar : this.zza.zza(bArr)) {
            try {
                byte[] bArrZza = zzmyVar.zza.zza(bArr, bArr2);
                this.zzb.zza(zzmyVar.zzb, bArr.length);
                return bArrZza;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
