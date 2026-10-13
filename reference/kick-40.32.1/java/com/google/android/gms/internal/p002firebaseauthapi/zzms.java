package com.google.android.gms.internal.p002firebaseauthapi;

import io.ktor.http.MimesKt;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzms {
    public static final byte[] zza = zza(1, 0);
    public static final byte[] zzb;
    public static final byte[] zzc;
    public static final byte[] zzd;
    public static final byte[] zze;
    public static final byte[] zzf;
    public static final byte[] zzg;
    public static final byte[] zzh;
    public static final byte[] zzi;
    public static final byte[] zzj;
    public static final byte[] zzk;
    public static final byte[] zzl;
    private static final byte[] zzm;
    private static final byte[] zzn;
    private static final byte[] zzo;

    public static int zza(zzkq.zzf zzfVar) {
        if (zzfVar == zzkq.zzf.zzd) {
            return 32;
        }
        if (zzfVar == zzkq.zzf.zza) {
            return 65;
        }
        if (zzfVar == zzkq.zzf.zzb) {
            return 97;
        }
        if (zzfVar == zzkq.zzf.zzc) {
            return 133;
        }
        if (zzfVar == zzkq.zzf.zze) {
            return 1120;
        }
        throw new IllegalArgumentException("Unable to determine KEM-encoding length for " + String.valueOf(zzfVar));
    }

    public static int zzb(zzkq.zzf zzfVar) throws GeneralSecurityException {
        if (zzfVar == zzkq.zzf.zzd || zzfVar == zzkq.zzf.zza) {
            return 32;
        }
        if (zzfVar == zzkq.zzf.zzb) {
            return 48;
        }
        if (zzfVar == zzkq.zzf.zzc) {
            return 66;
        }
        if (zzfVar == zzkq.zzf.zze) {
            return 32;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static int zzc(zzkq.zzf zzfVar) throws GeneralSecurityException {
        if (zzfVar == zzkq.zzf.zzd) {
            return 32;
        }
        if (zzfVar == zzkq.zzf.zza) {
            return 65;
        }
        if (zzfVar == zzkq.zzf.zzb) {
            return 97;
        }
        if (zzfVar == zzkq.zzf.zzc) {
            return 133;
        }
        if (zzfVar == zzkq.zzf.zze) {
            return MimesKt.INITIAL_MIMES_LIST_SIZE;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    static zzzq zzd(zzkq.zzf zzfVar) throws GeneralSecurityException {
        if (zzfVar == zzkq.zzf.zza) {
            return zzzq.NIST_P256;
        }
        if (zzfVar == zzkq.zzf.zzb) {
            return zzzq.NIST_P384;
        }
        if (zzfVar == zzkq.zzf.zzc) {
            return zzzq.NIST_P521;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    static {
        zza(1, 2);
        zzb = zza(2, 32);
        zzc = zza(2, 16);
        zzd = zza(2, 17);
        zze = zza(2, 18);
        zza(2, 25722);
        zzf = zza(2, 1);
        zzg = zza(2, 2);
        zzh = zza(2, 3);
        zzi = zza(2, 1);
        zzj = zza(2, 2);
        zzk = zza(2, 3);
        zzl = new byte[0];
        zzm = "KEM".getBytes(zzqu.zza);
        zzn = "HPKE".getBytes(zzqu.zza);
        zzo = "HPKE-v1".getBytes(zzqu.zza);
    }

    static byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzzi.zza(zzn, bArr, bArr2, bArr3);
    }

    private static byte[] zza(int i, int i2) {
        if (i > 4 || i < 0) {
            throw new IllegalArgumentException("capacity must be between 0 and 4");
        }
        if (i2 < 0 || (i < 4 && i2 >= (1 << (i << 3)))) {
            throw new IllegalArgumentException("value too large");
        }
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (i2 >> (((i - i3) - 1) * 8));
        }
        return bArr;
    }

    static byte[] zza(byte[] bArr) throws GeneralSecurityException {
        return zzzi.zza(zzm, bArr);
    }

    static byte[] zza(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzzi.zza(zzo, bArr2, str.getBytes(zzqu.zza), bArr);
    }

    static byte[] zza(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return zzzi.zza(zza(2, i), zzo, bArr2, str.getBytes(zzqu.zza), bArr);
    }
}
