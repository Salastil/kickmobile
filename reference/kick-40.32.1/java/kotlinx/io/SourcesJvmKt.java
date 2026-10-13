package kotlinx.io;

import androidx.collection.SieveCacheKt;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* JADX INFO: compiled from: SourcesJvm.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\t\u001a\u00020\n*\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\b¨\u0006\u0011"}, d2 = {"readStringImpl", "", "Lkotlinx/io/Buffer;", "byteCount", "", HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "readString", "Lkotlinx/io/Source;", "asInputStream", "Ljava/io/InputStream;", "readAtMostTo", "", "sink", "Ljava/nio/ByteBuffer;", "asByteChannel", "Ljava/nio/channels/ReadableByteChannel;", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SourcesJvmKt {
    static final boolean asByteChannel$lambda$3() {
        return false;
    }

    static final boolean asInputStream$lambda$2() {
        return false;
    }

    private static final String readStringImpl(Buffer buffer, long j, Charset charset) throws EOFException {
        String str;
        int i;
        if (j < 0 || j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("byteCount (" + j + ") is not within the range [0..2147483647)").toString());
        }
        if (buffer.getSizeMut() < j) {
            throw new EOFException("Buffer contains less bytes then required (byteCount: " + j + ", size: " + buffer.getSizeMut() + ')');
        }
        if (j == 0) {
            return "";
        }
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        if (buffer.exhausted()) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head = buffer.getHead();
        Intrinsics.checkNotNull(head);
        byte[] bArrDataAsByteArray = head.dataAsByteArray(true);
        int pos = head.getPos();
        if (head.getLimit() - pos >= j) {
            i = (int) j;
            str = new String(bArrDataAsByteArray, pos, i, charset);
        } else {
            str = null;
            i = 0;
        }
        if (i != 0) {
            if (i < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (i > head.getSize()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            buffer.skip(i);
        }
        return str == null ? new String(SourcesKt.readByteArray(buffer, (int) j), charset) : str;
    }

    public static final String readString(Source source, Charset charset) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        for (long j = 1; source.request(j); j *= 2) {
        }
        return readStringImpl(source.getBufferField(), source.getBufferField().getSizeMut(), charset);
    }

    public static final String readString(Source source, long j, Charset charset) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        source.require(j);
        return readStringImpl(source.getBufferField(), j, charset);
    }

    public static final InputStream asInputStream(final Source source) {
        final MutablePropertyReference0Impl mutablePropertyReference0Impl;
        Intrinsics.checkNotNullParameter(source, "<this>");
        if (source instanceof RealSource) {
            mutablePropertyReference0Impl = new MutablePropertyReference0Impl(source) { // from class: kotlinx.io.SourcesJvmKt$asInputStream$isClosed$1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return Boolean.valueOf(((RealSource) this.receiver).closed);
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(Object obj) {
                    ((RealSource) this.receiver).closed = ((Boolean) obj).booleanValue();
                }
            };
        } else {
            if (!(source instanceof Buffer)) {
                throw new NoWhenBranchMatchedException();
            }
            mutablePropertyReference0Impl = new Function0() { // from class: kotlinx.io.SourcesJvmKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(SourcesJvmKt.asInputStream$lambda$2());
                }
            };
        }
        return new InputStream() { // from class: kotlinx.io.SourcesJvmKt.asInputStream.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (mutablePropertyReference0Impl.invoke().booleanValue()) {
                    throw new IOException("Underlying source is closed.");
                }
                if (source.exhausted()) {
                    return -1;
                }
                return source.readByte() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] data, int offset, int byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(data, "data");
                if (mutablePropertyReference0Impl.invoke().booleanValue()) {
                    throw new IOException("Underlying source is closed.");
                }
                _UtilKt.checkOffsetAndCount(data.length, offset, byteCount);
                return source.readAtMostTo(data, offset, byteCount + offset);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (mutablePropertyReference0Impl.invoke().booleanValue()) {
                    throw new IOException("Underlying source is closed.");
                }
                return (int) Math.min(source.getBufferField().getSizeMut(), SieveCacheKt.NodeLinkMask);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                source.close();
            }

            public String toString() {
                return source + ".asInputStream()";
            }
        };
    }

    public static final int readAtMostTo(Source source, ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (source.getBufferField().getSizeMut() == 0) {
            source.request(8192L);
            if (source.getBufferField().getSizeMut() == 0) {
                return -1;
            }
        }
        return BuffersJvmKt.readAtMostTo(source.getBufferField(), sink);
    }

    public static final ReadableByteChannel asByteChannel(final Source source) {
        final MutablePropertyReference0Impl mutablePropertyReference0Impl;
        Intrinsics.checkNotNullParameter(source, "<this>");
        if (source instanceof RealSource) {
            mutablePropertyReference0Impl = new MutablePropertyReference0Impl(source) { // from class: kotlinx.io.SourcesJvmKt$asByteChannel$isClosed$1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return Boolean.valueOf(((RealSource) this.receiver).closed);
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(Object obj) {
                    ((RealSource) this.receiver).closed = ((Boolean) obj).booleanValue();
                }
            };
        } else {
            if (!(source instanceof Buffer)) {
                throw new NoWhenBranchMatchedException();
            }
            mutablePropertyReference0Impl = new Function0() { // from class: kotlinx.io.SourcesJvmKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(SourcesJvmKt.asByteChannel$lambda$3());
                }
            };
        }
        return new ReadableByteChannel() { // from class: kotlinx.io.SourcesJvmKt.asByteChannel.1
            @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                source.close();
            }

            @Override // java.nio.channels.Channel
            public boolean isOpen() {
                return !mutablePropertyReference0Impl.invoke().booleanValue();
            }

            @Override // java.nio.channels.ReadableByteChannel
            public int read(ByteBuffer sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                return SourcesJvmKt.readAtMostTo(source, sink);
            }
        };
    }
}
