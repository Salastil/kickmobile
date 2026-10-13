package io.ktor.client.engine.okhttp;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpMethodKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.OutgoingContentKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.JobKt;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import okio.BufferedSource;

/* JADX INFO: compiled from: OkHttpEngine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a#\u0010\u0011\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a#\u0010\u0015\u001a\u00020\u0014*\u00020\u00132\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u001a\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lokio/BufferedSource;", "Lkotlin/coroutines/CoroutineContext;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lio/ktor/client/request/HttpRequestData;", "requestData", "Lio/ktor/utils/io/ByteReadChannel;", "toChannel", "(Lokio/BufferedSource;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/request/HttpRequestData;)Lio/ktor/utils/io/ByteReadChannel;", "", "cause", "request", "mapExceptions", "(Ljava/lang/Throwable;Lio/ktor/client/request/HttpRequestData;)Ljava/lang/Throwable;", "callContext", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "config", "Lokhttp3/Request;", "convertToOkHttpRequest", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/engine/okhttp/OkHttpConfig;)Lokhttp3/Request;", "Lio/ktor/http/content/OutgoingContent;", "Lokhttp3/RequestBody;", "convertToOkHttpBody", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/engine/okhttp/OkHttpConfig;)Lokhttp3/RequestBody;", "Lokhttp3/OkHttpClient$Builder;", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "timeoutAttributes", "setupTimeoutAttributes", "(Lokhttp3/OkHttpClient$Builder;Lio/ktor/client/plugins/HttpTimeoutConfig;)Lokhttp3/OkHttpClient$Builder;", "ktor-client-okhttp"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class OkHttpEngineKt {

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: OkHttpEngine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1", f = "OkHttpEngine.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {168, 177}, m = "invokeSuspend", n = {"$this$writer", "$this$use$iv", "source", "lastRead", "$i$f$use", "$i$a$-use-OkHttpEngineKt$toChannel$1$1", "$this$writer", "$this$use$iv", "source", "lastRead", "$i$f$use", "$i$a$-use-OkHttpEngineKt$toChannel$1$1"}, s = {"L$0", "L$1", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $context;
        final /* synthetic */ HttpRequestData $requestData;
        final /* synthetic */ BufferedSource $this_toChannel;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_toChannel = bufferedSource;
            this.$context = coroutineContext;
            this.$requestData = httpRequestData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_toChannel, this.$context, this.$requestData, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00df  */
        /* JADX WARN: Code duplicated, block: B:53:0x0104  */
        /* JADX WARN: Code duplicated, block: B:55:0x0107  */
        /* JADX WARN: Code duplicated, block: B:58:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00dc, code lost:
        
            if (r13.flush(r18) == r7) goto L31;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00dc -> B:8:0x0031). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 264
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngineKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(Ref.IntRef intRef, BufferedSource bufferedSource, HttpRequestData httpRequestData, CoroutineContext coroutineContext, ByteBuffer byteBuffer) throws Throwable {
            Object objM12684constructorimpl;
            try {
                intRef.element = bufferedSource.read(byteBuffer);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(JobKt.getJob(coroutineContext).getCancellationException());
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                CancellationException cancellationException = (CancellationException) objM12684constructorimpl;
                if (cancellationException != null) {
                    th = cancellationException;
                }
                throw OkHttpEngineKt.mapExceptions(th, httpRequestData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel toChannel(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData) {
        return ByteWriteChannelOperationsKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, (Function2) new AnonymousClass1(bufferedSource, coroutineContext, httpRequestData, null), 2, (Object) null).getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapExceptions(Throwable th, HttpRequestData httpRequestData) {
        return th instanceof SocketTimeoutException ? HttpTimeoutKt.SocketTimeoutException(httpRequestData, th) : th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request convertToOkHttpRequest(HttpRequestData httpRequestData, CoroutineContext coroutineContext, OkHttpConfig okHttpConfig) {
        final Request.Builder builder = new Request.Builder();
        builder.url(httpRequestData.getUrl().getUrlString());
        final boolean z = !HttpMethodKt.getSupportsRequestBody(httpRequestData.getMethod()) && OutgoingContentKt.isEmpty(httpRequestData.getBody());
        UtilsKt.mergeHeaders(httpRequestData.getHeaders(), httpRequestData.getBody(), new Function2<String, String, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpRequest$lambda$0$$inlined$forEachHeader$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String key, String value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                if (z && Intrinsics.areEqual(key, "Content-Length")) {
                    return;
                }
                builder.addHeader(key, value);
            }
        });
        builder.method(httpRequestData.getMethod().getValue(), HttpMethod.permitsRequestBody(httpRequestData.getMethod().getValue()) ? convertToOkHttpBody(httpRequestData.getBody(), coroutineContext, okHttpConfig) : null);
        return builder.build();
    }

    public static final RequestBody convertToOkHttpBody(final OutgoingContent outgoingContent, final CoroutineContext callContext, OkHttpConfig config) {
        Intrinsics.checkNotNullParameter(outgoingContent, "<this>");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        Intrinsics.checkNotNullParameter(config, "config");
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            byte[] bArrBytes = ((OutgoingContent.ByteArrayContent) outgoingContent).getContent();
            return RequestBody.INSTANCE.create(bArrBytes, MediaType.INSTANCE.parse(String.valueOf(outgoingContent.getContentType())), 0, bArrBytes.length);
        }
        if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new StreamRequestBody(callContext, outgoingContent.getContentLength(), config.getDuplexStreamingEnabled(), new Function0() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ((OutgoingContent.ReadChannelContent) outgoingContent).getChannel();
                }
            });
        }
        if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            return new StreamRequestBody(callContext, outgoingContent.getContentLength(), config.getDuplexStreamingEnabled(), new Function0() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ByteWriteChannelOperationsKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, callContext, false, (Function2) new OkHttpEngineKt$convertToOkHttpBody$3$1(outgoingContent, null), 2, (Object) null).getChannel();
                }
            });
        }
        if (outgoingContent instanceof OutgoingContent.NoContent) {
            return RequestBody.INSTANCE.create(new byte[0], (MediaType) null, 0, 0);
        }
        if (outgoingContent instanceof OutgoingContent.ContentWrapper) {
            return convertToOkHttpBody(((OutgoingContent.ContentWrapper) outgoingContent).getDelegate(), callContext, config);
        }
        if (outgoingContent instanceof OutgoingContent.ProtocolUpgrade) {
            throw new UnsupportedContentTypeException(outgoingContent);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient.Builder setupTimeoutAttributes(OkHttpClient.Builder builder, HttpTimeoutConfig httpTimeoutConfig) {
        Long l = httpTimeoutConfig.get_connectTimeoutMillis();
        if (l != null) {
            builder.connectTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(l.longValue()), TimeUnit.MILLISECONDS);
        }
        Long l2 = httpTimeoutConfig.get_socketTimeoutMillis();
        if (l2 != null) {
            long jLongValue = l2.longValue();
            builder.readTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(jLongValue), TimeUnit.MILLISECONDS);
            builder.writeTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(jLongValue), TimeUnit.MILLISECONDS);
        }
        return builder;
    }
}
