package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzef extends Exception {
    public zzef(zzeg zzegVar) {
        Objects.requireNonNull(zzegVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzef(zzeg zzegVar, Throwable th) {
        super(th);
        Objects.requireNonNull(zzegVar);
    }
}
