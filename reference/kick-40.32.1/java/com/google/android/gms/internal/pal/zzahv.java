package com.google.android.gms.internal.pal;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzahv {
    private HashMap zza = new HashMap();

    public final zzahw zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzahw zzahwVar = new zzahw(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzahwVar;
    }
}
