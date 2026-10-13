package com.datadog.trace.core;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.time.TimeSource;
import com.datadog.trace.bootstrap.instrumentation.api.AgentScope;
import com.datadog.trace.bootstrap.instrumentation.api.AgentTrace;
import com.datadog.trace.common.sampling.PrioritySampler;
import com.datadog.trace.core.monitor.HealthMetrics;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.datadog.trace.monitor.Recording;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes6.dex */
public class PendingTrace implements AgentTrace, PendingTraceBuffer.Element {
    private volatile int completedSpanCount;
    private volatile long endToEndStartTime;
    private final HealthMetrics healthMetrics;
    private volatile int isEnqueued;
    private volatile long lastReferenced;
    private volatile long lastWriteTimeNano;
    private final Logger log;
    private volatile int longRunningTrackedState;
    private volatile int pendingReferenceCount;
    private final PendingTraceBuffer pendingTraceBuffer;
    private volatile DDSpan rootSpan;
    private volatile boolean rootSpanWritten;
    private volatile long runningTraceStartTimeNano;
    private final ConcurrentLinkedDeque<DDSpan> spans;
    private final boolean strictTraceWrites;
    private final TimeSource timeSource;
    private final CoreTracer.ConfigSnapshot traceConfig;
    private final DDTraceId traceId;
    private final CoreTracer tracer;
    private static final List<DDSpan> EMPTY = new ArrayList(0);
    private static final AtomicIntegerFieldUpdater<PendingTrace> COMPLETED_SPAN_COUNT = AtomicIntegerFieldUpdater.newUpdater(PendingTrace.class, "completedSpanCount");
    private static final AtomicIntegerFieldUpdater<PendingTrace> PENDING_REFERENCE_COUNT = AtomicIntegerFieldUpdater.newUpdater(PendingTrace.class, "pendingReferenceCount");
    private static final AtomicIntegerFieldUpdater<PendingTrace> IS_ENQUEUED = AtomicIntegerFieldUpdater.newUpdater(PendingTrace.class, "isEnqueued");
    private static final AtomicIntegerFieldUpdater<PendingTrace> LONG_RUNNING_STATE = AtomicIntegerFieldUpdater.newUpdater(PendingTrace.class, "longRunningTrackedState");
    private static final AtomicLongFieldUpdater<PendingTrace> RUNNING_TRACE_START_TIME_NANO = AtomicLongFieldUpdater.newUpdater(PendingTrace.class, "runningTraceStartTimeNano");
    private static final AtomicLongFieldUpdater<PendingTrace> LAST_WRITE_TIME_NANO = AtomicLongFieldUpdater.newUpdater(PendingTrace.class, "lastWriteTimeNano");
    private static final AtomicReferenceFieldUpdater<PendingTrace, DDSpan> ROOT_SPAN = AtomicReferenceFieldUpdater.newUpdater(PendingTrace.class, DDSpan.class, "rootSpan");
    private static final AtomicLongFieldUpdater<PendingTrace> END_TO_END_START_TIME = AtomicLongFieldUpdater.newUpdater(PendingTrace.class, "endToEndStartTime");

    enum PublishState {
        WRITTEN,
        PARTIAL_FLUSH,
        ROOT_BUFFERED,
        BUFFERED,
        PENDING
    }

    static class Factory {
        private final HealthMetrics healthMetrics;
        private final PendingTraceBuffer pendingTraceBuffer;
        private final boolean strictTraceWrites;
        private final TimeSource timeSource;
        private final CoreTracer tracer;

        Factory(CoreTracer coreTracer, PendingTraceBuffer pendingTraceBuffer, TimeSource timeSource, boolean z, HealthMetrics healthMetrics) {
            this.tracer = coreTracer;
            this.pendingTraceBuffer = pendingTraceBuffer;
            this.timeSource = timeSource;
            this.strictTraceWrites = z;
            this.healthMetrics = healthMetrics;
        }

