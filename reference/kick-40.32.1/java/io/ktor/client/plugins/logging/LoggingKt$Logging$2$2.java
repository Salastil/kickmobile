package io.ktor.client.plugins.logging;

import io.ktor.client.statement.HttpResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/logging/ResponseAfterEncodingHook$Context;", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingKt$Logging$2$2", f = "Logging.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {576, 583}, m = "invokeSuspend", n = {"$this$on", "response", "responseLogLines", "$this$on", "response", "responseLogLines", "newResponse"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
final class LoggingKt$Logging$2$2 extends SuspendLambda implements Function3<ResponseAfterEncodingHook.Context, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ LogBodyFilter $bodyFilter;
    final /* synthetic */ LogLevel $level;
    final /* synthetic */ Logger $logger;
    final /* synthetic */ boolean $okHttpFormat;
    final /* synthetic */ List<SanitizedHeader> $sanitizedHeaders;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoggingKt$Logging$2$2(boolean z, Logger logger, List<SanitizedHeader> list, LogLevel logLevel, LogBodyFilter logBodyFilter, Continuation<? super LoggingKt$Logging$2$2> continuation) {
        super(3, continuation);
        this.$okHttpFormat = z;
        this.$logger = logger;
        this.$sanitizedHeaders = list;
        this.$level = logLevel;
        this.$bodyFilter = logBodyFilter;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(ResponseAfterEncodingHook.Context context, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        LoggingKt$Logging$2$2 loggingKt$Logging$2$2 = new LoggingKt$Logging$2$2(this.$okHttpFormat, this.$logger, this.$sanitizedHeaders, this.$level, this.$bodyFilter, continuation);
        loggingKt$Logging$2$2.L$0 = context;
        loggingKt$Logging$2$2.L$1 = httpResponse;
        return loggingKt$Logging$2$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006b  */
    /* JADX WARN: Code duplicated, block: B:20:0x008c  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ad, code lost:
    
        if (r1.proceedWith(r3, r19) == r2) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = r0.L$0
            io.ktor.client.plugins.logging.ResponseAfterEncodingHook$Context r1 = (io.ktor.client.plugins.logging.ResponseAfterEncodingHook.Context) r1
            java.lang.Object r2 = r0.L$1
            r6 = r2
            io.ktor.client.statement.HttpResponse r6 = (io.ktor.client.statement.HttpResponse) r6
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r9 = 2
            r4 = 1
            if (r3 == 0) goto L39
            if (r3 == r4) goto L2e
            if (r3 != r9) goto L26
            java.lang.Object r1 = r0.L$3
            io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
            java.lang.Object r0 = r0.L$2
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r20)
            goto Lb0
        L26:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2e:
            java.lang.Object r3 = r0.L$2
            java.util.List r3 = (java.util.List) r3
            kotlin.ResultKt.throwOnFailure(r20)
            r7 = r3
            r3 = r20
            goto L63
        L39:
            kotlin.ResultKt.throwOnFailure(r20)
            boolean r3 = r0.$okHttpFormat
            if (r3 == 0) goto Lb0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r7 = r3
            java.util.List r7 = (java.util.List) r7
            java.util.List<io.ktor.client.plugins.logging.SanitizedHeader> r3 = r0.$sanitizedHeaders
            io.ktor.client.plugins.logging.LogLevel r5 = r0.$level
            r8 = r5
            io.ktor.client.plugins.logging.LogBodyFilter r5 = r0.$bodyFilter
            r10 = r8
            r8 = r0
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r0.L$0 = r1
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            r4 = r10
            java.lang.Object r3 = io.ktor.client.plugins.logging.LoggingKt.access$Logging$lambda$0$logResponseOkHttpFormat(r3, r4, r5, r6, r7, r8)
            if (r3 != r2) goto L63
            goto Laf
        L63:
            io.ktor.client.statement.HttpResponse r3 = (io.ktor.client.statement.HttpResponse) r3
            int r4 = r7.size()
            if (r4 <= 0) goto L86
            io.ktor.client.plugins.logging.Logger r4 = r0.$logger
            r10 = r7
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.lang.String r5 = "\n"
            r11 = r5
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r17 = 62
            r18 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String r5 = kotlin.collections.CollectionsKt.joinToString$default(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r4.log(r5)
        L86:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r6)
            if (r4 != 0) goto Lb0
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r0.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r0.L$3 = r5
            r0.label = r9
            java.lang.Object r0 = r1.proceedWith(r3, r4)
            if (r0 != r2) goto Lb0
        Laf:
            return r2
        Lb0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.LoggingKt$Logging$2$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
