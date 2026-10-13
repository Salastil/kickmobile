package org.h.s;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes11.dex */
public final class l3 extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f536a;
    public final /* synthetic */ s3 b;
    public final /* synthetic */ j3 c;
    public final /* synthetic */ w0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l3(s3 s3Var, j3 j3Var, w0 w0Var, Continuation continuation) {
        super(2, continuation);
        this.b = s3Var;
        this.c = j3Var;
        this.d = w0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new l3(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((l3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
    
        if (org.h.s.s3.a(r5, r1, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f536a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3f
        L12:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L1a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L30
        L1e:
            kotlin.ResultKt.throwOnFailure(r5)
            org.h.s.s3 r5 = r4.b
            org.h.s.l1 r5 = r5.c
            org.h.s.j3 r1 = r4.c
            r4.f536a = r3
            java.lang.Object r5 = r5.a(r1, r4)
            if (r5 != r0) goto L30
            goto L3e
        L30:
            org.h.s.s3 r5 = r4.b
            org.h.s.w0 r1 = r4.d
            org.h.s.x0 r1 = r1.b
            r4.f536a = r2
            java.lang.Object r4 = org.h.s.s3.a(r5, r1, r4)
            if (r4 != r0) goto L3f
        L3e:
            return r0
        L3f:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.h.s.l3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
