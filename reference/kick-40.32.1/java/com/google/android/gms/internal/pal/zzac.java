package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzac extends zzaun implements zzavx {
    private static final zzac zzi;
    private int zza;
    private boolean zze;
    private boolean zzf;
    private long zzd = 100;
    private long zzg = 300;
    private long zzh = 1000;

    static {
        zzac zzacVar = new zzac();
        zzi = zzacVar;
        zzaun.zzaD(zzac.class, zzacVar);
    }

    private zzac() {
    }

    public static zzac zzd() {
        return zzi;
    }

    public final long zza() {
        return this.zzd;
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final long zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005ဂ\u0004", new Object[]{"zza", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzac();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzab(bArr);
        }
        if (i2 == 5) {
            return zzi;
        }
        throw null;
    }
}
