package com.amazonaws.ivs.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.system.OsConstants;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.media3.common.PlaybackException;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import java.net.Inet6Address;

/* JADX INFO: loaded from: classes5.dex */
public class NetworkLinkInfo {
    private static final String TAG = "AmazonIVSNet";
    private ConnectivityManager.NetworkCallback callback;
    private ConnectivityManager connectivityManager;
    private final Context context;
    private boolean isPermissionAccessNetworkState;
    private long nativeListener;
    private Boolean isOnline = null;
    private final Object lock = new Object();

    enum CellularNetworkType {
        TYPE_2G,
        TYPE_3G,
        TYPE_4G,
        TYPE_5G
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void onNetworkAvailable(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void onNetworkLost(long j);

    public NetworkLinkInfo(Context context) {
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        this.context = applicationContext;
        if (applicationContext == null) {
            Log.w(TAG, "NetworkConnectivity null context, info not available");
        } else {
            this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }
    }

    private Network getActiveNetwork() {
        if (!this.isPermissionAccessNetworkState && this.context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        this.isPermissionAccessNetworkState = true;
        return this.connectivityManager.getActiveNetwork();
    }

    public String getNetworkType() {
        if (this.context != null) {
            Network activeNetwork = getActiveNetwork();
            if (activeNetwork == null) {
                return "None";
            }
            NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                return ViewUtilsKt.UNKNOWN_DESTINATION_URL;
            }
            if (networkCapabilities.hasTransport(3)) {
                return "Ethernet";
            }
            if (networkCapabilities.hasTransport(1)) {
                return "Wifi";
            }
            if (networkCapabilities.hasTransport(2)) {
                return "Bluetooth";
            }
            if (networkCapabilities.hasTransport(0)) {
                if (this.context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                    int iOrdinal = getCellularNetworkType().ordinal();
                    if (iOrdinal == 0) {
                        return "Cellular_2g";
                    }
                    if (iOrdinal == 2) {
                        return "Cellular_4g";
                    }
                    if (iOrdinal != 3) {
                        return "Cellular_3g";
                    }
                    return "Cellular_5g";
                }
                return "Cellular";
            }
        }
        return ViewUtilsKt.UNKNOWN_DESTINATION_URL;
    }

    private CellularNetworkType getCellularNetworkType() {
        int networkType = ((TelephonyManager) this.context.getSystemService("phone")).getNetworkType();
        if (networkType == 0 || networkType == 1 || networkType == 2 || networkType == 7 || networkType == 11) {
            return CellularNetworkType.TYPE_2G;
        }
        if (networkType == 13 || networkType == 19) {
            return CellularNetworkType.TYPE_4G;
        }
        if (networkType != 20) {
            return CellularNetworkType.TYPE_3G;
        }
        return CellularNetworkType.TYPE_5G;
    }

    private int getCellularMaxLinkSpeedKbps() {
        int networkType = ((TelephonyManager) this.context.getSystemService("phone")).getNetworkType();
        if (networkType == 1) {
            return 100;
        }
        if (networkType == 2) {
            return 300;
        }
        if (networkType == 15) {
            return 21000;
        }
        if (networkType == 16) {
            return 300;
        }
        if (networkType == 19) {
            return 300000;
        }
        if (networkType == 20) {
            return 1000000;
        }
        switch (networkType) {
            case 6:
                return 2000;
            case 7:
                return 100;
            case 8:
            case 9:
                return 14000;
            case 10:
                return PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED;
            case 11:
                return 300;
            case 12:
                return 3000;
            case 13:
                return 50000;
            default:
                return 1000;
        }
    }

    public int getDownlinkBandwidth() {
        if (this.context == null) {
            return -1;
        }
        NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(getActiveNetwork());
        if (networkCapabilities == null) {
            return -1;
        }
        if (networkCapabilities.hasTransport(1)) {
            WifiManager wifiManager = (WifiManager) this.context.getApplicationContext().getSystemService("wifi");
            if (this.context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    return connectionInfo.getLinkSpeed() * 1000000;
                }
            } else {
                Log.w(TAG, "No permission for ACCESS_WIFI_STATE");
            }
        }
        if (networkCapabilities.hasTransport(0)) {
            return Math.min(getCellularMaxLinkSpeedKbps(), networkCapabilities.getLinkDownstreamBandwidthKbps()) * 1000;
        }
        return networkCapabilities.getLinkDownstreamBandwidthKbps() * 1000;
    }

