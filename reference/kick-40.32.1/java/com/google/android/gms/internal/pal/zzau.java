package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzau extends zzaun implements zzavx {
    private static final zzau zzf;
    private int zza;
    private int zzd;
    private long zze = -1;

    static {
        zzau zzauVar = new zzau();
        zzf = zzauVar;
        zzaun.zzaD(zzau.class, zzauVar);
    }

    private zzau() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zza", "zzd", zzah.zza, "zze"});
        }
        if (i2 == 3) {
            return new zzau();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzat(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
