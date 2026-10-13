package com.reactnative.googlecast.api;

import androidx.mediarouter.media.MediaRouter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCSessionManager extends ReactContextBaseJavaModule implements LifecycleEventListener, SessionManagerListener<CastSession> {

    @VisibleForTesting
    public static final String REACT_CLASS = "RNGCSessionManager";
    public static final String SESSION_ENDED = "GoogleCast:SessionEnded";
    public static final String SESSION_ENDING = "GoogleCast:SessionEnding";
    public static final String SESSION_RESUMED = "GoogleCast:SessionResumed";
    public static final String SESSION_RESUMING = "GoogleCast:SessionResuming";
    public static final String SESSION_STARTED = "GoogleCast:SessionStarted";
    public static final String SESSION_STARTING = "GoogleCast:SessionStarting";
    public static final String SESSION_START_FAILED = "GoogleCast:SessionStartFailed";
    public static final String SESSION_SUSPENDED = "GoogleCast:SessionSuspended";
    private boolean mListenersAttached;

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumeFailed(CastSession castSession, int i) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNGCSessionManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mListenersAttached = false;
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("SESSION_STARTING", SESSION_STARTING);
        map.put("SESSION_STARTED", SESSION_STARTED);
        map.put("SESSION_START_FAILED", SESSION_START_FAILED);
        map.put("SESSION_SUSPENDED", SESSION_SUSPENDED);
        map.put("SESSION_RESUMING", SESSION_RESUMING);
        map.put("SESSION_RESUMED", SESSION_RESUMED);
        map.put("SESSION_ENDING", SESSION_ENDING);
        map.put("SESSION_ENDED", SESSION_ENDED);
        return map;
    }

    @ReactMethod
    public void endCurrentSession(final boolean z, final Promise promise) {
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCSessionManager.1
            @Override // java.lang.Runnable
            public void run() {
                SessionManager sessionManager = RNGCSessionManager.this.getSessionManager();
                if (sessionManager != null) {
                    sessionManager.endCurrentSession(z);
                }
                promise.resolve(null);
            }
        });
    }

    @ReactMethod
    public void getCurrentCastSession(final Promise promise) {
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCSessionManager.2
            @Override // java.lang.Runnable
            public void run() {
                SessionManager sessionManager = RNGCSessionManager.this.getSessionManager();
                promise.resolve(sessionManager == null ? null : RNGCCastSession.toJson(sessionManager.getCurrentCastSession()));
            }
        });
    }

    @ReactMethod
    public void startSession(final String str, final Promise promise) {
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCSessionManager.3
            @Override // java.lang.Runnable
            public void run() {
                MediaRouter mediaRouter = MediaRouter.getInstance(RNGCSessionManager.this.getReactApplicationContext());
                for (MediaRouter.RouteInfo routeInfo : mediaRouter.getRoutes()) {
                    CastDevice fromBundle = CastDevice.getFromBundle(routeInfo.getExtras());
                    if (fromBundle != null && fromBundle.getDeviceId().equals(str)) {
                        mediaRouter.selectRoute(routeInfo);
                        promise.resolve(true);
                        return;
                    }
                }
                promise.resolve(false);
            }
        });
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnded(final CastSession castSession, final int i) {
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCSessionManager.4
            @Override // java.lang.Runnable
            public void run() {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putMap("session", RNGCCastSession.toJson(castSession));
                CastContext sharedInstance = RNGCCastContext.getSharedInstance(RNGCSessionManager.this.getReactApplicationContext());
                if (sharedInstance == null || 2 != sharedInstance.getCastReasonCodeForCastStatusCode(i)) {
                    writableMapCreateMap.putString("error", CastStatusCodes.getStatusCodeString(i));
                }
                RNGCSessionManager.this.sendEvent(RNGCSessionManager.SESSION_ENDED, writableMapCreateMap);
            }
        });
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumed(CastSession castSession, boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putMap("session", RNGCCastSession.toJson(castSession));
        sendEvent(SESSION_RESUMED, writableMapCreateMap);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarted(CastSession castSession, String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putMap("session", RNGCCastSession.toJson(castSession));
        sendEvent(SESSION_STARTED, writableMapCreateMap);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStartFailed(CastSession castSession, int i) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putMap("session", RNGCCastSession.toJson(castSession));
        writableMapCreateMap.putString("error", CastStatusCodes.getStatusCodeString(i));
        sendEvent(SESSION_START_FAILED, writableMapCreateMap);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarting(CastSession castSession) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putMap("session", RNGCCastSession.toJson(castSession));
        sendEvent(SESSION_STARTING, writableMapCreateMap);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnding(CastSession castSession) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putMap("session", RNGCCastSession.toJson(castSession));
        sendEvent(SESSION_ENDING, writableMapCreateMap);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResuming(CastSession castSession, String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putMap("session", RNGCCastSession.toJson(castSession));
        sendEvent(SESSION_RESUMING, writableMapCreateMap);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionSuspended(CastSession castSession, int i) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putMap("session", RNGCCastSession.toJson(castSession));
        sendEvent(SESSION_SUSPENDED, writableMapCreateMap);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (this.mListenersAttached) {
            return;
        }
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCSessionManager.5
            @Override // java.lang.Runnable
            public void run() {
                SessionManager sessionManager = RNGCSessionManager.this.getSessionManager();
                RNGCSessionManager rNGCSessionManager = RNGCSessionManager.this;
                if (sessionManager != null) {
                    sessionManager.addSessionManagerListener(rNGCSessionManager, CastSession.class);
                    RNGCSessionManager.this.mListenersAttached = true;
                } else {
                    rNGCSessionManager.mListenersAttached = false;
                }
            }
        });
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCSessionManager.6
            @Override // java.lang.Runnable
            public void run() {
                SessionManager sessionManager = RNGCSessionManager.this.getSessionManager();
                if (sessionManager != null) {
                    sessionManager.removeSessionManagerListener(RNGCSessionManager.this, CastSession.class);
                }
                RNGCSessionManager.this.mListenersAttached = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SessionManager getSessionManager() {
        CastContext sharedInstance = RNGCCastContext.getSharedInstance(getReactApplicationContext());
        if (sharedInstance == null) {
            return null;
        }
        return sharedInstance.getSessionManager();
    }
}
