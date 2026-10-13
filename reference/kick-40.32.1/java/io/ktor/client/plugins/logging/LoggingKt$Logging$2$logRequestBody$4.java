package io.ktor.client.plugins.logging;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.Source;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingKt$Logging$2$logRequestBody$4", f = "Logging.kt", i = {0, 0, 0}, l = {765}, m = "invokeSuspend", n = {"$this$tryReadText$iv", "charset$iv", "$i$f$tryReadText"}, s = {"L$0", "L$1", "I$0"}, v = 1)
final class LoggingKt$Logging$2$logRequestBody$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteChannel $channel;
    final /* synthetic */ Charset $charset;
    final /* synthetic */ HttpClientCallLogger $logger;
    final /* synthetic */ StringBuilder $requestLog;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoggingKt$Logging$2$logRequestBody$4(ByteChannel byteChannel, Charset charset, StringBuilder sb, HttpClientCallLogger httpClientCallLogger, Continuation<? super LoggingKt$Logging$2$logRequestBody$4> continuation) {
        super(2, continuation);
        this.$channel = byteChannel;
        this.$charset = charset;
        this.$requestLog = sb;
        this.$logger = httpClientCallLogger;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoggingKt$Logging$2$logRequestBody$4(this.$channel, this.$charset, this.$requestLog, this.$logger, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoggingKt$Logging$2$logRequestBody$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Charset charset;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String text$default = null;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    ByteChannel byteChannel = this.$channel;
                    Charset charset2 = this.$charset;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(byteChannel);
                    this.L$1 = charset2;
                    this.I$0 = 0;
                    this.label = 1;
                    obj = ByteReadChannelOperationsKt.readRemaining(byteChannel, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    charset = charset2;
                } catch (Throwable th) {
                    HttpClientCallLogger httpClientCallLogger = this.$logger;
                    String string = this.$requestLog.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    httpClientCallLogger.logRequest(string);
                    this.$logger.closeRequestLog();
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                charset = (Charset) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            text$default = StringsKt.readText$default((Source) obj, charset, 0, 2, null);
        } catch (Throwable unused) {
        }
        if (text$default == null) {
            text$default = "[request body omitted]";
        }
        StringBuilder sb = this.$requestLog;
        sb.append("BODY START");
        sb.append('\n');
        StringBuilder sb2 = this.$requestLog;
        sb2.append(text$default);
        sb2.append('\n');
        this.$requestLog.append("BODY END");
        HttpClientCallLogger httpClientCallLogger2 = this.$logger;
        String string2 = this.$requestLog.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        httpClientCallLogger2.logRequest(string2);
        this.$logger.closeRequestLog();
        return Unit.INSTANCE;
    }
}
