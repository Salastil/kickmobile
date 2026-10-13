package io.ktor.client.plugins.logging;

import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingKt$Logging$2$responseObserver$1$2", f = "Logging.kt", i = {0, 0, 1, 1}, l = {647, 648}, m = "invokeSuspend", n = {"response", "callLogger", "response", "callLogger"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
final class LoggingKt$Logging$2$responseObserver$1$2 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ LogLevel $level;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoggingKt$Logging$2$responseObserver$1$2(LogLevel logLevel, Continuation<? super LoggingKt$Logging$2$responseObserver$1$2> continuation) {
        super(2, continuation);
        this.$level = logLevel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LoggingKt$Logging$2$responseObserver$1$2 loggingKt$Logging$2$responseObserver$1$2 = new LoggingKt$Logging$2$responseObserver$1$2(this.$level, continuation);
        loggingKt$Logging$2$responseObserver$1$2.L$0 = obj;
        return loggingKt$Logging$2$responseObserver$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        return ((LoggingKt$Logging$2$responseObserver$1$2) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
    
        if (r2.closeResponseLog(r6) == r1) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            io.ktor.client.statement.HttpResponse r0 = (io.ktor.client.statement.HttpResponse) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r6.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L2a
            if (r2 == r4) goto L22
            if (r2 != r3) goto L1a
            java.lang.Object r6 = r6.L$1
            io.ktor.client.plugins.logging.HttpClientCallLogger r6 = (io.ktor.client.plugins.logging.HttpClientCallLogger) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L85
        L1a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L22:
            java.lang.Object r2 = r6.L$1
            io.ktor.client.plugins.logging.HttpClientCallLogger r2 = (io.ktor.client.plugins.logging.HttpClientCallLogger) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6d
        L2a:
            kotlin.ResultKt.throwOnFailure(r7)
            io.ktor.client.plugins.logging.LogLevel r7 = r6.$level
            io.ktor.client.plugins.logging.LogLevel r2 = io.ktor.client.plugins.logging.LogLevel.NONE
            if (r7 == r2) goto L88
            io.ktor.client.call.HttpClientCall r7 = r0.getCall()
            io.ktor.util.Attributes r7 = r7.getAttributes()
            io.ktor.util.AttributeKey r2 = io.ktor.client.plugins.logging.LoggingKt.access$getDisableLogging$p()
            boolean r7 = r7.contains(r2)
            if (r7 == 0) goto L46
            goto L88
        L46:
            io.ktor.client.call.HttpClientCall r7 = r0.getCall()
            io.ktor.util.Attributes r7 = r7.getAttributes()
            io.ktor.util.AttributeKey r2 = io.ktor.client.plugins.logging.LoggingKt.access$getClientCallLogger$p()
            java.lang.Object r7 = r7.get(r2)
            r2 = r7
            io.ktor.client.plugins.logging.HttpClientCallLogger r2 = (io.ktor.client.plugins.logging.HttpClientCallLogger) r2
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r6.L$0 = r5
            r6.L$1 = r2
            r6.label = r4
            java.lang.Object r7 = io.ktor.client.plugins.logging.LoggingUtilsKt.logResponseBody(r2, r0, r7)
            if (r7 != r1) goto L6d
            goto L84
        L6d:
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r6.L$0 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$1 = r0
            r6.label = r3
            java.lang.Object r6 = r2.closeResponseLog(r7)
            if (r6 != r1) goto L85
        L84:
            return r1
        L85:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L88:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.LoggingKt$Logging$2$responseObserver$1$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
