package io.invertase.firebase.auth;

import io.invertase.firebase.common.RNFBHandleCollisionException;
import io.invertase.firebase.common.RNFBHandleMap;

/* JADX INFO: loaded from: classes9.dex */
final class RNFBAuthCacheRegistry<V> {
    private final RNFBHandleMap<String, V> map = new RNFBHandleMap<>();

    RNFBAuthCacheRegistry() {
    }

    void put(String str, V v) throws RNFBHandleCollisionException {
        this.map.put(str, v);
    }

    boolean putOrDiscard(String str, V v) {
        return this.map.putIfAbsent(str, v);
    }

    void putReplacing(String str, V v) {
        this.map.putReplacing(str, v);
    }

    V get(String str) {
        return this.map.get(str);
    }

    V take(String str) {
        return this.map.take(str);
    }

    void clear() {
        this.map.takeAll();
    }
}
