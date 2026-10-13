package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdx extends zzgp implements zzhs {
    private static final zzdx zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzdx zzdxVar = new zzdx();
        zzb = zzdxVar;
        zzgp.zzB(zzdx.class, zzdxVar);
    }

    private zzdx() {
    }

    public static zzdx zzb(byte[] bArr) throws zzhb {
        return (zzdx) zzgp.zzt(zzb, bArr);
    }

    public final zzeg zzc() {
        return this.zzd == 2 ? (zzeg) this.zze : zzeg.zzb();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001;\u0000\u0002<\u0000", new Object[]{"zze", "zzd", zzeg.class});
        }
        if (i2 == 3) {
            return new zzdx();
        }
        zzdw zzdwVar = null;
        if (i2 == 4) {
            return new zzdv(zzdwVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
