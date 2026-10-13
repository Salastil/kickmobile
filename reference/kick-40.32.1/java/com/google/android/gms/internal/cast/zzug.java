package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzug extends zzyd implements zzzj {
    private static final zzug zzl;
    private int zzb;
    private zzaaz zzd;
    private long zzi;
    private int zzj;
    private zzyl zze = zzyd.zzM();
    private zzyl zzf = zzM();
    private zzyl zzg = zzM();
    private String zzh = "";
    private String zzk = "";

    static {
        zzug zzugVar = new zzug();
        zzl = zzugVar;
        zzyd.zzG(zzug.class, zzugVar);
    }

    private zzug() {
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001ဉ\u0000\u0002\u001a\u0003\u001b\u0004\u001b\u0005ဈ\u0001\u0006ဂ\u0002\u0007᠌\u0003\bဈ\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", zzqe.class, "zzg", zztx.class, "zzh", "zzi", "zzj", zzql.zza, "zzk"});
        }
        if (i2 == 3) {
            return new zzug();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzuf(bArr);
        }
        if (i2 == 5) {
            return zzl;
        }
        throw null;
    }
}
