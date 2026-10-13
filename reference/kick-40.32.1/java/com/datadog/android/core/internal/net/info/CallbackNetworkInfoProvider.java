package com.datadog.android.core.internal.net.info;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.telephony.TelephonyManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: CallbackNetworkInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0001\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/datadog/android/core/internal/net/info/CallbackNetworkInfoProvider;", "Landroid/net/ConnectivityManager$NetworkCallback;", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/internal/system/BuildSdkVersionProvider;Lcom/datadog/android/api/InternalLogger;)V", "carrierInfoResolver", "Lcom/datadog/android/core/internal/net/info/CarrierInfoResolver;", "lastNetworkInfo", "Lcom/datadog/android/api/context/NetworkInfo;", "getLatestNetworkInfo", "getNetworkType", "Lcom/datadog/android/api/context/NetworkInfo$Connectivity;", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onCapabilitiesChanged", "", "network", "Landroid/net/Network;", "onLost", "register", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "resolveDownBandwidth", "", "(Landroid/net/NetworkCapabilities;)Ljava/lang/Long;", "resolveStrength", "resolveUpBandwidth", "unregister", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallbackNetworkInfoProvider extends ConnectivityManager.NetworkCallback implements NetworkInfoProvider {
    public static final String ERROR_REGISTER = "We couldn't register a Network Callback, the network information reported will be less accurate.";
    public static final String ERROR_UNREGISTER = "We couldn't unregister the Network Callback";
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private volatile CarrierInfoResolver carrierInfoResolver;
    private final InternalLogger internalLogger;
    private volatile NetworkInfo lastNetworkInfo;

    public /* synthetic */ CallbackNetworkInfoProvider(BuildSdkVersionProvider buildSdkVersionProvider, InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider, internalLogger);
    }

    public CallbackNetworkInfoProvider(BuildSdkVersionProvider buildSdkVersionProvider, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.internalLogger = internalLogger;
        this.lastNetworkInfo = new NetworkInfo(null, null, null, null, null, null, null, 127, null);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        CarrierInfoResolver carrierInfoResolver;
        CarrierInfoResolver carrierInfoResolver2;
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        super.onCapabilitiesChanged(network, networkCapabilities);
        boolean zHasTransport = networkCapabilities.hasTransport(0);
        NetworkInfo.Connectivity networkType = getNetworkType(networkCapabilities);
        Long carrierId = null;
        String carrierName = (!zHasTransport || (carrierInfoResolver2 = this.carrierInfoResolver) == null) ? null : carrierInfoResolver2.getCarrierName();
        if (zHasTransport && (carrierInfoResolver = this.carrierInfoResolver) != null) {
            carrierId = carrierInfoResolver.getCarrierId();
        }
        this.lastNetworkInfo = new NetworkInfo(networkType, carrierName, carrierId, resolveUpBandwidth(networkCapabilities), resolveDownBandwidth(networkCapabilities), resolveStrength(networkCapabilities), null, 64, null);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLost(network);
        this.lastNetworkInfo = new NetworkInfo(NetworkInfo.Connectivity.NETWORK_NOT_CONNECTED, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
    }

    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("phone");
        if (!(systemService instanceof TelephonyManager)) {
            systemService = null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        this.carrierInfoResolver = telephonyManager != null ? new CarrierInfoResolver(telephonyManager, this.internalLogger, this.buildSdkVersionProvider) : null;
        Object systemService2 = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = (ConnectivityManager) (systemService2 instanceof ConnectivityManager ? systemService2 : null);
        if (connectivityManager == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.register.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CallbackNetworkInfoProvider.ERROR_REGISTER;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        try {
            connectivityManager.registerDefaultNetworkCallback(this);
            Network activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (activeNetwork == null || networkCapabilities == null) {
                return;
            }
            onCapabilitiesChanged(activeNetwork, networkCapabilities);
        } catch (SecurityException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.register.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CallbackNetworkInfoProvider.ERROR_REGISTER;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            this.lastNetworkInfo = new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
        } catch (Exception e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.register.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CallbackNetworkInfoProvider.ERROR_REGISTER;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            this.lastNetworkInfo = new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
        }
    }

    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.carrierInfoResolver = null;
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = (ConnectivityManager) (systemService instanceof ConnectivityManager ? systemService : null);
        if (connectivityManager == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.unregister.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CallbackNetworkInfoProvider.ERROR_UNREGISTER;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(this);
        } catch (SecurityException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.unregister.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CallbackNetworkInfoProvider.ERROR_UNREGISTER;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        } catch (RuntimeException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.unregister.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CallbackNetworkInfoProvider.ERROR_UNREGISTER;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
        }
    }

    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    /* JADX INFO: renamed from: getLatestNetworkInfo, reason: from getter */
    public NetworkInfo getLastNetworkInfo() {
        return this.lastNetworkInfo;
    }

    private final Long resolveUpBandwidth(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.getLinkUpstreamBandwidthKbps() > 0) {
            return Long.valueOf(networkCapabilities.getLinkUpstreamBandwidthKbps());
        }
        return null;
    }

    private final Long resolveDownBandwidth(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.getLinkDownstreamBandwidthKbps() > 0) {
            return Long.valueOf(networkCapabilities.getLinkDownstreamBandwidthKbps());
        }
        return null;
    }

    private final Long resolveStrength(NetworkCapabilities networkCapabilities) {
        if (!this.buildSdkVersionProvider.getIsAtLeastQ() || networkCapabilities.getSignalStrength() == Integer.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(networkCapabilities.getSignalStrength());
    }

    private final NetworkInfo.Connectivity getNetworkType(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.hasTransport(1)) {
            return NetworkInfo.Connectivity.NETWORK_WIFI;
        }
        if (networkCapabilities.hasTransport(3)) {
            return NetworkInfo.Connectivity.NETWORK_ETHERNET;
        }
        if (networkCapabilities.hasTransport(0)) {
            return NetworkInfo.Connectivity.NETWORK_CELLULAR;
        }
        if (networkCapabilities.hasTransport(2)) {
            return NetworkInfo.Connectivity.NETWORK_BLUETOOTH;
        }
        return NetworkInfo.Connectivity.NETWORK_OTHER;
    }
}
