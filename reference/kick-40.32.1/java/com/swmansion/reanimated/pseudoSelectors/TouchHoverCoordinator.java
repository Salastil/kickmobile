package com.swmansion.reanimated.pseudoSelectors;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.datadog.android.log.LogAttributes;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.TouchTargetHelper;
import com.swmansion.reanimated.nativeProxy.PseudoSelectorCallback;
import expo.modules.updates.codesigning.CodeSigningAlgorithmKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TouchHoverCoordinator.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001SB%\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\fJ\u0016\u0010$\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bJ\u0006\u0010%\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000bJ\u0006\u0010'\u001a\u00020\u0006J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,J\u001e\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201J\"\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u0002012\u0006\u00107\u001a\u000201H\u0002J\u0016\u00108\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0005J\u0016\u0010:\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0005J\u000e\u0010;\u001a\u0002042\u0006\u00109\u001a\u00020\u0005J\"\u0010<\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002J$\u0010=\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u0018H\u0002J&\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00130@2\u0006\u00105\u001a\u00020\u00042\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002J$\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00130@2\u0006\u0010!\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201J\u001d\u0010B\u001a\u00020\u00062\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002040DH\u0082\bJ\b\u0010E\u001a\u00020\u0006H\u0002J\u0010\u0010F\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,H\u0002J \u0010G\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\f2\u0006\u0010H\u001a\u000204H\u0002J\u0018\u0010I\u001a\u0004\u0018\u00010,*\f\u0012\b\u0012\u00060\u001eR\u00020\u00000\u001dH\u0002J\u0010\u0010J\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0018\u0010K\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010L\u001a\u000204H\u0002J\u0010\u0010M\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010N\u001a\u00020\u0006H\u0002J\u0014\u0010O\u001a\u00020\u00062\n\u0010P\u001a\u00060\u001eR\u00020\u0000H\u0002J\u000e\u0010Q\u001a\u0002042\u0006\u0010!\u001a\u00020\u000bJ\u000e\u0010R\u001a\u0004\u0018\u00010,*\u00020\u000bH\u0002R\"\u0010\u0002\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u000fj\b\u0012\u0004\u0012\u00020\u000b`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0012j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u001eR\u00020\u00000\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/swmansion/reanimated/pseudoSelectors/TouchHoverCoordinator;", "", "onWindowTouch", "Lkotlin/Function2;", "Landroid/view/ViewGroup;", "Landroid/view/MotionEvent;", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "hoverCallbacks", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "Lcom/swmansion/reanimated/nativeProxy/PseudoSelectorCallback;", "Lkotlin/collections/LinkedHashMap;", "hoveredViews", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "hoverHostRefs", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "tmpLocation", "", "tmpCoords", "", "settledGestureDownTime", "", "observedWindows", "", "Ljava/lang/ref/WeakReference;", "Lcom/swmansion/reanimated/pseudoSelectors/TouchHoverCoordinator$WindowObserver;", "windowObserverRetainCount", "register", "view", LogAttributes.HOST, "callback", "unregister", "uninstall", "retainWindowObserver", "releaseWindowObserver", "acquireHoverListener", "releaseHoverListener", "observeExtraWindow", "window", "Landroid/view/Window;", "stopObservingExtraWindow", "recompute", "sourceView", "screenX", "", "screenY", "movedBeyondSlop", "", CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID, "dx", "dy", "onViewTouchUp", "event", "onViewTouchCancel", "isGestureSettled", "reconcile", "settleHover", "downPoint", "hitTestPath", "", "hitTestTagsAt", "unhoverWhere", "predicate", "Lkotlin/Function1;", "clearAll", "clearHoverForWindow", "setHovered", "hovered", "liveWindow", "ensureWindowObserver", "installObserverOnWindow", "isExtra", "removeObserverFromWindow", "removeActivityWindowObservers", "restoreCallback", "observer", "isWindowObserved", "activityWindow", "WindowObserver", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TouchHoverCoordinator {
    private final LinkedHashMap<View, PseudoSelectorCallback> hoverCallbacks;
    private final HashMap<View, Integer> hoverHostRefs;
    private final LinkedHashSet<View> hoveredViews;
    private final List<WeakReference<WindowObserver>> observedWindows;
    private final Function2<ViewGroup, MotionEvent, Unit> onWindowTouch;
    private long settledGestureDownTime;
    private final float[] tmpCoords;
    private final int[] tmpLocation;
    private int windowObserverRetainCount;

    /* JADX WARN: Multi-variable type inference failed */
    public TouchHoverCoordinator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TouchHoverCoordinator(Function2<? super ViewGroup, ? super MotionEvent, Unit> onWindowTouch) {
        Intrinsics.checkNotNullParameter(onWindowTouch, "onWindowTouch");
        this.onWindowTouch = onWindowTouch;
        this.hoverCallbacks = new LinkedHashMap<>();
        this.hoveredViews = new LinkedHashSet<>();
        this.hoverHostRefs = new HashMap<>();
        this.tmpLocation = new int[2];
        this.tmpCoords = new float[2];
        this.settledGestureDownTime = Long.MIN_VALUE;
        this.observedWindows = new ArrayList();
    }

    public /* synthetic */ TouchHoverCoordinator(Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function2() { // from class: com.swmansion.reanimated.pseudoSelectors.TouchHoverCoordinator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TouchHoverCoordinator._init_$lambda$0((ViewGroup) obj, (MotionEvent) obj2);
            }
        } : function2);
    }

    static final Unit _init_$lambda$0(ViewGroup viewGroup, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TouchHoverCoordinator.kt */
    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0019\u0010\u0016\u001a\u00020\u00062\u000e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\u00062\u000e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\u00190\u0019H\u0096\u0001J\u0019\u0010\u001a\u001a\u00020\u00062\u000e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\u00190\u0019H\u0096\u0001J\u0019\u0010\u001b\u001a\u00020\u00062\u000e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001cH\u0096\u0001J\u0019\u0010\u001d\u001a\u00020\u00062\u000e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u000e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010 0 H\u0096\u0001J\u0019\u0010!\u001a\u00020\u001f2\u000e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010 0 H\u0096\u0001J\t\u0010\"\u001a\u00020\u001fH\u0096\u0001J\t\u0010#\u001a\u00020\u001fH\u0096\u0001J \u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020%2\r\b\u0001\u0010&\u001a\u00070'¢\u0006\u0002\b(H\u0096\u0001J\u0018\u0010)\u001a\t\u0018\u00010*¢\u0006\u0002\b(2\u0006\u0010\u0017\u001a\u00020%H\u0097\u0001J\t\u0010+\u001a\u00020\u001fH\u0096\u0001J \u0010,\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020%2\r\b\u0001\u0010&\u001a\u00070-¢\u0006\u0002\b(H\u0096\u0001J \u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020%2\r\b\u0001\u0010&\u001a\u00070'¢\u0006\u0002\b(H\u0096\u0001J \u0010/\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020%2\r\b\u0001\u0010&\u001a\u00070'¢\u0006\u0002\b(H\u0096\u0001J1\u00100\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020%2\u000f\b\u0001\u0010&\u001a\t\u0018\u00010*¢\u0006\u0002\b(2\r\b\u0001\u00101\u001a\u00070'¢\u0006\u0002\b(H\u0096\u0001J\t\u00102\u001a\u00020\u0006H\u0096\u0001J\u0019\u00102\u001a\u00020\u00062\u000e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010303H\u0096\u0001J\u0019\u00104\u001a\u00020\u001f2\u000e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010505H\u0096\u0001J\u0011\u00106\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0096\u0001J \u00107\u001a\t\u0018\u00010 ¢\u0006\u0002\b(2\u000e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010808H\u0097\u0001J(\u00107\u001a\t\u0018\u00010 ¢\u0006\u0002\b(2\u000e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u000108082\u0006\u0010&\u001a\u00020%H\u0097\u0001R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00030\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/swmansion/reanimated/pseudoSelectors/TouchHoverCoordinator$WindowObserver;", "Landroid/view/Window$Callback;", "window", "Landroid/view/Window;", "original", "isExtra", "", "<init>", "(Lcom/swmansion/reanimated/pseudoSelectors/TouchHoverCoordinator;Landroid/view/Window;Landroid/view/Window$Callback;Z)V", "getOriginal", "()Landroid/view/Window$Callback;", "()Z", "windowRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWindowRef", "()Ljava/lang/ref/WeakReference;", "downPoint", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "dispatchGenericMotionEvent", "p0", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchKeyShortcutEvent", "dispatchPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "dispatchTrackballEvent", "onActionModeFinished", "", "Landroid/view/ActionMode;", "onActionModeStarted", "onAttachedToWindow", "onContentChanged", "onCreatePanelMenu", "", "p1", "Landroid/view/Menu;", "Lkotlin/jvm/internal/EnhancedNullability;", "onCreatePanelView", "Landroid/view/View;", "onDetachedFromWindow", "onMenuItemSelected", "Landroid/view/MenuItem;", "onMenuOpened", "onPanelClosed", "onPreparePanel", "p2", "onSearchRequested", "Landroid/view/SearchEvent;", "onWindowAttributesChanged", "Landroid/view/WindowManager$LayoutParams;", "onWindowFocusChanged", "onWindowStartingActionMode", "Landroid/view/ActionMode$Callback;", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    final class WindowObserver implements Window.Callback {
        private final float[] downPoint;
        private final boolean isExtra;
        private final Window.Callback original;
        final /* synthetic */ TouchHoverCoordinator this$0;
        private final WeakReference<Window> windowRef;

        @Override // android.view.Window.Callback
        public boolean dispatchGenericMotionEvent(MotionEvent p0) {
            return this.original.dispatchGenericMotionEvent(p0);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent p0) {
            return this.original.dispatchKeyEvent(p0);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent p0) {
            return this.original.dispatchKeyShortcutEvent(p0);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent p0) {
            return this.original.dispatchPopulateAccessibilityEvent(p0);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTrackballEvent(MotionEvent p0) {
            return this.original.dispatchTrackballEvent(p0);
        }

        @Override // android.view.Window.Callback
        public void onActionModeFinished(ActionMode p0) {
            this.original.onActionModeFinished(p0);
        }

        @Override // android.view.Window.Callback
        public void onActionModeStarted(ActionMode p0) {
            this.original.onActionModeStarted(p0);
        }

        @Override // android.view.Window.Callback
        public void onAttachedToWindow() {
            this.original.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            this.original.onContentChanged();
        }

        @Override // android.view.Window.Callback
        public boolean onCreatePanelMenu(int p0, Menu p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            return this.original.onCreatePanelMenu(p0, p1);
        }

        @Override // android.view.Window.Callback
        public View onCreatePanelView(int p0) {
            return this.original.onCreatePanelView(p0);
        }

        @Override // android.view.Window.Callback
        public void onDetachedFromWindow() {
            this.original.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public boolean onMenuItemSelected(int p0, MenuItem p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            return this.original.onMenuItemSelected(p0, p1);
        }

        @Override // android.view.Window.Callback
        public boolean onMenuOpened(int p0, Menu p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            return this.original.onMenuOpened(p0, p1);
        }

        @Override // android.view.Window.Callback
        public void onPanelClosed(int p0, Menu p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            this.original.onPanelClosed(p0, p1);
        }

        @Override // android.view.Window.Callback
        public boolean onPreparePanel(int p0, View p1, Menu p2) {
            Intrinsics.checkNotNullParameter(p2, "p2");
            return this.original.onPreparePanel(p0, p1, p2);
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested() {
            return this.original.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested(SearchEvent p0) {
            return this.original.onSearchRequested(p0);
        }

        @Override // android.view.Window.Callback
        public void onWindowAttributesChanged(WindowManager.LayoutParams p0) {
            this.original.onWindowAttributesChanged(p0);
        }

        @Override // android.view.Window.Callback
        public void onWindowFocusChanged(boolean p0) {
            this.original.onWindowFocusChanged(p0);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback p0) {
            return this.original.onWindowStartingActionMode(p0);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback p0, int p1) {
            return this.original.onWindowStartingActionMode(p0, p1);
        }

        public WindowObserver(TouchHoverCoordinator touchHoverCoordinator, Window window, Window.Callback original, boolean z) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(original, "original");
            this.this$0 = touchHoverCoordinator;
            this.original = original;
            this.isExtra = z;
            this.windowRef = new WeakReference<>(window);
            this.downPoint = new float[2];
        }

        public final Window.Callback getOriginal() {
            return this.original;
        }

        /* JADX INFO: renamed from: isExtra, reason: from getter */
        public final boolean getIsExtra() {
            return this.isExtra;
        }

        public final WeakReference<Window> getWindowRef() {
            return this.windowRef;
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Window window = this.windowRef.get();
            View decorView = window != null ? window.getDecorView() : null;
            ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
            int actionMasked = event.getActionMasked();
            if (actionMasked == 0) {
                this.downPoint[0] = event.getRawX();
                this.downPoint[1] = event.getRawY();
                this.this$0.reconcile(viewGroup, event.getRawX(), event.getRawY());
            } else if (actionMasked == 1) {
                if (event.findPointerIndex(0) >= 0) {
                    this.this$0.settleHover(viewGroup, event, this.downPoint);
                }
            } else if (actionMasked == 6 && event.getPointerId(event.getActionIndex()) == 0) {
                this.this$0.settleHover(viewGroup, event, this.downPoint);
            }
            this.this$0.onWindowTouch.invoke(viewGroup, event);
            return this.original.dispatchTouchEvent(event);
        }
    }

    public final void register(View view, View host, PseudoSelectorCallback callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.hoverCallbacks.put(view, callback);
        acquireHoverListener(host);
        retainWindowObserver(view);
    }

    public final void unregister(View view, View host) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(host, "host");
        PseudoSelectorCallback pseudoSelectorCallbackRemove = this.hoverCallbacks.remove(view);
        if (this.hoveredViews.remove(view) && pseudoSelectorCallbackRemove != null) {
            pseudoSelectorCallbackRemove.onSelectorStateChanged(false);
        }
        releaseHoverListener(host);
        releaseWindowObserver();
    }

    public final void uninstall() {
        this.windowObserverRetainCount = 0;
        Iterator<T> it = this.observedWindows.iterator();
        while (it.hasNext()) {
            WindowObserver windowObserver = (WindowObserver) ((WeakReference) it.next()).get();
            if (windowObserver != null) {
                restoreCallback(windowObserver);
            }
        }
        this.observedWindows.clear();
        Set<View> setKeySet = this.hoverHostRefs.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        Iterator<T> it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            ((View) it2.next()).setOnHoverListener(null);
        }
        this.hoverHostRefs.clear();
        this.hoverCallbacks.clear();
        this.hoveredViews.clear();
    }

    public final void retainWindowObserver(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.windowObserverRetainCount++;
        ensureWindowObserver(view);
    }

    public final void releaseWindowObserver() {
        int i = this.windowObserverRetainCount;
        if (i == 0) {
            return;
        }
        int i2 = i - 1;
        this.windowObserverRetainCount = i2;
        if (i2 == 0) {
            removeActivityWindowObservers();
        }
    }

    private final void acquireHoverListener(final View host) {
        Integer orDefault = this.hoverHostRefs.getOrDefault(host, 0);
        Intrinsics.checkNotNullExpressionValue(orDefault, "getOrDefault(...)");
        int iIntValue = orDefault.intValue();
        this.hoverHostRefs.put(host, Integer.valueOf(iIntValue + 1));
        if (iIntValue == 0) {
            host.setOnHoverListener(new View.OnHoverListener() { // from class: com.swmansion.reanimated.pseudoSelectors.TouchHoverCoordinator$$ExternalSyntheticLambda2
                @Override // android.view.View.OnHoverListener
                public final boolean onHover(View view, MotionEvent motionEvent) {
                    return TouchHoverCoordinator.acquireHoverListener$lambda$0(this.f$0, host, view, motionEvent);
                }
            });
        }
    }

    static final boolean acquireHoverListener$lambda$0(TouchHoverCoordinator touchHoverCoordinator, View view, View view2, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7 || actionMasked == 9) {
            touchHoverCoordinator.recompute(view, motionEvent.getRawX(), motionEvent.getRawY());
            return false;
        }
        if (actionMasked != 10) {
            return false;
        }
        touchHoverCoordinator.clearAll();
        return false;
    }

    private final void releaseHoverListener(View host) {
        Integer orDefault = this.hoverHostRefs.getOrDefault(host, 0);
        Intrinsics.checkNotNullExpressionValue(orDefault, "getOrDefault(...)");
        int iIntValue = orDefault.intValue();
        HashMap<View, Integer> map = this.hoverHostRefs;
        if (iIntValue > 1) {
            map.put(host, Integer.valueOf(iIntValue - 1));
        } else {
            map.remove(host);
            host.setOnHoverListener(null);
        }
    }

    public final void observeExtraWindow(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        installObserverOnWindow(window, true);
    }

    public final void stopObservingExtraWindow(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        removeObserverFromWindow(window);
        clearHoverForWindow(window);
    }

    public final void recompute(View sourceView, float screenX, float screenY) {
        Intrinsics.checkNotNullParameter(sourceView, "sourceView");
        View rootView = sourceView.getRootView();
        reconcile(rootView instanceof ViewGroup ? (ViewGroup) rootView : null, screenX, screenY);
    }

    private final boolean movedBeyondSlop(ViewGroup root, float dx, float dy) {
        Context context;
        if (root == null || (context = root.getContext()) == null) {
            Set<View> setKeySet = this.hoverCallbacks.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
            View view = (View) CollectionsKt.firstOrNull(setKeySet);
            context = view != null ? view.getContext() : null;
            if (context == null) {
                return true;
            }
        }
        float scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        return (dx * dx) + (dy * dy) > scaledTouchSlop * scaledTouchSlop;
    }

    public final void onViewTouchUp(View sourceView, MotionEvent event) {
        Intrinsics.checkNotNullParameter(sourceView, "sourceView");
        Intrinsics.checkNotNullParameter(event, "event");
        if (isWindowObserved(sourceView)) {
            return;
        }
        View rootView = sourceView.getRootView();
        settleHover(rootView instanceof ViewGroup ? (ViewGroup) rootView : null, event, null);
    }

    public final void onViewTouchCancel(View sourceView, MotionEvent event) {
        Intrinsics.checkNotNullParameter(sourceView, "sourceView");
        Intrinsics.checkNotNullParameter(event, "event");
        if (isWindowObserved(sourceView) || isGestureSettled(event)) {
            return;
        }
        this.settledGestureDownTime = event.getDownTime();
        clearAll();
    }

    public final boolean isGestureSettled(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return event.getDownTime() == this.settledGestureDownTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reconcile(ViewGroup root, float screenX, float screenY) {
        if (this.hoverCallbacks.isEmpty()) {
            return;
        }
        List<Integer> listEmptyList = root == null ? CollectionsKt.emptyList() : hitTestPath(root, screenX, screenY);
        for (Map.Entry<View, PseudoSelectorCallback> entry : this.hoverCallbacks.entrySet()) {
            View key = entry.getKey();
            setHovered(key, entry.getValue(), listEmptyList.contains(Integer.valueOf(key.getId())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void settleHover(ViewGroup root, MotionEvent event, float[] downPoint) {
        PseudoSelectorCallback pseudoSelectorCallback;
        if (isGestureSettled(event)) {
            return;
        }
        this.settledGestureDownTime = event.getDownTime();
        int iFindPointerIndex = event.findPointerIndex(0);
        if (iFindPointerIndex < 0 || this.hoveredViews.isEmpty()) {
            return;
        }
        float x = event.getX(iFindPointerIndex) + (event.getRawX() - event.getX(0));
        float y = event.getY(iFindPointerIndex) + (event.getRawY() - event.getY(0));
        if (downPoint == null || movedBeyondSlop(root, x - downPoint[0], y - downPoint[1])) {
            List<Integer> listEmptyList = root == null ? CollectionsKt.emptyList() : hitTestPath(root, x, y);
            for (View view : CollectionsKt.toList(this.hoveredViews)) {
                if (!listEmptyList.contains(Integer.valueOf(view.getId())) && (pseudoSelectorCallback = this.hoverCallbacks.get(view)) != null) {
                    setHovered(view, pseudoSelectorCallback, false);
                }
            }
        }
    }

    private final List<Integer> hitTestPath(ViewGroup root, float screenX, float screenY) {
        root.getLocationOnScreen(this.tmpLocation);
        int[] iArr = this.tmpLocation;
        List<TouchTargetHelper.ViewTarget> listFindTargetPathAndCoordinatesForTouch = TouchTargetHelper.findTargetPathAndCoordinatesForTouch(screenX - iArr[0], screenY - iArr[1], root, this.tmpCoords);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFindTargetPathAndCoordinatesForTouch, 10));
        Iterator<T> it = listFindTargetPathAndCoordinatesForTouch.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((TouchTargetHelper.ViewTarget) it.next()).getViewId()));
        }
        return arrayList;
    }

    public final List<Integer> hitTestTagsAt(View view, float screenX, float screenY) {
        Intrinsics.checkNotNullParameter(view, "view");
        View rootView = view.getRootView();
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        return viewGroup == null ? CollectionsKt.emptyList() : hitTestPath(viewGroup, screenX, screenY);
    }

    private final void unhoverWhere(Function1<? super View, Boolean> predicate) {
        PseudoSelectorCallback pseudoSelectorCallback;
        for (View view : CollectionsKt.toList(this.hoveredViews)) {
            if (predicate.invoke(view).booleanValue() && (pseudoSelectorCallback = this.hoverCallbacks.get(view)) != null) {
                setHovered(view, pseudoSelectorCallback, false);
            }
        }
    }

    private final void clearHoverForWindow(Window window) {
        PseudoSelectorCallback pseudoSelectorCallback;
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        for (View view : CollectionsKt.toList(this.hoveredViews)) {
            if (view.getRootView() == decorView && (pseudoSelectorCallback = this.hoverCallbacks.get(view)) != null) {
                setHovered(view, pseudoSelectorCallback, false);
            }
        }
    }

    private final void setHovered(View view, PseudoSelectorCallback callback, boolean hovered) {
        if (this.hoveredViews.contains(view) == hovered) {
            return;
        }
        LinkedHashSet<View> linkedHashSet = this.hoveredViews;
        if (hovered) {
            linkedHashSet.add(view);
        } else {
            linkedHashSet.remove(view);
        }
        callback.onSelectorStateChanged(hovered);
    }

    private final Window liveWindow(WeakReference<WindowObserver> weakReference) {
        WeakReference<Window> windowRef;
        WindowObserver windowObserver = weakReference.get();
        if (windowObserver == null || (windowRef = windowObserver.getWindowRef()) == null) {
            return null;
        }
        return windowRef.get();
    }

    private final void ensureWindowObserver(View view) {
        Window windowActivityWindow = activityWindow(view);
        if (windowActivityWindow == null) {
            return;
        }
        installObserverOnWindow(windowActivityWindow, false);
    }

    private final void installObserverOnWindow(Window window, boolean isExtra) {
        CollectionsKt.removeAll((List) this.observedWindows, new Function1() { // from class: com.swmansion.reanimated.pseudoSelectors.TouchHoverCoordinator$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TouchHoverCoordinator.installObserverOnWindow$lambda$0(this.f$0, (WeakReference) obj));
            }
        });
        List<WeakReference<WindowObserver>> list = this.observedWindows;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (liveWindow((WeakReference) it.next()) == window) {
                    return;
                }
            }
        }
        Window.Callback callback = window.getCallback();
        if (callback == null) {
            return;
        }
        WindowObserver windowObserver = new WindowObserver(this, window, callback, isExtra);
        this.observedWindows.add(new WeakReference<>(windowObserver));
        window.setCallback(windowObserver);
    }

    static final boolean installObserverOnWindow$lambda$0(TouchHoverCoordinator touchHoverCoordinator, WeakReference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return touchHoverCoordinator.liveWindow(it) == null;
    }

    private final void removeObserverFromWindow(Window window) {
        Iterator<WeakReference<WindowObserver>> it = this.observedWindows.iterator();
        while (it.hasNext()) {
            WindowObserver windowObserver = it.next().get();
            if (windowObserver == null) {
                it.remove();
            } else if (windowObserver.getWindowRef().get() == window) {
                restoreCallback(windowObserver);
                it.remove();
            }
        }
    }

    private final void removeActivityWindowObservers() {
        CollectionsKt.removeAll((List) this.observedWindows, new Function1() { // from class: com.swmansion.reanimated.pseudoSelectors.TouchHoverCoordinator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TouchHoverCoordinator.removeActivityWindowObservers$lambda$0(this.f$0, (WeakReference) obj));
            }
        });
        clearAll();
    }

    static final boolean removeActivityWindowObservers$lambda$0(TouchHoverCoordinator touchHoverCoordinator, WeakReference reference) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        WindowObserver windowObserver = (WindowObserver) reference.get();
        if (windowObserver == null) {
            return true;
        }
        if (windowObserver.getIsExtra()) {
            return false;
        }
        touchHoverCoordinator.restoreCallback(windowObserver);
        return true;
    }

    private final void restoreCallback(WindowObserver observer) {
        Window window = observer.getWindowRef().get();
        if (window != null && window.getCallback() == observer) {
            window.setCallback(observer.getOriginal());
        }
    }

    public final boolean isWindowObserved(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View rootView = view.getRootView();
        List<WeakReference<WindowObserver>> list = this.observedWindows;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Window windowLiveWindow = liveWindow((WeakReference) it.next());
            if ((windowLiveWindow != null ? windowLiveWindow.getDecorView() : null) == rootView) {
                return true;
            }
        }
        return false;
    }

    private final Window activityWindow(View view) {
        Activity currentActivity;
        Activity currentActivity2;
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow();
            }
            if ((context instanceof ReactContext) && (currentActivity2 = ((ReactContext) context).getCurrentActivity()) != null) {
                return currentActivity2.getWindow();
            }
        }
        Context context2 = view.getContext();
        ReactContext reactContext = context2 instanceof ReactContext ? (ReactContext) context2 : null;
        if (reactContext == null || (currentActivity = reactContext.getCurrentActivity()) == null) {
            return null;
        }
        return currentActivity.getWindow();
    }

    private final void clearAll() {
        for (View view : CollectionsKt.toList(this.hoveredViews)) {
            PseudoSelectorCallback pseudoSelectorCallback = this.hoverCallbacks.get(view);
            if (pseudoSelectorCallback != null) {
                setHovered(view, pseudoSelectorCallback, false);
            }
        }
    }
}
