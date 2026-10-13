package com.datadog.trace.bootstrap.instrumentation.api;

/* JADX INFO: loaded from: classes6.dex */
public enum ScopeSource {
    INSTRUMENTATION((byte) 0),
    MANUAL((byte) 1),
    ITERATION((byte) 2);

    private final byte id;

    ScopeSource(byte b) {
        this.id = b;
    }

    public byte id() {
        return this.id;
    }
}
