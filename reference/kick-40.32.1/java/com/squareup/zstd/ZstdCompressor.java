package com.squareup.zstd;

import kotlin.Metadata;

/* JADX INFO: compiled from: ZstdCompressor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\b&\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H&J@\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H&R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/squareup/zstd/ZstdCompressor;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "<init>", "()V", "inputBytesProcessed", "", "outputBytesProcessed", "setParameter", "", "param", "value", "compressStream2", "outputByteArray", "", "outputEnd", "outputStart", "inputByteArray", "inputEnd", "inputStart", "mode", "zstd-kmp_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ZstdCompressor implements AutoCloseable {
    public int inputBytesProcessed = -1;
    public int outputBytesProcessed = -1;

    public abstract long compressStream2(byte[] outputByteArray, int outputEnd, int outputStart, byte[] inputByteArray, int inputEnd, int inputStart, int mode);

    public abstract long setParameter(int param, int value);
}
