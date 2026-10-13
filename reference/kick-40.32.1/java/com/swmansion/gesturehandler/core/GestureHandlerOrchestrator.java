package com.swmansion.gesturehandler.core;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.RootView;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import com.swmansion.gesturehandler.react.ExtensionsKt;
import com.swmansion.gesturehandler.react.RNGestureHandlerDetectorView;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GestureHandlerOrchestrator.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 b2\u00020\u0001:\u0001bB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u000e\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/J\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u00101\u001a\u00020\u001fJ\b\u00102\u001a\u00020\u001cH\u0002J\b\u00103\u001a\u00020\u001cH\u0002J\u0010\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u0015H\u0002J\u0010\u00106\u001a\u00020'2\u0006\u00105\u001a\u00020\u0015H\u0002J\u0010\u00107\u001a\u00020'2\u0006\u00105\u001a\u00020\u0015H\u0002J\u0010\u00108\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u0015H\u0002J\b\u00109\u001a\u00020\u001cH\u0002J\u001e\u0010:\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u00152\u0006\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%J\u0010\u0010=\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u0015H\u0002J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J\b\u0010?\u001a\u00020\u001cH\u0002J\u0018\u0010@\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u00152\u0006\u0010A\u001a\u00020/H\u0002J\u0006\u0010B\u001a\u00020\u001cJ\u0012\u0010C\u001a\u00020'2\b\u00101\u001a\u0004\u0018\u00010\u001fH\u0002J\u0006\u0010D\u001a\u00020'J\u0018\u0010E\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010\u001f2\u0006\u0010.\u001a\u00020/J\u0018\u0010F\u001a\u00020\"2\b\u00101\u001a\u0004\u0018\u00010\u001f2\u0006\u0010G\u001a\u00020\"J\u0010\u0010H\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u0015H\u0002J\u0018\u0010I\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u00152\b\u00101\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010J\u001a\u00020'2\u0006\u00101\u001a\u00020\u001fH\u0002J(\u0010K\u001a\u00020'2\u0006\u00101\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020%2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u0010O\u001a\u00020'2\u0006\u00105\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0002J2\u0010P\u001a\u00020'2\u0006\u00101\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020%2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010Q\u001a\u00020'H\u0002J\u0010\u0010R\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010S\u001a\u00020'2\u0006\u00101\u001a\u00020\u001fH\u0002J(\u0010R\u001a\u00020'2\u0006\u0010T\u001a\u00020\u00032\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020%2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J\u000e\u0010V\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/J\u001e\u0010W\u001a\u00020'2\u0006\u00101\u001a\u00020\u001f2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00150YH\u0002J\u001e\u0010Z\u001a\u00020'2\u0006\u00105\u001a\u00020\u00152\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00150YH\u0002J&\u0010[\u001a\u00020'2\u0006\u00101\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020M2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001f0]H\u0002J(\u0010^\u001a\u00020'2\u0006\u00101\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020%2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010_\u001a\u00020'2\u0006\u00101\u001a\u00020\u001fH\u0002J\u0010\u0010`\u001a\u00020'2\u0006\u00101\u001a\u00020\u001fH\u0002J\u000e\u0010a\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u0014j\b\u0012\u0004\u0012\u00020\u001f`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020'@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;", "", "wrapperView", "Landroid/view/ViewGroup;", "handlerRegistry", "Lcom/swmansion/gesturehandler/core/GestureHandlerRegistry;", "viewConfigHelper", "Lcom/swmansion/gesturehandler/core/ViewConfigurationHelper;", "rootView", "onJSResponderCancelListener", "Lcom/swmansion/gesturehandler/core/OnJSResponderCancelListener;", "<init>", "(Landroid/view/ViewGroup;Lcom/swmansion/gesturehandler/core/GestureHandlerRegistry;Lcom/swmansion/gesturehandler/core/ViewConfigurationHelper;Landroid/view/ViewGroup;Lcom/swmansion/gesturehandler/core/OnJSResponderCancelListener;)V", "minimumAlphaForTraversal", "", "getMinimumAlphaForTraversal", "()F", "setMinimumAlphaForTraversal", "(F)V", "gestureHandlers", "Ljava/util/ArrayList;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "Lkotlin/collections/ArrayList;", "awaitingHandlers", "handlerListPool", "Ljava/util/ArrayDeque;", "obtainHandlerList", "recycleHandlerList", "", "list", "viewsToCancel", "Landroid/view/View;", "pointerDownPoints", "Landroid/util/SparseArray;", "Landroid/graphics/PointF;", "awaitingHandlersTags", "Ljava/util/HashSet;", "", "value", "", "isHandlingTouch", "()Z", "handlingChangeSemaphore", "finishedHandlersCleanupScheduled", "activationIndex", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "getHandlersForView", "view", "scheduleFinishedHandlersCleanup", "cleanupFinishedHandlers", "hasOtherHandlerToWaitFor", "handler", "shouldBeCancelledByFinishedHandler", "shouldBeCancelledByActiveHandler", "tryActivate", "cleanupAwaitingHandlers", "onHandlerStateChange", "newState", "prevState", "makeActive", "deliverEventToGestureHandlers", "cancelAll", "deliverEventToGestureHandler", "sourceEvent", "cancelAllLegacyHandlers", "isViewAttachedUnderWrapper", "isAnyHandlerActive", "transformEventToViewCoords", "transformPointToViewCoords", "point", "addAwaitingHandler", "recordHandlerIfNotPresent", "isViewOverflowingParent", "extractAncestorHandlers", "coords", "", "pointerId", "shouldHandlerSkipHoverEvents", "recordViewHandlersForPointer", "useChildBounds", "extractGestureHandlers", "shouldIgnoreSubtreeIfGestureHandlerRootView", "viewGroup", "trackPointerDownPoints", "cancelTouchesInInterceptedViews", "isViewDrivenByActiveNativeGesture", "activeHandlers", "", "nativeGestureSurvivesArbitration", "collectViewsAtPoint", "out", "", "traverseWithPointerEvents", "canReceiveEvents", "isClipping", "activateNativeHandlersForView", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GestureHandlerOrchestrator {
    private static final float DEFAULT_MIN_ALPHA_FOR_TRAVERSAL = 0.0f;
    private int activationIndex;
    private final ArrayList<GestureHandler> awaitingHandlers;
    private final HashSet<Integer> awaitingHandlersTags;
    private boolean finishedHandlersCleanupScheduled;
    private final ArrayList<GestureHandler> gestureHandlers;
    private final ArrayDeque<ArrayList<GestureHandler>> handlerListPool;
    private final GestureHandlerRegistry handlerRegistry;
    private int handlingChangeSemaphore;
    private boolean isHandlingTouch;
    private float minimumAlphaForTraversal;
    private final OnJSResponderCancelListener onJSResponderCancelListener;
    private final SparseArray<PointF> pointerDownPoints;
    private final ViewGroup rootView;
    private final ViewConfigurationHelper viewConfigHelper;
    private final ArrayList<View> viewsToCancel;
    private final ViewGroup wrapperView;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PointF tempPoint = new PointF();
    private static final float[] matrixTransformCoords = new float[2];
    private static final Matrix inverseMatrix = new Matrix();
    private static final float[] tempCoords = new float[2];
    private static final Comparator<GestureHandler> handlersComparator = new Comparator() { // from class: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return GestureHandlerOrchestrator.handlersComparator$lambda$0((GestureHandler) obj, (GestureHandler) obj2);
        }
    };

    /* JADX INFO: compiled from: GestureHandlerOrchestrator.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventsConfig.values().length];
            try {
                iArr[PointerEventsConfig.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEventsConfig.BOX_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEventsConfig.BOX_NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PointerEventsConfig.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GestureHandlerOrchestrator(ViewGroup wrapperView, GestureHandlerRegistry handlerRegistry, ViewConfigurationHelper viewConfigHelper, ViewGroup rootView, OnJSResponderCancelListener onJSResponderCancelListener) {
        Intrinsics.checkNotNullParameter(wrapperView, "wrapperView");
        Intrinsics.checkNotNullParameter(handlerRegistry, "handlerRegistry");
        Intrinsics.checkNotNullParameter(viewConfigHelper, "viewConfigHelper");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(onJSResponderCancelListener, "onJSResponderCancelListener");
        this.wrapperView = wrapperView;
        this.handlerRegistry = handlerRegistry;
        this.viewConfigHelper = viewConfigHelper;
        this.rootView = rootView;
        this.onJSResponderCancelListener = onJSResponderCancelListener;
        this.gestureHandlers = new ArrayList<>();
        this.awaitingHandlers = new ArrayList<>();
        this.handlerListPool = new ArrayDeque<>();
        this.viewsToCancel = new ArrayList<>();
        this.pointerDownPoints = new SparseArray<>();
        this.awaitingHandlersTags = new HashSet<>();
    }

    public final float getMinimumAlphaForTraversal() {
        return this.minimumAlphaForTraversal;
    }

    public final void setMinimumAlphaForTraversal(float f) {
        this.minimumAlphaForTraversal = f;
    }

    private final ArrayList<GestureHandler> obtainHandlerList() {
        ArrayList<GestureHandler> arrayListPollLast = this.handlerListPool.pollLast();
        return arrayListPollLast == null ? new ArrayList<>() : arrayListPollLast;
    }

    private final void recycleHandlerList(ArrayList<GestureHandler> list) {
        list.clear();
        this.handlerListPool.addLast(list);
    }

    /* JADX INFO: renamed from: isHandlingTouch, reason: from getter */
    public final boolean getIsHandlingTouch() {
        return this.isHandlingTouch;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001f  */
    public final boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.isHandlingTouch = true;
        int actionMasked = event.getActionMasked();
        trackPointerDownPoints(event);
        if (actionMasked == 0) {
            extractGestureHandlers(event);
        } else if (actionMasked == 3) {
            cancelAll();
        } else if (actionMasked == 5 || actionMasked == 7) {
            extractGestureHandlers(event);
        }
        deliverEventToGestureHandlers(event);
        this.isHandlingTouch = false;
        if (this.finishedHandlersCleanupScheduled && this.handlingChangeSemaphore == 0) {
            cleanupFinishedHandlers();
        }
        if ((actionMasked == 1 || actionMasked == 3 || actionMasked == 10) && this.gestureHandlers.isEmpty()) {
            KeyEvent.Callback callback = this.rootView;
            if (callback instanceof RootView) {
                ((RootView) callback).onChildEndedNativeGesture((View) callback, event);
            }
        }
        return true;
    }

    public final ArrayList<GestureHandler> getHandlersForView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.handlerRegistry.getHandlersForView(view);
    }

    private final void scheduleFinishedHandlersCleanup() {
        if (this.isHandlingTouch || this.handlingChangeSemaphore != 0) {
            this.finishedHandlersCleanupScheduled = true;
        } else {
            cleanupFinishedHandlers();
        }
    }

    private final void cleanupFinishedHandlers() {
        for (GestureHandler gestureHandler : CollectionsKt.asReversedMutable(this.gestureHandlers)) {
            if (INSTANCE.isFinished(gestureHandler.getState()) && !gestureHandler.getIsAwaiting()) {
                gestureHandler.reset();
                gestureHandler.setActive(false);
                gestureHandler.setAwaiting(false);
                gestureHandler.setActivationIndex(Integer.MAX_VALUE);
            }
        }
        CollectionsKt.removeAll((List) this.gestureHandlers, new Function1() { // from class: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GestureHandlerOrchestrator.cleanupFinishedHandlers$lambda$1((GestureHandler) obj));
            }
        });
        this.finishedHandlersCleanupScheduled = false;
    }

    static final boolean cleanupFinishedHandlers$lambda$1(GestureHandler it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.isFinished(it.getState()) && !it.getIsAwaiting();
    }

    private final boolean hasOtherHandlerToWaitFor(GestureHandler handler) {
        ArrayList<GestureHandler> arrayList = this.gestureHandlers;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        for (GestureHandler gestureHandler : arrayList) {
            Companion companion = INSTANCE;
            if (!companion.isFinished(gestureHandler.getState()) && companion.shouldHandlerWaitForOther(handler, gestureHandler)) {
                return true;
            }
        }
        return false;
    }

    private final boolean shouldBeCancelledByFinishedHandler(GestureHandler handler) {
        ArrayList<GestureHandler> arrayList = this.gestureHandlers;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        for (GestureHandler gestureHandler : arrayList) {
            if (INSTANCE.shouldHandlerWaitForOther(handler, gestureHandler) && gestureHandler.getState() == 5) {
                return true;
            }
        }
        return false;
    }

    private final boolean shouldBeCancelledByActiveHandler(GestureHandler handler) {
        ArrayList<GestureHandler> arrayList = this.gestureHandlers;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        for (GestureHandler gestureHandler : arrayList) {
            if (handler.hasCommonPointers(gestureHandler) && gestureHandler.getState() == 4 && !INSTANCE.canRunSimultaneously(handler, gestureHandler) && handler.isDescendantOf(gestureHandler)) {
                return true;
            }
        }
        return false;
    }

    private final void tryActivate(GestureHandler handler) {
        if (shouldBeCancelledByFinishedHandler(handler) || shouldBeCancelledByActiveHandler(handler)) {
            handler.cancel();
        } else if (hasOtherHandlerToWaitFor(handler)) {
            addAwaitingHandler(handler);
        } else {
            makeActive(handler);
            handler.setAwaiting(false);
        }
    }

    private final void cleanupAwaitingHandlers() {
        for (GestureHandler gestureHandler : CollectionsKt.toList(this.awaitingHandlers)) {
            if (!gestureHandler.getIsAwaiting()) {
                this.awaitingHandlers.remove(gestureHandler);
                this.awaitingHandlersTags.remove(Integer.valueOf(gestureHandler.getTag()));
            }
        }
    }

    public final void onHandlerStateChange(GestureHandler handler, int newState, int prevState) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handlingChangeSemaphore++;
        if (handler.getIsAwaiting() && (newState == 3 || newState == 1)) {
            handler.setAwaiting(false);
        }
        if (INSTANCE.isFinished(newState)) {
            for (GestureHandler gestureHandler : CollectionsKt.toList(this.awaitingHandlers)) {
                if (INSTANCE.shouldHandlerWaitForOther(gestureHandler, handler) && this.awaitingHandlersTags.contains(Integer.valueOf(gestureHandler.getTag()))) {
                    if (newState == 5) {
                        gestureHandler.cancel();
                        if (gestureHandler.getState() == 5) {
                            gestureHandler.dispatchStateChange(3, 2);
                        }
                        gestureHandler.setAwaiting(false);
                    } else {
                        tryActivate(gestureHandler);
                    }
                }
            }
            cleanupAwaitingHandlers();
        }
        if (newState == 4) {
            tryActivate(handler);
        } else if (prevState == 4 || prevState == 5) {
            if (handler.getIsActive()) {
                handler.dispatchStateChange(newState, prevState);
            } else if (newState == 3 || newState == 1) {
                handler.dispatchStateChange(newState, 2);
            }
        } else if (prevState != 0 || newState != 3) {
            handler.dispatchStateChange(newState, prevState);
        }
        this.handlingChangeSemaphore--;
        scheduleFinishedHandlersCleanup();
    }

    private final void makeActive(GestureHandler handler) {
        OnJSResponderCancelListener onJSResponderCancelListener;
        int state = handler.getState();
        handler.setAwaiting(false);
        handler.setActive(true);
        handler.setShouldResetProgress(true);
        int i = this.activationIndex;
        this.activationIndex = i + 1;
        handler.setActivationIndex(i);
        for (GestureHandler gestureHandler : CollectionsKt.asReversedMutable(this.gestureHandlers)) {
            if (INSTANCE.shouldHandlerBeCancelledBy(gestureHandler, handler)) {
                gestureHandler.cancel();
            }
        }
        for (GestureHandler gestureHandler2 : CollectionsKt.asReversedMutable(this.awaitingHandlers)) {
            if (INSTANCE.shouldHandlerBeCancelledBy(gestureHandler2, handler)) {
                gestureHandler2.setAwaiting(false);
            }
        }
        cleanupAwaitingHandlers();
        if (state == 1 || state == 3) {
            return;
        }
        if (handler.getCancelsJSResponder() && (onJSResponderCancelListener = this.onJSResponderCancelListener) != null) {
            onJSResponderCancelListener.onCancelJSResponderRequested(handler);
        }
        handler.dispatchStateChange(4, 2);
        if (state != 4) {
            handler.dispatchStateChange(5, 4);
            if (state != 5) {
                handler.dispatchStateChange(0, 5);
            }
        }
    }

    private final void deliverEventToGestureHandlers(MotionEvent event) {
        ArrayList<GestureHandler> arrayListObtainHandlerList = obtainHandlerList();
        arrayListObtainHandlerList.addAll(this.gestureHandlers);
        CollectionsKt.sortWith(arrayListObtainHandlerList, handlersComparator);
        try {
            Iterator<GestureHandler> it = arrayListObtainHandlerList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                deliverEventToGestureHandler(it.next(), event);
            }
            recycleHandlerList(arrayListObtainHandlerList);
        } catch (Throwable th) {
            recycleHandlerList(arrayListObtainHandlerList);
            throw th;
        }
    }

    private final void cancelAll() {
        Iterator it = CollectionsKt.toList(CollectionsKt.asReversedMutable(this.awaitingHandlers)).iterator();
        while (it.hasNext()) {
            ((GestureHandler) it.next()).cancel();
        }
        Iterator it2 = CollectionsKt.reversed(this.gestureHandlers).iterator();
        while (it2.hasNext()) {
            ((GestureHandler) it2.next()).cancel();
        }
    }

    private final void deliverEventToGestureHandler(GestureHandler handler, MotionEvent sourceEvent) {
        RNGestureHandlerDetectorView view = handler.getView();
        if (view == null) {
            view = handler.getHostDetectorView();
        }
        if (!isViewAttachedUnderWrapper(view)) {
            handler.cancel();
            return;
        }
        if (handler.wantsEvent(sourceEvent)) {
            int actionMasked = sourceEvent.getActionMasked();
            View coordinateView = handler.getCoordinateView();
            MotionEvent motionEventObtain = MotionEvent.obtain(sourceEvent);
            Intrinsics.checkNotNullExpressionValue(motionEventObtain, "obtain(...)");
            MotionEvent motionEventTransformEventToViewCoords = transformEventToViewCoords(coordinateView, motionEventObtain);
            if (handler.getNeedsPointerData()) {
                handler.updatePointerData(motionEventTransformEventToViewCoords, sourceEvent);
            }
            if (!handler.getIsAwaiting() || actionMasked != 2) {
                handler.handle(motionEventTransformEventToViewCoords, sourceEvent);
                if (handler.getState() == 4 && handler.getIsActive()) {
                    if (handler.getShouldResetProgress()) {
                        handler.setShouldResetProgress(false);
                        handler.resetProgress();
                    }
                    handler.dispatchHandlerUpdate(motionEventTransformEventToViewCoords);
                }
                if (actionMasked == 1 || actionMasked == 6 || actionMasked == 10) {
                    handler.stopTrackingPointer(motionEventTransformEventToViewCoords.getPointerId(motionEventTransformEventToViewCoords.getActionIndex()));
                }
            }
            motionEventTransformEventToViewCoords.recycle();
        }
    }

    public final void cancelAllLegacyHandlers() {
        ArrayList<GestureHandler> arrayListObtainHandlerList = obtainHandlerList();
        arrayListObtainHandlerList.addAll(this.gestureHandlers);
        try {
            for (GestureHandler gestureHandler : arrayListObtainHandlerList) {
                if (gestureHandler.getActionType() == 3 || gestureHandler.getActionType() == 4 || gestureHandler.getActionType() == 1 || gestureHandler.getActionType() == 2) {
                    gestureHandler.cancel();
                }
            }
            scheduleFinishedHandlersCleanup();
        } finally {
            recycleHandlerList(arrayListObtainHandlerList);
        }
    }

    private final boolean isViewAttachedUnderWrapper(View view) {
        if (view == null) {
            return false;
        }
        if (view == this.wrapperView) {
            return true;
        }
        while (true) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup == null || viewGroup.indexOfChild(view) < 0) {
                return false;
            }
            if (viewGroup == this.wrapperView) {
                return true;
            }
            view = viewGroup;
        }
    }

    public final boolean isAnyHandlerActive() {
        ArrayList<GestureHandler> arrayList = this.gestureHandlers;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((GestureHandler) it.next()).getState() == 4) {
                return true;
            }
        }
        return false;
    }

    public final MotionEvent transformEventToViewCoords(View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (!Intrinsics.areEqual(viewGroup, this.wrapperView)) {
                transformEventToViewCoords(viewGroup, event);
            }
            if (viewGroup != null) {
                event.setLocation((event.getX() + viewGroup.getScrollX()) - view.getLeft(), (event.getY() + viewGroup.getScrollY()) - view.getTop());
            }
            if (!view.getMatrix().isIdentity()) {
                Matrix matrix = view.getMatrix();
                Matrix matrix2 = inverseMatrix;
                matrix.invert(matrix2);
                event.transform(matrix2);
            }
        }
        return event;
    }

    public final PointF transformPointToViewCoords(View view, PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (!Intrinsics.areEqual(viewGroup, this.wrapperView)) {
                transformPointToViewCoords(viewGroup, point);
            }
            if (viewGroup != null) {
                point.x += viewGroup.getScrollX() - view.getLeft();
                point.y += viewGroup.getScrollY() - view.getTop();
            }
            if (!view.getMatrix().isIdentity()) {
                Matrix matrix = view.getMatrix();
                Matrix matrix2 = inverseMatrix;
                matrix.invert(matrix2);
                float[] fArr = tempCoords;
                fArr[0] = point.x;
                fArr[1] = point.y;
                matrix2.mapPoints(fArr);
                point.x = fArr[0];
                point.y = fArr[1];
            }
        }
        return point;
    }

    private final void addAwaitingHandler(GestureHandler handler) {
        if (this.awaitingHandlers.contains(handler)) {
            return;
        }
        this.awaitingHandlers.add(handler);
        this.awaitingHandlersTags.add(Integer.valueOf(handler.getTag()));
        handler.setAwaiting(true);
        int i = this.activationIndex;
        this.activationIndex = i + 1;
        handler.setActivationIndex(i);
    }

    public final void recordHandlerIfNotPresent(GestureHandler handler, View view) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.gestureHandlers.contains(handler)) {
            return;
        }
        handler.setActive(false);
        handler.setAwaiting(false);
        handler.setActivationIndex(Integer.MAX_VALUE);
        handler.prepare(view, this);
        if (!handler.shouldBeginWithRecordedHandlers(this.gestureHandlers)) {
            handler.cancel();
        }
        this.gestureHandlers.add(handler);
    }

    private final boolean isViewOverflowingParent(View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return false;
        }
        Matrix matrix = view.getMatrix();
        float[] fArr = matrixTransformCoords;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        matrix.mapPoints(fArr);
        float left = fArr[0] + view.getLeft();
        float top = fArr[1] + view.getTop();
        return left < 0.0f || left + ((float) view.getWidth()) > ((float) viewGroup.getWidth()) || top < 0.0f || top + ((float) view.getHeight()) > ((float) viewGroup.getHeight());
    }

    private final boolean extractAncestorHandlers(View view, float[] coords, int pointerId, MotionEvent event) {
        boolean z = false;
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                if ((parent instanceof RNGestureHandlerRootView) && ((RNGestureHandlerRootView) parent).getRootViewEnabled()) {
                    break;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                ArrayList<GestureHandler> handlersForView = this.handlerRegistry.getHandlersForView((View) parent);
                if (handlersForView != null) {
                    synchronized (handlersForView) {
                        Iterator<GestureHandler> it = handlersForView.iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        while (it.hasNext()) {
                            GestureHandler next = it.next();
                            if (!shouldHandlerSkipHoverEvents(next, event) && next.getIsEnabled() && next.isWithinBounds(view, coords[0], coords[1])) {
                                recordHandlerIfNotPresent(next, viewGroup);
                                next.startTrackingPointer(pointerId);
                                z = true;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    continue;
                }
            }
        }
        return z;
    }

    private final boolean shouldHandlerSkipHoverEvents(GestureHandler handler, MotionEvent event) {
        return ((handler instanceof HoverGestureHandler) || (handler instanceof RNGestureHandlerRootHelper.RootViewGestureHandler) || !ExtensionsKt.isHoverAction(event)) ? false : true;
    }

    static /* synthetic */ boolean recordViewHandlersForPointer$default(GestureHandlerOrchestrator gestureHandlerOrchestrator, View view, float[] fArr, int i, MotionEvent motionEvent, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = false;
        }
        return gestureHandlerOrchestrator.recordViewHandlersForPointer(view, fArr, i, motionEvent, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final boolean recordViewHandlersForPointer(View view, float[] coords, int pointerId, MotionEvent event, boolean useChildBounds) {
        View view2;
        boolean z;
        Integer numValueOf;
        ArrayList<GestureHandler> handlersForViewWithTag;
        float f = coords[0];
        float f2 = coords[1];
        if (useChildBounds) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.swmansion.gesturehandler.react.RNGestureHandlerDetectorView");
            View childAt = ((RNGestureHandlerDetectorView) view).getChildAt(0);
            PointF pointF = tempPoint;
            Intrinsics.checkNotNull(childAt);
            INSTANCE.transformPointToChildViewCoords(coords[0], coords[1], (ViewGroup) view, childAt, pointF);
            f = pointF.x;
            f2 = pointF.y;
            view2 = childAt;
        } else {
            view2 = view;
        }
        ArrayList<GestureHandler> handlersForView = this.handlerRegistry.getHandlersForView(view);
        if (handlersForView != null) {
            synchronized (handlersForView) {
                Iterator<GestureHandler> it = handlersForView.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                z = false;
                while (it.hasNext()) {
                    GestureHandler next = it.next();
                    if (next.getIsEnabled() && next.isWithinBounds(view2, f, f2) && !shouldHandlerSkipHoverEvents(next, event)) {
                        recordHandlerIfNotPresent(next, view);
                        next.startTrackingPointer(pointerId);
                        z = true;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        } else {
            z = false;
        }
        float width = view.getWidth();
        float f3 = coords[0];
        if (0.0f <= f3 && f3 <= width) {
            float height = view.getHeight();
            float f4 = coords[1];
            if (0.0f <= f4 && f4 <= height && isViewOverflowingParent(view) && extractAncestorHandlers(view, coords, pointerId, event)) {
                z = true;
            }
        }
        if (view instanceof ReactCompoundView) {
            try {
                numValueOf = Integer.valueOf(((ReactCompoundView) view).reactTagForTouch(coords[0], coords[1]));
            } catch (IllegalStateException unused) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                if (numValueOf.intValue() != view.getId() && (handlersForViewWithTag = this.handlerRegistry.getHandlersForViewWithTag(numValueOf.intValue())) != null) {
                    synchronized (handlersForViewWithTag) {
                        Iterator<GestureHandler> it2 = handlersForViewWithTag.iterator();
                        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            GestureHandler next2 = it2.next();
                            if (!shouldHandlerSkipHoverEvents(next2, event)) {
                                recordHandlerIfNotPresent(next2, view);
                                next2.startTrackingPointer(pointerId);
                                z = true;
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
        }
        return z;
    }

    private final void extractGestureHandlers(MotionEvent event) {
        int actionIndex = event.getActionIndex();
        int pointerId = event.getPointerId(actionIndex);
        float[] fArr = tempCoords;
        fArr[0] = event.getX(actionIndex);
        fArr[1] = event.getY(actionIndex);
        traverseWithPointerEvents(this.wrapperView, fArr, pointerId, event);
        extractGestureHandlers(this.wrapperView, fArr, pointerId, event);
    }

    private final boolean shouldIgnoreSubtreeIfGestureHandlerRootView(View view) {
        return (view instanceof RNGestureHandlerRootView) && !Intrinsics.areEqual(view, this.wrapperView) && ((RNGestureHandlerRootView) view).getRootViewEnabled();
    }

    private final boolean extractGestureHandlers(ViewGroup viewGroup, float[] coords, int pointerId, MotionEvent event) {
        ViewGroup viewGroup2;
        if (shouldIgnoreSubtreeIfGestureHandlerRootView(viewGroup)) {
            return false;
        }
        int childCount = viewGroup.getChildCount() - 1;
        while (-1 < childCount) {
            View childAt = viewGroup.getChildAt(childCount);
            Intrinsics.checkNotNull(childAt);
            if (canReceiveEvents(childAt)) {
                PointF pointF = tempPoint;
                Companion companion = INSTANCE;
                viewGroup2 = viewGroup;
                companion.transformPointToChildViewCoords(coords[0], coords[1], viewGroup2, childAt, pointF);
                float f = coords[0];
                float f2 = coords[1];
                coords[0] = pointF.x;
                coords[1] = pointF.y;
                boolean zTraverseWithPointerEvents = (!isClipping(childAt) || companion.isTransformedTouchPointInView(coords[0], coords[1], childAt)) ? traverseWithPointerEvents(childAt, coords, pointerId, event) : false;
                coords[0] = f;
                coords[1] = f2;
                if (zTraverseWithPointerEvents) {
                    return true;
                }
            } else {
                viewGroup2 = viewGroup;
            }
            childCount--;
            viewGroup = viewGroup2;
        }
        return false;
    }

    private final void trackPointerDownPoints(MotionEvent event) {
        int actionIndex = event.getActionIndex();
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.pointerDownPoints.clear();
                return;
            } else if (actionMasked != 5) {
                if (actionMasked != 6) {
                    return;
                }
                this.pointerDownPoints.remove(event.getPointerId(actionIndex));
                return;
            }
        }
        this.pointerDownPoints.put(event.getPointerId(actionIndex), new PointF(event.getX(actionIndex), event.getY(actionIndex)));
    }

    public final void cancelTouchesInInterceptedViews(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.viewsToCancel.clear();
        int size = this.pointerDownPoints.size();
        for (int i = 0; i < size; i++) {
            PointF pointFValueAt = this.pointerDownPoints.valueAt(i);
            float[] fArr = tempCoords;
            fArr[0] = pointFValueAt.x;
            fArr[1] = pointFValueAt.y;
            collectViewsAtPoint(this.wrapperView, fArr, this.viewsToCancel);
        }
        if (this.viewsToCancel.isEmpty()) {
            return;
        }
        ArrayList<GestureHandler> arrayList = this.gestureHandlers;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((GestureHandler) obj).getIsActive()) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        MotionEvent motionEventObtain = MotionEvent.obtain(event);
        motionEventObtain.setAction(3);
        Iterator<View> it = this.viewsToCancel.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            View next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            View view = next;
            if (view != this.wrapperView && !isViewDrivenByActiveNativeGesture(view, arrayList3)) {
                view.onTouchEvent(motionEventObtain);
            }
        }
        motionEventObtain.recycle();
        this.viewsToCancel.clear();
    }

    private final boolean isViewDrivenByActiveNativeGesture(View view, List<? extends GestureHandler> activeHandlers) {
        ArrayList<GestureHandler> handlersForView = this.handlerRegistry.getHandlersForView(view);
        boolean z = false;
        if (handlersForView == null) {
            return false;
        }
        synchronized (handlersForView) {
            ArrayList<GestureHandler> arrayList = handlersForView;
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (nativeGestureSurvivesArbitration((GestureHandler) it.next(), activeHandlers)) {
                        z = true;
                        break;
                    }
                }
            }
        }
        return z;
    }

    private final boolean nativeGestureSurvivesArbitration(GestureHandler handler, List<? extends GestureHandler> activeHandlers) {
        if (!(handler instanceof NativeViewGestureHandler)) {
            return false;
        }
        if (handler.getIsActive()) {
            return true;
        }
        List<? extends GestureHandler> list = activeHandlers;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (INSTANCE.shouldHandlerBeCancelledBy(handler, (GestureHandler) it.next())) {
                return false;
            }
        }
        return true;
    }

    private final boolean collectViewsAtPoint(View view, float[] coords, List<View> out) {
        PointerEventsConfig pointerEventsConfigForView;
        boolean zCollectViewsAtPoint;
        if (shouldIgnoreSubtreeIfGestureHandlerRootView(view) || (pointerEventsConfigForView = this.viewConfigHelper.getPointerEventsConfigForView(view)) == PointerEventsConfig.NONE) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointerEventsConfigForView == PointerEventsConfig.BOX_ONLY) {
            zCollectViewsAtPoint = false;
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            zCollectViewsAtPoint = false;
            for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                Intrinsics.checkNotNull(childAt);
                if (canReceiveEvents(childAt)) {
                    PointF pointF = tempPoint;
                    Companion companion = INSTANCE;
                    companion.transformPointToChildViewCoords(coords[0], coords[1], viewGroup, childAt, pointF);
                    if (!isClipping(childAt) || companion.isTransformedTouchPointInView(pointF.x, pointF.y, childAt)) {
                        float f = coords[0];
                        float f2 = coords[1];
                        coords[0] = pointF.x;
                        coords[1] = pointF.y;
                        zCollectViewsAtPoint = collectViewsAtPoint(childAt, coords, out);
                        coords[0] = f;
                        coords[1] = f2;
                        if (zCollectViewsAtPoint) {
                            break;
                        }
                    }
                }
            }
        }
        boolean z = pointerEventsConfigForView != PointerEventsConfig.BOX_NONE && INSTANCE.isTransformedTouchPointInView(coords[0], coords[1], view);
        if (!zCollectViewsAtPoint && !z) {
            return false;
        }
        if (!out.contains(view)) {
            out.add(view);
        }
        return true;
    }

    private final boolean traverseWithPointerEvents(View view, float[] coords, int pointerId, MotionEvent event) {
        if (shouldIgnoreSubtreeIfGestureHandlerRootView(view)) {
            return false;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.viewConfigHelper.getPointerEventsConfigForView(view).ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return recordViewHandlersForPointer$default(this, view, coords, pointerId, event, false, 16, null) || INSTANCE.shouldHandlerlessViewBecomeTouchTarget(view, coords);
        }
        if (i != 3) {
            if (i == 4) {
                return recordViewHandlersForPointer$default(this, view, coords, pointerId, event, false, 16, null) || (view instanceof ViewGroup ? extractGestureHandlers((ViewGroup) view, coords, pointerId, event) : false) || INSTANCE.shouldHandlerlessViewBecomeTouchTarget(view, coords);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (view instanceof ViewGroup) {
            boolean zExtractGestureHandlers = extractGestureHandlers((ViewGroup) view, coords, pointerId, event);
            if (zExtractGestureHandlers) {
                recordViewHandlersForPointer$default(this, view, coords, pointerId, event, false, 16, null);
                return zExtractGestureHandlers;
            }
            if (view instanceof RNGestureHandlerDetectorView) {
                recordViewHandlersForPointer(view, coords, pointerId, event, ((RNGestureHandlerDetectorView) view).getChildCount() == 1);
            }
            return zExtractGestureHandlers;
        }
        if (view instanceof EditText) {
            return recordViewHandlersForPointer$default(this, view, coords, pointerId, event, false, 16, null);
        }
        return false;
    }

    private final boolean canReceiveEvents(View view) {
        return view.getVisibility() == 0 && view.getAlpha() >= this.minimumAlphaForTraversal;
    }

    private final boolean isClipping(View view) {
        return !(view instanceof ViewGroup) || this.viewConfigHelper.isViewClippingChildren((ViewGroup) view);
    }

    public final void activateNativeHandlersForView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList<GestureHandler> handlersForView = this.handlerRegistry.getHandlersForView(view);
        if (handlersForView != null) {
            for (final GestureHandler gestureHandler : handlersForView) {
                if (gestureHandler instanceof NativeViewGestureHandler) {
                    recordHandlerIfNotPresent(gestureHandler, view);
                    gestureHandler.withMarkedAsInBounds(new Function0() { // from class: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GestureHandlerOrchestrator.activateNativeHandlersForView$lambda$0$0(gestureHandler);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit activateNativeHandlersForView$lambda$0$0(GestureHandler gestureHandler) {
        gestureHandler.begin();
        gestureHandler.activate();
        gestureHandler.end();
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: GestureHandlerOrchestrator.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0002J.\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0007J \u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0002J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0002J\u0018\u0010$\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator$Companion;", "", "<init>", "()V", "DEFAULT_MIN_ALPHA_FOR_TRAVERSAL", "", "tempPoint", "Landroid/graphics/PointF;", "matrixTransformCoords", "", "inverseMatrix", "Landroid/graphics/Matrix;", "tempCoords", "handlersComparator", "Ljava/util/Comparator;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "shouldHandlerlessViewBecomeTouchTarget", "", "view", "Landroid/view/View;", "coords", "transformPointToChildViewCoords", "", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "parent", "Landroid/view/ViewGroup;", "child", "outLocalPoint", "isTransformedTouchPointInView", "shouldHandlerWaitForOther", "handler", "other", "canRunSimultaneously", "a", "b", "shouldHandlerBeCancelledBy", "isFinished", "state", "", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isFinished(int state) {
            return state == 3 || state == 1 || state == 5;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldHandlerlessViewBecomeTouchTarget(View view, float[] coords) {
            return (!(view instanceof ViewGroup) || (view.getBackground() != null) || (view.getParent() instanceof RNGestureHandlerDetectorView)) && isTransformedTouchPointInView(coords[0], coords[1], view);
        }

        public final void transformPointToChildViewCoords(float x, float y, ViewGroup parent, View child, PointF outLocalPoint) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(outLocalPoint, "outLocalPoint");
            float scrollX = (x + parent.getScrollX()) - child.getLeft();
            float scrollY = (y + parent.getScrollY()) - child.getTop();
            Matrix matrix = child.getMatrix();
            if (!matrix.isIdentity()) {
                float[] fArr = GestureHandlerOrchestrator.matrixTransformCoords;
                fArr[0] = scrollX;
                fArr[1] = scrollY;
                matrix.invert(GestureHandlerOrchestrator.inverseMatrix);
                GestureHandlerOrchestrator.inverseMatrix.mapPoints(fArr);
                float f = fArr[0];
                scrollY = fArr[1];
                scrollX = f;
            }
            outLocalPoint.set(scrollX, scrollY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isTransformedTouchPointInView(float x, float y, View child) {
            return 0.0f <= x && x <= ((float) child.getWidth()) && 0.0f <= y && y <= ((float) child.getHeight());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldHandlerWaitForOther(GestureHandler handler, GestureHandler other) {
            if (handler != other) {
                return handler.shouldWaitForHandlerFailure(other) || other.shouldRequireToWaitForFailure(handler);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean canRunSimultaneously(GestureHandler a2, GestureHandler b) {
            return a2 == b || a2.shouldRecognizeSimultaneously(b) || b.shouldRecognizeSimultaneously(a2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldHandlerBeCancelledBy(GestureHandler handler, GestureHandler other) {
            if (!handler.hasCommonPointers(other) || canRunSimultaneously(handler, other)) {
                return false;
            }
            if (handler == other) {
                return true;
            }
            if (handler.getIsAwaiting() || handler.getState() == 4) {
                return handler.shouldBeCancelledBy(other);
            }
            return true;
        }
    }

    static final int handlersComparator$lambda$0(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        if ((gestureHandler.getIsActive() && gestureHandler2.getIsActive()) || (gestureHandler.getIsAwaiting() && gestureHandler2.getIsAwaiting())) {
            return Integer.signum(gestureHandler2.getActivationIndex() - gestureHandler.getActivationIndex());
        }
        if (gestureHandler.getIsActive()) {
            return -1;
        }
        if (gestureHandler2.getIsActive()) {
            return 1;
        }
        if (gestureHandler.getIsAwaiting()) {
            return -1;
        }
        return gestureHandler2.getIsAwaiting() ? 1 : 0;
    }
}
