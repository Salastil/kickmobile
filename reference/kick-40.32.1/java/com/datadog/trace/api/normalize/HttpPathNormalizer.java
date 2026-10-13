package com.datadog.trace.api.normalize;

/* JADX INFO: loaded from: classes6.dex */
abstract class HttpPathNormalizer {
    public abstract String normalize(String str, boolean z);

    HttpPathNormalizer() {
    }

    public final String normalize(String str) {
        return normalize(str, false);
    }
}
