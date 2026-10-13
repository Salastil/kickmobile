package com.datadog.trace.common.metrics;

import com.datadog.trace.core.CoreSpan;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes6.dex */
public interface MetricsAggregator extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    Future<Boolean> forceReport();

    boolean publish(List<? extends CoreSpan<?>> list);

    boolean report();

    void start();
}
