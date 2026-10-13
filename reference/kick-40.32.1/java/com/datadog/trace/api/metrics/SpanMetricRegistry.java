package com.datadog.trace.api.metrics;

import com.datadog.trace.api.InstrumenterConfig;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface SpanMetricRegistry {
    public static final SpanMetricRegistry NOOP = new SpanMetricRegistry() { // from class: com.datadog.trace.api.metrics.SpanMetricRegistry$$ExternalSyntheticLambda0
        @Override // com.datadog.trace.api.metrics.SpanMetricRegistry
        public final SpanMetrics get(String str) {
            return SpanMetrics.NOOP;
        }
    };

    SpanMetrics get(String str);

    default String summary() {
        return "";
    }

    static SpanMetricRegistry getInstance() {
        if (InstrumenterConfig.get().isTelemetryEnabled()) {
            return SpanMetricRegistryImpl.getInstance();
        }
        return NOOP;
    }
}
