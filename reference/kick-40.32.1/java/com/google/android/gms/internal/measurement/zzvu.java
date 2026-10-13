package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzvu {
    private static final WeakHashMap zza = new WeakHashMap();
    private static final WeakHashMap zzb = new WeakHashMap();

    public static void zza(Throwable th) {
        Throwable cause;
        zzxc zzxcVar;
        zzws zzwsVarZzb;
        WeakHashMap weakHashMap = zzb;
        synchronized (weakHashMap) {
            cause = th;
            while (cause != null) {
                try {
                    if (weakHashMap.containsKey(cause)) {
                        break;
                    } else {
                        cause = cause.getCause();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            weakHashMap.put(th, Boolean.valueOf(cause != null));
        }
        if (cause != null) {
            return;
        }
        Preconditions.checkState(true, "Trace uncaught exception is disabled.");
        WeakHashMap weakHashMap2 = zza;
        synchronized (weakHashMap2) {
            Throwable cause2 = th;
            while (cause2 != null) {
                try {
                    if (weakHashMap2.containsKey(cause2)) {
                        break;
                    } else {
                        cause2 = cause2.getCause();
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            if (cause2 == null) {
                zzxcVar = null;
            } else {
                zzww zzwwVar = (zzww) weakHashMap2.get(cause2);
                weakHashMap2.put(th, zzwwVar);
                zzxcVar = new zzxc(cause2, zzwwVar);
            }
        }
        if (zzxcVar != null || (zzwsVarZzb = zzvy.zzd().zzb) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (zzwsVarZzb = zzvy.zzd().zzb; zzwsVarZzb != null; zzwsVarZzb = zzwsVarZzb.zzb()) {
            arrayList.add(zzwsVarZzb);
        }
        zzvo zzvoVar = new zzvo();
        zzvoVar.zzc(((zzws) arrayList.get(0)).zzc());
        ((zzws) arrayList.get(0)).zzk();
        zzvoVar.zzd(-1L);
        ImmutableList.Builder builderBuilderWithExpectedSize = ImmutableList.builderWithExpectedSize(arrayList.size());
        ImmutableList.Builder builderBuilderWithExpectedSize2 = ImmutableList.builderWithExpectedSize(arrayList.size());
        for (zzws zzwsVar : Lists.reverse(arrayList)) {
            builderBuilderWithExpectedSize2.add(zzwsVar.zze());
            builderBuilderWithExpectedSize.add(zzwsVar.zzh());
        }
        WeakHashMap weakHashMap3 = zza;
        synchronized (weakHashMap3) {
            zzvoVar.zza(builderBuilderWithExpectedSize2.build());
            zzvoVar.zzb(builderBuilderWithExpectedSize.build());
            weakHashMap3.put(th, zzvoVar.zze());
        }
    }
}
