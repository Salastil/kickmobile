package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsf extends zzyd implements zzzj {
    private static final zzsf zzi;
    private int zzb;
    private Object zze;
    private int zzf;
    private int zzd = 0;
    private String zzg = "";
    private zzyl zzh = zzM();

    static {
        zzsf zzsfVar = new zzsf();
        zzi = zzsfVar;
        zzyd.zzG(zzsf.class, zzsfVar);
    }

    private zzsf() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzi, "\u0001\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003\u001b\u0004<\u0000\u0005<\u0000", new Object[]{"zze", "zzd", "zzb", "zzf", zzsd.zza, "zzg", "zzh", zztd.class, zzvp.class, zzvn.class});
        }
        if (i2 == 3) {
            return new zzsf();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzse(bArr);
        }
        if (i2 == 5) {
            return zzi;
        }
        throw null;
    }
}
