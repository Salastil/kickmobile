package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbf extends zzaun implements zzavx {
    private static final zzbf zzo;
    private int zza;
    private long zzd;
    private int zze;
    private boolean zzf;
    private long zzh;
    private boolean zzi;
    private long zzk;
    private long zzl;
    private long zzm;
    private zzbh zzn;
    private zzauu zzg = zzaG();
    private zzauy zzj = zzaJ();

    static {
        zzbf zzbfVar = new zzbf();
        zzo = zzbfVar;
        zzaun.zzaD(zzbf.class, zzbfVar);
    }

    private zzbf() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzo, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0002\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003\u0006ဇ\u0004\u0007\u001b\bဂ\u0005\tဂ\u0006\nဂ\u0007\u000bဉ\b", new Object[]{"zza", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzbl.class, "zzk", "zzl", "zzm", "zzn"});
        }
        if (i2 == 3) {
            return new zzbf();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzbe(bArr);
        }
        if (i2 == 5) {
            return zzo;
        }
        throw null;
    }
}
