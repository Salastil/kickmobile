package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaan implements zzcp {
    private static final byte[] zza = {0};
    private final zzsz zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    public static zzcp zza(zzqt zzqtVar) throws GeneralSecurityException {
        return new zzaan(zzqtVar);
    }

    public static zzcp zza(zzre zzreVar) throws GeneralSecurityException {
        return new zzaan(zzreVar);
    }

    private zzaan(zzqt zzqtVar) throws GeneralSecurityException {
        this.zzb = zzaak.zza(zzsx.zza(zzsw.zza(((zzra) ((zzro) zzqtVar.zza())).zzc()), zzqtVar.zzf()));
        this.zzc = ((zzra) ((zzro) zzqtVar.zza())).zzb();
        this.zzd = zzqtVar.zze().zzb();
        if (((zzra) ((zzro) zzqtVar.zza())).zze().equals(zzra.zzb.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.zze = new byte[0];
        }
    }

    private zzaan(zzre zzreVar) throws GeneralSecurityException {
        this.zzb = new zzaal("HMAC" + String.valueOf(((zzrl) ((zzro) zzreVar.zza())).zze()), new SecretKeySpec(zzreVar.zzf().zza(zzbu.zza()), "HMAC"));
        this.zzc = ((zzrl) ((zzro) zzreVar.zza())).zzb();
        this.zzd = zzreVar.zze().zzb();
        if (((zzrl) ((zzro) zzreVar.zza())).zzf().equals(zzrl.zzb.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzaan(zzsz zzszVar, int i) throws GeneralSecurityException {
        this.zzb = zzszVar;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        zzszVar.zza(new byte[0], i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcp
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!MessageDigest.isEqual(zza(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcp
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        int length = bArr2.length;
        byte[] bArr3 = this.zzd;
        if (length > 0) {
            return zzzi.zza(bArr3, this.zzb.zza(zzzi.zza(bArr, bArr2), this.zzc));
        }
        return zzzi.zza(bArr3, this.zzb.zza(bArr, this.zzc));
    }
}
