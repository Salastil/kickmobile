package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzakn {
    private static volatile int zze = 100;
    private static int zzf = 1;
    int zza;
    int zzb;
    int zzc;
    Object zzd;
    private int zzg;

    public static int zza(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract double zza() throws IOException;

    public abstract float zzb() throws IOException;

    public abstract int zzb(int i) throws zzamd;

    public abstract int zzc();

    public abstract void zzc(int i) throws zzamd;

    public abstract int zzd() throws IOException;

    public abstract void zzd(int i);

    public abstract int zze() throws IOException;

    public abstract boolean zze(int i) throws IOException;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract long zzk() throws IOException;

    public abstract long zzl() throws IOException;

    abstract long zzm() throws IOException;

    public abstract long zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract zzakb zzq() throws IOException;

    public abstract String zzr() throws IOException;

    public abstract String zzs() throws IOException;

    public abstract boolean zzw() throws IOException;

    public abstract boolean zzx() throws IOException;

    static zzakn zza(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        zzakn zzakpVar;
        zzakn zzakrVar;
        int i4 = zzf - 1;
        try {
            if (i4 == 1) {
                i3 = i2;
                zzakpVar = new zzakp(bArr, i, i3, z);
            } else {
                if (i4 == 2) {
                    i3 = i2;
                    zzakpVar = new zzaks(bArr, i, i3, z);
                } else {
                    zzakrVar = new zzakr(bArr, i, i2, z);
                    i3 = i2;
                }
                zzakrVar.zzb(i3);
                return zzakrVar;
            }
            zzakrVar.zzb(i3);
            return zzakrVar;
        } catch (zzamd e) {
            throw new IllegalArgumentException(e);
        }
        zzakrVar = zzakpVar;
    }

    private zzakn() {
        this.zzg = zze;
        this.zzc = Integer.MAX_VALUE;
    }

    public final void zzt() throws zzamd {
        if (this.zza + this.zzb >= this.zzg) {
            throw zzamd.zzh();
        }
    }

    public final void zzu() throws zzamd {
        if (this.zzb == 0) {
            zzc(0);
        }
    }

    public final void zzv() throws IOException {
        boolean zZze;
        do {
            int iZzi = zzi();
            if (iZzi == 0) {
                return;
            }
            zzt();
            this.zzb++;
            zZze = zze(iZzi);
            this.zzb--;
        } while (zZze);
    }
}
