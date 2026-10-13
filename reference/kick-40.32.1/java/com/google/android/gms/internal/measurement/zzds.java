package com.google.android.gms.internal.measurement;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzds extends zzcu {
    final /* synthetic */ Runnable zza;

    zzds(zzdt zzdtVar, Runnable runnable) {
        this.zza = runnable;
        Objects.requireNonNull(zzdtVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void zze() {
        this.zza.run();
    }
}
