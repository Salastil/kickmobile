package com.datadog.reactnative;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NativeDdFlagsSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "DdFlags";

    @ReactMethod
    public abstract void enable(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void setEvaluationContext(String str, String str2, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void trackEvaluation(String str, String str2, ReadableMap readableMap, String str3, ReadableMap readableMap2, Promise promise);

    public NativeDdFlagsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "DdFlags";
    }
}
