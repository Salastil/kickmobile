package org.h.s;

import android.content.Context;
import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class m1 extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p1 f539a;
    public final /* synthetic */ Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(p1 p1Var, Context context, Continuation continuation) {
        super(2, continuation);
        this.f539a = p1Var;
        this.b = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new m1(this.f539a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new m1(this.f539a, this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM12684constructorimpl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        p1 p1Var = this.f539a;
        Context context = this.b;
        try {
            Result.Companion companion = Result.INSTANCE;
            p1Var.a(r1.a(context));
            if (y1.i == null) {
                y1.i = new y1(Dispatchers.getIO(), new t1());
            }
            y1 y1Var = y1.i;
            Intrinsics.checkNotNull(y1Var);
            y1Var.a(r4.INITIALISATION, "load_stored_token");
            LocalLogger.log(8, 22201L, p1Var.a() == null ? "0" : "1");
            objM12684constructorimpl = Result.m12684constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        p1 p1Var2 = this.f539a;
        if (Result.m12687exceptionOrNullimpl(objM12684constructorimpl) != null) {
            p1Var2.a((u) null);
            LocalLogger.log(8, 22901L, "Exception while initializing");
        }
        return Unit.INSTANCE;
    }
}
