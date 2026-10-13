package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbl extends zzaun implements zzavx {
    private static final zzbl zzg;
    private int zza;
    private long zzd;
    private long zze;
    private long zzf;

    static {
        zzbl zzblVar = new zzbl();
        zzg = zzblVar;
        zzaun.zzaD(zzbl.class, zzblVar);
    }

    private zzbl() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbl();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzbk(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
