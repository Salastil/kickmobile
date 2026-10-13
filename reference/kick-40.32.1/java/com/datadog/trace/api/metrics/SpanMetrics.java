package com.datadog.trace.api.metrics;

/* JADX INFO: loaded from: classes6.dex */
public interface SpanMetrics {
    public static final SpanMetrics NOOP = new SpanMetrics() { // from class: com.datadog.trace.api.metrics.SpanMetrics.1
        @Override // com.datadog.trace.api.metrics.SpanMetrics
        public void onSpanCreated() {
        }

        @Override // com.datadog.trace.api.metrics.SpanMetrics
        public void onSpanFinished() {
        }
    };

    void onSpanCreated();

    void onSpanFinished();
}
