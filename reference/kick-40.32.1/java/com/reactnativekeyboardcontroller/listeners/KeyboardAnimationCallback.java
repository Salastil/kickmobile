package com.reactnativekeyboardcontroller.listeners;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.constants.UIThread;
import com.reactnativekeyboardcontroller.events.KeyboardTransitionEvent;
import com.reactnativekeyboardcontroller.extensions.EditTextKt;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.extensions.ThemedReactContextKt;
import com.reactnativekeyboardcontroller.extensions.WindowInsetsAnimationCompatKt;
import com.reactnativekeyboardcontroller.interactive.InteractiveKeyboardProvider;
import com.reactnativekeyboardcontroller.log.Logger;
import com.reactnativekeyboardcontroller.traversal.FocusedInputHolder;
import io.ktor.sse.ServerSentEventKt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: KeyboardAnimationCallback.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u000202H\u0016J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\"H\u0016J\u0018\u00108\u001a\u0002092\u0006\u00107\u001a\u00020\"2\u0006\u0010:\u001a\u000209H\u0016J\u001e\u0010;\u001a\u0002022\u0006\u00104\u001a\u0002022\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\"0=H\u0016J\u0010\u0010>\u001a\u0002062\u0006\u00107\u001a\u00020\"H\u0016J#\u0010?\u001a\u0002062\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010BJ\u0006\u0010C\u001a\u000206J\u0010\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0014\u0010F\u001a\u00020\u00172\n\b\u0002\u00104\u001a\u0004\u0018\u000102H\u0002J\b\u0010G\u001a\u000206H\u0002J\u0010\u0010H\u001a\u00020I2\u0006\u0010@\u001a\u00020\u0017H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010%\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006J"}, d2 = {"Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallback;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Lcom/reactnativekeyboardcontroller/listeners/Suspendable;", "eventPropagationView", "Lcom/facebook/react/views/view/ReactViewGroup;", "view", "Landroid/view/View;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/react/uimanager/ThemedReactContext;", "config", "Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallbackConfig;", "<init>", "(Lcom/facebook/react/views/view/ReactViewGroup;Landroid/view/View;Lcom/facebook/react/uimanager/ThemedReactContext;Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallbackConfig;)V", "getEventPropagationView", "()Lcom/facebook/react/views/view/ReactViewGroup;", "getView", "()Landroid/view/View;", "getContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "surfaceId", "", "persistentKeyboardHeight", "", "prevKeyboardHeight", "isKeyboardVisible", "", "isTransitioning", "duration", "viewTagFocused", "pendingStartEvent", "Lcom/reactnativekeyboardcontroller/listeners/PendingKeyboardStartEvent;", "animationsToSkip", "Ljava/util/HashSet;", "Landroidx/core/view/WindowInsetsAnimationCompat;", "Lkotlin/collections/HashSet;", "isKeyboardInteractive", "()Z", "isSuspended", "setSuspended", "(Z)V", "focusListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "layoutObserver", "Lcom/reactnativekeyboardcontroller/listeners/FocusedInputObserver;", "getLayoutObserver$react_native_keyboard_controller_release", "()Lcom/reactnativekeyboardcontroller/listeners/FocusedInputObserver;", "setLayoutObserver$react_native_keyboard_controller_release", "(Lcom/reactnativekeyboardcontroller/listeners/FocusedInputObserver;)V", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "v", "insets", "onPrepare", "", "animation", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onProgress", "runningAnimations", "", "onEnd", "syncKeyboardPosition", ViewProps.HEIGHT, "isVisible", "(Ljava/lang/Double;Ljava/lang/Boolean;)V", "destroy", "onKeyboardResized", "keyboardHeight", "getCurrentKeyboardHeight", "flushPendingStartEvent", "getEventParams", "Lcom/facebook/react/bridge/WritableMap;", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeyboardAnimationCallback extends WindowInsetsAnimationCompat.Callback implements OnApplyWindowInsetsListener, Suspendable {
    private HashSet<WindowInsetsAnimationCompat> animationsToSkip;
    private final KeyboardAnimationCallbackConfig config;
    private final ThemedReactContext context;
    private int duration;
    private final ReactViewGroup eventPropagationView;
    private final ViewTreeObserver.OnGlobalFocusChangeListener focusListener;
    private boolean isKeyboardVisible;
    private boolean isSuspended;
    private boolean isTransitioning;
    private FocusedInputObserver layoutObserver;
    private PendingKeyboardStartEvent pendingStartEvent;
    private double persistentKeyboardHeight;
    private double prevKeyboardHeight;
    private final int surfaceId;
    private final View view;
    private int viewTagFocused;

    @Override // com.reactnativekeyboardcontroller.listeners.Suspendable
    public /* bridge */ void suspend(boolean z) {
        super.suspend(z);
    }

    public final ReactViewGroup getEventPropagationView() {
        return this.eventPropagationView;
    }

    public final View getView() {
        return this.view;
    }

    public final ThemedReactContext getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardAnimationCallback(ReactViewGroup eventPropagationView, View view, ThemedReactContext themedReactContext, KeyboardAnimationCallbackConfig config) {
        super(config.getDispatchMode());
        Intrinsics.checkNotNullParameter(eventPropagationView, "eventPropagationView");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        this.eventPropagationView = eventPropagationView;
        this.view = view;
        this.context = themedReactContext;
        this.config = config;
        this.surfaceId = UIManagerHelper.getSurfaceId(eventPropagationView);
        this.persistentKeyboardHeight = getCurrentKeyboardHeight$default(this, null, 1, null);
        this.prevKeyboardHeight = getCurrentKeyboardHeight$default(this, null, 1, null);
        this.viewTagFocused = -1;
        this.animationsToSkip = new HashSet<>();
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view2, View view3) {
                KeyboardAnimationCallback.focusListener$lambda$0(this.f$0, view2, view3);
            }
        };
        this.focusListener = onGlobalFocusChangeListener;
        if ((config.getDeferredInsetTypes() & config.getPersistentInsetTypes()) != 0) {
            throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values".toString());
        }
        this.layoutObserver = new FocusedInputObserver(view, eventPropagationView, themedReactContext);
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    private final boolean isKeyboardInteractive() {
        return this.duration == -1;
    }

    @Override // com.reactnativekeyboardcontroller.listeners.Suspendable
    /* JADX INFO: renamed from: isSuspended, reason: from getter */
    public boolean getIsSuspended() {
        return this.isSuspended;
    }

    @Override // com.reactnativekeyboardcontroller.listeners.Suspendable
    public void setSuspended(boolean z) {
        this.isSuspended = z;
    }

    static final void focusListener$lambda$0(KeyboardAnimationCallback keyboardAnimationCallback, View view, View view2) {
        if (view2 instanceof EditText) {
            keyboardAnimationCallback.viewTagFocused = ((EditText) view2).getId();
            if (!keyboardAnimationCallback.isKeyboardVisible || view == null) {
                return;
            }
            ThemedReactContextKt.dispatchEvent(keyboardAnimationCallback.context, keyboardAnimationCallback.eventPropagationView.getId(), new KeyboardTransitionEvent(keyboardAnimationCallback.surfaceId, keyboardAnimationCallback.eventPropagationView.getId(), KeyboardTransitionEvent.INSTANCE.getStart(), keyboardAnimationCallback.persistentKeyboardHeight, 1.0d, 0, keyboardAnimationCallback.viewTagFocused));
            ThemedReactContextKt.dispatchEvent(keyboardAnimationCallback.context, keyboardAnimationCallback.eventPropagationView.getId(), new KeyboardTransitionEvent(keyboardAnimationCallback.surfaceId, keyboardAnimationCallback.eventPropagationView.getId(), KeyboardTransitionEvent.INSTANCE.getEnd(), keyboardAnimationCallback.persistentKeyboardHeight, 1.0d, 0, keyboardAnimationCallback.viewTagFocused));
            ThemedReactContextKt.emitEvent(keyboardAnimationCallback.context, "KeyboardController::keyboardWillShow", keyboardAnimationCallback.getEventParams(keyboardAnimationCallback.persistentKeyboardHeight));
            ThemedReactContextKt.emitEvent(keyboardAnimationCallback.context, "KeyboardController::keyboardDidShow", keyboardAnimationCallback.getEventParams(keyboardAnimationCallback.persistentKeyboardHeight));
        }
    }

    /* JADX INFO: renamed from: getLayoutObserver$react_native_keyboard_controller_release, reason: from getter */
    public final FocusedInputObserver getLayoutObserver() {
        return this.layoutObserver;
    }

    public final void setLayoutObserver$react_native_keyboard_controller_release(FocusedInputObserver focusedInputObserver) {
        this.layoutObserver = focusedInputObserver;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        double currentKeyboardHeight$default = getCurrentKeyboardHeight$default(this, null, 1, null);
        boolean z = this.isKeyboardVisible && isKeyboardVisible();
        boolean z2 = this.isTransitioning || InteractiveKeyboardProvider.INSTANCE.isInteractive();
        boolean z3 = z && !z2;
        boolean z4 = this.persistentKeyboardHeight == currentKeyboardHeight$default;
        if (z3 && !z4 && !KeyboardAnimationCallbackKt.isResizeHandledInCallbackMethods) {
            Logger.i$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "onApplyWindowInsets: " + this.persistentKeyboardHeight + " -> " + currentKeyboardHeight$default, null, 4, null);
            onKeyboardResized(currentKeyboardHeight$default);
            return insets;
        }
        double currentKeyboardHeight = getCurrentKeyboardHeight(insets);
        if (this.prevKeyboardHeight != currentKeyboardHeight && !z2 && !getIsSuspended()) {
            Logger.w$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "detected desynchronized state - force updating it: " + currentKeyboardHeight, null, 4, null);
            syncKeyboardPosition(Double.valueOf(currentKeyboardHeight), Boolean.valueOf(currentKeyboardHeight > 0.0d));
        }
        return insets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(WindowInsetsAnimationCompat animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onPrepare(animation);
        if (!WindowInsetsAnimationCompatKt.isKeyboardAnimation(animation) || getIsSuspended()) {
            return;
        }
        this.isTransitioning = true;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (!WindowInsetsAnimationCompatKt.isKeyboardAnimation(animation) || getIsSuspended()) {
            return bounds;
        }
        this.pendingStartEvent = null;
        this.isKeyboardVisible = isKeyboardVisible();
        this.duration = (int) animation.getDurationMillis();
        double currentKeyboardHeight$default = getCurrentKeyboardHeight$default(this, null, 1, null);
        boolean z = this.isKeyboardVisible;
        if (z) {
            this.persistentKeyboardHeight = currentKeyboardHeight$default;
        }
        boolean z2 = (currentKeyboardHeight$default == 0.0d || this.prevKeyboardHeight == currentKeyboardHeight$default) ? false : true;
        boolean z3 = z && this.prevKeyboardHeight != 0.0d;
        if (z2 && z3 && KeyboardAnimationCallbackKt.isResizeHandledInCallbackMethods) {
            onKeyboardResized(currentKeyboardHeight$default);
            this.animationsToSkip.add(animation);
            return bounds;
        }
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::".concat(!this.isKeyboardVisible ? "keyboardWillHide" : "keyboardWillShow"), getEventParams(currentKeyboardHeight$default));
        Logger.i$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "HEIGHT:: " + currentKeyboardHeight$default + " TAG:: " + this.viewTagFocused, null, 4, null);
        this.pendingStartEvent = new PendingKeyboardStartEvent(currentKeyboardHeight$default, this.isKeyboardVisible ? 1.0d : 0.0d, this.duration, this.viewTagFocused);
        WindowInsetsAnimationCompat.BoundsCompat boundsCompatOnStart = super.onStart(animation, bounds);
        Intrinsics.checkNotNullExpressionValue(boundsCompatOnStart, "onStart(...)");
        return boundsCompatOnStart;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
        Object next;
        KeyboardTransitionEvent.Companion.EventName move;
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
        Iterator<T> it = runningAnimations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) next;
            if (WindowInsetsAnimationCompatKt.isKeyboardAnimation(windowInsetsAnimationCompat) && !this.animationsToSkip.contains(windowInsetsAnimationCompat)) {
                break;
            }
        }
        boolean z = next == null;
        if (!getIsSuspended() && !z) {
            Insets insets2 = insets.getInsets(this.config.getDeferredInsetTypes());
            Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
            Insets NONE = insets.getInsets(this.config.getPersistentInsetTypes());
            Intrinsics.checkNotNullExpressionValue(NONE, "getInsets(...)");
            if (this.config.getHasTranslucentNavigationBar()) {
                NONE = Insets.NONE;
                Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
            }
            Insets insetsMax = Insets.max(Insets.subtract(insets2, NONE), Insets.NONE);
            Intrinsics.checkNotNullExpressionValue(insetsMax, "let(...)");
            float f = insetsMax.bottom - insetsMax.top;
            double dp = FloatKt.getDp(f);
            double d = 0.0d;
            try {
                double dAbs = Math.abs(dp / this.persistentKeyboardHeight);
                if (!Double.isNaN(dAbs) && !Double.isInfinite(dAbs)) {
                    d = dAbs;
                }
            } catch (ArithmeticException e) {
                Logger.w$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "Caught arithmetic exception during `progress` calculation: " + e, null, 4, null);
            }
            double d2 = d;
            Logger.i$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "DiffY: " + f + ServerSentEventKt.SPACE + dp + ServerSentEventKt.SPACE + d2 + ServerSentEventKt.SPACE + InteractiveKeyboardProvider.INSTANCE.isInteractive() + ServerSentEventKt.SPACE + this.viewTagFocused, null, 4, null);
            flushPendingStartEvent();
            if (this.isTransitioning) {
                if (InteractiveKeyboardProvider.INSTANCE.isInteractive()) {
                    move = KeyboardTransitionEvent.INSTANCE.getInteractive();
                } else {
                    move = KeyboardTransitionEvent.INSTANCE.getMove();
                }
                ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new KeyboardTransitionEvent(this.surfaceId, this.eventPropagationView.getId(), move, dp, d2, this.duration, this.viewTagFocused));
            }
        }
        return insets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(final WindowInsetsAnimationCompat animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onEnd(animation);
        if (!WindowInsetsAnimationCompatKt.isKeyboardAnimation(animation) || getIsSuspended()) {
            return;
        }
        this.isTransitioning = false;
        this.duration = (int) animation.getDurationMillis();
        Runnable runnable = new Runnable() { // from class: com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardAnimationCallback.onEnd$lambda$0(this.f$0, animation);
            }
        };
        if (isKeyboardInteractive()) {
            this.view.postDelayed(runnable, UIThread.INSTANCE.getNEXT_FRAME());
        } else {
            runnable.run();
        }
    }

    static final void onEnd$lambda$0(KeyboardAnimationCallback keyboardAnimationCallback, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        double currentKeyboardHeight$default = getCurrentKeyboardHeight$default(keyboardAnimationCallback, null, 1, null);
        keyboardAnimationCallback.isKeyboardVisible = keyboardAnimationCallback.isKeyboardVisible();
        keyboardAnimationCallback.prevKeyboardHeight = currentKeyboardHeight$default;
        if (keyboardAnimationCallback.animationsToSkip.contains(windowInsetsAnimationCompat)) {
            keyboardAnimationCallback.duration = 0;
            keyboardAnimationCallback.pendingStartEvent = null;
            keyboardAnimationCallback.animationsToSkip.remove(windowInsetsAnimationCompat);
        } else {
            keyboardAnimationCallback.flushPendingStartEvent();
            ThemedReactContextKt.emitEvent(keyboardAnimationCallback.context, "KeyboardController::".concat(!keyboardAnimationCallback.isKeyboardVisible ? "keyboardDidHide" : "keyboardDidShow"), keyboardAnimationCallback.getEventParams(currentKeyboardHeight$default));
            ThemedReactContextKt.dispatchEvent(keyboardAnimationCallback.context, keyboardAnimationCallback.eventPropagationView.getId(), new KeyboardTransitionEvent(keyboardAnimationCallback.surfaceId, keyboardAnimationCallback.eventPropagationView.getId(), KeyboardTransitionEvent.INSTANCE.getEnd(), currentKeyboardHeight$default, !keyboardAnimationCallback.isKeyboardVisible ? 0.0d : 1.0d, keyboardAnimationCallback.duration, keyboardAnimationCallback.viewTagFocused));
            keyboardAnimationCallback.duration = 0;
            ThemedReactContextKt.keepShadowNodesInSync(keyboardAnimationCallback.context, keyboardAnimationCallback.eventPropagationView.getId());
        }
    }

    public static /* synthetic */ void syncKeyboardPosition$default(KeyboardAnimationCallback keyboardAnimationCallback, Double d, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            d = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        keyboardAnimationCallback.syncKeyboardPosition(d, bool);
    }

    public final void syncKeyboardPosition(Double height, Boolean isVisible) {
        double dDoubleValue = height != null ? height.doubleValue() : getCurrentKeyboardHeight$default(this, null, 1, null);
        boolean zBooleanValue = isVisible != null ? isVisible.booleanValue() : isKeyboardVisible();
        this.isKeyboardVisible = zBooleanValue;
        this.prevKeyboardHeight = dDoubleValue;
        this.isTransitioning = false;
        this.duration = 0;
        this.pendingStartEvent = null;
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::".concat(!zBooleanValue ? "keyboardDidHide" : "keyboardDidShow"), getEventParams(dDoubleValue));
        Iterator it = CollectionsKt.listOf((Object[]) new KeyboardTransitionEvent.Companion.EventName[]{KeyboardTransitionEvent.INSTANCE.getStart(), KeyboardTransitionEvent.INSTANCE.getMove(), KeyboardTransitionEvent.INSTANCE.getEnd()}).iterator();
        while (it.hasNext()) {
            ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new KeyboardTransitionEvent(this.surfaceId, this.eventPropagationView.getId(), (KeyboardTransitionEvent.Companion.EventName) it.next(), dDoubleValue, !this.isKeyboardVisible ? 0.0d : 1.0d, this.duration, this.viewTagFocused));
        }
    }

    public final void destroy() {
        this.pendingStartEvent = null;
        this.view.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.focusListener);
        FocusedInputObserver focusedInputObserver = this.layoutObserver;
        if (focusedInputObserver != null) {
            focusedInputObserver.destroy();
        }
    }

    private final void onKeyboardResized(double keyboardHeight) {
        this.duration = 0;
        FocusedInputObserver focusedInputObserver = this.layoutObserver;
        if (focusedInputObserver != null) {
            focusedInputObserver.syncUpLayout();
        }
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::keyboardWillShow", getEventParams(keyboardHeight));
        Iterator it = CollectionsKt.listOf((Object[]) new KeyboardTransitionEvent.Companion.EventName[]{KeyboardTransitionEvent.INSTANCE.getStart(), KeyboardTransitionEvent.INSTANCE.getMove(), KeyboardTransitionEvent.INSTANCE.getEnd()}).iterator();
        while (it.hasNext()) {
            ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new KeyboardTransitionEvent(this.surfaceId, this.eventPropagationView.getId(), (KeyboardTransitionEvent.Companion.EventName) it.next(), keyboardHeight, 1.0d, 0, this.viewTagFocused));
        }
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::keyboardDidShow", getEventParams(keyboardHeight));
        ThemedReactContextKt.keepShadowNodesInSync(this.context, this.eventPropagationView.getId());
        this.persistentKeyboardHeight = keyboardHeight;
    }

    private final boolean isKeyboardVisible() {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        if (rootWindowInsets != null) {
            return rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
        }
        return false;
    }

    static /* synthetic */ double getCurrentKeyboardHeight$default(KeyboardAnimationCallback keyboardAnimationCallback, WindowInsetsCompat windowInsetsCompat, int i, Object obj) {
        if ((i & 1) != 0) {
            windowInsetsCompat = null;
        }
        return keyboardAnimationCallback.getCurrentKeyboardHeight(windowInsetsCompat);
    }

    private final double getCurrentKeyboardHeight(WindowInsetsCompat insets) {
        Insets insets2;
        Insets insets3;
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        if (insets == null) {
            insets = rootWindowInsets;
        }
        int i = 0;
        int i2 = (insets == null || (insets3 = insets.getInsets(WindowInsetsCompat.Type.ime())) == null) ? 0 : insets3.bottom;
        if (!this.config.getHasTranslucentNavigationBar() && rootWindowInsets != null && (insets2 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())) != null) {
            i = insets2.bottom;
        }
        return RangesKt.coerceAtLeast(FloatKt.getDp(i2 - i), 0.0d);
    }

    private final void flushPendingStartEvent() {
        PendingKeyboardStartEvent pendingKeyboardStartEvent = this.pendingStartEvent;
        if (pendingKeyboardStartEvent == null) {
            return;
        }
        this.pendingStartEvent = null;
        FocusedInputObserver focusedInputObserver = this.layoutObserver;
        if (focusedInputObserver != null) {
            focusedInputObserver.syncUpLayout();
        }
        ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new KeyboardTransitionEvent(this.surfaceId, this.eventPropagationView.getId(), KeyboardTransitionEvent.INSTANCE.getStart(), pendingKeyboardStartEvent.getKeyboardHeight(), pendingKeyboardStartEvent.getProgress(), pendingKeyboardStartEvent.getDuration(), pendingKeyboardStartEvent.getTarget()));
    }

    private final WritableMap getEventParams(double height) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble(ViewProps.HEIGHT, height);
        writableMapCreateMap.putInt("duration", this.duration);
        writableMapCreateMap.putDouble("timestamp", System.currentTimeMillis());
        writableMapCreateMap.putInt(TypedValues.Attributes.S_TARGET, this.viewTagFocused);
        EditText editText = FocusedInputHolder.INSTANCE.get();
        writableMapCreateMap.putString("type", editText != null ? EditTextKt.getKeyboardType(editText) : null);
        writableMapCreateMap.putString("appearance", ThemedReactContextKt.getAppearance(this.context));
        return writableMapCreateMap;
    }
}
