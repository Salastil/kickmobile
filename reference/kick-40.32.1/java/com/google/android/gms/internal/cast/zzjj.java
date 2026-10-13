package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjj {
    private static final zzjf zza = new zzjh();
    private static final zzje zzb = new zzji();

    public static zzjc zza(Set set) {
        zzjc zzjcVar = new zzjc(zza, null);
        zzje zzjeVar = zzb;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzjcVar.zza((zzit) it.next());
        }
        return zzjcVar;
    }
}
