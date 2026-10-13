package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaoy extends zzaun implements zzavx {
    private static final zzaoy zzh;
    private int zza;
    private zzaoq zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzaoy zzaoyVar = new zzaoy();
        zzh = zzaoyVar;
        zzaun.zzaD(zzaoy.class, zzaoyVar);
    }

    private zzaoy() {
    }

    public static zzaox zze() {
        return (zzaox) zzh.zzay();
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzaoq zzb() {
        zzaoq zzaoqVar = this.zzd;
        return zzaoqVar == null ? zzaoq.zzd() : zzaoqVar;
    }

    public final int zzc() {
        return this.zzf;
    }

    public final zzapm zzd() {
        zzapm zzapmVarZzb = zzapm.zzb(this.zzg);
        return zzapmVarZzb == null ? zzapm.UNRECOGNIZED : zzapmVarZzb;
    }

    final /* synthetic */ void zzf(zzaoq zzaoqVar) {
        zzaoqVar.getClass();
        this.zzd = zzaoqVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzg(int i) {
        this.zzf = i;
    }

    final /* synthetic */ void zzh(zzapm zzapmVar) {
        this.zzg = zzapmVar.zza();
    }

    public final int zzj() {
        int i = this.zze;
        int i2 = 2;
        if (i != 0) {
            if (i == 1) {
                i2 = 3;
            } else if (i != 2) {
                i2 = i != 3 ? 0 : 5;
            } else {
                i2 = 4;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    final /* synthetic */ void zzk(int i) {
        this.zze = zzaor.zza(i);
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzh, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zza", "zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzaoy();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaox(bArr);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }
}
