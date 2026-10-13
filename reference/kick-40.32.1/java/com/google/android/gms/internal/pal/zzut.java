package com.google.android.gms.internal.pal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzut extends zzaun implements zzavx {
    private static final zzut zzd;
    private zzauu zza = zzaG();

    static {
        zzut zzutVar = new zzut();
        zzd = zzutVar;
        zzaun.zzaD(zzut.class, zzutVar);
    }

    private zzut() {
    }

    public static zzus zzb() {
        return (zzus) zzd.zzay();
    }

    public static zzut zzc() {
        return zzd;
    }

    public final List zza() {
        return this.zza;
    }

    final /* synthetic */ void zzd(Iterable iterable) {
        zzauu zzauuVar = this.zza;
        if (!zzauuVar.zza()) {
            this.zza = zzaun.zzaH(zzauuVar);
        }
        zzasx.zzas(iterable, this.zza);
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"zza"});
        }
        if (i2 == 3) {
            return new zzut();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzus(bArr);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }
}
