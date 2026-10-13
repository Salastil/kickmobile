package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.DialogInterface;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter;
import com.swmansion.rnscreens.gamma.modals.dimmingview.DimmingViewManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormSheetPresentationManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u001d\u001a\u00020\nH\u0000¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0016H\u0000¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\nH\u0002J\b\u0010'\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\nH\u0002J\b\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020\nH\u0002J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0005H\u0002J\r\u0010-\u001a\u00020\nH\u0000¢\u0006\u0002\b.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetPresentationManager;", "", "dialog", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialog;", "bottomSheetView", "Landroid/view/View;", "dimmingManager", "Lcom/swmansion/rnscreens/gamma/modals/dimmingview/DimmingViewManager;", FormSheetNativeDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "", "<init>", "(Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialog;Landroid/view/View;Lcom/swmansion/rnscreens/gamma/modals/dimmingview/DimmingViewManager;Lkotlin/jvm/functions/Function0;)V", "appearanceEventEmitter", "Lcom/swmansion/rnscreens/gamma/common/event/ViewAppearanceEventEmitter;", "getAppearanceEventEmitter$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/common/event/ViewAppearanceEventEmitter;", "setAppearanceEventEmitter$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/common/event/ViewAppearanceEventEmitter;)V", "state", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetPresentationState;", "targetIsOpen", "", "animatorFactory", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetAnimatorFactory;", "currentSheetAnimator", "Landroid/animation/Animator;", "nativeDismissCoordinator", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetNativeDismissCoordinator;", "setup", "setup$react_native_screens_release", "updatePresentationState", "isOpen", "updatePresentationState$react_native_screens_release", "resolvePresentationState", "presentIfNeeded", "dismissIfNeeded", "startEnterAnimation", "startExitAnimation", "performDismiss", "onPresentationComplete", "onDismissComplete", "handleNativeDismiss", "syncBehaviorStateAfterExitAnimationComplete", "view", "destroy", "destroy$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetPresentationManager {
    private final FormSheetAnimatorFactory animatorFactory;
    private ViewAppearanceEventEmitter appearanceEventEmitter;
    private final View bottomSheetView;
    private Animator currentSheetAnimator;
    private final FormSheetDialog dialog;
    private final DimmingViewManager dimmingManager;
    private final FormSheetNativeDismissCoordinator nativeDismissCoordinator;
    private final Function0<Unit> onNativeDismiss;
    private FormSheetPresentationState state;
    private boolean targetIsOpen;

    public FormSheetPresentationManager(FormSheetDialog dialog, View view, DimmingViewManager dimmingManager, Function0<Unit> onNativeDismiss) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(dimmingManager, "dimmingManager");
        Intrinsics.checkNotNullParameter(onNativeDismiss, "onNativeDismiss");
        this.dialog = dialog;
        this.bottomSheetView = view;
        this.dimmingManager = dimmingManager;
        this.onNativeDismiss = onNativeDismiss;
        this.state = FormSheetPresentationState.DISMISSED;
        this.animatorFactory = new FormSheetAnimatorFactory(dimmingManager);
        this.nativeDismissCoordinator = new FormSheetNativeDismissCoordinator(dialog, dimmingManager, new Function0() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetPresentationManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormSheetPresentationManager.nativeDismissCoordinator$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: getAppearanceEventEmitter$react_native_screens_release, reason: from getter */
    public final ViewAppearanceEventEmitter getAppearanceEventEmitter() {
        return this.appearanceEventEmitter;
    }

    public final void setAppearanceEventEmitter$react_native_screens_release(ViewAppearanceEventEmitter viewAppearanceEventEmitter) {
        this.appearanceEventEmitter = viewAppearanceEventEmitter;
    }

    static final Unit nativeDismissCoordinator$lambda$0(FormSheetPresentationManager formSheetPresentationManager) {
        formSheetPresentationManager.handleNativeDismiss();
        return Unit.INSTANCE;
    }

    public final void setup$react_native_screens_release() {
        View view = this.bottomSheetView;
        if (view != null) {
            DimmingViewManager dimmingViewManager = this.dimmingManager;
            BottomSheetBehavior<?> bottomSheetBehaviorFrom = BottomSheetBehavior.from(view);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
            dimmingViewManager.attachToBehavior$react_native_screens_release(bottomSheetBehaviorFrom);
        }
        this.nativeDismissCoordinator.setup$react_native_screens_release();
    }

    public final void updatePresentationState$react_native_screens_release(boolean isOpen) {
        this.targetIsOpen = isOpen;
        resolvePresentationState();
    }

    private final void resolvePresentationState() {
        if (this.targetIsOpen) {
            presentIfNeeded();
        } else {
            dismissIfNeeded();
        }
    }

    private final void presentIfNeeded() {
        if (this.state != FormSheetPresentationState.DISMISSED) {
            return;
        }
        this.state = FormSheetPresentationState.PRESENTING;
        ViewAppearanceEventEmitter viewAppearanceEventEmitter = this.appearanceEventEmitter;
        if (viewAppearanceEventEmitter != null) {
            viewAppearanceEventEmitter.emitOnWillAppear();
        }
        this.dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetPresentationManager$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                FormSheetPresentationManager.presentIfNeeded$lambda$0(this.f$0, dialogInterface);
            }
        });
        this.dialog.show();
    }

    static final void presentIfNeeded$lambda$0(FormSheetPresentationManager formSheetPresentationManager, DialogInterface dialogInterface) {
        formSheetPresentationManager.dialog.setOnShowListener(null);
        formSheetPresentationManager.dimmingManager.onDialogShow$react_native_screens_release();
        formSheetPresentationManager.startEnterAnimation();
    }

    private final void dismissIfNeeded() {
        if (this.state != FormSheetPresentationState.PRESENTED) {
            return;
        }
        this.state = FormSheetPresentationState.DISMISSING;
        ViewAppearanceEventEmitter viewAppearanceEventEmitter = this.appearanceEventEmitter;
        if (viewAppearanceEventEmitter != null) {
            viewAppearanceEventEmitter.emitOnWillDisappear();
        }
        View view = this.bottomSheetView;
        if (view == null || BottomSheetBehavior.from(view).getState() == 5) {
            performDismiss();
        } else {
            startExitAnimation();
        }
    }

    private final void startEnterAnimation() {
        if (this.bottomSheetView == null) {
            onPresentationComplete();
            return;
        }
        Animator animator = this.currentSheetAnimator;
        boolean z = false;
        if (animator != null && animator.isRunning()) {
            z = true;
        }
        Animator animator2 = this.currentSheetAnimator;
        if (animator2 != null) {
            animator2.removeAllListeners();
        }
        Animator animator3 = this.currentSheetAnimator;
        if (animator3 != null) {
            animator3.cancel();
        }
        this.dimmingManager.setTransitionAnimationRunning$react_native_screens_release(true);
        final Animator animatorCreateEnterAnimator$react_native_screens_release = this.animatorFactory.createEnterAnimator$react_native_screens_release(this.bottomSheetView, z);
        animatorCreateEnterAnimator$react_native_screens_release.addListener(new AnimatorListenerAdapter() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetPresentationManager$startEnterAnimation$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.dimmingManager.setTransitionAnimationRunning$react_native_screens_release(false);
                if (Intrinsics.areEqual(this.this$0.currentSheetAnimator, animatorCreateEnterAnimator$react_native_screens_release)) {
                    this.this$0.currentSheetAnimator = null;
                }
                this.this$0.onPresentationComplete();
            }
        });
        animatorCreateEnterAnimator$react_native_screens_release.start();
        this.currentSheetAnimator = animatorCreateEnterAnimator$react_native_screens_release;
    }

    private final void startExitAnimation() {
        if (this.bottomSheetView == null) {
            performDismiss();
            return;
        }
        Animator animator = this.currentSheetAnimator;
        boolean z = false;
        if (animator != null && animator.isRunning()) {
            z = true;
        }
        Animator animator2 = this.currentSheetAnimator;
        if (animator2 != null) {
            animator2.removeAllListeners();
        }
        Animator animator3 = this.currentSheetAnimator;
        if (animator3 != null) {
            animator3.cancel();
        }
        this.dimmingManager.setTransitionAnimationRunning$react_native_screens_release(true);
        final Animator animatorCreateExitAnimator$react_native_screens_release = this.animatorFactory.createExitAnimator$react_native_screens_release(this.bottomSheetView, z);
        animatorCreateExitAnimator$react_native_screens_release.addListener(new AnimatorListenerAdapter() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetPresentationManager$startExitAnimation$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.dimmingManager.setTransitionAnimationRunning$react_native_screens_release(false);
                if (Intrinsics.areEqual(this.this$0.currentSheetAnimator, animatorCreateExitAnimator$react_native_screens_release)) {
                    this.this$0.currentSheetAnimator = null;
                }
                FormSheetPresentationManager formSheetPresentationManager = this.this$0;
                formSheetPresentationManager.syncBehaviorStateAfterExitAnimationComplete(formSheetPresentationManager.bottomSheetView);
                this.this$0.performDismiss();
            }
        });
        animatorCreateExitAnimator$react_native_screens_release.start();
        this.currentSheetAnimator = animatorCreateExitAnimator$react_native_screens_release;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performDismiss() {
        this.dialog.dismiss();
        onDismissComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPresentationComplete() {
        if (this.state == FormSheetPresentationState.PRESENTING) {
            this.state = FormSheetPresentationState.PRESENTED;
            ViewAppearanceEventEmitter viewAppearanceEventEmitter = this.appearanceEventEmitter;
            if (viewAppearanceEventEmitter != null) {
                viewAppearanceEventEmitter.emitOnDidAppear();
            }
            resolvePresentationState();
        }
    }

    private final void onDismissComplete() {
        if (this.state == FormSheetPresentationState.DISMISSING) {
            this.state = FormSheetPresentationState.DISMISSED;
            ViewAppearanceEventEmitter viewAppearanceEventEmitter = this.appearanceEventEmitter;
            if (viewAppearanceEventEmitter != null) {
                viewAppearanceEventEmitter.emitOnDidDisappear();
            }
            resolvePresentationState();
        }
    }

    private final void handleNativeDismiss() {
        if (this.state == FormSheetPresentationState.DISMISSING || this.state == FormSheetPresentationState.DISMISSED) {
            return;
        }
        this.onNativeDismiss.invoke();
        updatePresentationState$react_native_screens_release(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncBehaviorStateAfterExitAnimationComplete(View view) {
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(view);
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        view.offsetTopAndBottom((view2 != null ? view2.getHeight() : view.getHeight()) - view.getTop());
        bottomSheetBehaviorFrom.setState(5);
    }

    public final void destroy$react_native_screens_release() {
        Animator animator = this.currentSheetAnimator;
        if (animator != null) {
            animator.cancel();
        }
        this.currentSheetAnimator = null;
        this.dialog.setOnShowListener(null);
        this.state = FormSheetPresentationState.DISMISSED;
        this.nativeDismissCoordinator.destroy$react_native_screens_release();
    }
}
