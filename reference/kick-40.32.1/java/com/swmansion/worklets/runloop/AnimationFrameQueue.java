package com.swmansion.worklets.runloop;

import android.os.SystemClock;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationFrameQueue.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0018J\u0016\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\rJ\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0007H\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180(H\u0002J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/swmansion/worklets/runloop/AnimationFrameQueue;", "", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mFirstUptime", "", "mSlowAnimationsEnabled", "", "lastFrameTimeMs", "", "mAnimationsDragFactor", "", "mReactChoreographer", "Lcom/facebook/react/modules/core/ReactChoreographer;", "mChoreographerCallback", "Lcom/facebook/react/uimanager/GuardedFrameCallback;", "mCallbackPosted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mPaused", "mInvalidated", "mFrameCallbacks", "", "Lcom/swmansion/worklets/runloop/AnimationFrameCallback;", "mDispatchLock", "resume", "", PauseEvent.TYPE, "invalidate", "requestAnimationFrame", "animationFrameCallback", "enableSlowAnimations", "slowAnimationsEnabled", "animationsDragFactor", "scheduleQueueExecution", "removePostedFrameCallback", "executeQueue", "frameTimeNanos", "pullCallbacks", "", "calculateTimestamp", "react-native-worklets_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnimationFrameQueue {
    private double lastFrameTimeMs;
    private int mAnimationsDragFactor;
    private final AtomicBoolean mCallbackPosted;
    private final GuardedFrameCallback mChoreographerCallback;
    private final Object mDispatchLock;
    private long mFirstUptime;
    private final List<AnimationFrameCallback> mFrameCallbacks;
    private final AtomicBoolean mInvalidated;
    private final AtomicBoolean mPaused;
    private final ReactChoreographer mReactChoreographer;
    private boolean mSlowAnimationsEnabled;

    public AnimationFrameQueue(final ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.mFirstUptime = SystemClock.uptimeMillis();
        this.mAnimationsDragFactor = 1;
        this.mReactChoreographer = ReactChoreographer.INSTANCE.getInstance();
        this.mChoreographerCallback = new GuardedFrameCallback(reactApplicationContext, this) { // from class: com.swmansion.worklets.runloop.AnimationFrameQueue$mChoreographerCallback$1
            final /* synthetic */ AnimationFrameQueue this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(reactApplicationContext);
                this.this$0 = this;
            }

            @Override // com.facebook.react.uimanager.GuardedFrameCallback
            protected void doFrameGuarded(long frameTimeNanos) {
                this.this$0.executeQueue(frameTimeNanos);
            }
        };
        this.mCallbackPosted = new AtomicBoolean();
        this.mPaused = new AtomicBoolean();
        this.mInvalidated = new AtomicBoolean();
        this.mFrameCallbacks = new ArrayList();
        this.mDispatchLock = new Object();
    }

    public final void resume() {
        if (this.mPaused.getAndSet(false)) {
            scheduleQueueExecution();
        }
    }

    public final void pause() {
        synchronized (this.mPaused) {
            if (!this.mPaused.getAndSet(true) && this.mCallbackPosted.getAndSet(false)) {
                this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void invalidate() {
        this.mInvalidated.set(true);
        removePostedFrameCallback();
        synchronized (this.mDispatchLock) {
            synchronized (this.mFrameCallbacks) {
                this.mFrameCallbacks.clear();
                Unit unit = Unit.INSTANCE;
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final void requestAnimationFrame(AnimationFrameCallback animationFrameCallback) {
        Intrinsics.checkNotNullParameter(animationFrameCallback, "animationFrameCallback");
        synchronized (this.mFrameCallbacks) {
            if (this.mInvalidated.get()) {
                return;
            }
            this.mFrameCallbacks.add(animationFrameCallback);
            scheduleQueueExecution();
        }
    }

    public final void enableSlowAnimations(boolean slowAnimationsEnabled, int animationsDragFactor) {
        this.mSlowAnimationsEnabled = slowAnimationsEnabled;
        this.mAnimationsDragFactor = animationsDragFactor;
        if (slowAnimationsEnabled) {
            this.mFirstUptime = SystemClock.uptimeMillis();
        }
    }

    private final void scheduleQueueExecution() {
        synchronized (this.mPaused) {
            if (this.mInvalidated.get()) {
                return;
            }
            if (!this.mPaused.get() && !this.mCallbackPosted.getAndSet(true)) {
                this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void removePostedFrameCallback() {
        if (this.mCallbackPosted.getAndSet(false)) {
            this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void executeQueue(long frameTimeNanos) {
        double dCalculateTimestamp = calculateTimestamp(frameTimeNanos);
        if (dCalculateTimestamp <= this.lastFrameTimeMs) {
            this.mCallbackPosted.set(false);
            scheduleQueueExecution();
            return;
        }
        synchronized (this.mDispatchLock) {
            List<AnimationFrameCallback> listPullCallbacks = pullCallbacks();
            this.mCallbackPosted.set(false);
            if (this.mInvalidated.get()) {
                return;
            }
            this.lastFrameTimeMs = dCalculateTimestamp;
            for (AnimationFrameCallback animationFrameCallback : listPullCallbacks) {
                if (this.mInvalidated.get()) {
                    break;
                } else {
                    animationFrameCallback.onAnimationFrame(dCalculateTimestamp);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final List<AnimationFrameCallback> pullCallbacks() {
        List<AnimationFrameCallback> list;
        synchronized (this.mFrameCallbacks) {
            list = CollectionsKt.toList(this.mFrameCallbacks);
            this.mFrameCallbacks.clear();
        }
        return list;
    }

    private final double calculateTimestamp(long frameTimeNanos) {
        double d = frameTimeNanos / 1000000.0d;
        if (!this.mSlowAnimationsEnabled) {
            return d;
        }
        long j = this.mFirstUptime;
        return j + ((d - j) / ((double) this.mAnimationsDragFactor));
    }
}
