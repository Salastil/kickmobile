package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzant extends zzaun implements zzavx {
    private static final zzant zzh;
    private static volatile zzawd zzi;
    private int zza;
    private int zzd;
    private zzanp zze;
    private zzatl zzf;
    private zzatl zzg;

    static {
        zzant zzantVar = new zzant();
        zzh = zzantVar;
        zzaun.zzaD(zzant.class, zzantVar);
    }

    private zzant() {
        zzatl zzatlVar = zzatl.zza;
        this.zzf = zzatlVar;
        this.zzg = zzatlVar;
    }

    public static zzant zze(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzant) zzaun.zzaM(zzh, zzatlVar, zzatyVar);
    }

    public static zzans zzf() {
        return (zzans) zzh.zzay();
    }

    public static zzant zzg() {
        return zzh;
    }

    public static zzawd zzh() {
        return (zzawd) zzh.zzl(7, null, null);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzanp zzb() {
        zzanp zzanpVar = this.zze;
        return zzanpVar == null ? zzanp.zze() : zzanpVar;
    }

    public final zzatl zzc() {
        return this.zzf;
    }

    public final zzatl zzd() {
        return this.zzg;
    }

    final /* synthetic */ void zzi(int i) {
        this.zzd = 0;
    }

    final /* synthetic */ void zzj(zzanp zzanpVar) {
        zzanpVar.getClass();
        this.zze = zzanpVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzk(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zzf = zzatlVar;
    }

    final /* synthetic */ void zzm(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zzg = zzatlVar;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        zzawd zzaujVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzh, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zza", "zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzant();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzans(bArr);
        }
        if (i2 == 5) {
            return zzh;
        }
        if (i2 != 6) {
            throw null;
        }
        zzawd zzawdVar = zzi;
        if (zzawdVar != null) {
            return zzawdVar;
        }
        synchronized (zzant.class) {
            zzaujVar = zzi;
            if (zzaujVar == null) {
                zzaujVar = new zzauj(zzh);
                zzi = zzaujVar;
            }
        }
        return zzaujVar;
    }
}
