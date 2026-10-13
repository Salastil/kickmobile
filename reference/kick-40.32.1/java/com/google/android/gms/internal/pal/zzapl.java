package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzapl extends zzaun implements zzavx {
    private static final zzapl zzf;
    private int zza;
    private String zzd = "";
    private zzaot zze;

    static {
        zzapl zzaplVar = new zzapl();
        zzf = zzaplVar;
        zzaun.zzaD(zzapl.class, zzaplVar);
    }

    private zzapl() {
    }

    public static zzapl zzc(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzapl) zzaun.zzaM(zzf, zzatlVar, zzatyVar);
    }

    public static zzapk zzd() {
        return (zzapk) zzf.zzay();
    }

    public static zzapl zze() {
        return zzf;
    }

    public final String zza() {
        return this.zzd;
    }

    public final zzaot zzb() {
        zzaot zzaotVar = this.zze;
        return zzaotVar == null ? zzaot.zzg() : zzaotVar;
    }

    final /* synthetic */ void zzf(String str) {
        str.getClass();
        this.zzd = str;
    }

    final /* synthetic */ void zzg(zzaot zzaotVar) {
        zzaotVar.getClass();
        this.zze = zzaotVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzapl();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzapk(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
