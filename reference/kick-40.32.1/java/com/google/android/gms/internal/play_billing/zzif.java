package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzif implements Iterator {
    final /* synthetic */ zzii zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzif(zzii zziiVar, zzih zzihVar) {
        Objects.requireNonNull(zziiVar);
        this.zza = zziiVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzii zziiVar = this.zza;
        if (i >= zziiVar.zzb) {
            return !zziiVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzii zziiVar = this.zza;
        return i < zziiVar.zzb ? (zzie) zziiVar.zza[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzii zziiVar = this.zza;
        zziiVar.zzo();
        int i = this.zzb;
        if (i >= zziiVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i - 1;
            zziiVar.zzm(i);
        }
    }
}
