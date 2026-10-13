package org.jctools.maps;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public class NonBlockingHashSet<E> extends AbstractSet<E> implements Serializable {
    private static final Object V = "";
    private final NonBlockingHashMap<E, Object> _map = new NonBlockingHashMap<>();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        return this._map.putIfAbsent(e, V) == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this._map.containsKey(obj);
    }

    public E get(E e) {
        return this._map.getk(e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this._map.remove(obj) == V;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this._map.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this._map.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this._map.keySet().iterator();
    }
}
