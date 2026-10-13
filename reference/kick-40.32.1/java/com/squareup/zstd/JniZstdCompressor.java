package com.squareup.zstd;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JniZstdCompressor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J@\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0082 JQ\u0010\n\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0082 J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/squareup/zstd/JniZstdCompressor;", "Lcom/squareup/zstd/ZstdCompressor;", "<init>", "()V", "cctxPointer", "", "setParameter", "param", "", "value", "compressStream2", "outputByteArray", "", "outputEnd", "outputStart", "inputByteArray", "inputEnd", "inputStart", "mode", "close", "", "jniPointer", "zstd-kmp_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JniZstdCompressor extends ZstdCompressor {
    public long cctxPointer;

    private final native void close(long cctxPointer);

    private final native long compressStream2(long jniPointer, long cctxPointer, byte[] outputByteArray, int outputEnd, int outputStart, byte[] inputByteArray, int inputEnd, int inputStart, int mode);

    private final native long setParameter(long cctxPointer, int param, int value);

    public JniZstdCompressor() {
        long jCreateZstdCompressor = JniZstdKt.createZstdCompressor();
        if (jCreateZstdCompressor != 0) {
            this.cctxPointer = jCreateZstdCompressor;
            return;
        }
        throw new OutOfMemoryError("createZstdCompressor failed");
    }

    @Override // com.squareup.zstd.ZstdCompressor
    public long setParameter(int param, int value) {
        return setParameter(this.cctxPointer, param, value);
    }

    @Override // com.squareup.zstd.ZstdCompressor
    public long compressStream2(byte[] outputByteArray, int outputEnd, int outputStart, byte[] inputByteArray, int inputEnd, int inputStart, int mode) {
        Intrinsics.checkNotNullParameter(outputByteArray, "outputByteArray");
        Intrinsics.checkNotNullParameter(inputByteArray, "inputByteArray");
        return compressStream2(JniZstdKt.getJniZstdPointer(), this.cctxPointer, outputByteArray, outputEnd, outputStart, inputByteArray, inputEnd, inputStart, mode);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        long j = this.cctxPointer;
        if (j != 0) {
            this.cctxPointer = 0L;
            close(j);
        }
    }
}
