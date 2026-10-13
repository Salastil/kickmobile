package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaaz extends zzyd implements zzzj {
    private static final zzaaz zzg;
    private zzyl zzb = zzM();
    private zzyl zzd = zzM();
    private zzyl zze = zzM();
    private zzyl zzf = zzM();

    static {
        zzaaz zzaazVar = new zzaaz();
        zzg = zzaazVar;
        zzyd.zzG(zzaaz.class, zzaazVar);
    }

    private zzaaz() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b", new Object[]{"zzb", zzaax.class, "zzd", zzaat.class, "zze", zzaax.class, "zzf", zzaat.class});
        }
        if (i2 == 3) {
            return new zzaaz();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaay(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
