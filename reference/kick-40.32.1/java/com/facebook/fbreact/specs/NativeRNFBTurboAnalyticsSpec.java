package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes9.dex */
public abstract class NativeRNFBTurboAnalyticsSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "NativeRNFBTurboAnalytics";

    @ReactMethod
    public abstract void getAppInstanceId(Promise promise);

    @ReactMethod
    public abstract void getSessionId(Promise promise);

    @ReactMethod
    public abstract void initiateOnDeviceConversionMeasurementWithEmailAddress(String str, Promise promise);

    @ReactMethod
    public abstract void initiateOnDeviceConversionMeasurementWithHashedEmailAddress(String str, Promise promise);

    @ReactMethod
    public abstract void initiateOnDeviceConversionMeasurementWithHashedPhoneNumber(String str, Promise promise);

    @ReactMethod
    public abstract void initiateOnDeviceConversionMeasurementWithPhoneNumber(String str, Promise promise);

    @ReactMethod
    public abstract void logEvent(String str, @Nullable ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void logTransaction(String str, Promise promise);

    @ReactMethod
    public abstract void resetAnalyticsData(Promise promise);

    @ReactMethod
    public abstract void setAnalyticsCollectionEnabled(boolean z, Promise promise);

    @ReactMethod
    public abstract void setConsent(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void setDefaultEventParameters(@Nullable ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void setSessionTimeoutDuration(double d, Promise promise);

    @ReactMethod
    public abstract void setUserId(@Nullable String str, Promise promise);

    @ReactMethod
    public abstract void setUserProperties(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void setUserProperty(String str, @Nullable String str2, Promise promise);

    public NativeRNFBTurboAnalyticsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }
}
