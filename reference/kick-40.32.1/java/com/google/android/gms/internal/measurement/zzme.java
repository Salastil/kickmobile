package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzme extends zzadu implements zzafd {
    private static final zzme zzh;
    private static volatile zzafj zzi;
    private int zzb;
    private zzmd zzf;
    private String zze = "";
    private String zzg = "";

    static {
        zzme zzmeVar = new zzme();
        zzh = zzmeVar;
        zzadu.zzcs(zzme.class, zzmeVar);
    }

    private zzme() {
    }

    public static zzmb zzb() {
        return (zzmb) zzh.zzcn();
    }

    public final String zza() {
        return this.zze;
    }

    final /* synthetic */ void zzc(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    final /* synthetic */ void zzd(zzmd zzmdVar) {
        zzmdVar.getClass();
        this.zzf = zzmdVar;
        this.zzb |= 2;
    }

    final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzg = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    protected final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzct(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003ဈ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzme();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzmb(bArr);
        }
        if (i2 == 5) {
            return zzh;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzi;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zzme.class) {
            zzadqVar = zzi;
            if (zzadqVar == null) {
                zzadqVar = new zzadq(zzh);
                zzi = zzadqVar;
            }
        }
        return zzadqVar;
    }
}
