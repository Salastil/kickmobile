package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrz extends zzyd implements zzzj {
    private static final zzrz zzk;
    private int zzb;
    private int zzd;
    private int zze;
    private zzyj zzf = zzJ();
    private zzyj zzg = zzJ();
    private zzyl zzh = zzyd.zzM();
    private zzyl zzi = zzyd.zzM();
    private int zzj;

    static {
        zzrz zzrzVar = new zzrz();
        zzk = zzrzVar;
        zzyd.zzG(zzrz.class, zzrzVar);
    }

    private zzrz() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001င\u0000\u0002᠌\u0001\u0003\u0016\u0004\u0016\u0005\u001a\u0006\u001a\u0007᠌\u0002", new Object[]{"zzb", "zzd", "zze", zzmq.zza(), "zzf", "zzg", "zzh", "zzi", "zzj", zzmi.zza()});
        }
        if (i2 == 3) {
            return new zzrz();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzry(bArr);
        }
        if (i2 == 5) {
            return zzk;
        }
        throw null;
    }
}
