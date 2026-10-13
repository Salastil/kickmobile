package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaba implements Iterator {
    final /* synthetic */ zzabb zza;
    private int zzb;

    zzaba(zzabb zzabbVar) {
        Objects.requireNonNull(zzabbVar);
        this.zza = zzabbVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb;
        zzabb zzabbVar = this.zza;
        return i < zzabbVar.zzc() - zzabbVar.zzb();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zzb;
        zzabb zzabbVar = this.zza;
        if (i >= zzabbVar.zzc() - zzabbVar.zzb()) {
            throw new NoSuchElementException();
        }
        zzabc zzabcVar = zzabbVar.zzb;
        Object obj = zzabcVar.zzb()[zzabbVar.zzb() + i];
        this.zzb = i + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
