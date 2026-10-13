package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrh {
    private static final zzrd zza = new zzrf();
    private static final zzrc zzb = new zzrg();

    public static zzra zza(Set set) {
        zzra zzraVar = new zzra(zza, null);
        zzraVar.zza(zzb);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzraVar.zzb((zzpz) it.next());
        }
        return zzraVar;
    }
}
