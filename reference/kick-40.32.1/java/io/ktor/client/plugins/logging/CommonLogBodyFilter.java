package io.ktor.client.plugins.logging;

import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.Url;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: LogBodyFilter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bæ\u0080\u0001\u0018\u00002\u00020\u0001J<\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ<\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u000f\u0010\u000eJ4\u0010\u0010\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH¦@¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/logging/CommonLogBodyFilter;", "Lio/ktor/client/plugins/logging/LogBodyFilter;", "Lio/ktor/http/Url;", ImagesContract.URL, "", "contentLength", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/utils/io/ByteReadChannel;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lio/ktor/client/plugins/logging/BodyFilterResult;", "filterRequest", "(Lio/ktor/http/Url;Ljava/lang/Long;Lio/ktor/http/ContentType;Lio/ktor/http/Headers;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterResponse", "filterAll", "(Ljava/lang/Long;Lio/ktor/http/ContentType;Lio/ktor/http/Headers;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface CommonLogBodyFilter extends LogBodyFilter {
    Object filterAll(Long l, ContentType contentType, Headers headers, ByteReadChannel byteReadChannel, Continuation<? super BodyFilterResult> continuation);

    @Override // io.ktor.client.plugins.logging.LogBodyFilter
    default Object filterRequest(Url url, Long l, ContentType contentType, Headers headers, ByteReadChannel byteReadChannel, Continuation<? super BodyFilterResult> continuation) {
        return filterRequest$suspendImpl(this, url, l, contentType, headers, byteReadChannel, continuation);
    }

    @Override // io.ktor.client.plugins.logging.LogBodyFilter
    default Object filterResponse(Url url, Long l, ContentType contentType, Headers headers, ByteReadChannel byteReadChannel, Continuation<? super BodyFilterResult> continuation) {
        return filterResponse$suspendImpl(this, url, l, contentType, headers, byteReadChannel, continuation);
    }

    /* JADX INFO: compiled from: LogBodyFilter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object filterRequest(CommonLogBodyFilter commonLogBodyFilter, Url url, Long l, ContentType contentType, Headers headers, ByteReadChannel byteReadChannel, Continuation<? super BodyFilterResult> continuation) {
            return CommonLogBodyFilter.super.filterRequest(url, l, contentType, headers, byteReadChannel, continuation);
        }

        @Deprecated
        public static Object filterResponse(CommonLogBodyFilter commonLogBodyFilter, Url url, Long l, ContentType contentType, Headers headers, ByteReadChannel byteReadChannel, Continuation<? super BodyFilterResult> continuation) {
            return CommonLogBodyFilter.super.filterResponse(url, l, contentType, headers, byteReadChannel, continuation);
        }
    }

    static /* synthetic */ Object filterRequest$suspendImpl(CommonLogBodyFilter commonLogBodyFilter, Url url, Long l, ContentType contentType, Headers headers, ByteReadChannel byteReadChannel, Continuation<? super BodyFilterResult> continuation) {
        return commonLogBodyFilter.filterAll(l, contentType, headers, byteReadChannel, continuation);
    }

    static /* synthetic */ Object filterResponse$suspendImpl(CommonLogBodyFilter commonLogBodyFilter, Url url, Long l, ContentType contentType, Headers headers, ByteReadChannel byteReadChannel, Continuation<? super BodyFilterResult> continuation) {
        return commonLogBodyFilter.filterAll(l, contentType, headers, byteReadChannel, continuation);
    }
}
