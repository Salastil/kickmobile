package com.google.android.gms.internal.pal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzatt extends zzate {
    public static final /* synthetic */ int zzb = 0;
    private static final boolean zzc = zzaxh.zza();
    Object zza;

    private zzatt() {
        throw null;
    }

    /* synthetic */ zzatt(byte[] bArr) {
    }

    public static int zzu(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzv(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public abstract void zza(int i, int i2) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, long j) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzg(int i, boolean z) throws IOException;

    public abstract void zzh(int i, String str) throws IOException;

    public abstract void zzi(int i, zzatl zzatlVar) throws IOException;

    public abstract void zzj(int i, zzavw zzavwVar) throws IOException;

    public abstract void zzk(int i, zzatl zzatlVar) throws IOException;

    public abstract void zzl(byte b) throws IOException;

    public abstract void zzm(int i) throws IOException;

    public abstract void zzn(int i) throws IOException;

    public abstract void zzo(int i) throws IOException;

    public abstract void zzp(long j) throws IOException;

    public abstract void zzq(long j) throws IOException;

    public abstract int zzt();

    public final void zzw() {
        if (zzt() > 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
        if (zzt() < 0) {
            throw new IllegalStateException("Wrote more data than expected.");
        }
    }
}
