package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class zzapo extends zzaun implements zzavx {
    public static final /* synthetic */ int zza = 0;
    private static final zzapo zzf;
    private String zzd = "";
    private zzauy zze = zzaJ();

    static {
        zzapo zzapoVar = new zzapo();
        zzf = zzapoVar;
        zzaun.zzaD(zzapo.class, zzapoVar);
    }

    private zzapo() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzaov.class});
        }
        if (i2 == 3) {
            return new zzapo();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzapn(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
