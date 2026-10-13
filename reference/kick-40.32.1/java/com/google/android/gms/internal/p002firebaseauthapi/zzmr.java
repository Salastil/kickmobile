package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzmr implements zzbs {
    private final zzbs zza;
    private final byte[] zzb;

    public static zzbs zza(zzon zzonVar) throws GeneralSecurityException {
        zzct zzctVarZza = zzonVar.zza(zzbu.zza());
        return new zzmr((zzbs) zzoe.zza().zza(zzctVarZza.zze(), zzbs.class).zzb(zzctVarZza.zzc()), zzqk.zza(zzctVarZza.zzb(), zzonVar.zzb()).zzb());
    }

    private zzmr(zzbs zzbsVar, byte[] bArr) {
        this.zza = zzbsVar;
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (!zzqu.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        return this.zza.zza(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
    }
}
