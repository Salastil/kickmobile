package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqk extends zzyd implements zzzj {
    private static final zzqk zzd;
    private zzyl zzb = zzyd.zzM();

    static {
        zzqk zzqkVar = new zzqk();
        zzd = zzqkVar;
        zzyd.zzG(zzqk.class, zzqkVar);
    }

    private zzqk() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        }
        if (i2 == 3) {
            return new zzqk();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzqj(bArr);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }
}
