package com.datadog.trace.api.cache;

import com.datadog.android.trace.internal.compat.function.BiConsumer;
import com.datadog.android.trace.internal.compat.function.Function;
import com.datadog.trace.api.Pair;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
abstract class FixedSizeCache<K, V> implements DDCache<K, V> {
    static final int MAXIMUM_CAPACITY = 1073741824;
    private final Pair<K, V>[] elements;
    private final int mask;

    abstract boolean equals(K k, Pair<K, V> pair);

    abstract int hash(K k);

    FixedSizeCache(int i) {
        int iCalculateSize = calculateSize(i);
        this.elements = new Pair[iCalculateSize];
        this.mask = iCalculateSize - 1;
    }

    static int calculateSize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cache capacity must be > 0");
        }
        if (i > 1073741824) {
            i = 1073741824;
        }
        int iNumberOfLeadingZeros = (-1) >>> Integer.numberOfLeadingZeros(i - 1);
        if (iNumberOfLeadingZeros < 0) {
            return 1;
        }
        if (iNumberOfLeadingZeros >= 1073741824) {
            return 1073741824;
        }
        return iNumberOfLeadingZeros + 1;
    }

    @Override // com.datadog.trace.api.cache.DDCache
    public final V computeIfAbsent(K k, Function<K, ? extends V> function) {
        if (k == null) {
            return null;
        }
        int iHash = hash(k);
        int i = this.mask & iHash;
        int i2 = 1;
        while (true) {
            int i3 = this.mask & iHash;
            Pair<K, V> pair = this.elements[i3];
            if (pair == null) {
                return produceAndStoreValue(k, function, i3);
            }
            if (equals(k, pair)) {
                return pair.getRight();
            }
            if (i2 == 3) {
                return produceAndStoreValue(k, function, i);
            }
            iHash = rehash(iHash);
            i2++;
        }
    }

    @Override // com.datadog.trace.api.cache.DDCache
    public void clear() {
        Arrays.fill(this.elements, (Object) null);
    }

    @Override // com.datadog.trace.api.cache.DDCache
    public void visit(BiConsumer<K, V> biConsumer) {
        for (Pair<K, V> pair : this.elements) {
            if (pair != null) {
                biConsumer.accept(pair.getLeft(), pair.getRight());
            }
        }
    }

    private V produceAndStoreValue(K k, Function<K, ? extends V> function, int i) {
        V vApply = function.apply(k);
        this.elements[i] = Pair.of(k, vApply);
        return vApply;
    }

    static int rehash(int i) {
        return Integer.reverseBytes(i * (-1640532531)) * (-1640532531);
    }

    static final class ObjectHash<K, V> extends FixedSizeCache<K, V> {
        ObjectHash(int i) {
            super(i);
        }

        @Override // com.datadog.trace.api.cache.FixedSizeCache
        int hash(K k) {
            return k.hashCode();
        }

        @Override // com.datadog.trace.api.cache.FixedSizeCache
        boolean equals(K k, Pair<K, V> pair) {
            return k.equals(pair.getLeft());
        }
    }

    static final class IdentityHash<K, V> extends FixedSizeCache<K, V> {
        IdentityHash(int i) {
            super(i);
        }

        @Override // com.datadog.trace.api.cache.FixedSizeCache
        int hash(K k) {
            int iIdentityHashCode = System.identityHashCode(k);
            return iIdentityHashCode - (iIdentityHashCode << 7);
        }

        @Override // com.datadog.trace.api.cache.FixedSizeCache
        boolean equals(K k, Pair<K, V> pair) {
            return k == pair.getLeft();
        }
    }

    static final class ArrayHash<K, V> extends FixedSizeCache<K[], V> {
        ArrayHash(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.datadog.trace.api.cache.FixedSizeCache
        public int hash(K[] kArr) {
            return Arrays.hashCode(kArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.datadog.trace.api.cache.FixedSizeCache
        public boolean equals(K[] kArr, Pair<K[], V> pair) {
            return Arrays.equals(kArr, pair.getLeft());
        }
    }
}
