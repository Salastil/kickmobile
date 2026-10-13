package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzanp extends zzaun implements zzavx {
    private static final zzanp zzg;
    private int zza;
    private zzanv zzd;
    private zzanl zze;
    private int zzf;

    static {
        zzanp zzanpVar = new zzanp();
        zzg = zzanpVar;
        zzaun.zzaD(zzanp.class, zzanpVar);
    }

    private zzanp() {
    }

    public static zzano zzd() {
        return (zzano) zzg.zzay();
    }

    public static zzanp zze() {
        return zzg;
    }

    public final zzanv zza() {
        zzanv zzanvVar = this.zzd;
        return zzanvVar == null ? zzanv.zze() : zzanvVar;
    }

    public final zzanl zzb() {
        zzanl zzanlVar = this.zze;
        return zzanlVar == null ? zzanl.zzc() : zzanlVar;
    }

    public final zzanj zzc() {
        zzanj zzanjVar;
        int i = this.zzf;
        if (i == 0) {
            zzanjVar = zzanj.UNKNOWN_FORMAT;
        } else if (i == 1) {
            zzanjVar = zzanj.UNCOMPRESSED;
        } else if (i != 2) {
            zzanjVar = i != 3 ? null : zzanj.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        } else {
            zzanjVar = zzanj.COMPRESSED;
        }
        return zzanjVar == null ? zzanj.UNRECOGNIZED : zzanjVar;
    }

    final /* synthetic */ void zzf(zzanv zzanvVar) {
        zzanvVar.getClass();
        this.zzd = zzanvVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzg(zzanl zzanlVar) {
        zzanlVar.getClass();
        this.zze = zzanlVar;
        this.zza |= 2;
    }

    final /* synthetic */ void zzh(zzanj zzanjVar) {
        this.zzf = zzanjVar.zza();
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzanp();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzano(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
