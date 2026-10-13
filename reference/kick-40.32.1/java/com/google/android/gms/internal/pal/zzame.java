package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzame extends zzaun implements zzavx {
    private static final zzame zzg;
    private static volatile zzawd zzh;
    private int zza;
    private int zzd;
    private zzami zze;
    private zzanz zzf;

    static {
        zzame zzameVar = new zzame();
        zzg = zzameVar;
        zzaun.zzaD(zzame.class, zzameVar);
    }

    private zzame() {
    }

    public static zzame zzd(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzame) zzaun.zzaM(zzg, zzatlVar, zzatyVar);
    }

    public static zzamd zze() {
        return (zzamd) zzg.zzay();
    }

    public static zzawd zzf() {
        return (zzawd) zzg.zzl(7, null, null);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzami zzb() {
        zzami zzamiVar = this.zze;
        return zzamiVar == null ? zzami.zze() : zzamiVar;
    }

    public final zzanz zzc() {
        zzanz zzanzVar = this.zzf;
        return zzanzVar == null ? zzanz.zzf() : zzanzVar;
    }

    final /* synthetic */ void zzg(zzami zzamiVar) {
        zzamiVar.getClass();
        this.zze = zzamiVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzh(zzanz zzanzVar) {
        zzanzVar.getClass();
        this.zzf = zzanzVar;
        this.zza |= 2;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        zzawd zzaujVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzame();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzamd(bArr);
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
        synchronized (zzame.class) {
            zzaujVar = zzh;
            if (zzaujVar == null) {
                zzaujVar = new zzauj(zzg);
                zzh = zzaujVar;
            }
        }
        return zzaujVar;
    }
}
