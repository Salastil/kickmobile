package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes9.dex */
public abstract class NativeRNFBTurboUtilsSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "NativeRNFBTurboUtils";

    @ReactMethod
    public abstract void androidGetPlayServicesStatus(Promise promise);

    @ReactMethod
    public abstract void androidMakePlayServicesAvailable(Promise promise);

    @ReactMethod
    public abstract void androidPromptForPlayServices(Promise promise);

    @ReactMethod
    public abstract void androidResolutionForPlayServices(Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    public NativeRNFBTurboUtilsSpec(ReactApplicationContext reactApplicationContext) {
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
            HashSet hashSet = new HashSet(Arrays.asList("CACHES_DIRECTORY", "DOCUMENT_DIRECTORY", "LIBRARY_DIRECTORY", "MAIN_BUNDLE", "MOVIES_DIRECTORY", "PICTURES_DIRECTORY", "TEMP_DIRECTORY", "isRunningInTestLab"));
            HashSet hashSet2 = new HashSet(Arrays.asList("EXTERNAL_DIRECTORY", "EXTERNAL_STORAGE_DIRECTORY", "FILE_TYPE_DIRECTORY", "FILE_TYPE_REGULAR", "appVersion"));
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
