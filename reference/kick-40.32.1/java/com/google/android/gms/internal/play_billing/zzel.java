package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzel extends zzgp implements zzhs {
    private static final zzel zzb;
    private int zzd;
    private zzev zze;
    private zzev zzf;
    private int zzg;

    static {
        zzel zzelVar = new zzel();
        zzb = zzelVar;
        zzgp.zzB(zzel.class, zzelVar);
    }

    private zzel() {
    }

    public static zzek zza() {
        return (zzek) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzel zzelVar, zzev zzevVar) {
        zzevVar.getClass();
        zzelVar.zze = zzevVar;
        zzelVar.zzd |= 1;
    }

    static /* synthetic */ void zze(zzel zzelVar, zzev zzevVar) {
        zzevVar.getClass();
        zzelVar.zzf = zzevVar;
        zzelVar.zzd |= 2;
    }

    static /* synthetic */ void zzf(zzel zzelVar, int i) {
        zzelVar.zzg = i - 1;
        zzelVar.zzd |= 4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzey.zza()});
        }
        if (i2 == 3) {
            return new zzel();
        }
        zzeo zzeoVar = null;
        if (i2 == 4) {
            return new zzek(zzeoVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
