package expo.modules.network;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TAG", "", "kotlin.jvm.PlatformType", "isInternetReachable", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "sdkInt", "", "expo-network_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NetworkUtilsKt {
    private static final String TAG = "NetworkModule";

    public static /* synthetic */ boolean isInternetReachable$default(ConnectivityManager connectivityManager, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return isInternetReachable(connectivityManager, i);
    }

    public static final boolean isInternetReachable(ConnectivityManager connectivityManager, int i) {
        NetworkCapabilities networkCapabilities;
        NetworkInfo networkInfo;
        boolean zHasCapability;
        Intrinsics.checkNotNullParameter(connectivityManager, "connectivityManager");
        Network activeNetwork = connectivityManager.getActiveNetwork();
        boolean z = false;
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        if (i >= 29) {
            zHasCapability = networkCapabilities.hasCapability(21);
        } else {
            try {
                networkInfo = connectivityManager.getNetworkInfo(activeNetwork);
            } catch (SecurityException e) {
                Log.w(TAG, "expo-network could not read network state: missing ACCESS_NETWORK_STATE permission", e);
                networkInfo = null;
            }
            zHasCapability = (networkInfo != null ? networkInfo.getDetailedState() : null) == NetworkInfo.DetailedState.CONNECTED;
        }
        boolean z2 = networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16) && zHasCapability;
        if (!networkCapabilities.hasTransport(4)) {
            return z2;
        }
        if (z2 && networkCapabilities.getLinkDownstreamBandwidthKbps() != 0) {
            z = true;
        }
        return z;
    }
}
