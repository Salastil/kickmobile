package com.reactnative.googlecast.api;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import androidx.mediarouter.app.MediaRouteButton;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastStateListener;
import com.google.android.gms.cast.framework.IntroductoryOverlay;
import com.google.android.gms.common.GoogleApiAvailability;
import com.reactnative.googlecast.RNGCExpandedControllerActivity;
import com.reactnative.googlecast.components.RNGoogleCastButtonManager;
import com.reactnative.googlecast.types.RNGCCastState;
import com.reactnative.googlecast.types.RNGCPlayServicesState;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCCastContext extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static final String CAST_STATE_CHANGED = "GoogleCast:CastStateChanged";

    @VisibleForTesting
    public static final String REACT_CLASS = "RNGCCastContext";
    private CastStateListener castStateListener;
    private boolean mListenersAttached;

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNGCCastContext(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mListenersAttached = false;
        this.castStateListener = new CastStateListener() { // from class: com.reactnative.googlecast.api.RNGCCastContext.1
            @Override // com.google.android.gms.cast.framework.CastStateListener
            public void onCastStateChanged(int i) {
                RNGCCastContext.this.sendEvent(RNGCCastContext.CAST_STATE_CHANGED, RNGCCastState.toJson(i));
            }
        };
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("CAST_STATE_CHANGED", CAST_STATE_CHANGED);
        return map;
    }

    public static CastContext getSharedInstance(Context context) {
        try {
            if (isCastApiAvailable(context)) {
                return CastContext.getSharedInstance(context);
            }
        } catch (RuntimeException unused) {
        }
        return null;
    }

    public void sendEvent(String str, Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
    }

    @ReactMethod
    public void getCastState(final Promise promise) {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCCastContext.2
            @Override // java.lang.Runnable
            public void run() {
                CastContext sharedInstance = RNGCCastContext.getSharedInstance(reactApplicationContext);
                promise.resolve(sharedInstance == null ? null : RNGCCastState.toJson(sharedInstance.getCastState()));
            }
        });
    }

    @ReactMethod
    public void getPlayServicesState(final Promise promise) {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCCastContext.3
            @Override // java.lang.Runnable
            public void run() {
                promise.resolve(RNGCPlayServicesState.toJson(RNGCCastContext.getGooglePlayServicesState(reactApplicationContext)));
            }
        });
    }

    @ReactMethod
    public void showCastDialog(final Promise promise) {
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCCastContext.4
            @Override // java.lang.Runnable
            public void run() {
                MediaRouteButton current = RNGoogleCastButtonManager.getCurrent();
                if (current != null) {
                    current.performClick();
                    promise.resolve(true);
                } else {
                    promise.resolve(false);
                }
            }
        });
    }

    @ReactMethod
    public void showExpandedControls() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intent intent = new Intent(reactApplicationContext, (Class<?>) RNGCExpandedControllerActivity.class);
        intent.addFlags(268435456);
        reactApplicationContext.startActivity(intent);
    }

    @ReactMethod
    public void showIntroductoryOverlay(final ReadableMap readableMap, final Promise promise) {
        final MediaRouteButton current = RNGoogleCastButtonManager.getCurrent();
        if (current == null || current.getVisibility() != 0) {
            return;
        }
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCCastContext.5
            @Override // java.lang.Runnable
            public void run() {
                IntroductoryOverlay.Builder builder = new IntroductoryOverlay.Builder(RNGCCastContext.this.getCurrentActivity(), current);
                if (readableMap.getBoolean("once")) {
                    builder.setSingleTime();
                }
                builder.setOnOverlayDismissedListener(new IntroductoryOverlay.OnOverlayDismissedListener() { // from class: com.reactnative.googlecast.api.RNGCCastContext.5.1
                    @Override // com.google.android.gms.cast.framework.IntroductoryOverlay.OnOverlayDismissedListener
                    public void onOverlayDismissed() {
                        promise.resolve(true);
                    }
                });
                builder.build().show();
            }
        });
    }

    @ReactMethod
    public void showPlayServicesErrorDialog(final String str, final Promise promise) {
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCCastContext.6
            @Override // java.lang.Runnable
            public void run() {
                promise.resolve(Boolean.valueOf(GoogleApiAvailability.getInstance().showErrorDialogFragment(RNGCCastContext.this.getCurrentActivity(), RNGCPlayServicesState.fromJson(str), 0)));
            }
        });
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (this.mListenersAttached) {
            return;
        }
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCCastContext.7
            @Override // java.lang.Runnable
            public void run() {
                CastContext sharedInstance = RNGCCastContext.getSharedInstance(reactApplicationContext);
                if (sharedInstance != null) {
                    sharedInstance.addCastStateListener(RNGCCastContext.this.castStateListener);
                }
            }
        });
        this.mListenersAttached = true;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCCastContext.8
            @Override // java.lang.Runnable
            public void run() {
                CastContext sharedInstance = RNGCCastContext.getSharedInstance(reactApplicationContext);
                if (sharedInstance != null) {
                    sharedInstance.removeCastStateListener(RNGCCastContext.this.castStateListener);
                }
            }
        });
        this.mListenersAttached = false;
    }

    private static boolean isCastApiAvailable(Context context) {
        return !isTv(context) && isGooglePlayServiceAvailable(context);
    }

    private static boolean isTv(Context context) {
        return ((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4;
    }

    private static boolean isGooglePlayServiceAvailable(Context context) {
        return getGooglePlayServicesState(context) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getGooglePlayServicesState(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
    }
}
