package com.datadog.trace.api;

import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class Pair<T, U> {
    private final T left;
    private final U right;

    public static <T, U> Pair<T, U> of(T t, U u) {
        return new Pair<>(t, u);
    }

    Pair(T t, U u) {
        this.left = t;
        this.right = u;
    }

    public T getLeft() {
        return this.left;
    }

    public U getRight() {
        return this.right;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            if (Objects.equals(this.left, pair.left) && Objects.equals(this.right, pair.right)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        T t = this.left;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        U u = this.right;
        return iHashCode + (u != null ? u.hashCode() : 0);
    }
}
