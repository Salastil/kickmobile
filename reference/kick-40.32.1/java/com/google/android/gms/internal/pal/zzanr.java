package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzanr extends zzaun implements zzavx {
    private static final zzanr zzg;
    private static volatile zzawd zzh;
    private int zza;
    private int zzd;
    private zzant zze;
    private zzatl zzf = zzatl.zza;

    static {
        zzanr zzanrVar = new zzanr();
        zzg = zzanrVar;
        zzaun.zzaD(zzanr.class, zzanrVar);
    }

    private zzanr() {
    }

    public static zzanr zzd(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzanr) zzaun.zzaM(zzg, zzatlVar, zzatyVar);
    }

    public static zzanq zze() {
        return (zzanq) zzg.zzay();
    }

    public static zzawd zzf() {
        return (zzawd) zzg.zzl(7, null, null);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzant zzb() {
        zzant zzantVar = this.zze;
        return zzantVar == null ? zzant.zzg() : zzantVar;
    }

    public final zzatl zzc() {
        return this.zzf;
    }

    final /* synthetic */ void zzg(int i) {
        this.zzd = 0;
    }

    final /* synthetic */ void zzh(zzant zzantVar) {
        zzantVar.getClass();
        this.zze = zzantVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzi(zzatl zzatlVar) {
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
            return new zzanr();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzanq(bArr);
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
        synchronized (zzanr.class) {
            zzaujVar = zzh;
            if (zzaujVar == null) {
                zzaujVar = new zzauj(zzg);
                zzh = zzaujVar;
            }
        }
        return zzaujVar;
    }
}
