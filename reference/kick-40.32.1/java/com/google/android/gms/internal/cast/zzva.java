package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzva extends zzyd implements zzzj {
    private static final zzva zzi;
    private int zzb;
    private int zzd;
    private long zze;
    private zzyl zzf = zzM();
    private zzyl zzg = zzM();
    private zzyl zzh = zzM();

    static {
        zzva zzvaVar = new zzva();
        zzi = zzvaVar;
        zzyd.zzG(zzva.class, zzvaVar);
    }

    private zzva() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003\u001b\u0004\u001b\u0005\u001b", new Object[]{"zzb", "zzd", zzoi.zza(), "zze", "zzf", zzus.class, "zzg", zzqt.class, "zzh", zzuy.class});
        }
        if (i2 == 3) {
            return new zzva();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzuz(bArr);
        }
        if (i2 == 5) {
            return zzi;
        }
        throw null;
    }
}
