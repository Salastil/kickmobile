package com.swmansion.worklets;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes8.dex */
public abstract class NativeWorkletsModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "WorkletsModule";

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean installTurboModule(boolean z);

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean prepareBundleMode();

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean start();

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean toggleSlowAnimationsOnUIRuntime();

    public NativeWorkletsModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "WorkletsModule";
    }
}
