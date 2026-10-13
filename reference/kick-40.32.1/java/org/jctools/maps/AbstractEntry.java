package org.jctools.maps;

import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
abstract class AbstractEntry<TypeK, TypeV> implements Map.Entry<TypeK, TypeV> {
    protected final TypeK _key;
    protected TypeV _val;

    public AbstractEntry(TypeK typek, TypeV typev) {
        this._key = typek;
        this._val = typev;
    }

    public AbstractEntry(Map.Entry<TypeK, TypeV> entry) {
        this._key = entry.getKey();
        this._val = entry.getValue();
    }

    public String toString() {
        return this._key + "=" + this._val;
    }

    @Override // java.util.Map.Entry
    public TypeK getKey() {
        return this._key;
    }

    @Override // java.util.Map.Entry
    public TypeV getValue() {
        return this._val;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return eq(this._key, entry.getKey()) && eq(this._val, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        TypeK typek = this._key;
        int iHashCode = typek == null ? 0 : typek.hashCode();
        TypeV typev = this._val;
        return iHashCode ^ (typev != null ? typev.hashCode() : 0);
    }

    private static boolean eq(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
