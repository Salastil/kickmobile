package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaly extends zzaun implements zzavx {
    private static final zzaly zzg;
    private static volatile zzawd zzh;
    private int zza;
    private int zzd;
    private zzatl zze = zzatl.zza;
    private zzamc zzf;

    static {
        zzaly zzalyVar = new zzaly();
        zzg = zzalyVar;
        zzaun.zzaD(zzaly.class, zzalyVar);
    }

    private zzaly() {
    }

    public static zzaly zzd(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzaly) zzaun.zzaM(zzg, zzatlVar, zzatyVar);
    }

    public static zzalx zze() {
        return (zzalx) zzg.zzay();
    }

    public static zzawd zzf() {
        return (zzawd) zzg.zzl(7, null, null);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzatl zzb() {
        return this.zze;
    }

    public final zzamc zzc() {
        zzamc zzamcVar = this.zzf;
        return zzamcVar == null ? zzamc.zzc() : zzamcVar;
    }

    final /* synthetic */ void zzg(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zze = zzatlVar;
    }

    final /* synthetic */ void zzh(zzamc zzamcVar) {
        zzamcVar.getClass();
        this.zzf = zzamcVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        zzawd zzaujVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzaly();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzalx(bArr);
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
        synchronized (zzaly.class) {
            zzaujVar = zzh;
            if (zzaujVar == null) {
                zzaujVar = new zzauj(zzg);
                zzh = zzaujVar;
            }
        }
        return zzaujVar;
    }
}
