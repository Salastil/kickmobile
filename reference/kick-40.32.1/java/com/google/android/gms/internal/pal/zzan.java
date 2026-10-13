package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzan extends zzaun implements zzavx {
    private static final zzan zzg;
    private int zza;
    private long zzd = -1;
    private int zze = 1000;
    private int zzf = 1000;

    static {
        zzan zzanVar = new zzan();
        zzg = zzanVar;
        zzaun.zzaD(zzan.class, zzanVar);
    }

    private zzan() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzaus zzausVar = zzbn.zza;
            return zzaE(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zza", "zzd", "zze", zzausVar, "zzf", zzausVar});
        }
        if (i2 == 3) {
            return new zzan();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzam(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
