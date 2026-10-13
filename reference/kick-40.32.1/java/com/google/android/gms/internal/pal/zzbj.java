package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbj extends zzaun implements zzavx {
    private static final zzbj zzh;
    private int zza;
    private zzatl zzd;
    private zzatl zze;
    private zzatl zzf;
    private zzatl zzg;

    static {
        zzbj zzbjVar = new zzbj();
        zzh = zzbjVar;
        zzaun.zzaD(zzbj.class, zzbjVar);
    }

    private zzbj() {
        zzatl zzatlVar = zzatl.zza;
        this.zzd = zzatlVar;
        this.zze = zzatlVar;
        this.zzf = zzatlVar;
        this.zzg = zzatlVar;
    }

    public static zzbj zze(byte[] bArr, zzaty zzatyVar) throws zzavb {
        return (zzbj) zzaun.zzaN(zzh, bArr, zzatyVar);
    }

    public static zzbi zzf() {
        return (zzbi) zzh.zzay();
    }

    public final zzatl zza() {
        return this.zzd;
    }

    public final zzatl zzb() {
        return this.zze;
    }

    public final zzatl zzc() {
        return this.zzf;
    }

    public final zzatl zzd() {
        return this.zzg;
    }

    final /* synthetic */ void zzg(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zza |= 1;
        this.zzd = zzatlVar;
    }

    final /* synthetic */ void zzh(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zza |= 2;
        this.zze = zzatlVar;
    }

    final /* synthetic */ void zzi(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zza |= 4;
        this.zzf = zzatlVar;
    }

    final /* synthetic */ void zzj(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zza |= 8;
        this.zzg = zzatlVar;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zza", "zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbj();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzbi(bArr);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }
}
