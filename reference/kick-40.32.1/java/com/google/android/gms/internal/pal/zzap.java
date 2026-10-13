package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzap extends zzaun implements zzavx {
    private static final zzap zze;
    private int zza;
    private long zzd = -1;

    static {
        zzap zzapVar = new zzap();
        zze = zzapVar;
        zzaun.zzaD(zzap.class, zzapVar);
    }

    private zzap() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဂ\u0000", new Object[]{"zza", "zzd"});
        }
        if (i2 == 3) {
            return new zzap();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzao(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
