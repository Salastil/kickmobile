package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzt {
    private static final zzzp zza = new zzzr();
    private static final zzzo zzb = new zzzs();

    public static zzzm zza(Set set) {
        zzzm zzzmVar = new zzzm(zza, null);
        zzzmVar.zza(zzb);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzzmVar.zzb((zzyl) it.next());
        }
        return zzzmVar;
    }
}
