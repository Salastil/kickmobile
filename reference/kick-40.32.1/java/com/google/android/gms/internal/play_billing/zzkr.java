package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkr extends zzgp implements zzhs {
    private static final zzkr zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzkr zzkrVar = new zzkr();
        zzb = zzkrVar;
        zzgp.zzB(zzkr.class, zzkrVar);
    }

    private zzkr() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzkq.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzkr();
        }
        zzks zzksVar = null;
        if (i2 == 4) {
            return new zzkp(zzksVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
