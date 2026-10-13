package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzyf {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();

    protected zzyf() {
    }

    protected abstract Object zza();

    public final Object zzb(zzyd zzydVar, zzzj zzzjVar) {
        ConcurrentHashMap concurrentHashMap = this.zza;
        Object obj = concurrentHashMap.get(zzydVar);
        if (obj != null) {
            return obj;
        }
        Object objZza = zza();
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(zzydVar, objZza);
        if (objPutIfAbsent != null) {
            return objPutIfAbsent;
        }
        int iZza = zzzjVar.zza();
        zzye zzyeVar = null;
        for (int i = 0; i < iZza; i++) {
            if (zzxx.zzf.equals(zzzjVar.zzb(i))) {
                Object objZzc = zzzjVar.zzc(i);
                if (objZzc instanceof zzyj) {
                    if (zzyeVar == null) {
                        zzyeVar = new zzye(this, zzydVar);
                    }
                    ((zzyj) objZzc).zza();
                }
            }
        }
        return objZza;
    }

    final /* synthetic */ ConcurrentHashMap zzc() {
        return this.zza;
    }
}
