package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhe extends zzadu implements zzafd {
    private static final zzhe zzl;
    private static volatile zzafj zzm;
    private int zzb;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        zzhe zzheVar = new zzhe();
        zzl = zzheVar;
        zzadu.zzcs(zzhe.class, zzheVar);
    }

    private zzhe() {
    }

    public static zzhd zzi() {
        return (zzhd) zzl.zzcn();
    }

    public static zzhe zzj() {
        return zzl;
    }

    public final boolean zza() {
        return this.zze;
    }

    public final boolean zzb() {
        return this.zzf;
    }

    public final boolean zzc() {
        return this.zzg;
    }

    public final boolean zzd() {
        return this.zzh;
    }

    public final boolean zze() {
        return this.zzi;
    }

    public final boolean zzf() {
        return this.zzj;
    }

    public final boolean zzh() {
        return this.zzk;
    }

    final /* synthetic */ void zzk(boolean z) {
        this.zzb |= 1;
        this.zze = z;
    }

    final /* synthetic */ void zzl(boolean z) {
        this.zzb |= 2;
        this.zzf = z;
    }

    final /* synthetic */ void zzm(boolean z) {
        this.zzb |= 4;
        this.zzg = z;
    }

    final /* synthetic */ void zzn(boolean z) {
        this.zzb |= 8;
        this.zzh = z;
    }

    final /* synthetic */ void zzo(boolean z) {
        this.zzb |= 16;
        this.zzi = z;
    }

    final /* synthetic */ void zzp(boolean z) {
        this.zzb |= 32;
        this.zzj = z;
    }

    final /* synthetic */ void zzq(boolean z) {
        this.zzb |= 64;
        this.zzk = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    protected final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzct(zzl, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzhe();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzhd(bArr);
        }
        if (i2 == 5) {
            return zzl;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzm;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zzhe.class) {
            zzadqVar = zzm;
            if (zzadqVar == null) {
                zzadqVar = new zzadq(zzl);
                zzm = zzadqVar;
            }
        }
        return zzadqVar;
    }
}
