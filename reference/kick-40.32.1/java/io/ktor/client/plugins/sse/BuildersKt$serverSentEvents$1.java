package io.ktor.client.plugins.sse;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: builders.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.BuildersKt", f = "builders.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {189, 191}, m = "serverSentEvents-mY9Nd3A", n = {"$this$serverSentEvents_u2dmY9Nd3A", "request", "reconnectionTime", "showCommentEvents", "showRetryEvents", "block", "$this$serverSentEvents_u2dmY9Nd3A", "request", "reconnectionTime", "showCommentEvents", "showRetryEvents", "block", "session"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 1)
final class BuildersKt$serverSentEvents$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    BuildersKt$serverSentEvents$1(Continuation<? super BuildersKt$serverSentEvents$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BuildersKt.m12509serverSentEventsmY9Nd3A(null, null, null, null, null, null, this);
    }
}
