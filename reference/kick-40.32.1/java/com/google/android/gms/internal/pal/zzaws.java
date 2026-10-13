package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaws implements Iterator {
    final /* synthetic */ zzawu zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzaws(zzawu zzawuVar, byte[] bArr) {
        Objects.requireNonNull(zzawuVar);
        this.zza = zzawuVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzk().entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzawu zzawuVar = this.zza;
        if (i >= zzawuVar.zzj()) {
            return !zzawuVar.zzk().isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzawu zzawuVar = this.zza;
        return i < zzawuVar.zzj() ? (zzawr) zzawuVar.zzi()[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzawu zzawuVar = this.zza;
        zzawuVar.zzh();
        int i = this.zzb;
        if (i >= zzawuVar.zzj()) {
            zza().remove();
        } else {
            this.zzb = i - 1;
            zzawuVar.zzg(i);
        }
    }
}
