package com.google.android.gms.internal.pal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaoz extends zzaun implements zzavx {
    private static final zzaoz zze;
    private int zza;
    private zzauy zzd = zzaJ();

    static {
        zzaoz zzaozVar = new zzaoz();
        zze = zzaozVar;
        zzaun.zzaD(zzaoz.class, zzaozVar);
    }

    private zzaoz() {
    }

    public static zzaoz zze(byte[] bArr, zzaty zzatyVar) throws zzavb {
        return (zzaoz) zzaun.zzaN(zze, bArr, zzatyVar);
    }

    public static zzaow zzf() {
        return (zzaow) zze.zzay();
    }

    public final int zza() {
        return this.zza;
    }

    public final List zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzd.size();
    }

    public final zzaoy zzd(int i) {
        return (zzaoy) this.zzd.get(i);
    }

    final /* synthetic */ void zzg(int i) {
        this.zza = i;
    }

    final /* synthetic */ void zzh(zzaoy zzaoyVar) {
        zzaoyVar.getClass();
        zzauy zzauyVar = this.zzd;
        if (!zzauyVar.zza()) {
            this.zzd = zzaun.zzaK(zzauyVar);
        }
        this.zzd.add(zzaoyVar);
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zza", "zzd", zzaoy.class});
        }
        if (i2 == 3) {
            return new zzaoz();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaow(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
