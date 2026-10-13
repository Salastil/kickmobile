package io.ktor.client.plugins.logging;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingKt", f = "Logging.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {150}, m = "Logging$lambda$0$logRequestBody", n = {"bodyFilter", ImagesContract.URL, "content", "contentLength", "headers", FirebaseAnalytics.Param.METHOD, "logLines", ExpoNotificationBuilder.EXTRAS_BODY_KEY}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 1)
final class LoggingKt$Logging$2$logRequestBody$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    LoggingKt$Logging$2$logRequestBody$1(Continuation<? super LoggingKt$Logging$2$logRequestBody$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return LoggingKt.Logging$lambda$0$logRequestBody(null, null, null, null, null, null, null, null, this);
    }
}
