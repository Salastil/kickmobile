package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaat extends zzyd implements zzzj {
    private static final zzaat zzg;
    private int zzb;
    private zzabb zzd;
    private int zze;
    private int zzf;

    static {
        zzaat zzaatVar = new zzaat();
        zzg = zzaatVar;
        zzyd.zzG(zzaat.class, zzaatVar);
    }

    private zzaat() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", "zze", zzaas.zza, "zzf", zzaar.zza});
        }
        if (i2 == 3) {
            return new zzaat();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaaq(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
