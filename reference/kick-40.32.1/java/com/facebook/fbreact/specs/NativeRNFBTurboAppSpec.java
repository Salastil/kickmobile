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
public abstract class NativeRNFBTurboAppSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "NativeRNFBTurboApp";

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void deleteApp(String str, Promise promise);

    @ReactMethod
    public abstract void eventsAddListener(String str);

    @ReactMethod
    public abstract void eventsGetListeners(Promise promise);

    @ReactMethod
    public abstract void eventsNotifyReady(boolean z);

    @ReactMethod
    public abstract void eventsPing(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void eventsRemoveListener(String str, boolean z);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod
    public abstract void initializeApp(ReadableMap readableMap, ReadableMap readableMap2, Promise promise);

    @ReactMethod
    public abstract void jsonGetAll(Promise promise);

    @ReactMethod
    public abstract void metaGetAll(Promise promise);

    @ReactMethod
    public abstract void preferencesClearAll(Promise promise);

    @ReactMethod
    public abstract void preferencesGetAll(Promise promise);

    @ReactMethod
    public abstract void preferencesSetBool(String str, boolean z, Promise promise);

    @ReactMethod
    public abstract void preferencesSetString(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void removeListeners(double d);

    @ReactMethod
    public abstract void setAutomaticDataCollectionEnabled(String str, boolean z);

    @ReactMethod
    public abstract void setLogLevel(String str);

    public NativeRNFBTurboAppSpec(ReactApplicationContext reactApplicationContext) {
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
            HashSet hashSet = new HashSet(Arrays.asList("FIREBASE_RAW_JSON", "NATIVE_FIREBASE_APPS"));
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
