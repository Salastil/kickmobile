package io.ktor.client.plugins.logging;

import com.google.android.gms.cast.MediaError;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingKt", f = "Logging.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {MediaError.DetailedErrorCode.SMOOTH_NO_MEDIA_DATA, 336}, m = "Logging$lambda$0$logRequestOkHttpFormat", n = {"sanitizedHeaders", FirebaseAnalytics.Param.LEVEL, "$this_createClientPlugin", "bodyFilter", "request", "logLines", "uri", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "headers", "contentLength", "startLine", "sanitizedHeaders", FirebaseAnalytics.Param.LEVEL, "$this_createClientPlugin", "bodyFilter", "request", "logLines", "uri", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "headers", "contentLength", "startLine"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 1)
final class LoggingKt$Logging$2$logRequestOkHttpFormat$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$10;
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

    LoggingKt$Logging$2$logRequestOkHttpFormat$1(Continuation<? super LoggingKt$Logging$2$logRequestOkHttpFormat$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return LoggingKt.Logging$lambda$0$logRequestOkHttpFormat(null, null, null, null, null, null, this);
    }
}
