package com.google.android.gms.internal.pal;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzqh extends zzqe {
    private static final zzpt zzb = new zzqf();
    private static final ThreadLocal zze = new zzqg();
    final AtomicInteger zza = new AtomicInteger();

    zzqh() {
    }

    static zzqe zza(zzqx zzqxVar, zzpr zzprVar) {
        Integer num = (Integer) zzqxVar.zzd(zzpl.zzc);
        if (num == null || num.intValue() <= 0) {
            return null;
        }
        zzqh zzqhVar = (zzqh) zzb.zzb(zzprVar, zzqxVar);
        return (((Random) zze.get()).nextInt(num.intValue()) == 0 ? zzqhVar.zza.incrementAndGet() : zzqhVar.zza.get()) > 0 ? zzqhVar : zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzqe
    public final void zzb() {
        this.zza.decrementAndGet();
    }
}
