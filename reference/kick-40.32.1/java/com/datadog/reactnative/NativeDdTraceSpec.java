package com.datadog.reactnative;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NativeDdTraceSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "DdTrace";

    @ReactMethod
    public abstract void finishSpan(String str, ReadableMap readableMap, double d, Promise promise);

    @ReactMethod
    public abstract void startSpan(String str, ReadableMap readableMap, double d, Promise promise);

    public NativeDdTraceSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "DdTrace";
    }
}
