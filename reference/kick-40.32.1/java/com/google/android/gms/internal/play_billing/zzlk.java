package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzlk extends zzgp implements zzhs {
    private static final zzlk zzb;
    private int zzd;
    private int zze;

    static {
        zzlk zzlkVar = new zzlk();
        zzb = zzlkVar;
        zzgp.zzB(zzlk.class, zzlkVar);
    }

    private zzlk() {
    }

    public static zzlk zzb() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzli.zza});
        }
        if (i2 == 3) {
            return new zzlk();
        }
        zzlj zzljVar = null;
        if (i2 == 4) {
            return new zzlh(zzljVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
