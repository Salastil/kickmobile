package com.google.android.gms.internal.pal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzss {
    public static final /* synthetic */ int zza = 0;
    private static final Comparator zzb = new zzsl();
    private static final zzss zzc = new zzss(new zzsq(Collections.EMPTY_LIST));
    private final zzsq zzd;

    private zzss(zzsq zzsqVar) {
        this.zzd = zzsqVar;
    }

    public static zzss zza() {
        return zzc;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzss) && ((zzss) obj).zzd.equals(this.zzd);
    }

    public final int hashCode() {
        return ~this.zzd.hashCode();
    }

    public final String toString() {
        return this.zzd.toString();
    }

    public final Map zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return this.zzd.isEmpty();
    }

    public final zzss zzd(zzss zzssVar) {
        zzsq zzsqVar = zzssVar.zzd;
        if (zzsqVar.isEmpty()) {
            return this;
        }
        zzsq zzsqVar2 = this.zzd;
        return zzsqVar2.isEmpty() ? zzssVar : new zzss(new zzsq(zzsqVar2, zzsqVar));
    }
}
