package com.google.android.gms.internal.pal;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzsp extends AbstractSet {
    final int zza;
    final /* synthetic */ zzsq zzb;

    zzsp(zzsq zzsqVar, int i) {
        Objects.requireNonNull(zzsqVar);
        this.zzb = zzsqVar;
        this.zza = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return Arrays.binarySearch(this.zzb.zzb(), zzb(), zzc(), obj, this.zza == -1 ? zzsq.zza : zzss.zzb) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzso(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zzc() - zzb();
    }

    final Object zza(int i) {
        return this.zzb.zzb()[zzb() + i];
    }

    final int zzb() {
        int i = this.zza;
        if (i == -1) {
            return 0;
        }
        return this.zzb.zzc()[i];
    }

    final int zzc() {
        return this.zzb.zzc()[this.zza + 1];
    }
}
