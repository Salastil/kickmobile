package dagger.internal;

import dagger.Lazy;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class MapProviderLazyFactory<K, V> extends AbstractMapFactory<K, V, Provider<Lazy<V>>> {
    private static final Provider<Map<Object, Object>> EMPTY = InstanceFactory.create(Collections.EMPTY_MAP);

    public static <K, V> Builder<K, V> builder(int size) {
        return new Builder<>(size);
    }

    public static <K, V> Provider<Map<K, Provider<Lazy<V>>>> emptyMapProvider() {
        return (Provider<Map<K, Provider<Lazy<V>>>>) EMPTY;
    }

    private MapProviderLazyFactory(Map<K, Provider<V>> map) {
        super(map);
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Map<K, Provider<Lazy<V>>> get() {
        LinkedHashMap linkedHashMapNewLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(contributingMap().size());
        for (final Map.Entry<K, Provider<V>> entry : contributingMap().entrySet()) {
            linkedHashMapNewLinkedHashMapWithExpectedSize.put(entry.getKey(), new Provider() { // from class: dagger.internal.MapProviderLazyFactory$$ExternalSyntheticLambda0
                @Override // javax.inject.Provider, jakarta.inject.Provider
                public final Object get() {
                    return DoubleCheck.lazy((Provider) entry.getValue());
                }
            });
        }
        return Collections.unmodifiableMap(linkedHashMapNewLinkedHashMapWithExpectedSize);
    }

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider<Lazy<V>>> {
        private Builder(int size) {
            super(size);
        }

        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> put(K key, Provider<V> providerOfValue) {
            super.put((Object) key, (Provider) providerOfValue);
            return this;
        }

        @Deprecated
        public Builder<K, V> put(K key, javax.inject.Provider<V> providerOfValue) {
            return put((Object) key, (Provider) Providers.asDaggerProvider(providerOfValue));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(Provider<Map<K, Provider<Lazy<V>>>> mapFactory) {
            super.putAll((Provider) mapFactory);
            return this;
        }

        @Deprecated
        public Builder<K, V> putAll(javax.inject.Provider<Map<K, Provider<Lazy<V>>>> mapFactory) {
            return putAll((Provider) Providers.asDaggerProvider(mapFactory));
        }

        public MapProviderLazyFactory<K, V> build() {
            return new MapProviderLazyFactory<>(this.map);
        }
    }
}
