package com.swmansion.reanimated.keyboard;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardAnimationManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class KeyboardAnimationManager$mWindowsInsetsManager$1 implements NotifyAboutKeyboardChangeFunction, FunctionAdapter {
    final /* synthetic */ KeyboardAnimationManager $tmp0;

    KeyboardAnimationManager$mWindowsInsetsManager$1(KeyboardAnimationManager keyboardAnimationManager) {
        this.$tmp0 = keyboardAnimationManager;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof NotifyAboutKeyboardChangeFunction) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(0, this.$tmp0, KeyboardAnimationManager.class, "notifyAboutKeyboardChange", "notifyAboutKeyboardChange()V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.swmansion.reanimated.keyboard.NotifyAboutKeyboardChangeFunction
    public final void call() {
        this.$tmp0.notifyAboutKeyboardChange();
    }
}
