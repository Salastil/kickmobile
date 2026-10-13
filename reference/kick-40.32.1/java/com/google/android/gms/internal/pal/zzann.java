package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzann extends zzaun implements zzavx {
    private static final zzann zze;
    private int zza;
    private zzanp zzd;

    static {
        zzann zzannVar = new zzann();
        zze = zzannVar;
        zzaun.zzaD(zzann.class, zzannVar);
    }

    private zzann() {
    }

    public static zzann zzb(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzann) zzaun.zzaM(zze, zzatlVar, zzatyVar);
    }

    public static zzanm zzc() {
        return (zzanm) zze.zzay();
    }

    public final zzanp zza() {
        zzanp zzanpVar = this.zzd;
        return zzanpVar == null ? zzanp.zze() : zzanpVar;
    }

    final /* synthetic */ void zzd(zzanp zzanpVar) {
        zzanpVar.getClass();
        this.zzd = zzanpVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zza", "zzd"});
        }
        if (i2 == 3) {
            return new zzann();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzanm(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
