package com.swmansion.reanimated.pseudoSelectors;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.datadog.android.log.LogAttributes;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ReactCompoundView;
import com.swmansion.reanimated.nativeProxy.PseudoSelectorCallback;
import expo.modules.updates.codesigning.CodeSigningAlgorithmKt;
import io.ktor.sse.ServerSentEventKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PseudoSelectorManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0015*\u0001\"\u0018\u00002\u00020\u0001:\u0002[\\B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0012J(\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0012H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002JE\u0010.\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00122#\u00100\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020 01H\u0002J \u00105\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0012H\u0002J4\u00106\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00122\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001208H\u0002J\u001a\u00109\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=H\u0002J\u001a\u0010>\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=H\u0002J6\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00160FH\u0002J\u0014\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110HH\u0002J \u0010I\u001a\u0004\u0018\u00010\u00112\u0006\u0010@\u001a\u00020\u00112\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00160FH\u0002J\b\u0010J\u001a\u00020%H\u0002J\u0010\u0010K\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0011H\u0002J\u0010\u0010L\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0010\u0010M\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0018\u0010N\u001a\u00020 2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010O\u001a\u00020%2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010P\u001a\u00020%2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010Q\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u001e\u0010R\u001a\u00020%2\u0006\u0010A\u001a\u00020\u00112\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00160FH\u0002J\u0016\u0010S\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0016J\u0006\u0010T\u001a\u00020%J\u001e\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u00112\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00160FH\u0002J\u0018\u0010W\u001a\u00020%2\u0006\u0010X\u001a\u00020\u00112\u0006\u0010Y\u001a\u00020 H\u0002J\u0018\u0010Z\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010V\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00160\nj\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0016`\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180\nj\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0018`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e0\u0010j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#¨\u0006]"}, d2 = {"Lcom/swmansion/reanimated/pseudoSelectors/PseudoSelectorManager;", "", "fabricUIManager", "Lcom/facebook/react/fabric/FabricUIManager;", "reactContext", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/fabric/FabricUIManager;Ljava/lang/ref/WeakReference;)V", "detachActions", "Ljava/util/HashMap;", "", "Ljava/lang/Runnable;", "Lkotlin/collections/HashMap;", "focusDetachActions", "activeCallbacks", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "Lcom/swmansion/reanimated/nativeProxy/PseudoSelectorCallback;", "Lkotlin/collections/LinkedHashMap;", "deepestCallbacks", "touchHostRefs", "", "gestureByHost", "Lcom/swmansion/reanimated/pseudoSelectors/PseudoSelectorManager$HostGesture;", "hover", "Lcom/swmansion/reanimated/pseudoSelectors/TouchHoverCoordinator;", "extraWindowBridge", "Lcom/swmansion/reanimated/pseudoSelectors/ExtraWindowObserverBridge;", "pendingAttaches", "Lcom/swmansion/reanimated/pseudoSelectors/PseudoSelectorManager$PendingAttach;", "mountListenerRegistered", "", "mountListener", "com/swmansion/reanimated/pseudoSelectors/PseudoSelectorManager$mountListener$1", "Lcom/swmansion/reanimated/pseudoSelectors/PseudoSelectorManager$mountListener$1;", "attach", "", "tag", "selector", "callback", "attachToView", "view", "tryResolveView", "ensureMountListener", "flushPendingAttaches", "attachFocusListener", "key", "isFocused", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newFocus", "attachHover", "attachPressSelector", "callbacks", "", "onWindowPressTouch", CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID, "Landroid/view/ViewGroup;", "event", "Landroid/view/MotionEvent;", "windowPressDown", "beginPress", LogAttributes.HOST, "leaf", "rawX", "", "rawY", "hitTags", "", "pressHostsById", "", "findTouchedLeaf", "releaseAllHostGestures", "findTouchHost", "acquireTouchListener", "releaseTouchListener", "onHostTouch", "onHostDown", "onHostMove", "onHostRelease", "fireDeepestIfHit", "detach", "invalidate", "hasDeepestDescendantAt", "ancestor", "fireActiveCallbacksUpTree", "source", "isActive", "isDescendantOf", "PendingAttach", "HostGesture", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PseudoSelectorManager {
    private final LinkedHashMap<View, PseudoSelectorCallback> activeCallbacks;
    private final LinkedHashMap<View, PseudoSelectorCallback> deepestCallbacks;
    private final HashMap<String, Runnable> detachActions;
    private ExtraWindowObserverBridge extraWindowBridge;
    private final FabricUIManager fabricUIManager;
    private final HashMap<String, Runnable> focusDetachActions;
    private final HashMap<View, HostGesture> gestureByHost;
    private final TouchHoverCoordinator hover;
    private final PseudoSelectorManager$mountListener$1 mountListener;
    private boolean mountListenerRegistered;
    private final LinkedHashMap<String, PendingAttach> pendingAttaches;
    private final WeakReference<ReactApplicationContext> reactContext;
    private final HashMap<View, Integer> touchHostRefs;

    static final boolean attachToView$lambda$1(View view, View view2) {
        return view2 == view;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$mountListener$1] */
    public PseudoSelectorManager(FabricUIManager fabricUIManager, WeakReference<ReactApplicationContext> reactContext) {
        Intrinsics.checkNotNullParameter(fabricUIManager, "fabricUIManager");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.fabricUIManager = fabricUIManager;
        this.reactContext = reactContext;
        this.detachActions = new HashMap<>();
        this.focusDetachActions = new HashMap<>();
        this.activeCallbacks = new LinkedHashMap<>();
        this.deepestCallbacks = new LinkedHashMap<>();
        this.touchHostRefs = new HashMap<>();
        this.gestureByHost = new HashMap<>();
        this.hover = new TouchHoverCoordinator(new PseudoSelectorManager$hover$1(this));
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager._init_$lambda$0(this.f$0);
            }
        });
        this.pendingAttaches = new LinkedHashMap<>();
        this.mountListener = new UIManagerListener() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$mountListener$1
            @Override // com.facebook.react.bridge.UIManagerListener
            public void didDispatchMountItems(UIManager uiManager) {
                Intrinsics.checkNotNullParameter(uiManager, "uiManager");
            }

            @Override // com.facebook.react.bridge.UIManagerListener
            public void didScheduleMountItems(UIManager uiManager) {
                Intrinsics.checkNotNullParameter(uiManager, "uiManager");
            }

            @Override // com.facebook.react.bridge.UIManagerListener
            public void willDispatchViewUpdates(UIManager uiManager) {
                Intrinsics.checkNotNullParameter(uiManager, "uiManager");
            }

            @Override // com.facebook.react.bridge.UIManagerListener
            public void willMountItems(UIManager uiManager) {
                Intrinsics.checkNotNullParameter(uiManager, "uiManager");
            }

            @Override // com.facebook.react.bridge.UIManagerListener
            public void didMountItems(UIManager uiManager) {
                Intrinsics.checkNotNullParameter(uiManager, "uiManager");
                this.this$0.flushPendingAttaches();
            }
        };
    }

    static final void _init_$lambda$0(PseudoSelectorManager pseudoSelectorManager) {
        ReactApplicationContext reactApplicationContext = pseudoSelectorManager.reactContext.get();
        if (reactApplicationContext != null) {
            ExtraWindowObserverBridge extraWindowObserverBridge = new ExtraWindowObserverBridge(reactApplicationContext, pseudoSelectorManager.hover);
            extraWindowObserverBridge.install();
            pseudoSelectorManager.extraWindowBridge = extraWindowObserverBridge;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PseudoSelectorManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/swmansion/reanimated/pseudoSelectors/PseudoSelectorManager$PendingAttach;", "", "tag", "", "selector", "callback", "Lcom/swmansion/reanimated/nativeProxy/PseudoSelectorCallback;", "<init>", "(IILcom/swmansion/reanimated/nativeProxy/PseudoSelectorCallback;)V", "getTag", "()I", "getSelector", "getCallback", "()Lcom/swmansion/reanimated/nativeProxy/PseudoSelectorCallback;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    static final /* data */ class PendingAttach {
        private final PseudoSelectorCallback callback;
        private final int selector;
        private final int tag;

        public static /* synthetic */ PendingAttach copy$default(PendingAttach pendingAttach, int i, int i2, PseudoSelectorCallback pseudoSelectorCallback, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = pendingAttach.tag;
            }
            if ((i3 & 2) != 0) {
                i2 = pendingAttach.selector;
            }
            if ((i3 & 4) != 0) {
                pseudoSelectorCallback = pendingAttach.callback;
            }
            return pendingAttach.copy(i, i2, pseudoSelectorCallback);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTag() {
            return this.tag;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSelector() {
            return this.selector;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PseudoSelectorCallback getCallback() {
            return this.callback;
        }

        public final PendingAttach copy(int tag, int selector, PseudoSelectorCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            return new PendingAttach(tag, selector, callback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingAttach)) {
                return false;
            }
            PendingAttach pendingAttach = (PendingAttach) other;
            return this.tag == pendingAttach.tag && this.selector == pendingAttach.selector && Intrinsics.areEqual(this.callback, pendingAttach.callback);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.tag) * 31) + Integer.hashCode(this.selector)) * 31) + this.callback.hashCode();
        }

        public String toString() {
            return "PendingAttach(tag=" + this.tag + ", selector=" + this.selector + ", callback=" + this.callback + ")";
        }

        public PendingAttach(int i, int i2, PseudoSelectorCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.tag = i;
            this.selector = i2;
            this.callback = callback;
        }

        public final int getTag() {
            return this.tag;
        }

        public final int getSelector() {
            return this.selector;
        }

        public final PseudoSelectorCallback getCallback() {
            return this.callback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PseudoSelectorManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/swmansion/reanimated/pseudoSelectors/PseudoSelectorManager$HostGesture;", "", "leaf", "Landroid/view/View;", "downX", "", "downY", "<init>", "(Landroid/view/View;FF)V", "getLeaf", "()Landroid/view/View;", "getDownX", "()F", "getDownY", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    static final class HostGesture {
        private final float downX;
        private final float downY;
        private final View leaf;

        public HostGesture(View leaf, float f, float f2) {
            Intrinsics.checkNotNullParameter(leaf, "leaf");
            this.leaf = leaf;
            this.downX = f;
            this.downY = f2;
        }

        public final View getLeaf() {
            return this.leaf;
        }

        public final float getDownX() {
            return this.downX;
        }

        public final float getDownY() {
            return this.downY;
        }
    }

    public final void attach(final int tag, final int selector, final PseudoSelectorCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager.attach$lambda$0(this.f$0, tag, selector, callback);
            }
        });
    }

    static final void attach$lambda$0(PseudoSelectorManager pseudoSelectorManager, int i, int i2, PseudoSelectorCallback pseudoSelectorCallback) {
        View viewTryResolveView = pseudoSelectorManager.tryResolveView(i);
        if (viewTryResolveView != null) {
            pseudoSelectorManager.attachToView(viewTryResolveView, i, i2, pseudoSelectorCallback);
            return;
        }
        pseudoSelectorManager.pendingAttaches.put(i + ServerSentEventKt.COLON + i2, new PendingAttach(i, i2, pseudoSelectorCallback));
        pseudoSelectorManager.ensureMountListener();
    }

    private final void attachToView(final View view, int tag, int selector, PseudoSelectorCallback callback) {
        String str = tag + ServerSentEventKt.COLON + selector;
        if (selector == 0) {
            attachFocusListener(view, str, callback, new Function1() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(view.hasFocus());
                }
            });
            return;
        }
        if (selector == 1) {
            attachFocusListener(view, str, callback, new Function1() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(PseudoSelectorManager.attachToView$lambda$1(view, (View) obj));
                }
            });
            return;
        }
        if (selector == 2) {
            attachHover(view, str, callback);
        } else if (selector == 3) {
            attachPressSelector(view, str, callback, this.activeCallbacks);
        } else {
            if (selector != 4) {
                return;
            }
            attachPressSelector(view, str, callback, this.deepestCallbacks);
        }
    }

    private final View tryResolveView(int tag) {
        try {
            return this.fabricUIManager.resolveView(tag);
        } catch (IllegalViewOperationException unused) {
            return null;
        }
    }

    private final void ensureMountListener() {
        if (this.mountListenerRegistered) {
            return;
        }
        this.mountListenerRegistered = true;
        this.fabricUIManager.addUIManagerEventListener(this.mountListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushPendingAttaches() {
        if (this.pendingAttaches.isEmpty()) {
            return;
        }
        Iterator<PendingAttach> it = this.pendingAttaches.values().iterator();
        while (it.hasNext()) {
            PendingAttach next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            PendingAttach pendingAttach = next;
            View viewTryResolveView = tryResolveView(pendingAttach.getTag());
            if (viewTryResolveView != null) {
                it.remove();
                attachToView(viewTryResolveView, pendingAttach.getTag(), pendingAttach.getSelector(), pendingAttach.getCallback());
            }
        }
    }

    private final void attachFocusListener(final View view, String key, final PseudoSelectorCallback callback, final Function1<? super View, Boolean> isFocused) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda9
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view2, View view3) {
                PseudoSelectorManager.attachFocusListener$lambda$0(isFocused, booleanRef, callback, view2, view3);
            }
        };
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
        this.focusDetachActions.put(key, new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                view.getViewTreeObserver().removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
            }
        });
    }

    static final void attachFocusListener$lambda$0(Function1 function1, Ref.BooleanRef booleanRef, PseudoSelectorCallback pseudoSelectorCallback, View view, View view2) {
        boolean zBooleanValue = ((Boolean) function1.invoke(view2)).booleanValue();
        if (zBooleanValue != booleanRef.element) {
            booleanRef.element = zBooleanValue;
            pseudoSelectorCallback.onSelectorStateChanged(zBooleanValue);
        }
    }

    private final void attachHover(final View view, String key, PseudoSelectorCallback callback) {
        final View viewFindTouchHost = findTouchHost(view);
        acquireTouchListener(viewFindTouchHost);
        this.hover.register(view, viewFindTouchHost, callback);
        this.detachActions.put(key, new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager.attachHover$lambda$0(this.f$0, view, viewFindTouchHost);
            }
        });
    }

    static final void attachHover$lambda$0(PseudoSelectorManager pseudoSelectorManager, View view, View view2) {
        pseudoSelectorManager.hover.unregister(view, view2);
        pseudoSelectorManager.releaseTouchListener(view2);
    }

    private final void attachPressSelector(final View view, String key, PseudoSelectorCallback callback, final Map<View, PseudoSelectorCallback> callbacks) {
        final View viewFindTouchHost = findTouchHost(view);
        callbacks.put(view, callback);
        acquireTouchListener(viewFindTouchHost);
        this.hover.retainWindowObserver(view);
        this.detachActions.put(key, new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager.attachPressSelector$lambda$0(callbacks, view, this, viewFindTouchHost);
            }
        });
    }

    static final void attachPressSelector$lambda$0(Map map, View view, PseudoSelectorManager pseudoSelectorManager, View view2) {
        map.remove(view);
        pseudoSelectorManager.releaseTouchListener(view2);
        pseudoSelectorManager.hover.releaseWindowObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWindowPressTouch(ViewGroup root, MotionEvent event) {
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            windowPressDown(root, event);
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                Set<View> setKeySet = this.gestureByHost.keySet();
                Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
                for (View view : CollectionsKt.toList(setKeySet)) {
                    Intrinsics.checkNotNull(view);
                    onHostMove(view, event);
                }
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked == 6 && event.getPointerId(event.getActionIndex()) == 0) {
                    releaseAllHostGestures();
                    return;
                }
                return;
            }
        }
        releaseAllHostGestures();
    }

    private final void windowPressDown(ViewGroup root, MotionEvent event) {
        View view;
        View viewFindTouchedLeaf;
        if (root != null) {
            if (this.activeCallbacks.isEmpty() && this.deepestCallbacks.isEmpty()) {
                return;
            }
            Map<Integer, View> mapPressHostsById = pressHostsById();
            List<Integer> listHitTestTagsAt = this.hover.hitTestTagsAt(root, event.getRawX(), event.getRawY());
            Iterator<T> it = listHitTestTagsAt.iterator();
            do {
                if (!it.hasNext()) {
                    view = null;
                    break;
                }
                view = mapPressHostsById.get(Integer.valueOf(((Number) it.next()).intValue()));
            } while (view == null);
            View view2 = view;
            if (view2 == null || this.gestureByHost.containsKey(view2) || (viewFindTouchedLeaf = findTouchedLeaf(view2, listHitTestTagsAt)) == null) {
                return;
            }
            beginPress(view2, viewFindTouchedLeaf, event.getRawX(), event.getRawY(), listHitTestTagsAt);
        }
    }

    private final void beginPress(View host, View leaf, float rawX, float rawY, List<Integer> hitTags) {
        this.gestureByHost.put(host, new HostGesture(leaf, rawX, rawY));
        fireActiveCallbacksUpTree(leaf, true);
        fireDeepestIfHit(leaf, hitTags);
    }

    private final Map<Integer, View> pressHostsById() {
        Set<View> setKeySet = this.activeCallbacks.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        Set<View> setKeySet2 = this.deepestCallbacks.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet2, "<get-keys>(...)");
        Set<View> setPlus = SetsKt.plus((Set) setKeySet, (Iterable) setKeySet2);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setPlus, 10));
        for (View view : setPlus) {
            Intrinsics.checkNotNull(view);
            arrayList.add(findTouchHost(view));
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj : arrayList2) {
            linkedHashMap.put(Integer.valueOf(((View) obj).getId()), obj);
        }
        return linkedHashMap;
    }

    private final View findTouchedLeaf(View host, List<Integer> hitTags) {
        if (!(host instanceof ReactCompoundView)) {
            return host;
        }
        Integer num = (Integer) CollectionsKt.firstOrNull((List) hitTags);
        if (num != null) {
            return tryResolveView(num.intValue());
        }
        return null;
    }

    private final void releaseAllHostGestures() {
        Set<View> setKeySet = this.gestureByHost.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        for (View view : CollectionsKt.toList(setKeySet)) {
            Intrinsics.checkNotNull(view);
            onHostRelease(view);
        }
    }

    private final View findTouchHost(View view) {
        for (Object parent = view.getParent(); parent instanceof View; parent = ((View) parent).getParent()) {
            if (parent instanceof ReactCompoundView) {
                return (View) parent;
            }
        }
        return view;
    }

    private final void acquireTouchListener(final View host) {
        Integer orDefault = this.touchHostRefs.getOrDefault(host, 0);
        Intrinsics.checkNotNullExpressionValue(orDefault, "getOrDefault(...)");
        int iIntValue = orDefault.intValue();
        this.touchHostRefs.put(host, Integer.valueOf(iIntValue + 1));
        if (iIntValue == 0) {
            host.setOnTouchListener(new View.OnTouchListener() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return PseudoSelectorManager.acquireTouchListener$lambda$0(this.f$0, host, view, motionEvent);
                }
            });
        }
    }

    static final boolean acquireTouchListener$lambda$0(PseudoSelectorManager pseudoSelectorManager, View view, View view2, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(motionEvent);
        return pseudoSelectorManager.onHostTouch(view, motionEvent);
    }

    private final void releaseTouchListener(View host) {
        Integer orDefault = this.touchHostRefs.getOrDefault(host, 0);
        Intrinsics.checkNotNullExpressionValue(orDefault, "getOrDefault(...)");
        int iIntValue = orDefault.intValue();
        HashMap<View, Integer> map = this.touchHostRefs;
        if (iIntValue > 1) {
            map.put(host, Integer.valueOf(iIntValue - 1));
            return;
        }
        map.remove(host);
        onHostRelease(host);
        host.setOnTouchListener(null);
    }

    private final boolean onHostTouch(View host, MotionEvent event) {
        if (this.hover.isWindowObserved(host)) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6 && event.getPointerId(event.getActionIndex()) == 0) {
                            onHostRelease(host);
                            this.hover.onViewTouchUp(host, event);
                        }
                    } else if (event.findPointerIndex(0) >= 0) {
                        onHostRelease(host);
                        this.hover.onViewTouchCancel(host, event);
                    }
                } else if (event.findPointerIndex(0) >= 0) {
                    onHostMove(host, event);
                }
            } else if (event.findPointerIndex(0) >= 0) {
                onHostRelease(host);
                this.hover.onViewTouchUp(host, event);
            }
        } else if (!this.hover.isGestureSettled(event)) {
            onHostDown(host, event);
        }
        return false;
    }

    private final void onHostDown(View host, MotionEvent event) {
        PseudoSelectorManager pseudoSelectorManager;
        View view;
        List<Integer> listHitTestTagsAt = this.hover.hitTestTagsAt(host, event.getRawX(), event.getRawY());
        View viewFindTouchedLeaf = findTouchedLeaf(host, listHitTestTagsAt);
        if (viewFindTouchedLeaf != null) {
            pseudoSelectorManager = this;
            view = host;
            pseudoSelectorManager.beginPress(view, viewFindTouchedLeaf, event.getRawX(), event.getRawY(), listHitTestTagsAt);
        } else {
            pseudoSelectorManager = this;
            view = host;
        }
        pseudoSelectorManager.hover.recompute(view, event.getRawX(), event.getRawY());
    }

    private final void onHostMove(View host, MotionEvent event) {
        HostGesture hostGesture = this.gestureByHost.get(host);
        if (hostGesture == null) {
            return;
        }
        float rawX = event.getRawX() - hostGesture.getDownX();
        float rawY = event.getRawY() - hostGesture.getDownY();
        float scaledTouchSlop = ViewConfiguration.get(host.getContext()).getScaledTouchSlop();
        if ((rawX * rawX) + (rawY * rawY) > scaledTouchSlop * scaledTouchSlop) {
            onHostRelease(host);
        }
    }

    private final void onHostRelease(View host) {
        View leaf;
        HostGesture hostGestureRemove = this.gestureByHost.remove(host);
        if (hostGestureRemove == null || (leaf = hostGestureRemove.getLeaf()) == null) {
            return;
        }
        fireActiveCallbacksUpTree(leaf, false);
        PseudoSelectorCallback pseudoSelectorCallback = this.deepestCallbacks.get(leaf);
        if (pseudoSelectorCallback != null) {
            pseudoSelectorCallback.onSelectorStateChanged(false);
        }
    }

    private final void fireDeepestIfHit(View leaf, List<Integer> hitTags) {
        PseudoSelectorCallback pseudoSelectorCallback = this.deepestCallbacks.get(leaf);
        if (pseudoSelectorCallback == null || hasDeepestDescendantAt(leaf, hitTags)) {
            return;
        }
        pseudoSelectorCallback.onSelectorStateChanged(true);
    }

    public final void detach(final int tag, final int selector) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager.detach$lambda$0(tag, selector, this);
            }
        });
    }

    static final void detach$lambda$0(int i, int i2, PseudoSelectorManager pseudoSelectorManager) {
        String str = i + ServerSentEventKt.COLON + i2;
        pseudoSelectorManager.pendingAttaches.remove(str);
        Runnable runnableRemove = pseudoSelectorManager.focusDetachActions.remove(str);
        if (runnableRemove != null) {
            runnableRemove.run();
        }
        Runnable runnableRemove2 = pseudoSelectorManager.detachActions.remove(str);
        if (runnableRemove2 != null) {
            runnableRemove2.run();
        }
    }

    public final void invalidate() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager.invalidate$lambda$0(this.f$0);
            }
        });
    }

    static final void invalidate$lambda$0(PseudoSelectorManager pseudoSelectorManager) {
        pseudoSelectorManager.fabricUIManager.removeUIManagerEventListener(pseudoSelectorManager.mountListener);
        pseudoSelectorManager.mountListenerRegistered = false;
        ExtraWindowObserverBridge extraWindowObserverBridge = pseudoSelectorManager.extraWindowBridge;
        if (extraWindowObserverBridge != null) {
            extraWindowObserverBridge.uninstall();
        }
        pseudoSelectorManager.extraWindowBridge = null;
        pseudoSelectorManager.hover.uninstall();
        Set<View> setKeySet = pseudoSelectorManager.touchHostRefs.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnTouchListener(null);
        }
        pseudoSelectorManager.touchHostRefs.clear();
        pseudoSelectorManager.gestureByHost.clear();
        pseudoSelectorManager.activeCallbacks.clear();
        pseudoSelectorManager.deepestCallbacks.clear();
        pseudoSelectorManager.pendingAttaches.clear();
        Collection<Runnable> collectionValues = pseudoSelectorManager.focusDetachActions.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator<T> it2 = collectionValues.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
        pseudoSelectorManager.focusDetachActions.clear();
        pseudoSelectorManager.detachActions.clear();
    }

    private final boolean hasDeepestDescendantAt(View ancestor, List<Integer> hitTags) {
        Set<View> setKeySet = this.deepestCallbacks.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        Set<View> set = setKeySet;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (View view : set) {
            if (view != ancestor && hitTags.contains(Integer.valueOf(view.getId()))) {
                Intrinsics.checkNotNull(view);
                if (isDescendantOf(view, ancestor)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void fireActiveCallbacksUpTree(View source, boolean isActive) {
        PseudoSelectorCallback pseudoSelectorCallback;
        PseudoSelectorCallback pseudoSelectorCallback2 = this.activeCallbacks.get(source);
        if (pseudoSelectorCallback2 != null) {
            pseudoSelectorCallback2.onSelectorStateChanged(isActive);
        }
        for (ViewParent parent = source.getParent(); parent != null; parent = parent.getParent()) {
            if ((parent instanceof View) && (pseudoSelectorCallback = this.activeCallbacks.get(parent)) != null) {
                pseudoSelectorCallback.onSelectorStateChanged(isActive);
            }
        }
    }

    private final boolean isDescendantOf(View view, View ancestor) {
        Object parent = view.getParent();
        while (parent != null) {
            if (parent == ancestor) {
                return true;
            }
            View view2 = parent instanceof View ? (View) parent : null;
            parent = view2 != null ? view2.getParent() : null;
        }
        return false;
    }
}
