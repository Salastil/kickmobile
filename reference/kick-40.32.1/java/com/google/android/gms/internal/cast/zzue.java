package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzue extends zzyd implements zzzj {
    private static final zzue zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        zzue zzueVar = new zzue();
        zzf = zzueVar;
        zzyd.zzG(zzue.class, zzueVar);
    }

    private zzue() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzue();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzud(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