        PendingTrace create(DDTraceId dDTraceId) {
            return create(dDTraceId, null);
        }

        PendingTrace create(DDTraceId dDTraceId, CoreTracer.ConfigSnapshot configSnapshot) {
            return new PendingTrace(this.tracer, dDTraceId, this.pendingTraceBuffer, this.timeSource, configSnapshot, this.strictTraceWrites, this.healthMetrics);
        }
    }

    private PendingTrace(CoreTracer coreTracer, DDTraceId dDTraceId, PendingTraceBuffer pendingTraceBuffer, TimeSource timeSource, CoreTracer.ConfigSnapshot configSnapshot, boolean z, HealthMetrics healthMetrics) {
        this.completedSpanCount = 0;
        this.pendingReferenceCount = 0;
        this.isEnqueued = 0;
        this.longRunningTrackedState = 0;
        this.runningTraceStartTimeNano = 0L;
        this.lastWriteTimeNano = 0L;
        this.rootSpan = null;
        this.rootSpanWritten = false;
        this.lastReferenced = 0L;
        this.tracer = coreTracer;
        this.traceId = dDTraceId;
        this.pendingTraceBuffer = pendingTraceBuffer;
        this.timeSource = timeSource;
        this.traceConfig = configSnapshot == null ? coreTracer.captureTraceConfig() : configSnapshot;
        this.strictTraceWrites = z;
        this.healthMetrics = healthMetrics;
        this.spans = new ConcurrentLinkedDeque<>();
        this.log = LoggerFactory.getLogger("PendingTrace", coreTracer.internalLogger);
    }

    CoreTracer getTracer() {
        return this.tracer;
    }

    TraceConfig getTraceConfig() {
        return this.traceConfig;
    }

    String mapServiceName(String str) {
        return this.traceConfig.getServiceMapping().containsKey(str) ? this.traceConfig.getServiceMapping().get(str) : str;
    }

    public long getCurrentTimeNano() {
        long nanoTicks = this.timeSource.getNanoTicks();
        this.lastReferenced = nanoTicks;
        return this.tracer.getTimeWithNanoTicks(nanoTicks);
    }

    public TimeSource getTimeSource() {
        return this.timeSource;
    }

    public void touch() {
        this.lastReferenced = this.timeSource.getNanoTicks();
    }

    @Override // com.datadog.trace.core.PendingTraceBuffer.Element
    public boolean lastReferencedNanosAgo(long j) {
        return j < this.timeSource.getNanoTicks() - this.lastReferenced;
    }

    void registerSpan(DDSpan dDSpan) {
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(ROOT_SPAN, this, null, dDSpan);
        PENDING_REFERENCE_COUNT.incrementAndGet(this);
        this.healthMetrics.onCreateSpan();
        if (this.pendingTraceBuffer.longRunningSpansEnabled()) {
            this.spans.addFirst(dDSpan);
            trackRunningTrace(dDSpan);
        }
    }

    void unregisterSpan(DDSpan dDSpan) {
        PENDING_REFERENCE_COUNT.decrementAndGet(this);
        if (this.pendingTraceBuffer.longRunningSpansEnabled()) {
            this.spans.remove(dDSpan);
        }
    }

    void trackRunningTrace(DDSpan dDSpan) {
        if (compareAndSetLongRunningState(0, 1)) {
            RUNNING_TRACE_START_TIME_NANO.set(this, dDSpan.getStartTime());
            this.pendingTraceBuffer.enqueue(this);
        }
    }

    public Integer evaluateSamplingPriority() {
        DDSpan dDSpanPeek = this.spans.peek();
        if (dDSpanPeek == null) {
            return null;
        }
        Integer traceSamplingPriority = dDSpanPeek.getTraceSamplingPriority();
        return traceSamplingPriority == null ? dDSpanPeek.forceSamplingDecision() : traceSamplingPriority;
    }

    public boolean compareAndSetLongRunningState(int i, int i2) {
        return LONG_RUNNING_STATE.compareAndSet(this, i, i2);
    }

