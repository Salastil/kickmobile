package com.datadog.trace.core;

import com.datadog.trace.api.Config;
import com.datadog.trace.core.monitor.HealthMetrics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class LongRunningTracesTracker {
    public static final int EXPIRED = 4;
    public static final int NOT_TRACKED = -1;
    public static final int TO_TRACK = 1;
    public static final int TRACKED = 2;
    public static final int UNDEFINED = 0;
    public static final int WRITE_RUNNING_SPANS = 3;
    private int dropped;
    private int expired;
    private final int flushPeriodMilli;
    private final HealthMetrics healthMetrics;
    private long lastFlushMilli = 0;
    private final long maxTrackedDurationMilli;
    private final int maxTrackedTraces;
    private final List<PendingTrace> traceArray;
    private int write;

    public LongRunningTracesTracker(Config config, int i, HealthMetrics healthMetrics) {
        TimeUnit timeUnit = TimeUnit.HOURS;
        this.maxTrackedDurationMilli = 43200000L;
        this.traceArray = new ArrayList(16);
        this.dropped = 0;
        this.write = 0;
        this.expired = 0;
        this.maxTrackedTraces = i;
        this.flushPeriodMilli = (int) TimeUnit.SECONDS.toMillis(config.getLongRunningTraceFlushInterval());
        this.healthMetrics = healthMetrics;
    }

    public boolean add(PendingTraceBuffer.Element element) {
        if (!(element instanceof PendingTrace)) {
            return false;
        }
        PendingTrace pendingTrace = (PendingTrace) element;
        if (!pendingTrace.compareAndSetLongRunningState(1, 2)) {
            return false;
        }
        addTrace(pendingTrace);
        return true;
    }

    private void addTrace(PendingTrace pendingTrace) {
        if (pendingTrace.empty()) {
            return;
        }
        if (this.traceArray.size() == this.maxTrackedTraces) {
            this.dropped++;
        } else {
            this.traceArray.add(pendingTrace);
        }
    }

    public void flushAndCompact(long j) {
        long j2 = this.lastFlushMilli;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (j < j2 + 1000) {
            return;
        }
        int i = 0;
        while (i < this.traceArray.size()) {
            PendingTrace pendingTrace = this.traceArray.get(i);
            if (pendingTrace == null) {
                cleanSlot(i);
            } else if (pendingTrace.empty()) {
                pendingTrace.compareAndSetLongRunningState(3, -1);
                cleanSlot(i);
            } else if (hasExpired(j, pendingTrace)) {
                pendingTrace.compareAndSetLongRunningState(3, 4);
                this.expired++;
                cleanSlot(i);
            } else {
                if (shouldFlush(j, pendingTrace)) {
                    if (negativeOrNullPriority(pendingTrace)) {
                        pendingTrace.compareAndSetLongRunningState(2, -1);
                        cleanSlot(i);
                    } else {
                        pendingTrace.compareAndSetLongRunningState(2, 3);
                        this.write++;
                        pendingTrace.write();
                    }
                }
                i++;
            }
        }
        this.lastFlushMilli = j;
        flushStats();
    }

    private boolean hasExpired(long j, PendingTrace pendingTrace) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return j - (pendingTrace.getRunningTraceStartTime() / 1000000) > this.maxTrackedDurationMilli;
    }

    private boolean shouldFlush(long j, PendingTrace pendingTrace) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return j - (Math.max(pendingTrace.getRunningTraceStartTime(), pendingTrace.getLastWriteTime()) / 1000000) > ((long) this.flushPeriodMilli);
    }

    private void cleanSlot(int i) {
        int size = this.traceArray.size() - 1;
        List<PendingTrace> list = this.traceArray;
        list.set(i, list.get(size));
        this.traceArray.remove(size);
    }

    private boolean negativeOrNullPriority(PendingTrace pendingTrace) {
        Integer numEvaluateSamplingPriority = pendingTrace.evaluateSamplingPriority();
        return numEvaluateSamplingPriority == null || numEvaluateSamplingPriority.intValue() <= 0;
    }

    private void flushStats() {
        this.healthMetrics.onLongRunningUpdate(this.dropped, this.write, this.expired);
        this.dropped = 0;
        this.write = 0;
        this.expired = 0;
    }
}
