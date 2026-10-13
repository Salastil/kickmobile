package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzik implements zzbm {
    private final zzih zza;
    private final zzpu<zzih> zzb;
    private final zzot zzc;
    private final zzot zzd;

    private zzik(zzih zzihVar, zzpu<zzih> zzpuVar, zzot zzotVar, zzot zzotVar2) {
        this.zza = zzihVar;
        this.zzb = zzpuVar;
        this.zzc = zzotVar;
        this.zzd = zzotVar2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzih zzihVar : this.zzb.zza(bArr)) {
            try {
                byte[] bArrZza = zzihVar.zza.zza(bArr, bArr2);
                this.zzd.zza(zzihVar.zzb, bArr.length);
                return bArrZza;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzd.zza();
        throw new GeneralSecurityException("decryption failed");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            byte[] bArrZzb = this.zza.zza.zzb(bArr, bArr2);
            this.zzc.zza(this.zza.zzb, bArr.length);
            return bArrZzb;
        } catch (GeneralSecurityException e) {
            this.zzc.zza();
            throw e;
        }
    }
}
