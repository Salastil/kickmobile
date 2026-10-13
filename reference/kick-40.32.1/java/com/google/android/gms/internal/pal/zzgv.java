package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgv extends zzaun implements zzavx {
    private static final zzgv zzi;
    private int zza;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzgv zzgvVar = new zzgv();
        zzi = zzgvVar;
        zzaun.zzaD(zzgv.class, zzgvVar);
    }

    private zzgv() {
    }

    public static zzgv zzf(zzatl zzatlVar) throws zzavb {
        return (zzgv) zzaun.zzaL(zzi, zzatlVar);
    }

    public static zzgv zzg(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzgv) zzaun.zzaM(zzi, zzatlVar, zzatyVar);
    }

    public static zzgu zzh() {
        return (zzgu) zzi.zzay();
    }

    public static zzgv zzi() {
        return zzi;
    }

    public final String zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zze;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final long zze() {
        return this.zzh;
    }

    final /* synthetic */ void zzj(String str) {
        str.getClass();
        this.zza |= 1;
        this.zzd = str;
    }

    final /* synthetic */ void zzk(String str) {
        str.getClass();
        this.zza |= 2;
        this.zze = str;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zza", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzgv();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzgu(bArr);
        }
        if (i2 == 5) {
            return zzi;
        }
        throw null;
    }

    final /* synthetic */ void zzm(long j) {
        this.zza |= 4;
        this.zzf = j;
    }

    final /* synthetic */ void zzn(long j) {
        this.zza |= 8;
        this.zzg = j;
    }

    final /* synthetic */ void zzo(long j) {
        this.zza |= 16;
        this.zzh = j;
    }
}
