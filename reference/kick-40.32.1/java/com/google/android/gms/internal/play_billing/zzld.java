package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzld extends zzgp implements zzhs {
    private static final zzld zzb;
    private int zzd;
    private int zze;

    static {
        zzld zzldVar = new zzld();
        zzb = zzldVar;
        zzgp.zzB(zzld.class, zzldVar);
    }

    private zzld() {
    }

    public static zzla zza() {
        return (zzla) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzld zzldVar, int i) {
        zzldVar.zze = i - 1;
        zzldVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzlb.zza});
        }
        if (i2 == 3) {
            return new zzld();
        }
        zzlc zzlcVar = null;
        if (i2 == 4) {
            return new zzla(zzlcVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
