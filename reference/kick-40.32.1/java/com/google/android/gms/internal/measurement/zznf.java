package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zznf extends zzadu implements zzafd {
    private static final zznf zzf;
    private static volatile zzafj zzg;
    private int zzb;
    private boolean zze;

    static {
        zznf zznfVar = new zznf();
        zzf = zznfVar;
        zzadu.zzcs(zznf.class, zznfVar);
    }

    private zznf() {
    }

    public static zznf zzb() {
        return zzf;
    }

    public final boolean zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    protected final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzct(zzf, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zzb", "zze"});
        }
        if (i2 == 3) {
            return new zznf();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzne(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzg;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zznf.class) {
            zzadqVar = zzg;
            if (zzadqVar == null) {
                zzadqVar = new zzadq(zzf);
                zzg = zzadqVar;
            }
        }
        return zzadqVar;
    }
}
