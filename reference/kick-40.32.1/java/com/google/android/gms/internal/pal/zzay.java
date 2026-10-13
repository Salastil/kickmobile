package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzay extends zzaun implements zzavx {
    private static final zzay zzf;
    private int zza;
    private long zzd = -1;
    private int zze = 1000;

    static {
        zzay zzayVar = new zzay();
        zzf = zzayVar;
        zzaun.zzaD(zzay.class, zzayVar);
    }

    private zzay() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001", new Object[]{"zza", "zzd", "zze", zzbn.zza});
        }
        if (i2 == 3) {
            return new zzay();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzax(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
