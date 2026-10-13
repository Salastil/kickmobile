package com.reactnative.googlecast.api;

import android.os.Bundle;
import androidx.mediarouter.media.MediaRouter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastContext;
import com.reactnative.googlecast.types.RNGCDevice;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCDiscoveryManager extends ReactContextBaseJavaModule implements LifecycleEventListener {
    public static final String DEVICES_UPDATED = "GoogleCast:DevicesUpdated";

    @VisibleForTesting
    public static final String REACT_CLASS = "RNGCDiscoveryManager";
    private boolean mListenersAttached;
    private MediaRouter.Callback mediaRouterCallback;

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNGCDiscoveryManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mListenersAttached = false;
        this.mediaRouterCallback = new MediaRouter.Callback() { // from class: com.reactnative.googlecast.api.RNGCDiscoveryManager.1
            @Override // androidx.mediarouter.media.MediaRouter.Callback
            public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
                super.onRouteAdded(mediaRouter, routeInfo);
                RNGCDiscoveryManager rNGCDiscoveryManager = RNGCDiscoveryManager.this;
                rNGCDiscoveryManager.sendEvent(RNGCDiscoveryManager.DEVICES_UPDATED, rNGCDiscoveryManager.getDevices());
            }

            @Override // androidx.mediarouter.media.MediaRouter.Callback
            public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
                super.onRouteRemoved(mediaRouter, routeInfo);
                RNGCDiscoveryManager rNGCDiscoveryManager = RNGCDiscoveryManager.this;
                rNGCDiscoveryManager.sendEvent(RNGCDiscoveryManager.DEVICES_UPDATED, rNGCDiscoveryManager.getDevices());
            }

            @Override // androidx.mediarouter.media.MediaRouter.Callback
            public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
                super.onRouteChanged(mediaRouter, routeInfo);
                RNGCDiscoveryManager rNGCDiscoveryManager = RNGCDiscoveryManager.this;
                rNGCDiscoveryManager.sendEvent(RNGCDiscoveryManager.DEVICES_UPDATED, rNGCDiscoveryManager.getDevices());
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
        map.put("DEVICES_UPDATED", DEVICES_UPDATED);
        return map;
    }

    @ReactMethod
    public void getDevices(final Promise promise) {
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCDiscoveryManager.2
            @Override // java.lang.Runnable
            public void run() {
                promise.resolve(RNGCDiscoveryManager.this.getDevices());
            }
        });
    }

    @ReactMethod
    public void isPassiveScan(Promise promise) {
        promise.resolve(false);
    }

    @ReactMethod
    public void isRunning(Promise promise) {
        promise.resolve(true);
    }

    @ReactMethod
    public void setPassiveScan(boolean z, Promise promise) {
        promise.resolve(null);
    }

    @ReactMethod
    public void startDiscovery(Promise promise) {
        promise.resolve(null);
    }

    @ReactMethod
    public void stopDiscovery(Promise promise) {
        promise.resolve(null);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (this.mListenersAttached) {
            return;
        }
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCDiscoveryManager.3
            @Override // java.lang.Runnable
            public void run() {
                CastContext sharedInstance = RNGCCastContext.getSharedInstance(reactApplicationContext);
                if (sharedInstance == null) {
                    return;
                }
                MediaRouter.getInstance(reactApplicationContext).addCallback(sharedInstance.getMergedSelector(), RNGCDiscoveryManager.this.mediaRouterCallback);
            }
        });
        this.mListenersAttached = true;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCDiscoveryManager.4
            @Override // java.lang.Runnable
            public void run() {
                MediaRouter.getInstance(reactApplicationContext).removeCallback(RNGCDiscoveryManager.this.mediaRouterCallback);
            }
        });
        this.mListenersAttached = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WritableArray getDevices() {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (MediaRouter.RouteInfo routeInfo : MediaRouter.getInstance(getReactApplicationContext()).getRoutes()) {
            Bundle extras = routeInfo.getExtras();
            CastDevice fromBundle = CastDevice.getFromBundle(extras);
            if (fromBundle != null && extras != null && !routeInfo.isDefault() && !routeInfo.getDescription().equals("Google Cast Multizone Member") && routeInfo.getPlaybackType() == 1 && extras.getString("com.google.android.gms.cast.EXTRA_SESSION_ID") == null) {
                writableArrayCreateArray.pushMap(RNGCDevice.toJson(fromBundle));
            }
        }
        return writableArrayCreateArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(String str, Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
    }
}
