package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzok extends zznt {
    private final transient zznp zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzok(zznp zznpVar, Object[] objArr, int i, int i2) {
        this.zza = zznpVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.pal.zznh, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.pal.zznt, com.google.android.gms.internal.pal.zznh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzh().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.pal.zznt, com.google.android.gms.internal.pal.zznh
    /* JADX INFO: renamed from: zza */
    public final zzou iterator() {
        return zzh().listIterator(0);
    }

    @Override // com.google.android.gms.internal.pal.zznh
    final int zze(Object[] objArr, int i) {
        return zzh().zze(objArr, 0);
    }

    @Override // com.google.android.gms.internal.pal.zznt
    final zznm zzi() {
        return new zzoj(this);
    }

    final /* synthetic */ Object[] zzk() {
        return this.zzb;
    }

    final /* synthetic */ int zzl() {
        return this.zzc;
    }
}
