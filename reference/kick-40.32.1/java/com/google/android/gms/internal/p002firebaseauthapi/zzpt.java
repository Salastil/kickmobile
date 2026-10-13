package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Add missing generic type declarations: [P] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzpt<P> implements Iterable<P> {
    private final /* synthetic */ List zza;
    private final /* synthetic */ List zzb;

    @Override // java.lang.Iterable
    public final Iterator<P> iterator() {
        return new zzpv(this.zza.iterator(), this.zzb.iterator());
    }

    zzpt(zzpu zzpuVar, List list, List list2) {
        this.zza = list;
        this.zzb = list2;
        Objects.requireNonNull(zzpuVar);
    }
}
