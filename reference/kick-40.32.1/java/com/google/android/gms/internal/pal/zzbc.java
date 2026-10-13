package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbc extends zzaun implements zzavx {
    private static final zzbc zzl;
    private int zza;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;

    static {
        zzbc zzbcVar = new zzbc();
        zzl = zzbcVar;
        zzaun.zzaD(zzbc.class, zzbcVar);
    }

    private zzbc() {
    }

    public static zzbb zza() {
        return (zzbb) zzl.zzay();
    }

    final /* synthetic */ void zzb(long j) {
        this.zza |= 1;
        this.zzd = j;
    }

    final /* synthetic */ void zzc(long j) {
        this.zza |= 4;
        this.zzf = j;
    }

    final /* synthetic */ void zzd(long j) {
        this.zza |= 8;
        this.zzg = j;
    }

    final /* synthetic */ void zze(long j) {
        this.zza |= 16;
        this.zzh = j;
    }

    final /* synthetic */ void zzf(long j) {
        this.zza |= 32;
        this.zzi = j;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zza", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzbc();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzbb(bArr);
        }
        if (i2 == 5) {
            return zzl;
        }
        throw null;
    }
}
