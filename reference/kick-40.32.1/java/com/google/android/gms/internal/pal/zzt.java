package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzt extends zzaun implements zzavx {
    private static final zzt zzf;
    private int zza;
    private zzv zzd;
    private zzy zze;

    static {
        zzt zztVar = new zzt();
        zzf = zztVar;
        zzaun.zzaD(zzt.class, zztVar);
    }

    private zzt() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzt();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzs(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
