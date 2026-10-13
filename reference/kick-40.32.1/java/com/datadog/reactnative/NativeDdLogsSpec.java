package com.datadog.reactnative;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NativeDdLogsSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "DdLogs";

    @ReactMethod
    public abstract void debug(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void debugWithError(String str, String str2, String str3, String str4, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void error(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void errorWithError(String str, String str2, String str3, String str4, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void info(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void infoWithError(String str, String str2, String str3, String str4, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void warn(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void warnWithError(String str, String str2, String str3, String str4, ReadableMap readableMap, Promise promise);

    public NativeDdLogsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "DdLogs";
    }
}
