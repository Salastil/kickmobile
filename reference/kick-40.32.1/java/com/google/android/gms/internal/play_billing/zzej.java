package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzej extends zzgp implements zzhs {
    private static final zzej zzb;
    private int zzd;
    private int zze;
    private zzdu zzf;

    static {
        zzej zzejVar = new zzej();
        zzb = zzejVar;
        zzgp.zzB(zzej.class, zzejVar);
    }

    private zzej() {
    }

    public static zzej zzc(byte[] bArr) throws zzhb {
        return (zzej) zzgp.zzt(zzb, bArr);
    }

    public final zzdu zza() {
        zzdu zzduVar = this.zzf;
        return zzduVar == null ? zzdu.zzb() : zzduVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzej();
        }
        zzei zzeiVar = null;
        if (i2 == 4) {
            return new zzeh(zzeiVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }

    public final boolean zze() {
        return (this.zzd & 2) != 0;
    }
}
