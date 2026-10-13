package com.squareup.zstd;

import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidZstd.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"loadNativeLibrary", "", "zstd-kmp_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AndroidZstdKt {
    public static final void loadNativeLibrary() {
        System.loadLibrary("zstd-kmp");
    }
}
