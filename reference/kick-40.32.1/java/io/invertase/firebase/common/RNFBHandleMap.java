package io.invertase.firebase.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes9.dex */
public class RNFBHandleMap<K, V> {
    private final Object lock = new Object();
    private final HashMap<K, V> map = new HashMap<>();

    public void put(K k, V v) throws RNFBHandleCollisionException {
        synchronized (this.lock) {
            if (this.map.containsKey(k)) {
                throw new RNFBHandleCollisionException(k);
            }
            this.map.put(k, v);
        }
    }

    public boolean putIfAbsent(K k, V v) {
        synchronized (this.lock) {
            if (this.map.containsKey(k)) {
                return false;
            }
            this.map.put(k, v);
            return true;
        }
    }

    public boolean putIfAbsentOrSame(K k, V v) {
        synchronized (this.lock) {
            V v2 = this.map.get(k);
            boolean z = true;
            if (v2 == null) {
                this.map.put(k, v);
                return true;
            }
            if (v2 != v) {
                z = false;
            }
            return z;
        }
    }

    public V putReplacing(K k, V v) {
        V vPut;
        synchronized (this.lock) {
            vPut = this.map.put(k, v);
        }
        return vPut;
    }

    public V get(K k) {
        V v;
        synchronized (this.lock) {
            v = this.map.get(k);
        }
        return v;
    }

    public V take(K k) {
        V vRemove;
        synchronized (this.lock) {
            vRemove = this.map.remove(k);
        }
        return vRemove;
    }

    public V takeIf(K k, Predicate<V> predicate) {
        synchronized (this.lock) {
            V v = this.map.get(k);
            if (v == null || !predicate.test(v)) {
                return null;
            }
            return this.map.remove(k);
        }
    }

    public List<V> takeAll() {
        ArrayList arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList(this.map.values());
            this.map.clear();
        }
        return arrayList;
    }
}
