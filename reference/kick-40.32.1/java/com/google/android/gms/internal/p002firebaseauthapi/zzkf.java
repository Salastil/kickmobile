package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzkf implements zzbp {
    private final zzkg zza;
    private final zzpu<zzkg> zzb;
    private final zzot zzc;
    private final zzot zzd;

    zzkf(zzkg zzkgVar, zzpu<zzkg> zzpuVar, zzot zzotVar, zzot zzotVar2) {
        this.zza = zzkgVar;
        this.zzb = zzpuVar;
        this.zzc = zzotVar;
        this.zzd = zzotVar2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbp
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzkg zzkgVar : this.zzb.zza(bArr)) {
            try {
                byte[] bArrZza = zzkgVar.zza.zza(bArr, bArr2);
                this.zzd.zza(zzkgVar.zzb, bArr.length);
                return bArrZza;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzd.zza();
        throw new GeneralSecurityException("decryption failed");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbp
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
