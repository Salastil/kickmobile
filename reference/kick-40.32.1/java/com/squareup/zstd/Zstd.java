package com.squareup.zstd;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"com/squareup/zstd/Zstd__ZstdKt", "com/squareup/zstd/Zstd__Zstd_jniKt"}, k = 4, mv = {2, 2, 0}, xi = 48)
public final class Zstd {
    public static final int ZSTD_e_continue = 0;
    public static final int ZSTD_e_end = 2;
    public static final int ZSTD_e_flush = 1;

    public static final String getErrorName(long j) {
        return Zstd__Zstd_jniKt.getErrorName(j);
    }

    public static final ZstdCompressor zstdCompressor() {
        return Zstd__Zstd_jniKt.zstdCompressor();
    }

    public static final ZstdDecompressor zstdDecompressor() {
        return Zstd__Zstd_jniKt.zstdDecompressor();
    }
}
