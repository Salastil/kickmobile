package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Blocking.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/Job;", "parent", "Ljava/io/InputStream;", "toInputStream", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/coroutines/Job;)Ljava/io/InputStream;", "Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/io/OutputStream;", "toOutputStream", "(Lio/ktor/utils/io/ByteWriteChannel;)Ljava/io/OutputStream;", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BlockingKt {
    public static final InputStream toInputStream(final ByteReadChannel byteReadChannel, Job job) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        return new InputStream() { // from class: io.ktor.utils.io.jvm.javaio.BlockingKt.toInputStream.1
            @Override // java.io.InputStream
            public int read() throws InterruptedException {
                if (byteReadChannel.isClosedForRead()) {
                    return -1;
                }
                if (byteReadChannel.getReadBuffer().exhausted()) {
                    blockingWait();
                }
                if (byteReadChannel.isClosedForRead()) {
                    return -1;
                }
                return byteReadChannel.getReadBuffer().readByte() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] b, int off, int len) throws InterruptedException {
                Intrinsics.checkNotNullParameter(b, "b");
                if (byteReadChannel.isClosedForRead()) {
                    return -1;
                }
                if (byteReadChannel.getReadBuffer().exhausted()) {
                    blockingWait();
                }
                int atMostTo = byteReadChannel.getReadBuffer().readAtMostTo(b, off, Math.min(ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel), len) + off);
                if (atMostTo >= 0) {
                    return atMostTo;
                }
                return byteReadChannel.isClosedForRead() ? -1 : 0;
            }

            private final void blockingWait() throws InterruptedException {
                BuildersKt__BuildersKt.runBlocking$default(null, new BlockingKt$toInputStream$1$blockingWait$1(byteReadChannel, null), 1, null);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                ByteReadChannelKt.cancel(byteReadChannel);
            }
        };
    }

    public static /* synthetic */ InputStream toInputStream$default(ByteReadChannel byteReadChannel, Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return toInputStream(byteReadChannel, job);
    }

    public static final OutputStream toOutputStream(final ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        return new OutputStream() { // from class: io.ktor.utils.io.jvm.javaio.BlockingKt.toOutputStream.1
            @Override // java.io.OutputStream
            public void write(int b) throws InterruptedException {
                BuildersKt__BuildersKt.runBlocking$default(null, new BlockingKt$toOutputStream$1$write$1(byteWriteChannel, b, null), 1, null);
            }

            @Override // java.io.OutputStream
            public void write(byte[] b, int off, int len) throws InterruptedException {
                Intrinsics.checkNotNullParameter(b, "b");
                BuildersKt__BuildersKt.runBlocking$default(null, new BlockingKt$toOutputStream$1$write$2(byteWriteChannel, b, off, len, null), 1, null);
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws InterruptedException {
                BuildersKt__BuildersKt.runBlocking$default(null, new BlockingKt$toOutputStream$1$flush$1(byteWriteChannel, null), 1, null);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws InterruptedException {
                BuildersKt__BuildersKt.runBlocking$default(null, new BlockingKt$toOutputStream$1$close$1(byteWriteChannel, null), 1, null);
            }
        };
    }
}