    boolean empty() {
        return COMPLETED_SPAN_COUNT.get(this) + PENDING_REFERENCE_COUNT.get(this) <= 0;
    }

    PublishState onPublish(DDSpan dDSpan) {
        if (!this.pendingTraceBuffer.longRunningSpansEnabled()) {
            this.spans.addFirst(dDSpan);
        }
        this.healthMetrics.onFinishSpan();
        COMPLETED_SPAN_COUNT.incrementAndGet(this);
        return decrementRefAndMaybeWrite(dDSpan == getRootSpan());
    }

    @Override // com.datadog.trace.core.PendingTraceBuffer.Element
    public DDSpan getRootSpan() {
        return this.rootSpan;
    }

    @Override // com.datadog.trace.core.PendingTraceBuffer.Element
    public long oldestFinishedTime() {
        long jMin = Long.MAX_VALUE;
        for (DDSpan dDSpan : this.spans) {
            if (dDSpan.isFinished()) {
                jMin = Math.min(jMin, dDSpan.getStartTime() + dDSpan.getDurationNano());
            }
        }
        return jMin;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTrace
    public void registerContinuation(AgentScope.Continuation continuation) {
        PENDING_REFERENCE_COUNT.incrementAndGet(this);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTrace
    public void cancelContinuation(AgentScope.Continuation continuation) {
        decrementRefAndMaybeWrite(false);
        this.healthMetrics.onCancelContinuation();
    }

    private PublishState decrementRefAndMaybeWrite(boolean z) {
        int iDecrementAndGet = PENDING_REFERENCE_COUNT.decrementAndGet(this);
        if (this.strictTraceWrites && iDecrementAndGet < 0) {
            throw new IllegalStateException("Pending reference count " + iDecrementAndGet + " is negative");
        }
        int partialFlushMinSpans = this.tracer.getPartialFlushMinSpans();
        if (iDecrementAndGet == 0 && (this.strictTraceWrites || !this.rootSpanWritten)) {
            write();
            return PublishState.WRITTEN;
        }
        if (z) {
            this.pendingTraceBuffer.enqueue(this);
            return PublishState.ROOT_BUFFERED;
        }
        if (partialFlushMinSpans > 0 && size() > partialFlushMinSpans) {
            partialFlush();
            return PublishState.PARTIAL_FLUSH;
        }
        if (this.rootSpanWritten) {
            this.pendingTraceBuffer.enqueue(this);
            return PublishState.BUFFERED;
        }
        return PublishState.PENDING;
    }

    private void partialFlush() {
        int iWrite = write(true);
        this.healthMetrics.onPartialFlush(iWrite);
        if (this.log.isDebugEnabled()) {
            this.log.debug("t_id={} -> wrote partial trace of size {}", this.traceId, Integer.valueOf(iWrite));
        }
    }

    @Override // com.datadog.trace.core.PendingTraceBuffer.Element
    public void write() {
        write(false);
    }

    private int write(boolean z) {
        List<DDSpan> arrayList;
        int iEnqueueSpansToWrite;
        if (!this.spans.isEmpty()) {
            Recording recordingWriteTimer = this.tracer.writeTimer();
            try {
                synchronized (this) {
                    boolean z2 = true;
                    if (!z) {
                        this.rootSpanWritten = true;
                    }
                    int size = size();
                    if (3 != LONG_RUNNING_STATE.get(this)) {
                        z2 = false;
                    }
                    if (z2) {
                        size += this.pendingReferenceCount;
                    }
                    if (size > 0 && (!z || size >= this.tracer.getPartialFlushMinSpans())) {
                        arrayList = new ArrayList<>(size);
                        iEnqueueSpansToWrite = enqueueSpansToWrite(arrayList, z2);
                    } else {
                        arrayList = EMPTY;
                        iEnqueueSpansToWrite = 0;
                    }
                }
                if (!arrayList.isEmpty()) {
                    COMPLETED_SPAN_COUNT.addAndGet(this, -iEnqueueSpansToWrite);
                    this.tracer.write(arrayList);
                    this.healthMetrics.onCreateTrace();
                    if (recordingWriteTimer != null) {
                        recordingWriteTimer.close();
                    }
                    return iEnqueueSpansToWrite;
                }
                if (recordingWriteTimer != null) {
                    recordingWriteTimer.close();
                }
            } catch (Throwable th) {
                if (recordingWriteTimer != null) {
                    try {
                        recordingWriteTimer.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return 0;
    }

    public int enqueueSpansToWrite(List<DDSpan> list, boolean z) {
        long currentTimeNano;
        long spanId = 0;
        if (z) {
            currentTimeNano = getCurrentTimeNano();
            setLastWriteTime(currentTimeNano);
        } else {
            currentTimeNano = 0;
        }
        DDSpan dDSpanPollFirst = this.spans.pollFirst();
        boolean z2 = false;
        int i = 0;
        while (dDSpanPollFirst != null) {
            if (z2 && dDSpanPollFirst.getSpanId() == spanId) {
                this.spans.addFirst(dDSpanPollFirst);
                return i;
            }
            if (dDSpanPollFirst.isFinished()) {
                list.add(dDSpanPollFirst);
                i++;
            } else {
                this.spans.add(dDSpanPollFirst);
                if (!z2) {
                    spanId = dDSpanPollFirst.getSpanId();
                    z2 = true;
                }
                if (z) {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    dDSpanPollFirst.setLongRunningVersion((int) ((currentTimeNano - dDSpanPollFirst.getStartTime()) / 1000000));
                    list.add(dDSpanPollFirst);
                }
            }
            dDSpanPollFirst = this.spans.pollFirst();
        }
        return i;
    }

    public int size() {
        return this.completedSpanCount;
    }

    public void beginEndToEnd() {
        beginEndToEnd(getCurrentTimeNano());
    }

    void beginEndToEnd(long j) {
        END_TO_END_START_TIME.compareAndSet(this, 0L, j);
    }

    public long getEndToEndStartTime() {
        return this.endToEndStartTime;
    }

    public long getLastWriteTime() {
        return LAST_WRITE_TIME_NANO.get(this);
    }

    public long getRunningTraceStartTime() {
        return RUNNING_TRACE_START_TIME_NANO.get(this);
    }

    public void setLastWriteTime(long j) {
        LAST_WRITE_TIME_NANO.set(this, j);
    }

    public int getPendingReferenceCount() {
        return this.pendingReferenceCount;
    }

    public boolean isRootSpanWritten() {
        return this.rootSpanWritten;
    }

    public List<DDSpan> getSpans() {
        return this.spans.isEmpty() ? EMPTY : new ArrayList(this.spans);
    }

    @Override // com.datadog.trace.core.PendingTraceBuffer.Element
    public boolean setEnqueued(boolean z) {
        int i = !z ? 1 : 0;
        return IS_ENQUEUED.compareAndSet(this, i, 1 - i);
    }

    @Override // com.datadog.trace.core.PendingTraceBuffer.Element
    public boolean writeOnBufferFull() {
        return !compareAndSetLongRunningState(1, -1);
    }

    public static long getDurationNano(CoreSpan<?> coreSpan) {
        long durationNano = coreSpan.getDurationNano();
        return (durationNano <= 0 && (coreSpan instanceof DDSpan)) ? ((DDSpan) coreSpan).context().getTrace().getLastWriteTime() - coreSpan.getStartTime() : durationNano;
    }

    public void setSamplingPriorityIfNecessary() {
        if ((this.traceConfig.sampler instanceof PrioritySampler) && this.rootSpan != null && this.rootSpan.context().getTraceSamplingPriority() == -128) {
            ((PrioritySampler) this.traceConfig.sampler).setSamplingPriority(this.rootSpan);
        }
    }

    public boolean sample(DDSpan dDSpan) {
        return this.traceConfig.sampler.sample(dDSpan);
    }
}
