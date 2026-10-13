package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpu extends zzyd implements zzzj {
    private static final zzpu zzg;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private zzyj zzf = zzJ();

    static {
        zzpu zzpuVar = new zzpu();
        zzg = zzpuVar;
        zzyd.zzG(zzpu.class, zzpuVar);
    }

    private zzpu() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ࠞ", new Object[]{"zzb", "zzd", "zze", "zzf", zzpm.zzb()});
        }
        if (i2 == 3) {
            return new zzpu();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzpt(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
