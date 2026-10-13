package com.squareup.zstd;

import kotlin.Metadata;

/* JADX INFO: compiled from: ZstdDecompressor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b&\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J8\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H&R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/squareup/zstd/ZstdDecompressor;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "<init>", "()V", "inputBytesProcessed", "", "outputBytesProcessed", "decompressStream", "", "outputByteArray", "", "outputEnd", "outputStart", "inputByteArray", "inputEnd", "inputStart", "zstd-kmp_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ZstdDecompressor implements AutoCloseable {
    public int inputBytesProcessed = -1;
    public int outputBytesProcessed = -1;

    public abstract long decompressStream(byte[] outputByteArray, int outputEnd, int outputStart, byte[] inputByteArray, int inputEnd, int inputStart);
}
