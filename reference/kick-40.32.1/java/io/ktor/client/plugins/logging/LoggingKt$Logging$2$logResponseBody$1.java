package io.ktor.client.plugins.logging;

import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingKt", f = "Logging.kt", i = {0, 0, 0, 0}, l = {345}, m = "Logging$lambda$0$logResponseBody", n = {"bodyFilter", "response", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "logLines"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
final class LoggingKt$Logging$2$logResponseBody$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    LoggingKt$Logging$2$logResponseBody$1(Continuation<? super LoggingKt$Logging$2$logResponseBody$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return LoggingKt.Logging$lambda$0$logResponseBody(null, null, null, null, this);
    }
}
