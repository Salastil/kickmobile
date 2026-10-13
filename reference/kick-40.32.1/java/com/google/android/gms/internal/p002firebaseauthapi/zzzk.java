package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.EllipticCurve;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzk implements zzbs {
    private final ECPrivateKey zza;
    private final zzzm zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzzp zze;
    private final zzlu zzf;
    private final byte[] zzg;

    public static zzbs zza(zzko zzkoVar) throws GeneralSecurityException {
        ECPrivateKey eCPrivateKeyZza = zzzn.zza((zzzq) zzzj.zza.zza(((zzkl) ((zzln) zzkoVar.zza())).zzd()), zznu.zza(zzkoVar.zzf().zza(zzbu.zza())));
        byte[] bArrZzb = new byte[0];
        if (((zzkl) ((zzln) zzkoVar.zza())).zzh() != null) {
            bArrZzb = ((zzkl) ((zzln) zzkoVar.zza())).zzh().zzb();
        }
        return new zzzk(eCPrivateKeyZza, bArrZzb, zzzj.zza(((zzkl) ((zzln) zzkoVar.zza())).zze()), (zzzp) zzzj.zzb.zza(((zzkl) ((zzln) zzkoVar.zza())).zzf()), zzlq.zza((zzkl) ((zzln) zzkoVar.zza())), zzkoVar.zzh().zzb());
    }

    private zzzk(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzzp zzzpVar, zzlu zzluVar, byte[] bArr2) {
        this.zza = eCPrivateKey;
        this.zzb = new zzzm(eCPrivateKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zze = zzzpVar;
        this.zzf = zzluVar;
        this.zzg = bArr2;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    /* JADX WARN: Code duplicated, block: B:17:0x0055  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int i;
        int i2;
        if (!zzqu.zza(this.zzg, bArr)) {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        int length = this.zzg.length;
        EllipticCurve curve = this.zza.getParams().getCurve();
        zzzp zzzpVar = this.zze;
        int iZza = zzzn.zza(curve);
        int iOrdinal = zzzpVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    throw new GeneralSecurityException("unknown EC point format");
                }
                i = iZza * 2;
            }
            i2 = i + length;
            if (bArr.length >= i2) {
                throw new GeneralSecurityException("ciphertext too short");
            }
            return this.zzf.zza(this.zzb.zza(Arrays.copyOfRange(bArr, length, i2), this.zzc, this.zzd, bArr2, this.zzf.zza(), this.zze), bArr, i2);
        }
        iZza *= 2;
        i = iZza + 1;
        i2 = i + length;
        if (bArr.length >= i2) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.zzf.zza(this.zzb.zza(Arrays.copyOfRange(bArr, length, i2), this.zzc, this.zzd, bArr2, this.zzf.zza(), this.zze), bArr, i2);
    }
}
