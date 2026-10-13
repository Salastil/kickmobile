package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzr extends zzaun implements zzavx {
    private static final zzr zzq;
    private int zza;
    private long zze;
    private long zzi;
    private long zzj;
    private long zzl;
    private int zzp;
    private String zzd = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzk = "";
    private String zzm = "";
    private String zzn = "";
    private zzauy zzo = zzaJ();

    static {
        zzr zzrVar = new zzr();
        zzq = zzrVar;
        zzaun.zzaD(zzr.class, zzrVar);
    }

    private zzr() {
    }

    public static zzn zza() {
        return (zzn) zzq.zzay();
    }

    final /* synthetic */ void zzb(String str) {
        str.getClass();
        this.zza |= 1;
        this.zzd = str;
    }

    final /* synthetic */ void zzc(long j) {
        this.zza |= 2;
        this.zze = j;
    }

    final /* synthetic */ void zzd(String str) {
        str.getClass();
        this.zza |= 4;
        this.zzf = str;
    }

    final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zza |= 8;
        this.zzg = str;
    }

    final /* synthetic */ void zzf(String str) {
        this.zza |= 16;
        this.zzh = str;
    }

    final /* synthetic */ void zzg(String str) {
        this.zza |= 1024;
        this.zzn = str;
    }

    final /* synthetic */ void zzi(int i) {
        this.zzp = i - 1;
        this.zza |= 2048;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzq, "\u0004\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zza", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzp.class, "zzp", zzq.zza});
        }
        if (i2 == 3) {
            return new zzr();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzn(bArr);
        }
        if (i2 == 5) {
            return zzq;
        }
        throw null;
    }
}
