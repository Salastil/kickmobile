package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzed extends zzgp implements zzhs {
    private static final zzed zzb;
    private int zzd;
    private String zze = "";

    static {
        zzed zzedVar = new zzed();
        zzb = zzedVar;
        zzgp.zzB(zzed.class, zzedVar);
    }

    private zzed() {
    }

    public static zzed zzb(byte[] bArr) throws zzhb {
        return (zzed) zzgp.zzt(zzb, bArr);
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
            return zzy(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzed();
        }
        zzec zzecVar = null;
        if (i2 == 4) {
            return new zzeb(zzecVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
