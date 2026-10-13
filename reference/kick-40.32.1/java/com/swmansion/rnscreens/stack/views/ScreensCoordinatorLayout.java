package com.swmansion.rnscreens.stack.views;

import android.content.Context;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ViewProps;
import com.swmansion.rnscreens.PointerEventsBoxNoneImpl;
import com.swmansion.rnscreens.ScreenStackFragment;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.stack.anim.ScreensAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreensCoordinatorLayout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\nJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J0\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$H\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020)X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/swmansion/rnscreens/stack/views/ScreensCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Lcom/facebook/react/uimanager/ReactPointerEventsView;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "fragment", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "pointerEventsImpl", "<init>", "(Landroid/content/Context;Lcom/swmansion/rnscreens/ScreenStackFragment;Lcom/facebook/react/uimanager/ReactPointerEventsView;)V", "(Landroid/content/Context;Lcom/swmansion/rnscreens/ScreenStackFragment;)V", "getFragment$react_native_screens_release", "()Lcom/swmansion/rnscreens/ScreenStackFragment;", "blockFrameworkTransitionFinalization", "", "getBlockFrameworkTransitionFinalization$react_native_screens_release", "()Z", "setBlockFrameworkTransitionFinalization$react_native_screens_release", "(Z)V", "needsTransitionFinalization", "getNeedsTransitionFinalization$react_native_screens_release", "setNeedsTransitionFinalization$react_native_screens_release", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "animationListener", "Landroid/view/animation/Animation$AnimationListener;", "startAnimation", "", "animation", "Landroid/view/animation/Animation;", "clearAnimation", "clearFocus", "onLayout", "changed", "l", "", "t", "r", "b", ViewProps.POINTER_EVENTS, "Lcom/facebook/react/uimanager/PointerEvents;", "getPointerEvents", "()Lcom/facebook/react/uimanager/PointerEvents;", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScreensCoordinatorLayout extends CoordinatorLayout implements ReactPointerEventsView {
    private final Animation.AnimationListener animationListener;
    private boolean blockFrameworkTransitionFinalization;
    private final ScreenStackFragment fragment;
    private boolean needsTransitionFinalization;
    private final ReactPointerEventsView pointerEventsImpl;

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.pointerEventsImpl.getPointerEvents();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreensCoordinatorLayout(Context context, ScreenStackFragment fragment, ReactPointerEventsView pointerEventsImpl) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(pointerEventsImpl, "pointerEventsImpl");
        this.fragment = fragment;
        this.pointerEventsImpl = pointerEventsImpl;
        this.animationListener = new Animation.AnimationListener() { // from class: com.swmansion.rnscreens.stack.views.ScreensCoordinatorLayout$animationListener$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.getFragment().onViewAnimationStart();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (this.this$0.getBlockFrameworkTransitionFinalization()) {
                    this.this$0.setBlockFrameworkTransitionFinalization$react_native_screens_release(false);
                    this.this$0.setNeedsTransitionFinalization$react_native_screens_release(true);
                }
                this.this$0.getFragment().onViewAnimationEnd();
                this.this$0.setNeedsTransitionFinalization$react_native_screens_release(false);
            }
        };
    }

    /* JADX INFO: renamed from: getFragment$react_native_screens_release, reason: from getter */
    public final ScreenStackFragment getFragment() {
        return this.fragment;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScreensCoordinatorLayout(Context context, ScreenStackFragment fragment) {
        this(context, fragment, new PointerEventsBoxNoneImpl());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX INFO: renamed from: getBlockFrameworkTransitionFinalization$react_native_screens_release, reason: from getter */
    public final boolean getBlockFrameworkTransitionFinalization() {
        return this.blockFrameworkTransitionFinalization;
    }

    public final void setBlockFrameworkTransitionFinalization$react_native_screens_release(boolean z) {
        this.blockFrameworkTransitionFinalization = z;
    }

    /* JADX INFO: renamed from: getNeedsTransitionFinalization$react_native_screens_release, reason: from getter */
    public final boolean getNeedsTransitionFinalization() {
        return this.needsTransitionFinalization;
    }

    public final void setNeedsTransitionFinalization$react_native_screens_release(boolean z) {
        this.needsTransitionFinalization = z;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        WindowInsets windowInsetsOnApplyWindowInsets = super.onApplyWindowInsets(insets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsOnApplyWindowInsets, "onApplyWindowInsets(...)");
        return windowInsetsOnApplyWindowInsets;
    }

    @Override // android.view.View
    public void startAnimation(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        ScreensAnimation screensAnimation = new ScreensAnimation(this.fragment);
        screensAnimation.setDuration(animation.getDuration());
        if (this.fragment.isRemoving()) {
            this.blockFrameworkTransitionFinalization = true;
        }
        if ((animation instanceof AnimationSet) && !this.fragment.isRemoving()) {
            AnimationSet animationSet = (AnimationSet) animation;
            animationSet.addAnimation(screensAnimation);
            animationSet.setAnimationListener(this.animationListener);
            super.startAnimation(animationSet);
            return;
        }
        AnimationSet animationSet2 = new AnimationSet(true);
        animationSet2.addAnimation(animation);
        animationSet2.addAnimation(screensAnimation);
        animationSet2.setAnimationListener(this.animationListener);
        super.startAnimation(animationSet2);
    }

    @Override // android.view.View
    public void clearAnimation() {
        this.blockFrameworkTransitionFinalization = false;
        this.needsTransitionFinalization = false;
        super.clearAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        if (getVisibility() != 4) {
            super.clearFocus();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (SheetUtilsKt.usesFormSheetPresentation(this.fragment.getScreen())) {
            this.fragment.getScreen().onBottomSheetBehaviorDidLayout$react_native_screens_release(changed);
        }
    }
}
