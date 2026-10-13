package com.google.android.gms.internal.cast;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzzp {
    private static final zzzp zza = new zzzp();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzzt zzb = new zzza();

    private zzzp() {
    }

    public static zzzp zza() {
        return zza;
    }

    public final zzzs zzb(Class cls) {
        zzym.zza(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzc;
        zzzs zzzsVar = (zzzs) concurrentMap.get(cls);
        if (zzzsVar != null) {
            return zzzsVar;
        }
        zzzs zzzsVarZza = this.zzb.zza(cls);
        zzym.zza(cls, "messageType");
        zzzs zzzsVar2 = (zzzs) concurrentMap.putIfAbsent(cls, zzzsVarZza);
        return zzzsVar2 != null ? zzzsVar2 : zzzsVarZza;
    }
}
