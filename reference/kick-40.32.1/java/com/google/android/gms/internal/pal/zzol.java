package com.google.android.gms.internal.pal;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzol extends zznt {
    private final transient zznp zza;
    private final transient zznm zzb;

    zzol(zznp zznpVar, zznm zznmVar) {
        this.zza = zznpVar;
        this.zzb = zznmVar;
    }

    @Override // com.google.android.gms.internal.pal.zznh, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.pal.zznt, com.google.android.gms.internal.pal.zznh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.pal.zznt, com.google.android.gms.internal.pal.zznh
    /* JADX INFO: renamed from: zza */
    public final zzou iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.pal.zznh
    final int zze(Object[] objArr, int i) {
        return this.zzb.zze(objArr, 0);
    }
}
