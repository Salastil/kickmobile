package com.google.android.gms.internal.measurement;

import java.io.Closeable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabt implements Closeable {
    private static final ThreadLocal zza = new zzabs();
    private int zzb = 0;

    public static int zza() {
        return zzd().zzb;
    }

    public static zzabt zzc() {
        zzabt zzabtVarZzd = zzd();
        int i = zzabtVarZzd.zzb + 1;
        zzabtVarZzd.zzb = i;
        if (i != 0) {
            return zzabtVarZzd;
        }
        throw new AssertionError("Overflow of RecursionDepth (possible error in core library)");
    }

    private static zzabt zzd() {
        return (zzabt) zza.get();
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
