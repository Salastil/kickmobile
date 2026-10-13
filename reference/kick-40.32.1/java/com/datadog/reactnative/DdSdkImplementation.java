package com.datadog.reactnative;

import android.app.Activity;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.Log;
import android.view.Display;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.RumPerformanceMetric;
import com.datadog.android.rum._RumInternalProxy;
import com.datadog.android.rum.configuration.VitalsUpdateFrequency;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DdSdkImplementation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 S2\u00020\u0001:\u0001SB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010/\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 J\u0016\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0016\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u00104\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 J\u0016\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 J&\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020#2\u0006\u0010'\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010:\u001a\u00020\u001c2\u0006\u00108\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 J&\u0010;\u001a\u00020\u001c2\u0006\u00108\u001a\u00020#2\u0006\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010>\u001a\u00020\u001c2\u0006\u00108\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010?\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 J\u0017\u0010@\u001a\u00020A2\b\u00106\u001a\u0004\u0018\u00010#H\u0000¢\u0006\u0002\bBJ\b\u0010C\u001a\u00020\u001cH\u0002J\u0012\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010#H\u0002J\u0012\u0010G\u001a\u0004\u0018\u00010\u00172\u0006\u0010H\u001a\u00020IH\u0002J\u001e\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c\u0018\u00010K2\u0006\u0010H\u001a\u00020IH\u0002J3\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u000f2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010QJ\u0012\u0010R\u001a\u00020\u00192\b\u0010N\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006T"}, d2 = {"Lcom/datadog/reactnative/DdSdkImplementation;", "", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "datadog", "Lcom/datadog/reactnative/DatadogWrapper;", "ddTelemetry", "Lcom/datadog/reactnative/DdTelemetry;", "uiThreadExecutor", "Lcom/datadog/reactnative/UiThreadExecutor;", "jsThreadExecutor", "Lcom/datadog/reactnative/JsThreadExecutor;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/datadog/reactnative/DatadogWrapper;Lcom/datadog/reactnative/DdTelemetry;Lcom/datadog/reactnative/UiThreadExecutor;Lcom/datadog/reactnative/JsThreadExecutor;)V", "appContext", "Landroid/content/Context;", "getAppContext$datadog_mobile_react_native_release", "()Landroid/content/Context;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$datadog_mobile_react_native_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "frameRateProvider", "Lcom/datadog/reactnative/FrameRateProvider;", "maxDisplayRefreshRate", "", "Ljava/lang/Double;", "initialize", "", "configuration", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "addAttribute", "key", "", "value", "removeAttribute", "addAttributes", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "removeAttributes", UserMetadata.KEYDATA_FILENAME, "Lcom/facebook/react/bridge/ReadableArray;", "setUserInfo", "userInfo", "addUserExtraInfo", "userExtraInfo", "clearUserInfo", "setAccountInfo", "accountInfo", "addAccountExtraInfo", "accountExtraInfo", "clearAccountInfo", "setTrackingConsent", "trackingConsent", "sendTelemetryLog", "message", "config", "telemetryDebug", "telemetryError", "stack", "kind", "consumeWebviewEvent", "clearAllData", "buildTrackingConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "buildTrackingConsent$datadog_mobile_react_native_release", "configureSynthetics", "buildVitalUpdateFrequency", "Lcom/datadog/android/rum/configuration/VitalsUpdateFrequency;", "vitalsUpdateFrequency", "createFrameRateProvider", "ddSdkConfiguration", "Lcom/datadog/reactnative/DdSdkConfiguration;", "buildFrameTimeCallback", "Lkotlin/Function1;", "normalizeFrameTime", "frameTimeSeconds", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "fpsBudget", "deviceDisplayFps", "(DLandroid/content/Context;Ljava/lang/Double;Ljava/lang/Double;)D", "getMaxDisplayRefreshRate", "Companion", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdSdkImplementation {
    public static final String DD_DROP_ACTION = "_dd.action.drop_action";
    public static final String DD_DROP_RESOURCE = "_dd.resource.drop_resource";
    public static final String DD_NEEDS_CLEAR_TEXT_HTTP = "_dd.needsClearTextHttp";
    public static final String DD_VERSION = "_dd.version";
    public static final String DD_VERSION_SUFFIX = "_dd.version_suffix";
    public static final String DEFAULT_APP_VERSION = "?";
    public static final double DEFAULT_REFRESH_HZ = 60.0d;
    public static final String MONITOR_JS_ERROR_MESSAGE = "Error monitoring JS refresh rate";
    public static final String NAME = "DdSdk";
    public static final String PACKAGE_INFO_NOT_FOUND_ERROR_MESSAGE = "Error getting package info";
    private final Context appContext;
    private final DatadogWrapper datadog;
    private final DdTelemetry ddTelemetry;
    private FrameRateProvider frameRateProvider;
    private final AtomicBoolean initialized;
    private final JsThreadExecutor jsThreadExecutor;
    private volatile Double maxDisplayRefreshRate;
    private final ReactApplicationContext reactContext;
    private final UiThreadExecutor uiThreadExecutor;

    public DdSdkImplementation(ReactApplicationContext reactContext, DatadogWrapper datadog, DdTelemetry ddTelemetry, UiThreadExecutor uiThreadExecutor, JsThreadExecutor jsThreadExecutor) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(datadog, "datadog");
        Intrinsics.checkNotNullParameter(ddTelemetry, "ddTelemetry");
        Intrinsics.checkNotNullParameter(uiThreadExecutor, "uiThreadExecutor");
        Intrinsics.checkNotNullParameter(jsThreadExecutor, "jsThreadExecutor");
        this.reactContext = reactContext;
        this.datadog = datadog;
        this.ddTelemetry = ddTelemetry;
        this.uiThreadExecutor = uiThreadExecutor;
        this.jsThreadExecutor = jsThreadExecutor;
        Context applicationContext = reactContext.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.appContext = applicationContext;
        this.initialized = new AtomicBoolean(false);
    }

    public /* synthetic */ DdSdkImplementation(ReactApplicationContext reactApplicationContext, DatadogSDKWrapper datadogSDKWrapper, DdTelemetry ddTelemetry, ReactUiThreadExecutor reactUiThreadExecutor, ReactJsThreadExecutor reactJsThreadExecutor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, (i & 2) != 0 ? new DatadogSDKWrapper() : datadogSDKWrapper, (i & 4) != 0 ? new DdTelemetry() : ddTelemetry, (i & 8) != 0 ? new ReactUiThreadExecutor() : reactUiThreadExecutor, (i & 16) != 0 ? new ReactJsThreadExecutor(reactApplicationContext) : reactJsThreadExecutor);
    }

    /* JADX INFO: renamed from: getAppContext$datadog_mobile_react_native_release, reason: from getter */
    public final Context getAppContext() {
        return this.appContext;
    }

    /* JADX INFO: renamed from: getInitialized$datadog_mobile_react_native_release, reason: from getter */
    public final AtomicBoolean getInitialized() {
        return this.initialized;
    }

    public final void initialize(ReadableMap configuration, Promise promise) {
        _RumInternalProxy _ruminternalproxy_getInternal;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(promise, "promise");
        DdSdkConfiguration ddSdkConfigurationAsDdSdkConfiguration = DdSdkConfigurationExtKt.asDdSdkConfiguration(configuration);
        DdSdkSessionStartedListener.INSTANCE.getInstance().setReactContext(this.reactContext);
        DdSdkNativeInitialization.initialize$datadog_mobile_react_native_release$default(new DdSdkNativeInitialization(this.appContext, this.datadog, this.ddTelemetry, null, 8, null), ddSdkConfigurationAsDdSdkConfiguration, false, 2, null);
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (ddSdkConfigurationAsDdSdkConfiguration.getRumConfiguration() != null && currentActivity != null && (_ruminternalproxy_getInternal = this.datadog.getRumMonitor()._getInternal()) != null) {
            _ruminternalproxy_getInternal.enableJankStatsTracking(currentActivity);
        }
        this.frameRateProvider = createFrameRateProvider(ddSdkConfigurationAsDdSdkConfiguration);
        this.reactContext.addLifecycleEventListener(new LifecycleEventListener() { // from class: com.datadog.reactnative.DdSdkImplementation.initialize.1
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostResume() {
                FrameRateProvider frameRateProvider = DdSdkImplementation.this.frameRateProvider;
                if (frameRateProvider != null) {
                    frameRateProvider.start();
                }
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostPause() {
                FrameRateProvider frameRateProvider = DdSdkImplementation.this.frameRateProvider;
                if (frameRateProvider != null) {
                    frameRateProvider.stop();
                }
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostDestroy() {
                FrameRateProvider frameRateProvider = DdSdkImplementation.this.frameRateProvider;
                if (frameRateProvider != null) {
                    frameRateProvider.stop();
                }
            }
        });
        configureSynthetics();
        this.initialized.set(true);
        promise.resolve(null);
    }

    public final void addAttribute(String key, ReadableMap value, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Object obj = DdSdkBridgeExtKt.toMap(value).get("value");
        this.datadog.addRumGlobalAttribute(key, obj);
        GlobalState.addAttribute(key, obj);
        promise.resolve(null);
    }

    public final void removeAttribute(String key, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.removeRumGlobalAttribute(key);
        GlobalState.removeAttribute(key);
        promise.resolve(null);
    }

    public final void addAttributes(ReadableMap attributes, Promise promise) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.addRumGlobalAttributes(attributes.toHashMap());
        for (Map.Entry<String, Object> entry : attributes.toHashMap().entrySet()) {
            GlobalState.addAttribute(entry.getKey(), entry.getValue());
        }
        promise.resolve(null);
    }

    public final void removeAttributes(ReadableArray keys, Promise promise) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ArrayList arrayList = new ArrayList();
        int size = keys.size();
        for (int i = 0; i < size; i++) {
            String string = keys.getString(i);
            if (string != null && !StringsKt.isBlank(string)) {
                arrayList.add(string);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        this.datadog.removeRumGlobalAttributes(strArr);
        for (String str : strArr) {
            GlobalState.removeAttribute(str);
        }
        promise.resolve(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setUserInfo(ReadableMap userInfo, Promise promise) {
        LinkedHashMap linkedHashMapEmptyMap;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map mutableMap = MapsKt.toMutableMap(userInfo.toHashMap());
        Object obj = mutableMap.get("id");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = mutableMap.get("name");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = mutableMap.get("email");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = mutableMap.get("extraInfo");
        Map map = obj4 instanceof Map ? (Map) obj4 : null;
        if (map == null) {
            linkedHashMapEmptyMap = MapsKt.emptyMap();
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getKey() instanceof String) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                Object key = entry2.getKey();
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap3.put((String) key, entry2.getValue());
            }
            linkedHashMapEmptyMap = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap3.size()));
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                linkedHashMapEmptyMap.put(entry3.getKey(), entry3.getValue());
            }
        }
        if (str != null) {
            this.datadog.setUserInfo(str, str2, str3, linkedHashMapEmptyMap);
        }
        promise.resolve(null);
    }

    public final void addUserExtraInfo(ReadableMap userExtraInfo, Promise promise) {
        Intrinsics.checkNotNullParameter(userExtraInfo, "userExtraInfo");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.addUserExtraInfo(MapsKt.toMutableMap(userExtraInfo.toHashMap()));
        promise.resolve(null);
    }

    public final void clearUserInfo(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.clearUserInfo();
        promise.resolve(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAccountInfo(ReadableMap accountInfo, Promise promise) {
        LinkedHashMap linkedHashMapEmptyMap;
        Intrinsics.checkNotNullParameter(accountInfo, "accountInfo");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map mutableMap = MapsKt.toMutableMap(accountInfo.toHashMap());
        Object obj = mutableMap.get("id");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = mutableMap.get("name");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = mutableMap.get("extraInfo");
        Map map = obj3 instanceof Map ? (Map) obj3 : null;
        if (map == null) {
            linkedHashMapEmptyMap = MapsKt.emptyMap();
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getKey() instanceof String) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                Object key = entry2.getKey();
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap3.put((String) key, entry2.getValue());
            }
            linkedHashMapEmptyMap = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap3.size()));
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                linkedHashMapEmptyMap.put(entry3.getKey(), entry3.getValue());
            }
        }
        if (str != null) {
            this.datadog.setAccountInfo(str, str2, linkedHashMapEmptyMap);
        }
        promise.resolve(null);
    }

    public final void addAccountExtraInfo(ReadableMap accountExtraInfo, Promise promise) {
        Intrinsics.checkNotNullParameter(accountExtraInfo, "accountExtraInfo");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.addAccountExtraInfo(MapsKt.toMutableMap(accountExtraInfo.toHashMap()));
        promise.resolve(null);
    }

    public final void clearAccountInfo(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.clearAccountInfo();
        promise.resolve(null);
    }

    public final void setTrackingConsent(String trackingConsent, Promise promise) {
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.setTrackingConsent(buildTrackingConsent$datadog_mobile_react_native_release(trackingConsent));
        promise.resolve(null);
    }

    public final void sendTelemetryLog(String message, ReadableMap attributes, ReadableMap config, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.ddTelemetry.sendTelemetryLog(message, attributes, config);
        promise.resolve(null);
    }

    public final void telemetryDebug(String message, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.ddTelemetry.telemetryDebug(message);
        promise.resolve(null);
    }

    public final void telemetryError(String message, String stack, String kind, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.ddTelemetry.telemetryError(message, stack, kind);
        promise.resolve(null);
    }

    public final void consumeWebviewEvent(String message, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.consumeWebviewEvent(message);
        promise.resolve(null);
    }

    public final void clearAllData(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.clearAllData();
        promise.resolve(null);
    }

    public final TrackingConsent buildTrackingConsent$datadog_mobile_react_native_release(String trackingConsent) {
        String lowerCase;
        if (trackingConsent != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            lowerCase = trackingConsent.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1302084273) {
                if (iHashCode != -682587753) {
                    if (iHashCode == 280295099 && lowerCase.equals(PermissionsResponse.GRANTED_KEY)) {
                        return TrackingConsent.GRANTED;
                    }
                } else if (lowerCase.equals("pending")) {
                    return TrackingConsent.PENDING;
                }
            } else if (lowerCase.equals("not_granted")) {
                return TrackingConsent.NOT_GRANTED;
            }
        }
        Log.w(DdSdk.class.getCanonicalName(), "Unknown consent given: " + trackingConsent + ", using " + TrackingConsent.PENDING + " as default");
        return TrackingConsent.PENDING;
    }

    private final void configureSynthetics() {
        String resultId;
        _RumInternalProxy _ruminternalproxy_getInternal;
        String testId = DdSdkSynthetics.INSTANCE.getTestId();
        if (testId == null || StringsKt.isBlank(testId) || (resultId = DdSdkSynthetics.INSTANCE.getResultId()) == null || StringsKt.isBlank(resultId) || (_ruminternalproxy_getInternal = this.datadog.getRumMonitor()._getInternal()) == null) {
            return;
        }
        _ruminternalproxy_getInternal.setSyntheticsAttribute(DdSdkSynthetics.INSTANCE.getTestId(), DdSdkSynthetics.INSTANCE.getResultId());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final VitalsUpdateFrequency buildVitalUpdateFrequency(String vitalsUpdateFrequency) {
        String lowerCase;
        if (vitalsUpdateFrequency != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            lowerCase = vitalsUpdateFrequency.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            switch (lowerCase.hashCode()) {
                case -1526279474:
                    if (lowerCase.equals("frequent")) {
                        return VitalsUpdateFrequency.FREQUENT;
                    }
                    break;
                case -631448035:
                    if (lowerCase.equals("average")) {
                        return VitalsUpdateFrequency.AVERAGE;
                    }
                    break;
                case 3493026:
                    if (lowerCase.equals("rare")) {
                        return VitalsUpdateFrequency.RARE;
                    }
                    break;
                case 104712844:
                    if (lowerCase.equals("never")) {
                        return VitalsUpdateFrequency.NEVER;
                    }
                    break;
            }
        }
        return VitalsUpdateFrequency.AVERAGE;
    }

    private final FrameRateProvider createFrameRateProvider(DdSdkConfiguration ddSdkConfiguration) {
        Function1<Double, Unit> function1BuildFrameTimeCallback = buildFrameTimeCallback(ddSdkConfiguration);
        if (function1BuildFrameTimeCallback == null) {
            return null;
        }
        FrameRateProvider frameRateProvider = new FrameRateProvider(function1BuildFrameTimeCallback, this.jsThreadExecutor);
        frameRateProvider.start();
        return frameRateProvider;
    }

    private final Function1<Double, Unit> buildFrameTimeCallback(final DdSdkConfiguration ddSdkConfiguration) {
        final boolean z = (ddSdkConfiguration.getRumConfiguration() == null || buildVitalUpdateFrequency(ddSdkConfiguration.getRumConfiguration().getVitalsUpdateFrequency()) == VitalsUpdateFrequency.NEVER) ? false : true;
        final boolean z2 = (ddSdkConfiguration.getRumConfiguration() == null || Intrinsics.areEqual(ddSdkConfiguration.getRumConfiguration().getLongTaskThresholdMs(), 0.0d)) ? false : true;
        if (z2 || z) {
            return new Function1() { // from class: com.datadog.reactnative.DdSdkImplementation$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DdSdkImplementation.buildFrameTimeCallback$lambda$0(z, this, z2, ddSdkConfiguration, ((Double) obj).doubleValue());
                }
            };
        }
        return null;
    }

    static final Unit buildFrameTimeCallback$lambda$0(boolean z, DdSdkImplementation ddSdkImplementation, boolean z2, DdSdkConfiguration ddSdkConfiguration, double d) {
        DdSdkImplementation ddSdkImplementation2;
        double d2;
        _RumInternalProxy _ruminternalproxy_getInternal;
        Double longTaskThresholdMs;
        if (!z || d <= 0.0d) {
            ddSdkImplementation2 = ddSdkImplementation;
            d2 = d;
        } else {
            ddSdkImplementation2 = ddSdkImplementation;
            d2 = d;
            double dNormalizeFrameTime$default = normalizeFrameTime$default(ddSdkImplementation2, d2, ddSdkImplementation.appContext, null, null, 12, null);
            _RumInternalProxy _ruminternalproxy_getInternal2 = ddSdkImplementation2.datadog.getRumMonitor()._getInternal();
            if (_ruminternalproxy_getInternal2 != null) {
                _ruminternalproxy_getInternal2.updatePerformanceMetric(RumPerformanceMetric.JS_FRAME_TIME, dNormalizeFrameTime$default);
            }
        }
        if (z2) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            RumConfiguration rumConfiguration = ddSdkConfiguration.getRumConfiguration();
            if (d2 > timeUnit.toNanos((rumConfiguration == null || (longTaskThresholdMs = rumConfiguration.getLongTaskThresholdMs()) == null) ? 0L : (long) longTaskThresholdMs.doubleValue()) && (_ruminternalproxy_getInternal = ddSdkImplementation2.datadog.getRumMonitor()._getInternal()) != null) {
                _ruminternalproxy_getInternal.addLongTask((long) d2, "javascript");
            }
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ double normalizeFrameTime$default(DdSdkImplementation ddSdkImplementation, double d, Context context, Double d2, Double d3, int i, Object obj) {
        if ((i & 4) != 0) {
            d2 = null;
        }
        if ((i & 8) != 0) {
            d3 = null;
        }
        return ddSdkImplementation.normalizeFrameTime(d, context, d2, d3);
    }

    public final double normalizeFrameTime(double frameTimeSeconds, Context context, Double fpsBudget, Double deviceDisplayFps) {
        Intrinsics.checkNotNullParameter(context, "context");
        double d = frameTimeSeconds * 1000.0d;
        double dDoubleValue = fpsBudget != null ? fpsBudget.doubleValue() : 60.0d;
        double dDoubleValue2 = deviceDisplayFps != null ? deviceDisplayFps.doubleValue() : getMaxDisplayRefreshRate(context);
        double d2 = 1000.0d / dDoubleValue2;
        double d3 = 1000.0d / dDoubleValue;
        List listListOf = CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(dDoubleValue2), Double.valueOf(d), Double.valueOf(dDoubleValue), Double.valueOf(d3), Double.valueOf(d2)});
        if (!(listListOf instanceof Collection) || !listListOf.isEmpty()) {
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                double dDoubleValue3 = ((Number) it.next()).doubleValue();
                if (Math.abs(dDoubleValue3) > Double.MAX_VALUE || dDoubleValue3 <= 0.0d) {
                    return 0.016666666666666666d;
                }
            }
        }
        return Math.max(d / (d2 / d3), d2) / 1000.0d;
    }

    private final double getMaxDisplayRefreshRate(Context context) {
        Display display;
        Double d = this.maxDisplayRefreshRate;
        if (d != null) {
            return d.doubleValue();
        }
        Double dValueOf = null;
        Object systemService = context != null ? context.getSystemService("display") : null;
        DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
        if (displayManager == null || (display = displayManager.getDisplay(0)) == null) {
            return 60.0d;
        }
        Display.Mode[] supportedModes = display.getSupportedModes();
        Intrinsics.checkNotNullExpressionValue(supportedModes, "getSupportedModes(...)");
        Display.Mode[] modeArr = supportedModes;
        if (modeArr.length != 0) {
            double refreshRate = modeArr[0].getRefreshRate();
            int lastIndex = ArraysKt.getLastIndex(modeArr);
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    refreshRate = Math.max(refreshRate, modeArr[i].getRefreshRate());
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            dValueOf = Double.valueOf(refreshRate);
        }
        double dDoubleValue = dValueOf != null ? dValueOf.doubleValue() : 60.0d;
        this.maxDisplayRefreshRate = Double.valueOf(dDoubleValue);
        return dDoubleValue;
    }
}
