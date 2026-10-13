package io.ktor.client.plugins.sse;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.CacheControl;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSEClientContent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013H\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020,8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lio/ktor/client/plugins/sse/SSEClientContent;", "Lio/ktor/http/content/OutgoingContent$ContentWrapper;", "Lkotlin/time/Duration;", "reconnectionTime", "", "showCommentEvents", "showRetryEvents", "", "maxReconnectionAttempts", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "bufferPolicy", "Lkotlin/coroutines/CoroutineContext;", "callContext", "Lio/ktor/client/request/HttpRequestBuilder;", "initialRequest", "Lio/ktor/http/content/OutgoingContent;", "requestBody", "<init>", "(JZZILio/ktor/client/plugins/sse/SSEBufferPolicy;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "toString", "()Ljava/lang/String;", "delegate", "copy", "(Lio/ktor/http/content/OutgoingContent;)Lio/ktor/client/plugins/sse/SSEClientContent;", "J", "getReconnectionTime-UwyO8pc", "()J", "Z", "getShowCommentEvents", "()Z", "getShowRetryEvents", "I", "getMaxReconnectionAttempts", "()I", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "getBufferPolicy", "()Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "Lkotlin/coroutines/CoroutineContext;", "getCallContext", "()Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "getInitialRequest", "()Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SSEClientContent extends OutgoingContent.ContentWrapper {
    private final SSEBufferPolicy bufferPolicy;
    private final CoroutineContext callContext;
    private final Headers headers;
    private final HttpRequestBuilder initialRequest;
    private final int maxReconnectionAttempts;
    private final long reconnectionTime;
    private final boolean showCommentEvents;
    private final boolean showRetryEvents;

    public /* synthetic */ SSEClientContent(long j, boolean z, boolean z2, int i, SSEBufferPolicy sSEBufferPolicy, CoroutineContext coroutineContext, HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, z, z2, i, sSEBufferPolicy, coroutineContext, httpRequestBuilder, outgoingContent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private SSEClientContent(long j, boolean z, boolean z2, int i, SSEBufferPolicy bufferPolicy, CoroutineContext callContext, HttpRequestBuilder initialRequest, OutgoingContent requestBody) {
        super(requestBody);
        Intrinsics.checkNotNullParameter(bufferPolicy, "bufferPolicy");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        Intrinsics.checkNotNullParameter(initialRequest, "initialRequest");
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        this.reconnectionTime = j;
        this.showCommentEvents = z;
        this.showRetryEvents = z2;
        this.maxReconnectionAttempts = i;
        this.bufferPolicy = bufferPolicy;
        this.callContext = callContext;
        this.initialRequest = initialRequest;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.appendAll(requestBody.getHeaders());
        HeaderValueWithParametersKt.append(headersBuilder, "Accept", ContentType.Text.INSTANCE.getEventStream());
        headersBuilder.append("Cache-Control", CacheControl.NO_STORE);
        this.headers = headersBuilder.build();
    }

    /* JADX INFO: renamed from: getReconnectionTime-UwyO8pc, reason: not valid java name and from getter */
    public final long getReconnectionTime() {
        return this.reconnectionTime;
    }

    public final boolean getShowCommentEvents() {
        return this.showCommentEvents;
    }

    public final boolean getShowRetryEvents() {
        return this.showRetryEvents;
    }

    public final int getMaxReconnectionAttempts() {
        return this.maxReconnectionAttempts;
    }

    public final SSEBufferPolicy getBufferPolicy() {
        return this.bufferPolicy;
    }

    public final CoroutineContext getCallContext() {
        return this.callContext;
    }

    public final HttpRequestBuilder getInitialRequest() {
        return this.initialRequest;
    }

    @Override // io.ktor.http.content.OutgoingContent.ContentWrapper, io.ktor.http.content.OutgoingContent
    public Headers getHeaders() {
        return this.headers;
    }

    public String toString() {
        return "SSEClientContent";
    }

    @Override // io.ktor.http.content.OutgoingContent.ContentWrapper
    public SSEClientContent copy(OutgoingContent delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new SSEClientContent(this.reconnectionTime, this.showCommentEvents, this.showRetryEvents, this.maxReconnectionAttempts, this.bufferPolicy, this.callContext, this.initialRequest, delegate, null);
    }
}
