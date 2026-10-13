package com.datadog.android.core.internal.net.info;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.core.internal.receiver.ThreadSafeReceiver;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: BroadcastReceiverNetworkInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/datadog/android/core/internal/net/info/BroadcastReceiverNetworkInfoProvider;", "Lcom/datadog/android/core/internal/receiver/ThreadSafeReceiver;", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "handler", "Landroid/os/Handler;", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "(Lcom/datadog/android/api/InternalLogger;Landroid/os/Handler;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;)V", "networkInfo", "Lcom/datadog/android/api/context/NetworkInfo;", "buildMobileNetworkInfo", "carrierInfoResolver", "Lcom/datadog/android/core/internal/net/info/CarrierInfoResolver;", "subtype", "", "buildNetworkInfo", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "activeNetworkInfo", "Landroid/net/NetworkInfo;", "getCellularTechnology", "", "getLatestNetworkInfo", "onReceive", "", "intent", "Landroid/content/Intent;", "register", "unregister", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BroadcastReceiverNetworkInfoProvider extends ThreadSafeReceiver implements NetworkInfoProvider {
    private static final String ERROR_HANDLING_BROADCAST_INTENT = "Error handling network info broadcast intent.";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private final Handler handler;
    private final InternalLogger internalLogger;
    private volatile NetworkInfo networkInfo;
    private static final Set<Integer> knownMobileTypes = SetsKt.setOf((Object[]) new Integer[]{0, 4, 5, 2, 3});
    private static final Set<Integer> known2GSubtypes = SetsKt.setOf((Object[]) new Integer[]{1, 2, 4, 7, 11, 16});
    private static final Set<Integer> known3GSubtypes = SetsKt.setOf((Object[]) new Integer[]{3, 5, 6, 8, 9, 10, 12, 14, 15, 17});
    private static final Set<Integer> known4GSubtypes = SetsKt.setOf((Object[]) new Integer[]{13, 18, 19});
    private static final Set<Integer> known5GSubtypes = SetsKt.setOf(20);

    public /* synthetic */ BroadcastReceiverNetworkInfoProvider(InternalLogger internalLogger, Handler handler, BuildSdkVersionProvider buildSdkVersionProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalLogger, handler, (i & 4) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastReceiverNetworkInfoProvider(InternalLogger internalLogger, Handler handler, BuildSdkVersionProvider buildSdkVersionProvider) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.internalLogger = internalLogger;
        this.handler = handler;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.networkInfo = new NetworkInfo(null, null, null, null, null, null, null, 127, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("connectivity");
            if (!(systemService instanceof ConnectivityManager)) {
                systemService = null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            this.networkInfo = buildNetworkInfo(context, connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null);
        } catch (RuntimeException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.net.info.BroadcastReceiverNetworkInfoProvider.onReceive.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return BroadcastReceiverNetworkInfoProvider.ERROR_HANDLING_BROADCAST_INTENT;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }

    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        registerReceiver(context, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), this.handler);
        onReceive(context, null);
    }

    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        unregisterReceiver(context);
    }

    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    /* JADX INFO: renamed from: getLatestNetworkInfo, reason: from getter */
    public NetworkInfo getNetworkInfo() {
        return this.networkInfo;
    }

    private final NetworkInfo buildNetworkInfo(Context context, android.net.NetworkInfo activeNetworkInfo) {
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return new NetworkInfo(NetworkInfo.Connectivity.NETWORK_NOT_CONNECTED, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
        }
        if (activeNetworkInfo.getType() == 1) {
            return new NetworkInfo(NetworkInfo.Connectivity.NETWORK_WIFI, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
        }
        if (activeNetworkInfo.getType() == 9) {
            return new NetworkInfo(NetworkInfo.Connectivity.NETWORK_ETHERNET, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
        }
        if (!knownMobileTypes.contains(Integer.valueOf(activeNetworkInfo.getType()))) {
            return new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
        }
        Object systemService = context.getSystemService("phone");
        if (!(systemService instanceof TelephonyManager)) {
            systemService = null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        return buildMobileNetworkInfo(telephonyManager != null ? new CarrierInfoResolver(telephonyManager, this.internalLogger, this.buildSdkVersionProvider) : null, activeNetworkInfo.getSubtype());
    }

    private final NetworkInfo buildMobileNetworkInfo(CarrierInfoResolver carrierInfoResolver, int subtype) {
        NetworkInfo.Connectivity connectivity;
        if (known2GSubtypes.contains(Integer.valueOf(subtype))) {
            connectivity = NetworkInfo.Connectivity.NETWORK_2G;
        } else if (known3GSubtypes.contains(Integer.valueOf(subtype))) {
            connectivity = NetworkInfo.Connectivity.NETWORK_3G;
        } else if (known4GSubtypes.contains(Integer.valueOf(subtype))) {
            connectivity = NetworkInfo.Connectivity.NETWORK_4G;
        } else {
            connectivity = known5GSubtypes.contains(Integer.valueOf(subtype)) ? NetworkInfo.Connectivity.NETWORK_5G : NetworkInfo.Connectivity.NETWORK_MOBILE_OTHER;
        }
        return new NetworkInfo(connectivity, carrierInfoResolver != null ? carrierInfoResolver.getCarrierName() : null, carrierInfoResolver != null ? carrierInfoResolver.getCarrierId() : null, null, null, null, getCellularTechnology(subtype), 56, null);
    }

    private final String getCellularTechnology(int subtype) {
        switch (subtype) {
            case 1:
                return "GPRS";
            case 2:
                return "Edge";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "CDMAEVDORev0";
            case 6:
                return "CDMAEVDORevA";
            case 7:
                return "CDMA1x";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDen";
            case 12:
                return "CDMAEVDORevB";
            case 13:
                return "LTE";
            case 14:
                return "eHRPD";
            case 15:
                return "HSPA+";
            case 16:
                return "GSM";
            case 17:
                return "TD_SCDMA";
            case 18:
                return "IWLAN";
            case 19:
                return "LTE_CA";
            case 20:
                return "New Radio";
            default:
                return null;
        }
    }
}
