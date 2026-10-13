package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkj extends zzgp implements zzhs {
    private static final zzkj zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzkj zzkjVar = new zzkj();
        zzb = zzkjVar;
        zzgp.zzB(zzkj.class, zzkjVar);
    }

    private zzkj() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzkj();
        }
        zzki zzkiVar = null;
        if (i2 == 4) {
            return new zzkh(zzkiVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
