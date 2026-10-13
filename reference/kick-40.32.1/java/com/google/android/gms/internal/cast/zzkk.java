package com.google.android.gms.internal.cast;

import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkk {
    private static final Comparator zza = new zzkd();
    private static final zzkk zzb = new zzkk(new zzki(Collections.EMPTY_LIST));
    private final zzki zzc;

    private zzkk(zzki zzkiVar) {
        this.zzc = zzkiVar;
    }

    public static zzkk zza() {
        return zzb;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzkk) && ((zzkk) obj).zzc.equals(this.zzc);
    }

    public final int hashCode() {
        return ~this.zzc.hashCode();
    }

    public final String toString() {
        return this.zzc.toString();
    }
}
