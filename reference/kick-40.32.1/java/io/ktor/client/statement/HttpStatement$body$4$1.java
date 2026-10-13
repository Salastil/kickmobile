package io.ktor.client.statement;

import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: HttpStatement.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement$body$4$1", f = "HttpStatement.kt", i = {0, 0, 1}, l = {207, 145}, m = "invokeSuspend", n = {"$this$body$iv", "$i$f$body", "result"}, s = {"L$0", "I$0", "L$0"}, v = 1)
public final class HttpStatement$body$4$1<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function2<T, Continuation<? super R>, Object> $block;
    final /* synthetic */ HttpResponse $response;
    int I$0;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpStatement$body$4$1(HttpResponse httpResponse, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super HttpStatement$body$4$1> continuation) {
        super(2, continuation);
        this.$response = httpResponse;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HttpStatement$body$4$1(this.$response, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((HttpStatement$body$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to io.ktor.client.statement.HttpStatement$body$4$1<R> for r8v3 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            java.lang.String r3 = "T"
            r4 = 1
            if (r1 == 0) goto L24
            if (r1 == r4) goto L1c
            if (r1 != r2) goto L14
            kotlin.ResultKt.throwOnFailure(r9)
            return r9
        L14:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1c:
            java.lang.Object r1 = r8.L$0
            io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5a
        L24:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.statement.HttpResponse r9 = r8.$response
            io.ktor.client.call.HttpClientCall r1 = r9.getCall()
            r5 = 4
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r5, r3)
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            r6 = 0
            r7 = 6
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r7, r3)     // Catch: java.lang.Throwable -> L3d
            goto L40
        L3d:
            r7 = r6
            kotlin.reflect.KType r7 = (kotlin.reflect.KType) r7
        L40:
            io.ktor.util.reflect.TypeInfo r7 = new io.ktor.util.reflect.TypeInfo
            r7.<init>(r5, r6)
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r8.L$0 = r9
            r9 = 0
            r8.I$0 = r9
            r8.label = r4
            java.lang.Object r9 = r1.bodyNullable(r7, r5)
            if (r9 != r0) goto L5a
            goto L70
        L5a:
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r4, r3)
            r1 = r9
            java.lang.Object r1 = (java.lang.Object) r1
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r8.$block
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r8.L$0 = r3
            r8.label = r2
            java.lang.Object r8 = r1.invoke(r9, r8)
            if (r8 != r0) goto L71
        L70:
            return r0
        L71:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement$body$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to io.ktor.client.statement.HttpStatement$body$4$1<R> for r4v2 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r5) {
        /*
            r4 = this;
            io.ktor.client.statement.HttpResponse r5 = r4.$response
            io.ktor.client.call.HttpClientCall r5 = r5.getCall()
            r0 = 4
            java.lang.String r1 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r0, r1)
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            r2 = 0
            r3 = 6
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r3, r1)     // Catch: java.lang.Throwable -> L18
            goto L1b
        L18:
            r3 = r2
            kotlin.reflect.KType r3 = (kotlin.reflect.KType) r3
        L1b:
            io.ktor.util.reflect.TypeInfo r3 = new io.ktor.util.reflect.TypeInfo
            r3.<init>(r0, r2)
            r0 = r4
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            java.lang.Object r5 = r5.bodyNullable(r3, r0)
            r0 = 1
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r0, r1)
            r0 = r5
            java.lang.Object r0 = (java.lang.Object) r0
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r0 = r4.$block
            java.lang.Object r4 = r0.invoke(r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement$body$4$1.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
    }
}
