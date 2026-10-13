package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzba extends zzaun implements zzavx {
    private static final zzba zzy;
    private int zza;
    private long zzs;
    private long zzt;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private int zzj = 1000;
    private long zzk = -1;
    private long zzl = -1;
    private long zzm = -1;
    private int zzn = 1000;
    private long zzo = -1;
    private long zzp = -1;
    private long zzq = -1;
    private long zzr = -1;
    private long zzu = -1;
    private long zzv = -1;
    private long zzw = -1;
    private long zzx = -1;

    static {
        zzba zzbaVar = new zzba();
        zzy = zzbaVar;
        zzaun.zzaD(zzba.class, zzbaVar);
    }

    private zzba() {
    }

    public static zzaz zza() {
        return (zzaz) zzy.zzay();
    }

    final /* synthetic */ void zzb(long j) {
        this.zza |= 1;
        this.zzd = j;
    }

    final /* synthetic */ void zzc(long j) {
        this.zza |= 2;
        this.zze = j;
    }

    final /* synthetic */ void zzd(long j) {
        this.zza |= 4;
        this.zzf = j;
    }

    final /* synthetic */ void zze(long j) {
        this.zza |= 8;
        this.zzg = j;
    }

    final /* synthetic */ void zzf() {
        this.zza &= -9;
        this.zzg = -1L;
    }

    final /* synthetic */ void zzg(long j) {
        this.zza |= 16;
        this.zzh = j;
    }

    final /* synthetic */ void zzh(long j) {
        this.zza |= 32;
        this.zzi = j;
    }

    final /* synthetic */ void zzi(long j) {
        this.zza |= 128;
        this.zzk = j;
    }

    final /* synthetic */ void zzj(long j) {
        this.zza |= 256;
        this.zzl = j;
    }

    final /* synthetic */ void zzk(long j) {
        this.zza |= 512;
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzaus zzausVar = zzbn.zza;
            return zzaE(zzy, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007᠌\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000b᠌\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zza", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzausVar, "zzk", "zzl", "zzm", "zzn", zzausVar, "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx"});
        }
        if (i2 == 3) {
            return new zzba();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaz(bArr);
        }
        if (i2 == 5) {
            return zzy;
        }
        throw null;
    }

    final /* synthetic */ void zzm(long j) {
        this.zza |= 2048;
        this.zzo = j;
    }

    final /* synthetic */ void zzn(long j) {
        this.zza |= 4096;
        this.zzp = j;
    }

    final /* synthetic */ void zzo(long j) {
        this.zza |= 8192;
        this.zzq = j;
    }

    final /* synthetic */ void zzp(long j) {
        this.zza |= 16384;
        this.zzr = j;
    }

    final /* synthetic */ void zzq(long j) {
        this.zza |= 32768;
        this.zzs = j;
    }

    final /* synthetic */ void zzr(long j) {
        this.zza |= 65536;
        this.zzt = j;
    }

    final /* synthetic */ void zzs(long j) {
        this.zza |= 131072;
        this.zzu = j;
    }

    final /* synthetic */ void zzt(long j) {
        this.zza |= 262144;
        this.zzv = j;
    }

    final /* synthetic */ void zzv(int i) {
        this.zzj = i - 1;
        this.zza |= 64;
    }

    final /* synthetic */ void zzw(int i) {
        this.zzn = i - 1;
        this.zza |= 1024;
    }
}
