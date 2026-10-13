package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzea extends zzgp implements zzhs {
    private static final zzea zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzea zzeaVar = new zzea();
        zzb = zzeaVar;
        zzgp.zzB(zzea.class, zzeaVar);
    }

    private zzea() {
    }

    public static zzea zzb(byte[] bArr) throws zzhb {
        return (zzea) zzgp.zzt(zzb, bArr);
    }

    public final String zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzea();
        }
        zzdz zzdzVar = null;
        if (i2 == 4) {
            return new zzdy(zzdzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }

    public final String zze() {
        return this.zzf;
    }
}
