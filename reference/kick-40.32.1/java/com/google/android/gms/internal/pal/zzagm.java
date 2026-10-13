package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzagm {
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

    static {
        zza(1, 2);
        zzb = zza(2, 32);
        zzc = zza(2, 16);
        zzd = zza(2, 17);
        zze = zza(2, 18);
        zzf = zza(2, 1);
        zzg = zza(2, 2);
        zzh = zza(2, 3);
        zzi = zza(2, 1);
        zzj = zza(2, 2);
        zzk = zza(2, 3);
        zzl = new byte[0];
        zzm = "KEM".getBytes(zzajp.zza);
        zzn = "HPKE".getBytes(zzajp.zza);
        zzo = "HPKE-v1".getBytes(zzajp.zza);
    }

    public static byte[] zza(int i, int i2) {
        if (i2 < 0 || i2 >= (1 << (i * 8))) {
            throw new IllegalArgumentException("value too large");
        }
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((i2 >> (((i - i3) - 1) * 8)) & 255);
        }
        return bArr;
    }

    static byte[] zzb(byte[] bArr) throws GeneralSecurityException {
        return zzaqj.zza(zzm, bArr);
    }

    static byte[] zzc(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzaqj.zza(zzn, bArr, bArr2, bArr3);
    }

    static byte[] zzd(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzaqj.zza(zzo, bArr2, str.getBytes(zzajp.zza), bArr);
    }

    static byte[] zze(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return zzaqj.zza(zza(2, i), zzo, bArr2, str.getBytes(zzajp.zza), bArr);
    }
}
