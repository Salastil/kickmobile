package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes9.dex */
public abstract class NativeRNFBTurboCrashlyticsSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "NativeRNFBTurboCrashlytics";

    @ReactMethod
    public abstract void checkForUnsentReports(Promise promise);

    @ReactMethod
    public abstract void crash();

    @ReactMethod
    public abstract void crashWithStackPromise(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void deleteUnsentReports(Promise promise);

    @ReactMethod
    public abstract void didCrashOnPreviousExecution(Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod
    public abstract void log(String str);

    @ReactMethod
    public abstract void logPromise(String str, Promise promise);

    @ReactMethod
    public abstract void recordError(ReadableMap readableMap);

    @ReactMethod
    public abstract void recordErrorPromise(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void sendUnsentReports();

    @ReactMethod
    public abstract void setAttribute(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void setAttributes(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void setCrashlyticsCollectionEnabled(boolean z, Promise promise);

    @ReactMethod
    public abstract void setUserId(String str, Promise promise);

    public NativeRNFBTurboCrashlyticsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public final Map<String, Object> getConstants() {
        Map<String, Object> typedExportedConstants = getTypedExportedConstants();
        if (ReactBuildConfig.DEBUG || ReactBuildConfig.IS_INTERNAL_BUILD) {
            HashSet hashSet = new HashSet(Arrays.asList("isCrashlyticsCollectionEnabled", "isCrashlyticsJavascriptExceptionHandlerChainingEnabled", "isErrorGenerationOnJSCrashEnabled"));
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet(typedExportedConstants.keySet());
            hashSet3.removeAll(hashSet);
            hashSet3.removeAll(hashSet2);
            if (!hashSet3.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module Flow doesn't declare constants: %s", hashSet3));
            }
            hashSet.removeAll(typedExportedConstants.keySet());
            if (!hashSet.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module doesn't fill in constants: %s", hashSet));
            }
        }
        return typedExportedConstants;
    }
}
