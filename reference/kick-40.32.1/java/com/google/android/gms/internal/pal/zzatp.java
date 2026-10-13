package com.google.android.gms.internal.pal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzatp {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    Object zzc;

    private zzatp() {
    }

    /* synthetic */ zzatp(byte[] bArr) {
    }

    static zzatp zzE(byte[] bArr, int i, int i2, boolean z) {
        zzatn zzatnVar = new zzatn(bArr, i, i2, z, null);
        try {
            zzatnVar.zzA(i2);
            return zzatnVar;
        } catch (zzavb e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzF(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long zzG(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public abstract int zzA(int i) throws zzavb;

    public abstract void zzB(int i);

    public abstract boolean zzC() throws IOException;

    public abstract int zzD();

    public abstract int zza() throws IOException;

    public abstract void zzb(int i) throws zzavb;

    public abstract double zzc() throws IOException;

    public abstract float zzd() throws IOException;

    public abstract long zze() throws IOException;

    public abstract long zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract long zzh() throws IOException;

    public abstract int zzi() throws IOException;

    public abstract boolean zzj() throws IOException;

    public abstract String zzk() throws IOException;

    public abstract String zzl() throws IOException;

    public abstract zzatl zzm() throws IOException;

    public abstract int zzn() throws IOException;

    public abstract int zzo() throws IOException;

    public abstract int zzp() throws IOException;

    public abstract long zzq() throws IOException;

    public abstract int zzr() throws IOException;

    public abstract long zzs() throws IOException;
}
