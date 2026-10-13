package com.google.android.gms.internal.pal;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zznv extends zznt implements NavigableSet, zzos {
    final transient Comparator zza;
    transient zznv zzb;

    zznv(Comparator comparator) {
        this.zza = comparator;
    }

    static zzop zzk(Comparator comparator) {
        if (zzob.zza.equals(comparator)) {
            return zzop.zzc;
        }
        int i = zznm.zzd;
        return new zzop(zzoi.zza, comparator);
    }

    @Deprecated
    public final void addFirst(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void addLast(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedSet, com.google.android.gms.internal.pal.zzos
    public final Comparator comparator() {
        return this.zza;
    }

    @Override // java.util.NavigableSet
    public final /* bridge */ /* synthetic */ NavigableSet descendingSet() {
        zznv zznvVar = this.zzb;
        if (zznvVar != null) {
            return zznvVar;
        }
        zznv zznvVarZzp = zzp();
        this.zzb = zznvVarZzp;
        zznvVarZzp.zzb = this;
        return zznvVarZzp;
    }

    @Override // java.util.SortedSet
    public Object first() {
        return iterator().next();
    }

    public final Object getFirst() {
        return first();
    }

    public final Object getLast() {
        return last();
    }

    @Override // java.util.SortedSet
    public Object last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // com.google.android.gms.internal.pal.zznt, com.google.android.gms.internal.pal.zznh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zza */
    public abstract zzou iterator();

    abstract zznv zzm(Object obj, boolean z);

    abstract zznv zzn(Object obj, boolean z, Object obj2, boolean z2);

    abstract zznv zzo(Object obj, boolean z);

    abstract zznv zzp();

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: zzq */
    public abstract zzou descendingIterator();

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet headSet(Object obj) {
        obj.getClass();
        return zzm(obj, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet tailSet(Object obj) {
        obj.getClass();
        return zzo(obj, true);
    }

    @Override // java.util.NavigableSet
    public Object ceiling(Object obj) {
        obj.getClass();
        return zznw.zza(zzo(obj, true), null);
    }

    @Override // java.util.NavigableSet
    public Object floor(Object obj) {
        obj.getClass();
        return zznz.zza(zzm(obj, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public Object higher(Object obj) {
        obj.getClass();
        return zznw.zza(zzo(obj, false), null);
    }

    @Override // java.util.NavigableSet
    public Object lower(Object obj) {
        obj.getClass();
        return zznz.zza(zzm(obj, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        obj.getClass();
        return zzm(obj, z);
    }

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        obj.getClass();
        return zzo(obj, z);
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public final zznv subSet(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        zzls.zza(this.zza.compare(obj, obj2) <= 0);
        return zzn(obj, z, obj2, z2);
    }
}
