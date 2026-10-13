package com.swmansion.rnscreens.gamma.tabs.host;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TabsHost.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class TabsHost$layoutCoordinator$1 extends FunctionReferenceImpl implements Function0<Unit> {
    TabsHost$layoutCoordinator$1(Object obj) {
        super(0, obj, TabsHost.class, "forceSubtreeMeasureAndLayoutPass", "forceSubtreeMeasureAndLayoutPass()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((TabsHost) this.receiver).forceSubtreeMeasureAndLayoutPass();
    }
}
