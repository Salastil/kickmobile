package com.google.android.gms.internal.pal;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzahw implements zzvs {
    private final Map zza;

    static {
        new zzahv().zza();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzahw) {
            return this.zza.equals(((zzahw) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final boolean zza() {
        return this.zza.isEmpty();
    }
}
