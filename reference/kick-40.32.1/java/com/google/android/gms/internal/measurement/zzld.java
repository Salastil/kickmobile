package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzld {
    private static final ConcurrentMap zza = new ConcurrentHashMap();

    static void zza() {
        Iterator it = zza.values().iterator();
        if (it.hasNext()) {
            throw null;
        }
    }
}
