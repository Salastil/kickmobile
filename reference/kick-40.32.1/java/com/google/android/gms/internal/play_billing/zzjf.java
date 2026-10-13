package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjf extends zzgp implements zzhs {
    private static final zzjf zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzjf zzjfVar = new zzjf();
        zzb = zzjfVar;
        zzgp.zzB(zzjf.class, zzjfVar);
    }

    private zzjf() {
    }

    public static zzjd zza() {
        return (zzjd) zzb.zzp();
    }

    public static zzjf zzc() {
        return zzb;
    }

    static /* synthetic */ void zze(zzjf zzjfVar, String str) {
        str.getClass();
        zzjfVar.zzd = 3;
        zzjfVar.zze = str;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzia(zzb, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"zze", "zzd", zzim.class, zzhi.class});
        }
        if (i2 == 3) {
            return new zzjf();
        }
        zzje zzjeVar = null;
        if (i2 == 4) {
            return new zzjd(zzjeVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
