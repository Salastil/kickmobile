package com.datadog.trace.core;

import androidx.work.WorkInfo;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.trace.internal.compat.function.BiFunction;
import com.datadog.android.trace.internal.compat.function.Supplier;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.DDSpanId;
import com.datadog.trace.api.DDTags;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.DynamicConfig;
import com.datadog.trace.api.EndpointCheckpointerHolder;
import com.datadog.trace.api.EndpointTracker;
import com.datadog.trace.api.IdGenerationStrategy;
import com.datadog.trace.api.InstrumenterConfig;
import com.datadog.trace.api.StatsDClient;
import com.datadog.trace.api.gateway.RequestContext;
import com.datadog.trace.api.gateway.RequestContextSlot;
import com.datadog.trace.api.naming.SpanNaming;
import com.datadog.trace.api.profiling.Timer;
import com.datadog.trace.api.scopemanager.ScopeListener;
import com.datadog.trace.api.time.SystemTimeSource;
import com.datadog.trace.api.time.TimeSource;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.bootstrap.instrumentation.api.AgentScope;
import com.datadog.trace.bootstrap.instrumentation.api.AgentScopeManager;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink;
import com.datadog.trace.bootstrap.instrumentation.api.AgentTracer;
import com.datadog.trace.bootstrap.instrumentation.api.PathwayContext;
import com.datadog.trace.bootstrap.instrumentation.api.ProfilingContextIntegration;
import com.datadog.trace.bootstrap.instrumentation.api.ScopeSource;
import com.datadog.trace.bootstrap.instrumentation.api.TagContext;
import com.datadog.trace.common.metrics.MetricsAggregator;
import com.datadog.trace.common.metrics.NoOpMetricsAggregator;
import com.datadog.trace.common.sampling.Sampler;
import com.datadog.trace.common.sampling.SpanSamplingRules;
import com.datadog.trace.common.sampling.TraceSamplingRules;
import com.datadog.trace.common.writer.NoOpWriter;
import com.datadog.trace.common.writer.Writer;
import com.datadog.trace.core.monitor.HealthMetrics;
import com.datadog.trace.core.propagation.CorePropagation;
import com.datadog.trace.core.propagation.ExtractedContext;
import com.datadog.trace.core.propagation.HttpCodec;
import com.datadog.trace.core.propagation.PropagationTags;
import com.datadog.trace.core.scopemanager.ContinuableScopeManager;
import com.datadog.trace.core.taginterceptor.RuleFlags;
import com.datadog.trace.core.taginterceptor.TagInterceptor;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.datadog.trace.monitor.NoOpRecording;
import com.datadog.trace.monitor.Recording;
import com.datadog.trace.util.AgentThreadFactory;
import com.datadog.trace.util.CollectionUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class CoreTracer implements AgentTracer.TracerAPI {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean allowInferredServices;
    private final long clockSyncPeriod;
    private volatile long counterDrift;
    private final Map<String, ?> defaultSpanTags;
    private final boolean disableSamplingMechanismValidation;
    private final DynamicConfig<ConfigSnapshot> dynamicConfig;
    private final EndpointCheckpointerHolder endpointCheckpointer;
    private final HealthMetrics healthMetrics;
    private final IdGenerationStrategy idGenerationStrategy;
    final Config initialConfig;
    final Sampler initialSampler;
    private boolean injectBaggageAsTags;
    final InternalLogger internalLogger;
    private volatile long lastSyncTicks;
    private final Map<String, ?> localRootSpanTags;
    final Logger log;
    private final boolean logs128bTraceIdEnabled;
    final MetricsAggregator metricsAggregator;
    private final int partialFlushMinSpans;
    private final PendingTraceBuffer pendingTraceBuffer;
    private final PendingTrace.Factory pendingTraceFactory;
    private final ProfilingContextIntegration profilingContextIntegration;
    private final AgentPropagation propagation;
    private final PropagationTags.Factory propagationTagsFactory;
    final AgentScopeManager scopeManager;
    final String serviceName;
    private final Thread shutdownCallback;
    private final long startNanoTicks;
    private final long startTimeNano;
    private final StatsDClient statsDClient;
    private final TagInterceptor tagInterceptor;
    private final TimeSource timeSource;
    private Timer timer;
    private final Recording traceWriteTimer;
    final Writer writer;

    private List<DDSpan> interceptCompleteTrace(List<DDSpan> list) {
        return list;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public ConfigSnapshot captureTraceConfig() {
        return (ConfigSnapshot) this.dynamicConfig.captureTraceConfig();
    }

    PropagationTags.Factory getPropagationTagsFactory() {
        return this.propagationTagsFactory;
    }

    @Override // com.datadog.trace.api.EndpointCheckpointer
    public void onRootSpanFinished(AgentSpan agentSpan, EndpointTracker endpointTracker) {
        this.endpointCheckpointer.onRootSpanFinished(agentSpan, endpointTracker);
    }

    @Override // com.datadog.trace.api.EndpointCheckpointer
    public EndpointTracker onRootSpanStarted(AgentSpan agentSpan) {
        return this.endpointCheckpointer.onRootSpanStarted(agentSpan);
    }

    public static class CoreTracerBuilder {
        private Map<String, String> baggageMapping;
        private Config config;
        private Map<String, ?> defaultSpanTags;
        private HttpCodec.Extractor extractor;
        private IdGenerationStrategy idGenerationStrategy;
        private boolean injectBaggageAsTags;
        private HttpCodec.Injector injector;
        private InternalLogger internalLogger;
        private Map<String, ?> localRootSpanTags;
        private int partialFlushMinSpans;
        private Sampler sampler;
        private AgentScopeManager scopeManager;
        private String serviceName;
        private Map<String, String> serviceNameMappings;
        private boolean strictTraceWrites;
        private TagInterceptor tagInterceptor;
        private Map<String, String> taggedHeaders;
        private TimeSource timeSource;
        private Writer writer = new NoOpWriter();
        private ProfilingContextIntegration profilingContextIntegration = ProfilingContextIntegration.NoOp.INSTANCE;

        public CoreTracerBuilder serviceName(String str) {
            this.serviceName = str;
            return this;
        }

        public CoreTracerBuilder writer(Writer writer) {
            this.writer = writer;
            return this;
        }

        public CoreTracerBuilder idGenerationStrategy(IdGenerationStrategy idGenerationStrategy) {
            this.idGenerationStrategy = idGenerationStrategy;
            return this;
        }

        public CoreTracerBuilder sampler(Sampler sampler) {
            this.sampler = sampler;
            return this;
        }

        public CoreTracerBuilder extractor(HttpCodec.Extractor extractor) {
            this.extractor = extractor;
            return this;
        }

        public CoreTracerBuilder injector(HttpCodec.Injector injector) {
            this.injector = injector;
            return this;
        }

        public CoreTracerBuilder scopeManager(AgentScopeManager agentScopeManager) {
            this.scopeManager = agentScopeManager;
            return this;
        }

        public CoreTracerBuilder localRootSpanTags(Map<String, ?> map) {
            this.localRootSpanTags = CollectionUtils.tryMakeImmutableMap(map);
            return this;
        }

        public CoreTracerBuilder defaultSpanTags(Map<String, ?> map) {
            this.defaultSpanTags = CollectionUtils.tryMakeImmutableMap(map);
            return this;
        }

        public CoreTracerBuilder serviceNameMappings(Map<String, String> map) {
            this.serviceNameMappings = CollectionUtils.tryMakeImmutableMap(map);
            return this;
        }

        public CoreTracerBuilder taggedHeaders(Map<String, String> map) {
            this.taggedHeaders = CollectionUtils.tryMakeImmutableMap(map);
            return this;
        }

        public CoreTracerBuilder baggageMapping(Map<String, String> map) {
            this.baggageMapping = CollectionUtils.tryMakeImmutableMap(map);
            return this;
        }

        public CoreTracerBuilder partialFlushMinSpans(int i) {
            this.partialFlushMinSpans = i;
            return this;
        }

        public CoreTracerBuilder tagInterceptor(TagInterceptor tagInterceptor) {
            this.tagInterceptor = tagInterceptor;
            return this;
        }

        public CoreTracerBuilder strictTraceWrites(boolean z) {
            this.strictTraceWrites = z;
            return this;
        }

        public CoreTracerBuilder timeSource(TimeSource timeSource) {
            this.timeSource = timeSource;
            return this;
        }

        public CoreTracerBuilder injectBaggageAsTags(boolean z) {
            this.injectBaggageAsTags = z;
            return this;
        }

        public CoreTracerBuilder(InternalLogger internalLogger) {
            config(Config.get());
            this.internalLogger = internalLogger;
        }

        public CoreTracerBuilder withProperties(Properties properties) {
            return config(Config.get(properties));
        }

        public CoreTracerBuilder config(Config config) {
            this.config = config;
            serviceName(config.getServiceName());
            sampler(Sampler.Builder.forConfig(config, null));
            localRootSpanTags(config.getLocalRootSpanTags());
            defaultSpanTags(config.getMergedSpanTags());
            serviceNameMappings(config.getServiceMapping());
            taggedHeaders(config.getRequestHeaderTags());
            baggageMapping(config.getBaggageMapping());
            partialFlushMinSpans(config.getPartialFlushMinSpans());
            strictTraceWrites(config.isTraceStrictWritesEnabled());
            injectBaggageAsTags(config.isInjectBaggageAsTagsEnabled());
            injector(HttpCodec.createInjector(config, config.getTracePropagationStylesToInject(), CoreTracer.invertMap(config.getBaggageMapping())));
            return this;
        }

        public CoreTracer build() {
            return new CoreTracer(this.config, this.serviceName, this.writer, this.idGenerationStrategy, this.sampler, this.injector, this.extractor, this.scopeManager, this.localRootSpanTags, this.defaultSpanTags, this.serviceNameMappings, this.taggedHeaders, this.baggageMapping, this.partialFlushMinSpans, this.tagInterceptor, this.strictTraceWrites, this.timeSource, this.profilingContextIntegration, this.injectBaggageAsTags, this.internalLogger);
        }
    }

    private CoreTracer(Config config, String str, Writer writer, IdGenerationStrategy idGenerationStrategy, Sampler sampler, HttpCodec.Injector injector, HttpCodec.Extractor extractor, AgentScopeManager agentScopeManager, Map<String, ?> map, Map<String, ?> map2, Map<String, String> map3, Map<String, String> map4, Map<String, String> map5, int i, TagInterceptor tagInterceptor, boolean z, TimeSource timeSource, ProfilingContextIntegration profilingContextIntegration, boolean z2, InternalLogger internalLogger) {
        TraceSamplingRules traceSamplingRulesDeserialize;
        ProfilingContextIntegration profilingContextIntegration2;
        PendingTraceBuffer pendingTraceBufferDelaying;
        this.timer = Timer.NoOp.INSTANCE;
        this.log = LoggerFactory.getLogger("CoreTracer", internalLogger);
        TimeSource timeSource2 = timeSource == null ? SystemTimeSource.INSTANCE : timeSource;
        this.timeSource = timeSource2;
        this.startTimeNano = timeSource2.getCurrentTimeNanos();
        long nanoTicks = timeSource2.getNanoTicks();
        this.startNanoTicks = nanoTicks;
        this.clockSyncPeriod = Math.max(1000000L, TimeUnit.SECONDS.toNanos(config.getClockSyncPeriod()));
        this.lastSyncTicks = nanoTicks;
        this.endpointCheckpointer = EndpointCheckpointerHolder.create();
        this.serviceName = str;
        this.initialConfig = config;
        this.initialSampler = sampler;
        if (config.getTraceSamplingRules() == null) {
            traceSamplingRulesDeserialize = TraceSamplingRules.EMPTY;
        } else {
            traceSamplingRulesDeserialize = TraceSamplingRules.deserialize(config.getTraceSamplingRules());
        }
        String spanSamplingRules = config.getSpanSamplingRules();
        String spanSamplingRulesFile = config.getSpanSamplingRulesFile();
        SpanSamplingRules spanSamplingRulesDeserializeFile = SpanSamplingRules.EMPTY;
        if (spanSamplingRules != null) {
            spanSamplingRulesDeserializeFile = SpanSamplingRules.deserialize(spanSamplingRules);
        } else if (spanSamplingRulesFile != null) {
            spanSamplingRulesDeserializeFile = SpanSamplingRules.deserializeFile(spanSamplingRulesFile);
        }
        this.dynamicConfig = DynamicConfig.create(new BiFunction() { // from class: com.datadog.trace.core.CoreTracer$$ExternalSyntheticLambda0
            @Override // com.datadog.android.trace.internal.compat.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.f$0.m11179lambda$new$0$comdatadogtracecoreCoreTracer((DynamicConfig.Builder) obj, (CoreTracer.ConfigSnapshot) obj2);
            }
        }).setRuntimeMetricsEnabled(config.isRuntimeMetricsEnabled()).setLogsInjectionEnabled(config.isLogsInjectionEnabled()).setDataStreamsEnabled(config.isDataStreamsEnabled()).setServiceMapping(map3).setHeaderTags(map4).setBaggageMapping(map5).setTraceSampleRate(config.getTraceSampleRate()).setSpanSamplingRules(spanSamplingRulesDeserializeFile.getRules()).setTraceSamplingRules(traceSamplingRulesDeserialize.getRules()).apply();
        this.logs128bTraceIdEnabled = InstrumenterConfig.get().isLogs128bTraceIdEnabled();
        this.defaultSpanTags = map2;
        this.partialFlushMinSpans = i;
        this.idGenerationStrategy = idGenerationStrategy == null ? Config.get().getIdGenerationStrategy() : idGenerationStrategy;
        this.statsDClient = StatsDClient.NO_OP;
        this.traceWriteTimer = NoOpRecording.NO_OP;
        HealthMetrics healthMetrics = HealthMetrics.NO_OP;
        this.healthMetrics = healthMetrics;
        if (agentScopeManager == null) {
            profilingContextIntegration2 = profilingContextIntegration;
            this.scopeManager = new ContinuableScopeManager(config.getScopeDepthLimit(), config.isScopeStrictMode(), config.isScopeInheritAsyncPropagation(), profilingContextIntegration2, healthMetrics, internalLogger);
        } else {
            profilingContextIntegration2 = profilingContextIntegration;
            this.scopeManager = agentScopeManager;
        }
        this.disableSamplingMechanismValidation = config.isSamplingMechanismValidationDisabled();
        this.writer = writer;
        if (z) {
            pendingTraceBufferDelaying = PendingTraceBuffer.discarding(internalLogger);
        } else {
            pendingTraceBufferDelaying = PendingTraceBuffer.delaying(timeSource2, config, healthMetrics);
        }
        PendingTraceBuffer pendingTraceBuffer = pendingTraceBufferDelaying;
        this.pendingTraceBuffer = pendingTraceBuffer;
        this.pendingTraceFactory = new PendingTrace.Factory(this, pendingTraceBuffer, timeSource2, z, healthMetrics);
        pendingTraceBuffer.start();
        writer.start();
        this.metricsAggregator = NoOpMetricsAggregator.INSTANCE;
        this.propagation = new CorePropagation(extractor == null ? HttpCodec.createExtractor(config, new Supplier() { // from class: com.datadog.trace.core.CoreTracer$$ExternalSyntheticLambda1
            @Override // com.datadog.android.trace.internal.compat.function.Supplier
            public final Object get() {
                return this.f$0.captureTraceConfig();
            }
        }) : extractor, injector, HttpCodec.allInjectorsFor(config, invertMap(map5)));
        this.tagInterceptor = tagInterceptor == null ? new TagInterceptor(new RuleFlags(config)) : tagInterceptor;
        ShutdownHook shutdownHook = new ShutdownHook();
        this.shutdownCallback = shutdownHook;
        try {
            Runtime.getRuntime().addShutdownHook(shutdownHook);
        } catch (IllegalStateException unused) {
        }
        this.propagationTagsFactory = PropagationTags.factory(config);
        this.profilingContextIntegration = profilingContextIntegration2;
        this.injectBaggageAsTags = z2;
        this.allowInferredServices = SpanNaming.instance().namingSchema().allowInferredServices();
        if (profilingContextIntegration2 != ProfilingContextIntegration.NoOp.INSTANCE) {
            HashMap map6 = new HashMap(map);
            map6.put(DDTags.PROFILING_CONTEXT_ENGINE, profilingContextIntegration2.name());
            this.localRootSpanTags = CollectionUtils.tryMakeImmutableMap(map6);
        } else {
            this.localRootSpanTags = map;
        }
        this.internalLogger = internalLogger;
    }

    /* JADX INFO: renamed from: lambda$new$0$com-datadog-trace-core-CoreTracer, reason: not valid java name */
    /* synthetic */ ConfigSnapshot m11179lambda$new$0$comdatadogtracecoreCoreTracer(DynamicConfig.Builder builder, ConfigSnapshot configSnapshot) {
        return new ConfigSnapshot(builder, configSnapshot);
    }

    protected void finalize() {
        Thread thread = this.shutdownCallback;
        if (thread != null) {
            try {
                thread.run();
                Runtime.getRuntime().removeShutdownHook(this.shutdownCallback);
            } catch (IllegalStateException unused) {
            } catch (Exception e) {
                this.log.error("Error while finalizing DDTracer.", (Throwable) e);
            }
        }
    }

    PendingTrace createTrace(DDTraceId dDTraceId, ConfigSnapshot configSnapshot) {
        return this.pendingTraceFactory.create(dDTraceId, configSnapshot);
    }

    long getTimeWithNanoTicks(long j) {
        long jMax = this.startTimeNano + Math.max(0L, j - this.startNanoTicks);
        if (j - this.lastSyncTicks >= this.clockSyncPeriod) {
            long currentTimeNanos = jMax - this.timeSource.getCurrentTimeNanos();
            if (Math.abs(this.counterDrift + currentTimeNanos) >= 1000000) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                this.counterDrift = -timeUnit.toNanos(currentTimeNanos / 1000000);
            }
            this.lastSyncTicks = j;
        }
        return jMax + this.counterDrift;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public CoreSpanBuilder buildSpan(String str, CharSequence charSequence) {
        return new CoreSpanBuilder(str, charSequence, this);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public AgentSpan startSpan(String str, CharSequence charSequence) {
        return buildSpan(str, charSequence).start();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public AgentSpan startSpan(String str, CharSequence charSequence, long j) {
        return buildSpan(str, charSequence).withStartTimestamp(j).start();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public AgentSpan startSpan(String str, CharSequence charSequence, AgentSpan.Context context) {
        return buildSpan(str, charSequence).ignoreActiveSpan().asChildOf(context).start();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public AgentSpan startSpan(String str, CharSequence charSequence, AgentSpan.Context context, long j) {
        return buildSpan(str, charSequence).ignoreActiveSpan().asChildOf(context).withStartTimestamp(j).start();
    }

    public AgentScope activateSpan(AgentSpan agentSpan) {
        return this.scopeManager.activate(agentSpan, ScopeSource.INSTRUMENTATION, true);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public AgentScope activateSpan(AgentSpan agentSpan, ScopeSource scopeSource) {
        return this.scopeManager.activate(agentSpan, scopeSource);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public AgentScope activateSpan(AgentSpan agentSpan, ScopeSource scopeSource, boolean z) {
        return this.scopeManager.activate(agentSpan, scopeSource, z);
    }

    public TagInterceptor getTagInterceptor() {
        return this.tagInterceptor;
    }

    public int getPartialFlushMinSpans() {
        return this.partialFlushMinSpans;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public AgentSpan activeSpan() {
        return this.scopeManager.activeSpan();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public AgentPropagation propagate() {
        return this.propagation;
    }

    void write(List<DDSpan> list) {
        List<DDSpan> listInterceptCompleteTrace = interceptCompleteTrace(list);
        if (listInterceptCompleteTrace.isEmpty()) {
            return;
        }
        boolean zPublish = this.metricsAggregator.publish(listInterceptCompleteTrace);
        PendingTrace trace = listInterceptCompleteTrace.get(0).context().getTrace();
        trace.setSamplingPriorityIfNecessary();
        DDSpan rootSpan = trace.getRootSpan();
        DDSpan dDSpan = rootSpan == null ? listInterceptCompleteTrace.get(0) : rootSpan;
        dDSpan.forceKeep(zPublish);
        if (zPublish || trace.sample(dDSpan)) {
            this.writer.write(listInterceptCompleteTrace);
        } else {
            this.writer.incrementDropCounts(listInterceptCompleteTrace.size());
        }
        if (rootSpan != null) {
            onRootSpanFinished(rootSpan, rootSpan.getEndpointTracker());
            RequestContext requestContext = rootSpan.getRequestContext();
            if (requestContext != null) {
                try {
                    requestContext.close();
                } catch (IOException e) {
                    this.log.warn("Error closing request context data", (Throwable) e);
                }
            }
        }
    }

    public String getTraceId() {
        return getTraceId(activeSpan());
    }

    public String getSpanId() {
        return getSpanId(activeSpan());
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public String getTraceId(AgentSpan agentSpan) {
        if (agentSpan != null && agentSpan.getTraceId() != null) {
            DDTraceId traceId = agentSpan.getTraceId();
            if (this.logs128bTraceIdEnabled && traceId.toHighOrderLong() != 0) {
                return traceId.toHexString();
            }
            return traceId.toString();
        }
        return "0";
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public String getSpanId(AgentSpan agentSpan) {
        if (agentSpan != null) {
            return DDSpanId.toString(agentSpan.getSpanId());
        }
        return "0";
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public void addScopeListener(ScopeListener scopeListener) {
        AgentScopeManager agentScopeManager = this.scopeManager;
        if (agentScopeManager instanceof ContinuableScopeManager) {
            ((ContinuableScopeManager) agentScopeManager).addScopeListener(scopeListener);
        }
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.TracerAPI
    public void close() {
        this.pendingTraceBuffer.close();
        this.writer.close();
        this.statsDClient.close();
        this.metricsAggregator.close();
    }

    public void flush() {
        this.pendingTraceBuffer.flush();
        this.writer.flush();
    }

    Recording writeTimer() {
        return this.traceWriteTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Map<V, K> invertMap(Map<K, V> map) {
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            map2.put(entry.getValue(), entry.getKey());
        }
        return Collections.unmodifiableMap(map2);
    }

    public class CoreSpanBuilder implements AgentTracer.SpanBuilder {
        private Object builderCiVisibilityContextData;
        private Object builderRequestContextDataAppSec;
        private Object builderRequestContextDataIast;
        private boolean errorFlag;
        private boolean ignoreScope = false;
        private final String instrumentationName;
        private List<AgentSpanLink> links;
        private final CharSequence operationName;
        private String origin;
        private AgentSpan.Context parent;
        private String resourceName;
        private String serviceName;
        private CharSequence spanType;
        private Map<String, Object> tags;
        private long timestampMicro;
        private final CoreTracer tracer;

        CoreSpanBuilder(String str, CharSequence charSequence, CoreTracer coreTracer) {
            this.instrumentationName = str;
            this.operationName = charSequence;
            this.tracer = coreTracer;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public CoreSpanBuilder ignoreActiveSpan() {
            this.ignoreScope = true;
            return this;
        }

        private DDSpan buildSpan() {
            addTerminatedContextAsLinks();
            DDSpan dDSpanCreate = DDSpan.create(this.instrumentationName, this.timestampMicro, buildSpanContext(), this.links, this.tracer.internalLogger);
            if (dDSpanCreate.isLocalRootSpan()) {
                dDSpanCreate.setEndpointTracker(this.tracer.onRootSpanStarted(dDSpanCreate));
            }
            return dDSpanCreate;
        }

        private void addTerminatedContextAsLinks() {
            AgentSpan.Context context = this.parent;
            if (context instanceof TagContext) {
                List<AgentSpanLink> terminatedContextLinks = ((TagContext) context).getTerminatedContextLinks();
                if (terminatedContextLinks.isEmpty()) {
                    return;
                }
                if (this.links == null) {
                    this.links = new ArrayList();
                }
                this.links.addAll(terminatedContextLinks);
            }
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public AgentSpan start() {
            return buildSpan();
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public CoreSpanBuilder withTag(String str, Number number) {
            return withTag(str, (Object) number);
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public CoreSpanBuilder withTag(String str, String str2) {
            if (str2 == null || str2.isEmpty()) {
                str2 = null;
            }
            return withTag(str, (Object) str2);
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public CoreSpanBuilder withTag(String str, boolean z) {
            return withTag(str, (Object) Boolean.valueOf(z));
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public CoreSpanBuilder withStartTimestamp(long j) {
            this.timestampMicro = j;
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public CoreSpanBuilder withServiceName(String str) {
            this.serviceName = str;
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public CoreSpanBuilder withResourceName(String str) {
            this.resourceName = str;
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public CoreSpanBuilder withErrorFlag() {
            this.errorFlag = true;
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public CoreSpanBuilder withSpanType(CharSequence charSequence) {
            this.spanType = charSequence;
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public CoreSpanBuilder asChildOf(AgentSpan.Context context) {
            this.parent = context;
            return this;
        }

        public CoreSpanBuilder asChildOf(AgentSpan agentSpan) {
            this.parent = agentSpan.context();
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public CoreSpanBuilder withTag(String str, Object obj) {
            if (str == null) {
                return this;
            }
            Map linkedHashMap = this.tags;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                this.tags = linkedHashMap;
            }
            if (obj == null) {
                linkedHashMap.remove(str);
                return this;
            }
            linkedHashMap.put(str, obj);
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public <T> AgentTracer.SpanBuilder withRequestContextData(RequestContextSlot requestContextSlot, T t) {
            int i = AnonymousClass1.$SwitchMap$com$datadog$trace$api$gateway$RequestContextSlot[requestContextSlot.ordinal()];
            if (i == 1) {
                this.builderRequestContextDataAppSec = t;
                return this;
            }
            if (i == 2) {
                this.builderCiVisibilityContextData = t;
                return this;
            }
            if (i != 3) {
                return this;
            }
            this.builderRequestContextDataIast = t;
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public AgentTracer.SpanBuilder withLink(AgentSpanLink agentSpanLink) {
            if (agentSpanLink != null) {
                if (this.links == null) {
                    this.links = new ArrayList();
                }
                this.links.add(agentSpanLink);
            }
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTracer.SpanBuilder
        public AgentTracer.SpanBuilder withOrigin(String str) {
            this.origin = str;
            return this;
        }

        private DDSpanContext buildSpanContext() {
            DDTraceId dDTraceIdGenerateTraceId;
            PropagationTags propagationTagsEmpty;
            long spanId;
            long endToEndStartTime;
            CharSequence origin;
            Object ciVisibilityContextData;
            ConfigSnapshot configSnapshot;
            Map<String, String> tags;
            Map<String, String> baggage;
            Object requestContextDataAppSec;
            Object requestContextDataIast;
            Map<String, ?> map;
            int i;
            long spanId2;
            Map<String, String> map2;
            Object data;
            DDTraceId dDTraceId;
            PendingTrace pendingTrace;
            Object data2;
            String str;
            PathwayContext pathwayContext;
            Object data3;
            AgentSpan agentSpanActiveSpan;
            long jGenerateSpanId = CoreTracer.this.idGenerationStrategy.generateSpanId();
            AgentSpan.Context context = this.parent;
            if (context == null && !this.ignoreScope && (agentSpanActiveSpan = CoreTracer.this.scopeManager.activeSpan()) != null) {
                context = agentSpanActiveSpan.context();
            }
            boolean z = context instanceof DDSpanContext;
            int traceSamplingPriority = WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            if (z) {
                DDSpanContext dDSpanContext = (DDSpanContext) context;
                DDTraceId traceId = dDSpanContext.getTraceId();
                spanId2 = dDSpanContext.getSpanId();
                Map<String, String> baggageItems = dDSpanContext.getBaggageItems();
                PendingTrace trace = dDSpanContext.getTrace();
                String serviceName = dDSpanContext.getServiceName();
                if (this.serviceName == null) {
                    this.serviceName = serviceName;
                }
                RequestContext requestContext = dDSpanContext.getRequestContext();
                if (requestContext != null) {
                    data = requestContext.getData(RequestContextSlot.APPSEC);
                    data3 = requestContext.getData(RequestContextSlot.IAST);
                    data2 = requestContext.getData(RequestContextSlot.CI_VISIBILITY);
                } else {
                    data2 = null;
                    data = null;
                    data3 = null;
                }
                propagationTagsEmpty = CoreTracer.this.propagationTagsFactory.empty();
                i = -128;
                dDTraceId = traceId;
                str = serviceName;
                pendingTrace = trace;
                requestContextDataIast = data3;
                map = null;
                tags = null;
                origin = null;
                map2 = baggageItems;
            } else {
                if (context instanceof ExtractedContext) {
                    ExtractedContext extractedContext = (ExtractedContext) context;
                    DDTraceId traceId2 = extractedContext.getTraceId();
                    spanId = extractedContext.getSpanId();
                    int traceSamplingPriority2 = extractedContext.getTraceSamplingPriority();
                    endToEndStartTime = extractedContext.getEndToEndStartTime();
                    propagationTagsEmpty = extractedContext.getPropagationTags();
                    dDTraceIdGenerateTraceId = traceId2;
                    traceSamplingPriority = traceSamplingPriority2;
                } else {
                    if (context != null) {
                        if (context.getTraceId() == DDTraceId.ZERO) {
                            dDTraceIdGenerateTraceId = CoreTracer.this.idGenerationStrategy.generateTraceId();
                        } else {
                            dDTraceIdGenerateTraceId = context.getTraceId();
                        }
                        spanId = context.getSpanId();
                        traceSamplingPriority = context.getTraceSamplingPriority();
                        propagationTagsEmpty = CoreTracer.this.propagationTagsFactory.empty();
                    } else {
                        dDTraceIdGenerateTraceId = CoreTracer.this.idGenerationStrategy.generateTraceId();
                        propagationTagsEmpty = CoreTracer.this.propagationTagsFactory.empty();
                        spanId = 0;
                    }
                    endToEndStartTime = 0;
                }
                if (context instanceof TagContext) {
                    TagContext tagContext = (TagContext) context;
                    configSnapshot = (ConfigSnapshot) tagContext.getTraceConfig();
                    tags = tagContext.getTags();
                    origin = tagContext.getOrigin();
                    baggage = tagContext.getBaggage();
                    requestContextDataAppSec = tagContext.getRequestContextDataAppSec();
                    requestContextDataIast = tagContext.getRequestContextDataIast();
                    ciVisibilityContextData = tagContext.getCiVisibilityContextData();
                } else {
                    origin = this.origin;
                    ciVisibilityContextData = null;
                    configSnapshot = null;
                    tags = null;
                    baggage = null;
                    requestContextDataAppSec = null;
                    requestContextDataIast = null;
                }
                map = CoreTracer.this.localRootSpanTags;
                PendingTrace pendingTraceCreateTrace = CoreTracer.this.createTrace(dDTraceIdGenerateTraceId, configSnapshot);
                if (endToEndStartTime > 0) {
                    pendingTraceCreateTrace.beginEndToEnd(endToEndStartTime);
                }
                i = traceSamplingPriority;
                spanId2 = spanId;
                map2 = baggage;
                data = requestContextDataAppSec;
                dDTraceId = dDTraceIdGenerateTraceId;
                pendingTrace = pendingTraceCreateTrace;
                data2 = ciVisibilityContextData;
                str = null;
            }
            PropagationTags propagationTags = propagationTagsEmpty;
            if (context != null && context.getPathwayContext() != null && context.getPathwayContext().isStarted()) {
                pathwayContext = context.getPathwayContext();
            } else {
                pathwayContext = AgentTracer.NoopPathwayContext.INSTANCE;
            }
            PathwayContext pathwayContext2 = pathwayContext;
            if (!CoreTracer.this.allowInferredServices) {
                DDSpan rootSpan = pendingTrace.getRootSpan();
                this.serviceName = rootSpan != null ? rootSpan.getServiceName() : null;
            }
            if (this.serviceName == null) {
                this.serviceName = CoreTracer.this.serviceName;
            }
            CharSequence charSequence = this.operationName;
            if (charSequence == null) {
                charSequence = this.resourceName;
            }
            CharSequence charSequence2 = charSequence;
            Map<String, Object> map3 = this.tags;
            int size = (map3 == null ? 0 : map3.size()) + CoreTracer.this.defaultSpanTags.size() + (tags == null ? 0 : tags.size()) + (map != null ? map.size() : 0);
            Object obj = this.builderRequestContextDataAppSec;
            Object obj2 = obj != null ? obj : data;
            Object obj3 = this.builderCiVisibilityContextData;
            Object obj4 = obj3 != null ? obj3 : data2;
            Object obj5 = this.builderRequestContextDataIast;
            if (obj5 != null) {
                requestContextDataIast = obj5;
            }
            DDSpanContext dDSpanContext2 = new DDSpanContext(dDTraceId, jGenerateSpanId, spanId2, str, this.serviceName, charSequence2, this.resourceName, i, origin, map2, this.errorFlag, this.spanType, size, pendingTrace, obj2, requestContextDataIast, obj4, pathwayContext2, CoreTracer.this.disableSamplingMechanismValidation, propagationTags, CoreTracer.this.profilingContextIntegration, CoreTracer.this.injectBaggageAsTags);
            dDSpanContext2.setAllTags(CoreTracer.this.defaultSpanTags);
            dDSpanContext2.setAllTags(this.tags);
            dDSpanContext2.setAllTags(tags);
            dDSpanContext2.setAllTags(map);
            return dDSpanContext2;
        }
    }

    /* JADX INFO: renamed from: com.datadog.trace.core.CoreTracer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$datadog$trace$api$gateway$RequestContextSlot;

        static {
            int[] iArr = new int[RequestContextSlot.values().length];
            $SwitchMap$com$datadog$trace$api$gateway$RequestContextSlot = iArr;
            try {
                iArr[RequestContextSlot.APPSEC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$datadog$trace$api$gateway$RequestContextSlot[RequestContextSlot.CI_VISIBILITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$datadog$trace$api$gateway$RequestContextSlot[RequestContextSlot.IAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static class ShutdownHook extends Thread {
        private final WeakReference<CoreTracer> reference;

        private ShutdownHook(CoreTracer coreTracer) {
            super(AgentThreadFactory.AGENT_THREAD_GROUP, "dd-tracer-shutdown-hook");
            this.reference = new WeakReference<>(coreTracer);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            CoreTracer coreTracer = this.reference.get();
            if (coreTracer != null) {
                coreTracer.close();
            }
        }
    }

    protected class ConfigSnapshot extends DynamicConfig.Snapshot {
        final Sampler sampler;

        protected ConfigSnapshot(DynamicConfig<ConfigSnapshot>.Builder builder, ConfigSnapshot configSnapshot) {
            super(builder, configSnapshot);
            if (configSnapshot == null) {
                this.sampler = CoreTracer.this.initialSampler;
            } else if (Objects.equals(getTraceSampleRate(), configSnapshot.getTraceSampleRate())) {
                this.sampler = configSnapshot.sampler;
            } else {
                this.sampler = Sampler.Builder.forConfig(CoreTracer.this.initialConfig, this);
            }
        }
    }
}
