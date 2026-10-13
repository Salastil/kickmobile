package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbu extends zzaun implements zzavx {
    private static final zzbu zze;
    private int zza;
    private String zzd = "";

    static {
        zzbu zzbuVar = new zzbu();
        zze = zzbuVar;
        zzaun.zzaD(zzbu.class, zzbuVar);
    }

    private zzbu() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zza", "zzd"});
        }
        if (i2 == 3) {
            return new zzbu();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzbt(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
