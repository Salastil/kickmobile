package io.ktor.client.plugins.logging;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;

/* JADX INFO: compiled from: LogBodyFilter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\n\u000b\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/logging/BodyFilterResult;", "", "", "getByteSize", "()Ljava/lang/Long;", "byteSize", "Empty", "Skip", "Content", "BufferContent", "Lio/ktor/client/plugins/logging/BodyFilterResult$Content;", "Lio/ktor/client/plugins/logging/BodyFilterResult$Empty;", "Lio/ktor/client/plugins/logging/BodyFilterResult$Skip;", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface BodyFilterResult {
    default Long getByteSize() {
        return null;
    }

    /* JADX INFO: compiled from: LogBodyFilter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Long getByteSize(BodyFilterResult bodyFilterResult) {
            return BodyFilterResult.super.getByteSize();
        }
    }

    /* JADX INFO: compiled from: LogBodyFilter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/client/plugins/logging/BodyFilterResult$Empty;", "Lio/ktor/client/plugins/logging/BodyFilterResult;", "<init>", "()V", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Empty implements BodyFilterResult {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Override // io.ktor.client.plugins.logging.BodyFilterResult
        public /* bridge */ Long getByteSize() {
            return super.getByteSize();
        }
    }

    /* JADX INFO: compiled from: LogBodyFilter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/logging/BodyFilterResult$Skip;", "Lio/ktor/client/plugins/logging/BodyFilterResult;", "", "reason", "", "byteSize", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "Ljava/lang/Long;", "getByteSize", "()Ljava/lang/Long;", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Skip implements BodyFilterResult {
        private final Long byteSize;
        private final String reason;

        /* JADX WARN: Multi-variable type inference failed */
        public Skip() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public Skip(String str, Long l) {
            this.reason = str;
            this.byteSize = l;
        }

        public /* synthetic */ Skip(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l);
        }

        public final String getReason() {
            return this.reason;
        }

        @Override // io.ktor.client.plugins.logging.BodyFilterResult
        public Long getByteSize() {
            return this.byteSize;
        }
    }

    /* JADX INFO: compiled from: LogBodyFilter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/logging/BodyFilterResult$Content;", "Lio/ktor/client/plugins/logging/BodyFilterResult;", "", "read", "()Ljava/lang/String;", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface Content extends BodyFilterResult {
        String read();

        /* JADX INFO: compiled from: LogBodyFilter.kt */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static Long getByteSize(Content content) {
                return Content.super.getByteSize();
            }
        }
    }

    /* JADX INFO: compiled from: LogBodyFilter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0018\u0010\u0006\u001a\u00060\u0004j\u0002`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/logging/BodyFilterResult$BufferContent;", "Lio/ktor/client/plugins/logging/BodyFilterResult$Content;", "Lkotlinx/io/Buffer;", "buffer", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "", "byteSize", "<init>", "(Lkotlinx/io/Buffer;Ljava/nio/charset/Charset;J)V", "", "read", "()Ljava/lang/String;", "Lkotlinx/io/Buffer;", "Ljava/nio/charset/Charset;", "J", "getByteSize", "()Ljava/lang/Long;", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class BufferContent implements Content {
        private final Buffer buffer;
        private final long byteSize;
        private final Charset charset;

        public BufferContent(Buffer buffer, Charset charset, long j) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            Intrinsics.checkNotNullParameter(charset, "charset");
            this.buffer = buffer;
            this.charset = charset;
            this.byteSize = j;
        }

        public /* synthetic */ BufferContent(Buffer buffer, Charset charset, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(buffer, charset, (i & 4) != 0 ? buffer.getSizeMut() : j);
        }

        @Override // io.ktor.client.plugins.logging.BodyFilterResult
        public Long getByteSize() {
            return Long.valueOf(this.byteSize);
        }

        @Override // io.ktor.client.plugins.logging.BodyFilterResult.Content
        public String read() {
            return StringsKt.readText$default(this.buffer, this.charset, 0, 2, null);
        }
    }
}
