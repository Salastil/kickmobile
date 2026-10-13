package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzapq extends zzaun implements zzavx {
    private static final zzapq zzg;
    private int zza;
    private int zzd;
    private zzapu zze;
    private zzatl zzf = zzatl.zza;

    static {
        zzapq zzapqVar = new zzapq();
        zzg = zzapqVar;
        zzaun.zzaD(zzapq.class, zzapqVar);
    }

    private zzapq() {
    }

    public static zzapq zzd(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzapq) zzaun.zzaM(zzg, zzatlVar, zzatyVar);
    }

    public static zzapp zze() {
        return (zzapp) zzg.zzay();
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzapu zzb() {
        zzapu zzapuVar = this.zze;
        return zzapuVar == null ? zzapu.zzc() : zzapuVar;
    }

    public final zzatl zzc() {
        return this.zzf;
    }

    final /* synthetic */ void zzf(zzapu zzapuVar) {
        zzapuVar.getClass();
        this.zze = zzapuVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzg(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zzf = zzatlVar;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzapq();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzapp(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
