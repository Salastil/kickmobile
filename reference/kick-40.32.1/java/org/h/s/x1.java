package org.h.s;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes11.dex */
public final class x1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y1 f588a;
    public /* synthetic */ Object b;
    public final /* synthetic */ y1 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(y1 y1Var, Continuation continuation) {
        super(continuation);
        this.c = y1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(this);
    }
}
