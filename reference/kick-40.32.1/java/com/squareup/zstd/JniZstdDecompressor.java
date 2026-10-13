package com.squareup.zstd;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JniZstdDecompressor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016JI\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0082 J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0082 R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/squareup/zstd/JniZstdDecompressor;", "Lcom/squareup/zstd/ZstdDecompressor;", "<init>", "()V", "dctxPointer", "", "decompressStream", "outputByteArray", "", "outputEnd", "", "outputStart", "inputByteArray", "inputEnd", "inputStart", "close", "", "jniPointer", "cctxPointer", "zstd-kmp_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JniZstdDecompressor extends ZstdDecompressor {
    public long dctxPointer;

    private final native void close(long cctxPointer);

    private final native long decompressStream(long jniPointer, long dctxPointer, byte[] outputByteArray, int outputEnd, int outputStart, byte[] inputByteArray, int inputEnd, int inputStart);

    public JniZstdDecompressor() {
        long jCreateZstdDecompressor = JniZstdKt.createZstdDecompressor();
        if (jCreateZstdDecompressor != 0) {
            this.dctxPointer = jCreateZstdDecompressor;
            return;
        }
        throw new OutOfMemoryError("createZstdDecompressor failed");
    }

    @Override // com.squareup.zstd.ZstdDecompressor
    public long decompressStream(byte[] outputByteArray, int outputEnd, int outputStart, byte[] inputByteArray, int inputEnd, int inputStart) {
        Intrinsics.checkNotNullParameter(outputByteArray, "outputByteArray");
        Intrinsics.checkNotNullParameter(inputByteArray, "inputByteArray");
        return decompressStream(JniZstdKt.getJniZstdPointer(), this.dctxPointer, outputByteArray, outputEnd, outputStart, inputByteArray, inputEnd, inputStart);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        long j = this.dctxPointer;
        if (j != 0) {
            this.dctxPointer = 0L;
            close(j);
        }
    }
}
