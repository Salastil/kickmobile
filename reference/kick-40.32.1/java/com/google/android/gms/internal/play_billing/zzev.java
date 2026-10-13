package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzev extends zzgp implements zzhs {
    private static final zzev zzb;
    private int zzd;
    private String zze = "";

    static {
        zzev zzevVar = new zzev();
        zzb = zzevVar;
        zzgp.zzB(zzev.class, zzevVar);
    }

    private zzev() {
    }

    public static zzeu zza() {
        return (zzeu) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzev zzevVar, String str) {
        zzevVar.zzd |= 1;
        zzevVar.zze = str;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzev();
        }
        zzew zzewVar = null;
        if (i2 == 4) {
            return new zzeu(zzewVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
