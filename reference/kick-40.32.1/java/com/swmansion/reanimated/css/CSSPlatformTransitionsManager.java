package com.swmansion.reanimated.css;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ViewProps;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CSSPlatformTransitionsManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\b*\u0001\u0016\b\u0000\u0018\u00002\u00020\u0001:\u0004NOPQB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJF\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u0014J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020)J\u0006\u00108\u001a\u000205J\u0016\u00109\u001a\u0002052\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)J\u0010\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020$H\u0002J\u0010\u0010<\u001a\u0002052\u0006\u0010=\u001a\u00020\u000eH\u0002J\u0010\u0010>\u001a\u0002052\u0006\u0010;\u001a\u00020\u001fH\u0002J\u0010\u0010?\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u001fH\u0002J\b\u0010@\u001a\u000205H\u0002J\u0018\u0010A\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010;\u001a\u00020\u001fH\u0002J\u0006\u0010D\u001a\u000205J\b\u0010E\u001a\u00020\u0014H\u0002J\b\u0010F\u001a\u000205H\u0002J&\u0010G\u001a\u0002052\u0006\u00102\u001a\u00020)2\u0006\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JJ\u000e\u0010L\u001a\u0002052\u0006\u00102\u001a\u00020)J\u0012\u0010M\u001a\u0004\u0018\u00010C2\u0006\u0010,\u001a\u00020)H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\n\n\u0002\u0010\u0019\u0012\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001f` X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager;", "", "fabricUIManager", "Lcom/facebook/react/fabric/FabricUIManager;", "reactContext", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "getAnimationTimestamp", "Lkotlin/Function0;", "", "<init>", "(Lcom/facebook/react/fabric/FabricUIManager;Ljava/lang/ref/WeakReference;Lkotlin/jvm/functions/Function0;)V", "animators", "Ljava/util/HashMap;", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Key;", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$RunningTransition;", "Lkotlin/collections/HashMap;", "slowAnimationsDragFactor", "", "reactWroteSinceLastDraw", "", "mountListener", "com/swmansion/reanimated/css/CSSPlatformTransitionsManager$mountListener$1", "getMountListener$annotations", "()V", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$mountListener$1;", "reconciler", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionReconciler;", "invalidated", "pendingStarts", "Ljava/util/LinkedHashMap;", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Command$Start;", "Lkotlin/collections/LinkedHashMap;", "retryScheduled", "commands", "Lcom/swmansion/reanimated/css/MainThreadCommandQueue;", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Command;", "mainHandler", "Landroid/os/Handler;", "easings", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroid/animation/TimeInterpolator;", "animateTransition", "viewTag", "propertyId", "fromValue", "toValue", "durationMs", "startTimestampMs", "easingId", "persistent", "enableSlowAnimations", "", "slowAnimationsEnabled", "animationsDragFactor", "invalidate", "removeTransition", "executeCommand", "command", "removeNow", "key", "beginStart", "startIfMounted", "scheduleRetry", ViewProps.START, "view", "Landroid/view/View;", "onPropsWrittenSynchronously", "onPreDraw", "repairClobberedValues", "defineEasing", "easingType", "easingPointsX", "", "easingPointsY", "undefineEasing", "viewForTag", "Key", "RunningTransition", "Command", "HoldThenEase", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CSSPlatformTransitionsManager {
    private final HashMap<Key, RunningTransition> animators;
    private final MainThreadCommandQueue<Command> commands;
    private final ConcurrentHashMap<Integer, TimeInterpolator> easings;
    private final FabricUIManager fabricUIManager;
    private final Function0<Long> getAnimationTimestamp;
    private volatile boolean invalidated;
    private final Handler mainHandler;
    private final CSSPlatformTransitionsManager$mountListener$1 mountListener;
    private final LinkedHashMap<Key, Command.Start> pendingStarts;
    private final WeakReference<ReactApplicationContext> reactContext;
    private boolean reactWroteSinceLastDraw;
    private final CSSPlatformTransitionReconciler reconciler;
    private boolean retryScheduled;
    private double slowAnimationsDragFactor;

    private static /* synthetic */ void getMountListener$annotations() {
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.swmansion.reanimated.css.CSSPlatformTransitionsManager$mountListener$1] */
    public CSSPlatformTransitionsManager(FabricUIManager fabricUIManager, WeakReference<ReactApplicationContext> reactContext, Function0<Long> getAnimationTimestamp) {
        Intrinsics.checkNotNullParameter(fabricUIManager, "fabricUIManager");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(getAnimationTimestamp, "getAnimationTimestamp");
        this.fabricUIManager = fabricUIManager;
        this.reactContext = reactContext;
        this.getAnimationTimestamp = getAnimationTimestamp;
        this.animators = new HashMap<>();
        this.slowAnimationsDragFactor = 1.0d;
        this.reactWroteSinceLastDraw = true;
        ?? r3 = new UIManagerListener() { // from class: com.swmansion.reanimated.css.CSSPlatformTransitionsManager$mountListener$1
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
                this.this$0.reactWroteSinceLastDraw = true;
            }
        };
        this.mountListener = r3;
        fabricUIManager.addUIManagerEventListener((UIManagerListener) r3);
        this.reconciler = new CSSPlatformTransitionReconciler(new CSSPlatformTransitionsManager$reconciler$1(this));
        this.pendingStarts = new LinkedHashMap<>();
        this.commands = new MainThreadCommandQueue<>(new CSSPlatformTransitionsManager$commands$1(this));
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.easings = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CSSPlatformTransitionsManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Key;", "", "viewTag", "", "propertyId", "<init>", "(II)V", "getViewTag", "()I", "getPropertyId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    static final /* data */ class Key {
        private final int propertyId;
        private final int viewTag;

        public static /* synthetic */ Key copy$default(Key key, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = key.viewTag;
            }
            if ((i3 & 2) != 0) {
                i2 = key.propertyId;
            }
            return key.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getViewTag() {
            return this.viewTag;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPropertyId() {
            return this.propertyId;
        }

        public final Key copy(int viewTag, int propertyId) {
            return new Key(viewTag, propertyId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Key)) {
                return false;
            }
            Key key = (Key) other;
            return this.viewTag == key.viewTag && this.propertyId == key.propertyId;
        }

        public int hashCode() {
            return (Integer.hashCode(this.viewTag) * 31) + Integer.hashCode(this.propertyId);
        }

        public String toString() {
            return "Key(viewTag=" + this.viewTag + ", propertyId=" + this.propertyId + ")";
        }

        public Key(int i, int i2) {
            this.viewTag = i;
            this.propertyId = i2;
        }

        public final int getViewTag() {
            return this.viewTag;
        }

        public final int getPropertyId() {
            return this.propertyId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CSSPlatformTransitionsManager.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$RunningTransition;", "", "animator", "Landroid/animation/ObjectAnimator;", "writer", "Lcom/swmansion/reanimated/css/CSSPropertyWriter;", "startValue", "", "<init>", "(Landroid/animation/ObjectAnimator;Lcom/swmansion/reanimated/css/CSSPropertyWriter;F)V", "getAnimator", "()Landroid/animation/ObjectAnimator;", "getWriter", "()Lcom/swmansion/reanimated/css/CSSPropertyWriter;", "getStartValue", "()F", "heldValue", "getHeldValue", "()Ljava/lang/Float;", "setHeldValue", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "currentValue", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    static final class RunningTransition {
        private final ObjectAnimator animator;
        private Float heldValue;
        private final float startValue;
        private final CSSPropertyWriter writer;

        public RunningTransition(ObjectAnimator animator, CSSPropertyWriter writer, float f) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            Intrinsics.checkNotNullParameter(writer, "writer");
            this.animator = animator;
            this.writer = writer;
            this.startValue = f;
        }

        public final ObjectAnimator getAnimator() {
            return this.animator;
        }

        public final CSSPropertyWriter getWriter() {
            return this.writer;
        }

        public final float getStartValue() {
            return this.startValue;
        }

        public final Float getHeldValue() {
            return this.heldValue;
        }

        public final void setHeldValue(Float f) {
            this.heldValue = f;
        }

        public final float currentValue() {
            Float f = this.heldValue;
            if (f != null) {
                return f.floatValue();
            }
            if (!this.animator.isRunning()) {
                return this.startValue;
            }
            Object animatedValue = this.animator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            return ((Float) animatedValue).floatValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CSSPlatformTransitionsManager.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Command;", "", "<init>", "()V", "key", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Key;", "getKey", "()Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Key;", "Start", "Remove", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Command$Remove;", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Command$Start;", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    static abstract class Command {
        public /* synthetic */ Command(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Key getKey();

        private Command() {
        }

        /* JADX INFO: compiled from: CSSPlatformTransitionsManager.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b#\u0010\u0018¨\u0006$"}, d2 = {"Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Command$Start;", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Command;", "key", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Key;", "writer", "Lcom/swmansion/reanimated/css/CSSPropertyWriter;", "fromValue", "", "toValue", "durationMs", "startTimestampMs", "interpolator", "Landroid/animation/TimeInterpolator;", "scale", "", "persistent", "", "<init>", "(Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Key;Lcom/swmansion/reanimated/css/CSSPropertyWriter;DDDDLandroid/animation/TimeInterpolator;FZ)V", "getKey", "()Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Key;", "getWriter", "()Lcom/swmansion/reanimated/css/CSSPropertyWriter;", "getFromValue", "()D", "getToValue", "getDurationMs", "getStartTimestampMs", "getInterpolator", "()Landroid/animation/TimeInterpolator;", "getScale", "()F", "getPersistent", "()Z", "endTimestampMs", "getEndTimestampMs", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Start extends Command {
            private final double durationMs;
            private final double fromValue;
            private final TimeInterpolator interpolator;
            private final Key key;
            private final boolean persistent;
            private final float scale;
            private final double startTimestampMs;
            private final double toValue;
            private final CSSPropertyWriter writer;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Start(Key key, CSSPropertyWriter writer, double d, double d2, double d3, double d4, TimeInterpolator interpolator, float f, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(interpolator, "interpolator");
                this.key = key;
                this.writer = writer;
                this.fromValue = d;
                this.toValue = d2;
                this.durationMs = d3;
                this.startTimestampMs = d4;
                this.interpolator = interpolator;
                this.scale = f;
                this.persistent = z;
            }

            @Override // com.swmansion.reanimated.css.CSSPlatformTransitionsManager.Command
            public Key getKey() {
                return this.key;
            }

            public final CSSPropertyWriter getWriter() {
                return this.writer;
            }

            public final double getFromValue() {
                return this.fromValue;
            }

            public final double getToValue() {
                return this.toValue;
            }

            public final double getDurationMs() {
                return this.durationMs;
            }

            public final double getStartTimestampMs() {
                return this.startTimestampMs;
            }

            public final TimeInterpolator getInterpolator() {
                return this.interpolator;
            }

            public final float getScale() {
                return this.scale;
            }

            public final boolean getPersistent() {
                return this.persistent;
            }

            public final double getEndTimestampMs() {
                return this.startTimestampMs + this.durationMs;
            }
        }

        /* JADX INFO: compiled from: CSSPlatformTransitionsManager.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Command$Remove;", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Command;", "key", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Key;", "<init>", "(Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Key;)V", "getKey", "()Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Key;", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Remove extends Command {
            private final Key key;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Remove(Key key) {
                super(null);
                Intrinsics.checkNotNullParameter(key, "key");
                this.key = key;
            }

            @Override // com.swmansion.reanimated.css.CSSPlatformTransitionsManager.Command
            public Key getKey() {
                return this.key;
            }
        }
    }

    /* JADX INFO: compiled from: CSSPlatformTransitionsManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$HoldThenEase;", "Landroid/animation/TimeInterpolator;", "delayFraction", "", "inner", "<init>", "(FLandroid/animation/TimeInterpolator;)V", "getInterpolation", "input", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class HoldThenEase implements TimeInterpolator {
        private final float delayFraction;
        private final TimeInterpolator inner;

        public HoldThenEase(float f, TimeInterpolator inner) {
            Intrinsics.checkNotNullParameter(inner, "inner");
            this.delayFraction = f;
            this.inner = inner;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            float f = this.delayFraction;
            if (input < f) {
                return 0.0f;
            }
            if (f >= 1.0f) {
                return 1.0f;
            }
            return this.inner.getInterpolation((input - f) / (1.0f - f));
        }
    }

    public final boolean animateTransition(int viewTag, int propertyId, double fromValue, double toValue, double durationMs, double startTimestampMs, int easingId, boolean persistent) {
        CSSPropertyWriter cSSPropertyWriterCssPropertyWriterFor;
        TimeInterpolator timeInterpolator;
        ReactApplicationContext reactApplicationContext;
        if (this.invalidated || (cSSPropertyWriterCssPropertyWriterFor = CSSPropertyWriterKt.cssPropertyWriterFor(propertyId, fromValue, toValue)) == null || (timeInterpolator = this.easings.get(Integer.valueOf(easingId))) == null || (reactApplicationContext = this.reactContext.get()) == null) {
            return false;
        }
        float fEffectiveScale = DurationScale.INSTANCE.effectiveScale(reactApplicationContext);
        if (fEffectiveScale <= 0.0f) {
            return false;
        }
        Pair<Double, Double> pairAnimatorEndpoints = cSSPropertyWriterCssPropertyWriterFor.animatorEndpoints(fromValue, toValue);
        this.commands.enqueue(new Command.Start(new Key(viewTag, propertyId), cSSPropertyWriterCssPropertyWriterFor, pairAnimatorEndpoints.component1().doubleValue(), pairAnimatorEndpoints.component2().doubleValue(), durationMs, startTimestampMs, timeInterpolator, fEffectiveScale, persistent));
        return true;
    }

    public final void enableSlowAnimations(boolean slowAnimationsEnabled, int animationsDragFactor) {
        this.slowAnimationsDragFactor = slowAnimationsEnabled ? animationsDragFactor : 1.0d;
    }

    public final void invalidate() {
        this.invalidated = true;
        this.fabricUIManager.removeUIManagerEventListener(this.mountListener);
        this.mainHandler.post(new Runnable() { // from class: com.swmansion.reanimated.css.CSSPlatformTransitionsManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CSSPlatformTransitionsManager.invalidate$lambda$0(this.f$0);
            }
        });
    }

    static final void invalidate$lambda$0(CSSPlatformTransitionsManager cSSPlatformTransitionsManager) {
        cSSPlatformTransitionsManager.pendingStarts.clear();
        Collection<RunningTransition> collectionValues = cSSPlatformTransitionsManager.animators.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        List list = CollectionsKt.toList(collectionValues);
        cSSPlatformTransitionsManager.animators.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RunningTransition) it.next()).getAnimator().cancel();
        }
        cSSPlatformTransitionsManager.reconciler.invalidate();
        cSSPlatformTransitionsManager.easings.clear();
    }

    public final void removeTransition(int viewTag, int propertyId) {
        if (this.invalidated) {
            return;
        }
        this.commands.enqueue(new Command.Remove(new Key(viewTag, propertyId)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void executeCommand(Command command) {
        if (this.invalidated) {
            return;
        }
        if (command instanceof Command.Start) {
            beginStart((Command.Start) command);
        } else {
            if (!(command instanceof Command.Remove)) {
                throw new NoWhenBranchMatchedException();
            }
            removeNow(((Command.Remove) command).getKey());
        }
    }

    private final void removeNow(Key key) {
        ObjectAnimator animator;
        this.pendingStarts.remove(key);
        RunningTransition runningTransitionRemove = this.animators.remove(key);
        if (runningTransitionRemove == null || (animator = runningTransitionRemove.getAnimator()) == null) {
            return;
        }
        animator.cancel();
    }

    private final void beginStart(Command.Start command) {
        if (startIfMounted(command) || this.getAnimationTimestamp.invoke().longValue() >= command.getEndTimestampMs()) {
            this.pendingStarts.remove(command.getKey());
        } else {
            this.pendingStarts.put(command.getKey(), command);
            scheduleRetry();
        }
    }

    private final boolean startIfMounted(Command.Start command) {
        View viewViewForTag = viewForTag(command.getKey().getViewTag());
        if (viewViewForTag == null) {
            return false;
        }
        start(viewViewForTag, command);
        return true;
    }

    private final void scheduleRetry() {
        if (this.retryScheduled) {
            return;
        }
        this.retryScheduled = true;
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.swmansion.reanimated.css.CSSPlatformTransitionsManager$$ExternalSyntheticLambda1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                CSSPlatformTransitionsManager.scheduleRetry$lambda$0(this.f$0, j);
            }
        });
    }

    static final void scheduleRetry$lambda$0(CSSPlatformTransitionsManager cSSPlatformTransitionsManager, long j) {
        cSSPlatformTransitionsManager.retryScheduled = false;
        if (cSSPlatformTransitionsManager.invalidated) {
            cSSPlatformTransitionsManager.pendingStarts.clear();
            return;
        }
        long jLongValue = cSSPlatformTransitionsManager.getAnimationTimestamp.invoke().longValue();
        Iterator<Map.Entry<Key, Command.Start>> it = cSSPlatformTransitionsManager.pendingStarts.entrySet().iterator();
        while (it.hasNext()) {
            Command.Start value = it.next().getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
            Command.Start start = value;
            if (cSSPlatformTransitionsManager.startIfMounted(start) || jLongValue >= start.getEndTimestampMs()) {
                it.remove();
            }
        }
        if (cSSPlatformTransitionsManager.pendingStarts.isEmpty()) {
            return;
        }
        cSSPlatformTransitionsManager.scheduleRetry();
    }

    private final void start(View view, final Command.Start command) {
        ObjectAnimator animator;
        final Key key = command.getKey();
        CSSPropertyWriter writer = command.getWriter();
        double durationMs = command.getDurationMs();
        HoldThenEase interpolator = command.getInterpolator();
        RunningTransition runningTransitionRemove = this.animators.remove(key);
        float fResumeFrom = runningTransitionRemove != null ? writer.resumeFrom(view) : (float) command.getFromValue();
        if (runningTransitionRemove != null && (animator = runningTransitionRemove.getAnimator()) != null) {
            animator.cancel();
        }
        double dLongValue = this.getAnimationTimestamp.invoke().longValue() - command.getStartTimestampMs();
        if (dLongValue < durationMs) {
            writer.setValue(view, fResumeFrom);
        }
        final ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, writer, fResumeFrom, (float) command.getToValue());
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.swmansion.reanimated.css.CSSPlatformTransitionsManager.start.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                RunningTransition runningTransition = (RunningTransition) CSSPlatformTransitionsManager.this.animators.get(key);
                if (runningTransition != null && runningTransition.getAnimator() == animation) {
                    if (!command.getPersistent()) {
                        CSSPlatformTransitionsManager.this.animators.remove(key);
                        return;
                    }
                    Object animatedValue = objectAnimatorOfFloat.getAnimatedValue();
                    Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                    runningTransition.setHeldValue((Float) animatedValue);
                }
            }
        });
        double d = dLongValue < 0.0d ? -dLongValue : 0.0d;
        double d2 = d + durationMs;
        objectAnimatorOfFloat.setDuration(RangesKt.coerceAtLeast((long) ((this.slowAnimationsDragFactor * d2) / ((double) command.getScale())), 1L));
        if (d > 0.0d) {
            interpolator = new HoldThenEase((float) (d / d2), interpolator);
        }
        objectAnimatorOfFloat.setInterpolator(interpolator);
        if (dLongValue > 0.0d && durationMs > 0.0d) {
            objectAnimatorOfFloat.setCurrentFraction(RangesKt.coerceIn((float) (dLongValue / durationMs), 0.0f, 1.0f));
        }
        objectAnimatorOfFloat.start();
        HashMap<Key, RunningTransition> map = this.animators;
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        map.put(key, new RunningTransition(objectAnimatorOfFloat, writer, fResumeFrom));
        this.reconciler.track(view);
    }

    public final void onPropsWrittenSynchronously() {
        this.reactWroteSinceLastDraw = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onPreDraw() {
        this.commands.drain();
        repairClobberedValues();
        return !this.invalidated;
    }

    private final void repairClobberedValues() {
        if (this.reactWroteSinceLastDraw) {
            this.reactWroteSinceLastDraw = false;
            Collection<RunningTransition> collectionValues = this.animators.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
            for (RunningTransition runningTransition : collectionValues) {
                Object target = runningTransition.getAnimator().getTarget();
                View view = target instanceof View ? (View) target : null;
                if (view != null) {
                    float fCurrentValue = runningTransition.currentValue();
                    if (!runningTransition.getWriter().matches(view, fCurrentValue)) {
                        runningTransition.getWriter().setValue(view, fCurrentValue);
                    }
                }
            }
        }
    }

    public final void defineEasing(int easingId, int easingType, float[] easingPointsX, float[] easingPointsY) {
        Intrinsics.checkNotNullParameter(easingPointsX, "easingPointsX");
        Intrinsics.checkNotNullParameter(easingPointsY, "easingPointsY");
        this.easings.put(Integer.valueOf(easingId), CSSEasing.INSTANCE.interpolator(easingType, easingPointsX, easingPointsY));
    }

    public final void undefineEasing(int easingId) {
        this.easings.remove(Integer.valueOf(easingId));
    }

    private final View viewForTag(int viewTag) {
        try {
            return this.fabricUIManager.resolveView(viewTag);
        } catch (IllegalViewOperationException unused) {
            return null;
        }
    }
}
