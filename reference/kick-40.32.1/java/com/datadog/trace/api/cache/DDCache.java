package com.datadog.trace.api.cache;

import com.datadog.android.trace.internal.compat.function.BiConsumer;
import com.datadog.android.trace.internal.compat.function.Function;

/* JADX INFO: loaded from: classes6.dex */
public interface DDCache<K, V> {
    void clear();

    V computeIfAbsent(K k, Function<K, ? extends V> function);

    void visit(BiConsumer<K, V> biConsumer);
}
