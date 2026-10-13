package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzanz extends zzaun implements zzavx {
    private static final zzanz zzg;
    private static volatile zzawd zzh;
    private int zza;
    private int zzd;
    private zzaod zze;
    private zzatl zzf = zzatl.zza;

    static {
        zzanz zzanzVar = new zzanz();
        zzg = zzanzVar;
        zzaun.zzaD(zzanz.class, zzanzVar);
    }

    private zzanz() {
    }

    public static zzanz zzd(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzanz) zzaun.zzaM(zzg, zzatlVar, zzatyVar);
    }

    public static zzany zze() {
        return (zzany) zzg.zzay();
    }

    public static zzanz zzf() {
        return zzg;
    }

    public static zzawd zzg() {
        return (zzawd) zzg.zzl(7, null, null);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzaod zzb() {
        zzaod zzaodVar = this.zze;
        return zzaodVar == null ? zzaod.zzd() : zzaodVar;
    }

    public final zzatl zzc() {
        return this.zzf;
    }

    final /* synthetic */ void zzh(zzaod zzaodVar) {
        zzaodVar.getClass();
        this.zze = zzaodVar;
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
            return new zzanz();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzany(bArr);
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
        synchronized (zzanz.class) {
            zzaujVar = zzh;
            if (zzaujVar == null) {
                zzaujVar = new zzauj(zzg);
                zzh = zzaujVar;
            }
        }
        return zzaujVar;
    }
}
