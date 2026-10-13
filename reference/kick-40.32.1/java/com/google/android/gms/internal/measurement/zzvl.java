package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzvl extends AbstractFuture {
    private final int zza;

    zzvl(int i) {
        this.zza = i;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final boolean setFuture(ListenableFuture listenableFuture) {
        return super.setFuture(listenableFuture);
    }

    final /* synthetic */ int zza() {
        return this.zza;
    }
}
