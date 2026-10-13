package io.ktor.client.plugins.logging;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.java_websocket.WebSocketImpl;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingKt", f = "Logging.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {437, WebSocketImpl.DEFAULT_WSS_PORT}, m = "Logging$lambda$0$logResponseOkHttpFormat", n = {"sanitizedHeaders", FirebaseAnalytics.Param.LEVEL, "bodyFilter", "response", "logLines", "contentLength", "request", "startLine", "duration", "sanitizedHeaders", FirebaseAnalytics.Param.LEVEL, "bodyFilter", "response", "logLines", "contentLength", "request", "startLine", "origChannel", "newChannel", "duration"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "J$0"}, v = 1)
final class LoggingKt$Logging$2$logResponseOkHttpFormat$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;

    LoggingKt$Logging$2$logResponseOkHttpFormat$1(Continuation<? super LoggingKt$Logging$2$logResponseOkHttpFormat$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return LoggingKt.Logging$lambda$0$logResponseOkHttpFormat(null, null, null, null, null, this);
    }
}
