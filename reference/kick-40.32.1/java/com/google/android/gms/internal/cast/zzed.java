package com.google.android.gms.internal.cast;

import android.os.Bundle;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.CastDevice;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzed extends MediaRouter.Callback {
    final /* synthetic */ zzee zza;

    /* synthetic */ zzed(zzee zzeeVar, byte[] bArr) {
        Objects.requireNonNull(zzeeVar);
        this.zza = zzeeVar;
    }

    @Override // androidx.mediarouter.media.MediaRouter.Callback
    public final void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        zzee.zzb.d("RemoteConnectionMediaRouterCallback.onRouteAdded.", new Object[0]);
        this.zza.zzf(routeInfo.getExtras());
    }

    @Override // androidx.mediarouter.media.MediaRouter.Callback
    public final void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        zzee.zzb.d("RemoteConnectionMediaRouterCallback.onRouteChanged.", new Object[0]);
        this.zza.zzf(routeInfo.getExtras());
    }

    @Override // androidx.mediarouter.media.MediaRouter.Callback
    public final void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        CastDevice fromBundle;
        zzee.zzb.d("RemoteConnectionMediaRouterCallback.onRouteRemoved.", new Object[0]);
        Bundle extras = routeInfo.getExtras();
        if (extras == null || (fromBundle = CastDevice.getFromBundle(extras)) == null) {
            return;
        }
        String string = extras.getString("com.google.android.gms.cast.EXTRA_RUNNING_RECEIVER_APP_ID");
        zzee zzeeVar = this.zza;
        zzdz zzdzVar = (zzdz) zzeeVar.zzi().get(fromBundle.getDeviceId());
        if (zzdzVar != null && string != null) {
            throw null;
        }
        if (zzdzVar != null) {
            com.google.android.gms.cast.framework.zzo zzoVar = new com.google.android.gms.cast.framework.zzo();
            zzoVar.zzb(2422);
            zzdzVar.zzb(zzoVar.zzc());
        }
        if (zzdzVar != null) {
            throw null;
        }
        zzeeVar.zzg(fromBundle);
    }
}
