package com.squareup.zstd.okio;

import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.squareup.zstd.Zstd;
import com.squareup.zstd.ZstdDecompressor;
import java.io.EOFException;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: ZstdDecompressSource.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/squareup/zstd/okio/ZstdDecompressSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "decompressor", "Lcom/squareup/zstd/ZstdDecompressor;", "<init>", "(Lokio/BufferedSource;Lcom/squareup/zstd/ZstdDecompressor;)V", "inputCursor", "Lokio/Buffer$UnsafeCursor;", "outputBuffer", "Lokio/Buffer;", "outputCursor", "lastDecompressResult", "", "closed", "", "read", "sink", "byteCount", "close", "", "refillIfNecessary", InstrumentationTags.TIMEOUT, "Lokio/Timeout;", "zstd-kmp-okio_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ZstdDecompressSource implements Source {
    public boolean closed;
    private final ZstdDecompressor decompressor;
    private final Buffer.UnsafeCursor inputCursor;
    private long lastDecompressResult;
    private final Buffer outputBuffer;
    private final Buffer.UnsafeCursor outputCursor;
    public final BufferedSource source;

    public ZstdDecompressSource(BufferedSource source, ZstdDecompressor decompressor) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(decompressor, "decompressor");
        this.source = source;
        this.decompressor = decompressor;
        this.inputCursor = new Buffer.UnsafeCursor();
        this.outputBuffer = new Buffer();
        this.outputCursor = new Buffer.UnsafeCursor();
    }

    @Override // okio.Source
    public long read(Buffer sink, long byteCount) throws Throwable {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (byteCount == 0) {
            return 0L;
        }
        refillIfNecessary();
        return this.outputBuffer.read(sink, byteCount);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        Throwable th;
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.outputBuffer.clear();
        BufferedSource bufferedSource = this.source;
        try {
            ZstdDecompressor zstdDecompressor = this.decompressor;
            try {
                Unit unit = Unit.INSTANCE;
                th = null;
                AutoCloseableKt.closeFinally(zstdDecompressor, null);
                Unit unit2 = Unit.INSTANCE;
                if (bufferedSource != null) {
                    try {
                        bufferedSource.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (th != null) {
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    AutoCloseableKt.closeFinally(zstdDecompressor, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            if (bufferedSource != null) {
                try {
                    bufferedSource.close();
                } catch (Throwable th6) {
                    ExceptionsKt.addSuppressed(th, th6);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:? A[LOOP:0: B:3:0x0002->B:77:?, LOOP_END, SYNTHETIC] */
    private final void refillIfNecessary() throws Throwable {
        long j;
        Throwable th;
        String errorName;
        Throwable th2;
        while (this.outputBuffer.exhausted()) {
            long jDecompressStream = 0;
            if (!this.source.request(1L)) {
                if (this.lastDecompressResult != 0) {
                    throw new EOFException("EOF before end of stream");
                }
                return;
            }
            Buffer.UnsafeCursor andWriteUnsafe = this.outputBuffer.readAndWriteUnsafe(this.outputCursor);
            try {
                Buffer.UnsafeCursor unsafeCursor = andWriteUnsafe;
                long size = this.outputBuffer.size();
                unsafeCursor.expandBuffer(1);
                Buffer.UnsafeCursor unsafe = this.source.getBuffer().readUnsafe(this.inputCursor);
                th = null;
                try {
                    Buffer.UnsafeCursor unsafeCursor2 = unsafe;
                    unsafeCursor2.next();
                    ZstdDecompressor zstdDecompressor = this.decompressor;
                    byte[] bArr = unsafeCursor.data;
                    Intrinsics.checkNotNull(bArr);
                    int i = unsafeCursor.end;
                    int i2 = unsafeCursor.start;
                    byte[] bArr2 = unsafeCursor2.data;
                    Intrinsics.checkNotNull(bArr2);
                    jDecompressStream = zstdDecompressor.decompressStream(bArr, i, i2, bArr2, unsafeCursor2.end, unsafeCursor2.start);
                    Unit unit = Unit.INSTANCE;
                    if (unsafe != null) {
                        try {
                            unsafe.close();
                        } catch (Throwable th3) {
                            th2 = th3;
                        }
                    }
                    th2 = null;
                } catch (Throwable th4) {
                    j = jDecompressStream;
                    if (unsafe != null) {
                        try {
                            unsafe.close();
                        } catch (Throwable th5) {
                            try {
                                ExceptionsKt.addSuppressed(th4, th5);
                            } catch (Throwable th6) {
                                th = th6;
                                Throwable th7 = th;
                                if (andWriteUnsafe != null) {
                                    try {
                                        andWriteUnsafe.close();
                                    } catch (Throwable th8) {
                                        ExceptionsKt.addSuppressed(th7, th8);
                                    }
                                }
                                th = th7;
                                jDecompressStream = j;
                            }
                        }
                    }
                    th2 = th4;
                    jDecompressStream = j;
                }
                if (th2 == null) {
                    this.source.skip(this.decompressor.inputBytesProcessed);
                    Long.valueOf(unsafeCursor.resizeBuffer(size + ((long) this.decompressor.outputBytesProcessed)));
                    if (andWriteUnsafe != null) {
                        try {
                            andWriteUnsafe.close();
                        } catch (Throwable th9) {
                            th = th9;
                        }
                    }
                    if (th == null) {
                        this.lastDecompressResult = jDecompressStream;
                        errorName = Zstd.getErrorName(jDecompressStream);
                        if (errorName == null) {
                            throw new IOException("zstd decompress failed: " + errorName);
                        }
                    } else {
                        throw th;
                    }
                } else {
                    throw th2;
                }
            } catch (Throwable th10) {
                th = th10;
                j = jDecompressStream;
            }
            Throwable th11 = th;
            if (andWriteUnsafe != null) {
                andWriteUnsafe.close();
            }
            th = th11;
            jDecompressStream = j;
            if (th == null) {
                this.lastDecompressResult = jDecompressStream;
                errorName = Zstd.getErrorName(jDecompressStream);
                if (errorName == null) {
                    throw new IOException("zstd decompress failed: " + errorName);
                }
            } else {
                throw th;
            }
        }
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: timeout */
    public Timeout getTimeout() {
        return this.source.getTimeout();
    }
}
