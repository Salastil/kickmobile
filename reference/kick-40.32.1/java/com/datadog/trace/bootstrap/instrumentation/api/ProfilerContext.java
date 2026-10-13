package com.datadog.trace.bootstrap.instrumentation.api;

/* JADX INFO: loaded from: classes6.dex */
public interface ProfilerContext {
    int getEncodedOperationName();

    int getEncodedResourceName();

    CharSequence getOperationName();

    CharSequence getResourceName();

    long getRootSpanId();

    long getSpanId();
}
