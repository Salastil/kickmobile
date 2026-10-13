package com.google.android.gms.internal.pal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzqd {
    private static final zzpt zza = new zzqc();
    private final AtomicBoolean zzb = new AtomicBoolean();
    private final AtomicInteger zzc = new AtomicInteger();

    private zzqd() {
    }

    static int zza(zzqe zzqeVar, zzpr zzprVar, zzqx zzqxVar) {
        zzqd zzqdVar = (zzqd) zza.zzb(zzprVar, zzqxVar);
        int iIncrementAndGet = zzqdVar.zzc.incrementAndGet();
        if (zzqeVar == zzqe.zzc || !zzqdVar.zzb.compareAndSet(false, true)) {
            return -1;
        }
        try {
            zzqeVar.zzb();
            zzqdVar.zzb.set(false);
            zzqdVar.zzc.addAndGet(-iIncrementAndGet);
            return iIncrementAndGet - 1;
        } catch (Throwable th) {
            zzqdVar.zzb.set(false);
            throw th;
        }
    }

    /* synthetic */ zzqd(byte[] bArr) {
    }
}
