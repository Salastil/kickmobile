package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzzx implements Iterator {
    final /* synthetic */ zzzz zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzzx(zzzz zzzzVar, byte[] bArr) {
        Objects.requireNonNull(zzzzVar);
        this.zza = zzzzVar;
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
        zzzz zzzzVar = this.zza;
        if (i >= zzzzVar.zzj()) {
            return !zzzzVar.zzk().isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzzz zzzzVar = this.zza;
        return i < zzzzVar.zzj() ? (zzzw) zzzzVar.zzi()[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzzz zzzzVar = this.zza;
        zzzzVar.zzh();
        int i = this.zzb;
        if (i >= zzzzVar.zzj()) {
            zza().remove();
        } else {
            this.zzb = i - 1;
            zzzzVar.zzg(i);
        }
    }
}
