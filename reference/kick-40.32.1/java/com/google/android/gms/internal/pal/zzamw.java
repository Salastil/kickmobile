package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzamw extends zzaun implements zzavx {
    private static final zzamw zze;
    private int zza;
    private int zzd;

    static {
        zzamw zzamwVar = new zzamw();
        zze = zzamwVar;
        zzaun.zzaD(zzamw.class, zzamwVar);
    }

    private zzamw() {
    }

    public static zzamw zzc(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzamw) zzaun.zzaM(zze, zzatlVar, zzatyVar);
    }

    public static zzamv zzd() {
        return (zzamv) zze.zzay();
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
            return zzaE(zze, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zza", "zzd"});
        }
        if (i2 == 3) {
            return new zzamw();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzamv(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
