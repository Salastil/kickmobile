package io.ktor.client.plugins.logging;

import androidx.core.app.NotificationCompat;
import io.ktor.client.call.HttpClientCall;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/logging/ReceiveHook$Context;", NotificationCompat.CATEGORY_CALL, "Lio/ktor/client/call/HttpClientCall;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingKt$Logging$2$4", f = "Logging.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {624, 629, 630}, m = "invokeSuspend", n = {"$this$on", NotificationCompat.CATEGORY_CALL, "$this$on", NotificationCompat.CATEGORY_CALL, "cause", "log", "callLogger", "$this$on", NotificationCompat.CATEGORY_CALL, "cause", "log", "callLogger"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
final class LoggingKt$Logging$2$4 extends SuspendLambda implements Function3<ReceiveHook.Context, HttpClientCall, Continuation<? super Unit>, Object> {
    final /* synthetic */ LogLevel $level;
    final /* synthetic */ boolean $okHttpFormat;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoggingKt$Logging$2$4(boolean z, LogLevel logLevel, Continuation<? super LoggingKt$Logging$2$4> continuation) {
        super(3, continuation);
        this.$okHttpFormat = z;
        this.$level = logLevel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(ReceiveHook.Context context, HttpClientCall httpClientCall, Continuation<? super Unit> continuation) {
        LoggingKt$Logging$2$4 loggingKt$Logging$2$4 = new LoggingKt$Logging$2$4(this.$okHttpFormat, this.$level, continuation);
        loggingKt$Logging$2$4.L$0 = context;
        loggingKt$Logging$2$4.L$1 = httpClientCall;
        return loggingKt$Logging$2$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StringBuilder sb;
        HttpClientCallLogger httpClientCallLogger;
        ReceiveHook.Context context = (ReceiveHook.Context) this.L$0;
        HttpClientCall httpClientCall = (HttpClientCall) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$okHttpFormat) {
                    return Unit.INSTANCE;
                }
                if (this.$level == LogLevel.NONE || httpClientCall.getAttributes().contains(LoggingKt.DisableLogging)) {
                    return Unit.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(context);
                this.L$1 = httpClientCall;
                this.label = 1;
                obj = context.proceed(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Throwable th = (Throwable) this.L$2;
                        ResultKt.throwOnFailure(obj);
                        throw th;
                    }
                    httpClientCallLogger = (HttpClientCallLogger) this.L$4;
                    sb = (StringBuilder) this.L$3;
                    Throwable th2 = (Throwable) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    th = th2;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(context);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(httpClientCall);
                    this.L$2 = th;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(sb);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(httpClientCallLogger);
                    this.label = 3;
                    if (httpClientCallLogger.closeResponseLog(this) != coroutine_suspended) {
                        throw th;
                    }
                    return coroutine_suspended;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            StringBuilder sb2 = new StringBuilder();
            HttpClientCallLogger httpClientCallLogger2 = (HttpClientCallLogger) httpClientCall.getAttributes().get(LoggingKt.ClientCallLogger);
            LoggingKt.Logging$lambda$0$logResponseException(this.$level, sb2, httpClientCall.getRequest(), th);
            String string = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            this.L$0 = SpillingKt.nullOutSpilledVariable(context);
            this.L$1 = SpillingKt.nullOutSpilledVariable(httpClientCall);
            this.L$2 = th;
            this.L$3 = SpillingKt.nullOutSpilledVariable(sb2);
            this.L$4 = httpClientCallLogger2;
            this.label = 2;
            if (httpClientCallLogger2.logResponseException(string, this) != coroutine_suspended) {
                sb = sb2;
                httpClientCallLogger = httpClientCallLogger2;
            }
        }
    }
}
