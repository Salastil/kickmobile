package io.ktor.client.plugins.logging;

import androidx.media3.muxer.WebmConstants;
import androidx.mediarouter.media.GlobalMediaRouter;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingKt", f = "Logging.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {194, 226, WebmConstants.MkvEbmlElement.TIMESTAMP, 246, GlobalMediaRouter.CallbackHandler.MSG_ROUTE_CHANGED}, m = "Logging$lambda$0$logOutgoingContent", n = {"$this_createClientPlugin", "bodyFilter", ImagesContract.URL, "content", FirebaseAnalytics.Param.METHOD, "headers", "logLines", "process", "$this_createClientPlugin", "bodyFilter", ImagesContract.URL, "content", FirebaseAnalytics.Param.METHOD, "headers", "logLines", "process", "bytes", "$this_createClientPlugin", "bodyFilter", ImagesContract.URL, "content", FirebaseAnalytics.Param.METHOD, "headers", "logLines", "process", "$this_createClientPlugin", "bodyFilter", ImagesContract.URL, "content", FirebaseAnalytics.Param.METHOD, "headers", "logLines", "process", "origChannel", "newChannel", "$this_createClientPlugin", "bodyFilter", ImagesContract.URL, "content", FirebaseAnalytics.Param.METHOD, "headers", "logLines", "process", "channel", "origChannel", "newChannel"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 1)
final class LoggingKt$Logging$2$logOutgoingContent$1 extends ContinuationImpl {
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

    LoggingKt$Logging$2$logOutgoingContent$1(Continuation<? super LoggingKt$Logging$2$logOutgoingContent$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return LoggingKt.Logging$lambda$0$logOutgoingContent(null, null, null, null, null, null, null, null, this);
    }
}
