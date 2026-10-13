package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzen extends zzgp implements zzhs {
    private static final zzen zzb;
    private zzgu zzd = zzv();

    static {
        zzen zzenVar = new zzen();
        zzb = zzenVar;
        zzgp.zzB(zzen.class, zzenVar);
    }

    private zzen() {
    }

    public static zzem zza() {
        return (zzem) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzen zzenVar, Iterable iterable) {
        zzgu zzguVar = zzenVar.zzd;
        if (!zzguVar.zzc()) {
            int size = zzguVar.size();
            zzenVar.zzd = zzguVar.zzd(size + size);
        }
        zzfa.zzk(iterable, zzenVar.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzel.class});
        }
        if (i2 == 3) {
            return new zzen();
        }
        zzeo zzeoVar = null;
        if (i2 == 4) {
            return new zzem(zzeoVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
