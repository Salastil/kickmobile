package org.h.s;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m3 extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f541a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ s3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m3(Context context, s3 s3Var, Continuation continuation) {
        super(2, continuation);
        this.b = context;
        this.c = s3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new m3(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new m3(this.b, this.c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        c cVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f541a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedPreferences sharedPreferences = this.b.getSharedPreferences("RLSP", 0);
            if (a0.i.c) {
                Intrinsics.checkNotNull(sharedPreferences);
                cVar = new c(sharedPreferences);
            } else {
                cVar = null;
            }
            l1 l1Var = this.c.c;
            Intrinsics.checkNotNull(sharedPreferences);
            b bVar = new b(sharedPreferences);
            this.f541a = 1;
            if (l1Var.a(cVar, bVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
