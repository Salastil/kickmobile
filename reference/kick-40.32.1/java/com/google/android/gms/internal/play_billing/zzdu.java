package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdu extends zzgp implements zzhs {
    private static final zzdu zzb;
    private int zzd;
    private int zze;
    private boolean zzf;

    static {
        zzdu zzduVar = new zzdu();
        zzb = zzduVar;
        zzgp.zzB(zzdu.class, zzduVar);
    }

    private zzdu() {
    }

    public static zzdu zzb() {
        return zzb;
    }

    public final boolean zzc() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzdu();
        }
        zzdt zzdtVar = null;
        if (i2 == 4) {
            return new zzds(zzdtVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }

    public final int zze() {
        int i = this.zze;
        int i2 = 2;
        if (i != 0) {
            if (i != 1) {
                i2 = i != 2 ? 0 : 4;
            } else {
                i2 = 3;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
