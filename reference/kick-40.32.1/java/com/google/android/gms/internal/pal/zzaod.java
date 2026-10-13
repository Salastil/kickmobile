package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaod extends zzaun implements zzavx {
    private static final zzaod zze;
    private int zza;
    private int zzd;

    static {
        zzaod zzaodVar = new zzaod();
        zze = zzaodVar;
        zzaun.zzaD(zzaod.class, zzaodVar);
    }

    private zzaod() {
    }

    public static zzaoc zzc() {
        return (zzaoc) zze.zzay();
    }

    public static zzaod zzd() {
        return zze;
    }

    public final zzanx zza() {
        zzanx zzanxVarZzb = zzanx.zzb(this.zza);
        return zzanxVarZzb == null ? zzanx.UNRECOGNIZED : zzanxVarZzb;
    }

    public final int zzb() {
        return this.zzd;
    }

    final /* synthetic */ void zze(zzanx zzanxVar) {
        this.zza = zzanxVar.zza();
    }

    final /* synthetic */ void zzf(int i) {
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zza", "zzd"});
        }
        if (i2 == 3) {
            return new zzaod();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaoc(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
