package com.datadog.trace.api.metrics;

/* JADX INFO: loaded from: classes6.dex */
public interface CoreCounter {
    String getName();

    long getValue();

    long getValueAndReset();
}
