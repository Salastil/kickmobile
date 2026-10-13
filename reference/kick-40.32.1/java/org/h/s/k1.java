package org.h.s;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes11.dex */
public final class k1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l1 f530a;
    public z0 b;
    public Mutex c;
    public /* synthetic */ Object d;
    public final /* synthetic */ l1 e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(l1 l1Var, Continuation continuation) {
        super(continuation);
        this.e = l1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, null, this);
    }
}
