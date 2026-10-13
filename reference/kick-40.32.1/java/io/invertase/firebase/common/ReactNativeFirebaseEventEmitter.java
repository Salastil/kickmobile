package io.invertase.firebase.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import io.invertase.firebase.app.ReactNativeFirebaseApp;
import io.invertase.firebase.interfaces.NativeEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class ReactNativeFirebaseEventEmitter {
    private static final String TAG = "RNFB_EMITTER";
    private static ReactNativeFirebaseEventEmitter sharedInstance = new ReactNativeFirebaseEventEmitter();
    private int attachedJsListenerCountSnapshot;
    private boolean attachedJsReadySnapshot;
    private HashMap<String, Integer> attachedListenersSnapshot;
    private boolean emitPrefersRestoredAttached;
    private int jsListenerCount;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final List<NativeEvent> queuedEvents = new ArrayList();
    private final HashMap<String, Integer> jsListeners = new HashMap<>();
    private WeakReference<ReactContext> attachedReactContext = new WeakReference<>(null);
    private WeakReference<ReactContext> pendingReactContext = new WeakReference<>(null);
    private WeakReference<ReactContext> hostLagReactContext = new WeakReference<>(null);
    private boolean jsReady = false;

    public static ReactNativeFirebaseEventEmitter getSharedInstance() {
        return sharedInstance;
    }

    public void attachReactContext(ReactContext reactContext) {
        ReactContext reactContext2;
        ReactContext currentReactContextFromHost = getCurrentReactContextFromHost(reactContext);
        synchronized (this.jsListeners) {
            ReactContext reactContext3 = this.attachedReactContext.get();
            if (reactContext3 == null || reactContext3 == reactContext) {
                if (reactContext3 != reactContext) {
                    acceptAttachedContext(reactContext, false);
                    clearConvergenceState();
                } else if (currentReactContextFromHost == reactContext && ((reactContext2 = this.pendingReactContext.get()) == null || reactContext2 == reactContext)) {
                    clearConvergenceState();
                }
            } else {
                if (currentReactContextFromHost == null) {
                    Log.w(TAG, "Ignoring attach of ReactContext@" + System.identityHashCode(reactContext) + " while host current is null; keeping @" + System.identityHashCode(reactContext3));
                    return;
                }
                ReactContext reactContext4 = this.hostLagReactContext.get();
                if (currentReactContextFromHost != reactContext) {
                    if (currentReactContextFromHost == reactContext3) {
                        boolean z = this.pendingReactContext.get() != reactContext;
                        StringBuilder sb = new StringBuilder("Host still on @");
                        sb.append(System.identityHashCode(reactContext3));
                        sb.append("; pending attach of @");
                        sb.append(System.identityHashCode(reactContext));
                        sb.append(z ? "" : " (idempotent)");
                        Log.i(TAG, sb.toString());
                        this.pendingReactContext = new WeakReference<>(reactContext);
                        this.hostLagReactContext = new WeakReference<>(reactContext3);
                        if (z) {
                            snapshotAttachedListenerStateIfNeeded();
                            resetListenerState();
                        }
                        this.handler.post(new Runnable() { // from class: io.invertase.firebase.common.ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.tryConvergePendingReactContext();
                            }
                        });
                        return;
                    }
                    Log.w(TAG, "Ignoring attach of non-current ReactContext@" + System.identityHashCode(reactContext) + ", current is @" + System.identityHashCode(currentReactContextFromHost));
                    return;
                }
                if (reactContext4 != null && reactContext4 == reactContext) {
                    Log.w(TAG, "Ignoring attach of host-lag ReactContext@" + System.identityHashCode(reactContext) + "; keeping live @" + System.identityHashCode(reactContext3));
                    return;
                }
                acceptAttachedContext(reactContext, this.pendingReactContext.get() != reactContext);
                clearConvergenceState();
                discardAttachedListenerSnapshot();
            }
            this.handler.post(new ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda0(this));
        }
    }

    public void detachReactContext(ReactContext reactContext) {
        synchronized (this.jsListeners) {
            ReactContext reactContext2 = this.pendingReactContext.get();
            if (reactContext2 == reactContext && this.attachedReactContext.get() != reactContext) {
                Log.i(TAG, "Cancelled pending ReactContext@" + System.identityHashCode(reactContext) + "; attached remains @" + System.identityHashCode(this.attachedReactContext.get()));
                clearConvergenceState();
                restoreAttachedListenerSnapshot();
                this.handler.post(new ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda0(this));
                return;
            }
            if (this.attachedReactContext.get() != reactContext) {
                return;
            }
            if (reactContext2 != null && reactContext2 != reactContext) {
                Log.i(TAG, "Detached ReactContext@" + System.identityHashCode(reactContext) + "; promoting pending @" + System.identityHashCode(reactContext2));
                this.attachedReactContext = new WeakReference<>(reactContext2);
                this.pendingReactContext = new WeakReference<>(null);
                discardAttachedListenerSnapshot();
                this.emitPrefersRestoredAttached = false;
                this.handler.post(new ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda0(this));
                return;
            }
            Log.i(TAG, "Detached ReactContext@" + System.identityHashCode(reactContext));
            this.attachedReactContext = new WeakReference<>(null);
            resetListenerState();
            clearConvergenceState();
            discardAttachedListenerSnapshot();
            this.emitPrefersRestoredAttached = false;
        }
    }

    public void notifyJsReady(Boolean bool) {
        synchronized (this.jsListeners) {
            this.jsReady = bool.booleanValue();
        }
        this.handler.post(new ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda0(this));
    }

    public void sendEvent(final NativeEvent nativeEvent) {
        this.handler.post(new Runnable() { // from class: io.invertase.firebase.common.ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendEvent$0(nativeEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendEvent$0(NativeEvent nativeEvent) {
        synchronized (this.jsListeners) {
            if (!this.jsListeners.containsKey(nativeEvent.getEventName())) {
                this.queuedEvents.add(nativeEvent);
            } else {
                if (emit(nativeEvent)) {
                    return;
                }
                synchronized (this.jsListeners) {
                    this.queuedEvents.add(nativeEvent);
                }
            }
        }
    }

    public void addListener(String str) {
        synchronized (this.jsListeners) {
            this.jsListenerCount++;
            boolean zContainsKey = this.jsListeners.containsKey(str);
            HashMap<String, Integer> map = this.jsListeners;
            if (!zContainsKey) {
                map.put(str, 1);
            } else {
                this.jsListeners.put(str, Integer.valueOf(map.get(str).intValue() + 1));
            }
        }
        this.handler.post(new ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda0(this));
    }

    public void removeListener(String str, Boolean bool) {
        synchronized (this.jsListeners) {
            if (this.jsListeners.containsKey(str)) {
                int iIntValue = this.jsListeners.get(str).intValue();
                if (iIntValue <= 1 || bool.booleanValue()) {
                    this.jsListeners.remove(str);
                } else {
                    this.jsListeners.put(str, Integer.valueOf(iIntValue - 1));
                }
                int i = this.jsListenerCount;
                if (!bool.booleanValue()) {
                    iIntValue = 1;
                }
                this.jsListenerCount = i - iIntValue;
            }
        }
    }

    public WritableMap getListenersMap() {
        ReactContext reactContext;
        ReactContext reactContext2;
        ReactContext reactContext3;
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        synchronized (this.jsListeners) {
            reactContext = this.pendingReactContext.get();
            reactContext2 = this.attachedReactContext.get();
        }
        if (reactContext == null) {
            reactContext = reactContext2;
        }
        ReactContext currentReactContextFromHost = getCurrentReactContextFromHost(reactContext);
        synchronized (this.jsListeners) {
            tryConvergePendingReactContextLocked(currentReactContextFromHost);
            reactContext3 = this.attachedReactContext.get();
            writableMapCreateMap.putInt("listeners", this.jsListenerCount);
            writableMapCreateMap.putInt("queued", this.queuedEvents.size());
            writableMapCreateMap.putBoolean("jsReady", this.jsReady);
            writableMapCreateMap.putInt("attachedContextHash", reactContext3 == null ? 0 : System.identityHashCode(reactContext3));
            for (Map.Entry<String, Integer> entry : this.jsListeners.entrySet()) {
                writableMapCreateMap2.putInt(entry.getKey(), entry.getValue().intValue());
            }
        }
        ReactContext currentReactContextFromHost2 = getCurrentReactContextFromHost(reactContext3);
        writableMapCreateMap.putInt("currentContextHash", currentReactContextFromHost2 != null ? System.identityHashCode(currentReactContextFromHost2) : 0);
        writableMapCreateMap.putMap("events", writableMapCreateMap2);
        return writableMapCreateMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendQueuedEvents() {
        ArrayList arrayList;
        synchronized (this.jsListeners) {
            arrayList = new ArrayList();
            for (NativeEvent nativeEvent : new ArrayList(this.queuedEvents)) {
                if (this.jsListeners.containsKey(nativeEvent.getEventName())) {
                    this.queuedEvents.remove(nativeEvent);
                    arrayList.add(nativeEvent);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sendEvent((NativeEvent) it.next());
        }
    }

    private boolean emit(NativeEvent nativeEvent) {
        synchronized (this.jsListeners) {
            if (!this.jsReady) {
                return false;
            }
            ReactContext reactContext = this.attachedReactContext.get();
            if (reactContext == null) {
                reactContext = this.pendingReactContext.get();
            }
            ReactContext currentReactContextFromHost = getCurrentReactContextFromHost(reactContext);
            synchronized (this.jsListeners) {
                if (!this.jsReady) {
                    return false;
                }
                tryConvergePendingReactContextLocked(currentReactContextFromHost);
                ReactContext reactContextResolveEmitContext = resolveEmitContext(this.attachedReactContext.get(), currentReactContextFromHost);
                if (reactContextResolveEmitContext != null && reactContextResolveEmitContext.hasActiveReactInstance()) {
                    try {
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContextResolveEmitContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("rnfb_" + nativeEvent.getEventName(), nativeEvent.getEventBody());
                        return true;
                    } catch (Exception e) {
                        Log.wtf(TAG, "Error sending Event " + nativeEvent.getEventName(), e);
                    }
                }
                return false;
            }
        }
    }

    private ReactContext resolveEmitContext(ReactContext reactContext, ReactContext reactContext2) {
        ReactContext reactContext3 = this.pendingReactContext.get();
        ReactContext reactContext4 = this.hostLagReactContext.get();
        if (reactContext3 != null) {
            return reactContext3;
        }
        if (reactContext2 != null) {
            if (reactContext == null || reactContext == reactContext2) {
                if (reactContext == reactContext2) {
                    clearConvergenceState();
                    this.emitPrefersRestoredAttached = false;
                }
            } else if ((reactContext4 == null || reactContext4 != reactContext2) && !this.emitPrefersRestoredAttached) {
            }
            return reactContext2;
        }
        return reactContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryConvergePendingReactContext() {
        ReactContext reactContext;
        synchronized (this.jsListeners) {
            reactContext = this.pendingReactContext.get();
        }
        if (reactContext == null) {
            return;
        }
        ReactContext currentReactContextFromHost = getCurrentReactContextFromHost(reactContext);
        synchronized (this.jsListeners) {
            if (tryConvergePendingReactContextLocked(currentReactContextFromHost)) {
                this.handler.post(new ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda0(this));
            }
        }
    }

    private boolean tryConvergePendingReactContextLocked(ReactContext reactContext) {
        ReactContext reactContext2 = this.pendingReactContext.get();
        if (reactContext2 == null || reactContext != reactContext2) {
            return false;
        }
        if (this.attachedReactContext.get() == reactContext2) {
            clearConvergenceState();
            return false;
        }
        Log.i(TAG, "Host caught up; attaching pending ReactContext@" + System.identityHashCode(reactContext2));
        acceptAttachedContext(reactContext2, false);
        clearConvergenceState();
        discardAttachedListenerSnapshot();
        return true;
    }

    private void acceptAttachedContext(ReactContext reactContext, boolean z) {
        ReactContext reactContext2 = this.attachedReactContext.get();
        if (reactContext2 != reactContext) {
            Log.i(TAG, "ReactContext changed: @" + System.identityHashCode(reactContext2) + " -> @" + System.identityHashCode(reactContext));
            this.attachedReactContext = new WeakReference<>(reactContext);
            this.emitPrefersRestoredAttached = false;
            if (z) {
                discardAttachedListenerSnapshot();
                resetListenerState();
            }
        }
    }

    private void resetListenerState() {
        this.jsReady = false;
        this.jsListeners.clear();
        this.jsListenerCount = 0;
    }

    private void snapshotAttachedListenerStateIfNeeded() {
        if (this.attachedListenersSnapshot != null) {
            return;
        }
        this.attachedListenersSnapshot = new HashMap<>(this.jsListeners);
        this.attachedJsReadySnapshot = this.jsReady;
        this.attachedJsListenerCountSnapshot = this.jsListenerCount;
    }

    private void restoreAttachedListenerSnapshot() {
        if (this.attachedListenersSnapshot == null) {
            resetListenerState();
            this.emitPrefersRestoredAttached = false;
            return;
        }
        this.jsListeners.clear();
        this.jsListeners.putAll(this.attachedListenersSnapshot);
        this.jsReady = this.attachedJsReadySnapshot;
        this.jsListenerCount = this.attachedJsListenerCountSnapshot;
        discardAttachedListenerSnapshot();
        this.emitPrefersRestoredAttached = true;
    }

    private void discardAttachedListenerSnapshot() {
        this.attachedListenersSnapshot = null;
        this.attachedJsReadySnapshot = false;
        this.attachedJsListenerCountSnapshot = 0;
    }

    private void clearConvergenceState() {
        this.pendingReactContext = new WeakReference<>(null);
        this.hostLagReactContext = new WeakReference<>(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.content.Context] */
    private static ReactContext getCurrentReactContextFromHost(ReactContext reactContext) {
        Context applicationContext;
        ?? applicationContext2;
        Context applicationContext3;
        if (reactContext != null) {
            applicationContext3 = reactContext.getApplicationContext();
        } else {
            applicationContext = ReactNativeFirebaseApp.getApplicationContext();
        }
        if (applicationContext2 != 0) {
            applicationContext2 = applicationContext;
            applicationContext2 = applicationContext3;
            applicationContext2 = applicationContext2.getApplicationContext();
        }
        applicationContext2 = applicationContext;
        applicationContext2 = applicationContext3;
        ReactContext currentReactContext = null;
        if (!(applicationContext2 instanceof ReactApplication)) {
            return null;
        }
        ReactApplication reactApplication = (ReactApplication) applicationContext2;
        try {
            ReactHost reactHost = reactApplication.getReactHost();
            if (reactHost != null && (currentReactContext = reactHost.getCurrentReactContext()) != null) {
                return currentReactContext;
            }
        } catch (LinkageError | RuntimeException e) {
            Log.d(TAG, "Failed to resolve current ReactContext via ReactHost", e);
        }
        try {
            ReactNativeHost reactNativeHost = reactApplication.getReactNativeHost();
            if (reactNativeHost != null && reactNativeHost.hasInstance()) {
                return reactNativeHost.getReactInstanceManager().getCurrentReactContext();
            }
        } catch (LinkageError | RuntimeException e2) {
            Log.d(TAG, "Failed to resolve current ReactContext via ReactNativeHost", e2);
        }
        return currentReactContext;
    }
}
