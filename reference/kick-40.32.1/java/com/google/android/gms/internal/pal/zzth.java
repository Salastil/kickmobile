package com.google.android.gms.internal.pal;

import java.io.Closeable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzth implements Closeable {
    private static final ThreadLocal zza = new zztg();
    private int zzb = 0;

    public static int zza() {
        return zzd().zzb;
    }

    public static zzth zzc() {
        zzth zzthVarZzd = zzd();
        int i = zzthVarZzd.zzb + 1;
        zzthVarZzd.zzb = i;
        if (i != 0) {
            return zzthVarZzd;
        }
        throw new AssertionError("Overflow of RecursionDepth (possible error in core library)");
    }

    private static zzth zzd() {
        return (zzth) zza.get();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i = this.zzb;
        if (i <= 0) {
            throw new AssertionError("Mismatched calls to RecursionDepth (possible error in core library)");
        }
        this.zzb = i - 1;
    }

    public final int zzb() {
        return this.zzb;
    }
}
