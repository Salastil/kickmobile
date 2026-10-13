package com.google.android.gms.internal.pal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzux extends zzaun implements zzavx {
    private static final zzux zzf;
    private int zza;
    private int zzd;
    private zzauu zze = zzaG();

    static {
        zzux zzuxVar = new zzux();
        zzf = zzuxVar;
        zzaun.zzaD(zzux.class, zzuxVar);
    }

    private zzux() {
    }

    public static zzuv zzd() {
        return (zzuv) zzf.zzay();
    }

    public final zzup zza() {
        zzup zzupVarZzb = zzup.zzb(this.zza);
        return zzupVarZzb == null ? zzup.UNRECOGNIZED : zzupVarZzb;
    }

    public final zzuw zzb() {
        zzuw zzuwVarZzb = zzuw.zzb(this.zzd);
        return zzuwVarZzb == null ? zzuw.UNRECOGNIZED : zzuwVarZzb;
    }

    public final List zzc() {
        return this.zze;
    }

    final /* synthetic */ void zze(zzup zzupVar) {
        this.zza = zzupVar.zza();
    }

    final /* synthetic */ void zzf(zzuw zzuwVar) {
        this.zzd = zzuwVar.zza();
    }

    final /* synthetic */ void zzg(Iterable iterable) {
        zzauu zzauuVar = this.zze;
        if (!zzauuVar.zza()) {
            this.zze = zzaun.zzaH(zzauuVar);
        }
        zzasx.zzas(iterable, this.zze);
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0004\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002\f\u0003'", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzux();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzuv(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
