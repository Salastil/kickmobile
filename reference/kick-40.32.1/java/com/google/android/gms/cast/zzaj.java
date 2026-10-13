package com.google.android.gms.cast;

import android.os.Binder;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaj extends Binder {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    zzaj(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        Objects.requireNonNull(castRemoteDisplayLocalService);
        this.zza = castRemoteDisplayLocalService;
    }
}
