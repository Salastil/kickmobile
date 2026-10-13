package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TailAppendingInputStream.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/common/streams/TailAppendingInputStream;", "Ljava/io/FilterInputStream;", "inputStream", "Ljava/io/InputStream;", "tail", "", "<init>", "(Ljava/io/InputStream;[B)V", "tailOffset", "", "markedTailOffset", "read", "buffer", "offset", "count", "reset", "", "mark", "readLimit", "readNextTailByte", "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TailAppendingInputStream extends FilterInputStream {
    private int markedTailOffset;
    private final byte[] tail;
    private int tailOffset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailAppendingInputStream(InputStream inputStream, byte[] tail) {
        super(inputStream);
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(tail, "tail");
        this.tail = tail;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = this.in.read();
        return i != -1 ? i : readNextTailByte();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] buffer) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return read(buffer, 0, buffer.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] buffer, int offset, int count) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = this.in.read(buffer, offset, count);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (count == 0) {
            return 0;
        }
        while (i2 < count) {
            int nextTailByte = readNextTailByte();
            if (nextTailByte == -1) {
                break;
            }
            buffer[offset + i2] = (byte) nextTailByte;
            i2++;
        }
        if (i2 > 0) {
            return i2;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (this.in.markSupported()) {
            this.in.reset();
            this.tailOffset = this.markedTailOffset;
            return;
        }
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int readLimit) {
        if (this.in.markSupported()) {
            super.mark(readLimit);
            this.markedTailOffset = this.tailOffset;
        }
    }

    private final int readNextTailByte() {
        int i = this.tailOffset;
        byte[] bArr = this.tail;
        if (i >= bArr.length) {
            return -1;
        }
        this.tailOffset = i + 1;
        return bArr[i] & 255;
    }
}
