package io.ktor.client.plugins.logging;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/logging/ResponseHook$Context;", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingKt$Logging$2$3", f = "Logging.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6}, l = {599, TypedValues.Motion.TYPE_PATHMOTION_ARC, TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS, TypedValues.Motion.TYPE_QUANTIZE_INTERPOLATOR_TYPE, TypedValues.Motion.TYPE_PATHMOTION_ARC, TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS, TypedValues.Motion.TYPE_QUANTIZE_INTERPOLATOR_TYPE}, m = "invokeSuspend", n = {"$this$on", "response", "callLogger", "header", "failed", "$this$on", "response", "callLogger", "header", "failed", "$this$on", "response", "callLogger", "header", "failed", "$this$on", "response", "callLogger", "header", "failed", "$this$on", "response", "callLogger", "header", "failed", "$this$on", "response", "callLogger", "header", "failed", "$this$on", "response", "callLogger", "header", "failed"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
final class LoggingKt$Logging$2$3 extends SuspendLambda implements Function3<ResponseHook.Context, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ LogLevel $level;
    final /* synthetic */ boolean $okHttpFormat;
    final /* synthetic */ List<SanitizedHeader> $sanitizedHeaders;
    int I$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoggingKt$Logging$2$3(boolean z, LogLevel logLevel, List<SanitizedHeader> list, Continuation<? super LoggingKt$Logging$2$3> continuation) {
        super(3, continuation);
        this.$okHttpFormat = z;
        this.$level = logLevel;
        this.$sanitizedHeaders = list;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(ResponseHook.Context context, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        LoggingKt$Logging$2$3 loggingKt$Logging$2$3 = new LoggingKt$Logging$2$3(this.$okHttpFormat, this.$level, this.$sanitizedHeaders, continuation);
        loggingKt$Logging$2$3.L$0 = context;
        loggingKt$Logging$2$3.L$1 = httpResponse;
        return loggingKt$Logging$2$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x014a, code lost:
    
        if (r5.closeResponseLog(r11) == r2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0172, code lost:
    
        if (r7.closeResponseLog(r11) == r2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0203, code lost:
    
        if (r6.closeResponseLog(r11) == r2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x022c, code lost:
    
        if (r7.closeResponseLog(r11) == r2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x022f, code lost:
    
        r0 = r12;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.LoggingKt$Logging$2$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
