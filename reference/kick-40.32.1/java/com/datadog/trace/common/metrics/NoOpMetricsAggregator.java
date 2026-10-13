package com.datadog.trace.common.metrics;

import com.datadog.trace.core.CoreSpan;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes6.dex */
public final class NoOpMetricsAggregator implements MetricsAggregator {
    public static final NoOpMetricsAggregator INSTANCE = new NoOpMetricsAggregator();

    @Override // com.datadog.trace.common.metrics.MetricsAggregator, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.datadog.trace.common.metrics.MetricsAggregator
    public boolean publish(List<? extends CoreSpan<?>> list) {
        return false;
    }

    @Override // com.datadog.trace.common.metrics.MetricsAggregator
    public boolean report() {
        return false;
    }

    @Override // com.datadog.trace.common.metrics.MetricsAggregator
    public void start() {
    }

    @Override // com.datadog.trace.common.metrics.MetricsAggregator
    public Future<Boolean> forceReport() {
        return new Future<Boolean>() { // from class: com.datadog.trace.common.metrics.NoOpMetricsAggregator.1
            @Override // java.util.concurrent.Future
            public boolean cancel(boolean z) {
                return false;
            }

            @Override // java.util.concurrent.Future
            public boolean isCancelled() {
                return false;
            }

            @Override // java.util.concurrent.Future
            public boolean isDone() {
                return false;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Future
            public Boolean get() throws ExecutionException, InterruptedException {
                return Boolean.FALSE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Future
            public Boolean get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
                return Boolean.FALSE;
            }
        };
    }
}
