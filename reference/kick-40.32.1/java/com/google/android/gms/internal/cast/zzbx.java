package com.google.android.gms.internal.cast;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import androidx.mediarouter.media.MediaRouterParams;
import androidx.mediarouter.media.MediaTransferReceiver;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.SessionTransferCallback;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbx extends zzbd {
    private static final Logger zza = new Logger("MediaRouterProxy");
    private final MediaRouter zzb;
    private final CastOptions zzc;
    private final Map zzd = new HashMap();
    private zzce zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;

    public zzbx(Context context, MediaRouter mediaRouter, CastOptions castOptions, com.google.android.gms.cast.internal.zzn zznVar) {
        this.zzb = mediaRouter;
        this.zzc = castOptions;
        if (Build.VERSION.SDK_INT < 33) {
            return;
        }
        zza.d("Set up MediaRouterParams based on module flag and CastOptions for Android T or above", new Object[0]);
        this.zze = new zzce(castOptions);
        Intent intent = new Intent(context, (Class<?>) MediaTransferReceiver.class);
        intent.setPackage(context.getPackageName());
        this.zzf = !context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty();
        this.zzg = true;
        zznVar.zzb(new String[]{"com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED"}).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.cast.zzbw
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                this.zza.zzv(task);
            }
        });
    }

    private final void zzy(MediaRouteSelector mediaRouteSelector, int i) {
        Set set = (Set) this.zzd.get(mediaRouteSelector);
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.zzb.addCallback(mediaRouteSelector, (MediaRouter.Callback) it.next(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public final void zzx(MediaRouteSelector mediaRouteSelector) {
        Set set = (Set) this.zzd.get(mediaRouteSelector);
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.zzb.removeCallback((MediaRouter.Callback) it.next());
        }
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final void zzb(Bundle bundle, zzbg zzbgVar) {
        MediaRouteSelector mediaRouteSelectorFromBundle = MediaRouteSelector.fromBundle(bundle);
        if (mediaRouteSelectorFromBundle == null) {
            return;
        }
        Map map = this.zzd;
        if (!map.containsKey(mediaRouteSelectorFromBundle)) {
            map.put(mediaRouteSelectorFromBundle, new HashSet());
        }
        ((Set) map.get(mediaRouteSelectorFromBundle)).add(new zzbl(zzbgVar, this, this.zze));
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final void zzc(Bundle bundle, final int i) {
        final MediaRouteSelector mediaRouteSelectorFromBundle = MediaRouteSelector.fromBundle(bundle);
        if (mediaRouteSelectorFromBundle == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzy(mediaRouteSelectorFromBundle, i);
        } else {
            new zzfk(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.cast.zzbu
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzw(mediaRouteSelectorFromBundle, i);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final void zzd(Bundle bundle) {
        final MediaRouteSelector mediaRouteSelectorFromBundle = MediaRouteSelector.fromBundle(bundle);
        if (mediaRouteSelectorFromBundle == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzx(mediaRouteSelectorFromBundle);
        } else {
            new zzfk(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.cast.zzbv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzx(mediaRouteSelectorFromBundle);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final boolean zze(Bundle bundle, int i) {
        MediaRouteSelector mediaRouteSelectorFromBundle = MediaRouteSelector.fromBundle(bundle);
        if (mediaRouteSelectorFromBundle == null) {
            return false;
        }
        return this.zzb.isRouteAvailable(mediaRouteSelectorFromBundle, i);
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final void zzf(String str) {
        Logger logger = zza;
        logger.d("select route with routeId = %s", str);
        MediaRouter mediaRouter = this.zzb;
        for (MediaRouter.RouteInfo routeInfo : mediaRouter.getRoutes()) {
            if (routeInfo.getId().equals(str)) {
                logger.d("media route is found and selected", new Object[0]);
                mediaRouter.selectRoute(routeInfo);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final void zzg() {
        MediaRouter mediaRouter = this.zzb;
        mediaRouter.selectRoute(mediaRouter.getDefaultRoute());
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final boolean zzh() {
        MediaRouter mediaRouter = this.zzb;
        MediaRouter.RouteInfo defaultRoute = mediaRouter.getDefaultRoute();
        return defaultRoute != null && mediaRouter.getSelectedRoute().getId().equals(defaultRoute.getId());
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final Bundle zzi(String str) {
        for (MediaRouter.RouteInfo routeInfo : this.zzb.getRoutes()) {
            if (routeInfo.getId().equals(str)) {
                return routeInfo.getExtras();
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final String zzj() {
        return this.zzb.getSelectedRoute().getId();
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final void zzk() {
        Map map = this.zzd;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Set) it.next()).iterator();
            while (it2.hasNext()) {
                this.zzb.removeCallback((MediaRouter.Callback) it2.next());
            }
        }
        map.clear();
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final boolean zzl() {
        MediaRouter mediaRouter = this.zzb;
        MediaRouter.RouteInfo bluetoothRoute = mediaRouter.getBluetoothRoute();
        return bluetoothRoute != null && mediaRouter.getSelectedRoute().getId().equals(bluetoothRoute.getId());
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final void zzm(int i) {
        this.zzb.unselect(i);
    }

    @Override // com.google.android.gms.internal.cast.zzbe
    public final void zzn(String str) {
        MediaRouter mediaRouter = this.zzb;
        for (MediaRouter.GroupRouteInfo groupRouteInfo : mediaRouter.getConnectedGroupRoutes()) {
            if (groupRouteInfo.getId().equals(str)) {
                zza.d("clean up the connectedGroupRoute = %s", groupRouteInfo);
                groupRouteInfo.disconnect();
            }
        }
        MediaRouter.RouteInfo selectedRoute = mediaRouter.getSelectedRoute();
        if (selectedRoute == null || selectedRoute.isSystemRoute() || !selectedRoute.getId().equals(str)) {
            return;
        }
        zza.d("clean up the selected route = %s", selectedRoute);
        mediaRouter.unselect(0);
    }

    public final boolean zzo() {
        CastOptions castOptions;
        return this.zzf && this.zzg && (castOptions = this.zzc) != null && castOptions.zzf();
    }

    public final void zzp(boolean z) {
        this.zzh = z;
    }

    public final boolean zzq() {
        return this.zzh;
    }

    public final void zzr(SessionTransferCallback sessionTransferCallback) {
        zzce zzceVar = this.zze;
        if (zzceVar != null) {
            zzceVar.zzc(sessionTransferCallback);
            this.zzb.setOnPrepareTransferListener(new zzbt((zzce) Preconditions.checkNotNull(this.zze)));
        }
    }

    public final void zzs(SessionTransferCallback sessionTransferCallback) {
        zzce zzceVar = this.zze;
        if (zzceVar != null) {
            zzceVar.zzd(sessionTransferCallback);
            this.zzb.setOnPrepareTransferListener(null);
        }
    }

    public final zzce zzt() {
        return this.zze;
    }

    public final void zzu(MediaSessionCompat mediaSessionCompat) {
        this.zzb.setMediaSessionCompat(mediaSessionCompat);
    }

    final /* synthetic */ void zzv(Task task) {
        CastOptions castOptions;
        if (task.isSuccessful()) {
            Bundle bundle = (Bundle) task.getResult();
            boolean z = bundle != null && bundle.containsKey("com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED");
            zza.d("The module-to-client output switcher flag %s", true != z ? "not existed" : "existed");
            if (z) {
                this.zzg = bundle.getBoolean("com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED");
            }
        }
        boolean z2 = this.zzg;
        MediaRouter mediaRouter = this.zzb;
        if (mediaRouter == null || (castOptions = this.zzc) == null) {
            return;
        }
        boolean zZzd = castOptions.zzd();
        boolean zZzc = castOptions.zzc();
        boolean z3 = z2 && castOptions.zzf();
        mediaRouter.setRouterParams(new MediaRouterParams.Builder().setMediaTransferReceiverEnabled(z3).setTransferToLocalEnabled(zZzd).setOutputSwitcherEnabled(zZzc).setMediaTransferRestrictedToSelfProviders(castOptions.zzi()).build());
        zza.i("media transfer = %b, session transfer = %b, transfer to local = %b, in-app output switcher = %b", Boolean.valueOf(this.zzf), Boolean.valueOf(z3), Boolean.valueOf(zZzd), Boolean.valueOf(zZzc));
        zzce zzceVar = this.zze;
        if (zzceVar != null) {
            zzceVar.zzb(this.zzf && z3);
        }
        if (this.zzf && z3) {
            zzr.zzb(zzpm.CAST_OUTPUT_SWITCHER_ENABLED);
        }
        if (zZzd) {
            zzr.zzb(zzpm.CAST_TRANSFER_TO_LOCAL_ENABLED);
        }
    }

    final /* synthetic */ void zzw(MediaRouteSelector mediaRouteSelector, int i) {
        synchronized (this.zzd) {
            zzy(mediaRouteSelector, i);
        }
    }
}
