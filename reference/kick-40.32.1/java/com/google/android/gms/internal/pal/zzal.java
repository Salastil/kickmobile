package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzal extends zzaun implements zzavx {
    private static final zzal zzh;
    private int zza;
    private int zzd = 1000;
    private int zze = 1000;
    private int zzf = 1000;
    private int zzg = 1000;

    static {
        zzal zzalVar = new zzal();
        zzh = zzalVar;
        zzaun.zzaD(zzal.class, zzalVar);
    }

    private zzal() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzaus zzausVar = zzbn.zza;
            return zzaE(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003", new Object[]{"zza", "zzd", zzausVar, "zze", zzausVar, "zzf", zzausVar, "zzg", zzausVar});
        }
        if (i2 == 3) {
            return new zzal();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzak(bArr);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }
}
