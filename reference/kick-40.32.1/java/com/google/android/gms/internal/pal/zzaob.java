package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaob extends zzaun implements zzavx {
    private static final zzaob zzg;
    private int zza;
    private zzaod zzd;
    private int zze;
    private int zzf;

    static {
        zzaob zzaobVar = new zzaob();
        zzg = zzaobVar;
        zzaun.zzaD(zzaob.class, zzaobVar);
    }

    private zzaob() {
    }

    public static zzaob zzd(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzaob) zzaun.zzaM(zzg, zzatlVar, zzatyVar);
    }

    public static zzaoa zze() {
        return (zzaoa) zzg.zzay();
    }

    public static zzaob zzf() {
        return zzg;
    }

    public final zzaod zza() {
        zzaod zzaodVar = this.zzd;
        return zzaodVar == null ? zzaod.zzd() : zzaodVar;
    }

    public final int zzb() {
        return this.zze;
    }

    public final int zzc() {
        return this.zzf;
    }

    final /* synthetic */ void zzg(zzaod zzaodVar) {
        zzaodVar.getClass();
        this.zzd = zzaodVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzh(int i) {
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzaob();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaoa(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
