package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjx extends zzgp implements zzhs {
    private static final zzjx zzb;

    static {
        zzjx zzjxVar = new zzjx();
        zzb = zzjxVar;
        zzgp.zzB(zzjx.class, zzjxVar);
    }

    private zzjx() {
    }

    public static zzjx zzb() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzjw zzjwVar = null;
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0000", null);
        }
        if (i2 == 3) {
            return new zzjx();
        }
        if (i2 == 4) {
            return new zzjv(zzjwVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
