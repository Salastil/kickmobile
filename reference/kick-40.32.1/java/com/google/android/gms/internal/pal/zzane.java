package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzane extends zzaun implements zzavx {
    private static final zzane zze;
    private int zza;
    private int zzd;

    static {
        zzane zzaneVar = new zzane();
        zze = zzaneVar;
        zzaun.zzaD(zzane.class, zzaneVar);
    }

    private zzane() {
    }

    public static zzane zzc(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzane) zzaun.zzaM(zze, zzatlVar, zzatyVar);
    }

    public static zzand zzd() {
        return (zzand) zze.zzay();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzd;
    }

    final /* synthetic */ void zze(int i) {
        this.zza = i;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zza", "zzd"});
        }
        if (i2 == 3) {
            return new zzane();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzand(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
