package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.trace.api.config.ProfilingConfig;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.swiperefresh.ReactSwipeRefreshLayout;
import com.facebook.react.views.text.ReactTextView;
import com.facebook.react.views.textinput.ReactEditText;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper;
import com.swmansion.gesturehandler.react.events.eventbuilders.NativeGestureHandlerEventDataBuilder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeViewGestureHandler.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 72\u00020\u0001:\u000b3456789:;<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0001H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0001H\u0016J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0001J\u0016\u0010!\u001a\u00020\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010#H\u0016J\b\u0010$\u001a\u00020\u0018H\u0014J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0014J\b\u0010)\u001a\u00020\u0018H\u0002J\b\u0010*\u001a\u00020\u0018H\u0014J\b\u0010+\u001a\u00020\u0018H\u0014J\b\u0010,\u001a\u00020\u0018H\u0014J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0016J\b\u00102\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "<init>", "()V", "isContinuous", "", "()Z", "shouldActivateOnStart", "value", "disallowInterruption", "getDisallowInterruption", "yieldsToContinuousGestures", "getYieldsToContinuousGestures", "delaysChildPressedState", "getDelaysChildPressedState", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "pressedStateDelayOverriddenView", "Landroid/view/View;", "hook", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "lastActiveUpdate", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$ActiveUpdateSnapshot;", "resetConfig", "", "updateConfig", "config", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Config;", "shouldRecognizeSimultaneously", "handler", "shouldBeCancelledBy", "canBeInterruptedBy", "other", "shouldBeginWithRecordedHandlers", "recorded", "", "onPrepare", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "dispatchCancelEventToView", "onCancel", "onFail", "onReset", "dispatchHandlerUpdate", "dispatchStateChange", "newState", "", "prevState", "wantsToAttachDirectlyToView", "ActiveUpdateSnapshot", "HitSlop", "Config", "Factory", "Companion", "NativeViewGestureHandlerHook", "TextViewHook", "EditTextHook", "SwipeRefreshLayoutHook", "ScrollViewHook", "ReactViewGroupHook", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NativeViewGestureHandler extends GestureHandler {
    private static final boolean DEFAULT_DISALLOW_INTERRUPTION = false;
    private static final boolean DEFAULT_SHOULD_ACTIVATE_ON_START = false;
    private static final boolean DEFAULT_SHOULD_CANCEL_WHEN_OUTSIDE = true;
    private static final boolean DEFAULT_YIELDS_TO_CONTINUOUS_GESTURES = false;
    private Boolean delaysChildPressedState;
    private boolean disallowInterruption;
    private ActiveUpdateSnapshot lastActiveUpdate;
    private View pressedStateDelayOverriddenView;
    private boolean shouldActivateOnStart;
    private boolean yieldsToContinuousGestures;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean DEFAULT_DELAYS_CHILD_PRESSED_STATE = true;
    private static final Lazy<Method> childPressedStateDelaySetter$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.gesturehandler.core.NativeViewGestureHandler$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NativeViewGestureHandler.childPressedStateDelaySetter_delegate$lambda$0();
        }
    });
    private static final NativeViewGestureHandler$Companion$defaultHook$1 defaultHook = new NativeViewGestureHandlerHook() { // from class: com.swmansion.gesturehandler.core.NativeViewGestureHandler$Companion$defaultHook$1
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void afterGestureEnd(MotionEvent motionEvent) {
            super.afterGestureEnd(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canActivate(View view) {
            return super.canActivate(view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canBegin(MotionEvent motionEvent) {
            return super.canBegin(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void handleEventBeforeActivation(MotionEvent motionEvent) {
            super.handleEventBeforeActivation(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerStateChange(NativeViewGestureHandler nativeViewGestureHandler, int i, int i2) {
            super.onHandlerStateChange(nativeViewGestureHandler, i, i2);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerUpdate(NativeViewGestureHandler nativeViewGestureHandler) {
            super.onHandlerUpdate(nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ Boolean sendTouchEvent(View view, MotionEvent motionEvent) {
            return super.sendTouchEvent(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean shouldBeginWithRecordedHandlers(List<? extends GestureHandler> list, NativeViewGestureHandler nativeViewGestureHandler) {
            return super.shouldBeginWithRecordedHandlers(list, nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return super.shouldCancelRootViewGestureHandlerIfNecessary();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ Boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler) {
            return super.shouldRecognizeSimultaneously(gestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean wantsToHandleEventBeforeActivation() {
            return super.wantsToHandleEventBeforeActivation();
        }
    };
    private final boolean isContinuous = true;
    private NativeViewGestureHandlerHook hook = defaultHook;

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean wantsToAttachDirectlyToView() {
        return true;
    }

    public NativeViewGestureHandler() {
        setShouldCancelWhenOutside(true);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    /* JADX INFO: renamed from: isContinuous, reason: from getter */
    public boolean getIsContinuous() {
        return this.isContinuous;
    }

    public final boolean getDisallowInterruption() {
        return this.disallowInterruption;
    }

    public final boolean getYieldsToContinuousGestures() {
        return this.yieldsToContinuousGestures;
    }

    public final Boolean getDelaysChildPressedState() {
        return this.delaysChildPressedState;
    }

    /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$ActiveUpdateSnapshot;", "", "pointerInside", "", "numberOfPointers", "", "pointerType", "<init>", "(ZII)V", "getPointerInside", "()Z", "getNumberOfPointers", "()I", "getPointerType", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class ActiveUpdateSnapshot {
        private final int numberOfPointers;
        private final boolean pointerInside;
        private final int pointerType;

        public static /* synthetic */ ActiveUpdateSnapshot copy$default(ActiveUpdateSnapshot activeUpdateSnapshot, boolean z, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z = activeUpdateSnapshot.pointerInside;
            }
            if ((i3 & 2) != 0) {
                i = activeUpdateSnapshot.numberOfPointers;
            }
            if ((i3 & 4) != 0) {
                i2 = activeUpdateSnapshot.pointerType;
            }
            return activeUpdateSnapshot.copy(z, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getPointerInside() {
            return this.pointerInside;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getNumberOfPointers() {
            return this.numberOfPointers;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPointerType() {
            return this.pointerType;
        }

        public final ActiveUpdateSnapshot copy(boolean pointerInside, int numberOfPointers, int pointerType) {
            return new ActiveUpdateSnapshot(pointerInside, numberOfPointers, pointerType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActiveUpdateSnapshot)) {
                return false;
            }
            ActiveUpdateSnapshot activeUpdateSnapshot = (ActiveUpdateSnapshot) other;
            return this.pointerInside == activeUpdateSnapshot.pointerInside && this.numberOfPointers == activeUpdateSnapshot.numberOfPointers && this.pointerType == activeUpdateSnapshot.pointerType;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.pointerInside) * 31) + Integer.hashCode(this.numberOfPointers)) * 31) + Integer.hashCode(this.pointerType);
        }

        public String toString() {
            return "ActiveUpdateSnapshot(pointerInside=" + this.pointerInside + ", numberOfPointers=" + this.numberOfPointers + ", pointerType=" + this.pointerType + ")";
        }

        public ActiveUpdateSnapshot(boolean z, int i, int i2) {
            this.pointerInside = z;
            this.numberOfPointers = i;
            this.pointerType = i2;
        }

        public final int getNumberOfPointers() {
            return this.numberOfPointers;
        }

        public final boolean getPointerInside() {
            return this.pointerInside;
        }

        public final int getPointerType() {
            return this.pointerType;
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.shouldActivateOnStart = false;
        this.disallowInterruption = false;
        this.yieldsToContinuousGestures = false;
        setShouldCancelWhenOutside(true);
        this.delaysChildPressedState = Boolean.valueOf(DEFAULT_DELAYS_CHILD_PRESSED_STATE);
    }

    public final void updateConfig(Config config) {
        NativeViewGestureHandler nativeViewGestureHandler;
        Intrinsics.checkNotNullParameter(config, "config");
        setEnabled(config.getEnabled());
        setShouldCancelWhenOutside(config.getShouldCancelWhenOutside());
        setTestID(config.getTestID());
        HitSlop hitSlop = config.getHitSlop();
        if (hitSlop != null) {
            nativeViewGestureHandler = this;
            nativeViewGestureHandler.setHitSlop(hitSlop.getLeft(), hitSlop.getTop(), hitSlop.getRight(), hitSlop.getBottom(), Float.NaN, Float.NaN);
        } else {
            nativeViewGestureHandler = this;
            nativeViewGestureHandler.setHitSlop(null);
        }
        nativeViewGestureHandler.shouldActivateOnStart = config.getShouldActivateOnStart();
        nativeViewGestureHandler.disallowInterruption = config.getDisallowInterruption();
        nativeViewGestureHandler.yieldsToContinuousGestures = config.getYieldsToContinuousGestures();
        nativeViewGestureHandler.delaysChildPressedState = config.getDelaysChildPressedState();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean shouldRecognizeSimultaneously(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Boolean boolShouldRecognizeSimultaneously = this.hook.shouldRecognizeSimultaneously(handler);
        if (boolShouldRecognizeSimultaneously != null) {
            return boolShouldRecognizeSimultaneously.booleanValue();
        }
        if (super.shouldRecognizeSimultaneously(handler)) {
            return true;
        }
        if ((handler instanceof NativeViewGestureHandler) && handler.getState() == 4) {
            NativeViewGestureHandler nativeViewGestureHandler = (NativeViewGestureHandler) handler;
            if (nativeViewGestureHandler.disallowInterruption && !nativeViewGestureHandler.yieldsToContinuousGestures) {
                return false;
            }
        }
        boolean zCanBeInterruptedBy = canBeInterruptedBy(handler);
        return !(getState() == 4 && handler.getState() == 4 && zCanBeInterruptedBy) && getState() == 4 && zCanBeInterruptedBy && (!this.hook.shouldCancelRootViewGestureHandlerIfNecessary() || handler.getTag() > 0);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean shouldBeCancelledBy(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return canBeInterruptedBy(handler);
    }

    public final boolean canBeInterruptedBy(GestureHandler other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.disallowInterruption) {
            return this.yieldsToContinuousGestures && other.getIsContinuous();
        }
        return true;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean shouldBeginWithRecordedHandlers(List<? extends GestureHandler> recorded) {
        Intrinsics.checkNotNullParameter(recorded, "recorded");
        return this.hook.shouldBeginWithRecordedHandlers(recorded, this);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onPrepare() {
        KeyEvent.Callback view = getView();
        if (view instanceof NativeViewGestureHandlerHook) {
            this.hook = (NativeViewGestureHandlerHook) view;
        } else if (view instanceof ReactEditText) {
            this.hook = new EditTextHook(this, (ReactEditText) view);
        } else if (view instanceof ReactSwipeRefreshLayout) {
            this.hook = new SwipeRefreshLayoutHook(this, (ReactSwipeRefreshLayout) view);
        } else if ((view instanceof ReactScrollView) || (view instanceof ReactHorizontalScrollView)) {
            this.hook = new ScrollViewHook();
        } else if (view instanceof ReactTextView) {
            this.hook = new TextViewHook();
        } else if (view instanceof ReactViewGroup) {
            this.hook = new ReactViewGroupHook();
        }
        Boolean bool = this.delaysChildPressedState;
        if (bool != null) {
            bool.booleanValue();
            View view2 = getView();
            if (view2 == null || !INSTANCE.trySetChildPressedStateDelay(view2, bool)) {
                return;
            }
            this.pressedStateDelayOverriddenView = view2;
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        View view = getView();
        Intrinsics.checkNotNull(view);
        if (event.getActionMasked() == 1) {
            if (getState() == 0 && !this.hook.canBegin(event)) {
                cancel();
            } else {
                this.hook.sendTouchEvent(view, event);
                if ((getState() == 0 || getState() == 2) && this.hook.canActivate(view)) {
                    activate();
                }
                if (getState() == 0) {
                    cancel();
                } else {
                    end();
                }
            }
            this.hook.afterGestureEnd(event);
            return;
        }
        if (getState() == 0 || getState() == 2) {
            if (getState() != 2 && this.hook.canBegin(event)) {
                begin();
            }
            if (this.shouldActivateOnStart) {
                INSTANCE.tryIntercept(view, event);
                this.hook.sendTouchEvent(view, event);
                activate();
                return;
            }
            boolean zTryIntercept = INSTANCE.tryIntercept(view, event);
            NativeViewGestureHandlerHook nativeViewGestureHandlerHook = this.hook;
            if (zTryIntercept) {
                nativeViewGestureHandlerHook.sendTouchEvent(view, event);
                activate();
                return;
            } else {
                if (nativeViewGestureHandlerHook.wantsToHandleEventBeforeActivation()) {
                    this.hook.handleEventBeforeActivation(event);
                    return;
                }
                return;
            }
        }
        if (getState() == 4) {
            this.hook.sendTouchEvent(view, event);
        }
    }

    private final void dispatchCancelEventToView() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        motionEventObtain.setAction(3);
        NativeViewGestureHandlerHook nativeViewGestureHandlerHook = this.hook;
        View view = getView();
        Intrinsics.checkNotNull(motionEventObtain);
        nativeViewGestureHandlerHook.sendTouchEvent(view, motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onCancel() {
        dispatchCancelEventToView();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onFail() {
        dispatchCancelEventToView();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onReset() {
        this.hook = defaultHook;
        this.lastActiveUpdate = null;
        View view = this.pressedStateDelayOverriddenView;
        if (view != null) {
            INSTANCE.trySetChildPressedStateDelay(view, null);
        }
        this.pressedStateDelayOverriddenView = null;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void dispatchHandlerUpdate(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ActiveUpdateSnapshot activeUpdateSnapshot = new ActiveUpdateSnapshot(getIsWithinBounds(), getNumberOfPointers(), getPointerType());
        if (Intrinsics.areEqual(activeUpdateSnapshot, this.lastActiveUpdate)) {
            return;
        }
        this.lastActiveUpdate = activeUpdateSnapshot;
        super.dispatchHandlerUpdate(event);
        this.hook.onHandlerUpdate(this);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void dispatchStateChange(int newState, int prevState) {
        this.lastActiveUpdate = null;
        super.dispatchStateChange(newState, prevState);
        this.hook.onHandlerStateChange(this, newState, prevState);
    }

    /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$HitSlop;", "", "left", "", ViewProps.TOP, "right", ViewProps.BOTTOM, "<init>", "(FFFF)V", "getLeft", "()F", "getTop", "getRight", "getBottom", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class HitSlop {
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public HitSlop() {
            this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        }

        public static /* synthetic */ HitSlop copy$default(HitSlop hitSlop, float f, float f2, float f3, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = hitSlop.left;
            }
            if ((i & 2) != 0) {
                f2 = hitSlop.top;
            }
            if ((i & 4) != 0) {
                f3 = hitSlop.right;
            }
            if ((i & 8) != 0) {
                f4 = hitSlop.bottom;
            }
            return hitSlop.copy(f, f2, f3, f4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getLeft() {
            return this.left;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getTop() {
            return this.top;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getRight() {
            return this.right;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getBottom() {
            return this.bottom;
        }

        public final HitSlop copy(float left, float top, float right, float bottom) {
            return new HitSlop(left, top, right, bottom);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HitSlop)) {
                return false;
            }
            HitSlop hitSlop = (HitSlop) other;
            return Float.compare(this.left, hitSlop.left) == 0 && Float.compare(this.top, hitSlop.top) == 0 && Float.compare(this.right, hitSlop.right) == 0 && Float.compare(this.bottom, hitSlop.bottom) == 0;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.left) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom);
        }

        public String toString() {
            return "HitSlop(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
        }

        public HitSlop(float f, float f2, float f3, float f4) {
            this.left = f;
            this.top = f2;
            this.right = f3;
            this.bottom = f4;
        }

        public /* synthetic */ HitSlop(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Float.NaN : f, (i & 2) != 0 ? Float.NaN : f2, (i & 4) != 0 ? Float.NaN : f3, (i & 8) != 0 ? Float.NaN : f4);
        }

        public final float getLeft() {
            return this.left;
        }

        public final float getTop() {
            return this.top;
        }

        public final float getRight() {
            return this.right;
        }

        public final float getBottom() {
            return this.bottom;
        }
    }

    /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJd\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004J\n\u0010*\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Config;", "", "enabled", "", "shouldCancelWhenOutside", "hitSlop", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$HitSlop;", ViewProps.TEST_ID, "", "shouldActivateOnStart", "disallowInterruption", "yieldsToContinuousGestures", "delaysChildPressedState", "<init>", "(ZZLcom/swmansion/gesturehandler/core/NativeViewGestureHandler$HitSlop;Ljava/lang/String;ZZZLjava/lang/Boolean;)V", "getEnabled", "()Z", "getShouldCancelWhenOutside", "getHitSlop", "()Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$HitSlop;", "getTestID", "()Ljava/lang/String;", "getShouldActivateOnStart", "getDisallowInterruption", "getYieldsToContinuousGestures", "getDelaysChildPressedState", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZZLcom/swmansion/gesturehandler/core/NativeViewGestureHandler$HitSlop;Ljava/lang/String;ZZZLjava/lang/Boolean;)Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Config;", "equals", "other", "hashCode", "", "toString", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Config {
        private final Boolean delaysChildPressedState;
        private final boolean disallowInterruption;
        private final boolean enabled;
        private final HitSlop hitSlop;
        private final boolean shouldActivateOnStart;
        private final boolean shouldCancelWhenOutside;
        private final String testID;
        private final boolean yieldsToContinuousGestures;

        public Config() {
            this(false, false, null, null, false, false, false, null, 255, null);
        }

        public static /* synthetic */ Config copy$default(Config config, boolean z, boolean z2, HitSlop hitSlop, String str, boolean z3, boolean z4, boolean z5, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                z = config.enabled;
            }
            if ((i & 2) != 0) {
                z2 = config.shouldCancelWhenOutside;
            }
            if ((i & 4) != 0) {
                hitSlop = config.hitSlop;
            }
            if ((i & 8) != 0) {
                str = config.testID;
            }
            if ((i & 16) != 0) {
                z3 = config.shouldActivateOnStart;
            }
            if ((i & 32) != 0) {
                z4 = config.disallowInterruption;
            }
            if ((i & 64) != 0) {
                z5 = config.yieldsToContinuousGestures;
            }
            if ((i & 128) != 0) {
                bool = config.delaysChildPressedState;
            }
            boolean z6 = z5;
            Boolean bool2 = bool;
            boolean z7 = z3;
            boolean z8 = z4;
            return config.copy(z, z2, hitSlop, str, z7, z8, z6, bool2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShouldCancelWhenOutside() {
            return this.shouldCancelWhenOutside;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final HitSlop getHitSlop() {
            return this.hitSlop;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTestID() {
            return this.testID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getShouldActivateOnStart() {
            return this.shouldActivateOnStart;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getDisallowInterruption() {
            return this.disallowInterruption;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getYieldsToContinuousGestures() {
            return this.yieldsToContinuousGestures;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getDelaysChildPressedState() {
            return this.delaysChildPressedState;
        }

        public final Config copy(boolean enabled, boolean shouldCancelWhenOutside, HitSlop hitSlop, String testID, boolean shouldActivateOnStart, boolean disallowInterruption, boolean yieldsToContinuousGestures, Boolean delaysChildPressedState) {
            return new Config(enabled, shouldCancelWhenOutside, hitSlop, testID, shouldActivateOnStart, disallowInterruption, yieldsToContinuousGestures, delaysChildPressedState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return this.enabled == config.enabled && this.shouldCancelWhenOutside == config.shouldCancelWhenOutside && Intrinsics.areEqual(this.hitSlop, config.hitSlop) && Intrinsics.areEqual(this.testID, config.testID) && this.shouldActivateOnStart == config.shouldActivateOnStart && this.disallowInterruption == config.disallowInterruption && this.yieldsToContinuousGestures == config.yieldsToContinuousGestures && Intrinsics.areEqual(this.delaysChildPressedState, config.delaysChildPressedState);
        }

        public int hashCode() {
            int iHashCode = ((Boolean.hashCode(this.enabled) * 31) + Boolean.hashCode(this.shouldCancelWhenOutside)) * 31;
            HitSlop hitSlop = this.hitSlop;
            int iHashCode2 = (iHashCode + (hitSlop == null ? 0 : hitSlop.hashCode())) * 31;
            String str = this.testID;
            int iHashCode3 = (((((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.shouldActivateOnStart)) * 31) + Boolean.hashCode(this.disallowInterruption)) * 31) + Boolean.hashCode(this.yieldsToContinuousGestures)) * 31;
            Boolean bool = this.delaysChildPressedState;
            return iHashCode3 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "Config(enabled=" + this.enabled + ", shouldCancelWhenOutside=" + this.shouldCancelWhenOutside + ", hitSlop=" + this.hitSlop + ", testID=" + this.testID + ", shouldActivateOnStart=" + this.shouldActivateOnStart + ", disallowInterruption=" + this.disallowInterruption + ", yieldsToContinuousGestures=" + this.yieldsToContinuousGestures + ", delaysChildPressedState=" + this.delaysChildPressedState + ")";
        }

        public Config(boolean z, boolean z2, HitSlop hitSlop, String str, boolean z3, boolean z4, boolean z5, Boolean bool) {
            this.enabled = z;
            this.shouldCancelWhenOutside = z2;
            this.hitSlop = hitSlop;
            this.testID = str;
            this.shouldActivateOnStart = z3;
            this.disallowInterruption = z4;
            this.yieldsToContinuousGestures = z5;
            this.delaysChildPressedState = bool;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final boolean getShouldCancelWhenOutside() {
            return this.shouldCancelWhenOutside;
        }

        public final HitSlop getHitSlop() {
            return this.hitSlop;
        }

        public final String getTestID() {
            return this.testID;
        }

        public final boolean getShouldActivateOnStart() {
            return this.shouldActivateOnStart;
        }

        public final boolean getDisallowInterruption() {
            return this.disallowInterruption;
        }

        public final boolean getYieldsToContinuousGestures() {
            return this.yieldsToContinuousGestures;
        }

        public /* synthetic */ Config(boolean z, boolean z2, HitSlop hitSlop, String str, boolean z3, boolean z4, boolean z5, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? null : hitSlop, (i & 8) != 0 ? null : str, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4, (i & 64) != 0 ? false : z5, (i & 128) != 0 ? Boolean.valueOf(NativeViewGestureHandler.DEFAULT_DELAYS_CHILD_PRESSED_STATE) : bool);
        }

        public final Boolean getDelaysChildPressedState() {
            return this.delaysChildPressedState;
        }
    }

    /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Factory;", "Lcom/swmansion/gesturehandler/core/GestureHandler$Factory;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "<init>", "()V", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "name", "", "getName", "()Ljava/lang/String;", "create", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "updateConfig", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/events/eventbuilders/NativeGestureHandlerEventDataBuilder;", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Factory extends GestureHandler.Factory<NativeViewGestureHandler> {
        private static final String KEY_DELAYS_CHILD_PRESSED_STATE = "delaysChildPressedState";
        private static final String KEY_DISALLOW_INTERRUPTION = "disallowInterruption";
        private static final String KEY_SHOULD_ACTIVATE_ON_START = "shouldActivateOnStart";
        private static final String KEY_YIELDS_TO_CONTINUOUS_GESTURES = "yieldsToContinuousGestures";
        private final Class<NativeViewGestureHandler> type = NativeViewGestureHandler.class;
        private final String name = "NativeViewGestureHandler";

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public Class<NativeViewGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public NativeViewGestureHandler create(Context context) {
            return new NativeViewGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public void updateConfig(NativeViewGestureHandler handler, ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.updateConfig(handler, config);
            if (config.hasKey(KEY_SHOULD_ACTIVATE_ON_START)) {
                handler.shouldActivateOnStart = config.getBoolean(KEY_SHOULD_ACTIVATE_ON_START);
            }
            if (config.hasKey(KEY_DISALLOW_INTERRUPTION)) {
                handler.disallowInterruption = config.getBoolean(KEY_DISALLOW_INTERRUPTION);
            }
            if (config.hasKey(KEY_YIELDS_TO_CONTINUOUS_GESTURES)) {
                handler.yieldsToContinuousGestures = config.getBoolean(KEY_YIELDS_TO_CONTINUOUS_GESTURES);
            }
            if (config.hasKey(KEY_DELAYS_CHILD_PRESSED_STATE)) {
                handler.delaysChildPressedState = Boolean.valueOf(config.getBoolean(KEY_DELAYS_CHILD_PRESSED_STATE));
            }
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public NativeGestureHandlerEventDataBuilder createEventBuilder(NativeViewGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new NativeGestureHandlerEventDataBuilder(handler);
        }
    }

    /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
    @Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u0001\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion;", "", "<init>", "()V", "DEFAULT_SHOULD_CANCEL_WHEN_OUTSIDE", "", "DEFAULT_SHOULD_ACTIVATE_ON_START", "DEFAULT_DISALLOW_INTERRUPTION", "DEFAULT_YIELDS_TO_CONTINUOUS_GESTURES", "DEFAULT_DELAYS_CHILD_PRESSED_STATE", "childPressedStateDelaySetter", "Ljava/lang/reflect/Method;", "getChildPressedStateDelaySetter", "()Ljava/lang/reflect/Method;", "childPressedStateDelaySetter$delegate", "Lkotlin/Lazy;", "trySetChildPressedStateDelay", "view", "Landroid/view/View;", "value", "(Landroid/view/View;Ljava/lang/Boolean;)Z", "tryIntercept", "event", "Landroid/view/MotionEvent;", "defaultHook", "com/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion$defaultHook$1", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion$defaultHook$1;", "ScrollDirection", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final Method getChildPressedStateDelaySetter() {
            return (Method) NativeViewGestureHandler.childPressedStateDelaySetter$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean trySetChildPressedStateDelay(View view, Boolean value) {
            Method childPressedStateDelaySetter = getChildPressedStateDelaySetter();
            if (childPressedStateDelaySetter == null || !childPressedStateDelaySetter.getDeclaringClass().isInstance(view)) {
                return false;
            }
            try {
                childPressedStateDelaySetter.invoke(view, value);
                return true;
            } catch (ReflectiveOperationException unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean tryIntercept(View view, MotionEvent event) {
            return (view instanceof ViewGroup) && ((ViewGroup) view).onInterceptTouchEvent(event);
        }

        /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion$ScrollDirection;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UP", "DOWN", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public enum ScrollDirection {
            UP(-1),
            DOWN(1),
            NONE(0);

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
            private final int value;

            public static EnumEntries<ScrollDirection> getEntries() {
                return $ENTRIES;
            }

            ScrollDirection(int i) {
                this.value = i;
            }

            public final int getValue() {
                return this.value;
            }
        }
    }

    static final Method childPressedStateDelaySetter_delegate$lambda$0() {
        try {
            return Class.forName("com.facebook.react.uimanager.HasChildPressedStateDelay").getMethod("setHasChildPressedStateDelay", Boolean.class);
        } catch (ReflectiveOperationException unused) {
            return null;
        }
    }

    /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u001e\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\f\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0015H\u0016J \u0010\u0019\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "", "canBegin", "", "event", "Landroid/view/MotionEvent;", "canActivate", "view", "Landroid/view/View;", "afterGestureEnd", "", "shouldRecognizeSimultaneously", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)Ljava/lang/Boolean;", "wantsToHandleEventBeforeActivation", "handleEventBeforeActivation", "shouldCancelRootViewGestureHandlerIfNecessary", "shouldBeginWithRecordedHandlers", "recorded", "", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "sendTouchEvent", "(Landroid/view/View;Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "onHandlerUpdate", "onHandlerStateChange", "newState", "", "prevState", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface NativeViewGestureHandlerHook {
        default void afterGestureEnd(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        default boolean canBegin(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return true;
        }

        default void handleEventBeforeActivation(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        default void onHandlerStateChange(NativeViewGestureHandler handler, int newState, int prevState) {
            Intrinsics.checkNotNullParameter(handler, "handler");
        }

        default void onHandlerUpdate(NativeViewGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
        }

        default boolean shouldBeginWithRecordedHandlers(List<? extends GestureHandler> recorded, NativeViewGestureHandler handler) {
            Intrinsics.checkNotNullParameter(recorded, "recorded");
            Intrinsics.checkNotNullParameter(handler, "handler");
            return true;
        }

        default boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return false;
        }

        default Boolean shouldRecognizeSimultaneously(GestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return null;
        }

        default boolean wantsToHandleEventBeforeActivation() {
            return false;
        }

        /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static boolean canBegin(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                return NativeViewGestureHandlerHook.super.canBegin(event);
            }

            @Deprecated
            public static boolean canActivate(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                return NativeViewGestureHandlerHook.super.canActivate(view);
            }

            @Deprecated
            public static void afterGestureEnd(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                NativeViewGestureHandlerHook.super.afterGestureEnd(event);
            }

            @Deprecated
            public static Boolean shouldRecognizeSimultaneously(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, GestureHandler handler) {
                Intrinsics.checkNotNullParameter(handler, "handler");
                return NativeViewGestureHandlerHook.super.shouldRecognizeSimultaneously(handler);
            }

            @Deprecated
            public static boolean wantsToHandleEventBeforeActivation(NativeViewGestureHandlerHook nativeViewGestureHandlerHook) {
                return NativeViewGestureHandlerHook.super.wantsToHandleEventBeforeActivation();
            }

            @Deprecated
            public static void handleEventBeforeActivation(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                NativeViewGestureHandlerHook.super.handleEventBeforeActivation(event);
            }

            @Deprecated
            public static boolean shouldCancelRootViewGestureHandlerIfNecessary(NativeViewGestureHandlerHook nativeViewGestureHandlerHook) {
                return NativeViewGestureHandlerHook.super.shouldCancelRootViewGestureHandlerIfNecessary();
            }

            @Deprecated
            public static boolean shouldBeginWithRecordedHandlers(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, List<? extends GestureHandler> recorded, NativeViewGestureHandler handler) {
                Intrinsics.checkNotNullParameter(recorded, "recorded");
                Intrinsics.checkNotNullParameter(handler, "handler");
                return NativeViewGestureHandlerHook.super.shouldBeginWithRecordedHandlers(recorded, handler);
            }

            @Deprecated
            public static Boolean sendTouchEvent(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, View view, MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                return NativeViewGestureHandlerHook.super.sendTouchEvent(view, event);
            }

            @Deprecated
            public static void onHandlerUpdate(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, NativeViewGestureHandler handler) {
                Intrinsics.checkNotNullParameter(handler, "handler");
                NativeViewGestureHandlerHook.super.onHandlerUpdate(handler);
            }

            @Deprecated
            public static void onHandlerStateChange(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, NativeViewGestureHandler handler, int i, int i2) {
                Intrinsics.checkNotNullParameter(handler, "handler");
                NativeViewGestureHandlerHook.super.onHandlerStateChange(handler, i, i2);
            }
        }

        default boolean canActivate(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view.isPressed();
        }

        default Boolean sendTouchEvent(View view, MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (view != null) {
                return Boolean.valueOf(view.onTouchEvent(event));
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$TextViewHook;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "<init>", "()V", "shouldRecognizeSimultaneously", "", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)Ljava/lang/Boolean;", "canActivate", "view", "Landroid/view/View;", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class TextViewHook implements NativeViewGestureHandlerHook {
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void afterGestureEnd(MotionEvent motionEvent) {
            super.afterGestureEnd(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canBegin(MotionEvent motionEvent) {
            return super.canBegin(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void handleEventBeforeActivation(MotionEvent motionEvent) {
            super.handleEventBeforeActivation(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerStateChange(NativeViewGestureHandler nativeViewGestureHandler, int i, int i2) {
            super.onHandlerStateChange(nativeViewGestureHandler, i, i2);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerUpdate(NativeViewGestureHandler nativeViewGestureHandler) {
            super.onHandlerUpdate(nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ Boolean sendTouchEvent(View view, MotionEvent motionEvent) {
            return super.sendTouchEvent(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean shouldBeginWithRecordedHandlers(List<? extends GestureHandler> list, NativeViewGestureHandler nativeViewGestureHandler) {
            return super.shouldBeginWithRecordedHandlers(list, nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return super.shouldCancelRootViewGestureHandlerIfNecessary();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean wantsToHandleEventBeforeActivation() {
            return super.wantsToHandleEventBeforeActivation();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean shouldRecognizeSimultaneously(GestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canActivate(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view instanceof ReactTextView;
        }
    }

    /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0002\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$EditTextHook;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "handler", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "editText", "Lcom/facebook/react/views/textinput/ReactEditText;", "<init>", "(Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;Lcom/facebook/react/views/textinput/ReactEditText;)V", "startX", "", "startY", "touchSlopSquared", "", "afterGestureEnd", "", "event", "Landroid/view/MotionEvent;", "shouldRecognizeSimultaneously", "", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)Ljava/lang/Boolean;", "wantsToHandleEventBeforeActivation", "handleEventBeforeActivation", "shouldCancelRootViewGestureHandlerIfNecessary", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class EditTextHook implements NativeViewGestureHandlerHook {
        private final ReactEditText editText;
        private final NativeViewGestureHandler handler;
        private float startX;
        private float startY;
        private int touchSlopSquared;

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean wantsToHandleEventBeforeActivation() {
            return true;
        }

        public EditTextHook(NativeViewGestureHandler handler, ReactEditText editText) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(editText, "editText");
            this.handler = handler;
            this.editText = editText;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(editText.getContext());
            this.touchSlopSquared = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canActivate(View view) {
            return super.canActivate(view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canBegin(MotionEvent motionEvent) {
            return super.canBegin(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerStateChange(NativeViewGestureHandler nativeViewGestureHandler, int i, int i2) {
            super.onHandlerStateChange(nativeViewGestureHandler, i, i2);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerUpdate(NativeViewGestureHandler nativeViewGestureHandler) {
            super.onHandlerUpdate(nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ Boolean sendTouchEvent(View view, MotionEvent motionEvent) {
            return super.sendTouchEvent(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean shouldBeginWithRecordedHandlers(List<? extends GestureHandler> list, NativeViewGestureHandler nativeViewGestureHandler) {
            return super.shouldBeginWithRecordedHandlers(list, nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void afterGestureEnd(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (((event.getX() - this.startX) * (event.getX() - this.startX)) + ((event.getY() - this.startY) * (event.getY() - this.startY)) < this.touchSlopSquared) {
                this.editText.requestFocusFromJS();
            }
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean shouldRecognizeSimultaneously(GestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            if (handler instanceof NativeViewGestureHandler) {
                return null;
            }
            return Boolean.valueOf(!(handler instanceof RNGestureHandlerRootHelper.RootViewGestureHandler));
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void handleEventBeforeActivation(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.handler.activate();
            this.editText.onTouchEvent(event);
            this.startX = event.getX();
            this.startY = event.getY();
        }
    }

    /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$SwipeRefreshLayoutHook;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "handler", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "swipeRefreshLayout", "Lcom/facebook/react/views/swiperefresh/ReactSwipeRefreshLayout;", "<init>", "(Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;Lcom/facebook/react/views/swiperefresh/ReactSwipeRefreshLayout;)V", "lastY", "", "Ljava/lang/Float;", "wantsToHandleEventBeforeActivation", "", "handleEventBeforeActivation", "", "event", "Landroid/view/MotionEvent;", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class SwipeRefreshLayoutHook implements NativeViewGestureHandlerHook {
        private final NativeViewGestureHandler handler;
        private Float lastY;
        private final ReactSwipeRefreshLayout swipeRefreshLayout;

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean wantsToHandleEventBeforeActivation() {
            return true;
        }

        public SwipeRefreshLayoutHook(NativeViewGestureHandler handler, ReactSwipeRefreshLayout swipeRefreshLayout) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(swipeRefreshLayout, "swipeRefreshLayout");
            this.handler = handler;
            this.swipeRefreshLayout = swipeRefreshLayout;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void afterGestureEnd(MotionEvent motionEvent) {
            super.afterGestureEnd(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canActivate(View view) {
            return super.canActivate(view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canBegin(MotionEvent motionEvent) {
            return super.canBegin(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerStateChange(NativeViewGestureHandler nativeViewGestureHandler, int i, int i2) {
            super.onHandlerStateChange(nativeViewGestureHandler, i, i2);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerUpdate(NativeViewGestureHandler nativeViewGestureHandler) {
            super.onHandlerUpdate(nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ Boolean sendTouchEvent(View view, MotionEvent motionEvent) {
            return super.sendTouchEvent(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean shouldBeginWithRecordedHandlers(List<? extends GestureHandler> list, NativeViewGestureHandler nativeViewGestureHandler) {
            return super.shouldBeginWithRecordedHandlers(list, nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return super.shouldCancelRootViewGestureHandlerIfNecessary();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ Boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler) {
            return super.shouldRecognizeSimultaneously(gestureHandler);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x006a  */
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void handleEventBeforeActivation(MotionEvent event) {
            Companion.ScrollDirection scrollDirection;
            ArrayList<GestureHandler> handlersForView;
            Intrinsics.checkNotNullParameter(event, "event");
            View childAt = this.swipeRefreshLayout.getChildAt(0);
            GestureHandler gestureHandler = null;
            ScrollView scrollView = childAt instanceof ScrollView ? (ScrollView) childAt : null;
            if (scrollView == null) {
                return;
            }
            GestureHandlerOrchestrator orchestrator = this.handler.getOrchestrator();
            if (orchestrator != null && (handlersForView = orchestrator.getHandlersForView(scrollView)) != null) {
                Iterator<T> it = handlersForView.iterator();
                do {
                    if (!it.hasNext()) {
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    gestureHandler = (GestureHandler) it.next();
                } while (!(gestureHandler instanceof NativeViewGestureHandler));
            }
            Float f = this.lastY;
            if (f != null) {
                float fFloatValue = f.floatValue() - event.getY();
                if (fFloatValue < 0.0f) {
                    scrollDirection = Companion.ScrollDirection.UP;
                } else if (fFloatValue > 0.0f) {
                    scrollDirection = Companion.ScrollDirection.DOWN;
                } else {
                    scrollDirection = Companion.ScrollDirection.NONE;
                }
                if (scrollDirection == null) {
                    scrollDirection = Companion.ScrollDirection.NONE;
                }
            } else {
                scrollDirection = Companion.ScrollDirection.NONE;
            }
            if (gestureHandler != null && gestureHandler.getState() == 4 && (scrollDirection == Companion.ScrollDirection.DOWN || scrollView.canScrollVertically(Companion.ScrollDirection.UP.getValue()))) {
                this.handler.fail();
            }
            this.lastY = Float.valueOf(event.getY());
        }
    }

    /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$ScrollViewHook;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "<init>", "()V", "shouldCancelRootViewGestureHandlerIfNecessary", "", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class ScrollViewHook implements NativeViewGestureHandlerHook {
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void afterGestureEnd(MotionEvent motionEvent) {
            super.afterGestureEnd(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canActivate(View view) {
            return super.canActivate(view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canBegin(MotionEvent motionEvent) {
            return super.canBegin(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void handleEventBeforeActivation(MotionEvent motionEvent) {
            super.handleEventBeforeActivation(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerStateChange(NativeViewGestureHandler nativeViewGestureHandler, int i, int i2) {
            super.onHandlerStateChange(nativeViewGestureHandler, i, i2);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerUpdate(NativeViewGestureHandler nativeViewGestureHandler) {
            super.onHandlerUpdate(nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ Boolean sendTouchEvent(View view, MotionEvent motionEvent) {
            return super.sendTouchEvent(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean shouldBeginWithRecordedHandlers(List<? extends GestureHandler> list, NativeViewGestureHandler nativeViewGestureHandler) {
            return super.shouldBeginWithRecordedHandlers(list, nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ Boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler) {
            return super.shouldRecognizeSimultaneously(gestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean wantsToHandleEventBeforeActivation() {
            return super.wantsToHandleEventBeforeActivation();
        }
    }

    /* JADX INFO: compiled from: NativeViewGestureHandler.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$ReactViewGroupHook;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "<init>", "()V", "sendTouchEvent", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "(Landroid/view/View;Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class ReactViewGroupHook implements NativeViewGestureHandlerHook {
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void afterGestureEnd(MotionEvent motionEvent) {
            super.afterGestureEnd(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canActivate(View view) {
            return super.canActivate(view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canBegin(MotionEvent motionEvent) {
            return super.canBegin(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void handleEventBeforeActivation(MotionEvent motionEvent) {
            super.handleEventBeforeActivation(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerStateChange(NativeViewGestureHandler nativeViewGestureHandler, int i, int i2) {
            super.onHandlerStateChange(nativeViewGestureHandler, i, i2);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void onHandlerUpdate(NativeViewGestureHandler nativeViewGestureHandler) {
            super.onHandlerUpdate(nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean shouldBeginWithRecordedHandlers(List<? extends GestureHandler> list, NativeViewGestureHandler nativeViewGestureHandler) {
            return super.shouldBeginWithRecordedHandlers(list, nativeViewGestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return super.shouldCancelRootViewGestureHandlerIfNecessary();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ Boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler) {
            return super.shouldRecognizeSimultaneously(gestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean wantsToHandleEventBeforeActivation() {
            return super.wantsToHandleEventBeforeActivation();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean sendTouchEvent(View view, MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (view != null) {
                return Boolean.valueOf(view.dispatchTouchEvent(event));
            }
            return null;
        }
    }
}
