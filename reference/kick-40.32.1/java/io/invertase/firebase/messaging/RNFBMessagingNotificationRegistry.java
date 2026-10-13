package io.invertase.firebase.messaging;

import io.invertase.firebase.common.RNFBHandleCollisionException;
import io.invertase.firebase.common.RNFBHandleMap;

/* JADX INFO: loaded from: classes9.dex */
final class RNFBMessagingNotificationRegistry<V> {
    private final RNFBHandleMap<String, V> map = new RNFBHandleMap<>();

    RNFBMessagingNotificationRegistry() {
    }

    void put(String str, V v) throws RNFBHandleCollisionException {
        this.map.put(str, v);
    }

    V putReplacing(String str, V v) {
        return this.map.putReplacing(str, v);
    }

    V get(String str) {
        return this.map.get(str);
    }

    V take(String str) {
        return this.map.take(str);
    }
}
