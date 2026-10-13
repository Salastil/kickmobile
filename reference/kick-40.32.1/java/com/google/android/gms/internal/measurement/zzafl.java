package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzafl {
    private static final zzafl zza = new zzafl();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();
    private final zzaet zzb = new zzaet();

    private zzafl() {
    }

    static zzafl zza() {
        return zza;
    }

    private <T> zzafp<T> zzc(Class<T> cls) {
        ConcurrentHashMap concurrentHashMap = this.zzc;
        zzafp<T> zzafpVarZza = this.zzb.zza(cls);
        zzafp<T> zzafpVar = (zzafp) concurrentHashMap.putIfAbsent(cls, zzafpVarZza);
        return zzafpVar != null ? zzafpVar : zzafpVarZza;
    }

    final zzafp zzb(Class cls) {
        Object obj = this.zzc.get(cls);
        return obj == null ? zzc(cls) : (zzafp) obj;
    }
}
