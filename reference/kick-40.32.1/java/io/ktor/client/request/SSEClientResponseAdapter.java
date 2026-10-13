package io.ktor.client.request;

import kotlin.Metadata;

/* JADX INFO: compiled from: HttpRequest.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/request/SSEClientResponseAdapter;", "Lio/ktor/client/request/ResponseAdapter;", "<init>", "()V", "Lio/ktor/client/request/HttpRequestData;", "data", "Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/utils/io/ByteReadChannel;", "responseBody", "Lio/ktor/http/content/OutgoingContent;", "outgoingContent", "Lkotlin/coroutines/CoroutineContext;", "callContext", "", "adapt", "(Lio/ktor/client/request/HttpRequestData;Lio/ktor/http/HttpStatusCode;Lio/ktor/http/Headers;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SSEClientResponseAdapter implements ResponseAdapter {
    /* JADX WARN: Code duplicated, block: B:17:0x005b  */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, io.ktor.http.HttpStatusCode.INSTANCE.getNoContent()) != false) goto L19;
     */
    @Override // io.ktor.client.request.ResponseAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object adapt(io.ktor.client.request.HttpRequestData r1, io.ktor.http.HttpStatusCode r2, io.ktor.http.Headers r3, io.ktor.utils.io.ByteReadChannel r4, io.ktor.http.content.OutgoingContent r5, kotlin.coroutines.CoroutineContext r6) {
        /*
            r0 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "status"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "responseBody"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "outgoingContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "callContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "Content-Type"
            java.lang.String r0 = r3.get(r0)
            r3 = 0
            if (r0 == 0) goto L2e
            io.ktor.http.ContentType$Companion r6 = io.ktor.http.ContentType.INSTANCE
            io.ktor.http.ContentType r0 = r6.parse(r0)
            goto L2f
        L2e:
            r0 = r3
        L2f:
            boolean r6 = io.ktor.client.request.HttpRequestKt.isSseRequest(r1)
            if (r6 == 0) goto L6f
            boolean r1 = io.ktor.client.request.HttpRequestKt.isSseReconnectionRequest(r1)
            if (r1 != 0) goto L6f
            io.ktor.http.HttpStatusCode$Companion r1 = io.ktor.http.HttpStatusCode.INSTANCE
            io.ktor.http.HttpStatusCode r1 = r1.getOK()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r1)
            if (r1 == 0) goto L5b
            if (r0 == 0) goto L4e
            io.ktor.http.ContentType r0 = r0.withoutParameters()
            goto L4f
        L4e:
            r0 = r3
        L4f:
            io.ktor.http.ContentType$Text r1 = io.ktor.http.ContentType.Text.INSTANCE
            io.ktor.http.ContentType r1 = r1.getEventStream()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L67
        L5b:
            io.ktor.http.HttpStatusCode$Companion r0 = io.ktor.http.HttpStatusCode.INSTANCE
            io.ktor.http.HttpStatusCode r0 = r0.getNoContent()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
            if (r0 == 0) goto L6f
        L67:
            io.ktor.client.plugins.sse.SSEClientContent r5 = (io.ktor.client.plugins.sse.SSEClientContent) r5
            io.ktor.client.plugins.sse.DefaultClientSSESession r0 = new io.ktor.client.plugins.sse.DefaultClientSSESession
            r0.<init>(r5, r4)
            return r0
        L6f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.SSEClientResponseAdapter.adapt(io.ktor.client.request.HttpRequestData, io.ktor.http.HttpStatusCode, io.ktor.http.Headers, io.ktor.utils.io.ByteReadChannel, io.ktor.http.content.OutgoingContent, kotlin.coroutines.CoroutineContext):java.lang.Object");
    }
}
