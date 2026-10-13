package org.linusu;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NativeRNGetRandomValuesSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNGetRandomValues";

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String getRandomBase64(double d);

    public NativeRNGetRandomValuesSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }
}
