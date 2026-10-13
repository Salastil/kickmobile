package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzp extends zzaun implements zzavx {
    private static final zzp zzf;
    private int zza;
    private String zzd = "";
    private String zze = "";

    static {
        zzp zzpVar = new zzp();
        zzf = zzpVar;
        zzaun.zzaD(zzp.class, zzpVar);
    }

    private zzp() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzp();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzo(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
