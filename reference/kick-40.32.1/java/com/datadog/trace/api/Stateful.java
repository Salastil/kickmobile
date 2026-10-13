package com.datadog.trace.api;

/* JADX INFO: loaded from: classes6.dex */
public interface Stateful extends AutoCloseable {
    public static final Stateful DEFAULT = new Stateful() { // from class: com.datadog.trace.api.Stateful.1
        @Override // com.datadog.trace.api.Stateful
        public void activate(Object obj) {
        }

        @Override // com.datadog.trace.api.Stateful, java.lang.AutoCloseable
        public void close() {
        }
    };

    void activate(Object obj);

    @Override // java.lang.AutoCloseable
    void close();
}
