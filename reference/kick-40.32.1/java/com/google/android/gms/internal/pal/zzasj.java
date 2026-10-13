package com.google.android.gms.internal.pal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzasj implements Iterator {
    zzask zza;
    zzask zzb;
    int zzc;
    final /* synthetic */ zzasl zzd;

    zzasj(zzasl zzaslVar) {
        Objects.requireNonNull(zzaslVar);
        this.zzd = zzaslVar;
        this.zza = zzaslVar.zzd.zzd;
        this.zzb = null;
        this.zzc = zzaslVar.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza != this.zzd.zzd;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzask zzaskVar = this.zzb;
        if (zzaskVar == null) {
            throw new IllegalStateException();
        }
        zzasl zzaslVar = this.zzd;
        zzaslVar.zzd(zzaskVar, true);
        this.zzb = null;
        this.zzc = zzaslVar.zzc;
    }

    final zzask zza() {
        zzasl zzaslVar = this.zzd;
        zzask zzaskVar = this.zza;
        if (zzaskVar == zzaslVar.zzd) {
            throw new NoSuchElementException();
        }
        if (zzaslVar.zzc != this.zzc) {
            throw new ConcurrentModificationException();
        }
        this.zza = zzaskVar.zzd;
        this.zzb = zzaskVar;
        return zzaskVar;
    }
}
