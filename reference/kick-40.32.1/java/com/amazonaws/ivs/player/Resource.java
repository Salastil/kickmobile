package com.amazonaws.ivs.player;

/* JADX INFO: loaded from: classes5.dex */
class Resource<T> implements AutoCloseable {
    private final Consumer<T> closer;
    private T resource;

    static <T> Resource<T> from(T t, Consumer<T> consumer) {
        return new Resource<>(t, consumer);
    }

    void let(Consumer<T> consumer) {
        T t = this.resource;
        if (t != null) {
            consumer.accept(t);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        T t = this.resource;
        if (t != null) {
            this.closer.accept(t);
            this.resource = null;
        }
    }

    private Resource(T t, Consumer<T> consumer) {
        this.resource = t;
        this.closer = consumer;
    }
}
