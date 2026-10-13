package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzlg extends zzgp implements zzhs {
    private static final zzlg zzb;
    private int zzd;
    private zzju zze;
    private long zzf;

    static {
        zzlg zzlgVar = new zzlg();
        zzb = zzlgVar;
        zzgp.zzB(zzlg.class, zzlgVar);
    }

    private zzlg() {
    }

    public static zzle zza() {
        return (zzle) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzlg zzlgVar, zzju zzjuVar) {
        zzjuVar.getClass();
        zzlgVar.zze = zzjuVar;
        zzlgVar.zzd |= 1;
    }

    static /* synthetic */ void zze(zzlg zzlgVar, long j) {
        zzlgVar.zzd |= 2;
        zzlgVar.zzf = j;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzlg();
        }
        zzlf zzlfVar = null;
        if (i2 == 4) {
            return new zzle(zzlfVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
