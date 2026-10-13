package com.swmansion.reanimated.css;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CSSPlatformTransitionsManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CSSPlatformTransitionsManager$reconciler$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    CSSPlatformTransitionsManager$reconciler$1(Object obj) {
        super(0, obj, CSSPlatformTransitionsManager.class, "onPreDraw", "onPreDraw()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(((CSSPlatformTransitionsManager) this.receiver).onPreDraw());
    }
}
