package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzanv extends zzaun implements zzavx {
    private static final zzanv zzf;
    private int zza;
    private int zzd;
    private zzatl zze = zzatl.zza;

    static {
        zzanv zzanvVar = new zzanv();
        zzf = zzanvVar;
        zzaun.zzaD(zzanv.class, zzanvVar);
    }

    private zzanv() {
    }

    public static zzanu zzd() {
        return (zzanu) zzf.zzay();
    }

    public static zzanv zze() {
        return zzf;
    }

    public final zzanw zza() {
        zzanw zzanwVar;
        int i = this.zza;
        if (i == 0) {
            zzanwVar = zzanw.UNKNOWN_CURVE;
        } else if (i == 2) {
            zzanwVar = zzanw.NIST_P256;
        } else if (i == 3) {
            zzanwVar = zzanw.NIST_P384;
        } else if (i != 4) {
            zzanwVar = i != 5 ? null : zzanw.CURVE25519;
        } else {
            zzanwVar = zzanw.NIST_P521;
        }
        return zzanwVar == null ? zzanw.UNRECOGNIZED : zzanwVar;
    }

    public final zzanx zzb() {
        zzanx zzanxVarZzb = zzanx.zzb(this.zzd);
        return zzanxVarZzb == null ? zzanx.UNRECOGNIZED : zzanxVarZzb;
    }

    public final zzatl zzc() {
        return this.zze;
    }

    final /* synthetic */ void zzf(zzanw zzanwVar) {
        this.zza = zzanwVar.zza();
    }

    final /* synthetic */ void zzg(zzanx zzanxVar) {
        this.zzd = zzanxVar.zza();
    }

    final /* synthetic */ void zzh(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zze = zzatlVar;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzanv();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzanu(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
