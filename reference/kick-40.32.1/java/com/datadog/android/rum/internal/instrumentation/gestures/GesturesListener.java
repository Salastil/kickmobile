package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.heatmaps.HeatmapViewKeyKt;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.heatmaps.NativeHeatmapActionData;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.internal.tracking.NoOpInteractionPredicate;
import com.datadog.android.rum.tracking.ActionTrackingStrategy;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.NoOpActionTrackingStrategy;
import com.datadog.android.rum.tracking.Node;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import com.datadog.android.rum.tracking.ViewTarget;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GesturesListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0000\u0018\u0000 S2\u00020\u0001:\u0001SB_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0002\u0010\u0014J&\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010)0(H\u0002J\u001a\u0010*\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010&2\u0006\u0010,\u001a\u00020-H\u0002J\"\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010&2\u0006\u0010,\u001a\u00020-H\u0002J\u001a\u00100\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010&2\u0006\u0010,\u001a\u00020-H\u0002J,\u00101\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020&2\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u00192\b\b\u0002\u00104\u001a\u000205H\u0002J\"\u00106\u001a\u0004\u0018\u00010\u001e2\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0019H\u0002J\"\u00107\u001a\u0004\u0018\u00010\u001e2\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0019H\u0002J\u001a\u00108\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010&2\u0006\u00109\u001a\u00020-H\u0002J\u0010\u0010:\u001a\u0002052\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010;\u001a\u0002052\u0006\u00109\u001a\u00020-H\u0016J*\u0010<\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010-2\u0006\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019H\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u00109\u001a\u00020-H\u0016J*\u0010B\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010-2\u0006\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u0019H\u0016J\u0010\u0010F\u001a\u00020$2\u0006\u00109\u001a\u00020-H\u0016J\u0010\u0010G\u001a\u0002052\u0006\u00109\u001a\u00020-H\u0016J\u000e\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020-J\b\u0010J\u001a\u00020$H\u0002J(\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010)0(2\u0006\u0010L\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0010\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020-H\u0002J \u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020\u00192\u0006\u0010R\u001a\u00020\u0019H\u0002R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesListener;", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GestureListenerCompat;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "windowReference", "Ljava/lang/ref/WeakReference;", "Landroid/view/Window;", "attributesProviders", "", "Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "contextRef", "Ljava/lang/ref/Reference;", "Landroid/content/Context;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "composeActionTrackingStrategy", "Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;", "androidActionTrackingStrategy", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Ljava/lang/ref/WeakReference;[Lcom/datadog/android/rum/tracking/ViewAttributesProvider;Lcom/datadog/android/rum/tracking/InteractionPredicate;Ljava/lang/ref/Reference;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;)V", "[Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "gestureDirection", "", "onTouchDownXPos", "", "onTouchDownYPos", "scrollEventType", "Lcom/datadog/android/rum/RumActionType;", "scrollTargetReference", "Lcom/datadog/android/rum/tracking/ViewTarget;", "tapLocationBuffer", "", "tapTargetSelector", "Lcom/datadog/android/rum/internal/instrumentation/gestures/TapTargetSelector;", "addViewAttributes", "", "view", "Landroid/view/View;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "closeScrollAsTap", "decorView", "onUpEvent", "Landroid/view/MotionEvent;", "closeScrollOrSwipeEvent", "type", "closeScrollOrSwipeEventIfAny", "findTarget", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "isScroll", "", "findTargetForScroll", "findTargetForTap", "handleTapUp", "e", "isJetpackComposeView", "onDown", "onFling", "startDownEvent", "endUpEvent", "velocityX", "velocityY", "onLongPress", "onScroll", "currentMoveEvent", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onUp", "event", "resetScrollEventParameters", "resolveAttributes", "scrollTarget", "resolveGestureDirection", "endEvent", "sendTapEventWithTarget", TypedValues.Attributes.S_TARGET, "touchX", "touchY", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GesturesListener extends GestureListenerCompat {
    public static final String MSG_NO_COMPOSE_TARGET = "We could not find a valid target for the gesture event. Compose actions tracking not enabled, or the compose view is not tagged.";
    public static final String MSG_NO_TARGET_ACTION = "We could not find a valid target for the gesture event. The DecorView was empty and either transparent or not clickable for this Activity.";
    public static final String SCROLL_DIRECTION_DOWN = "down";
    public static final String SCROLL_DIRECTION_LEFT = "left";
    public static final String SCROLL_DIRECTION_RIGHT = "right";
    public static final String SCROLL_DIRECTION_UP = "up";
    private final ActionTrackingStrategy androidActionTrackingStrategy;
    private final ViewAttributesProvider[] attributesProviders;
    private final ActionTrackingStrategy composeActionTrackingStrategy;
    private final Reference<Context> contextRef;
    private String gestureDirection;
    private final InteractionPredicate interactionPredicate;
    private final InternalLogger internalLogger;
    private float onTouchDownXPos;
    private float onTouchDownYPos;
    private RumActionType scrollEventType;
    private ViewTarget scrollTargetReference;
    private final FeatureSdkCore sdkCore;
    private final int[] tapLocationBuffer;
    private final TapTargetSelector tapTargetSelector;
    private final WeakReference<Window> windowReference;

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }

    public /* synthetic */ GesturesListener(FeatureSdkCore featureSdkCore, WeakReference weakReference, ViewAttributesProvider[] viewAttributesProviderArr, NoOpInteractionPredicate noOpInteractionPredicate, Reference reference, InternalLogger internalLogger, ActionTrackingStrategy actionTrackingStrategy, ActionTrackingStrategy actionTrackingStrategy2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, weakReference, (i & 4) != 0 ? new ViewAttributesProvider[0] : viewAttributesProviderArr, (i & 8) != 0 ? new NoOpInteractionPredicate() : noOpInteractionPredicate, reference, internalLogger, (i & 64) != 0 ? new NoOpActionTrackingStrategy() : actionTrackingStrategy, (i & 128) != 0 ? new AndroidActionTrackingStrategy() : actionTrackingStrategy2);
    }

    public GesturesListener(FeatureSdkCore sdkCore, WeakReference<Window> windowReference, ViewAttributesProvider[] attributesProviders, InteractionPredicate interactionPredicate, Reference<Context> contextRef, InternalLogger internalLogger, ActionTrackingStrategy composeActionTrackingStrategy, ActionTrackingStrategy androidActionTrackingStrategy) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(windowReference, "windowReference");
        Intrinsics.checkNotNullParameter(attributesProviders, "attributesProviders");
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(contextRef, "contextRef");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(composeActionTrackingStrategy, "composeActionTrackingStrategy");
        Intrinsics.checkNotNullParameter(androidActionTrackingStrategy, "androidActionTrackingStrategy");
        this.sdkCore = sdkCore;
        this.windowReference = windowReference;
        this.attributesProviders = attributesProviders;
        this.interactionPredicate = interactionPredicate;
        this.contextRef = contextRef;
        this.internalLogger = internalLogger;
        this.composeActionTrackingStrategy = composeActionTrackingStrategy;
        this.androidActionTrackingStrategy = androidActionTrackingStrategy;
        this.gestureDirection = "";
        this.tapLocationBuffer = new int[2];
        this.tapTargetSelector = new TapTargetSelector();
        Context context = contextRef.get();
        if (context != null) {
            composeActionTrackingStrategy.register(sdkCore, context);
            androidActionTrackingStrategy.register(sdkCore, context);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        Window window = this.windowReference.get();
        handleTapUp(window != null ? window.getDecorView() : null, e);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        resetScrollEventParameters();
        this.onTouchDownXPos = e.getX();
        this.onTouchDownYPos = e.getY();
        return false;
    }

    public final void onUp(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Window window = this.windowReference.get();
        closeScrollOrSwipeEventIfAny(window != null ? window.getDecorView() : null, event);
        resetScrollEventParameters();
    }

    @Override // com.datadog.android.rum.internal.instrumentation.gestures.GestureListenerCompat, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent startDownEvent, MotionEvent endUpEvent, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(endUpEvent, "endUpEvent");
        this.scrollEventType = RumActionType.SWIPE;
        return false;
    }

    @Override // com.datadog.android.rum.internal.instrumentation.gestures.GestureListenerCompat, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent startDownEvent, MotionEvent currentMoveEvent, float distanceX, float distanceY) {
        View decorView;
        Intrinsics.checkNotNullParameter(currentMoveEvent, "currentMoveEvent");
        RumMonitor rumMonitor = GlobalRumMonitor.get(this.sdkCore);
        Window window = this.windowReference.get();
        if (window != null && (decorView = window.getDecorView()) != null && this.scrollEventType == null) {
            ViewTarget viewTargetFindTarget = startDownEvent != null ? findTarget(decorView, startDownEvent.getX(), startDownEvent.getY(), true) : null;
            if (viewTargetFindTarget != null) {
                this.scrollTargetReference = viewTargetFindTarget;
                rumMonitor.startAction(RumActionType.SCROLL, GesturesUtilsKt.resolveViewTargetName(this.interactionPredicate, viewTargetFindTarget), resolveAttributes(viewTargetFindTarget, null));
                this.scrollEventType = RumActionType.SCROLL;
                Unit unit = Unit.INSTANCE;
            }
        }
        return false;
    }

    static /* synthetic */ ViewTarget findTarget$default(GesturesListener gesturesListener, View view, float f, float f2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return gesturesListener.findTarget(view, f, f2, z);
    }

    private final ViewTarget findTarget(View decorView, float x, float y, boolean isScroll) {
        final String str;
        ViewTarget viewTargetFindTargetForTap;
        LinkedList linkedList = new LinkedList();
        linkedList.add(0, decorView);
        ViewTarget viewTarget = null;
        ViewTarget viewTarget2 = null;
        View view = null;
        boolean z = false;
        while (!linkedList.isEmpty()) {
            Object objRemove = linkedList.remove(0);
            Intrinsics.checkNotNullExpressionValue(objRemove, "queue.removeAt(0)");
            View view2 = (View) objRemove;
            z = z || isJetpackComposeView(view2);
            if (isScroll) {
                viewTargetFindTargetForTap = findTargetForScroll(view2, x, y);
            } else {
                viewTargetFindTargetForTap = findTargetForTap(view2, x, y);
            }
            if (viewTargetFindTargetForTap != null) {
                if (isScroll) {
                    viewTarget = viewTargetFindTargetForTap;
                } else if (this.tapTargetSelector.shouldSelectCandidate(view, view2)) {
                    view = view2;
                    viewTarget2 = viewTargetFindTargetForTap;
                }
            }
            if (view2.getVisibility() == 0 && (view2 instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    linkedList.add(viewGroup.getChildAt(i));
                }
            }
        }
        if (viewTarget == null) {
            viewTarget = viewTarget2;
        }
        if (viewTarget == null) {
            if (z) {
                str = MSG_NO_COMPOSE_TARGET;
            } else {
                str = MSG_NO_TARGET_ACTION;
            }
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.GesturesListener.findTarget.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return viewTarget;
    }

    private final ViewTarget findTargetForScroll(View view, float x, float y) {
        ViewTarget viewTargetFindTargetForScroll = this.androidActionTrackingStrategy.findTargetForScroll(view, x, y);
        if (viewTargetFindTargetForScroll == null) {
            viewTargetFindTargetForScroll = null;
        }
        ViewTarget viewTargetFindTargetForScroll2 = this.composeActionTrackingStrategy.findTargetForScroll(view, x, y);
        return viewTargetFindTargetForScroll2 != null ? viewTargetFindTargetForScroll2 : viewTargetFindTargetForScroll;
    }

    private final ViewTarget findTargetForTap(View view, float x, float y) {
        ViewTarget viewTargetFindTargetForTap = this.androidActionTrackingStrategy.findTargetForTap(view, x, y);
        if (viewTargetFindTargetForTap == null) {
            viewTargetFindTargetForTap = null;
        }
        ViewTarget viewTargetFindTargetForTap2 = this.composeActionTrackingStrategy.findTargetForTap(view, x, y);
        return viewTargetFindTargetForTap2 != null ? viewTargetFindTargetForTap2 : viewTargetFindTargetForTap;
    }

    private final void closeScrollOrSwipeEventIfAny(View decorView, MotionEvent onUpEvent) {
        RumActionType rumActionType = this.scrollEventType;
        if (rumActionType == null) {
            closeScrollAsTap(decorView, onUpEvent);
        } else {
            closeScrollOrSwipeEvent(rumActionType, decorView, onUpEvent);
        }
    }

    private final void closeScrollAsTap(View decorView, MotionEvent onUpEvent) {
        if (decorView != null) {
            ViewTarget viewTargetFindTarget$default = findTarget$default(this, decorView, this.onTouchDownXPos, this.onTouchDownYPos, false, 8, null);
            ViewTarget viewTargetFindTarget$default2 = findTarget$default(this, decorView, onUpEvent.getX(), onUpEvent.getY(), false, 8, null);
            if (viewTargetFindTarget$default != null) {
                if (!Intrinsics.areEqual(viewTargetFindTarget$default, viewTargetFindTarget$default2)) {
                    viewTargetFindTarget$default = null;
                }
                if (viewTargetFindTarget$default != null) {
                    sendTapEventWithTarget(viewTargetFindTarget$default, onUpEvent.getX(), onUpEvent.getY());
                }
            }
        }
    }

    private final void closeScrollOrSwipeEvent(RumActionType type, View decorView, MotionEvent onUpEvent) {
        RumMonitor rumMonitor = GlobalRumMonitor.get(this.sdkCore);
        ViewTarget viewTarget = this.scrollTargetReference;
        if (decorView == null || viewTarget == null) {
            return;
        }
        rumMonitor.stopAction(type, GesturesUtilsKt.resolveViewTargetName(this.interactionPredicate, viewTarget), resolveAttributes(viewTarget, onUpEvent));
    }

    private final void resetScrollEventParameters() {
        this.scrollTargetReference = null;
        this.scrollEventType = null;
        this.gestureDirection = "";
        this.onTouchDownYPos = 0.0f;
        this.onTouchDownXPos = 0.0f;
    }

    private final void handleTapUp(View decorView, MotionEvent e) {
        ViewTarget viewTargetFindTarget$default;
        if (decorView == null || (viewTargetFindTarget$default = findTarget$default(this, decorView, e.getX(), e.getY(), false, 8, null)) == null) {
            return;
        }
        sendTapEventWithTarget(viewTargetFindTarget$default, e.getX(), e.getY());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x006c  */
    private final void sendTapEventWithTarget(ViewTarget target, float touchX, float touchY) {
        NativeHeatmapActionData nativeHeatmapActionData;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        View view = target.getViewRef().get();
        Unit unit = null;
        if (view != null) {
            addViewAttributes(view, linkedHashMap);
            if (view.isAttachedToWindow()) {
                view.getLocationInWindow(this.tapLocationBuffer);
                float f = view.getResources().getDisplayMetrics().density;
                nativeHeatmapActionData = new NativeHeatmapActionData(HeatmapViewKeyKt.heatmapViewKey(view), MathKt.roundToLong((touchX - this.tapLocationBuffer[0]) / f), MathKt.roundToLong((touchY - this.tapLocationBuffer[1]) / f), Long.valueOf(MathKt.roundToLong(view.getWidth() / f)), Long.valueOf(MathKt.roundToLong(view.getHeight() / f)));
            } else {
                nativeHeatmapActionData = null;
            }
        } else {
            nativeHeatmapActionData = null;
        }
        Node node = target.getNode();
        if (node != null) {
            linkedHashMap.putAll(node.getCustomAttributes());
        }
        RumMonitor rumMonitor = GlobalRumMonitor.get(this.sdkCore);
        String strResolveViewTargetName = GesturesUtilsKt.resolveViewTargetName(this.interactionPredicate, target);
        AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        if (advancedRumMonitor != null) {
            advancedRumMonitor.addActionWithHeatmap(RumActionType.TAP, strResolveViewTargetName, nativeHeatmapActionData, linkedHashMap);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            rumMonitor.addAction(RumActionType.TAP, strResolveViewTargetName, linkedHashMap);
        }
    }

    private final Map<String, Object> resolveAttributes(ViewTarget scrollTarget, MotionEvent onUpEvent) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        View view = scrollTarget.getViewRef().get();
        if (view != null) {
            addViewAttributes(view, linkedHashMap);
        }
        Node node = scrollTarget.getNode();
        if (node != null) {
            linkedHashMap.putAll(node.getCustomAttributes());
        }
        if (onUpEvent != null) {
            String strResolveGestureDirection = resolveGestureDirection(onUpEvent);
            this.gestureDirection = strResolveGestureDirection;
            linkedHashMap.put(RumAttributes.ACTION_GESTURE_DIRECTION, strResolveGestureDirection);
        }
        return linkedHashMap;
    }

    private final void addViewAttributes(View view, Map<String, Object> attributes) {
        String strResourceIdName = GesturesUtilsKt.resourceIdName(this.contextRef.get(), view.getId());
        attributes.put(RumAttributes.ACTION_TARGET_CLASS_NAME, GesturesUtilsKt.targetClassName(view));
        attributes.put(RumAttributes.ACTION_TARGET_RESOURCE_ID, strResourceIdName);
        for (ViewAttributesProvider viewAttributesProvider : this.attributesProviders) {
            viewAttributesProvider.extractAttributes(view, attributes);
        }
    }

    private final String resolveGestureDirection(MotionEvent endEvent) {
        float x = endEvent.getX() - this.onTouchDownXPos;
        float y = endEvent.getY() - this.onTouchDownYPos;
        if (Math.abs(x) > Math.abs(y)) {
            if (x > 0.0f) {
                return "right";
            }
            return "left";
        }
        if (y > 0.0f) {
            return SCROLL_DIRECTION_DOWN;
        }
        return SCROLL_DIRECTION_UP;
    }

    private final boolean isJetpackComposeView(View view) {
        String name = view.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "view::class.java.name");
        return StringsKt.startsWith$default(name, "androidx.compose.ui.platform.ComposeView", false, 2, (Object) null);
    }
}
