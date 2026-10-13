package com.reactnative.googlecast.api;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.PendingResult;
import com.reactnative.googlecast.types.RNGCJSONObject;
import com.reactnative.googlecast.types.RNGCMediaLoadRequest;
import com.reactnative.googlecast.types.RNGCMediaQueueItem;
import com.reactnative.googlecast.types.RNGCMediaSeekOptions;
import com.reactnative.googlecast.types.RNGCMediaStatus;
import com.reactnative.googlecast.types.RNGCTextTrackStyle;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCRemoteMediaClient extends ReactContextBaseJavaModule implements LifecycleEventListener {
    public static final String MEDIA_PROGRESS_UPDATED = "GoogleCast:MediaProgressUpdated";
    public static final String MEDIA_STATUS_UPDATED = "GoogleCast:MediaStatusUpdated";

    @VisibleForTesting
    public static final String REACT_CLASS = "RNGCRemoteMediaClient";
    private RemoteMediaClient.Callback clientCallback;
    private boolean mListenersAttached;
    private RemoteMediaClient.ProgressListener progressListener;
    private SessionManagerListener sessionListener;
    protected With<RemoteMediaClient> with;

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNGCRemoteMediaClient(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mListenersAttached = false;
        this.with = new With<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.19
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.reactnative.googlecast.api.With
            public RemoteMediaClient getX() {
                CastSession currentCastSession;
                CastContext sharedInstance = RNGCCastContext.getSharedInstance(getReactApplicationContext());
                if (sharedInstance == null || (currentCastSession = sharedInstance.getSessionManager().getCurrentCastSession()) == null) {
                    return null;
                }
                return currentCastSession.getRemoteMediaClient();
            }

            @Override // com.reactnative.googlecast.api.With
            protected ReactContext getReactApplicationContext() {
                return RNGCRemoteMediaClient.this.getReactApplicationContext();
            }
        };
        this.clientCallback = new RemoteMediaClient.Callback() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.20
            @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
            public void onStatusUpdated() {
                RNGCRemoteMediaClient.this.with.withX(new With.WithX<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.20.1
                    @Override // com.reactnative.googlecast.api.With.WithX
                    public void execute(RemoteMediaClient remoteMediaClient) {
                        MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
                        RNGCRemoteMediaClient.this.sendEvent(RNGCRemoteMediaClient.MEDIA_STATUS_UPDATED, RNGCMediaStatus.toJson(mediaStatus));
                        if (mediaStatus == null || mediaStatus.getPlayerState() == 1 || mediaStatus.getPlayerState() == 0) {
                            WritableArray writableArrayCreateArray = Arguments.createArray();
                            writableArrayCreateArray.pushNull();
                            writableArrayCreateArray.pushNull();
                            RNGCRemoteMediaClient.this.sendEvent(RNGCRemoteMediaClient.MEDIA_PROGRESS_UPDATED, writableArrayCreateArray);
                        }
                    }
                });
            }
        };
        this.progressListener = new RemoteMediaClient.ProgressListener() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.21
            @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener
            public void onProgressUpdated(long j, long j2) {
                RNGCRemoteMediaClient.this.sendEvent(RNGCRemoteMediaClient.MEDIA_PROGRESS_UPDATED, Arguments.fromArray(new double[]{j / 1000.0d, j2 / 1000.0d}));
            }
        };
        this.sessionListener = new CastSessionManagerListener() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.22
            @Override // com.reactnative.googlecast.api.CastSessionManagerListener, com.google.android.gms.cast.framework.SessionManagerListener
            public void onSessionResumed(CastSession castSession, boolean z) {
                castSession.getRemoteMediaClient().registerCallback(RNGCRemoteMediaClient.this.clientCallback);
            }

            @Override // com.reactnative.googlecast.api.CastSessionManagerListener, com.google.android.gms.cast.framework.SessionManagerListener
            public void onSessionStarted(CastSession castSession, String str) {
                castSession.getRemoteMediaClient().registerCallback(RNGCRemoteMediaClient.this.clientCallback);
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
        map.put("MEDIA_PROGRESS_UPDATED", MEDIA_PROGRESS_UPDATED);
        map.put("MEDIA_STATUS_UPDATED", MEDIA_STATUS_UPDATED);
        return map;
    }

    @ReactMethod
    public void getMediaStatus(final Promise promise) {
        this.with.withX(new With.WithX<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.1
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(RemoteMediaClient remoteMediaClient) {
                promise.resolve(RNGCMediaStatus.toJson(remoteMediaClient.getMediaStatus()));
            }
        }, promise);
    }

    @ReactMethod
    public void getStreamPosition(final Promise promise) {
        this.with.withX(new With.WithX<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.2
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(RemoteMediaClient remoteMediaClient) {
                MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
                if (mediaStatus == null || mediaStatus.getPlayerState() == 1 || mediaStatus.getPlayerState() == 0) {
                    promise.resolve(null);
                } else {
                    promise.resolve(Double.valueOf(remoteMediaClient.getApproximateStreamPosition() / 1000.0d));
                }
            }
        }, promise);
    }

    @ReactMethod
    public void loadMedia(final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.3
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.load(RNGCMediaLoadRequest.fromJson(readableMap));
            }
        }, promise);
    }

    @ReactMethod
    public void pause(final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.4
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.pause(RNGCJSONObject.fromJson(readableMap));
            }
        }, promise);
    }

    @ReactMethod
    public void play(final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.5
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.play(RNGCJSONObject.fromJson(readableMap));
            }
        }, promise);
    }

    @ReactMethod
    public void queueInsertAndPlayItem(final ReadableMap readableMap, final Integer num, final Integer num2, final ReadableMap readableMap2, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.6
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.queueInsertAndPlayItem(RNGCMediaQueueItem.fromJson(readableMap), num.intValue(), num2.intValue(), RNGCJSONObject.fromJson(readableMap2));
            }
        }, promise);
    }

    @ReactMethod
    public void queueInsertItems(final ReadableArray readableArray, final Integer num, final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.7
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[readableArray.size()];
                for (int i = 0; i < readableArray.size(); i++) {
                    mediaQueueItemArr[i] = RNGCMediaQueueItem.fromJson(readableArray.getMap(i));
                }
                return remoteMediaClient.queueInsertItems(mediaQueueItemArr, num.intValue(), RNGCJSONObject.fromJson(readableMap));
            }
        }, promise);
    }

    @ReactMethod
    public void queueNext(final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.8
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.queueNext(RNGCJSONObject.fromJson(readableMap));
            }
        }, promise);
    }

    @ReactMethod
    public void queuePrev(final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.9
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.queuePrev(RNGCJSONObject.fromJson(readableMap));
            }
        }, promise);
    }

    @ReactMethod
    public void requestStatus(Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.10
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.requestStatus();
            }
        }, promise);
    }

    @ReactMethod
    public void seek(final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.11
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.seek(RNGCMediaSeekOptions.fromJson(readableMap));
            }
        }, promise);
    }

    @ReactMethod
    public void setActiveTrackIds(final ReadableArray readableArray, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.12
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                long[] jArr = new long[readableArray.size()];
                for (int i = 0; i < readableArray.size(); i++) {
                    jArr[i] = readableArray.getInt(i);
                }
                return remoteMediaClient.setActiveMediaTracks(jArr);
            }
        }, promise);
    }

    @ReactMethod
    public void setPlaybackRate(final double d, final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.13
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.setPlaybackRate(d, RNGCJSONObject.fromJson(readableMap));
            }
        }, promise);
    }

    @ReactMethod
    public void setProgressUpdateInterval(final Double d, Promise promise) {
        this.with.withX(new With.WithX<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.14
            @Override // com.reactnative.googlecast.api.With.WithX
            public void execute(RemoteMediaClient remoteMediaClient) {
                remoteMediaClient.removeProgressListener(RNGCRemoteMediaClient.this.progressListener);
                Double d2 = d;
                if (d2 == null || d2.doubleValue() <= 0.0d) {
                    return;
                }
                remoteMediaClient.addProgressListener(RNGCRemoteMediaClient.this.progressListener, Math.round(d.doubleValue() * 1000.0d));
            }
        }, promise);
    }

    @ReactMethod
    public void setStreamMuted(final boolean z, final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.15
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.setStreamMute(z, RNGCJSONObject.fromJson(readableMap));
            }
        }, promise);
    }

    @ReactMethod
    public void setStreamVolume(final double d, final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.16
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.setStreamVolume(d, RNGCJSONObject.fromJson(readableMap));
            }
        }, promise);
    }

    @ReactMethod
    public void setTextTrackStyle(final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.17
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.setTextTrackStyle(RNGCTextTrackStyle.fromJson(readableMap));
            }
        }, promise);
    }

    @ReactMethod
    public void stop(final ReadableMap readableMap, Promise promise) {
        this.with.withX(new With.WithXPromisify<RemoteMediaClient>() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.18
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(RemoteMediaClient remoteMediaClient) {
                return remoteMediaClient.stop(RNGCJSONObject.fromJson(readableMap));
            }
        }, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(String str, Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (this.mListenersAttached) {
            return;
        }
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.23
            @Override // java.lang.Runnable
            public void run() {
                CastContext sharedInstance = RNGCCastContext.getSharedInstance(reactApplicationContext);
                if (sharedInstance == null) {
                    return;
                }
                SessionManager sessionManager = sharedInstance.getSessionManager();
                sessionManager.addSessionManagerListener(RNGCRemoteMediaClient.this.sessionListener);
                CastSession currentCastSession = sessionManager.getCurrentCastSession();
                if (currentCastSession == null || currentCastSession.getRemoteMediaClient() == null) {
                    return;
                }
                currentCastSession.getRemoteMediaClient().registerCallback(RNGCRemoteMediaClient.this.clientCallback);
            }
        });
        this.mListenersAttached = true;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.RNGCRemoteMediaClient.24
            @Override // java.lang.Runnable
            public void run() {
                CastContext sharedInstance = RNGCCastContext.getSharedInstance(reactApplicationContext);
                if (sharedInstance == null) {
                    return;
                }
                SessionManager sessionManager = sharedInstance.getSessionManager();
                sessionManager.removeSessionManagerListener(RNGCRemoteMediaClient.this.sessionListener);
                CastSession currentCastSession = sessionManager.getCurrentCastSession();
                if (currentCastSession == null || currentCastSession.getRemoteMediaClient() == null) {
                    return;
                }
                currentCastSession.getRemoteMediaClient().unregisterCallback(RNGCRemoteMediaClient.this.clientCallback);
            }
        });
        this.mListenersAttached = false;
    }
}
