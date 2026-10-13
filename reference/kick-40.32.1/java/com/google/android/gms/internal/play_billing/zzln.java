package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzln extends zzgp implements zzhs {
    private static final zzln zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private long zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;

    static {
        zzln zzlnVar = new zzln();
        zzb = zzlnVar;
        zzgp.zzB(zzln.class, zzlnVar);
    }

    private zzln() {
    }

    public static zzll zza() {
        return (zzll) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzln zzlnVar, boolean z) {
        zzlnVar.zzd |= 8;
        zzlnVar.zzh = z;
    }

    static /* synthetic */ void zze(zzln zzlnVar, int i) {
        zzlnVar.zzd |= 16;
        zzlnVar.zzi = i;
    }

    static /* synthetic */ void zzf(zzln zzlnVar, long j) {
        zzlnVar.zzd |= 4;
        zzlnVar.zzg = j;
    }

    static /* synthetic */ void zzg(zzln zzlnVar, int i) {
        zzlnVar.zzd |= 32;
        zzlnVar.zzj = i;
    }

    static /* synthetic */ void zzh(zzln zzlnVar, boolean z) {
        zzlnVar.zzd |= 2;
        zzlnVar.zzf = true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003ဂ\u0002\u0004ဇ\u0003\u0005င\u0004\u0006င\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzln();
        }
        zzlm zzlmVar = null;
        if (i2 == 4) {
            return new zzll(zzlmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
