package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrf extends zzyd implements zzzj {
    private static final zzrf zzf;
    private int zzb;
    private String zzd = "";
    private long zze;

    static {
        zzrf zzrfVar = new zzrf();
        zzf = zzrfVar;
        zzyd.zzG(zzrf.class, zzrfVar);
    }

    private zzrf() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzrf();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzre(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
