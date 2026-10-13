package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgt extends zzaun implements zzavx {
    private static final zzgt zzg;
    private int zza;
    private zzgv zzd;
    private zzatl zze;
    private zzatl zzf;

    static {
        zzgt zzgtVar = new zzgt();
        zzg = zzgtVar;
        zzaun.zzaD(zzgt.class, zzgtVar);
    }

    private zzgt() {
        zzatl zzatlVar = zzatl.zza;
        this.zze = zzatlVar;
        this.zzf = zzatlVar;
    }

    public static zzgt zzd(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzgt) zzaun.zzaM(zzg, zzatlVar, zzatyVar);
    }

    public final zzgv zza() {
        zzgv zzgvVar = this.zzd;
        return zzgvVar == null ? zzgv.zzi() : zzgvVar;
    }

    public final zzatl zzb() {
        return this.zze;
    }

    public final zzatl zzc() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgt();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzgs(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
