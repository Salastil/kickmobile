package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeg extends zzgp implements zzhs {
    private static final zzeg zzb;
    private int zzd;
    private String zze = "";

    static {
        zzeg zzegVar = new zzeg();
        zzb = zzegVar;
        zzgp.zzB(zzeg.class, zzegVar);
    }

    private zzeg() {
    }

    public static zzeg zzb() {
        return zzb;
    }

    public final String zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzeg();
        }
        zzef zzefVar = null;
        if (i2 == 4) {
            return new zzee(zzefVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
