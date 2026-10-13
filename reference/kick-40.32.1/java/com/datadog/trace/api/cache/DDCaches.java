package com.datadog.trace.api.cache;

/* JADX INFO: loaded from: classes6.dex */
public final class DDCaches {
    private DDCaches() {
    }

    public static <K, V> DDCache<K, V> newFixedSizeCache(int i) {
        return new FixedSizeCache.ObjectHash(i);
    }

    public static <K, V> DDPartialKeyCache<K, V> newFixedSizePartialKeyCache(int i) {
        return new FixedSizePartialKeyCache(i);
    }
}
