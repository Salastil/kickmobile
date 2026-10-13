package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbh extends zzaun implements zzavx {
    private static final zzbh zze;
    private zzaux zza = zzaI();
    private zzaux zzd = zzaI();

    static {
        zzbh zzbhVar = new zzbh();
        zze = zzbhVar;
        zzaun.zzaD(zzbh.class, zzbhVar);
    }

    private zzbh() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001%\u0002%", new Object[]{"zza", "zzd"});
        }
        if (i2 == 3) {
            return new zzbh();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzbg(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
