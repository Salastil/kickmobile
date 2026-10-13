package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzasf extends zzasj {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzasf(zzasg zzasgVar) {
        super(zzasgVar.zza);
        Objects.requireNonNull(zzasgVar);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return zza();
    }
}
