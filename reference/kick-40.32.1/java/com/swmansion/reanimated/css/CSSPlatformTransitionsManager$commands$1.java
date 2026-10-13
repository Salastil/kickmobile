package com.swmansion.reanimated.css;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CSSPlatformTransitionsManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CSSPlatformTransitionsManager$commands$1 extends FunctionReferenceImpl implements Function1<CSSPlatformTransitionsManager.Command, Unit> {
    CSSPlatformTransitionsManager$commands$1(Object obj) {
        super(1, obj, CSSPlatformTransitionsManager.class, "executeCommand", "executeCommand(Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager$Command;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CSSPlatformTransitionsManager.Command command) {
        invoke2(command);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CSSPlatformTransitionsManager.Command p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((CSSPlatformTransitionsManager) this.receiver).executeCommand(p0);
    }
}
