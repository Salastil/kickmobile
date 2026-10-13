package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaom extends zzaun implements zzavx {
    private static final zzaom zzg;
    private static volatile zzawd zzh;
    private int zza;
    private int zzd;
    private zzaoo zze;
    private zzatl zzf = zzatl.zza;

    static {
        zzaom zzaomVar = new zzaom();
        zzg = zzaomVar;
        zzaun.zzaD(zzaom.class, zzaomVar);
    }

    private zzaom() {
    }

    public static zzaom zzd(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzaom) zzaun.zzaM(zzg, zzatlVar, zzatyVar);
    }

    public static zzaol zze() {
        return (zzaol) zzg.zzay();
    }

    public static zzawd zzf() {
        return (zzawd) zzg.zzl(7, null, null);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzaoo zzb() {
        zzaoo zzaooVar = this.zze;
        return zzaooVar == null ? zzaoo.zzf() : zzaooVar;
    }

    public final zzatl zzc() {
        return this.zzf;
    }

    final /* synthetic */ void zzg(int i) {
        this.zzd = 0;
    }

    final /* synthetic */ void zzh(zzaoo zzaooVar) {
        zzaooVar.getClass();
        this.zze = zzaooVar;
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
            return new zzaom();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaol(bArr);
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
        synchronized (zzaom.class) {
            zzaujVar = zzh;
            if (zzaujVar == null) {
                zzaujVar = new zzauj(zzg);
                zzh = zzaujVar;
            }
        }
        return zzaujVar;
    }
}
