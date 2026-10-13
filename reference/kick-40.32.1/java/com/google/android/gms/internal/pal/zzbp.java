package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbp extends zzaun implements zzavx {
    private static final zzbp zzj;
    private int zza;
    private long zzf;
    private long zzh;
    private long zzi;
    private String zzd = "";
    private String zze = "";
    private String zzg = "D";

    static {
        zzbp zzbpVar = new zzbp();
        zzj = zzbpVar;
        zzaun.zzaD(zzbp.class, zzbpVar);
    }

    private zzbp() {
    }

    public static zzbo zza() {
        return (zzbo) zzj.zzay();
    }

    final /* synthetic */ void zzb(String str) {
        this.zza |= 1;
        this.zzd = "0.828153725";
    }

    final /* synthetic */ void zzc(String str) {
        str.getClass();
        this.zza |= 2;
        this.zze = str;
    }

    final /* synthetic */ void zzd(long j) {
        this.zza |= 4;
        this.zzf = j;
    }

    final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zza |= 8;
        this.zzg = str;
    }

    final /* synthetic */ void zzf(long j) {
        this.zza |= 16;
        this.zzh = j;
    }

    final /* synthetic */ void zzg(long j) {
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
            return zzaE(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဈ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zza", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzbp();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzbo(bArr);
        }
        if (i2 == 5) {
            return zzj;
        }
        throw null;
    }
}
