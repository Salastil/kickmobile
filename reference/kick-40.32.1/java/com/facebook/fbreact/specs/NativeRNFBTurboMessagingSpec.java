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
public abstract class NativeRNFBTurboMessagingSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "NativeRNFBTurboMessaging";

    @ReactMethod
    public abstract void completeNotificationProcessing();

    @ReactMethod
    public abstract void deleteToken(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void getAPNSToken(Promise promise);

    @ReactMethod
    public abstract void getDidOpenSettingsForNotification(Promise promise);

    @ReactMethod
    public abstract void getInitialNotification(Promise promise);

    @ReactMethod
    public abstract void getIsHeadless(Promise promise);

    @ReactMethod
    public abstract void getToken(String str, String str2, Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod
    public abstract void hasPermission(Promise promise);

    @ReactMethod
    public abstract void isNotificationDelegationEnabled(Promise promise);

    @ReactMethod
    public abstract void registerForRemoteNotifications(Promise promise);

    @ReactMethod
    public abstract void requestPermission(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void sendMessage(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void setAPNSToken(String str, @Nullable String str2, Promise promise);

    @ReactMethod
    public abstract void setAutoInitEnabled(boolean z, Promise promise);

    @ReactMethod
    public abstract void setDeliveryMetricsExportToBigQuery(boolean z, Promise promise);

    @ReactMethod
    public abstract void setNotificationDelegationEnabled(boolean z, Promise promise);

    @ReactMethod
    public abstract void signalBackgroundMessageHandlerSet();

    @ReactMethod
    public abstract void subscribeToTopic(String str, Promise promise);

    @ReactMethod
    public abstract void unregisterForRemoteNotifications(Promise promise);

    @ReactMethod
    public abstract void unsubscribeFromTopic(String str, Promise promise);

    public NativeRNFBTurboMessagingSpec(ReactApplicationContext reactApplicationContext) {
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
            HashSet hashSet = new HashSet(Arrays.asList("isAutoInitEnabled", "isDeliveryMetricsExportToBigQueryEnabled"));
            HashSet hashSet2 = new HashSet(Arrays.asList("isNotificationDelegationEnabled", "isRegisteredForRemoteNotifications"));
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
