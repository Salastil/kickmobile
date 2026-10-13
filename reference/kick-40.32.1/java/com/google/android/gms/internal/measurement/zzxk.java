package com.google.android.gms.internal.measurement;

import androidx.collection.SieveCacheKt;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzxk extends zzyq {
    private static final zzyf zza = new zzxj();
    private final AtomicLong zzb = new AtomicLong(SieveCacheKt.NodeLinkMask);

    zzxk() {
    }

    static zzyq zza(zzzj zzzjVar, zzyd zzydVar) {
        Integer num = (Integer) zzzjVar.zzd(zzxx.zzb);
        if (num == null) {
            return null;
        }
        zzxk zzxkVar = (zzxk) zza.zzb(zzydVar, zzzjVar);
        return zzxkVar.zzb.incrementAndGet() >= ((long) num.intValue()) ? zzxkVar : zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzyq
    public final void zzb() {
        this.zzb.set(0L);
    }
}
