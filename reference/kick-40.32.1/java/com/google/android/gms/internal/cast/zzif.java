package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzif extends zzhz {
    private final transient zzhy zza;
    private final transient zzhv zzb;

    zzif(zzhy zzhyVar, zzhv zzhvVar) {
        this.zza = zzhyVar;
        this.zzb = zzhvVar;
    }

    @Override // com.google.android.gms.internal.cast.zzhr, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.cast.zzhz, com.google.android.gms.internal.cast.zzhr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.cast.zzhz, com.google.android.gms.internal.cast.zzhr
    /* JADX INFO: renamed from: zza */
    public final zzil iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.cast.zzhz, com.google.android.gms.internal.cast.zzhr
    public final zzhv zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.cast.zzhr
    final boolean zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzhr
    final int zzg(Object[] objArr, int i) {
        return this.zzb.zzg(objArr, 0);
    }
}
