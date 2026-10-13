package com.swmansion.reanimated.pseudoSelectors;

import android.view.MotionEvent;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PseudoSelectorManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class PseudoSelectorManager$hover$1 extends FunctionReferenceImpl implements Function2<ViewGroup, MotionEvent, Unit> {
    PseudoSelectorManager$hover$1(Object obj) {
        super(2, obj, PseudoSelectorManager.class, "onWindowPressTouch", "onWindowPressTouch(Landroid/view/ViewGroup;Landroid/view/MotionEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ViewGroup viewGroup, MotionEvent motionEvent) {
        invoke2(viewGroup, motionEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ViewGroup viewGroup, MotionEvent p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((PseudoSelectorManager) this.receiver).onWindowPressTouch(viewGroup, p1);
    }
}
