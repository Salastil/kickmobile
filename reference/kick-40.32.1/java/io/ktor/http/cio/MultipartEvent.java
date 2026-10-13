package io.ktor.http.cio;

import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.io.Source;

/* JADX INFO: compiled from: Multipart.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0003\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/cio/MultipartEvent;", "", "<init>", "()V", "", "release", "Preamble", "MultipartPart", "Epilogue", "Lio/ktor/http/cio/MultipartEvent$Epilogue;", "Lio/ktor/http/cio/MultipartEvent$MultipartPart;", "Lio/ktor/http/cio/MultipartEvent$Preamble;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class MultipartEvent {
    public /* synthetic */ MultipartEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract void release();

    private MultipartEvent() {
    }

    /* JADX INFO: compiled from: Multipart.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/cio/MultipartEvent$Preamble;", "Lio/ktor/http/cio/MultipartEvent;", "Lkotlinx/io/Source;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "<init>", "(Lkotlinx/io/Source;)V", "", "release", "()V", "Lkotlinx/io/Source;", "getBody", "()Lkotlinx/io/Source;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Preamble extends MultipartEvent {
        private final Source body;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Preamble(Source body) {
            super(null);
            Intrinsics.checkNotNullParameter(body, "body");
            this.body = body;
        }

        public final Source getBody() {
            return this.body;
        }

        @Override // io.ktor.http.cio.MultipartEvent
        public void release() {
            this.body.close();
        }
    }

    /* JADX INFO: compiled from: Multipart.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/http/cio/MultipartEvent$MultipartPart;", "Lio/ktor/http/cio/MultipartEvent;", "Lkotlinx/coroutines/Deferred;", "Lio/ktor/http/cio/HttpHeadersMap;", "headers", "Lio/ktor/utils/io/ByteReadChannel;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "<init>", "(Lkotlinx/coroutines/Deferred;Lio/ktor/utils/io/ByteReadChannel;)V", "", "release", "()V", "Lkotlinx/coroutines/Deferred;", "getHeaders", "()Lkotlinx/coroutines/Deferred;", "Lio/ktor/utils/io/ByteReadChannel;", "getBody", "()Lio/ktor/utils/io/ByteReadChannel;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class MultipartPart extends MultipartEvent {
        private final ByteReadChannel body;
        private final Deferred<HttpHeadersMap> headers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultipartPart(Deferred<HttpHeadersMap> headers, ByteReadChannel body) {
            super(null);
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(body, "body");
            this.headers = headers;
            this.body = body;
        }

        public final Deferred<HttpHeadersMap> getHeaders() {
            return this.headers;
        }

        public final ByteReadChannel getBody() {
            return this.body;
        }

        @Override // io.ktor.http.cio.MultipartEvent
        public void release() throws InterruptedException {
            this.headers.invokeOnCompletion(new Function1() { // from class: io.ktor.http.cio.MultipartEvent$MultipartPart$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MultipartEvent.MultipartPart.release$lambda$0(this.f$0, (Throwable) obj);
                }
            });
            MultipartJvmAndPosixKt.discardBlocking(this.body);
        }

        static final Unit release$lambda$0(MultipartPart multipartPart, Throwable th) {
            if (th != null) {
                multipartPart.headers.getCompleted().release();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: Multipart.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/cio/MultipartEvent$Epilogue;", "Lio/ktor/http/cio/MultipartEvent;", "Lkotlinx/io/Source;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "<init>", "(Lkotlinx/io/Source;)V", "", "release", "()V", "Lkotlinx/io/Source;", "getBody", "()Lkotlinx/io/Source;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Epilogue extends MultipartEvent {
        private final Source body;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Epilogue(Source body) {
            super(null);
            Intrinsics.checkNotNullParameter(body, "body");
            this.body = body;
        }

        public final Source getBody() {
            return this.body;
        }

        @Override // io.ktor.http.cio.MultipartEvent
        public void release() {
            this.body.close();
        }
    }
}
