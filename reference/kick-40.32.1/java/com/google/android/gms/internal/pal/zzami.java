package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzami extends zzaun implements zzavx {
    private static final zzami zzg;
    private int zza;
    private int zzd;
    private zzamm zze;
    private zzatl zzf = zzatl.zza;

    static {
        zzami zzamiVar = new zzami();
        zzg = zzamiVar;
        zzaun.zzaD(zzami.class, zzamiVar);
    }

    private zzami() {
    }

    public static zzamh zzd() {
        return (zzamh) zzg.zzay();
    }

    public static zzami zze() {
        return zzg;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzamm zzb() {
        zzamm zzammVar = this.zze;
        return zzammVar == null ? zzamm.zzc() : zzammVar;
    }

    public final zzatl zzc() {
        return this.zzf;
    }

    final /* synthetic */ void zzf(zzamm zzammVar) {
        zzammVar.getClass();
        this.zze = zzammVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzg(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zzf = zzatlVar;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzami();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzamh(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
