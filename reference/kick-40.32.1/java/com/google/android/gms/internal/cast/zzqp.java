package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqp extends zzyd implements zzzj {
    private static final zzqp zzk;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;

    static {
        zzqp zzqpVar = new zzqp();
        zzk = zzqpVar;
        zzyd.zzG(zzqp.class, zzqpVar);
    }

    private zzqp() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ဇ\u0003\u0005င\u0004\u0006င\u0005\u0007ဇ\u0006", new Object[]{"zzb", "zzd", zznw.zza(), "zze", zzns.zza(), "zzf", zznu.zza(), "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzqp();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzqo(bArr);
        }
        if (i2 == 5) {
            return zzk;
        }
        throw null;
    }
}
