package com.swmansion.rnscreens;

import android.view.View;
import android.view.ViewParent;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.math.MathUtils;
import com.swmansion.rnscreens.bottomsheet.SheetUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenFooter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0013*\u00013\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b#J\u0015\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0000¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\"H\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\u0012H\u0002J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u0002J0\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0014J\u0014\u00105\u001a\u00020\"2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J\u0014\u00107\u001a\u00020\"2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J\b\u00108\u001a\u00020\"H\u0014J\b\u00109\u001a\u00020\"H\u0014J\u0010\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\tH\u0002J\u0010\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u000eH\u0002J6\u0010>\u001a\u00020\"2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tJ(\u0010@\u001a\u00020\"2\u0006\u0010?\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\b\b\u0002\u0010C\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0010\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0004\n\u0002\u00104¨\u0006E"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFooter;", "Lcom/facebook/react/views/view/ReactViewGroup;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "<init>", "(Lcom/facebook/react/bridge/ReactContext;)V", "getReactContext", "()Lcom/facebook/react/bridge/ReactContext;", "lastContainerHeight", "", "lastStableSheetState", "isAnimationControlledByKeyboard", "", "lastSlideOffset", "", "lastBottomInset", "isCallbackRegistered", "screenParent", "Lcom/swmansion/rnscreens/Screen;", "getScreenParent", "()Lcom/swmansion/rnscreens/Screen;", "sheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getSheetBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "hasReceivedInitialLayoutFromParent", "getHasReceivedInitialLayoutFromParent", "()Z", "reactHeight", "getReactHeight", "()I", "reactWidth", "getReactWidth", "notifyKeyboardAnimationStart", "", "notifyKeyboardAnimationStart$react_native_screens_release", "handleKeyboardInsetsProgress", "insets", "Landroidx/core/view/WindowInsetsCompat;", "handleKeyboardInsetsProgress$react_native_screens_release", "notifyKeyboardAnimationEnd", "notifyKeyboardAnimationEnd$react_native_screens_release", "requireScreenParent", "requireSheetBehavior", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "footerCallback", "com/swmansion/rnscreens/ScreenFooter$footerCallback$1", "Lcom/swmansion/rnscreens/ScreenFooter$footerCallback$1;", "registerWithSheetBehavior", "behavior", "unregisterWithSheetBehavior", "onAttachedToWindow", "onDetachedFromWindow", "sheetTopInStableState", "state", "sheetTopWhileDragging", "slideOffset", "onParentLayout", "containerHeight", "layoutFooterOnYAxis", "footerHeight", "sheetTop", "bottomInset", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScreenFooter extends ReactViewGroup {
    public static final String TAG = "ScreenFooter";
    private ScreenFooter$footerCallback$1 footerCallback;
    private boolean isAnimationControlledByKeyboard;
    private boolean isCallbackRegistered;
    private int lastBottomInset;
    private int lastContainerHeight;
    private float lastSlideOffset;
    private int lastStableSheetState;
    private final ReactContext reactContext;

    public final ReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.swmansion.rnscreens.ScreenFooter$footerCallback$1] */
    public ScreenFooter(ReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.lastStableSheetState = 5;
        this.footerCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.swmansion.rnscreens.ScreenFooter$footerCallback$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (SheetUtils.INSTANCE.isStateStable(newState)) {
                    if (newState == 3 || newState == 4 || newState == 6) {
                        ScreenFooter screenFooter = this.this$0;
                        screenFooter.layoutFooterOnYAxis(screenFooter.lastContainerHeight, this.this$0.getReactHeight(), this.this$0.sheetTopInStableState(newState), this.this$0.lastBottomInset);
                    }
                    this.this$0.lastStableSheetState = newState;
                }
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                this.this$0.lastSlideOffset = Math.max(slideOffset, 0.0f);
                if (this.this$0.isAnimationControlledByKeyboard) {
                    return;
                }
                ScreenFooter screenFooter = this.this$0;
                int i = screenFooter.lastContainerHeight;
                int reactHeight = this.this$0.getReactHeight();
                ScreenFooter screenFooter2 = this.this$0;
                screenFooter.layoutFooterOnYAxis(i, reactHeight, screenFooter2.sheetTopWhileDragging(screenFooter2.lastSlideOffset), this.this$0.lastBottomInset);
            }
        };
    }

    private final Screen getScreenParent() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            return (Screen) parent;
        }
        return null;
    }

    private final BottomSheetBehavior<Screen> getSheetBehavior() {
        return requireScreenParent().getSheetBehavior();
    }

    private final boolean getHasReceivedInitialLayoutFromParent() {
        return this.lastContainerHeight > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getReactHeight() {
        return getMeasuredHeight();
    }

    private final int getReactWidth() {
        return getMeasuredWidth();
    }

    public final void notifyKeyboardAnimationStart$react_native_screens_release() {
        this.isAnimationControlledByKeyboard = true;
    }

    public final void handleKeyboardInsetsProgress$react_native_screens_release(WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        Screen screenParent = getScreenParent();
        this.lastBottomInset = (int) (i + (screenParent != null ? screenParent.getTranslationY() : 0.0f));
        layoutFooterOnYAxis(this.lastContainerHeight, getReactHeight(), sheetTopWhileDragging(this.lastSlideOffset), this.lastBottomInset);
    }

    public final void notifyKeyboardAnimationEnd$react_native_screens_release() {
        this.isAnimationControlledByKeyboard = false;
    }

    private final Screen requireScreenParent() {
        Screen screenParent = getScreenParent();
        if (screenParent != null) {
            return screenParent;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final BottomSheetBehavior<Screen> requireSheetBehavior() {
        BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
        if (sheetBehavior != null) {
            return sheetBehavior;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (getHasReceivedInitialLayoutFromParent()) {
            layoutFooterOnYAxis(this.lastContainerHeight, bottom - top, sheetTopInStableState(requireSheetBehavior().getState()), this.lastBottomInset);
        }
    }

    public final void registerWithSheetBehavior(BottomSheetBehavior<Screen> behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        if (this.isCallbackRegistered) {
            return;
        }
        behavior.addBottomSheetCallback(this.footerCallback);
        this.isCallbackRegistered = true;
    }

    public final void unregisterWithSheetBehavior(BottomSheetBehavior<Screen> behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        if (this.isCallbackRegistered) {
            behavior.removeBottomSheetCallback(this.footerCallback);
            this.isCallbackRegistered = false;
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
        if (sheetBehavior != null) {
            registerWithSheetBehavior(sheetBehavior);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
        if (sheetBehavior != null) {
            unregisterWithSheetBehavior(sheetBehavior);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int sheetTopInStableState(int state) {
        BottomSheetBehavior<Screen> bottomSheetBehaviorRequireSheetBehavior = requireSheetBehavior();
        if (state == 3) {
            return bottomSheetBehaviorRequireSheetBehavior.getExpandedOffset();
        }
        if (state == 4) {
            return this.lastContainerHeight - bottomSheetBehaviorRequireSheetBehavior.getPeekHeight();
        }
        if (state == 5) {
            return this.lastContainerHeight;
        }
        if (state == 6) {
            return (int) (this.lastContainerHeight * (1.0f - bottomSheetBehaviorRequireSheetBehavior.getHalfExpandedRatio()));
        }
        throw new IllegalArgumentException("[RNScreens] use of stable-state method for unstable state");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int sheetTopWhileDragging(float slideOffset) {
        Screen screenParent = getScreenParent();
        return screenParent != null ? screenParent.getTop() : (int) MathUtils.lerp(sheetTopInStableState(4), sheetTopInStableState(3), slideOffset);
    }

    public final void onParentLayout(boolean changed, int left, int top, int right, int bottom, int containerHeight) {
        this.lastContainerHeight = containerHeight;
        layoutFooterOnYAxis$default(this, containerHeight, getReactHeight(), sheetTopInStableState(requireSheetBehavior().getState()), 0, 8, null);
    }

    public static /* synthetic */ void layoutFooterOnYAxis$default(ScreenFooter screenFooter, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        screenFooter.layoutFooterOnYAxis(i, i2, i3, i4);
    }

    public final void layoutFooterOnYAxis(int containerHeight, int footerHeight, int sheetTop, int bottomInset) {
        int iMax = ((containerHeight - footerHeight) - sheetTop) - Math.max(bottomInset, 0);
        int reactHeight = getReactHeight();
        setTop(Math.max(iMax, 0));
        setBottom(getTop() + reactHeight);
    }
}
