package io.ktor.client.plugins.logging;

import androidx.media3.muxer.WebmConstants;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.http.auth.HttpAuthHeader;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: LogBodyFilter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.logging.LogBodyFilterKt$BinaryLogBodyFilter$1", f = "LogBodyFilter.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {123, WebmConstants.MkvEbmlElement.FLAG_DEFAULT, WebmConstants.MkvEbmlElement.PREV_SIZE}, m = "filterAll", n = {"contentLength", "contentType", "headers", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "contentLength", "contentType", "headers", ExpoNotificationBuilder.EXTRAS_BODY_KEY, HttpAuthHeader.Parameters.Charset, "firstChunk", "isBinary", "contentLength", "contentType", "headers", ExpoNotificationBuilder.EXTRAS_BODY_KEY, HttpAuthHeader.Parameters.Charset, "firstChunk", "buffer", "firstChunkText", "$this$filterAll_u24lambda_u241", "isBinary", "firstReadSize", "$i$a$-apply-LogBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "I$0", "I$1", "I$2"}, v = 1)
final class LogBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
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
    final /* synthetic */ LogBodyFilterKt$BinaryLogBodyFilter$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LogBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1(LogBodyFilterKt$BinaryLogBodyFilter$1 logBodyFilterKt$BinaryLogBodyFilter$1, Continuation<? super LogBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1> continuation) {
        super(continuation);
        this.this$0 = logBodyFilterKt$BinaryLogBodyFilter$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.filterAll(null, null, null, null, this);
    }
}
