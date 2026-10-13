package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzani extends zzaun implements zzavx {
    private static final zzani zza;

    static {
        zzani zzaniVar = new zzani();
        zza = zzaniVar;
        zzaun.zzaD(zzani.class, zzaniVar);
    }

    private zzani() {
    }

    public static zzani zza(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzani) zzaun.zzaM(zza, zzatlVar, zzatyVar);
    }

    public static zzani zzb() {
        return zza;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        byte[] bArr = null;
        if (i2 == 2) {
            return zzaE(zza, "\u0000\u0000", null);
        }
        if (i2 == 3) {
            return new zzani();
        }
        if (i2 == 4) {
            return new zzanh(bArr);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
