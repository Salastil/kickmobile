package com.swmansion.reanimated.keyboard;

import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardAnimationCallback.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/swmansion/reanimated/keyboard/KeyboardAnimationCallback;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "mKeyboard", "Lcom/swmansion/reanimated/keyboard/Keyboard;", "mNotifyAboutKeyboardChange", "Lcom/swmansion/reanimated/keyboard/NotifyAboutKeyboardChangeFunction;", "mIsNavigationBarTranslucent", "", "<init>", "(Lcom/swmansion/reanimated/keyboard/Keyboard;Lcom/swmansion/reanimated/keyboard/NotifyAboutKeyboardChangeFunction;Z)V", "mPendingStartDispatch", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "bounds", "onProgress", "Landroidx/core/view/WindowInsetsCompat;", "insets", "runningAnimations", "", "onEnd", "", "isKeyboardAnimation", "Companion", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeyboardAnimationCallback extends WindowInsetsAnimationCompat.Callback {
    private final boolean mIsNavigationBarTranslucent;
    private final Keyboard mKeyboard;
    private final NotifyAboutKeyboardChangeFunction mNotifyAboutKeyboardChange;
    private boolean mPendingStartDispatch;
    private static final int CONTENT_TYPE_MASK = WindowInsetsCompat.Type.ime();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardAnimationCallback(Keyboard mKeyboard, NotifyAboutKeyboardChangeFunction mNotifyAboutKeyboardChange, boolean z) {
        super(1);
        Intrinsics.checkNotNullParameter(mKeyboard, "mKeyboard");
        Intrinsics.checkNotNullParameter(mNotifyAboutKeyboardChange, "mNotifyAboutKeyboardChange");
        this.mKeyboard = mKeyboard;
        this.mNotifyAboutKeyboardChange = mNotifyAboutKeyboardChange;
        this.mIsNavigationBarTranslucent = z;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (!isKeyboardAnimation(animation)) {
            return bounds;
        }
        this.mKeyboard.onAnimationStart();
        this.mPendingStartDispatch = true;
        WindowInsetsAnimationCompat.BoundsCompat boundsCompatOnStart = super.onStart(animation, bounds);
        Intrinsics.checkNotNullExpressionValue(boundsCompatOnStart, "onStart(...)");
        return boundsCompatOnStart;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
        Iterator<WindowInsetsAnimationCompat> it = runningAnimations.iterator();
        while (it.hasNext()) {
            if (isKeyboardAnimation(it.next())) {
                this.mPendingStartDispatch = false;
                this.mKeyboard.updateHeight(insets, this.mIsNavigationBarTranslucent);
                this.mNotifyAboutKeyboardChange.call();
                break;
            }
        }
        return insets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(WindowInsetsAnimationCompat animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (isKeyboardAnimation(animation)) {
            if (this.mPendingStartDispatch) {
                this.mNotifyAboutKeyboardChange.call();
            }
            this.mPendingStartDispatch = false;
            this.mKeyboard.onAnimationEnd();
            this.mNotifyAboutKeyboardChange.call();
        }
    }

    private final boolean isKeyboardAnimation(WindowInsetsAnimationCompat animation) {
        return (animation.getTypeMask() & CONTENT_TYPE_MASK) != 0;
    }
}
