package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzmd extends zzadu implements zzafd {
    private static final zzmd zzg;
    private static volatile zzafj zzh;
    private int zzb;
    private int zze;
    private int zzf;

    static {
        zzmd zzmdVar = new zzmd();
        zzg = zzmdVar;
        zzadu.zzcs(zzmd.class, zzmdVar);
    }

    private zzmd() {
    }

    public static zzmc zza() {
        return (zzmc) zzg.zzcn();
    }

    public static zzmd zzb() {
        return zzg;
    }

    final /* synthetic */ void zzd(int i) {
        this.zze = i - 2;
        this.zzb |= 1;
    }

    final /* synthetic */ void zze(int i) {
        if (i == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        this.zzf = i - 2;
        this.zzb |= 2;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    protected final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzct(zzg, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzb", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzmd();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzmc(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzh;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zzmd.class) {
            zzadqVar = zzh;
            if (zzadqVar == null) {
                zzadqVar = new zzadq(zzg);
                zzh = zzadqVar;
            }
        }
        return zzadqVar;
    }
}
