package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LimitedInputStream.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/common/streams/LimitedInputStream;", "Ljava/io/FilterInputStream;", "inputStream", "Ljava/io/InputStream;", "limit", "", "<init>", "(Ljava/io/InputStream;I)V", "bytesToRead", "bytesToReadWhenMarked", "read", "buffer", "", "byteOffset", "byteCount", "skip", "", "available", "mark", "", "readLimit", "reset", "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LimitedInputStream extends FilterInputStream {
    private int bytesToRead;
    private int bytesToReadWhenMarked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LimitedInputStream(InputStream inputStream, int i) {
        super(inputStream);
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        if (i < 0) {
            throw new IllegalArgumentException("limit must be >= 0".toString());
        }
        this.bytesToRead = i;
        this.bytesToReadWhenMarked = -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.bytesToRead == 0) {
            return -1;
        }
        int i = this.in.read();
        if (i != -1) {
            this.bytesToRead--;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = this.bytesToRead;
        if (i == 0) {
            return -1;
        }
        int i2 = this.in.read(buffer, byteOffset, Math.min(byteCount, i));
        if (i2 > 0) {
            this.bytesToRead -= i2;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long byteCount) throws IOException {
        long jSkip = this.in.skip(Math.min(byteCount, this.bytesToRead));
        this.bytesToRead -= (int) jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return Math.min(this.in.available(), this.bytesToRead);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int readLimit) {
        if (this.in.markSupported()) {
            this.in.mark(readLimit);
            this.bytesToReadWhenMarked = this.bytesToRead;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("mark is not supported");
        }
        if (this.bytesToReadWhenMarked == -1) {
            throw new IOException("mark not set");
        }
        this.in.reset();
        this.bytesToRead = this.bytesToReadWhenMarked;
    }
}
