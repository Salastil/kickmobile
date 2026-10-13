package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzsv implements zzcp {
    private final zzss zza;
    private final zzpu<zzss> zzb;
    private final zzot zzc;
    private final zzot zzd;

    private zzsv(zzss zzssVar, zzpu<zzss> zzpuVar, zzot zzotVar, zzot zzotVar2) {
        this.zza = zzssVar;
        this.zzb = zzpuVar;
        this.zzc = zzotVar;
        this.zzd = zzotVar2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcp
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzss zzssVar : this.zzb.zza(bArr)) {
            try {
                zzssVar.zza.zza(bArr, bArr2);
                this.zzd.zza(zzssVar.zzb, bArr2.length);
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzd.zza();
        throw new GeneralSecurityException("invalid MAC");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcp
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        try {
            byte[] bArrZza = this.zza.zza.zza(bArr);
            this.zzc.zza(this.zza.zzb, bArr.length);
            return bArrZza;
        } catch (GeneralSecurityException e) {
            this.zzc.zza();
            throw e;
        }
    }
}
