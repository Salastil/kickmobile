package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhi extends zzgp implements zzhs {
    private static final zzhi zzb;
    private zzgu zzd = zzhz.zze();

    static {
        zzhi zzhiVar = new zzhi();
        zzb = zzhiVar;
        zzgp.zzB(zzhi.class, zzhiVar);
    }

    private zzhi() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzia(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzjf.class});
        }
        if (i2 == 3) {
            return new zzhi();
        }
        zzhh zzhhVar = null;
        if (i2 == 4) {
            return new zzhg(zzhhVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
