package com.google.android.gms.cast;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzae implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ CastRemoteDisplayLocalService zzb;

    zzae(CastRemoteDisplayLocalService castRemoteDisplayLocalService, boolean z) {
        this.zza = z;
        Objects.requireNonNull(castRemoteDisplayLocalService);
        this.zzb = castRemoteDisplayLocalService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
    }
}
