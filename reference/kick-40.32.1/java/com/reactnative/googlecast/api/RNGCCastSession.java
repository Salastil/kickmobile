package com.reactnative.googlecast.api;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.common.api.PendingResult;
import com.reactnative.googlecast.types.RNGCActiveInputState;
import com.reactnative.googlecast.types.RNGCApplicationMetadata;
import com.reactnative.googlecast.types.RNGCDevice;
import com.reactnative.googlecast.types.RNGCStandbyState;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCCastSession extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static final String ACTIVE_INPUT_STATE_CHANGED = "GoogleCast:ActiveInputStateChanged";
    private static final String CHANNEL_MESSAGE_RECEIVED = "GoogleCast:ChannelMessageReceived";
    private static final String CHANNEL_UPDATED = "GoogleCast:ChannelUpdated";

    @VisibleForTesting
    public static final String REACT_CLASS = "RNGCCastSession";
    private static final String STANDBY_STATE_CHANGED = "GoogleCast:StandbyStateChanged";
    private Cast.Listener castListener;
    private CastSession castSession;
    private boolean mListenersAttached;
    private Cast.MessageReceivedCallback messageCallback;
    private SessionManagerListener sessionListener;
    private With<CastSession> with;

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNGCCastSession(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mListenersAttached = false;
        this.with = new With<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.13
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.reactnative.googlecast.api.With
            public CastSession getX() {
                return RNGCCastSession.this.castSession;
            }

            @Override // com.reactnative.googlecast.api.With
            protected ReactContext getReactApplicationContext() {
                return RNGCCastSession.this.getReactApplicationContext();
            }
        };
        this.castListener = new Cast.Listener() { // from class: com.reactnative.googlecast.api.RNGCCastSession.14
            @Override // com.google.android.gms.cast.Cast.Listener
            public void onActiveInputStateChanged(int i) {
                RNGCCastSession.this.sendEvent(RNGCCastSession.ACTIVE_INPUT_STATE_CHANGED, RNGCActiveInputState.toJson(i));
            }

            @Override // com.google.android.gms.cast.Cast.Listener
            public void onStandbyStateChanged(int i) {
                RNGCCastSession.this.sendEvent(RNGCCastSession.STANDBY_STATE_CHANGED, RNGCStandbyState.toJson(i));
            }
        };
        this.messageCallback = new Cast.MessageReceivedCallback() { // from class: com.reactnative.googlecast.api.RNGCCastSession.15
            @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
            public void onMessageReceived(CastDevice castDevice, String str, String str2) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("namespace", str);
                writableMapCreateMap.putString("message", str2);
                RNGCCastSession.this.sendEvent(RNGCCastSession.CHANNEL_MESSAGE_RECEIVED, writableMapCreateMap);
            }
        };
        this.sessionListener = new CastSessionManagerListener() { // from class: com.reactnative.googlecast.api.RNGCCastSession.16
            @Override // com.reactnative.googlecast.api.CastSessionManagerListener, com.google.android.gms.cast.framework.SessionManagerListener
            public void onSessionEnding(CastSession castSession) {
                castSession.removeCastListener(RNGCCastSession.this.castListener);
                RNGCCastSession.this.castSession = null;
            }

            @Override // com.reactnative.googlecast.api.CastSessionManagerListener, com.google.android.gms.cast.framework.SessionManagerListener
            public void onSessionResumed(CastSession castSession, boolean z) {
                castSession.addCastListener(RNGCCastSession.this.castListener);
                RNGCCastSession.this.castSession = castSession;
            }

            @Override // com.reactnative.googlecast.api.CastSessionManagerListener, com.google.android.gms.cast.framework.SessionManagerListener
            public void onSessionStarted(CastSession castSession, String str) {
                castSession.addCastListener(RNGCCastSession.this.castListener);
                RNGCCastSession.this.castSession = castSession;
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
        map.put("ACTIVE_INPUT_STATE_CHANGED", ACTIVE_INPUT_STATE_CHANGED);
        map.put("CHANNEL_MESSAGE_RECEIVED", CHANNEL_MESSAGE_RECEIVED);
        map.put("CHANNEL_UPDATED", CHANNEL_UPDATED);
        map.put("STANDBY_STATE_CHANGED", STANDBY_STATE_CHANGED);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(String str, Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
    }

    @ReactMethod
    public void getActiveInputState(final Promise promise) {
        this.with.withX(new With.WithX<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.1
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(CastSession castSession) {
                promise.resolve(RNGCActiveInputState.toJson(castSession.getActiveInputState()));
            }
        }, promise);
    }

    @ReactMethod
    public void getApplicationMetadata(final Promise promise) {
        this.with.withX(new With.WithX<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.2
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(CastSession castSession) {
                promise.resolve(RNGCApplicationMetadata.toJson(castSession.getApplicationMetadata()));
            }
        }, promise);
    }

    @ReactMethod
    public void getApplicationStatus(final Promise promise) {
        this.with.withX(new With.WithX<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.3
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(CastSession castSession) {
                promise.resolve(castSession.getApplicationStatus());
            }
        }, promise);
    }

    @ReactMethod
    public void getCastDevice(final Promise promise) {
        this.with.withX(new With.WithX<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.4
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(CastSession castSession) {
                promise.resolve(RNGCDevice.toJson(castSession.getCastDevice()));
            }
        }, promise);
    }

    @ReactMethod
    public void getStandbyState(final Promise promise) {
        this.with.withX(new With.WithX<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.5
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(CastSession castSession) {
                promise.resolve(RNGCStandbyState.toJson(castSession.getStandbyState()));
            }
        }, promise);
    }

    @ReactMethod
    public void getVolume(final Promise promise) {
        this.with.withX(new With.WithX<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.6
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(CastSession castSession) {
                promise.resolve(Double.valueOf(castSession.getVolume()));
            }
        }, promise);
    }

    @ReactMethod
    public void isMute(final Promise promise) {
        this.with.withX(new With.WithX<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.7
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(CastSession castSession) {
                promise.resolve(Boolean.valueOf(castSession.isMute()));
            }
        }, promise);
    }

    @ReactMethod
    public void setMute(final boolean z, final Promise promise) {
        this.with.withX(new With.WithX<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.8
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(CastSession castSession) {
                try {
                    castSession.setMute(z);
                    promise.resolve(null);
                } catch (IOException e) {
                    promise.reject(e);
                }
            }
        }, promise);
    }

    @ReactMethod
    public void setVolume(final double d, final Promise promise) {
        this.with.withX(new With.WithX<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.9
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(CastSession castSession) {
                try {
                    castSession.setVolume(d);
                    promise.resolve(null);
                } catch (IOException e) {
                    promise.reject(e);
                }
            }
        }, promise);
    }

    @ReactMethod
    public void addChannel(final String str, final Promise promise) {
        this.with.withX(new With.WithX<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.10
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(CastSession castSession) {
                try {
                    castSession.setMessageReceivedCallbacks(str, RNGCCastSession.this.messageCallback);
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putBoolean("connected", true);
                    writableMapCreateMap.putString("namespace", str);
                    writableMapCreateMap.putBoolean("writable", true);
                    promise.resolve(writableMapCreateMap);
                } catch (IOException e) {
                    promise.reject(e);
                }
            }
        }, promise);
    }

    @ReactMethod
    public void removeChannel(final String str, final Promise promise) {
        this.with.withX(new With.WithX<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.11
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(CastSession castSession) {
                try {
                    castSession.removeMessageReceivedCallbacks(str);
                    promise.resolve(null);
                } catch (IOException e) {
                    promise.reject(e);
                }
            }
        }, promise);
    }

    @ReactMethod
    public void sendMessage(final String str, final String str2, Promise promise) {
        this.with.withX(new With.WithXPromisify<CastSession>() { // from class: com.reactnative.googlecast.api.RNGCCastSession.12
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(CastSession castSession) {
                return castSession.sendMessage(str, str2);
            }
        }, promise);
    }

    public static WritableMap toJson(CastSession castSession) {
        if (castSession == null) {
            return null;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("id", castSession.getSessionId());
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (this.mListenersAttached) {
            return;
        }
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCCastSession.17
            @Override // java.lang.Runnable
            public void run() {
                CastContext sharedInstance = RNGCCastContext.getSharedInstance(reactApplicationContext);
                if (sharedInstance == null) {
                    return;
                }
                SessionManager sessionManager = sharedInstance.getSessionManager();
                sessionManager.addSessionManagerListener(RNGCCastSession.this.sessionListener);
                RNGCCastSession.this.castSession = sessionManager.getCurrentCastSession();
                if (RNGCCastSession.this.castSession != null) {
                    RNGCCastSession.this.castSession.addCastListener(RNGCCastSession.this.castListener);
                }
            }
        });
        this.mListenersAttached = true;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCCastSession.18
            @Override // java.lang.Runnable
            public void run() {
                CastContext sharedInstance = RNGCCastContext.getSharedInstance(reactApplicationContext);
                if (sharedInstance == null) {
                    return;
                }
                SessionManager sessionManager = sharedInstance.getSessionManager();
                sessionManager.removeSessionManagerListener(RNGCCastSession.this.sessionListener);
                RNGCCastSession.this.castSession = sessionManager.getCurrentCastSession();
                if (RNGCCastSession.this.castSession != null) {
                    RNGCCastSession.this.castSession.removeCastListener(RNGCCastSession.this.castListener);
                }
            }
        });
        this.mListenersAttached = false;
    }
}
