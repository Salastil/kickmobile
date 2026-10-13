package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkd extends zzgp implements zzhs {
    private static final zzkd zzb;
    private int zzd;
    private int zzf;
    private zzju zzi;
    private boolean zzj;
    private boolean zzk;
    private zzld zzl;
    private String zze = "";
    private zzgt zzg = zzu();
    private zzgu zzh = zzv();

    static {
        zzkd zzkdVar = new zzkd();
        zzb = zzkdVar;
        zzgp.zzB(zzkd.class, zzkdVar);
    }

    private zzkd() {
    }

    public static zzka zza() {
        return (zzka) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzkd zzkdVar, zzjz zzjzVar) {
        zzjzVar.getClass();
        zzgt zzgtVar = zzkdVar.zzg;
        if (!zzgtVar.zzc()) {
            int size = zzgtVar.size();
            zzkdVar.zzg = zzgtVar.zzd(size + size);
        }
        zzkdVar.zzg.zzh(zzjzVar.zza());
    }

    static /* synthetic */ void zze(zzkd zzkdVar, zzju zzjuVar) {
        zzjuVar.getClass();
        zzkdVar.zzi = zzjuVar;
        zzkdVar.zzd |= 4;
    }

    static /* synthetic */ void zzf(zzkd zzkdVar, String str) {
        zzkdVar.zzd |= 1;
        zzkdVar.zze = "ProxyBillingBroadcastReceiver";
    }

    static /* synthetic */ void zzg(zzkd zzkdVar, zzld zzldVar) {
        zzldVar.getClass();
        zzkdVar.zzl = zzldVar;
        zzkdVar.zzd |= 32;
    }

    static /* synthetic */ void zzh(zzkd zzkdVar, int i) {
        zzkdVar.zzf = i - 1;
        zzkdVar.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001b\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004\bဉ\u0005", new Object[]{"zzd", "zze", "zzf", zzkb.zza, "zzg", zzjy.zza, "zzh", zzkz.class, "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzkd();
        }
        zzkc zzkcVar = null;
        if (i2 == 4) {
            return new zzka(zzkcVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
