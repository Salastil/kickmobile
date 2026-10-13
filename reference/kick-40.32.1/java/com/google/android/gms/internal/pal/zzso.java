package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzso implements Iterator {
    final /* synthetic */ zzsp zza;
    private int zzb;

    zzso(zzsp zzspVar) {
        Objects.requireNonNull(zzspVar);
        this.zza = zzspVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb;
        zzsp zzspVar = this.zza;
        return i < zzspVar.zzc() - zzspVar.zzb();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zzb;
        zzsp zzspVar = this.zza;
        if (i >= zzspVar.zzc() - zzspVar.zzb()) {
            throw new NoSuchElementException();
        }
        zzsq zzsqVar = zzspVar.zzb;
        Object obj = zzsqVar.zzb()[zzspVar.zzb() + i];
        this.zzb = i + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
