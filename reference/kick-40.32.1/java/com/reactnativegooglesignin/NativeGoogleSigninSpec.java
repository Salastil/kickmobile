package com.reactnativegooglesignin;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes8.dex */
public abstract class NativeGoogleSigninSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNGoogleSignin";

    @ReactMethod
    public abstract void addScopes(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void clearCachedAccessToken(String str, Promise promise);

    @ReactMethod
    public abstract void configure(ReadableMap readableMap, Promise promise);

    @ReactMethod(isBlockingSynchronousMethod = true)
    @Nullable
    public abstract WritableMap getCurrentUser();

    @ReactMethod
    public abstract void getTokens(Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean hasPreviousSignIn();

    @ReactMethod
    public abstract void playServicesAvailable(boolean z, Promise promise);

    @ReactMethod
    public abstract void revokeAccess(Promise promise);

    @ReactMethod
    public abstract void signIn(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void signInSilently(Promise promise);

    @ReactMethod
    public abstract void signOut(Promise promise);

    public NativeGoogleSigninSpec(ReactApplicationContext reactApplicationContext) {
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
            HashSet hashSet = new HashSet(Arrays.asList("BUTTON_SIZE_ICON", "BUTTON_SIZE_STANDARD", "BUTTON_SIZE_WIDE", "IN_PROGRESS", "NO_SAVED_CREDENTIAL_FOUND", "ONE_TAP_START_FAILED", RNGoogleSigninModule.PLAY_SERVICES_NOT_AVAILABLE, "SCOPES_ALREADY_GRANTED", "SIGN_IN_CANCELLED", "SIGN_IN_REQUIRED"));
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
