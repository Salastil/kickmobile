package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zztl extends zzyd implements zzzj {
    private static final zztl zzf;
    private int zzb;
    private int zzd;
    private String zze = "";

    static {
        zztl zztlVar = new zztl();
        zzf = zztlVar;
        zzyd.zzG(zztl.class, zztlVar);
    }

    private zztl() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zztl();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zztk(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
