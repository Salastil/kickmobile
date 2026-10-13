package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzash extends zzasj {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzash(zzasi zzasiVar) {
        super(zzasiVar.zza);
        Objects.requireNonNull(zzasiVar);
    }

    @Override // java.util.Iterator
    public final Object next() {
        return zza().zzf;
    }
}
