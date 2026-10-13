package com.google.android.gms.internal.pal;

import java.util.AbstractList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzauw extends AbstractList {
    private final zzauu zza;
    private final zzauv zzb;

    public zzauw(zzauu zzauuVar, zzauv zzauvVar) {
        this.zza = zzauuVar;
        this.zzb = zzauvVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.zzb.zza(this.zza.zzf(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
