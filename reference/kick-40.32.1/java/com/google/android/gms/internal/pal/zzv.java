package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzv extends zzaun implements zzavx {
    private static final zzv zze;
    private int zza;
    private int zzd = 2;

    static {
        zzv zzvVar = new zzv();
        zze = zzvVar;
        zzaun.zzaD(zzv.class, zzvVar);
    }

    private zzv() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0004\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b᠌\u0000", new Object[]{"zza", "zzd", zzw.zza});
        }
        if (i2 == 3) {
            return new zzv();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzu(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
