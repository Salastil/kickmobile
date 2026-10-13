package com.google.android.gms.cast;

import androidx.mediarouter.media.MediaRouter;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzab extends MediaRouter.Callback {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    zzab(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        Objects.requireNonNull(castRemoteDisplayLocalService);
        this.zza = castRemoteDisplayLocalService;
    }

    @Override // androidx.mediarouter.media.MediaRouter.Callback
    public final void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.zza;
        castRemoteDisplayLocalService.zzg("onRouteUnselected");
        if (castRemoteDisplayLocalService.zzm() == null) {
            castRemoteDisplayLocalService.zzg("onRouteUnselected, no device was selected");
            return;
        }
        CastDevice fromBundle = CastDevice.getFromBundle(routeInfo.getExtras());
        if (fromBundle != null) {
            if (fromBundle.getDeviceId().equals(castRemoteDisplayLocalService.zzm().getDeviceId())) {
                CastRemoteDisplayLocalService.stopService();
                return;
            }
        }
        castRemoteDisplayLocalService.zzg("onRouteUnselected, device does not match");
    }
}
