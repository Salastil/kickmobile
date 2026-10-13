package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbs extends zzaun implements zzavx {
    private static final zzbs zzg;
    private int zza;
    private long zzd;
    private String zze = "";
    private zzatl zzf = zzatl.zza;

    static {
        zzbs zzbsVar = new zzbs();
        zzg = zzbsVar;
        zzaun.zzaD(zzbs.class, zzbsVar);
    }

    private zzbs() {
    }

    public static zzbs zze() {
        return zzg;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final long zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zze;
    }

    public final zzatl zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbs();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzbr(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
