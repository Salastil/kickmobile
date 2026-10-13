package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrb extends zzyd implements zzzj {
    private static final zzrb zzh;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzrb zzrbVar = new zzrb();
        zzh = zzrbVar;
        zzyd.zzG(zzrb.class, zzrbVar);
    }

    private zzrb() {
    }

    public static zzra zza() {
        return (zzra) zzh.zzB();
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzb", "zzd", zzou.zza(), "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzrb();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzra(bArr);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }

    final /* synthetic */ void zzc(int i) {
        this.zzb |= 2;
        this.zze = i;
    }

    final /* synthetic */ void zzd(int i) {
        this.zzb |= 4;
        this.zzf = i;
    }

    final /* synthetic */ void zze(int i) {
        this.zzb |= 8;
        this.zzg = i;
    }

    final /* synthetic */ void zzg(int i) {
        this.zzd = i - 1;
        this.zzb |= 1;
    }
}