    public boolean getNetworkOnline() {
        Boolean bool = this.isOnline;
        if (bool != null) {
            return bool.booleanValue();
        }
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean hasIPv6Connectivity() {
        Network activeNetwork;
        LinkProperties linkProperties;
        if (this.context == null || (activeNetwork = getActiveNetwork()) == null || (linkProperties = this.connectivityManager.getLinkProperties(activeNetwork)) == null) {
            return false;
        }
        for (LinkAddress linkAddress : linkProperties.getLinkAddresses()) {
            if ((linkAddress.getAddress() instanceof Inet6Address) && linkAddress.getScope() == OsConstants.RT_SCOPE_UNIVERSE) {
                for (RouteInfo routeInfo : linkProperties.getRoutes()) {
                    if (routeInfo.isDefaultRoute() && (routeInfo.getDestination().getAddress() instanceof Inet6Address)) {
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021 A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x0016, B:10:0x0019, B:12:0x0021, B:13:0x0028, B:16:0x0031, B:17:0x0038, B:8:0x000f), top: B:26:0x0003, inners: #0, #1 }] */
    public void setListener(long j) {
        synchronized (this.lock) {
            this.nativeListener = j;
            ConnectivityManager.NetworkCallback networkCallback = this.callback;
            if (networkCallback != null) {
                try {
                    this.connectivityManager.unregisterNetworkCallback(networkCallback);
                } catch (IllegalArgumentException unused) {
                    Log.w(TAG, "NetworkCallback was already unregistered");
                }
                this.callback = null;
                if (this.nativeListener != 0) {
                    this.callback = new ConnectivityManager.NetworkCallback() { // from class: com.amazonaws.ivs.net.NetworkLinkInfo.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            synchronized (NetworkLinkInfo.this.lock) {
                                NetworkLinkInfo.this.isOnline = true;
                                if (NetworkLinkInfo.this.nativeListener != 0) {
                                    NetworkLinkInfo networkLinkInfo = NetworkLinkInfo.this;
                                    networkLinkInfo.onNetworkAvailable(networkLinkInfo.nativeListener);
                                }
                            }
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLost(Network network) {
                            synchronized (NetworkLinkInfo.this.lock) {
                                NetworkLinkInfo.this.isOnline = false;
                                if (NetworkLinkInfo.this.nativeListener != 0) {
                                    NetworkLinkInfo networkLinkInfo = NetworkLinkInfo.this;
                                    networkLinkInfo.onNetworkLost(networkLinkInfo.nativeListener);
                                }
                            }
                        }
                    };
                    try {
                        this.connectivityManager.registerDefaultNetworkCallback(this.callback);
                    } catch (Exception e) {
                        Log.w(TAG, "Unable to monitor network changes", e);
                    }
                }
            } else if (this.nativeListener != 0) {
                this.callback = new ConnectivityManager.NetworkCallback() { // from class: com.amazonaws.ivs.net.NetworkLinkInfo.1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        synchronized (NetworkLinkInfo.this.lock) {
                            NetworkLinkInfo.this.isOnline = true;
                            if (NetworkLinkInfo.this.nativeListener != 0) {
                                NetworkLinkInfo networkLinkInfo = NetworkLinkInfo.this;
                                networkLinkInfo.onNetworkAvailable(networkLinkInfo.nativeListener);
                            }
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(Network network) {
                        synchronized (NetworkLinkInfo.this.lock) {
                            NetworkLinkInfo.this.isOnline = false;
                            if (NetworkLinkInfo.this.nativeListener != 0) {
                                NetworkLinkInfo networkLinkInfo = NetworkLinkInfo.this;
                                networkLinkInfo.onNetworkLost(networkLinkInfo.nativeListener);
                            }
                        }
                    }
                };
                this.connectivityManager.registerDefaultNetworkCallback(this.callback);
            }
            throw th;
        }
    }
}
