package com.squareup.zstd;

import kotlin.Metadata;

/* JADX INFO: compiled from: JniZstd.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\t\u0010\u0004\u001a\u00020\u0001H\u0081 \u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0081 \u001a\t\u0010\b\u001a\u00020\u0001H\u0081 \u001a\t\u0010\t\u001a\u00020\u0001H\u0081 \"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"jniZstdPointer", "", "getJniZstdPointer", "()J", "createJniZstd", "jniGetErrorName", "", "code", "createZstdCompressor", "createZstdDecompressor", "zstd-kmp_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JniZstdKt {
    private static final long jniZstdPointer;

    public static final native long createJniZstd();

    public static final native long createZstdCompressor();

    public static final native long createZstdDecompressor();

    public static final native String jniGetErrorName(long j);

    public static final long getJniZstdPointer() {
        return jniZstdPointer;
    }

    static {
        AndroidZstdKt.loadNativeLibrary();
        jniZstdPointer = createJniZstd();
    }
}
