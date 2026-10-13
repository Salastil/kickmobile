package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzmu implements zzbr {
    private final zzbr zza;
    private final byte[] zzb;

    public static zzbr zza(zzon zzonVar) throws GeneralSecurityException {
        zzct zzctVarZza = zzonVar.zza(zzbu.zza());
        return new zzmu((zzbr) zzoe.zza().zza(zzctVarZza.zze(), zzbr.class).zzb(zzctVarZza.zzc()), zzqk.zza(zzctVarZza.zzb(), zzonVar.zzb()).zzb());
    }

    private zzmu(zzbr zzbrVar, byte[] bArr) {
        this.zza = zzbrVar;
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr3.length;
        zzbr zzbrVar = this.zza;
        if (length == 0) {
            return zzbrVar.zza(bArr, bArr2);
        }
        return zzzi.zza(bArr3, zzbrVar.zza(bArr, bArr2));
    }
}
