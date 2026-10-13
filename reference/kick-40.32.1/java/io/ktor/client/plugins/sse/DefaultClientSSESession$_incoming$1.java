package io.ktor.client.plugins.sse;

import io.ktor.sse.ServerSentEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: DefaultClientSSESession.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lio/ktor/sse/ServerSentEvent;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$1", f = "DefaultClientSSESession.kt", i = {0, 1, 1, 2}, l = {56, 62, 66}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "event", "$this$flow"}, s = {"L$0", "L$0", "L$1", "L$0"}, v = 1)
final class DefaultClientSSESession$_incoming$1 extends SuspendLambda implements Function2<FlowCollector<? super ServerSentEvent>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DefaultClientSSESession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultClientSSESession$_incoming$1(DefaultClientSSESession defaultClientSSESession, Continuation<? super DefaultClientSSESession$_incoming$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultClientSSESession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultClientSSESession$_incoming$1 defaultClientSSESession$_incoming$1 = new DefaultClientSSESession$_incoming$1(this.this$0, continuation);
        defaultClientSSESession$_incoming$1.L$0 = obj;
        return defaultClientSSESession$_incoming$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ServerSentEvent> flowCollector, Continuation<? super Unit> continuation) {
        return ((DefaultClientSSESession$_incoming$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    /* JADX WARN: Code duplicated, block: B:20:0x005c A[PHI: r9
      0x005c: PHI (r9v8 java.lang.Object) = (r9v15 java.lang.Object), (r9v0 java.lang.Object) binds: [B:18:0x0059, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x0061  */
    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006f -> B:15:0x003a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007f -> B:15:0x003a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x009b -> B:15:0x003a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b5 -> B:13:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L2b
            if (r2 == r6) goto L27
            if (r2 == r5) goto L1f
            if (r2 != r4) goto L17
            goto L2b
        L17:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1f:
            java.lang.Object r2 = r8.L$1
            io.ktor.sse.ServerSentEvent r2 = (io.ktor.sse.ServerSentEvent) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L3a
        L27:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5c
        L2b:
            kotlin.ResultKt.throwOnFailure(r9)
        L2e:
            io.ktor.client.plugins.sse.DefaultClientSSESession r9 = r8.this$0
            kotlin.coroutines.CoroutineContext r9 = r9.getCoroutineContext()
            boolean r9 = kotlinx.coroutines.JobKt.isActive(r9)
            if (r9 == 0) goto Lb8
        L3a:
            io.ktor.client.plugins.sse.DefaultClientSSESession r9 = r8.this$0
            kotlin.coroutines.CoroutineContext r9 = r9.getCoroutineContext()
            boolean r9 = kotlinx.coroutines.JobKt.isActive(r9)
            if (r9 == 0) goto L9e
            io.ktor.client.plugins.sse.DefaultClientSSESession r9 = r8.this$0
            io.ktor.utils.io.ByteReadChannel r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getInput$p(r9)
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.L$0 = r0
            r8.L$1 = r3
            r8.label = r6
            java.lang.Object r9 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$tryParseEvent(r9, r2, r7)
            if (r9 != r1) goto L5c
            goto Lb7
        L5c:
            io.ktor.sse.ServerSentEvent r9 = (io.ktor.sse.ServerSentEvent) r9
            if (r9 != 0) goto L61
            goto L9e
        L61:
            io.ktor.client.plugins.sse.DefaultClientSSESession r2 = r8.this$0
            boolean r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$isCommentsEvent(r2, r9)
            if (r2 == 0) goto L71
            io.ktor.client.plugins.sse.DefaultClientSSESession r2 = r8.this$0
            boolean r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getShowCommentEvents$p(r2)
            if (r2 == 0) goto L3a
        L71:
            io.ktor.client.plugins.sse.DefaultClientSSESession r2 = r8.this$0
            boolean r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$isRetryEvent(r2, r9)
            if (r2 == 0) goto L81
            io.ktor.client.plugins.sse.DefaultClientSSESession r2 = r8.this$0
            boolean r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getShowRetryEvents$p(r2)
            if (r2 == 0) goto L3a
        L81:
            io.ktor.client.plugins.sse.DefaultClientSSESession r2 = r8.this$0
            io.ktor.client.plugins.sse.BodyBuffer r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getBodyBuffer$p(r2)
            r2.appendEvent(r9)
            r2 = r8
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r8.L$0 = r0
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r8.L$1 = r7
            r8.label = r5
            java.lang.Object r9 = r0.emit(r9, r2)
            if (r9 != r1) goto L3a
            goto Lb7
        L9e:
            io.ktor.client.plugins.sse.DefaultClientSSESession r9 = r8.this$0
            boolean r9 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getNeedToReconnect$p(r9)
            if (r9 == 0) goto Lb8
            io.ktor.client.plugins.sse.DefaultClientSSESession r9 = r8.this$0
            r2 = r8
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r8.L$0 = r0
            r8.L$1 = r3
            r8.label = r4
            java.lang.Object r9 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$doReconnection(r9, r2)
            if (r9 != r1) goto L2e
        Lb7:
            return r1
        Lb8:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
