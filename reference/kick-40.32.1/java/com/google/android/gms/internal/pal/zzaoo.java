package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaoo extends zzaun implements zzavx {
    private static final zzaoo zzg;
    private static volatile zzawd zzh;
    private int zza;
    private int zzd;
    private zzaok zze;
    private zzatl zzf = zzatl.zza;

    static {
        zzaoo zzaooVar = new zzaoo();
        zzg = zzaooVar;
        zzaun.zzaD(zzaoo.class, zzaooVar);
    }

    private zzaoo() {
    }

    public static zzaoo zzd(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzaoo) zzaun.zzaM(zzg, zzatlVar, zzatyVar);
    }

    public static zzaon zze() {
        return (zzaon) zzg.zzay();
    }

    public static zzaoo zzf() {
        return zzg;
    }

    public static zzawd zzg() {
        return (zzawd) zzg.zzl(7, null, null);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzaok zzb() {
        zzaok zzaokVar = this.zze;
        return zzaokVar == null ? zzaok.zze() : zzaokVar;
    }

    public final zzatl zzc() {
        return this.zzf;
    }

    final /* synthetic */ void zzh(int i) {
        this.zzd = 0;
    }

    final /* synthetic */ void zzi(zzaok zzaokVar) {
        zzaokVar.getClass();
        this.zze = zzaokVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzj(zzatl zzatlVar) {
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
            return new zzaoo();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaon(bArr);
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
        synchronized (zzaoo.class) {
            zzaujVar = zzh;
            if (zzaujVar == null) {
                zzaujVar = new zzauj(zzg);
                zzh = zzaujVar;
            }
        }
        return zzaujVar;
    }
}
