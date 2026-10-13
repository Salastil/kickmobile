package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabb extends zzyd implements zzzj {
    private static final zzabb zzd;
    private zzyl zzb = zzM();

    static {
        zzabb zzabbVar = new zzabb();
        zzd = zzabbVar;
        zzyd.zzG(zzabb.class, zzabbVar);
    }

    private zzabb() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzabd.class});
        }
        if (i2 == 3) {
            return new zzabb();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaba(bArr);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }
}
