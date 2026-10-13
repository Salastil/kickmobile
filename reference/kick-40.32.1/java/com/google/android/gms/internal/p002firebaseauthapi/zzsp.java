package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsp implements zzcp {
    private static final byte[] zza = {0};
    private final zzcp zzb;
    private final zzyi zzc;
    private final byte[] zzd;

    public static zzcp zza(zzon zzonVar) throws GeneralSecurityException {
        zzct zzctVarZza = zzonVar.zza(zzbu.zza());
        zzcp zzcpVar = (zzcp) zzoe.zza().zza(zzctVarZza.zze(), zzcp.class).zzb(zzctVarZza.zzc());
        zzcv zzcvVarZzb = zzctVarZza.zzb();
        return new zzsp(zzcpVar, zzqk.zza(zzcvVarZzb), zzqk.zza(zzcvVarZzb, zzonVar.zzb()).zzb());
    }

    private zzsp(zzcp zzcpVar, zzyi zzyiVar, byte[] bArr) {
        this.zzb = zzcpVar;
        this.zzc = zzyiVar;
        this.zzd = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcp
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 10) {
            throw new GeneralSecurityException("tag too short");
        }
        if (this.zzc.equals(zzyi.LEGACY)) {
            bArr2 = zzzi.zza(bArr2, zza);
        }
        byte[] bArr3 = new byte[0];
        if (!this.zzc.equals(zzyi.RAW)) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            bArr = Arrays.copyOfRange(bArr, 5, bArr.length);
            bArr3 = bArrCopyOf;
        }
        if (!Arrays.equals(this.zzd, bArr3)) {
            throw new GeneralSecurityException("wrong prefix");
        }
        this.zzb.zza(bArr, bArr2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcp
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        if (this.zzc.equals(zzyi.LEGACY)) {
            bArr = zzzi.zza(bArr, zza);
        }
        return zzzi.zza(this.zzd, this.zzb.zza(bArr));
    }
}
