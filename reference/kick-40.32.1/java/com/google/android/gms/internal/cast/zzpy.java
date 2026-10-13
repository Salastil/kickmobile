package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpy extends zzyd implements zzzj {
    private static final zzpy zzi;
    private int zzb;
    private int zzd;
    private double zze;
    private double zzf;
    private double zzg;
    private double zzh;

    static {
        zzpy zzpyVar = new zzpy();
        zzi = zzpyVar;
        zzyd.zzG(zzpy.class, zzpyVar);
    }

    private zzpy() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဋ\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005က\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzpy();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzpx(bArr);
        }
        if (i2 == 5) {
            return zzi;
        }
        throw null;
    }
}
