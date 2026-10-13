package com.datadog.trace.core;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.datadog.android.api.InternalLogger;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.DDTags;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.EndpointTracker;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.gateway.Flow;
import com.datadog.trace.api.gateway.RequestContext;
import com.datadog.trace.api.metrics.SpanMetricRegistry;
import com.datadog.trace.api.metrics.SpanMetrics;
import com.datadog.trace.api.profiling.TransientProfilingContextHolder;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink;
import com.datadog.trace.bootstrap.instrumentation.api.AttachableWrapper;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes6.dex */
public class DDSpan implements AgentSpan, CoreSpan<DDSpan>, TransientProfilingContextHolder, AttachableWrapper {
    private static final AtomicLongFieldUpdater<DDSpan> DURATION_NANO_UPDATER = AtomicLongFieldUpdater.newUpdater(DDSpan.class, "durationNano");
    private static final AtomicReferenceFieldUpdater<DDSpan, Object> WRAPPER_FIELD_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DDSpan.class, Object.class, "wrapper");
    private static final boolean legacyEndToEndEnabled = Config.get().isEndToEndDurationEnabled(false, "legacy");
    private final DDSpanContext context;
    private volatile long durationNano;
    private volatile EndpointTracker endpointTracker;
    private final boolean externalClock;
    private boolean forceKeep;
    private final List<AgentSpanLink> links;
    private final Logger log;
    private volatile int longRunningVersion = 0;
    private final SpanMetrics metrics;
    private volatile Flow.Action.RequestBlockingAction requestBlockingAction;
    private final long startTimeNano;
    private volatile Object wrapper;

    static DDSpan create(String str, long j, DDSpanContext dDSpanContext, List<AgentSpanLink> list, InternalLogger internalLogger) {
        DDSpan dDSpan = new DDSpan(str, j, dDSpanContext, list, internalLogger);
        dDSpanContext.getTrace().registerSpan(dDSpan);
        return dDSpan;
    }

    public DDSpan(String str, long j, DDSpanContext dDSpanContext, List<AgentSpanLink> list, InternalLogger internalLogger) {
        this.context = dDSpanContext;
        SpanMetrics spanMetrics = SpanMetricRegistry.getInstance().get(str);
        this.metrics = spanMetrics;
        spanMetrics.onSpanCreated();
        if (j <= 0) {
            this.startTimeNano = dDSpanContext.getTrace().getCurrentTimeNano();
            this.externalClock = false;
        } else {
            this.startTimeNano = TimeUnit.MICROSECONDS.toNanos(j);
            this.externalClock = true;
            dDSpanContext.getTrace().touch();
        }
        this.links = list == null ? new CopyOnWriteArrayList() : new CopyOnWriteArrayList(list);
        Logger logger = LoggerFactory.getLogger("DDSpan", internalLogger);
        this.log = logger;
        logger.debug("Started span: {}", this);
    }

    public boolean isFinished() {
        return this.durationNano != 0;
    }

    private void finishAndAddToTrace(long j) {
        if (DURATION_NANO_UPDATER.compareAndSet(this, 0L, Math.max(1L, j))) {
            setLongRunningVersion(-this.longRunningVersion);
            this.metrics.onSpanFinished();
            this.log.debug("Finished span ({}): {}", this.context.getTrace().onPublish(this), this);
            return;
        }
        this.log.debug("Already finished: {}", this);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public void finish() {
        boolean z = this.externalClock;
        DDSpanContext dDSpanContext = this.context;
        if (!z) {
            finishAndAddToTrace(dDSpanContext.getTrace().getCurrentTimeNano() - this.startTimeNano);
        } else {
            finish(dDSpanContext.getTrace().getTimeSource().getCurrentTimeMicros());
        }
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public void finish(long j) {
        long nanos;
        if (!this.externalClock) {
            long currentTimeMicros = j - this.context.getTrace().getTimeSource().getCurrentTimeMicros();
            long currentTimeNano = this.context.getTrace().getCurrentTimeNano() - this.startTimeNano;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            nanos = timeUnit.toNanos(currentTimeNano / 1000000) + TimeUnit.MICROSECONDS.toNanos(currentTimeMicros);
        } else {
            nanos = TimeUnit.MICROSECONDS.toNanos(j) - this.startTimeNano;
            this.context.getTrace().touch();
        }
        finishAndAddToTrace(nanos);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public final void finishWithDuration(long j) {
        finishAndAddToTrace(j);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public void beginEndToEnd() {
        if (legacyEndToEndEnabled) {
            if (getBaggageItem(DDTags.TRACE_START_TIME) == null) {
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                setBaggageItem(DDTags.TRACE_START_TIME, Long.toString(this.startTimeNano / 1000000));
                return;
            }
            return;
        }
        this.context.beginEndToEnd();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public void finishWithEndToEnd() {
        long endToEndStartTime;
        boolean z = legacyEndToEndEnabled;
        DDSpanContext dDSpanContext = this.context;
        if (z) {
            String baggageItem = dDSpanContext.getBaggageItem(DDTags.TRACE_START_TIME);
            if (baggageItem != null) {
                try {
                    endToEndStartTime = TimeUnit.MILLISECONDS.toNanos(Long.parseLong(baggageItem));
                } catch (RuntimeException e) {
                    this.log.debug("Ignoring invalid end-to-end start time {}", baggageItem, e);
                    endToEndStartTime = 0;
                }
            } else {
                endToEndStartTime = 0;
            }
        } else {
            endToEndStartTime = dDSpanContext.getEndToEndStartTime();
        }
        if (endToEndStartTime > 0) {
            phasedFinish();
            long j = this.startTimeNano + (this.durationNano & Long.MAX_VALUE);
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            mo11190setTag(InstrumentationTags.RECORD_END_TO_END_DURATION_MS, Math.max(0L, j - endToEndStartTime) / 1000000);
            publish();
            return;
        }
        finish();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public final boolean phasedFinish() {
        long currentTimeNanos;
        boolean z = this.externalClock;
        DDSpanContext dDSpanContext = this.context;
        if (!z) {
            currentTimeNanos = dDSpanContext.getTrace().getCurrentTimeNano() - this.startTimeNano;
        } else {
            currentTimeNanos = dDSpanContext.getTrace().getTimeSource().getCurrentTimeNanos() - this.startTimeNano;
            this.context.getTrace().touch();
        }
        boolean zCompareAndSet = DURATION_NANO_UPDATER.compareAndSet(this, 0L, Math.max(1L, currentTimeNanos) | Long.MIN_VALUE);
        Logger logger = this.log;
        if (zCompareAndSet) {
            logger.debug("Finished span (PHASED): {}", this);
            return true;
        }
        logger.debug("Already finished: {}", this);
        return false;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public final void publish() {
        long j = this.durationNano;
        if (j == 0) {
            this.log.debug("Can't publish unfinished span: {}", this);
            return;
        }
        if (j > 0) {
            this.log.debug("Already published: {}", this);
        } else if (DURATION_NANO_UPDATER.compareAndSet(this, j, Long.MAX_VALUE & j)) {
            this.log.debug("Published span ({}): {}", this.context.getTrace().onPublish(this), this);
        }
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
    public DDSpan setError(boolean z) {
        return setError(z, (byte) 0);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public DDSpan setError(boolean z, byte b) {
        this.context.setErrorFlag(z, b);
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setMeasured, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11183setMeasured(boolean z) {
        this.context.setMeasured(z);
        return this;
    }

    public DDSpan forceKeep(boolean z) {
        this.forceKeep = z;
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    public boolean isForceKeep() {
        return this.forceKeep;
    }

    public final boolean isRootSpan() {
        return this.context.getParentId() == 0;
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    @Deprecated
    public AgentSpan getRootSpan() {
        return mo11181getLocalRootSpan();
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: getLocalRootSpan, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11181getLocalRootSpan() {
        return this.context.getTrace().getRootSpan();
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    public void drop() {
        this.context.getTrace().unregisterSpan(this);
    }

    public boolean isLocalRootSpan() {
        return mo11181getLocalRootSpan().equals(this);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public boolean isSameTrace(AgentSpan agentSpan) {
        if (agentSpan instanceof DDSpan) {
            return getTraceId().equals(agentSpan.getTraceId());
        }
        return false;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setErrorMessage, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11182setErrorMessage(String str) {
        return mo11194setTag("error.message", str);
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: addThrowable, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11180addThrowable(Throwable th) {
        return addThrowable(th, (byte) 0);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public DDSpan addThrowable(Throwable th, byte b) {
        if (th != null) {
            String message = th.getMessage();
            if (!"broken pipe".equalsIgnoreCase(message) && (th.getCause() == null || !"broken pipe".equalsIgnoreCase(th.getCause().getMessage()))) {
                setError(true, b);
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                mo11194setTag("error.stack", stringWriter.toString());
            }
            mo11194setTag("error.message", message);
            mo11194setTag("error.type", th.getClass().getName());
        }
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setTag, reason: merged with bridge method [inline-methods] */
    public final DDSpan mo11194setTag(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            this.context.setTag(str, null);
            return this;
        }
        this.context.setTag(str, str2);
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setTag, reason: merged with bridge method [inline-methods] */
    public final DDSpan mo11195setTag(String str, boolean z) {
        this.context.setTag(str, Boolean.valueOf(z));
        return this;
    }

    @Override // com.datadog.trace.api.gateway.IGSpanInfo
    public void setRequestBlockingAction(Flow.Action.RequestBlockingAction requestBlockingAction) {
        this.requestBlockingAction = requestBlockingAction;
    }

    @Override // com.datadog.trace.api.gateway.IGSpanInfo
    public Flow.Action.RequestBlockingAction getRequestBlockingAction() {
        return this.requestBlockingAction;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setTag, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11189setTag(String str, int i) {
        if ("http.status_code".equals(str)) {
            this.context.setHttpStatusCode((short) i);
        }
        this.context.setTag(str, Integer.valueOf(i));
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setTag, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11190setTag(String str, long j) {
        this.context.setTag(str, Long.valueOf(j));
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setTag, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11188setTag(String str, double d) {
        this.context.setTag(str, Double.valueOf(d));
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setTag, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11192setTag(String str, Number number) {
        this.context.setTag(str, number);
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setMetric, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11185setMetric(CharSequence charSequence, int i) {
        this.context.setMetric(charSequence, Integer.valueOf(i));
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    public DDSpan setMetric(CharSequence charSequence, float f) {
        this.context.setMetric(charSequence, Float.valueOf(f));
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setMetric, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11186setMetric(CharSequence charSequence, long j) {
        this.context.setMetric(charSequence, Long.valueOf(j));
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setMetric, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11184setMetric(CharSequence charSequence, double d) {
        this.context.setMetric(charSequence, Double.valueOf(d));
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    public DDSpan setFlag(CharSequence charSequence, boolean z) {
        this.context.setMetric(charSequence, Integer.valueOf(z ? 1 : 0));
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setTag, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11191setTag(String str, CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            this.context.setTag(str, null);
            return this;
        }
        this.context.setTag(str, charSequence);
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setTag, reason: merged with bridge method [inline-methods] */
    public DDSpan mo11193setTag(String str, Object obj) {
        this.context.setTag(str, obj);
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    public DDSpan removeTag(String str) {
        this.context.setTag(str, null);
        return this;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
    public Object getTag(String str) {
        return this.context.getTag(str);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public final DDSpanContext context() {
        return this.context;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public final String getBaggageItem(String str) {
        return this.context.getBaggageItem(str);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public final DDSpan setBaggageItem(String str, String str2) {
        this.context.setBaggageItem(str, str2);
        return this;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public AgentSpan setHttpStatusCode(int i) {
        this.context.setHttpStatusCode((short) i);
        return this;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public short getHttpStatusCode() {
        return this.context.getHttpStatusCode();
    }

    @Override // com.datadog.trace.core.CoreSpan
    public CharSequence getOrigin() {
        return this.context.getOrigin();
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    public final DDSpan setOperationName(CharSequence charSequence) {
        this.context.setOperationName(charSequence);
        return this;
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    public final DDSpan setServiceName(String str) {
        this.context.setServiceName(str);
        return this;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
    public final DDSpan setResourceName(CharSequence charSequence) {
        return setResourceName(charSequence, (byte) 0);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public final DDSpan setResourceName(CharSequence charSequence, byte b) {
        this.context.setResourceName(charSequence, b);
        return this;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public boolean eligibleForDropping() {
        int traceSamplingPriority = this.context.getTraceSamplingPriority();
        return traceSamplingPriority == -1 || traceSamplingPriority == 0;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public RequestContext getRequestContext() {
        return this.context.getRequestContext();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public Integer forceSamplingDecision() {
        PendingTrace trace = this.context.getTrace();
        DDSpan rootSpan = trace.getRootSpan();
        trace.setSamplingPriorityIfNecessary();
        if (rootSpan == null) {
            return null;
        }
        return rootSpan.getTraceSamplingPriority();
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    @Deprecated
    public final DDSpan setSamplingPriority(int i) {
        return mo11187setSamplingPriority(i, -1);
    }

    @Override // com.datadog.trace.core.CoreSpan
    /* JADX INFO: renamed from: setSamplingPriority, reason: merged with bridge method [inline-methods] */
    public final DDSpan mo11187setSamplingPriority(int i, int i2) {
        this.context.setSamplingPriority(i, i2);
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    public DDSpan setSamplingPriority(int i, CharSequence charSequence, double d, int i2) {
        if (this.context.setSamplingPriority(i, i2)) {
            mo11184setMetric(charSequence, d);
        }
        return this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    public DDSpan setSpanSamplingPriority(double d, int i) {
        this.context.setSpanSamplingPriority(d, i);
        return this;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
    public final DDSpan setSpanType(CharSequence charSequence) {
        this.context.setSpanType(charSequence);
        return this;
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    public long getStartTime() {
        return this.startTimeNano;
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    public long getDurationNano() {
        return this.durationNano;
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    public String getServiceName() {
        return this.context.getServiceName();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.gateway.IGSpanInfo
    public DDTraceId getTraceId() {
        return this.context.getTraceId();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.gateway.IGSpanInfo
    public long getSpanId() {
        return this.context.getSpanId();
    }

    @Override // com.datadog.trace.core.CoreSpan
    public long getParentId() {
        return this.context.getParentId();
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    public CharSequence getResourceName() {
        return this.context.getResourceName();
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    public CharSequence getOperationName() {
        return this.context.getOperationName();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public CharSequence getSpanName() {
        return this.context.getOperationName();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public void setSpanName(CharSequence charSequence) {
        this.context.setOperationName(charSequence);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public boolean hasResourceName() {
        return this.context.hasResourceName();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public byte getResourceNamePriority() {
        return this.context.getResourceNamePriority();
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    public Integer getTraceSamplingPriority() {
        int traceSamplingPriority = this.context.getTraceSamplingPriority();
        if (traceSamplingPriority == -128) {
            return null;
        }
        return Integer.valueOf(traceSamplingPriority);
    }

    public int getSpanSamplingPriority() {
        return this.context.getSpanSamplingPriority();
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    public String getSpanType() {
        CharSequence spanType = this.context.getSpanType();
        if (spanType == null) {
            return null;
        }
        return spanType.toString();
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan, com.datadog.trace.api.gateway.IGSpanInfo
    public Map<String, Object> getTags() {
        return this.context.getTags();
    }

    @Override // com.datadog.trace.core.CoreSpan
    public CharSequence getType() {
        return this.context.getSpanType();
    }

    @Override // com.datadog.trace.core.CoreSpan
    public void processTagsAndBaggage(MetadataConsumer metadataConsumer) {
        this.context.processTagsAndBaggage(metadataConsumer, this.longRunningVersion, this.links);
    }

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    public boolean isError() {
        return this.context.getErrorFlag();
    }

    @Override // com.datadog.trace.core.CoreSpan
    public int getError() {
        return this.context.getErrorFlag() ? 1 : 0;
    }

    @Override // com.datadog.trace.core.CoreSpan
    public <U> U getTag(CharSequence charSequence, U u) {
        U u2 = (U) getTag(String.valueOf(charSequence));
        return u2 == null ? u : u2;
    }

    @Override // com.datadog.trace.core.CoreSpan
    public <U> U getTag(CharSequence charSequence) {
        return (U) getTag(charSequence, null);
    }

    @Override // com.datadog.trace.core.CoreSpan
    public boolean hasSamplingPriority() {
        return this.context.getTrace().getRootSpan() == this;
    }

    @Override // com.datadog.trace.core.CoreSpan
    public boolean isMeasured() {
        return this.context.isMeasured();
    }

    @Override // com.datadog.trace.core.CoreSpan
    public boolean isTopLevel() {
        return this.context.isTopLevel();
    }

    public EndpointTracker getEndpointTracker() {
        DDSpan dDSpanMo11181getLocalRootSpan = mo11181getLocalRootSpan();
        if (dDSpanMo11181getLocalRootSpan == null) {
            return null;
        }
        if (equals(dDSpanMo11181getLocalRootSpan)) {
            return this.endpointTracker;
        }
        return dDSpanMo11181getLocalRootSpan.endpointTracker;
    }

    public void setEndpointTracker(EndpointTracker endpointTracker) {
        DDSpan dDSpanMo11181getLocalRootSpan = mo11181getLocalRootSpan();
        if (dDSpanMo11181getLocalRootSpan == null) {
            this.log.warn("Span {} has no associated local root span", this);
        } else if (equals(dDSpanMo11181getLocalRootSpan)) {
            this.endpointTracker = endpointTracker;
        } else {
            dDSpanMo11181getLocalRootSpan.endpointTracker = endpointTracker;
        }
    }

    public List<AgentSpanLink> getLinks() {
        return this.links;
    }

    public Map<String, String> getBaggage() {
        return Collections.unmodifiableMap(this.context.getBaggageItems());
    }

    public String toString() {
        return this.context.toString() + ", duration_ns=" + this.durationNano + ", forceKeep=" + this.forceKeep + ", links=" + this.links;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AttachableWrapper
    public void attachWrapper(Object obj) {
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(WRAPPER_FIELD_UPDATER, this, null, obj);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AttachableWrapper
    public Object getWrapper() {
        return WRAPPER_FIELD_UPDATER.get(this);
    }

    public void setLongRunningVersion(int i) {
        if (this.longRunningVersion < 0) {
            return;
        }
        this.longRunningVersion = i;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public TraceConfig traceConfig() {
        return this.context.getTrace().getTraceConfig();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
    public void addLink(AgentSpanLink agentSpanLink) {
        if (agentSpanLink != null) {
            this.links.add(agentSpanLink);
        }
    }

    public long getStartTimeNano() {
        return this.startTimeNano;
    }
}
