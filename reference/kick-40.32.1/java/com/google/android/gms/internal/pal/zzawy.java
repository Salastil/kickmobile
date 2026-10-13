package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzawy extends zzaun implements zzavx {
    private static final zzawy zze;
    private long zza;
    private int zzd;

    static {
        zzawy zzawyVar = new zzawy();
        zze = zzawyVar;
        zzaun.zzaD(zzawy.class, zzawyVar);
    }

    private zzawy() {
    }

    public static zzawx zzc() {
        return (zzawx) zze.zzay();
    }

    public final long zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzd;
    }

    final /* synthetic */ void zzd(long j) {
        this.zza = j;
    }

    final /* synthetic */ void zze(int i) {
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzawh(zze, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zza", "zzd"});
        }
        if (i2 == 3) {
            return new zzawy();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzawx(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
