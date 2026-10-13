package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.InternalLogger;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* JADX INFO: compiled from: GzipRequestInterceptor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/GzipRequestInterceptor;", "Lokhttp3/Interceptor;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", GzipRequestInterceptor.ENCODING_GZIP, "Lokhttp3/RequestBody;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GzipRequestInterceptor implements Interceptor {
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ENCODING = "Content-Encoding";
    private final InternalLogger internalLogger;

    public GzipRequestInterceptor(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody == null || request.header("Content-Encoding") != null || (requestBodyBody instanceof MultipartBody)) {
            return chain.proceed(request);
        }
        try {
            request = request.newBuilder().header("Content-Encoding", ENCODING_GZIP).method(request.method(), gzip(requestBodyBody)).build();
        } catch (Exception e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.data.upload.GzipRequestInterceptor$intercept$compressedRequest$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to gzip request body";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
        return chain.proceed(request);
    }

    private final RequestBody gzip(final RequestBody body) {
        return new RequestBody() { // from class: com.datadog.android.core.internal.data.upload.GzipRequestInterceptor.gzip.1
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: contentType */
            public MediaType getContentType() {
                return body.getContentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink sink) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(sink));
                body.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
            }
        };
    }
}
