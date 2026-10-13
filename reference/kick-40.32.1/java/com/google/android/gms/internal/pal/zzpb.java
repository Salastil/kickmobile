package com.google.android.gms.internal.pal;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzpb extends zzqe {
    private static final zzpt zza = new zzoz();
    private final AtomicLong zzb = new AtomicLong(-1);

    zzpb() {
    }

    static zzqe zza(zzqx zzqxVar, zzpr zzprVar, long j) {
        if (((zzpa) zzqxVar.zzd(zzpl.zzd)) == null) {
            return null;
        }
        zzpb zzpbVar = (zzpb) zza.zzb(zzprVar, zzqxVar);
        zztf.zzb(j >= 0, "timestamp cannot be negative");
        AtomicLong atomicLong = zzpbVar.zzb;
        long j2 = atomicLong.get();
        if (j2 >= 0) {
            throw null;
        }
        atomicLong.compareAndSet(j2, -j);
        return zzpbVar;
    }

    @Override // com.google.android.gms.internal.pal.zzqe
    public final void zzb() {
        AtomicLong atomicLong = this.zzb;
        atomicLong.set(Math.max(-atomicLong.get(), 0L));
    }
}
