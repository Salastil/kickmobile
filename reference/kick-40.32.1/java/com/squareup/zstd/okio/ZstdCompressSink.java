package com.squareup.zstd.okio;

import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.squareup.zstd.Zstd;
import com.squareup.zstd.ZstdCompressor;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: compiled from: ZstdCompressSink.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/squareup/zstd/okio/ZstdCompressSink;", "Lokio/Sink;", "sink", "Lokio/BufferedSink;", "compressor", "Lcom/squareup/zstd/ZstdCompressor;", "<init>", "(Lokio/BufferedSink;Lcom/squareup/zstd/ZstdCompressor;)V", "inputBuffer", "Lokio/Buffer;", "inputCursor", "Lokio/Buffer$UnsafeCursor;", "outputCursor", "closed", "", "write", "", "source", "byteCount", "", "flush", "close", "compress", "mode", "", InstrumentationTags.TIMEOUT, "Lokio/Timeout;", "zstd-kmp-okio_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ZstdCompressSink implements Sink {
    public boolean closed;
    private final ZstdCompressor compressor;
    private final Buffer inputBuffer;
    private final Buffer.UnsafeCursor inputCursor;
    private final Buffer.UnsafeCursor outputCursor;
    public final BufferedSink sink;

    public ZstdCompressSink(BufferedSink sink, ZstdCompressor compressor) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(compressor, "compressor");
        this.sink = sink;
        this.compressor = compressor;
        this.inputBuffer = new Buffer();
        this.inputCursor = new Buffer.UnsafeCursor();
        this.outputCursor = new Buffer.UnsafeCursor();
    }

    @Override // okio.Sink
    public void write(Buffer source, long byteCount) throws Throwable {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.inputBuffer.write(source, byteCount);
        compress(0);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws Throwable {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        compress(1);
        this.sink.flush();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        this.closed = true;
        BufferedSink bufferedSink = this.sink;
        try {
            ZstdCompressor zstdCompressor = this.compressor;
            try {
                compress(2);
                Unit unit = Unit.INSTANCE;
                th = null;
                AutoCloseableKt.closeFinally(zstdCompressor, null);
                Unit unit2 = Unit.INSTANCE;
                if (bufferedSink != null) {
                    try {
                        bufferedSink.close();
                    } catch (Throwable th) {
                        th = th;
                    }
                }
                if (th != null) {
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    AutoCloseableKt.closeFinally(zstdCompressor, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            if (bufferedSink != null) {
                try {
                    bufferedSink.close();
                } catch (Throwable th5) {
                    ExceptionsKt.addSuppressed(th, th5);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0126 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x010e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x010e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a8 A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #2 {all -> 0x00a5, blocks: (B:36:0x0094, B:39:0x00a8), top: B:82:0x0094 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x0100  */
    /* JADX WARN: Code duplicated, block: B:69:0x0105  */
    /* JADX WARN: Code duplicated, block: B:71:0x0109  */
    /* JADX WARN: Code duplicated, block: B:82:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final void compress(int mode) throws Throwable {
        long size;
        long j;
        Throwable th;
        long j2;
        Throwable th2;
        String errorName;
        long jCompressStream2;
        Throwable th3;
        Throwable th4;
        Buffer buffer = this.inputBuffer;
        long j3 = 0;
        if (mode == 0) {
            size = buffer.completeSegmentByteCount();
            if (size == 0) {
                return;
            }
        } else {
            size = buffer.size();
        }
        while (true) {
            Buffer.UnsafeCursor andWriteUnsafe = this.sink.getBuffer().readAndWriteUnsafe(this.outputCursor);
            try {
                Buffer.UnsafeCursor unsafeCursor = andWriteUnsafe;
                long size2 = this.sink.getBuffer().size();
                unsafeCursor.expandBuffer(1);
                th2 = null;
                try {
                    if (size > j3) {
                        Buffer.UnsafeCursor unsafe = this.inputBuffer.readUnsafe(this.inputCursor);
                        try {
                            Buffer.UnsafeCursor unsafeCursor2 = unsafe;
                            unsafeCursor2.next();
                            ZstdCompressor zstdCompressor = this.compressor;
                            byte[] bArr = unsafeCursor.data;
                            Intrinsics.checkNotNull(bArr);
                            int i = unsafeCursor.end;
                            int i2 = unsafeCursor.start;
                            j = j3;
                            try {
                                byte[] bArr2 = unsafeCursor2.data;
                                Intrinsics.checkNotNull(bArr2);
                                jCompressStream2 = zstdCompressor.compressStream2(bArr, i, i2, bArr2, unsafeCursor2.end, unsafeCursor2.start, mode);
                                try {
                                    Unit unit = Unit.INSTANCE;
                                    if (unsafe != null) {
                                        try {
                                            unsafe.close();
                                        } catch (Throwable th5) {
                                            th4 = th5;
                                        }
                                    }
                                    th4 = null;
                                } catch (Throwable th6) {
                                    j2 = jCompressStream2;
                                    th3 = th6;
                                    if (unsafe != null) {
                                        try {
                                            unsafe.close();
                                        } catch (Throwable th7) {
                                            ExceptionsKt.addSuppressed(th3, th7);
                                        }
                                    }
                                    th4 = th3;
                                    jCompressStream2 = j2;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                th3 = th;
                                j2 = j;
                                if (unsafe != null) {
                                    unsafe.close();
                                }
                                th4 = th3;
                                jCompressStream2 = j2;
                                if (th4 == null) {
                                    try {
                                        size -= (long) this.compressor.inputBytesProcessed;
                                        this.inputBuffer.skip(this.compressor.inputBytesProcessed);
                                        j2 = jCompressStream2;
                                        Long.valueOf(unsafeCursor.resizeBuffer(size2 + ((long) this.compressor.outputBytesProcessed)));
                                        if (andWriteUnsafe != null) {
                                            try {
                                                andWriteUnsafe.close();
                                            } catch (Throwable th9) {
                                                th2 = th9;
                                            }
                                        }
                                    } catch (Throwable th10) {
                                        th = th10;
                                        j2 = jCompressStream2;
                                        th = th;
                                        if (andWriteUnsafe != null) {
                                            try {
                                                andWriteUnsafe.close();
                                            } catch (Throwable th11) {
                                                ExceptionsKt.addSuppressed(th, th11);
                                            }
                                        }
                                        th2 = th;
                                    }
                                    if (th2 == null) {
                                        this.sink.emitCompleteSegments();
                                        errorName = Zstd.getErrorName(j2);
                                        if (errorName == null) {
                                            throw new IOException("zstd compress failed: " + errorName);
                                        }
                                        if (mode == 0) {
                                            if (size == j) {
                                                return;
                                            }
                                        } else if (size == j) {
                                            continue;
                                        }
                                        j3 = j;
                                    } else {
                                        throw th2;
                                    }
                                } else {
                                    throw th4;
                                }
                                th = th10;
                                j2 = jCompressStream2;
                                th = th;
                                if (andWriteUnsafe != null) {
                                    andWriteUnsafe.close();
                                }
                                th2 = th;
                                if (th2 == null) {
                                    this.sink.emitCompleteSegments();
                                    errorName = Zstd.getErrorName(j2);
                                    if (errorName == null) {
                                        throw new IOException("zstd compress failed: " + errorName);
                                    }
                                    if (mode == 0) {
                                        if (size == j) {
                                            return;
                                        }
                                    } else if (size == j) {
                                        continue;
                                    }
                                    j3 = j;
                                } else {
                                    throw th2;
                                }
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            j = j3;
                        }
                        if (th4 == null) {
                            size -= (long) this.compressor.inputBytesProcessed;
                            this.inputBuffer.skip(this.compressor.inputBytesProcessed);
                        } else {
                            throw th4;
                        }
                        th = th10;
                        j2 = jCompressStream2;
                        th = th;
                        if (andWriteUnsafe != null) {
                            andWriteUnsafe.close();
                        }
                        th2 = th;
                        if (th2 == null) {
                            this.sink.emitCompleteSegments();
                            errorName = Zstd.getErrorName(j2);
                            if (errorName == null) {
                                throw new IOException("zstd compress failed: " + errorName);
                            }
                            if (mode == 0) {
                                if (size == j) {
                                    return;
                                }
                            } else if (size == j && j2 == j) {
                                return;
                            }
                            j3 = j;
                        } else {
                            throw th2;
                        }
                    } else {
                        j = j3;
                        try {
                            ZstdCompressor zstdCompressor2 = this.compressor;
                            byte[] bArr3 = unsafeCursor.data;
                            Intrinsics.checkNotNull(bArr3);
                            jCompressStream2 = zstdCompressor2.compressStream2(bArr3, unsafeCursor.end, unsafeCursor.start, OkioZstd.getEmptyByteArray(), 0, 0, mode);
                        } catch (Throwable th13) {
                            th = th13;
                            th = th;
                            j2 = j;
                            if (andWriteUnsafe != null) {
                                andWriteUnsafe.close();
                            }
                            th2 = th;
                        }
                    }
                    Long.valueOf(unsafeCursor.resizeBuffer(size2 + ((long) this.compressor.outputBytesProcessed)));
                    if (andWriteUnsafe != null) {
                        andWriteUnsafe.close();
                    }
                } catch (Throwable th14) {
                    th = th14;
                    th = th;
                    if (andWriteUnsafe != null) {
                        andWriteUnsafe.close();
                    }
                    th2 = th;
                }
                j2 = jCompressStream2;
            } catch (Throwable th15) {
                th = th15;
                j = j3;
            }
            if (th2 == null) {
                this.sink.emitCompleteSegments();
                errorName = Zstd.getErrorName(j2);
                if (errorName == null) {
                    throw new IOException("zstd compress failed: " + errorName);
                }
                if (mode == 0) {
                    if (size == j) {
                        return;
                    }
                } else if (size == j) {
                    continue;
                }
                j3 = j;
            } else {
                throw th2;
            }
        }
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: timeout */
    public Timeout getTimeout() {
        return this.sink.getTimeout();
    }
}
