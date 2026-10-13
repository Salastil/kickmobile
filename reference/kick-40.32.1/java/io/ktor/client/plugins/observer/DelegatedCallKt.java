package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DelegatedCall.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0004\b\u0003\u0010\u0007\u001a#\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/utils/io/ByteReadChannel;", "content", "wrapWithContent", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/client/call/HttpClientCall;", "Lkotlin/Function0;", "block", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/jvm/functions/Function0;)Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/http/Headers;", "headers", "wrap", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/Headers;)Lio/ktor/client/call/HttpClientCall;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DelegatedCallKt {
    static final ByteReadChannel wrap$lambda$0(ByteReadChannel byteReadChannel, HttpResponse replaceResponse) {
        Intrinsics.checkNotNullParameter(replaceResponse, "$this$replaceResponse");
        return byteReadChannel;
    }

    static final ByteReadChannel wrapWithContent$lambda$0(ByteReadChannel byteReadChannel, HttpResponse replaceResponse) {
        Intrinsics.checkNotNullParameter(replaceResponse, "$this$replaceResponse");
        return byteReadChannel;
    }

    @Deprecated(message = "Use 'replaceResponse' instead.", replaceWith = @ReplaceWith(expression = "replaceResponse { content }", imports = {"io.ktor.client.call.replaceResponse"}))
    public static final HttpClientCall wrapWithContent(HttpClientCall httpClientCall, final ByteReadChannel content) {
        Intrinsics.checkNotNullParameter(httpClientCall, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        return io.ktor.client.call.DelegatedCallKt.replaceResponse$default(httpClientCall, null, new Function1() { // from class: io.ktor.client.plugins.observer.DelegatedCallKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DelegatedCallKt.wrapWithContent$lambda$0(content, (HttpResponse) obj);
            }
        }, 1, null);
    }

    @Deprecated(message = "Use 'replaceResponse' instead.", replaceWith = @ReplaceWith(expression = "replaceResponse { block() }", imports = {"io.ktor.client.call.replaceResponse"}))
    public static final HttpClientCall wrapWithContent(HttpClientCall httpClientCall, final Function0<? extends ByteReadChannel> block) {
        Intrinsics.checkNotNullParameter(httpClientCall, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return io.ktor.client.call.DelegatedCallKt.replaceResponse$default(httpClientCall, null, new Function1() { // from class: io.ktor.client.plugins.observer.DelegatedCallKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DelegatedCallKt.wrapWithContent$lambda$1(block, (HttpResponse) obj);
            }
        }, 1, null);
    }

    static final ByteReadChannel wrapWithContent$lambda$1(Function0 function0, HttpResponse replaceResponse) {
        Intrinsics.checkNotNullParameter(replaceResponse, "$this$replaceResponse");
        return (ByteReadChannel) function0.invoke();
    }

    @Deprecated(message = "Use 'replaceResponse' instead.", replaceWith = @ReplaceWith(expression = "replaceResponse(headers) { content }", imports = {"io.ktor.client.call.replaceResponse"}))
    public static final HttpClientCall wrap(HttpClientCall httpClientCall, final ByteReadChannel content, Headers headers) {
        Intrinsics.checkNotNullParameter(httpClientCall, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return io.ktor.client.call.DelegatedCallKt.replaceResponse(httpClientCall, headers, new Function1() { // from class: io.ktor.client.plugins.observer.DelegatedCallKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DelegatedCallKt.wrap$lambda$0(content, (HttpResponse) obj);
            }
        });
    }
}
