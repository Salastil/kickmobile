package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzrj implements Iterator {
    final /* synthetic */ zzrk zza;
    private int zzb;

    zzrj(zzrk zzrkVar) {
        Objects.requireNonNull(zzrkVar);
        this.zza = zzrkVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zza.zza.zzg();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.zzb;
        this.zzb = i + 1;
        zzrm zzrmVar = this.zza.zza;
        return zzrmVar.zzd(zzrmVar.zzf()[i] & 31);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
