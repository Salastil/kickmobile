package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzag extends zzaun implements zzavx {
    private static final zzag zze;
    private int zza;
    private int zzd;

    static {
        zzag zzagVar = new zzag();
        zze = zzagVar;
        zzaun.zzaD(zzag.class, zzagVar);
    }

    private zzag() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zza", "zzd", zzaj.zza});
        }
        if (i2 == 3) {
            return new zzag();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaf(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
