package com.squareup.zstd;

import kotlin.Metadata;

/* JADX INFO: compiled from: Zstd.jni.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"getErrorName", "", "code", "", "zstdCompressor", "Lcom/squareup/zstd/ZstdCompressor;", "zstdDecompressor", "Lcom/squareup/zstd/ZstdDecompressor;", "zstd-kmp_release"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "com/squareup/zstd/Zstd")
final /* synthetic */ class Zstd__Zstd_jniKt {
    public static final String getErrorName(long j) {
        return JniZstdKt.jniGetErrorName(j);
    }

    public static final ZstdCompressor zstdCompressor() {
        return new JniZstdCompressor();
    }

    public static final ZstdDecompressor zstdDecompressor() {
        return new JniZstdDecompressor();
    }
}
