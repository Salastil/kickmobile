package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkz extends zzgp implements zzhs {
    private static final zzkz zzb;
    private int zzd;
    private int zzf;
    private zzgu zze = zzv();
    private String zzg = "";

    static {
        zzkz zzkzVar = new zzkz();
        zzb = zzkzVar;
        zzgp.zzB(zzkz.class, zzkzVar);
    }

    private zzkz() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzkz();
        }
        zzky zzkyVar = null;
        if (i2 == 4) {
            return new zzkx(zzkyVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
