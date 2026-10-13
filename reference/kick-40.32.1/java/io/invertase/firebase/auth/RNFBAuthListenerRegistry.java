package io.invertase.firebase.auth;

import io.invertase.firebase.common.RNFBHandleCollisionException;
import io.invertase.firebase.common.RNFBHandleMap;

/* JADX INFO: loaded from: classes9.dex */
final class RNFBAuthListenerRegistry {
    private final RNFBHandleMap<String, AuthListenerHandle> map = new RNFBHandleMap<>();

    RNFBAuthListenerRegistry() {
    }

    void put(String str, AuthListenerHandle authListenerHandle) throws RNFBHandleCollisionException {
        this.map.put(str, authListenerHandle);
    }

    boolean putOrDiscard(String str, AuthListenerHandle authListenerHandle) {
        try {
            this.map.put(str, authListenerHandle);
            return true;
        } catch (RNFBHandleCollisionException unused) {
            if (authListenerHandle == null) {
                return false;
            }
            authListenerHandle.remove();
            return false;
        }
    }

    AuthListenerHandle get(String str) {
        return this.map.get(str);
    }

    AuthListenerHandle take(String str) {
        return this.map.take(str);
    }

    void takeAndRemove(String str) {
        AuthListenerHandle authListenerHandleTake = this.map.take(str);
        if (authListenerHandleTake != null) {
            authListenerHandleTake.remove();
        }
    }

    void takeAllAndRemove() {
        for (AuthListenerHandle authListenerHandle : this.map.takeAll()) {
            if (authListenerHandle != null) {
                authListenerHandle.remove();
            }
        }
    }
}
