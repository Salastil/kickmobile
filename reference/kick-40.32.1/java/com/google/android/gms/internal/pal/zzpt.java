package com.google.android.gms.internal.pal;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzpt {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();

    protected zzpt() {
    }

    protected abstract Object zza();

    public final Object zzb(zzpr zzprVar, zzqx zzqxVar) {
        ConcurrentHashMap concurrentHashMap = this.zza;
        Object obj = concurrentHashMap.get(zzprVar);
        if (obj != null) {
            return obj;
        }
        Object objZza = zza();
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(zzprVar, objZza);
        if (objPutIfAbsent != null) {
            return objPutIfAbsent;
        }
        int iZza = zzqxVar.zza();
        zzps zzpsVar = null;
        for (int i = 0; i < iZza; i++) {
            if (zzpl.zzf.equals(zzqxVar.zzb(i))) {
                Object objZzc = zzqxVar.zzc(i);
                if (objZzc instanceof zzpx) {
                    if (zzpsVar == null) {
                        zzpsVar = new zzps(this, zzprVar);
                    }
                    ((zzpx) objZzc).zza();
                }
            }
        }
        return objZza;
    }

    final /* synthetic */ ConcurrentHashMap zzc() {
        return this.zza;
    }
}
