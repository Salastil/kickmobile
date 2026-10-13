package org.h.s;

import android.content.Context;
import android.content.SharedPreferences;
import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class l0 extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f533a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(Context context, Continuation continuation) {
        super(2, continuation);
        this.f533a = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new l0(this.f533a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new l0(this.f533a, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        CoroutineDispatcher coroutineDispatcher = m0.f538a;
        SharedPreferences sharedPreferences = this.f533a.getSharedPreferences("flagsAndConfigSP", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (a0 a0Var : a0.values()) {
            if (a0Var.b) {
                editorEdit.putBoolean(a0Var.f486a, a0Var.c);
            }
        }
        w2 w2Var = e3.b;
        for (x2 x2Var : w2.a()) {
            String str = x2Var.e;
            int i = x2Var.f;
            Integer.valueOf(i).getClass();
            editorEdit.putInt(str, i);
        }
        w2 w2Var2 = e3.b;
        for (d3 d3Var : w2.b()) {
            editorEdit.putString(d3Var.e, d3Var.f);
        }
        editorEdit.putString("hashValue", g0.f510a);
        editorEdit.apply();
        LocalLogger.log$default(16, 12001L, null, 4, null);
        return Unit.INSTANCE;
    }
}
