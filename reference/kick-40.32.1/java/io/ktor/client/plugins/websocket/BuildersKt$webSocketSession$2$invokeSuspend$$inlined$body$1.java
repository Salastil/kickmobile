package io.ktor.client.plugins.websocket;

import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HttpStatement.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "io/ktor/client/statement/HttpStatement$body$4$1"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1", f = "builders.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {207, 226}, m = "invokeSuspend", n = {"$this$body$iv", "$i$f$body", "result", "$completion", "session", "sessionCompleted", "$i$a$-body-BuildersKt$webSocketSession$2$1"}, s = {"L$0", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
public final class BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpResponse $response;
    final /* synthetic */ CompletableDeferred $sessionDeferred$inlined;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1(HttpResponse httpResponse, Continuation continuation, CompletableDeferred completableDeferred) {
        super(2, continuation);
        this.$response = httpResponse;
        this.$sessionDeferred$inlined = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1(this.$response, continuation, this.$sessionDeferred$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a3, code lost:
    
        if (r4.await(r9) == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 0
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L35
            if (r1 == r5) goto L2d
            if (r1 != r3) goto L25
            java.lang.Object r0 = r9.L$3
            kotlinx.coroutines.CompletableDeferred r0 = (kotlinx.coroutines.CompletableDeferred) r0
            java.lang.Object r0 = r9.L$2
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r0 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r0
            java.lang.Object r0 = r9.L$1
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            java.lang.Object r9 = r9.L$0
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r9 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto La6
        L25:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2d:
            java.lang.Object r1 = r9.L$0
            io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L65
        L35:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.client.statement.HttpResponse r10 = r9.$response
            io.ktor.client.call.HttpClientCall r1 = r10.getCall()
            java.lang.Class<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r6 = io.ktor.client.plugins.websocket.DefaultClientWebSocketSession.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            java.lang.Class<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r7 = io.ktor.client.plugins.websocket.DefaultClientWebSocketSession.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.typeOf(r7)     // Catch: java.lang.Throwable -> L4b
            goto L4c
        L4b:
            r7 = r4
        L4c:
            io.ktor.util.reflect.TypeInfo r8 = new io.ktor.util.reflect.TypeInfo
            r8.<init>(r6, r7)
            r6 = r9
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r9.L$0 = r10
            r9.I$0 = r2
            r9.label = r5
            java.lang.Object r10 = r1.bodyNullable(r8, r6)
            if (r10 != r0) goto L65
            goto La5
        L65:
            if (r10 == 0) goto La9
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r10 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r10
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            kotlinx.coroutines.CompletableDeferred r4 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default(r4, r5, r4)
            kotlinx.coroutines.CompletableDeferred r5 = r9.$sessionDeferred$inlined
            r5.complete(r10)
            kotlinx.coroutines.channels.SendChannel r5 = r10.getOutgoing()
            io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$1$1 r6 = new io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$1$1
            r6.<init>()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r5.invokeOnClose(r6)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r9.L$0 = r5
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r9.L$1 = r1
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r9.L$2 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r9.L$3 = r10
            r9.I$0 = r2
            r9.label = r3
            java.lang.Object r9 = r4.await(r9)
            if (r9 != r0) goto La6
        La5:
            return r0
        La6:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        La9:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r10 = "null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
