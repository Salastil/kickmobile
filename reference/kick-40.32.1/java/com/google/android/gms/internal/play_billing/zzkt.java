package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkt extends zzgp implements zzhs {
    private static final zzkt zzb;
    private int zzd;
    private zzgu zze = zzv();
    private String zzf = "";
    private boolean zzg;

    static {
        zzkt zzktVar = new zzkt();
        zzb = zzktVar;
        zzgp.zzB(zzkt.class, zzktVar);
    }

    private zzkt() {
    }

    public static zzkt zzb() {
        return zzb;
    }

    static /* synthetic */ void zzc(zzkt zzktVar, boolean z) {
        zzktVar.zzd |= 2;
        zzktVar.zzg = z;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဇ\u0001", new Object[]{"zzd", "zze", zzkr.class, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzkt();
        }
        zzks zzksVar = null;
        if (i2 == 4) {
            return new zzko(zzksVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
