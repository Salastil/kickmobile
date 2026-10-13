package com.datadog.reactnative;

import android.app.Activity;
import android.os.Bundle;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdk.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0006\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J \u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J(\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0018\u0010+\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J(\u0010,\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0012\u00101\u001a\u00020\u000f2\b\u00102\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/datadog/reactnative/DdSdk;", "Lcom/datadog/reactnative/NativeDdSdkSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "datadogWrapper", "Lcom/datadog/reactnative/DatadogWrapper;", "ddTelemetry", "Lcom/datadog/reactnative/DdTelemetry;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/datadog/reactnative/DatadogWrapper;Lcom/datadog/reactnative/DdTelemetry;)V", "implementation", "Lcom/datadog/reactnative/DdSdkImplementation;", "getName", "", "initialize", "", "configuration", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "addAttribute", "key", "value", "removeAttribute", "addAttributes", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "removeAttributes", UserMetadata.KEYDATA_FILENAME, "Lcom/facebook/react/bridge/ReadableArray;", "setUserInfo", "user", "addUserExtraInfo", "extraInfo", "clearUserInfo", "setAccountInfo", "account", "addAccountExtraInfo", "clearAccountInfo", "setTrackingConsent", "trackingConsent", "sendTelemetryLog", "message", "config", "telemetryDebug", "telemetryError", "stack", "kind", "consumeWebviewEvent", "clearAllData", "addListener", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "removeListeners", "count", "", "registerLifecycleEvents", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdSdk extends NativeDdSdkSpec {
    private final DdSdkImplementation implementation;

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    public void addListener(String eventType) {
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    public void removeListeners(double count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DdSdk(ReactApplicationContext reactContext, DatadogWrapper datadogWrapper, DdTelemetry ddTelemetry) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(datadogWrapper, "datadogWrapper");
        Intrinsics.checkNotNullParameter(ddTelemetry, "ddTelemetry");
        this.implementation = new DdSdkImplementation(reactContext, datadogWrapper, ddTelemetry, null, null, 24, null);
        registerLifecycleEvents(reactContext);
    }

    public /* synthetic */ DdSdk(ReactApplicationContext reactApplicationContext, DatadogSDKWrapper datadogSDKWrapper, DdTelemetry ddTelemetry, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, (i & 2) != 0 ? new DatadogSDKWrapper() : datadogSDKWrapper, (i & 4) != 0 ? new DdTelemetry() : ddTelemetry);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "DdSdk";
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void initialize(ReadableMap configuration, Promise promise) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.initialize(configuration, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void addAttribute(String key, ReadableMap value, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.addAttribute(key, value, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void removeAttribute(String key, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.removeAttribute(key, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void addAttributes(ReadableMap attributes, Promise promise) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.addAttributes(attributes, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void removeAttributes(ReadableArray keys, Promise promise) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.removeAttributes(keys, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void setUserInfo(ReadableMap user, Promise promise) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.setUserInfo(user, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void addUserExtraInfo(ReadableMap extraInfo, Promise promise) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.addUserExtraInfo(extraInfo, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void clearUserInfo(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.clearUserInfo(promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void setAccountInfo(ReadableMap account, Promise promise) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.setAccountInfo(account, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void addAccountExtraInfo(ReadableMap extraInfo, Promise promise) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.addAccountExtraInfo(extraInfo, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void clearAccountInfo(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.clearAccountInfo(promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void setTrackingConsent(String trackingConsent, Promise promise) {
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.setTrackingConsent(trackingConsent, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void sendTelemetryLog(String message, ReadableMap attributes, ReadableMap config, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.sendTelemetryLog(message, attributes, config, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void telemetryDebug(String message, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.telemetryDebug(message, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void telemetryError(String message, String stack, String kind, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.telemetryError(message, stack, kind, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void consumeWebviewEvent(String message, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.consumeWebviewEvent(message, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void clearAllData(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.clearAllData(promise);
    }

    private final void registerLifecycleEvents(final ReactApplicationContext reactContext) {
        reactContext.addLifecycleEventListener(new LifecycleEventListener() { // from class: com.datadog.reactnative.DdSdk.registerLifecycleEvents.1
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostResume() {
                Activity currentActivity = reactContext.getCurrentActivity();
                if (currentActivity != null) {
                    Bundle extras = currentActivity.getIntent().getExtras();
                    DdSdkSynthetics.INSTANCE.setTestId(extras != null ? extras.getString(ActivityLifecycleTrackingStrategy.EXTRA_SYNTHETICS_TEST_ID) : null);
                    DdSdkSynthetics.INSTANCE.setResultId(extras != null ? extras.getString(ActivityLifecycleTrackingStrategy.EXTRA_SYNTHETICS_RESULT_ID) : null);
                }
                DdSdkSessionStartedListener.INSTANCE.getInstance().setReactContext(reactContext);
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostPause() {
                DdSdkSessionStartedListener.INSTANCE.invalidate();
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostDestroy() {
                DdSdkSessionStartedListener.INSTANCE.invalidate();
            }
        });
    }
}
