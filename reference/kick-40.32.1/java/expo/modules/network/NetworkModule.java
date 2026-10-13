package expo.modules.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.trace.api.config.ProfilingConfig;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0015\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010#\u001a\u00020$H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006&"}, d2 = {"Lexpo/modules/network/NetworkModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "mainHandler", "Landroid/os/Handler;", "DELAY_MS", "", "isNetworkCallbackRegistered", "", "emitRunnable", "Ljava/lang/Runnable;", "networkCallback", "expo/modules/network/NetworkModule$networkCallback$1", "Lexpo/modules/network/NetworkModule$networkCallback$1;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "emitNetworkState", "", "asyncEmitNetworkState", "delay", "fetchNetworkState", "Landroid/os/Bundle;", "getConnectionType", "Lexpo/modules/network/NetworkModule$NetworkStateType;", "netCapabilities", "Landroid/net/NetworkCapabilities;", "getIpAddress", "", "NetworkStateType", "expo-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkModule extends Module {
    private boolean isNetworkCallbackRegistered;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final int DELAY_MS = 250;
    private final Runnable emitRunnable = new Runnable() { // from class: expo.modules.network.NetworkModule$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.emitNetworkState();
        }
    };
    private final NetworkModule$networkCallback$1 networkCallback = new NetworkModule$networkCallback$1(this);

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConnectivityManager getConnectivityManager() {
        Object systemService = getContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        NetworkModule networkModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (networkModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(networkModule);
            moduleDefinitionBuilder.Name("ExpoNetwork");
            moduleDefinitionBuilder.Events(NetworkModuleKt.NETWORK_STATE_EVENT_NAME);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.network.NetworkModule$definition$lambda$6$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    try {
                        this.this$0.getConnectivityManager().registerDefaultNetworkCallback(this.this$0.networkCallback);
                        this.this$0.isNetworkCallbackRegistered = true;
                    } catch (SecurityException e) {
                        Log.w(NetworkModuleKt.TAG, "expo-network cannot observe internet reachability: missing ACCESS_NETWORK_STATE permission", e);
                    } catch (RuntimeException e2) {
                        Log.e(NetworkModuleKt.TAG, "expo-network cannot observe internet reachability, too many callbacks registered!", e2);
                    }
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.network.NetworkModule$definition$lambda$6$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.mainHandler.removeCallbacks(this.this$0.emitRunnable);
                    if (this.this$0.isNetworkCallbackRegistered) {
                        try {
                            this.this$0.getConnectivityManager().unregisterNetworkCallback(this.this$0.networkCallback);
                        } catch (SecurityException e) {
                            Log.w(NetworkModuleKt.TAG, "expo-network could not unregister network callback: missing ACCESS_NETWORK_STATE permission", e);
                        } catch (Exception e2) {
                            Log.w(NetworkModuleKt.TAG, "expo-network could not unregister network callback during teardown", e2);
                        } finally {
                            this.this$0.isNetworkCallbackRegistered = false;
                        }
                    }
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getNetworkStateAsync", new UntypedAsyncFunctionComponent("getNetworkStateAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.network.NetworkModule$definition$lambda$6$$inlined$AsyncFunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return this.this$0.fetchNetworkState();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1<Object[], String> function1 = new Function1<Object[], String>() { // from class: expo.modules.network.NetworkModule$definition$lambda$6$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return this.this$0.getIpAddress();
                }
            };
            if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(String.class, String.class)) {
                                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("getIpAddressAsync", anyTypeArr, function1);
                            } else {
                                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("getIpAddressAsync", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("getIpAddressAsync", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("getIpAddressAsync", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("getIpAddressAsync", anyTypeArr, function1);
                }
            } else {
                untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("getIpAddressAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getIpAddressAsync", untypedAsyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[0];
            Function1<Object[], Boolean> function2 = new Function1<Object[], Boolean>() { // from class: expo.modules.network.NetworkModule$definition$lambda$6$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Settings.Global.getInt(this.this$0.getContext().getContentResolver(), "airplane_mode_on", 0) != 0);
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("isAirplaneModeEnabledAsync", anyTypeArr2, function2);
                            } else {
                                untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("isAirplaneModeEnabledAsync", anyTypeArr2, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("isAirplaneModeEnabledAsync", anyTypeArr2, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("isAirplaneModeEnabledAsync", anyTypeArr2, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("isAirplaneModeEnabledAsync", anyTypeArr2, function2);
                }
            } else {
                untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("isAirplaneModeEnabledAsync", anyTypeArr2, function2);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("isAirplaneModeEnabledAsync", untypedAsyncFunctionComponent2);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: compiled from: NetworkModule.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0014"}, d2 = {"Lexpo/modules/network/NetworkModule$NetworkStateType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "UNKNOWN", "CELLULAR", "WIFI", "BLUETOOTH", "ETHERNET", "WIMAX", "VPN", "OTHER", "isDefined", "", "()Z", "expo-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum NetworkStateType {
        NONE(ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT),
        UNKNOWN("UNKNOWN"),
        CELLULAR("CELLULAR"),
        WIFI("WIFI"),
        BLUETOOTH("BLUETOOTH"),
        ETHERNET("ETHERNET"),
        WIMAX("WIMAX"),
        VPN("VPN"),
        OTHER("OTHER");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String value;

        public static EnumEntries<NetworkStateType> getEntries() {
            return $ENTRIES;
        }

        NetworkStateType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        public final boolean isDefined() {
            return (Intrinsics.areEqual(this.value, ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT) || Intrinsics.areEqual(this.value, "UNKNOWN")) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitNetworkState() {
        try {
            sendEvent(NetworkModuleKt.NETWORK_STATE_EVENT_NAME, fetchNetworkState());
        } catch (SecurityException e) {
            Log.w(NetworkModuleKt.TAG, "expo-network could not read network state: missing ACCESS_NETWORK_STATE permission", e);
        } catch (Exception e2) {
            Log.w(NetworkModuleKt.TAG, "expo-network dropped a delayed network state update during teardown (the module or React context is no longer available)", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void asyncEmitNetworkState(int delay) {
        this.mainHandler.removeCallbacks(this.emitRunnable);
        this.mainHandler.postDelayed(this.emitRunnable, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle fetchNetworkState() {
        String value;
        Bundle bundle = new Bundle();
        try {
            Network activeNetwork = getConnectivityManager().getActiveNetwork();
            boolean zIsInternetReachable$default = NetworkUtilsKt.isInternetReachable$default(getConnectivityManager(), 0, 2, null);
            NetworkStateType connectionType = activeNetwork != null ? getConnectionType(getConnectivityManager().getNetworkCapabilities(activeNetwork)) : null;
            if (connectionType == null || (value = connectionType.getValue()) == null) {
                value = NetworkStateType.NONE.getValue();
            }
            bundle.putString("type", value);
            bundle.putBoolean("isInternetReachable", zIsInternetReachable$default);
            bundle.putBoolean("isConnected", connectionType != null && connectionType.isDefined());
            return bundle;
        } catch (Exception unused) {
            bundle.putString("type", NetworkStateType.UNKNOWN.getValue());
            bundle.putBoolean("isInternetReachable", false);
            bundle.putBoolean("isConnected", false);
            return bundle;
        }
    }

    private final NetworkStateType getConnectionType(NetworkCapabilities netCapabilities) {
        if (netCapabilities == null) {
            return NetworkStateType.UNKNOWN;
        }
        if (netCapabilities.hasTransport(0)) {
            return NetworkStateType.CELLULAR;
        }
        if (netCapabilities.hasTransport(1) || netCapabilities.hasTransport(5)) {
            return NetworkStateType.WIFI;
        }
        if (netCapabilities.hasTransport(2)) {
            return NetworkStateType.BLUETOOTH;
        }
        if (netCapabilities.hasTransport(3)) {
            return NetworkStateType.ETHERNET;
        }
        return netCapabilities.hasTransport(4) ? NetworkStateType.VPN : NetworkStateType.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getIpAddress() {
        LinkProperties linkProperties;
        Object next;
        String hostAddress;
        Network activeNetwork = getConnectivityManager().getActiveNetwork();
        if (activeNetwork == null || (linkProperties = getConnectivityManager().getLinkProperties(activeNetwork)) == null) {
            return "0.0.0.0";
        }
        List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
        Intrinsics.checkNotNullExpressionValue(linkAddresses, "getLinkAddresses(...)");
        List<LinkAddress> list = linkAddresses;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((LinkAddress) it.next()).getAddress());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof Inet4Address) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            Inet4Address inet4Address = (Inet4Address) obj2;
            if (!inet4Address.isLoopbackAddress() && !inet4Address.isMulticastAddress() && !inet4Address.isAnyLocalAddress()) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = arrayList3;
        Iterator it2 = arrayList4.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (((Inet4Address) next).isLinkLocalAddress());
        Inet4Address inet4Address2 = (Inet4Address) next;
        if (inet4Address2 == null) {
            inet4Address2 = (Inet4Address) CollectionsKt.firstOrNull((List) arrayList4);
        }
        return (inet4Address2 == null || (hostAddress = inet4Address2.getHostAddress()) == null) ? "0.0.0.0" : hostAddress;
    }
}
