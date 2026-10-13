package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzacv {
    private static volatile int zze = 100;
    int zza;
    int zzb;
    final int zzc = zze;
    Object zzd;

    private zzacv() {
    }

    /* synthetic */ zzacv(byte[] bArr) {
    }

    static zzacv zzN(byte[] bArr, int i, int i2, boolean z) {
        zzact zzactVar = new zzact(bArr, 0, 0, false, null);
        try {
            zzactVar.zzD(0);
            return zzactVar;
        } catch (zzaeh e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzR(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long zzS(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    static /* synthetic */ void zzT(byte[] bArr, int i, int i2) {
        if ((bArr.length - i) - i2 < 0 || (i | i2) < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public abstract int zzD(int i) throws zzaeh;

    public abstract void zzE(int i);

    public abstract int zzF();

    public abstract boolean zzG() throws IOException;

    public abstract int zzH();

    public abstract int zzK(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzL(int i) throws IOException;

    public final void zzO() throws zzaeh {
        if (this.zza + this.zzb >= this.zzc) {
            throw new zzaeh("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    public final void zzP() throws zzaeh {
        if (this.zzb == 0) {
            zzb(0);
        }
    }

    public final void zzQ() throws IOException {
        boolean zZzc;
        do {
            int iZza = zza();
            if (iZza == 0) {
                return;
            }
            zzO();
            this.zzb++;
            zZzc = zzc(iZza);
            this.zzb--;
        } while (zZzc);
    }

    public abstract int zza() throws IOException;

    public abstract void zzb(int i) throws zzaeh;

    public abstract boolean zzc(int i) throws IOException;

    public abstract double zzd() throws IOException;

    public abstract float zze() throws IOException;

    public abstract long zzf() throws IOException;

    public abstract long zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract long zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract boolean zzk() throws IOException;

    public abstract String zzl() throws IOException;

    public abstract String zzm() throws IOException;

    public abstract zzacr zzn() throws IOException;

    public abstract byte[] zzo() throws IOException;

    public abstract int zzp() throws IOException;

    public abstract int zzq() throws IOException;

    public abstract int zzr() throws IOException;

    public abstract long zzs() throws IOException;

    public abstract int zzt() throws IOException;

    public abstract long zzu() throws IOException;

    public abstract int zzx() throws IOException;

    public abstract long zzz() throws IOException;

    public static zzacv zzM(InputStream inputStream, int i) {
        if (i > 0) {
            return inputStream == null ? zzN(zzaed.zza, 0, 0, false) : new zzacu(inputStream, i, null);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }
}
