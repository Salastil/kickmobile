package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkn extends zzgp implements zzhs {
    private static final zzkn zzb;
    private int zzd;
    private int zze;

    static {
        zzkn zzknVar = new zzkn();
        zzb = zzknVar;
        zzgp.zzB(zzkn.class, zzknVar);
    }

    private zzkn() {
    }

    public static zzkk zza() {
        return (zzkk) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzkn zzknVar, int i) {
        zzknVar.zze = i - 1;
        zzknVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzkl.zza});
        }
        if (i2 == 3) {
            return new zzkn();
        }
        zzkm zzkmVar = null;
        if (i2 == 4) {
            return new zzkk(zzkmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
