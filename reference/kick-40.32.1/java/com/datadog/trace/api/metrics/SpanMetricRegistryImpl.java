package com.datadog.trace.api.metrics;

import com.datadog.android.trace.internal.compat.function.Function;
import com.datadog.trace.core.util.MapUtils;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class SpanMetricRegistryImpl implements SpanMetricRegistry {
    private static final SpanMetricRegistryImpl INSTANCE = new SpanMetricRegistryImpl();
    private final Map<String, SpanMetricsImpl> spanMetrics = new ConcurrentHashMap();

    public static SpanMetricRegistryImpl getInstance() {
        return INSTANCE;
    }

    private SpanMetricRegistryImpl() {
    }

    @Override // com.datadog.trace.api.metrics.SpanMetricRegistry
    public SpanMetrics get(String str) {
        return (SpanMetrics) MapUtils.computeIfAbsent(str, this.spanMetrics, new Function() { // from class: com.datadog.trace.api.metrics.SpanMetricRegistryImpl$$ExternalSyntheticLambda0
            @Override // com.datadog.android.trace.internal.compat.function.Function
            public final Object apply(Object obj) {
                return new SpanMetricsImpl((String) obj);
            }
        });
    }

    @Override // com.datadog.trace.api.metrics.SpanMetricRegistry
    public String summary() {
        StringBuilder sb = new StringBuilder();
        for (SpanMetricsImpl spanMetricsImpl : this.spanMetrics.values()) {
            sb.append(spanMetricsImpl.getInstrumentationName());
            String str = ": ";
            for (CoreCounter coreCounter : spanMetricsImpl.getCounters()) {
                sb.append(str);
                sb.append(coreCounter.getName());
                sb.append('=');
                sb.append(coreCounter.getValue());
                str = ", ";
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public Collection<SpanMetricsImpl> getSpanMetrics() {
        return this.spanMetrics.values();
    }
}
