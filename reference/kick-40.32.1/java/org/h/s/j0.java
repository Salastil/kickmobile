package org.h.s;

import android.content.Context;
import android.util.Base64;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes11.dex */
public final class j0 extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f524a;
    public /* synthetic */ Object b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Context e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(String str, String str2, Context context, Continuation continuation) {
        super(2, continuation);
        this.c = str;
        this.d = str2;
        this.e = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        j0 j0Var = new j0(this.c, this.d, this.e, continuation);
        j0Var.b = obj;
        return j0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((j0) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM12684constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f524a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = this.c;
                String str2 = this.d;
                Context context = this.e;
                Result.Companion companion = Result.INSTANCE;
                s3 s3Var = f1.f506a;
                f1.a(w0.l0, str);
                CoroutineDispatcher coroutineDispatcher = k0.f529a;
                byte[] bytes = str2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                byte[] bArrDecode = Base64.decode(bytes, 0);
                Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
                String strA = k0.a(k0.a(bArrDecode));
                this.f524a = 1;
                if (k0.a(strA, context, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            objM12684constructorimpl = Result.m12684constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            s3 s3Var2 = f1.f506a;
            f1.a(w0.m0, thM12687exceptionOrNullimpl.getMessage());
            String str3 = g0.f510a;
            Intrinsics.checkNotNullParameter("01o", "<set-?>");
            g0.f510a = "01o";
        }
        return Unit.INSTANCE;
    }
}
