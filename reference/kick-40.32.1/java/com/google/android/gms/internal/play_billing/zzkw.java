package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkw extends zzgp implements zzhs {
    private static final zzkw zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private zzkg zzg;
    private zzkj zzh;

    static {
        zzkw zzkwVar = new zzkw();
        zzb = zzkwVar;
        zzgp.zzB(zzkw.class, zzkwVar);
    }

    private zzkw() {
    }

    static /* synthetic */ void zzG(zzkw zzkwVar, zzlg zzlgVar) {
        zzlgVar.getClass();
        zzkwVar.zzf = zzlgVar;
        zzkwVar.zze = 8;
    }

    static /* synthetic */ void zzH(zzkw zzkwVar, zzlk zzlkVar) {
        zzkwVar.zzf = zzlkVar;
        zzkwVar.zze = 4;
    }

    public static zzku zza() {
        return (zzku) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzkw zzkwVar, zzjl zzjlVar) {
        zzkwVar.zzf = zzjlVar;
        zzkwVar.zze = 2;
    }

    static /* synthetic */ void zze(zzkw zzkwVar, zzjp zzjpVar) {
        zzkwVar.zzf = zzjpVar;
        zzkwVar.zze = 3;
    }

    static /* synthetic */ void zzf(zzkw zzkwVar, zzjx zzjxVar) {
        zzjxVar.getClass();
        zzkwVar.zzf = zzjxVar;
        zzkwVar.zze = 7;
    }

    static /* synthetic */ void zzg(zzkw zzkwVar, zzkd zzkdVar) {
        zzkdVar.getClass();
        zzkwVar.zzf = zzkdVar;
        zzkwVar.zze = 5;
    }

    static /* synthetic */ void zzh(zzkw zzkwVar, zzkg zzkgVar) {
        zzkgVar.getClass();
        zzkwVar.zzg = zzkgVar;
        zzkwVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001\u0007<\u0000\b<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzjl.class, zzjp.class, zzlk.class, zzkd.class, "zzh", zzjx.class, zzlg.class});
        }
        if (i2 == 3) {
            return new zzkw();
        }
        zzkv zzkvVar = null;
        if (i2 == 4) {
            return new zzku(zzkvVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
