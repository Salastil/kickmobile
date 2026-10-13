package org.h.s;

import io.mobileshield.sdk.config.Config;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g4 extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i4 f514a;
    public final /* synthetic */ u b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g4(i4 i4Var, u uVar, Continuation continuation) {
        super(2, continuation);
        this.f514a = i4Var;
        this.b = uVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new g4(this.f514a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new g4(this.f514a, this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        i4 i4Var = this.f514a;
        TimeUnit timeUnit = k4.f532a;
        String str = this.b.f576a;
        Config[] configArr = i4Var.c;
        if (configArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localConfig");
            configArr = null;
        }
        i4Var.a(k4.a(str, configArr));
        return Unit.INSTANCE;
    }
}
