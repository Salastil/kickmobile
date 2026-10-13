package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzaky extends zzakc {
    Object zza;

    public static long zzd(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zze(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b) throws IOException;

    public abstract void zza(int i) throws IOException;

    public abstract void zza(int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzakb zzakbVar) throws IOException;

    public abstract void zza(int i, zzamv zzamvVar) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zza(long j) throws IOException;

    public abstract void zza(zzakb zzakbVar) throws IOException;

    public abstract void zza(zzamv zzamvVar) throws IOException;

    public abstract void zza(String str) throws IOException;

    public abstract void zzb() throws IOException;

    public abstract void zzb(int i) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzb(int i, long j) throws IOException;

    public abstract void zzb(int i, zzakb zzakbVar) throws IOException;

    public abstract void zzb(long j) throws IOException;

    abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc(int i) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public static int zzc(int i, zzakb zzakbVar) {
        int iZzd = zzd(i << 3);
        int iZza = zzakbVar.zza();
        return iZzd + zzd(iZza) + iZza;
    }

    public static int zzb(zzakb zzakbVar) {
        int iZza = zzakbVar.zza();
        return zzd(iZza) + iZza;
    }

    public static int zze(int i, int i2) {
        return zzd(i << 3) + zzc(i2);
    }

    public static int zzf(int i, int i2) {
        return zzd(i << 3) + zzc(i2);
    }

    public static int zzc(int i, long j) {
        return zzd(i << 3) + zzc(j);
    }

    public static int zzb(zzamv zzamvVar) {
        int iZzl = zzamvVar.zzl();
        return zzd(iZzl) + iZzl;
    }

    public static int zzg(int i, int i2) {
        return zzd(i << 3) + zzd(zze(i2));
    }

    public static int zzd(int i, long j) {
        return zzd(i << 3) + zzc(zzd(j));
    }

    public static int zzb(int i, String str) {
        int iZzd = zzd(i << 3);
        int iZza = zzaog.zza(str);
        return iZzd + zzd(iZza) + iZza;
    }

    public static int zzb(String str) {
        int iZza = zzaog.zza(str);
        return zzd(iZza) + iZza;
    }

    public static int zzh(int i, int i2) {
        return zzd(i << 3) + zzd(i2);
    }

    public static int zzd(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zze(int i, long j) {
        return zzd(i << 3) + zzc(j);
    }

    public static int zzc(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    private zzaky() {
    }

    public final void zzc() {
        if (zza() > 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
        if (zza() < 0) {
            throw new IllegalStateException("Wrote more data than expected.");
        }
    }

    public final void zza(boolean z) throws IOException {
        zza(z ? (byte) 1 : (byte) 0);
    }

    public final void zza(int i, double d) throws IOException {
        zza(i, Double.doubleToRawLongBits(d));
    }

    public final void zza(double d) throws IOException {
        zza(Double.doubleToRawLongBits(d));
    }

    public final void zza(int i, float f) throws IOException {
        zza(i, Float.floatToRawIntBits(f));
    }

    public final void zza(float f) throws IOException {
        zza(Float.floatToRawIntBits(f));
    }

    public final void zzi(int i, int i2) throws IOException {
        zzd(i, zze(i2));
    }

    public final void zzf(int i) throws IOException {
        zzc(zze(i));
    }

    public final void zzf(int i, long j) throws IOException {
        zzb(i, zzd(j));
    }

    public final void zze(long j) throws IOException {
        zzb(zzd(j));
    }
}
