package io.ktor.client.plugins.logging;

import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/logging/SendHook$Context;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingKt$Logging$2$1", f = "Logging.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4}, l = {538, 546, 548, 559, 565}, m = "invokeSuspend", n = {"$this$on", "request", "requestLogLines", "$this$on", "request", "requestLogLines", "content", "$this$on", "request", "requestLogLines", "content", "$this$on", "request", "$this$on", "request", "loggedRequest"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
final class LoggingKt$Logging$2$1 extends SuspendLambda implements Function3<SendHook.Context, HttpRequestBuilder, Continuation<? super Unit>, Object> {
    final /* synthetic */ LogBodyFilter $bodyFilter;
    final /* synthetic */ List<Function1<HttpRequestBuilder, Boolean>> $filters;
    final /* synthetic */ LogLevel $level;
    final /* synthetic */ Logger $logger;
    final /* synthetic */ boolean $okHttpFormat;
    final /* synthetic */ List<SanitizedHeader> $sanitizedHeaders;
    final /* synthetic */ ClientPluginBuilder<LoggingConfig> $this_createClientPlugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LoggingKt$Logging$2$1(boolean z, Logger logger, List<? extends Function1<? super HttpRequestBuilder, Boolean>> list, List<SanitizedHeader> list2, LogLevel logLevel, ClientPluginBuilder<LoggingConfig> clientPluginBuilder, LogBodyFilter logBodyFilter, Continuation<? super LoggingKt$Logging$2$1> continuation) {
        super(3, continuation);
        this.$okHttpFormat = z;
        this.$logger = logger;
        this.$filters = list;
        this.$sanitizedHeaders = list2;
        this.$level = logLevel;
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$bodyFilter = logBodyFilter;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(SendHook.Context context, HttpRequestBuilder httpRequestBuilder, Continuation<? super Unit> continuation) {
        LoggingKt$Logging$2$1 loggingKt$Logging$2$1 = new LoggingKt$Logging$2$1(this.$okHttpFormat, this.$logger, this.$filters, this.$sanitizedHeaders, this.$level, this.$this_createClientPlugin, this.$bodyFilter, continuation);
        loggingKt$Logging$2$1.L$0 = context;
        loggingKt$Logging$2$1.L$1 = httpRequestBuilder;
        return loggingKt$Logging$2$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c7 A[Catch: all -> 0x004a, TRY_ENTER, TryCatch #1 {all -> 0x004a, blocks: (B:19:0x0045, B:37:0x00c7, B:40:0x00ec), top: B:63:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ec A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #1 {all -> 0x004a, blocks: (B:19:0x0045, B:37:0x00c7, B:40:0x00ec), top: B:63:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0143 A[Catch: all -> 0x002b, TRY_ENTER, TryCatch #2 {all -> 0x002b, blocks: (B:10:0x0026, B:54:0x0143, B:56:0x0149), top: B:63:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0148  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x010d, code lost:
    
        if (r0.proceed(r21) == r2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0160, code lost:
    
        if (r0.proceedWith(r5, r21) == r2) goto L58;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.LoggingKt$Logging$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
