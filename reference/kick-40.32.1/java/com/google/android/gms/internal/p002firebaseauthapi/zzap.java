package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzap<T> extends zzba<T> {
    private final T zza;
    private boolean zzb;

    @Override // java.util.Iterator
    public final T next() {
        if (this.zzb) {
            throw new NoSuchElementException();
        }
        this.zzb = true;
        return this.zza;
    }

    zzap(T t) {
        this.zza = t;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zzb;
    }
}
