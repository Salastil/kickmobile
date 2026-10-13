package org.h.s;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes11.dex */
public final class h1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l1 f516a;
    public Mutex b;
    public /* synthetic */ Object c;
    public final /* synthetic */ l1 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(l1 l1Var, Continuation continuation) {
        super(continuation);
        this.d = l1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a((Continuation) this);
    }
}
