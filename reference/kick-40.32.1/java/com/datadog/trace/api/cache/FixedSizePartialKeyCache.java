package com.datadog.trace.api.cache;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
final class FixedSizePartialKeyCache<K, V> implements DDPartialKeyCache<K, V> {
    private final HVElement<V>[] elements;
    private final int mask;

    FixedSizePartialKeyCache(int i) {
        int iCalculateSize = FixedSizeCache.calculateSize(i);
        this.elements = new HVElement[iCalculateSize];
        this.mask = iCalculateSize - 1;
    }

    @Override // com.datadog.trace.api.cache.DDPartialKeyCache
    public V computeIfAbsent(K k, int i, int i2, DDPartialKeyCache.Hasher<K> hasher, DDPartialKeyCache.Comparator<K, V> comparator, DDPartialKeyCache.Producer<K, ? extends V> producer) {
        if (k == null) {
            return null;
        }
        int iApply = hasher.apply(k, i, i2);
        int i3 = iApply & this.mask;
        int i4 = 1;
        int iRehash = iApply;
        while (true) {
            int i5 = iRehash & this.mask;
            HVElement<V> hVElement = this.elements[i5];
            if (hVElement == null) {
                return produceAndStoreValue(producer, iApply, k, i, i2, i5);
            }
            if (iApply == hVElement.hash && comparator.test(k, i, i2, hVElement.value)) {
                return hVElement.value;
            }
            if (i4 == 3) {
                return produceAndStoreValue(producer, iApply, k, i, i2, i3);
            }
            iRehash = FixedSizeCache.rehash(iRehash);
            i4++;
        }
    }

    @Override // com.datadog.trace.api.cache.DDPartialKeyCache
    public void clear() {
        Arrays.fill(this.elements, (Object) null);
    }

    private V produceAndStoreValue(DDPartialKeyCache.Producer<K, ? extends V> producer, int i, K k, int i2, int i3, int i4) {
        V vApply = producer.apply(k, i, i2, i3);
        this.elements[i4] = new HVElement<>(i, vApply);
        return vApply;
    }

    static final class HVElement<U> {
        final int hash;
        final U value;

        HVElement(int i, U u) {
            this.hash = i;
            this.value = u;
        }
    }
}
