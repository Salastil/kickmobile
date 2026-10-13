package com.google.android.gms.internal.play_billing;

import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzim extends zzgp implements zzhs {
    private static final zzim zzb;
    private zzhm zzd = zzhm.zza();

    static {
        zzim zzimVar = new zzim();
        zzb = zzimVar;
        zzgp.zzB(zzim.class, zzimVar);
    }

    private zzim() {
    }

    public static zzij zza() {
        return (zzij) zzb.zzp();
    }

    static /* synthetic */ Map zzc(zzim zzimVar) {
        if (!zzimVar.zzd.zze()) {
            zzimVar.zzd = zzimVar.zzd.zzb();
        }
        return zzimVar.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzia(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"zzd", zzik.zza});
        }
        if (i2 == 3) {
            return new zzim();
        }
        zzil zzilVar = null;
        if (i2 == 4) {
            return new zzij(zzilVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
