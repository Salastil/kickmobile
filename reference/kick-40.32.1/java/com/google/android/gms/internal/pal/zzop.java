package com.google.android.gms.internal.pal;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzop extends zznv {
    static final zzop zzc;
    final transient zznm zzd;

    static {
        int i = zznm.zzd;
        zzc = new zzop(zzoi.zza, zzob.zza);
    }

    zzop(zznm zznmVar, Comparator comparator) {
        super(comparator);
        this.zzd = zznmVar;
    }

    @Override // com.google.android.gms.internal.pal.zznv, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        zznm zznmVar = this.zzd;
        int iZzs = zzs(obj, true);
        if (iZzs == zznmVar.size()) {
            return null;
        }
        return zznmVar.get(iZzs);
    }

    @Override // com.google.android.gms.internal.pal.zznh, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.zzd, obj, this.zza) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzoa) {
            collection = ((zzoa) collection).zza();
        }
        Comparator comparator = ((zznv) this).zza;
        if (!zzot.zza(comparator, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        zzov zzovVarListIterator = this.zzd.listIterator(0);
        Iterator it = collection.iterator();
        if (!zzovVarListIterator.hasNext()) {
            return false;
        }
        Object next = it.next();
        E next2 = zzovVarListIterator.next();
        while (true) {
            try {
                int iCompare = comparator.compare(next2, next);
                if (iCompare < 0) {
                    if (!zzovVarListIterator.hasNext()) {
                        return false;
                    }
                    next2 = zzovVarListIterator.next();
                } else {
                    if (iCompare != 0) {
                        return false;
                    }
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zznt, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        zznm zznmVar = this.zzd;
        if (zznmVar.size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!zzot.zza(this.zza, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            zzov zzovVarListIterator = zznmVar.listIterator(0);
            while (zzovVarListIterator.hasNext()) {
                E next = zzovVarListIterator.next();
                Object next2 = it.next();
                if (next2 == null || ((zznv) this).zza.compare(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.pal.zznv, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.zzd.get(0);
    }

    @Override // com.google.android.gms.internal.pal.zznv, java.util.NavigableSet
    public final Object floor(Object obj) {
        int iZzr = zzr(obj, true) - 1;
        if (iZzr == -1) {
            return null;
        }
        return this.zzd.get(iZzr);
    }

    @Override // com.google.android.gms.internal.pal.zznv, java.util.NavigableSet
    public final Object higher(Object obj) {
        zznm zznmVar = this.zzd;
        int iZzs = zzs(obj, false);
        if (iZzs == zznmVar.size()) {
            return null;
        }
        return zznmVar.get(iZzs);
    }

    @Override // com.google.android.gms.internal.pal.zznv, com.google.android.gms.internal.pal.zznt, com.google.android.gms.internal.pal.zznh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.pal.zznv, java.util.SortedSet
    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        zznm zznmVar = this.zzd;
        return zznmVar.get(zznmVar.size() - 1);
    }

    @Override // com.google.android.gms.internal.pal.zznv, java.util.NavigableSet
    public final Object lower(Object obj) {
        int iZzr = zzr(obj, false) - 1;
        if (iZzr == -1) {
            return null;
        }
        return this.zzd.get(iZzr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd.size();
    }

    @Override // com.google.android.gms.internal.pal.zznv, com.google.android.gms.internal.pal.zznt, com.google.android.gms.internal.pal.zznh
    /* JADX INFO: renamed from: zza */
    public final zzou iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.pal.zznh
    final Object[] zzb() {
        return this.zzd.zzb();
    }

    @Override // com.google.android.gms.internal.pal.zznh
    final int zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.pal.zznh
    final int zzd() {
        return this.zzd.zzd();
    }

    @Override // com.google.android.gms.internal.pal.zznh
    final int zze(Object[] objArr, int i) {
        return this.zzd.zze(objArr, 0);
    }

    @Override // com.google.android.gms.internal.pal.zznt
    public final zznm zzh() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.pal.zznv
    final zznv zzm(Object obj, boolean z) {
        return zzt(0, zzr(obj, z));
    }

    @Override // com.google.android.gms.internal.pal.zznv
    final zznv zzn(Object obj, boolean z, Object obj2, boolean z2) {
        return zzo(obj, z).zzm(obj2, z2);
    }

    @Override // com.google.android.gms.internal.pal.zznv
    final zznv zzo(Object obj, boolean z) {
        return zzt(zzs(obj, z), this.zzd.size());
    }

    @Override // com.google.android.gms.internal.pal.zznv
    final zznv zzp() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.zza);
        return isEmpty() ? zzk(comparatorReverseOrder) : new zzop(this.zzd.zzf(), comparatorReverseOrder);
    }

    @Override // com.google.android.gms.internal.pal.zznv, java.util.NavigableSet
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public final zzou descendingIterator() {
        return this.zzd.zzf().listIterator(0);
    }

    final zzop zzt(int i, int i2) {
        if (i == 0) {
            if (i2 == this.zzd.size()) {
                return this;
            }
            i = 0;
        }
        if (i >= i2) {
            return zzk(this.zza);
        }
        zznm zznmVar = this.zzd;
        return new zzop(zznmVar.subList(i, i2), this.zza);
    }

    final int zzr(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.zzd, obj, ((zznv) this).zza);
        if (iBinarySearch >= 0) {
            return z ? iBinarySearch + 1 : iBinarySearch;
        }
        return ~iBinarySearch;
    }

    final int zzs(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.zzd, obj, ((zznv) this).zza);
        if (iBinarySearch >= 0) {
            return z ? iBinarySearch : iBinarySearch + 1;
        }
        return ~iBinarySearch;
    }
}
