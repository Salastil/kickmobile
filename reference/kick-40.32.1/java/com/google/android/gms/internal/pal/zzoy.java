package com.google.android.gms.internal.pal;

import androidx.collection.SieveCacheKt;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzoy extends zzqe {
    private static final zzpt zza = new zzox();
    private final AtomicLong zzb = new AtomicLong(SieveCacheKt.NodeLinkMask);

    zzoy() {
    }

    static zzqe zza(zzqx zzqxVar, zzpr zzprVar) {
        Integer num = (Integer) zzqxVar.zzd(zzpl.zzb);
        if (num == null) {
            return null;
        }
        zzoy zzoyVar = (zzoy) zza.zzb(zzprVar, zzqxVar);
        return zzoyVar.zzb.incrementAndGet() >= ((long) num.intValue()) ? zzoyVar : zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzqe
    public final void zzb() {
        this.zzb.set(0L);
    }
}
