package com.google.android.gms.internal.cast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.google.android.gms.cast.internal.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzek implements zzeg {
    private static final Logger zzb = new Logger("ConnectivityMonitor");
    public final Set zza;
    private final zzwo zzc;
    private final ConnectivityManager zze;
    private boolean zzh;
    private final Context zzi;
    private final boolean zzk;
    private final BroadcastReceiver zzl;
    private final ConnectivityManager.NetworkCallback zzd = new zzeh(this);
    private final Map zzf = new HashMap();
    private final List zzg = new ArrayList();
    private final Object zzj = new Object();

    public zzek(Context context, zzwo zzwoVar) {
        this.zzk = Build.VERSION.SDK_INT >= 31;
        this.zzl = new zzei(this);
        this.zza = new HashSet();
        this.zzc = zzwoVar;
        this.zzi = context;
        this.zze = (ConnectivityManager) context.getSystemService("connectivity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final void zzc(Network network, LinkProperties linkProperties) {
        synchronized (this.zzj) {
            zzb.d("a new network is available", new Object[0]);
            Map map = this.zzf;
            if (map.containsKey(network)) {
                this.zzg.remove(network);
            }
            map.put(network, linkProperties);
            this.zzg.add(network);
        }
        zzf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final void zzf() {
        zzwo zzwoVar = this.zzc;
        if (zzwoVar == null) {
            return;
        }
        Set<zzef> set = this.zza;
        synchronized (set) {
            for (final zzef zzefVar : set) {
                if (!zzwoVar.isShutdown()) {
                    zzwoVar.execute(new Runnable() { // from class: com.google.android.gms.internal.cast.zzej
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zzb(zzefVar);
                        }
                    });
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.cast.zzeg
    public final void zza() {
        ConnectivityManager connectivityManager;
        LinkProperties linkProperties;
        zzb.d("Start monitoring connectivity changes", new Object[0]);
        if (this.zzh || (connectivityManager = this.zze) == null) {
            return;
        }
        Context context = this.zzi;
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) != null) {
                zzc(activeNetwork, linkProperties);
            }
            NetworkRequest.Builder builderAddTransportType = new NetworkRequest.Builder().addTransportType(1);
            if (this.zzk) {
                builderAddTransportType.setIncludeOtherUidNetworks(true);
            } else {
                context.registerReceiver(this.zzl, new IntentFilter("android.net.wifi.STATE_CHANGE"));
            }
            connectivityManager.registerNetworkCallback(builderAddTransportType.build(), this.zzd);
            this.zzh = true;
        }
    }

    final /* synthetic */ void zzb(zzef zzefVar) {
        boolean zIsEmpty;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        synchronized (this.zzj) {
            zIsEmpty = this.zzg.isEmpty();
        }
        if (!zIsEmpty && !this.zzk && (connectivityManager = this.zze) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            activeNetworkInfo.isConnected();
        }
        zzefVar.zza();
    }

    final /* synthetic */ void zzd(Network network) {
        synchronized (this.zzj) {
            zzb.d("the network is lost", new Object[0]);
            if (this.zzg.remove(network)) {
                this.zzf.remove(network);
            }
        }
        zzf();
    }

    final /* synthetic */ void zze() {
        synchronized (this.zzj) {
            zzb.d("all networks are unavailable.", new Object[0]);
            this.zzf.clear();
            this.zzg.clear();
        }
        zzf();
    }
}
