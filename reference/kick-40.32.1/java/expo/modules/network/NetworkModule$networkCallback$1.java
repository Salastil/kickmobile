package expo.modules.network;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"expo/modules/network/NetworkModule$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "lostNetwork", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "expo-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkModule$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ NetworkModule this$0;

    NetworkModule$networkCallback$1(NetworkModule networkModule) {
        this.this$0 = networkModule;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        NetworkModule networkModule = this.this$0;
        networkModule.asyncEmitNetworkState(networkModule.DELAY_MS);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(final Network lostNetwork) {
        Intrinsics.checkNotNullParameter(lostNetwork, "lostNetwork");
        this.this$0.mainHandler.removeCallbacks(this.this$0.emitRunnable);
        Handler handler = this.this$0.mainHandler;
        final NetworkModule networkModule = this.this$0;
        handler.post(new Runnable() { // from class: expo.modules.network.NetworkModule$networkCallback$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NetworkModule$networkCallback$1.onLost$lambda$1(networkModule, lostNetwork);
            }
        });
    }

    static final void onLost$lambda$1(NetworkModule networkModule, Network network) {
        try {
            Network activeNetwork = networkModule.getConnectivityManager().getActiveNetwork();
            if (activeNetwork != null && !Intrinsics.areEqual(activeNetwork, network)) {
                networkModule.emitNetworkState();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", NetworkModule.NetworkStateType.NONE.getValue());
            bundle.putBoolean("isInternetReachable", false);
            bundle.putBoolean("isConnected", false);
            networkModule.sendEvent(NetworkModuleKt.NETWORK_STATE_EVENT_NAME, bundle);
        } catch (SecurityException e) {
            Log.w(NetworkModuleKt.TAG, "expo-network could not read network state in onLost: missing ACCESS_NETWORK_STATE permission", e);
        } catch (Exception e2) {
            Log.w(NetworkModuleKt.TAG, "expo-network dropped a network state update during teardown (the module or React context is no longer available)", e2);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        NetworkModule networkModule = this.this$0;
        networkModule.asyncEmitNetworkState(networkModule.DELAY_MS);
    }
}
