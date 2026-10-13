package com.datadog.trace.core;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.work.WorkInfo;
import com.datadog.trace.api.DDTags;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.Functions;
import com.datadog.trace.api.cache.DDCache;
import com.datadog.trace.api.cache.DDCaches;
import com.datadog.trace.api.cache.RadixTreeCache;
import com.datadog.trace.api.gateway.BlockResponseFunction;
import com.datadog.trace.api.gateway.RequestContext;
import com.datadog.trace.api.gateway.RequestContextSlot;
import com.datadog.trace.api.internal.TraceSegment;
import com.datadog.trace.api.sampling.SamplingMechanism;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink;
import com.datadog.trace.bootstrap.instrumentation.api.PathwayContext;
import com.datadog.trace.bootstrap.instrumentation.api.ProfilerContext;
import com.datadog.trace.bootstrap.instrumentation.api.ProfilingContextIntegration;
import com.datadog.trace.bootstrap.instrumentation.api.UTF8BytesString;
import com.datadog.trace.core.propagation.PropagationTags;
import com.datadog.trace.core.taginterceptor.TagInterceptor;
import com.datadog.trace.core.tagprocessor.TagsPostProcessorFactory;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.datadog.trace.util.TagsHelper;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes6.dex */
public class DDSpanContext implements AgentSpan.Context, RequestContext, TraceSegment, ProfilerContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String PRIORITY_SAMPLING_KEY = "_sampling_priority_v1";
    public static final String SAMPLE_RATE_KEY = "_sample_rate";
    public static final String SPAN_SAMPLING_MAX_PER_SECOND_TAG = "_dd.span_sampling.max_per_second";
    public static final String SPAN_SAMPLING_MECHANISM_TAG = "_dd.span_sampling.mechanism";
    public static final String SPAN_SAMPLING_RULE_RATE_TAG = "_dd.span_sampling.rule_rate";
    private volatile Map<String, String> baggageItems;
    private volatile BlockResponseFunction blockResponseFunction;
    private final Object ciVisibilityContextData;
    private final boolean disableSamplingMechanismValidation;
    private volatile int encodedOperationName;
    private volatile int encodedResourceName;
    private volatile boolean errorFlag;
    private volatile byte errorFlagPriority;
    private volatile short httpStatusCode;
    private final boolean injectBaggageAsTags;
    private volatile boolean measured;
    private volatile CharSequence operationName;
    private volatile CharSequence origin;
    private final long parentId;
    private final String parentServiceName;
    private volatile PathwayContext pathwayContext;
    private final ProfilingContextIntegration profilingContextIntegration;
    private final PropagationTags propagationTags;
    private final Object requestContextDataAppSec;
    private final Object requestContextDataIast;
    private volatile CharSequence resourceName;
    private volatile byte resourceNamePriority;
    private volatile int samplingPriority;
    private volatile String serviceName;
    private final long spanId;
    private volatile CharSequence spanType;
    private final long threadId;
    private final UTF8BytesString threadName;
    private volatile boolean topLevel;
    private final PendingTrace trace;
    private final DDTraceId traceId;
    private final Map<String, Object> unsafeTags;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) DDSpanContext.class);
    private static final DDCache<String, UTF8BytesString> THREAD_NAMES = DDCaches.newFixedSizeCache(256);
    private static final Map<String, String> EMPTY_BAGGAGE = Collections.EMPTY_MAP;
    private static final AtomicIntegerFieldUpdater<DDSpanContext> SAMPLING_PRIORITY_UPDATER = AtomicIntegerFieldUpdater.newUpdater(DDSpanContext.class, "samplingPriority");

    public RequestContext getRequestContext() {
        return this;
    }

    @Override // com.datadog.trace.api.gateway.RequestContext
    public TraceSegment getTraceSegment() {
        return this;
    }

    public DDSpanContext(DDTraceId dDTraceId, long j, long j2, CharSequence charSequence, String str, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Map<String, String> map, boolean z, CharSequence charSequence5, int i2, PendingTrace pendingTrace, Object obj, Object obj2, PathwayContext pathwayContext, boolean z2, PropagationTags propagationTags) {
        this(dDTraceId, j, j2, charSequence, str, charSequence2, charSequence3, i, charSequence4, map, z, charSequence5, i2, pendingTrace, obj, obj2, null, pathwayContext, z2, propagationTags, ProfilingContextIntegration.NoOp.INSTANCE, true);
    }

    public DDSpanContext(DDTraceId dDTraceId, long j, long j2, CharSequence charSequence, String str, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Map<String, String> map, boolean z, CharSequence charSequence5, int i2, PendingTrace pendingTrace, Object obj, Object obj2, PathwayContext pathwayContext, boolean z2, PropagationTags propagationTags, boolean z3) {
        this(dDTraceId, j, j2, charSequence, str, charSequence2, charSequence3, i, charSequence4, map, z, charSequence5, i2, pendingTrace, obj, obj2, null, pathwayContext, z2, propagationTags, ProfilingContextIntegration.NoOp.INSTANCE, z3);
    }

    public DDSpanContext(DDTraceId dDTraceId, long j, long j2, CharSequence charSequence, String str, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Map<String, String> map, boolean z, CharSequence charSequence5, int i2, PendingTrace pendingTrace, Object obj, Object obj2, PathwayContext pathwayContext, boolean z2, PropagationTags propagationTags, ProfilingContextIntegration profilingContextIntegration) {
        this(dDTraceId, j, j2, charSequence, str, charSequence2, charSequence3, i, charSequence4, map, z, charSequence5, i2, pendingTrace, obj, obj2, null, pathwayContext, z2, propagationTags, profilingContextIntegration, true);
    }

    public DDSpanContext(DDTraceId dDTraceId, long j, long j2, CharSequence charSequence, String str, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Map<String, String> map, boolean z, CharSequence charSequence5, int i2, PendingTrace pendingTrace, Object obj, Object obj2, Object obj3, PathwayContext pathwayContext, boolean z2, PropagationTags propagationTags, ProfilingContextIntegration profilingContextIntegration, boolean z3) {
        this.resourceNamePriority = (byte) 0;
        this.errorFlagPriority = (byte) -128;
        this.samplingPriority = WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        this.trace = pendingTrace;
        this.traceId = dDTraceId;
        this.spanId = j;
        this.parentId = j2;
        this.parentServiceName = String.valueOf(charSequence);
        if (map == null || map.isEmpty()) {
            this.baggageItems = EMPTY_BAGGAGE;
        } else {
            this.baggageItems = new ConcurrentHashMap(map);
        }
        this.requestContextDataAppSec = obj;
        this.requestContextDataIast = obj2;
        this.ciVisibilityContextData = obj3;
        this.pathwayContext = pathwayContext;
        this.unsafeTags = new HashMap(Math.max(((i2 <= 0 ? 3 : i2 + 1) * 4) / 3, 8));
        this.profilingContextIntegration = profilingContextIntegration;
        this.encodedOperationName = profilingContextIntegration.encodeOperationName(charSequence2);
        setServiceName(str);
        this.operationName = charSequence2;
        setResourceName(charSequence3, (byte) 0);
        this.errorFlag = z;
        this.spanType = charSequence5;
        Thread threadCurrentThread = Thread.currentThread();
        this.threadId = threadCurrentThread.getId();
        this.threadName = THREAD_NAMES.computeIfAbsent(threadCurrentThread.getName(), Functions.UTF8_ENCODE);
        this.disableSamplingMechanismValidation = z2;
        PropagationTags propagationTagsEmpty = propagationTags != null ? propagationTags : pendingTrace.getTracer().getPropagationTagsFactory().empty();
        this.propagationTags = propagationTagsEmpty;
        propagationTagsEmpty.updateTraceIdHighOrderBits(dDTraceId.toHighOrderLong());
        this.injectBaggageAsTags = z3;
        if (charSequence4 != null) {
            setOrigin(charSequence4);
        }
        if (i != -128) {
            setSamplingPriority(i, -1);
        }
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public DDTraceId getTraceId() {
        return this.traceId;
    }

    public long getParentId() {
        return this.parentId;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public long getSpanId() {
        return this.spanId;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.ProfilerContext
    public long getRootSpanId() {
        return getRootSpanContextOrThis().spanId;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.ProfilerContext
    public int getEncodedOperationName() {
        return this.encodedOperationName;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.ProfilerContext
    public int getEncodedResourceName() {
        return this.encodedResourceName;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String str) {
        this.serviceName = this.trace.mapServiceName(str);
        this.topLevel = isTopLevel(this.parentServiceName, this.serviceName);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.ProfilerContext
    public CharSequence getResourceName() {
        return isResourceNameSet() ? this.resourceName : this.operationName;
    }

    public boolean hasResourceName() {
        return isResourceNameSet() || getTag("resource.name") != null;
    }

    public byte getResourceNamePriority() {
        return this.resourceNamePriority;
    }

    public void setResourceName(CharSequence charSequence, byte b) {
        if (charSequence != null && b >= this.resourceNamePriority) {
            this.resourceNamePriority = b;
            this.resourceName = charSequence;
            this.encodedResourceName = this.profilingContextIntegration.encodeResourceName(charSequence);
        }
    }

    private boolean isResourceNameSet() {
        return (this.resourceName == null || this.resourceName.length() == 0) ? false : true;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.ProfilerContext
    public CharSequence getOperationName() {
        return this.operationName;
    }

    public void setOperationName(CharSequence charSequence) {
        this.operationName = charSequence;
        this.encodedOperationName = this.profilingContextIntegration.encodeOperationName(charSequence);
    }

    public boolean getErrorFlag() {
        return this.errorFlag;
    }

    public void setErrorFlag(boolean z, byte b) {
        if (b <= -128 || b < this.errorFlagPriority) {
            return;
        }
        this.errorFlag = z;
        this.errorFlagPriority = b;
    }

    public boolean isMeasured() {
        return this.measured;
    }

    public void setMeasured(boolean z) {
        if (z != this.measured) {
            this.measured = z;
        }
    }

    public boolean isTopLevel() {
        return this.topLevel;
    }

    private static boolean isTopLevel(String str, String str2) {
        return str == null || str.length() == 0 || !str.equals(str2);
    }

    public CharSequence getSpanType() {
        return this.spanType;
    }

    public void setSpanType(CharSequence charSequence) {
        this.spanType = charSequence;
    }

    public void forceKeep() {
        getRootSpanContextOrThis().forceKeepThisSpan((byte) 4);
    }

    private void forceKeepThisSpan(byte b) {
        if (SAMPLING_PRIORITY_UPDATER.getAndSet(this, 2) == -128) {
            this.propagationTags.updateTraceSamplingPriority(2, b);
        }
    }

    public boolean setSamplingPriority(int i, int i2) {
        return getRootSpanContextOrThis().setThisSpanSamplingPriority(i, i2);
    }

    private DDSpanContext getRootSpanContextOrThis() {
        DDSpanContext rootSpanContextIfDifferent = getRootSpanContextIfDifferent();
        return rootSpanContextIfDifferent != null ? rootSpanContextIfDifferent : this;
    }

    private DDSpanContext getRootSpanContextIfDifferent() {
        DDSpan rootSpan;
        PendingTrace pendingTrace = this.trace;
        if (pendingTrace == null || (rootSpan = pendingTrace.getRootSpan()) == null || rootSpan.context() == this) {
            return null;
        }
        return rootSpan.context();
    }

    private boolean setThisSpanSamplingPriority(int i, int i2) {
        if (!validateSamplingPriority(i, i2)) {
            return false;
        }
        if (!SAMPLING_PRIORITY_UPDATER.compareAndSet(this, WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, i)) {
            Logger logger = log;
            if (logger.isDebugEnabled()) {
                logger.debug("samplingPriority locked at priority: {}. Refusing to set to priority: {} mechanism: {}", Integer.valueOf(this.samplingPriority), Integer.valueOf(i), Integer.valueOf(i2));
            }
            return false;
        }
        this.propagationTags.updateTraceSamplingPriority(i, i2);
        return true;
    }

    private boolean validateSamplingPriority(int i, int i2) {
        if (i == -128) {
            log.debug("{}: Refusing to set samplingPriority to UNSET", this);
            return false;
        }
        if (SamplingMechanism.validateWithSamplingPriority(i2, i)) {
            return true;
        }
        if (this.disableSamplingMechanismValidation) {
            log.debug("{}: Bypassing setting setSamplingPriority check (trace.sampling.mechanism.validation.disabled) for a non valid combination of samplingMechanism {} and samplingPriority {}.", this, Integer.valueOf(i2), Integer.valueOf(i));
            return true;
        }
        log.debug("{}: Refusing to set samplingMechanism to {}. Provided samplingPriority {} is not allowed.", this, Integer.valueOf(i2), Integer.valueOf(i));
        return false;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public int getTraceSamplingPriority() {
        return getRootSpanContextOrThis().samplingPriority;
    }

    public int getSpanSamplingPriority() {
        return this.samplingPriority;
    }

    public void setSpanSamplingPriority(double d, int i) {
        synchronized (this.unsafeTags) {
            unsafeSetTag(SPAN_SAMPLING_MECHANISM_TAG, (byte) 8);
            unsafeSetTag(SPAN_SAMPLING_RULE_RATE_TAG, Double.valueOf(d));
            if (i != Integer.MAX_VALUE) {
                unsafeSetTag(SPAN_SAMPLING_MAX_PER_SECOND_TAG, Integer.valueOf(i));
            }
        }
    }

    @Deprecated
    public boolean lockSamplingPriority() {
        DDSpan rootSpan = this.trace.getRootSpan();
        if (rootSpan == null || rootSpan.context() == this) {
            return SAMPLING_PRIORITY_UPDATER.get(this) != -128;
        }
        return rootSpan.context().lockSamplingPriority();
    }

    public CharSequence getOrigin() {
        return getRootSpanContextOrThis().origin;
    }

    public void beginEndToEnd() {
        this.trace.beginEndToEnd();
    }

    public long getEndToEndStartTime() {
        return this.trace.getEndToEndStartTime();
    }

    public void setBaggageItem(String str, String str2) {
        Map<String, String> map = this.baggageItems;
        Map<String, String> map2 = EMPTY_BAGGAGE;
        if (map == map2) {
            synchronized (this) {
                if (this.baggageItems == map2) {
                    this.baggageItems = new ConcurrentHashMap(4);
                }
            }
        }
        this.baggageItems.put(str, str2);
    }

    public String getBaggageItem(String str) {
        return this.baggageItems.get(str);
    }

    public Map<String, String> getBaggageItems() {
        return this.baggageItems;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public Iterable<Map.Entry<String, String>> baggageItems() {
        return this.baggageItems.entrySet();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public PendingTrace getTrace() {
        return this.trace;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public PathwayContext getPathwayContext() {
        return this.pathwayContext;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public void mergePathwayContext(PathwayContext pathwayContext) {
        if (pathwayContext == null) {
            return;
        }
        if (this.pathwayContext.isStarted()) {
            if (ThreadLocalRandom.current().nextInt(2) == 1) {
                this.pathwayContext = pathwayContext;
                return;
            }
            return;
        }
        this.pathwayContext = pathwayContext;
    }

    public CoreTracer getTracer() {
        return this.trace.getTracer();
    }

    public void setHttpStatusCode(short s) {
        this.httpStatusCode = s;
    }

    public short getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public void setOrigin(CharSequence charSequence) {
        DDSpanContext rootSpanContextOrThis = getRootSpanContextOrThis();
        rootSpanContextOrThis.origin = charSequence;
        rootSpanContextOrThis.propagationTags.updateTraceOrigin(charSequence);
    }

    public void setMetric(CharSequence charSequence, Number number) {
        synchronized (this.unsafeTags) {
            unsafeSetTag(charSequence.toString(), number);
        }
    }

    public void setTag(String str, Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            synchronized (this.unsafeTags) {
                this.unsafeTags.remove(str);
            }
        } else {
            if (this.trace.getTracer().getTagInterceptor().interceptTag(this, str, obj)) {
                return;
            }
            synchronized (this.unsafeTags) {
                unsafeSetTag(str, obj);
            }
        }
    }

    void setAllTags(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        TagInterceptor tagInterceptor = this.trace.getTracer().getTagInterceptor();
        synchronized (this.unsafeTags) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                if (!tagInterceptor.interceptTag(this, entry.getKey(), entry.getValue())) {
                    unsafeSetTag(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    void unsafeSetTag(String str, Object obj) {
        this.unsafeTags.put(str, obj);
    }

    Object getTag(String str) {
        Object objUnsafeGetTag;
        str.hashCode();
        switch (str) {
            case "thread.id":
                return Long.valueOf(this.threadId);
            case "http.status_code":
                if (this.httpStatusCode == 0) {
                    return null;
                }
                return Integer.valueOf(this.httpStatusCode);
            case "thread.name":
                return this.threadName.toString();
            default:
                synchronized (this.unsafeTags) {
                    objUnsafeGetTag = unsafeGetTag(str);
                    break;
                }
                if (objUnsafeGetTag == null) {
                    return null;
                }
                return "http.url".equals(str) ? objUnsafeGetTag.toString() : objUnsafeGetTag;
        }
    }

    public Object unsafeGetTag(String str) {
        return this.unsafeTags.get(str);
    }

    public Map<String, Object> getTags() {
        Map<String, Object> mapUnmodifiableMap;
        synchronized (this.unsafeTags) {
            HashMap map = new HashMap(this.unsafeTags);
            map.put(DDTags.THREAD_ID, Long.valueOf(this.threadId));
            map.put(DDTags.THREAD_NAME, this.threadName.toString());
            if (this.samplingPriority != -128) {
                map.put(SAMPLE_RATE_KEY, Integer.valueOf(this.samplingPriority));
            }
            if (this.httpStatusCode != 0) {
                map.put("http.status_code", Integer.valueOf(this.httpStatusCode));
            }
            Object obj = map.get("http.url");
            if (obj != null) {
                map.put("http.url", obj.toString());
            }
            mapUnmodifiableMap = Collections.unmodifiableMap(map);
        }
        return mapUnmodifiableMap;
    }

    public void processTagsAndBaggage(MetadataConsumer metadataConsumer, int i, List<AgentSpanLink> list) {
        HashMap<String, String> mapCreateTagMap;
        synchronized (this.unsafeTags) {
            Map<String, Object> mapProcessTagsWithContext = TagsPostProcessorFactory.instance().processTagsWithContext(this.unsafeTags, this);
            String tag = DDSpanLink.toTag(list);
            if (tag != null) {
                mapProcessTagsWithContext.put("_dd.span_links", tag);
            }
            if (this.injectBaggageAsTags) {
                mapCreateTagMap = new HashMap<>(this.baggageItems);
                this.propagationTags.fillTagMap(mapCreateTagMap);
            } else {
                mapCreateTagMap = this.propagationTags.createTagMap();
            }
            metadataConsumer.accept(new Metadata(this.threadId, this.threadName, mapProcessTagsWithContext, mapCreateTagMap, this.samplingPriority != -128 ? this.samplingPriority : getTraceSamplingPriority(), this.measured, this.topLevel, this.httpStatusCode == 0 ? null : RadixTreeCache.HTTP_STATUSES.get(this.httpStatusCode), getOrigin(), i));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DDSpan [ t_id=");
        sb.append(this.traceId);
        sb.append(", s_id=");
        sb.append(this.spanId);
        sb.append(", p_id=");
        sb.append(this.parentId);
        sb.append(" ] trace=");
        sb.append(getServiceName());
        sb.append(DomExceptionUtils.SEPARATOR);
        sb.append(getOperationName());
        sb.append(DomExceptionUtils.SEPARATOR);
        sb.append(getResourceName());
        if (this.errorFlag) {
            sb.append(" *errored*");
        }
        if (this.measured) {
            sb.append(" *measured*");
        }
        synchronized (this.unsafeTags) {
            sb.append(" tags=");
            sb.append(new TreeMap(getTags()));
        }
        return sb.toString();
    }

    @Override // com.datadog.trace.api.gateway.RequestContext
    public Object getData(RequestContextSlot requestContextSlot) {
        if (requestContextSlot == RequestContextSlot.APPSEC) {
            return this.requestContextDataAppSec;
        }
        if (requestContextSlot == RequestContextSlot.CI_VISIBILITY) {
            return this.ciVisibilityContextData;
        }
        if (requestContextSlot == RequestContextSlot.IAST) {
            return this.requestContextDataIast;
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Object obj = this.requestContextDataAppSec;
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                e = e;
            } catch (RuntimeException e2) {
                e = e2;
            }
        }
        e = null;
        Object obj2 = this.requestContextDataIast;
        if (obj2 instanceof Closeable) {
            try {
                ((Closeable) obj2).close();
            } catch (IOException | RuntimeException e3) {
                e = e3;
            }
        }
        if (e != null) {
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            }
            throw ((IOException) e);
        }
    }

    @Override // com.datadog.trace.api.gateway.RequestContext
    public void setBlockResponseFunction(BlockResponseFunction blockResponseFunction) {
        getRootSpanContextOrThis().blockResponseFunction = blockResponseFunction;
    }

    @Override // com.datadog.trace.api.gateway.RequestContext
    public BlockResponseFunction getBlockResponseFunction() {
        return getRootSpanContextOrThis().blockResponseFunction;
    }

    public PropagationTags getPropagationTags() {
        return getRootSpanContextOrThis().propagationTags;
    }

    @Override // com.datadog.trace.api.internal.TraceSegment
    public void setTagTop(String str, Object obj, boolean z) {
        getRootSpanContextOrThis().setTagCurrent(str, obj, z);
    }

    @Override // com.datadog.trace.api.internal.TraceSegment
    public void setTagCurrent(String str, Object obj, boolean z) {
        if (z) {
            str = TagsHelper.sanitize(str);
        }
        setTag(str, obj);
    }

    @Override // com.datadog.trace.api.internal.TraceSegment
    public void setDataTop(String str, Object obj) {
        getRootSpanContextOrThis().setDataCurrent(str, obj);
    }

    @Override // com.datadog.trace.api.internal.TraceSegment
    public void effectivelyBlocked() {
        setTag("appsec.blocked", "true");
    }

    @Override // com.datadog.trace.api.internal.TraceSegment
    public void setDataCurrent(String str, Object obj) {
        setTag("_dd." + str + ".json", obj);
    }
}
