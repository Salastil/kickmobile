package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzig implements zzbm {
    private final zzbm zza;
    private final byte[] zzb;

    public static zzbm zza(zzon zzonVar) throws GeneralSecurityException {
        zzct zzctVarZza = zzonVar.zza(zzbu.zza());
        return new zzig((zzbm) zzoe.zza().zza(zzctVarZza.zze(), zzbm.class).zzb(zzctVarZza.zzc()), zzqk.zza(zzctVarZza.zzb(), zzonVar.zzb()).zzb());
    }

    public static zzbm zza(zzbm zzbmVar, zzaau zzaauVar) {
        return new zzig(zzbmVar, zzaauVar.zzb());
    }

    private zzig(zzbm zzbmVar, byte[] bArr) {
        this.zza = zzbmVar;
        if (bArr.length != 0 && bArr.length != 5) {
            throw new IllegalArgumentException("identifier has an invalid length");
        }
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (!zzqu.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("wrong prefix");
        }
        return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr3.length;
        zzbm zzbmVar = this.zza;
        if (length == 0) {
            return zzbmVar.zzb(bArr, bArr2);
        }
        return zzzi.zza(bArr3, zzbmVar.zzb(bArr, bArr2));
    }
}
