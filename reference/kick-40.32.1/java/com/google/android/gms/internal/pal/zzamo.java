package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzamo extends zzaun implements zzavx {
    private static final zzamo zzg;
    private static volatile zzawd zzh;
    private int zza;
    private int zzd;
    private zzams zze;
    private zzatl zzf = zzatl.zza;

    static {
        zzamo zzamoVar = new zzamo();
        zzg = zzamoVar;
        zzaun.zzaD(zzamo.class, zzamoVar);
    }

    private zzamo() {
    }

    public static zzamo zzd(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzamo) zzaun.zzaM(zzg, zzatlVar, zzatyVar);
    }

    public static zzamn zze() {
        return (zzamn) zzg.zzay();
    }

    public static zzawd zzf() {
        return (zzawd) zzg.zzl(7, null, null);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzams zzb() {
        zzams zzamsVar = this.zze;
        return zzamsVar == null ? zzams.zzc() : zzamsVar;
    }

    public final zzatl zzc() {
        return this.zzf;
    }

    final /* synthetic */ void zzg(zzams zzamsVar) {
        zzamsVar.getClass();
        this.zze = zzamsVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzh(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zzf = zzatlVar;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        zzawd zzaujVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzamo();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzamn(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        if (i2 != 6) {
            throw null;
        }
        zzawd zzawdVar = zzh;
        if (zzawdVar != null) {
            return zzawdVar;
        }
        synchronized (zzamo.class) {
            zzaujVar = zzh;
            if (zzaujVar == null) {
                zzaujVar = new zzauj(zzg);
                zzh = zzaujVar;
            }
        }
        return zzaujVar;
    }
}
