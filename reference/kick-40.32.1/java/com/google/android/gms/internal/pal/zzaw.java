package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaw extends zzaun implements zzavx {
    private static final zzaw zzg;
    private int zza;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;

    static {
        zzaw zzawVar = new zzaw();
        zzg = zzawVar;
        zzaun.zzaD(zzaw.class, zzawVar);
    }

    private zzaw() {
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
            return new zzaw();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzav(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
