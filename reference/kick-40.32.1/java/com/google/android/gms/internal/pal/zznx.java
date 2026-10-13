package com.google.android.gms.internal.pal;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zznx implements zzoe {
    private final Iterator zza;
    private boolean zzb;
    private Object zzc;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb || this.zza.hasNext();
    }

    @Override // com.google.android.gms.internal.pal.zzoe, java.util.Iterator
    public final Object next() {
        if (!this.zzb) {
            return this.zza.next();
        }
        Object obj = this.zzc;
        this.zzb = false;
        this.zzc = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzls.zzg(!this.zzb, "Can't remove after you've peeked at next");
        this.zza.remove();
    }

    @Override // com.google.android.gms.internal.pal.zzoe
    public final Object zza() {
        if (!this.zzb) {
            this.zzc = this.zza.next();
            this.zzb = true;
        }
        return this.zzc;
    }

    zznx(Iterator it) {
        it.getClass();
        this.zza = it;
    }
}
