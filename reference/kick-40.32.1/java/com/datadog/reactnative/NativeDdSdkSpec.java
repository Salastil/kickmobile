package com.datadog.reactnative;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NativeDdSdkSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "DdSdk";

    @ReactMethod
    public abstract void addAccountExtraInfo(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void addAttribute(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void addAttributes(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void addUserExtraInfo(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void clearAccountInfo(Promise promise);

    @ReactMethod
    public abstract void clearAllData(Promise promise);

    @ReactMethod
    public abstract void clearUserInfo(Promise promise);

    @ReactMethod
    public abstract void consumeWebviewEvent(String str, Promise promise);

    @ReactMethod
    public abstract void initialize(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void removeAttribute(String str, Promise promise);

    @ReactMethod
    public abstract void removeAttributes(ReadableArray readableArray, Promise promise);

    @ReactMethod
    public abstract void removeListeners(double d);

    @ReactMethod
    public abstract void sendTelemetryLog(String str, ReadableMap readableMap, ReadableMap readableMap2, Promise promise);

    @ReactMethod
    public abstract void setAccountInfo(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void setTrackingConsent(String str, Promise promise);

    @ReactMethod
    public abstract void setUserInfo(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void telemetryDebug(String str, Promise promise);

    @ReactMethod
    public abstract void telemetryError(String str, String str2, String str3, Promise promise);

    public NativeDdSdkSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "DdSdk";
    }
}
