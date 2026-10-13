package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaot extends zzaun implements zzavx {
    private static final zzaot zzf;
    private String zza = "";
    private zzatl zzd = zzatl.zza;
    private int zze;

    static {
        zzaot zzaotVar = new zzaot();
        zzf = zzaotVar;
        zzaun.zzaD(zzaot.class, zzaotVar);
    }

    private zzaot() {
    }

    public static zzaot zzd(byte[] bArr, zzaty zzatyVar) throws zzavb {
        return (zzaot) zzaun.zzaN(zzf, bArr, zzatyVar);
    }

    public static zzaos zze() {
        return (zzaos) zzf.zzay();
    }

    public static zzaos zzf(zzaot zzaotVar) {
        zzaui zzauiVarZzay = zzf.zzay();
        zzauiVarZzay.zzam(zzaotVar);
        return (zzaos) zzauiVarZzay;
    }

    public static zzaot zzg() {
        return zzf;
    }

    public final String zza() {
        return this.zza;
    }

    public final zzatl zzb() {
        return this.zzd;
    }

    public final zzapm zzc() {
        zzapm zzapmVarZzb = zzapm.zzb(this.zze);
        return zzapmVarZzb == null ? zzapm.UNRECOGNIZED : zzapmVarZzb;
    }

    final /* synthetic */ void zzh(String str) {
        str.getClass();
        this.zza = str;
    }

    final /* synthetic */ void zzi(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zzd = zzatlVar;
    }

    final /* synthetic */ void zzj(zzapm zzapmVar) {
        this.zze = zzapmVar.zza();
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzaot();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaos(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
