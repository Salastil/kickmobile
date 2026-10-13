package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaps extends zzaun implements zzavx {
    private static final zzaps zzf;
    private int zza;
    private int zzd;
    private zzapu zze;

    static {
        zzaps zzapsVar = new zzaps();
        zzf = zzapsVar;
        zzaun.zzaD(zzaps.class, zzapsVar);
    }

    private zzaps() {
    }

    public static zzaps zzc(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzaps) zzaun.zzaM(zzf, zzatlVar, zzatyVar);
    }

    public static zzapr zzd() {
        return (zzapr) zzf.zzay();
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzapu zzb() {
        zzapu zzapuVar = this.zze;
        return zzapuVar == null ? zzapu.zzc() : zzapuVar;
    }

    final /* synthetic */ void zze(zzapu zzapuVar) {
        zzapuVar.getClass();
        this.zze = zzapuVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0000\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003ဉ\u0000", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzaps();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzapr(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
