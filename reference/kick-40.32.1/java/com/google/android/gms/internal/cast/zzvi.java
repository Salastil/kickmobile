package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzvi extends zzyd implements zzzj {
    private static final zzvi zzh;
    private int zzb;
    private int zzd;
    private zzyl zze = zzM();
    private zzyl zzf = zzM();
    private int zzg;

    static {
        zzvi zzviVar = new zzvi();
        zzh = zzviVar;
        zzyd.zzG(zzvi.class, zzviVar);
    }

    private zzvi() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001b\u0003\u001b\u0004င\u0001", new Object[]{"zzb", "zzd", zzpc.zza(), "zze", zztl.class, "zzf", zztl.class, "zzg"});
        }
        if (i2 == 3) {
            return new zzvi();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzvh(bArr);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }
}
