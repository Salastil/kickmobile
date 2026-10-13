package io.ktor.client.plugins.sse;

import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.SSEClientResponseAdapter;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.LoggerJvmKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import org.slf4j.Logger;

/* JADX INFO: compiled from: SSE.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lio/ktor/http/content/OutgoingContent;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.SSEKt$SSE$2$1", f = "SSE.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SSEKt$SSE$2$1 extends SuspendLambda implements Function3<HttpRequestBuilder, OutgoingContent, Continuation<? super OutgoingContent>, Object> {
    final /* synthetic */ SSEBufferPolicy $bufferPolicy;
    final /* synthetic */ int $maxReconnectionAttempts;
    final /* synthetic */ long $reconnectionTime;
    final /* synthetic */ boolean $showCommentEvents;
    final /* synthetic */ boolean $showRetryEvents;
    final /* synthetic */ ClientPluginBuilder<SSEConfig> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SSEKt$SSE$2$1(ClientPluginBuilder<SSEConfig> clientPluginBuilder, long j, boolean z, boolean z2, int i, SSEBufferPolicy sSEBufferPolicy, Continuation<? super SSEKt$SSE$2$1> continuation) {
        super(3, continuation);
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$reconnectionTime = j;
        this.$showCommentEvents = z;
        this.$showRetryEvents = z2;
        this.$maxReconnectionAttempts = i;
        this.$bufferPolicy = sSEBufferPolicy;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent, Continuation<? super OutgoingContent> continuation) {
        SSEKt$SSE$2$1 sSEKt$SSE$2$1 = new SSEKt$SSE$2$1(this.$this_createClientPlugin, this.$reconnectionTime, this.$showCommentEvents, this.$showRetryEvents, this.$maxReconnectionAttempts, this.$bufferPolicy, continuation);
        sSEKt$SSE$2$1.L$0 = httpRequestBuilder;
        sSEKt$SSE$2$1.L$1 = outgoingContent;
        return sSEKt$SSE$2$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
        OutgoingContent outgoingContent = (OutgoingContent) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Intrinsics.areEqual(SSEKt.getAttributeValue(httpRequestBuilder, BuildersKt.getSseRequestAttr()), Boxing.boxBoolean(true))) {
                return outgoingContent;
            }
            Logger logger = SSEKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Sending SSE request to " + httpRequestBuilder.getUrl());
            }
            httpRequestBuilder.setCapability(SSECapability.INSTANCE, Unit.INSTANCE);
            Duration duration = (Duration) SSEKt.getAttributeValue(httpRequestBuilder, BuildersKt.getReconnectionTimeAttr());
            Boolean bool = (Boolean) SSEKt.getAttributeValue(httpRequestBuilder, BuildersKt.getShowCommentEventsAttr());
            Boolean bool2 = (Boolean) SSEKt.getAttributeValue(httpRequestBuilder, BuildersKt.getShowRetryEventsAttr());
            SSEBufferPolicy sSEBufferPolicy = (SSEBufferPolicy) SSEKt.getAttributeValue(httpRequestBuilder, BuildersKt.getSseBufferPolicyAttr());
            httpRequestBuilder.getAttributes().put(HttpRequestKt.getResponseAdapterAttributeKey(), new SSEClientResponseAdapter());
            httpRequestBuilder.getAttributes().put(SSEKt.getSSEClientForReconnectionAttr(), this.$this_createClientPlugin.getClient());
            ContentType contentType = outgoingContent.getContentType();
            if (contentType != null) {
                HttpMessagePropertiesKt.contentType(httpRequestBuilder, contentType);
            }
            long rawValue = duration != null ? duration.getRawValue() : this.$reconnectionTime;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : this.$showCommentEvents;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : this.$showRetryEvents;
            int i = this.$maxReconnectionAttempts;
            if (sSEBufferPolicy == null) {
                sSEBufferPolicy = this.$bufferPolicy;
            }
            return new SSEClientContent(rawValue, zBooleanValue, zBooleanValue2, i, sSEBufferPolicy, get$context(), httpRequestBuilder, outgoingContent, null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
