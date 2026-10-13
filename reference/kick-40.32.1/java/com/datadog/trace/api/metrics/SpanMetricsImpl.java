package com.datadog.trace.api.metrics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public class SpanMetricsImpl implements SpanMetrics {
    private final Collection<CoreCounter> coreCounters;
    private final String instrumentationName;
    private final AtomicLong spanCreatedCounter;
    private final AtomicLong spanFinishedCounter;

    public SpanMetricsImpl(String str) {
        this.instrumentationName = str;
        AtomicLong atomicLong = new AtomicLong(0L);
        this.spanCreatedCounter = atomicLong;
        AtomicLong atomicLong2 = new AtomicLong(0L);
        this.spanFinishedCounter = atomicLong2;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new SpanCounter("spans_created", atomicLong));
        arrayList.add(new SpanCounter("spans_finished", atomicLong2));
        this.coreCounters = Collections.unmodifiableList(arrayList);
    }

    @Override // com.datadog.trace.api.metrics.SpanMetrics
    public void onSpanCreated() {
        this.spanCreatedCounter.incrementAndGet();
    }

    @Override // com.datadog.trace.api.metrics.SpanMetrics
    public void onSpanFinished() {
        this.spanFinishedCounter.incrementAndGet();
    }

    public String getInstrumentationName() {
        return this.instrumentationName;
    }

    public Collection<CoreCounter> getCounters() {
        return this.coreCounters;
    }

    private static class SpanCounter implements CoreCounter {
        private final AtomicLong counter;
        private final String name;
        private long previousCount;

        private SpanCounter(String str, AtomicLong atomicLong) {
            this.name = str;
            this.counter = atomicLong;
        }

        @Override // com.datadog.trace.api.metrics.CoreCounter
        public String getName() {
            return this.name;
        }

        @Override // com.datadog.trace.api.metrics.CoreCounter
        public long getValue() {
            return this.counter.get();
        }

        @Override // com.datadog.trace.api.metrics.CoreCounter
        public long getValueAndReset() {
            long j = this.counter.get();
            long j2 = j - this.previousCount;
            this.previousCount = j;
            return j2;
        }
    }
}
