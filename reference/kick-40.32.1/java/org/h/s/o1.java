package org.h.s;

import android.content.Context;
import io.mobileshield.sdk.logger.LocalLogger;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes11.dex */
public final class o1 extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p1 f550a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ u c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(p1 p1Var, Context context, u uVar, Continuation continuation) {
        super(2, continuation);
        this.f550a = p1Var;
        this.b = context;
        this.c = uVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new o1(this.f550a, this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((o1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        p1 p1Var = this.f550a;
        Context ctx = this.b;
        u uVar = this.c;
        int i = p1.d;
        p1Var.getClass();
        String str = uVar.f576a;
        u uVarA = p1Var.a();
        if (StringsKt.equals(str, uVarA != null ? uVarA.f576a : null, true)) {
            LocalLogger.log$default(16, 22202L, null, 4, null);
        } else {
            LocalLogger.log$default(8, 22203L, null, 4, null);
        }
        p1Var.a(uVar);
        u uVarA2 = p1Var.a();
        Intrinsics.checkNotNullParameter(ctx, "context");
        try {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            LocalLogger.log(8, 22204L, null);
            ctx.deleteFile("a.txt");
            LocalLogger.log(8, 22206L, null);
            FileOutputStream fileOutputStreamOpenFileOutput = ctx.openFileOutput("a.txt", 32768);
            Intrinsics.checkNotNullExpressionValue(fileOutputStreamOpenFileOutput, "openFileOutput(...)");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStreamOpenFileOutput);
            LocalLogger.log(8, 22207L, null);
            objectOutputStream.writeObject(uVarA2);
            LocalLogger.log(8, 22208L, null);
            fileOutputStreamOpenFileOutput.close();
            objectOutputStream.close();
        } catch (IOException e) {
            LocalLogger.log(2, 22209L, e.getMessage());
        }
        return Unit.INSTANCE;
    }
}
