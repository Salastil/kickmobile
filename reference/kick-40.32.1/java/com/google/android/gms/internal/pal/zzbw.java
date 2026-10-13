package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbw extends zzaun implements zzavx {
    private static final zzbw zzh;
    private int zza;
    private zzauy zzd = zzaJ();
    private zzatl zze = zzatl.zza;
    private int zzf = 1;
    private int zzg = 1;

    static {
        zzbw zzbwVar = new zzbw();
        zzh = zzbwVar;
        zzaun.zzaD(zzbw.class, zzbwVar);
    }

    private zzbw() {
    }

    public static zzbv zza() {
        return (zzbv) zzh.zzay();
    }

    final /* synthetic */ void zzb(zzatl zzatlVar) {
        zzatlVar.getClass();
        zzauy zzauyVar = this.zzd;
        if (!zzauyVar.zza()) {
            this.zzd = zzaun.zzaK(zzauyVar);
        }
        this.zzd.add(zzatlVar);
    }

    final /* synthetic */ void zzc(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zza |= 1;
        this.zze = zzatlVar;
    }

    final /* synthetic */ void zze(int i) {
        this.zzf = 4;
        this.zza |= 2;
    }

    final /* synthetic */ void zzf(int i) {
        this.zzg = i - 1;
        this.zza |= 4;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zza", "zzd", "zze", "zzf", zzbq.zza, "zzg", zzbm.zza});
        }
        if (i2 == 3) {
            return new zzbw();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzbv(bArr);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }
}
