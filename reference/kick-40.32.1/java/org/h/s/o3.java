package org.h.s;

import android.util.Base64;
import io.mobileshield.sdk.config.Config;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class o3 extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s3 f552a;
    public final /* synthetic */ byte[] b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o3(s3 s3Var, byte[] bArr, Continuation continuation) {
        super(2, continuation);
        this.f552a = s3Var;
        this.b = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new o3(this.f552a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new o3(this.f552a, this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Config config = s3.h;
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("x-kpsdk-lg", this.f552a.c.f));
        String body = Base64.encodeToString(this.b, 2);
        Intrinsics.checkNotNullExpressionValue(body, "encodeToString(...)");
        s3 s3Var = this.f552a;
        s3Var.getClass();
        r3 onResponse = new r3(s3Var);
        m2 onFailure = m2.f540a;
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Intrinsics.checkNotNullParameter(onResponse, "onResponse");
        o2 tpResponseHandler = new o2(onFailure, onResponse);
        Intrinsics.checkNotNullParameter("/149e9513-01fa-4fb0-aad4-566afd725d1b/2d206a39-8ed7-437e-a3be-862e0f06eea3/lg", "endpoint");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(tpResponseHandler, "tpResponseHandler");
        s3 s3Var2 = f1.f506a;
        f1.a(w0.d0, StringsKt.substringAfterLast$default("/149e9513-01fa-4fb0-aad4-566afd725d1b/2d206a39-8ed7-437e-a3be-862e0f06eea3/lg", '/', (String) null, 2, (Object) null));
        if (config != null) {
            p2.a(p2.a(config, "/149e9513-01fa-4fb0-aad4-566afd725d1b/2d206a39-8ed7-437e-a3be-862e0f06eea3/lg"), body, mapMapOf, tpResponseHandler, 16);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
