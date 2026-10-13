package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ArrayBuffer;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.CxxCallbackImpl;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.ViewProps;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NativeSampleTurboModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "SampleTurboModule";

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract ArrayBuffer createNativeBuffer(double d);

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableArray getArray(ReadableArray readableArray);

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract ArrayBuffer getArrayBuffer(ArrayBuffer arrayBuffer);

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean getBool(boolean z);

    @ReactMethod(isBlockingSynchronousMethod = true)
    public double getEnum(double d) {
        return 0.0d;
    }

    @ReactMethod
    public void getImageUrl(Promise promise) {
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract double getNumber(double d);

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableMap getObject(ReadableMap readableMap);

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getObjectAssert(ReadableMap readableMap) {
        return null;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getObjectThrows(ReadableMap readableMap) {
        return null;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract double getRootTag(double d);

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String getString(String str);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableMap getUnsafeObject(ReadableMap readableMap);

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableMap getValue(double d, String str, ReadableMap readableMap);

    @ReactMethod
    public abstract void getValueWithCallback(Callback callback);

    @ReactMethod
    public abstract void getValueWithPromise(boolean z, Promise promise);

    @ReactMethod
    public abstract void processAsyncBuffer(ArrayBuffer arrayBuffer, Promise promise);

    @ReactMethod
    public void promiseAssert(Promise promise) {
    }

    @ReactMethod
    public void promiseThrows(Promise promise) {
    }

    @ReactMethod
    public abstract void voidFunc();

    @ReactMethod
    public void voidFuncAssert() {
    }

    @ReactMethod
    public void voidFuncThrows() {
    }

    public NativeSampleTurboModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }

    protected final void emitOnPress() {
        CxxCallbackImpl cxxCallbackImpl = this.mEventEmitterCallback;
        if (cxxCallbackImpl != null) {
            cxxCallbackImpl.invoke("onPress");
        }
    }

    protected final void emitOnClick(String str) {
        CxxCallbackImpl cxxCallbackImpl = this.mEventEmitterCallback;
        if (cxxCallbackImpl != null) {
            cxxCallbackImpl.invoke(ViewProps.ON_CLICK, str);
        }
    }

    protected final void emitOnChange(ReadableMap readableMap) {
        CxxCallbackImpl cxxCallbackImpl = this.mEventEmitterCallback;
        if (cxxCallbackImpl != null) {
            cxxCallbackImpl.invoke("onChange", readableMap);
        }
    }

    protected final void emitOnSubmit(ReadableArray readableArray) {
        CxxCallbackImpl cxxCallbackImpl = this.mEventEmitterCallback;
        if (cxxCallbackImpl != null) {
            cxxCallbackImpl.invoke("onSubmit", readableArray);
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public final Map<String, Object> getConstants() {
        Map<String, Object> typedExportedConstants = getTypedExportedConstants();
        if (ReactBuildConfig.DEBUG || ReactBuildConfig.IS_INTERNAL_BUILD) {
            HashSet hashSet = new HashSet(Arrays.asList("const1", "const2", "const3"));
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
