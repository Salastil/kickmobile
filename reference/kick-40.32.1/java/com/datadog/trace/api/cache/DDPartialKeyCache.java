package com.datadog.trace.api.cache;

/* JADX INFO: loaded from: classes6.dex */
public interface DDPartialKeyCache<K, V> {

    @FunctionalInterface
    public interface Comparator<T, U> {
        boolean test(T t, int i, int i2, U u);
    }

    @FunctionalInterface
    public interface Hasher<T> {
        int apply(T t, int i, int i2);
    }

    @FunctionalInterface
    public interface Producer<T, R> {
        R apply(T t, int i, int i2, int i3);
    }

    void clear();

    V computeIfAbsent(K k, int i, int i2, Hasher<K> hasher, Comparator<K, V> comparator, Producer<K, ? extends V> producer);
}
