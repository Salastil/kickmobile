package com.google.android.gms.internal.pal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzawf {
    private static final zzawf zza = new zzawf();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzawo zzb = new zzavo();

    private zzawf() {
    }

    static zzawf zza() {
        return zza;
    }

    final zzawn zzb(Class cls) {
        byte[] bArr = zzauz.zzb;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentMap concurrentMap = this.zzc;
        zzawn zzawnVar = (zzawn) concurrentMap.get(cls);
        if (zzawnVar != null) {
            return zzawnVar;
        }
        zzawn zzawnVarZza = this.zzb.zza(cls);
        zzawn zzawnVar2 = (zzawn) concurrentMap.putIfAbsent(cls, zzawnVarZza);
        return zzawnVar2 != null ? zzawnVar2 : zzawnVarZza;
    }
}
