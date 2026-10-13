package com.datadog.trace.api;

import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.datadog.android.trace.internal.compat.function.Function;
import com.datadog.trace.api.config.CrashTrackingConfig;
import com.datadog.trace.api.config.GeneralConfig;
import com.datadog.trace.api.config.ProfilingConfig;
import com.datadog.trace.api.config.RemoteConfigConfig;
import com.datadog.trace.api.config.TraceInstrumentationConfig;
import com.datadog.trace.api.config.TracerConfig;
import com.datadog.trace.api.naming.SpanNaming;
import com.datadog.trace.bootstrap.config.provider.ConfigProvider;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.datadog.trace.util.CollectionUtils;
import com.datadog.trace.util.PidHelper;
import io.ktor.sse.ServerSentEventKt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
public class Config {
    public static final String PREFIX = "dd.";
    private final String DBMPropagationMode;
    private final boolean agentConfiguredUsingDefault;
    private final String agentHost;
    private final String agentNamedPipe;
    private final int agentPort;
    private final int agentTimeout;
    private final String agentUrl;
    private final boolean awsPropagationEnabled;
    private final boolean azureAppServices;
    private final Map<String, String> baggageMapping;
    private final boolean clientIpEnabled;
    private final int clockSyncPeriod;
    private final String configFileStatus;
    private final ConfigProvider configProvider;
    private final boolean crashTrackingAgentless;
    private final Map<String, String> crashTrackingTags;
    private final float dataStreamsBucketDurationSeconds;
    private final boolean dataStreamsEnabled;
    private final boolean dbClientSplitByHost;
    private final boolean dbClientSplitByInstance;
    private final boolean dbClientSplitByInstanceTypeSuffix;
    private final boolean debugEnabled;
    private final List<String> dogStatsDArgs;
    private final String dogStatsDNamedPipe;
    private final String dogStatsDPath;
    private final int dogStatsDStartDelay;
    private final boolean elasticsearchBodyAndParamsEnabled;
    private final boolean elasticsearchBodyEnabled;
    private final boolean elasticsearchParamsEnabled;
    private String env;
    private final BitSet grpcClientErrorStatuses;
    private final Set<String> grpcIgnoredInboundMethods;
    private final Set<String> grpcIgnoredOutboundMethods;
    private final BitSet grpcServerErrorStatuses;
    private final boolean grpcServerTrimPackageResource;
    private final boolean healthMetricsEnabled;
    private final String healthMetricsStatsdHost;
    private final Integer healthMetricsStatsdPort;
    private final BitSet httpClientErrorStatuses;
    private final Map<String, String> httpClientPathResourceNameMapping;
    private final boolean httpClientSplitByDomain;
    private final boolean httpClientTagHeaders;
    private final boolean httpClientTagQueryString;
    private final boolean httpResourceRemoveTrailingSlash;
    private final boolean httpServerDecodedResourcePreserveSpaces;
    private final BitSet httpServerErrorStatuses;
    private final Map<String, String> httpServerPathResourceNameMapping;
    private final boolean httpServerRawQueryString;
    private final boolean httpServerRawResource;
    private final boolean httpServerRouteBasedNaming;
    private final boolean httpServerTagQueryString;
    private final boolean hystrixMeasuredEnabled;
    private final boolean hystrixTagsEnabled;
    private final IdGenerationStrategy idGenerationStrategy;
    private final boolean igniteCacheIncludeKeys;
    private final boolean injectBaggageAsTagsEnabled;
    private final InstrumenterConfig instrumenterConfig;
    private final boolean integrationSynapseLegacyOperationName;
    private final boolean isDatadogProfilerEnabled;
    private final boolean isTelemetryDependencyServiceEnabled;
    private final boolean isTelemetryLogCollectionEnabled;
    private final boolean jaxRsExceptionAsErrorsEnabled;
    private final Set<String> jmsPropagationDisabledQueues;
    private final Set<String> jmsPropagationDisabledTopics;
    private final boolean jmsPropagationEnabled;
    private final int jmsUnacknowledgedMaxAge;
    private final boolean kafkaClientBase64DecodingEnabled;
    private final Set<String> kafkaClientPropagationDisabledTopics;
    private final boolean kafkaClientPropagationEnabled;
    private final boolean logExtractHeaderNames;
    private final boolean logsInjectionEnabled;
    private final boolean longRunningTraceEnabled;
    private final long longRunningTraceFlushInterval;
    private final boolean messageBrokerSplitByDestination;
    private final Set<String> noProxyHosts;
    private final String obfuscationQueryRegexp;
    private final int partialFlushMinSpans;
    private final Map<String, String> peerServiceComponentOverrides;
    private final boolean peerServiceDefaultsEnabled;
    private final Map<String, String> peerServiceMapping;
    private final boolean perfMetricsEnabled;
    private final boolean playReportHttpStatus;
    private final String primaryTag;
    private final boolean prioritySamplingEnabled;
    private final String prioritySamplingForce;
    private final boolean profilingAgentless;
    private final int profilingDirectAllocationSampleLimit;
    private final boolean profilingEnabled;
    private final int profilingExceptionHistogramMaxCollectionSize;
    private final int profilingExceptionHistogramTopItems;
    private final int profilingExceptionSampleLimit;
    private final boolean profilingExcludeAgentThreads;
    private final String profilingProxyHost;
    private final String profilingProxyPassword;
    private final int profilingProxyPort;
    private final String profilingProxyUsername;
    private final boolean profilingRecordExceptionMessage;
    private final int profilingStartDelay;
    private final boolean profilingStartForceFirst;
    private final Map<String, String> profilingTags;
    private final String profilingTemplateOverrideFile;
    private final String profilingUploadCompression;
    private final int profilingUploadPeriod;
    private final boolean profilingUploadSummaryOn413Enabled;
    private final int profilingUploadTimeout;

    @Deprecated
    private final String profilingUrl;
    private final boolean rabbitIncludeRoutingKeyInResource;
    private final Set<String> rabbitPropagationDisabledExchanges;
    private final Set<String> rabbitPropagationDisabledQueues;
    private final boolean rabbitPropagationEnabled;
    private final boolean remoteConfigEnabled;
    private final boolean remoteConfigIntegrityCheckEnabled;
    private final long remoteConfigMaxPayloadSize;
    private final float remoteConfigPollIntervalSeconds;
    private final String remoteConfigTargetsKey;
    private final String remoteConfigTargetsKeyId;
    private final String remoteConfigUrl;
    private final boolean removeIntegrationServiceNamesEnabled;
    private final boolean reportHostName;
    private final Map<String, String> requestHeaderTags;
    private final boolean requestHeaderTagsCommaAllowed;
    private final Map<String, String> responseHeaderTags;
    private final String rootContextServiceName;
    private final boolean runtimeIdEnabled;
    private final boolean runtimeMetricsEnabled;
    private final String runtimeVersion;
    private final int scopeDepthLimit;
    private final boolean scopeInheritAsyncPropagation;
    private final int scopeIterationKeepAlive;
    private final boolean scopeStrictMode;
    private final boolean secureRandom;
    private final Map<String, String> serviceMapping;
    private final String serviceName;
    private final boolean serviceNameSetByUser;
    private final boolean servletAsyncTimeoutError;
    private final boolean servletPrincipalEnabled;
    private final String site;
    private final int spanAttributeSchemaVersion;
    private final String spanSamplingRules;
    private final String spanSamplingRulesFile;
    private final Map<String, String> spanTags;
    private final boolean sparkTaskHistogramEnabled;
    private final Set<String> splitByTags;
    private final boolean springDataRepositoryInterfaceResourceName;
    private final boolean sqsPropagationEnabled;
    private final long startTimeMillis;
    private final boolean startupLogsEnabled;
    private final Integer statsDClientQueueSize;
    private final Integer statsDClientSocketBuffer;
    private final Integer statsDClientSocketTimeout;
    private final Map<String, String> tags;
    private final boolean telemetryDebugRequestsEnabled;
    private final long telemetryExtendedHeartbeatInterval;
    private final float telemetryHeartbeatInterval;
    private final boolean telemetryMetricsEnabled;
    private final float telemetryMetricsInterval;
    private final boolean timelineEventsEnabled;
    private final boolean trace128bitTraceIdGenerationEnabled;
    private final List<String> traceAgentArgs;
    private final String traceAgentPath;
    private final boolean traceAgentV05Enabled;
    private final boolean traceAnalyticsEnabled;
    private final String traceClientIpHeader;
    private final boolean traceClientIpResolverEnabled;
    private final float traceFlushIntervalSeconds;
    private final boolean traceGitMetadataEnabled;
    private final boolean tracePropagationExtractFirst;
    private final boolean tracePropagationStyleB3PaddingEnabled;
    private final Set<TracePropagationStyle> tracePropagationStylesToExtract;
    private final Set<TracePropagationStyle> tracePropagationStylesToInject;
    private final int traceRateLimit;
    private final boolean traceResolverEnabled;
    private final Double traceSampleRate;
    private final Map<String, String> traceSamplingOperationRules;
    private final String traceSamplingRules;
    private final Map<String, String> traceSamplingServiceRules;
    private final boolean traceStrictWritesEnabled;
    private final boolean tracerMetricsBufferingEnabled;
    private final boolean tracerMetricsEnabled;
    private final int tracerMetricsMaxAggregates;
    private final int tracerMetricsMaxPending;
    private final boolean triageEnabled;
    private String version;
    private final String writerType;
    private final int xDatadogTagsMaxLength;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) Config.class);
    private static final Pattern COLON = Pattern.compile(ServerSentEventKt.COLON);
    private static final Config INSTANCE = new Config(ConfigProvider.getInstance(), InstrumenterConfig.get());

    public boolean isCiVisibilityEnabled() {
        return false;
    }

    static class RuntimeIdHolder {
        static final String runtimeId = UUID.randomUUID().toString();

        RuntimeIdHolder() {
        }
    }

    static class HostNameHolder {
        static final String hostName = Config.initHostName();

        HostNameHolder() {
        }
    }

    private Config() {
        this(ConfigProvider.createDefault());
    }

    private Config(ConfigProvider configProvider) {
        this(configProvider, new InstrumenterConfig(configProvider));
    }

    private Config(ConfigProvider configProvider, InstrumenterConfig instrumenterConfig) {
        String host;
        int port;
        boolean z;
        this.startTimeMillis = System.currentTimeMillis();
        this.configProvider = configProvider;
        this.instrumenterConfig = instrumenterConfig;
        this.configFileStatus = configProvider.getConfigFileStatus();
        this.runtimeIdEnabled = configProvider.getBoolean(GeneralConfig.RUNTIME_ID_ENABLED, true, new String[0]);
        this.runtimeVersion = System.getProperty("java.version", "unknown");
        this.site = configProvider.getString(GeneralConfig.SITE, "datadoghq.com", new String[0]);
        String string = configProvider.getString("service", null, "service.name");
        if (string == null) {
            this.serviceNameSetByUser = false;
            this.serviceName = configProvider.getString("service", ConfigDefaults.DEFAULT_SERVICE_NAME, "service.name");
        } else {
            this.serviceNameSetByUser = true;
            this.serviceName = string;
        }
        this.rootContextServiceName = configProvider.getString(TraceInstrumentationConfig.SERVLET_ROOT_CONTEXT_SERVICE_NAME, ConfigDefaults.DEFAULT_SERVLET_ROOT_CONTEXT_SERVICE_NAME, new String[0]);
        this.integrationSynapseLegacyOperationName = configProvider.getBoolean(TraceInstrumentationConfig.INTEGRATION_SYNAPSE_LEGACY_OPERATION_NAME, false, new String[0]);
        this.writerType = configProvider.getString(TracerConfig.WRITER_TYPE, ConfigDefaults.DEFAULT_AGENT_WRITER_TYPE, new String[0]);
        this.injectBaggageAsTagsEnabled = configProvider.getBoolean(TracerConfig.WRITER_BAGGAGE_INJECT, true, new String[0]);
        boolean z2 = configProvider.getBoolean(TracerConfig.SECURE_RANDOM, true, new String[0]);
        this.secureRandom = z2;
        this.elasticsearchBodyEnabled = configProvider.getBoolean(TraceInstrumentationConfig.ELASTICSEARCH_BODY_ENABLED, false, new String[0]);
        this.elasticsearchParamsEnabled = configProvider.getBoolean(TraceInstrumentationConfig.ELASTICSEARCH_PARAMS_ENABLED, true, new String[0]);
        this.elasticsearchBodyAndParamsEnabled = configProvider.getBoolean(TraceInstrumentationConfig.ELASTICSEARCH_BODY_AND_PARAMS_ENABLED, false, new String[0]);
        String string2 = configProvider.getString(TracerConfig.ID_GENERATION_STRATEGY);
        boolean z3 = configProvider.getBoolean(TracerConfig.TRACE_128_BIT_TRACEID_GENERATION_ENABLED, true, new String[0]);
        this.trace128bitTraceIdGenerationEnabled = z3;
        string2 = z2 ? "SECURE_RANDOM" : string2;
        string2 = string2 == null ? "RANDOM" : string2;
        IdGenerationStrategy idGenerationStrategyFromName = IdGenerationStrategy.fromName(string2, z3);
        if (idGenerationStrategyFromName == null) {
            log.warn("*** you are trying to use an unknown id generation strategy {} - falling back to RANDOM", string2);
            idGenerationStrategyFromName = IdGenerationStrategy.fromName("RANDOM", z3);
            string2 = "RANDOM";
        }
        if (!string2.equals("RANDOM") && !string2.equals("SECURE_RANDOM")) {
            log.warn("*** you are using an unsupported id generation strategy {} - this can impact correctness of traces", string2);
        }
        this.idGenerationStrategy = idGenerationStrategyFromName;
        String string3 = configProvider.getString(TracerConfig.TRACE_AGENT_URL);
        if (string3 != null) {
            try {
                URI uri = new URI(string3);
                host = uri.getHost();
                try {
                    port = uri.getPort();
                } catch (URISyntaxException e) {
                    e = e;
                    log.warn("{} not configured correctly: {}. Ignoring", TracerConfig.TRACE_AGENT_URL, e.getMessage());
                    port = -1;
                }
            } catch (URISyntaxException e2) {
                e = e2;
                host = null;
            }
        } else {
            port = -1;
            host = null;
        }
        if (host == null) {
            host = configProvider.getString(TracerConfig.AGENT_HOST);
            z = true;
        } else {
            z = false;
        }
        if (port < 0) {
            port = configProvider.getInteger(TracerConfig.TRACE_AGENT_PORT, -1, TracerConfig.AGENT_PORT_LEGACY);
            z = true;
        }
        if (host == null) {
            this.agentHost = "localhost";
        } else {
            this.agentHost = host;
        }
        if (port < 0) {
            this.agentPort = ConfigDefaults.DEFAULT_TRACE_AGENT_PORT;
        } else {
            this.agentPort = port;
        }
        if (z) {
            this.agentUrl = "http://" + this.agentHost + ServerSentEventKt.COLON + this.agentPort;
        } else {
            this.agentUrl = string3;
        }
        String string4 = configProvider.getString(TracerConfig.AGENT_NAMED_PIPE);
        this.agentNamedPipe = string4;
        this.agentConfiguredUsingDefault = host == null && port < 0 && string4 == null;
        this.agentTimeout = configProvider.getInteger(TracerConfig.AGENT_TIMEOUT, 10, new String[0]);
        this.noProxyHosts = CollectionUtils.tryMakeImmutableSet(configProvider.getSpacedList(TracerConfig.PROXY_NO_PROXY));
        this.prioritySamplingEnabled = configProvider.getBoolean(TracerConfig.PRIORITY_SAMPLING, true, new String[0]);
        this.prioritySamplingForce = configProvider.getString(TracerConfig.PRIORITY_SAMPLING_FORCE, ConfigDefaults.DEFAULT_PRIORITY_SAMPLING_FORCE, new String[0]);
        this.traceResolverEnabled = configProvider.getBoolean(TracerConfig.TRACE_RESOLVER_ENABLED, true, new String[0]);
        this.serviceMapping = configProvider.getMergedMap(TracerConfig.SERVICE_MAPPING);
        Map<String, String> map = new HashMap<>(configProvider.getMergedMap(GeneralConfig.GLOBAL_TAGS));
        map.putAll(configProvider.getMergedMap("tags"));
        this.tags = getMapWithPropertiesDefinedByEnvironment(map, "env", "version");
        this.spanTags = configProvider.getMergedMap("trace.span.tags");
        this.primaryTag = configProvider.getString(GeneralConfig.PRIMARY_TAG);
        if (isEnabled(false, TracerConfig.HEADER_TAGS, ".legacy.parsing.enabled")) {
            this.requestHeaderTags = configProvider.getMergedMap(TracerConfig.HEADER_TAGS);
            this.responseHeaderTags = Collections.EMPTY_MAP;
            if (configProvider.isSet(TracerConfig.REQUEST_HEADER_TAGS)) {
                logIgnoredSettingWarning(TracerConfig.REQUEST_HEADER_TAGS, TracerConfig.HEADER_TAGS, ".legacy.parsing.enabled");
            }
            if (configProvider.isSet(TracerConfig.RESPONSE_HEADER_TAGS)) {
                logIgnoredSettingWarning(TracerConfig.RESPONSE_HEADER_TAGS, TracerConfig.HEADER_TAGS, ".legacy.parsing.enabled");
            }
        } else {
            this.requestHeaderTags = configProvider.getMergedMapWithOptionalMappings("http.request.headers.", true, TracerConfig.HEADER_TAGS, TracerConfig.REQUEST_HEADER_TAGS);
            this.responseHeaderTags = configProvider.getMergedMapWithOptionalMappings("http.response.headers.", true, TracerConfig.HEADER_TAGS, TracerConfig.RESPONSE_HEADER_TAGS);
        }
        this.requestHeaderTagsCommaAllowed = configProvider.getBoolean(TracerConfig.REQUEST_HEADER_TAGS_COMMA_ALLOWED, true, new String[0]);
        this.baggageMapping = configProvider.getMergedMap(TracerConfig.BAGGAGE_MAPPING);
        this.spanAttributeSchemaVersion = schemaVersionFromConfig();
        this.peerServiceDefaultsEnabled = configProvider.getBoolean(TracerConfig.TRACE_PEER_SERVICE_DEFAULTS_ENABLED, false, new String[0]);
        this.peerServiceComponentOverrides = configProvider.getMergedMap(TracerConfig.TRACE_PEER_SERVICE_COMPONENT_OVERRIDES);
        this.removeIntegrationServiceNamesEnabled = configProvider.getBoolean(TracerConfig.TRACE_REMOVE_INTEGRATION_SERVICE_NAMES_ENABLED, false, new String[0]);
        this.peerServiceMapping = configProvider.getMergedMap(TracerConfig.TRACE_PEER_SERVICE_MAPPING);
        this.httpServerPathResourceNameMapping = configProvider.getOrderedMap(TracerConfig.TRACE_HTTP_SERVER_PATH_RESOURCE_NAME_MAPPING);
        this.httpClientPathResourceNameMapping = configProvider.getOrderedMap(TracerConfig.TRACE_HTTP_CLIENT_PATH_RESOURCE_NAME_MAPPING);
        this.httpResourceRemoveTrailingSlash = configProvider.getBoolean(TracerConfig.TRACE_HTTP_RESOURCE_REMOVE_TRAILING_SLASH, false, new String[0]);
        this.httpServerErrorStatuses = configProvider.getIntegerRange(TracerConfig.HTTP_SERVER_ERROR_STATUSES, ConfigDefaults.DEFAULT_HTTP_SERVER_ERROR_STATUSES);
        this.httpClientErrorStatuses = configProvider.getIntegerRange(TracerConfig.HTTP_CLIENT_ERROR_STATUSES, ConfigDefaults.DEFAULT_HTTP_CLIENT_ERROR_STATUSES);
        this.httpServerTagQueryString = configProvider.getBoolean(TraceInstrumentationConfig.HTTP_SERVER_TAG_QUERY_STRING, true, new String[0]);
        this.httpServerRawQueryString = configProvider.getBoolean(TraceInstrumentationConfig.HTTP_SERVER_RAW_QUERY_STRING, true, new String[0]);
        this.httpServerRawResource = configProvider.getBoolean(TraceInstrumentationConfig.HTTP_SERVER_RAW_RESOURCE, false, new String[0]);
        this.httpServerDecodedResourcePreserveSpaces = configProvider.getBoolean(TraceInstrumentationConfig.HTTP_SERVER_DECODED_RESOURCE_PRESERVE_SPACES, true, new String[0]);
        this.httpServerRouteBasedNaming = configProvider.getBoolean(TraceInstrumentationConfig.HTTP_SERVER_ROUTE_BASED_NAMING, true, new String[0]);
        this.httpClientTagQueryString = configProvider.getBoolean(TraceInstrumentationConfig.HTTP_CLIENT_TAG_QUERY_STRING, false, new String[0]);
        this.httpClientTagHeaders = configProvider.getBoolean(TraceInstrumentationConfig.HTTP_CLIENT_TAG_HEADERS, true, new String[0]);
        this.httpClientSplitByDomain = configProvider.getBoolean(TraceInstrumentationConfig.HTTP_CLIENT_HOST_SPLIT_BY_DOMAIN, false, new String[0]);
        this.dbClientSplitByInstance = configProvider.getBoolean(TraceInstrumentationConfig.DB_CLIENT_HOST_SPLIT_BY_INSTANCE, false, new String[0]);
        this.dbClientSplitByInstanceTypeSuffix = configProvider.getBoolean(TraceInstrumentationConfig.DB_CLIENT_HOST_SPLIT_BY_INSTANCE_TYPE_SUFFIX, false, new String[0]);
        this.dbClientSplitByHost = configProvider.getBoolean(TraceInstrumentationConfig.DB_CLIENT_HOST_SPLIT_BY_HOST, false, new String[0]);
        this.DBMPropagationMode = configProvider.getString(TraceInstrumentationConfig.DB_DBM_PROPAGATION_MODE_MODE, "disabled", new String[0]);
        this.splitByTags = CollectionUtils.tryMakeImmutableSet(configProvider.getList(TracerConfig.SPLIT_BY_TAGS));
        this.springDataRepositoryInterfaceResourceName = configProvider.getBoolean(TraceInstrumentationConfig.SPRING_DATA_REPOSITORY_INTERFACE_RESOURCE_NAME, true, new String[0]);
        this.scopeDepthLimit = configProvider.getInteger(TracerConfig.SCOPE_DEPTH_LIMIT, 100, new String[0]);
        this.scopeStrictMode = configProvider.getBoolean(TracerConfig.SCOPE_STRICT_MODE, false, new String[0]);
        this.scopeInheritAsyncPropagation = configProvider.getBoolean(TracerConfig.SCOPE_INHERIT_ASYNC_PROPAGATION, true, new String[0]);
        this.scopeIterationKeepAlive = configProvider.getInteger(TracerConfig.SCOPE_ITERATION_KEEP_ALIVE, 30, new String[0]);
        this.partialFlushMinSpans = !configProvider.getBoolean(TracerConfig.PARTIAL_FLUSH_ENABLED, true, new String[0]) ? 0 : configProvider.getInteger("trace.partial.flush.min.spans", 1000, new String[0]);
        this.traceStrictWritesEnabled = configProvider.getBoolean(TracerConfig.TRACE_STRICT_WRITES_ENABLED, false, new String[0]);
        this.logExtractHeaderNames = configProvider.getBoolean(TracerConfig.PROPAGATION_EXTRACT_LOG_HEADER_NAMES_ENABLED, false, new String[0]);
        this.tracePropagationStyleB3PaddingEnabled = isEnabled(true, TracerConfig.TRACE_PROPAGATION_STYLE, ".b3.padding.enabled");
        Set<TracePropagationStyle> settingsSetFromEnvironment = getSettingsSetFromEnvironment(TracerConfig.TRACE_PROPAGATION_STYLE, new Function() { // from class: com.datadog.trace.api.Config$$ExternalSyntheticLambda0
            @Override // com.datadog.android.trace.internal.compat.function.Function
            public final Object apply(Object obj) {
                return TracePropagationStyle.valueOfDisplayName((String) obj);
            }
        }, false);
        Set<TracePropagationStyle> settingsSetFromEnvironment2 = getSettingsSetFromEnvironment("trace.propagation.style.extract", new Function() { // from class: com.datadog.trace.api.Config$$ExternalSyntheticLambda0
            @Override // com.datadog.android.trace.internal.compat.function.Function
            public final Object apply(Object obj) {
                return TracePropagationStyle.valueOfDisplayName((String) obj);
            }
        }, false);
        Set<TracePropagationStyle> settingsSetFromEnvironment3 = getSettingsSetFromEnvironment("trace.propagation.style.inject", new Function() { // from class: com.datadog.trace.api.Config$$ExternalSyntheticLambda0
            @Override // com.datadog.android.trace.internal.compat.function.Function
            public final Object apply(Object obj) {
                return TracePropagationStyle.valueOfDisplayName((String) obj);
            }
        }, false);
        if (settingsSetFromEnvironment2.isEmpty()) {
            settingsSetFromEnvironment2 = settingsSetFromEnvironment;
        } else if (!settingsSetFromEnvironment.isEmpty()) {
            logOverriddenSettingWarning(TracerConfig.TRACE_PROPAGATION_STYLE, "trace.propagation.style.extract", settingsSetFromEnvironment2);
        }
        if (!settingsSetFromEnvironment3.isEmpty()) {
            if (!settingsSetFromEnvironment.isEmpty()) {
                logOverriddenSettingWarning(TracerConfig.TRACE_PROPAGATION_STYLE, "trace.propagation.style.inject", settingsSetFromEnvironment3);
            }
            settingsSetFromEnvironment = settingsSetFromEnvironment3;
        }
        this.tracePropagationStylesToExtract = settingsSetFromEnvironment2.isEmpty() ? ConfigDefaults.DEFAULT_TRACE_PROPAGATION_STYLE : settingsSetFromEnvironment2;
        this.tracePropagationStylesToInject = settingsSetFromEnvironment.isEmpty() ? ConfigDefaults.DEFAULT_TRACE_PROPAGATION_STYLE : settingsSetFromEnvironment;
        this.tracePropagationExtractFirst = configProvider.getBoolean(TracerConfig.TRACE_PROPAGATION_EXTRACT_FIRST, false, new String[0]);
        this.clockSyncPeriod = configProvider.getInteger(TracerConfig.CLOCK_SYNC_PERIOD, 30, new String[0]);
        this.logsInjectionEnabled = configProvider.getBoolean(TraceInstrumentationConfig.LOGS_INJECTION_ENABLED, true, new String[0]);
        this.dogStatsDNamedPipe = configProvider.getString(GeneralConfig.DOGSTATSD_NAMED_PIPE);
        this.dogStatsDStartDelay = configProvider.getInteger(GeneralConfig.DOGSTATSD_START_DELAY, 15, new String[0]);
        this.statsDClientQueueSize = configProvider.getInteger(GeneralConfig.STATSD_CLIENT_QUEUE_SIZE);
        this.statsDClientSocketBuffer = configProvider.getInteger(GeneralConfig.STATSD_CLIENT_SOCKET_BUFFER);
        this.statsDClientSocketTimeout = configProvider.getInteger(GeneralConfig.STATSD_CLIENT_SOCKET_TIMEOUT);
        boolean z4 = configProvider.getBoolean(GeneralConfig.RUNTIME_METRICS_ENABLED, true, new String[0]);
        this.runtimeMetricsEnabled = z4;
        this.healthMetricsEnabled = z4 && configProvider.getBoolean(GeneralConfig.HEALTH_METRICS_ENABLED, true, new String[0]);
        this.healthMetricsStatsdHost = configProvider.getString(GeneralConfig.HEALTH_METRICS_STATSD_HOST);
        this.healthMetricsStatsdPort = configProvider.getInteger(GeneralConfig.HEALTH_METRICS_STATSD_PORT);
        this.perfMetricsEnabled = z4 && configProvider.getBoolean(GeneralConfig.PERF_METRICS_ENABLED, false, new String[0]);
        this.tracerMetricsEnabled = configProvider.getBoolean(GeneralConfig.TRACER_METRICS_ENABLED, false, new String[0]);
        this.tracerMetricsBufferingEnabled = configProvider.getBoolean(GeneralConfig.TRACER_METRICS_BUFFERING_ENABLED, false, new String[0]);
        this.tracerMetricsMaxAggregates = configProvider.getInteger(GeneralConfig.TRACER_METRICS_MAX_AGGREGATES, 2048, new String[0]);
        this.tracerMetricsMaxPending = configProvider.getInteger(GeneralConfig.TRACER_METRICS_MAX_PENDING, 2048, new String[0]);
        this.reportHostName = configProvider.getBoolean(TracerConfig.TRACE_REPORT_HOSTNAME, false, new String[0]);
        this.traceAgentV05Enabled = configProvider.getBoolean(TracerConfig.ENABLE_TRACE_AGENT_V05, false, new String[0]);
        this.traceAnalyticsEnabled = configProvider.getBoolean(TracerConfig.TRACE_ANALYTICS_ENABLED, false, new String[0]);
        String string5 = configProvider.getString(TracerConfig.TRACE_CLIENT_IP_HEADER);
        this.traceClientIpHeader = string5 != null ? string5.toLowerCase(Locale.ROOT) : string5;
        this.traceClientIpResolverEnabled = configProvider.getBoolean(TracerConfig.TRACE_CLIENT_IP_RESOLVER_ENABLED, true, new String[0]);
        this.traceGitMetadataEnabled = configProvider.getBoolean(TracerConfig.TRACE_GIT_METADATA_ENABLED, true, new String[0]);
        this.traceSamplingServiceRules = configProvider.getMergedMap(TracerConfig.TRACE_SAMPLING_SERVICE_RULES);
        this.traceSamplingOperationRules = configProvider.getMergedMap(TracerConfig.TRACE_SAMPLING_OPERATION_RULES);
        this.traceSamplingRules = configProvider.getString(TracerConfig.TRACE_SAMPLING_RULES);
        this.traceSampleRate = configProvider.getDouble("trace.sample.rate");
        this.traceRateLimit = configProvider.getInteger("trace.rate.limit", 100, new String[0]);
        this.spanSamplingRules = configProvider.getString(TracerConfig.SPAN_SAMPLING_RULES);
        this.spanSamplingRulesFile = configProvider.getString(TracerConfig.SPAN_SAMPLING_RULES_FILE);
        this.profilingEnabled = configProvider.getBoolean(ProfilingConfig.PROFILING_ENABLED, instrumenterConfig.isProfilingEnabled(), new String[0]);
        this.profilingAgentless = configProvider.getBoolean(ProfilingConfig.PROFILING_AGENTLESS, false, new String[0]);
        this.isDatadogProfilerEnabled = !isDatadogProfilerEnablementOverridden() && configProvider.getBoolean(ProfilingConfig.PROFILING_DATADOG_PROFILER_ENABLED, isDatadogProfilerSafeInCurrentEnvironment(), new String[0]);
        this.profilingUrl = configProvider.getString(ProfilingConfig.PROFILING_URL);
        this.profilingTags = configProvider.getMergedMap(ProfilingConfig.PROFILING_TAGS);
        this.profilingStartDelay = configProvider.getInteger(ProfilingConfig.PROFILING_START_DELAY, 10, new String[0]);
        this.profilingStartForceFirst = configProvider.getBoolean(ProfilingConfig.PROFILING_START_FORCE_FIRST, false, new String[0]);
        this.profilingUploadPeriod = configProvider.getInteger(ProfilingConfig.PROFILING_UPLOAD_PERIOD, 60, new String[0]);
        this.profilingTemplateOverrideFile = configProvider.getString(ProfilingConfig.PROFILING_TEMPLATE_OVERRIDE_FILE);
        this.profilingUploadTimeout = configProvider.getInteger(ProfilingConfig.PROFILING_UPLOAD_TIMEOUT, 30, new String[0]);
        this.profilingUploadCompression = configProvider.getString(ProfilingConfig.PROFILING_UPLOAD_COMPRESSION, "on", new String[0]);
        this.profilingProxyHost = configProvider.getString(ProfilingConfig.PROFILING_PROXY_HOST);
        this.profilingProxyPort = configProvider.getInteger(ProfilingConfig.PROFILING_PROXY_PORT, ProfilingConfig.PROFILING_PROXY_PORT_DEFAULT, new String[0]);
        this.profilingProxyUsername = configProvider.getString(ProfilingConfig.PROFILING_PROXY_USERNAME);
        this.profilingProxyPassword = configProvider.getString(ProfilingConfig.PROFILING_PROXY_PASSWORD);
        this.profilingExceptionSampleLimit = configProvider.getInteger(ProfilingConfig.PROFILING_EXCEPTION_SAMPLE_LIMIT, 10000, new String[0]);
        this.profilingDirectAllocationSampleLimit = configProvider.getInteger(ProfilingConfig.PROFILING_DIRECT_ALLOCATION_SAMPLE_LIMIT, 2000, new String[0]);
        this.profilingExceptionHistogramTopItems = configProvider.getInteger(ProfilingConfig.PROFILING_EXCEPTION_HISTOGRAM_TOP_ITEMS, 50, new String[0]);
        this.profilingExceptionHistogramMaxCollectionSize = configProvider.getInteger(ProfilingConfig.PROFILING_EXCEPTION_HISTOGRAM_MAX_COLLECTION_SIZE, 10000, new String[0]);
        this.profilingExcludeAgentThreads = configProvider.getBoolean(ProfilingConfig.PROFILING_EXCLUDE_AGENT_THREADS, true, new String[0]);
        this.profilingRecordExceptionMessage = configProvider.getBoolean(ProfilingConfig.PROFILING_EXCEPTION_RECORD_MESSAGE, true, new String[0]);
        this.profilingUploadSummaryOn413Enabled = configProvider.getBoolean(ProfilingConfig.PROFILING_UPLOAD_SUMMARY_ON_413, false, new String[0]);
        this.crashTrackingAgentless = configProvider.getBoolean(CrashTrackingConfig.CRASH_TRACKING_AGENTLESS, false, new String[0]);
        this.crashTrackingTags = configProvider.getMergedMap(CrashTrackingConfig.CRASH_TRACKING_TAGS);
        float f = configProvider.getFloat(GeneralConfig.TELEMETRY_HEARTBEAT_INTERVAL, 60.0f);
        if (f < 0.1d || f > 3600.0f) {
            log.warn("Invalid Telemetry heartbeat interval: {}. The value must be in range 0.1-3600", Float.valueOf(f));
            f = 60.0f;
        }
        this.telemetryHeartbeatInterval = f;
        this.telemetryExtendedHeartbeatInterval = configProvider.getLong(GeneralConfig.TELEMETRY_EXTENDED_HEARTBEAT_INTERVAL, 86400L, new String[0]);
        float f2 = configProvider.getFloat(GeneralConfig.TELEMETRY_METRICS_INTERVAL, 10.0f);
        if (f2 < 0.1d || f2 > 3600.0f) {
            log.warn("Invalid Telemetry metrics interval: {}. The value must be in range 0.1-3600", Float.valueOf(f2));
            f2 = 10.0f;
        }
        this.telemetryMetricsInterval = f2;
        this.telemetryMetricsEnabled = configProvider.getBoolean(GeneralConfig.TELEMETRY_METRICS_ENABLED, true, new String[0]);
        this.isTelemetryDependencyServiceEnabled = configProvider.getBoolean(GeneralConfig.TELEMETRY_DEPENDENCY_COLLECTION_ENABLED, true, new String[0]);
        this.isTelemetryLogCollectionEnabled = configProvider.getBoolean(GeneralConfig.TELEMETRY_LOG_COLLECTION_ENABLED, false, new String[0]);
        this.clientIpEnabled = configProvider.getBoolean(TracerConfig.CLIENT_IP_ENABLED, false, new String[0]);
        this.remoteConfigEnabled = configProvider.getBoolean(RemoteConfigConfig.REMOTE_CONFIG_ENABLED, true, new String[0]);
        this.remoteConfigIntegrityCheckEnabled = configProvider.getBoolean(RemoteConfigConfig.REMOTE_CONFIG_INTEGRITY_CHECK_ENABLED, false, new String[0]);
        this.remoteConfigUrl = configProvider.getString(RemoteConfigConfig.REMOTE_CONFIG_URL);
        this.remoteConfigPollIntervalSeconds = configProvider.getFloat(RemoteConfigConfig.REMOTE_CONFIG_POLL_INTERVAL_SECONDS, 5.0f);
        this.remoteConfigMaxPayloadSize = configProvider.getInteger(RemoteConfigConfig.REMOTE_CONFIG_MAX_PAYLOAD_SIZE, 5120, new String[0]) * 1024;
        this.remoteConfigTargetsKeyId = configProvider.getString(RemoteConfigConfig.REMOTE_CONFIG_TARGETS_KEY_ID, "5c4ece41241a1bb513f6e3e5df74ab7d5183dfffbd71bfd43127920d880569fd", new String[0]);
        this.remoteConfigTargetsKey = configProvider.getString(RemoteConfigConfig.REMOTE_CONFIG_TARGETS_KEY, "e3f1f98c9da02a93bb547f448b472d727e14b22455235796fe49863856252508", new String[0]);
        this.awsPropagationEnabled = isPropagationEnabled(true, "aws", "aws-sdk");
        this.sqsPropagationEnabled = isPropagationEnabled(true, "sqs");
        this.kafkaClientPropagationEnabled = isPropagationEnabled(true, "kafka", "kafka.client");
        this.kafkaClientPropagationDisabledTopics = CollectionUtils.tryMakeImmutableSet(configProvider.getList(TraceInstrumentationConfig.KAFKA_CLIENT_PROPAGATION_DISABLED_TOPICS));
        this.kafkaClientBase64DecodingEnabled = configProvider.getBoolean(TraceInstrumentationConfig.KAFKA_CLIENT_BASE64_DECODING_ENABLED, false, new String[0]);
        this.jmsPropagationEnabled = isPropagationEnabled(true, "jms");
        this.jmsPropagationDisabledTopics = CollectionUtils.tryMakeImmutableSet(configProvider.getList(TraceInstrumentationConfig.JMS_PROPAGATION_DISABLED_TOPICS));
        this.jmsPropagationDisabledQueues = CollectionUtils.tryMakeImmutableSet(configProvider.getList(TraceInstrumentationConfig.JMS_PROPAGATION_DISABLED_QUEUES));
        this.jmsUnacknowledgedMaxAge = configProvider.getInteger(TraceInstrumentationConfig.JMS_UNACKNOWLEDGED_MAX_AGE, 3600, new String[0]);
        this.rabbitPropagationEnabled = isPropagationEnabled(true, "rabbit", "rabbitmq");
        this.rabbitPropagationDisabledQueues = CollectionUtils.tryMakeImmutableSet(configProvider.getList(TraceInstrumentationConfig.RABBIT_PROPAGATION_DISABLED_QUEUES));
        this.rabbitPropagationDisabledExchanges = CollectionUtils.tryMakeImmutableSet(configProvider.getList(TraceInstrumentationConfig.RABBIT_PROPAGATION_DISABLED_EXCHANGES));
        this.rabbitIncludeRoutingKeyInResource = configProvider.getBoolean(TraceInstrumentationConfig.RABBIT_INCLUDE_ROUTINGKEY_IN_RESOURCE, true, new String[0]);
        this.messageBrokerSplitByDestination = configProvider.getBoolean(TraceInstrumentationConfig.MESSAGE_BROKER_SPLIT_BY_DESTINATION, false, new String[0]);
        this.grpcIgnoredInboundMethods = CollectionUtils.tryMakeImmutableSet(configProvider.getList(TraceInstrumentationConfig.GRPC_IGNORED_INBOUND_METHODS));
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(configProvider.getList(TraceInstrumentationConfig.GRPC_IGNORED_OUTBOUND_METHODS));
        if (InstrumenterConfig.get().isIntegrationEnabled(Collections.singleton("google-pubsub"), true)) {
            arrayList.addAll(configProvider.getList(TraceInstrumentationConfig.GOOGLE_PUBSUB_IGNORED_GRPC_METHODS, Arrays.asList("google.pubsub.v1.Subscriber/ModifyAckDeadline", "google.pubsub.v1.Subscriber/Acknowledge", "google.pubsub.v1.Subscriber/Pull", "google.pubsub.v1.Subscriber/StreamingPull", "google.pubsub.v1.Publisher/Publish")));
        }
        this.grpcIgnoredOutboundMethods = CollectionUtils.tryMakeImmutableSet(arrayList);
        this.grpcServerTrimPackageResource = configProvider.getBoolean(TraceInstrumentationConfig.GRPC_SERVER_TRIM_PACKAGE_RESOURCE, false, new String[0]);
        this.grpcServerErrorStatuses = configProvider.getIntegerRange(TraceInstrumentationConfig.GRPC_SERVER_ERROR_STATUSES, ConfigDefaults.DEFAULT_GRPC_SERVER_ERROR_STATUSES);
        this.grpcClientErrorStatuses = configProvider.getIntegerRange(TraceInstrumentationConfig.GRPC_CLIENT_ERROR_STATUSES, ConfigDefaults.DEFAULT_GRPC_CLIENT_ERROR_STATUSES);
        this.hystrixTagsEnabled = configProvider.getBoolean(TraceInstrumentationConfig.HYSTRIX_TAGS_ENABLED, false, new String[0]);
        this.hystrixMeasuredEnabled = configProvider.getBoolean(TraceInstrumentationConfig.HYSTRIX_MEASURED_ENABLED, false, new String[0]);
        this.igniteCacheIncludeKeys = configProvider.getBoolean(TraceInstrumentationConfig.IGNITE_CACHE_INCLUDE_KEYS, false, new String[0]);
        this.obfuscationQueryRegexp = configProvider.getString(TraceInstrumentationConfig.OBFUSCATION_QUERY_STRING_REGEXP, null, "obfuscation.query.string.regexp");
        this.playReportHttpStatus = configProvider.getBoolean(TraceInstrumentationConfig.PLAY_REPORT_HTTP_STATUS, false, new String[0]);
        this.servletPrincipalEnabled = configProvider.getBoolean(TraceInstrumentationConfig.SERVLET_PRINCIPAL_ENABLED, false, new String[0]);
        this.xDatadogTagsMaxLength = configProvider.getInteger(TracerConfig.TRACE_X_DATADOG_TAGS_MAX_LENGTH, 512, new String[0]);
        this.servletAsyncTimeoutError = configProvider.getBoolean(TraceInstrumentationConfig.SERVLET_ASYNC_TIMEOUT_ERROR, true, new String[0]);
        boolean z5 = configProvider.getBoolean(GeneralConfig.TRACE_DEBUG, false, new String[0]);
        this.debugEnabled = z5;
        this.triageEnabled = configProvider.getBoolean(GeneralConfig.TRACE_TRIAGE, z5, new String[0]);
        this.startupLogsEnabled = configProvider.getBoolean(GeneralConfig.STARTUP_LOGS_ENABLED, true, new String[0]);
        this.dataStreamsEnabled = configProvider.getBoolean(GeneralConfig.DATA_STREAMS_ENABLED, false, new String[0]);
        this.dataStreamsBucketDurationSeconds = configProvider.getFloat(GeneralConfig.DATA_STREAMS_BUCKET_DURATION_SECONDS, 10.0f);
        this.azureAppServices = configProvider.getBoolean(GeneralConfig.AZURE_APP_SERVICES, false, new String[0]);
        this.traceAgentPath = configProvider.getString(TracerConfig.TRACE_AGENT_PATH);
        String string6 = configProvider.getString(TracerConfig.TRACE_AGENT_ARGS);
        if (string6 == null) {
            this.traceAgentArgs = Collections.EMPTY_LIST;
        } else {
            this.traceAgentArgs = Collections.unmodifiableList(new ArrayList(parseStringIntoSetOfNonEmptyStrings(string6)));
        }
        this.dogStatsDPath = configProvider.getString(GeneralConfig.DOGSTATSD_PATH);
        String string7 = configProvider.getString(GeneralConfig.DOGSTATSD_ARGS);
        if (string7 == null) {
            this.dogStatsDArgs = Collections.EMPTY_LIST;
        } else {
            this.dogStatsDArgs = Collections.unmodifiableList(new ArrayList(parseStringIntoSetOfNonEmptyStrings(string7)));
        }
        boolean z6 = configProvider.getBoolean(TracerConfig.TRACE_LONG_RUNNING_ENABLED, false, new String[0]);
        long j = 300;
        long j2 = configProvider.getLong(TracerConfig.TRACE_LONG_RUNNING_FLUSH_INTERVAL, 300L, new String[0]);
        if (!z6 || (j2 >= 20 && j2 <= 450)) {
            j = j2;
        } else {
            log.warn("Provided long running trace flush interval of {} seconds. It should be between 20 seconds and 7.5 minutes.Setting the flush interval to the default value of {} seconds .", Long.valueOf(j2), 300L);
        }
        this.longRunningTraceEnabled = z6;
        this.longRunningTraceFlushInterval = j;
        this.sparkTaskHistogramEnabled = configProvider.getBoolean(TraceInstrumentationConfig.SPARK_TASK_HISTOGRAM_ENABLED, true, new String[0]);
        this.jaxRsExceptionAsErrorsEnabled = configProvider.getBoolean(TraceInstrumentationConfig.JAX_RS_EXCEPTION_AS_ERROR_ENABLED, true, new String[0]);
        this.traceFlushIntervalSeconds = configProvider.getFloat(TracerConfig.TRACE_FLUSH_INTERVAL, 1.0f);
        this.telemetryDebugRequestsEnabled = configProvider.getBoolean(GeneralConfig.TELEMETRY_DEBUG_REQUESTS_ENABLED, false, new String[0]);
        this.timelineEventsEnabled = configProvider.getBoolean(ProfilingConfig.PROFILING_TIMELINE_EVENTS_ENABLED, false, new String[0]);
        log.debug("New instance: {}", this);
    }

    public String getRuntimeId() {
        return this.runtimeIdEnabled ? RuntimeIdHolder.runtimeId : "";
    }

    public Long getProcessId() {
        return Long.valueOf(PidHelper.getPidAsLong());
    }

    public String getSite() {
        return this.site;
    }

    public String getHostName() {
        return HostNameHolder.hostName;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public boolean isServiceNameSetByUser() {
        return this.serviceNameSetByUser;
    }

    public String getRootContextServiceName() {
        return this.rootContextServiceName;
    }

    public boolean isLongRunningTraceEnabled() {
        return this.longRunningTraceEnabled;
    }

    public long getLongRunningTraceFlushInterval() {
        return this.longRunningTraceFlushInterval;
    }

    public boolean isInjectBaggageAsTagsEnabled() {
        return this.injectBaggageAsTagsEnabled;
    }

    public boolean isPrioritySamplingEnabled() {
        return this.prioritySamplingEnabled;
    }

    public String getPrioritySamplingForce() {
        return this.prioritySamplingForce;
    }

    public int getSpanAttributeSchemaVersion() {
        return this.spanAttributeSchemaVersion;
    }

    public boolean isPeerServiceDefaultsEnabled() {
        return this.peerServiceDefaultsEnabled;
    }

    public Map<String, String> getPeerServiceComponentOverrides() {
        return this.peerServiceComponentOverrides;
    }

    public boolean isRemoveIntegrationServiceNamesEnabled() {
        return this.removeIntegrationServiceNamesEnabled;
    }

    public Map<String, String> getPeerServiceMapping() {
        return this.peerServiceMapping;
    }

    public Map<String, String> getServiceMapping() {
        return this.serviceMapping;
    }

    public Map<String, String> getRequestHeaderTags() {
        return this.requestHeaderTags;
    }

    public Map<String, String> getResponseHeaderTags() {
        return this.responseHeaderTags;
    }

    public boolean isRequestHeaderTagsCommaAllowed() {
        return this.requestHeaderTagsCommaAllowed;
    }

    public Map<String, String> getBaggageMapping() {
        return this.baggageMapping;
    }

    public Map<String, String> getHttpServerPathResourceNameMapping() {
        return this.httpServerPathResourceNameMapping;
    }

    public Map<String, String> getHttpClientPathResourceNameMapping() {
        return this.httpClientPathResourceNameMapping;
    }

    public boolean getHttpResourceRemoveTrailingSlash() {
        return this.httpResourceRemoveTrailingSlash;
    }

    public boolean isHttpServerDecodedResourcePreserveSpaces() {
        return this.httpServerDecodedResourcePreserveSpaces;
    }

    public Set<String> getSplitByTags() {
        return this.splitByTags;
    }

    public int getScopeDepthLimit() {
        return this.scopeDepthLimit;
    }

    public boolean isScopeStrictMode() {
        return this.scopeStrictMode;
    }

    public boolean isScopeInheritAsyncPropagation() {
        return this.scopeInheritAsyncPropagation;
    }

    public int getScopeIterationKeepAlive() {
        return this.scopeIterationKeepAlive;
    }

    public int getPartialFlushMinSpans() {
        return this.partialFlushMinSpans;
    }

    public boolean isTraceStrictWritesEnabled() {
        return this.traceStrictWritesEnabled;
    }

    public boolean isLogExtractHeaderNames() {
        return this.logExtractHeaderNames;
    }

    public boolean isTracePropagationStyleB3PaddingEnabled() {
        return this.tracePropagationStyleB3PaddingEnabled;
    }

    public Set<TracePropagationStyle> getTracePropagationStylesToExtract() {
        return this.tracePropagationStylesToExtract;
    }

    public Set<TracePropagationStyle> getTracePropagationStylesToInject() {
        return this.tracePropagationStylesToInject;
    }

    public boolean isTracePropagationExtractFirst() {
        return this.tracePropagationExtractFirst;
    }

    public int getClockSyncPeriod() {
        return this.clockSyncPeriod;
    }

    public boolean isRuntimeMetricsEnabled() {
        return this.runtimeMetricsEnabled;
    }

    public boolean isHealthMetricsEnabled() {
        return this.healthMetricsEnabled;
    }

    public boolean isLogsInjectionEnabled() {
        return this.logsInjectionEnabled;
    }

    public String getTraceClientIpHeader() {
        return this.traceClientIpHeader;
    }

    public boolean isTraceClientIpResolverEnabled() {
        return this.traceClientIpResolverEnabled;
    }

    public Map<String, String> getTraceSamplingServiceRules() {
        return this.traceSamplingServiceRules;
    }

    public Map<String, String> getTraceSamplingOperationRules() {
        return this.traceSamplingOperationRules;
    }

    public String getTraceSamplingRules() {
        return this.traceSamplingRules;
    }

    public Double getTraceSampleRate() {
        return this.traceSampleRate;
    }

    public int getTraceRateLimit() {
        return this.traceRateLimit;
    }

    public String getSpanSamplingRules() {
        return this.spanSamplingRules;
    }

    public String getSpanSamplingRulesFile() {
        return this.spanSamplingRulesFile;
    }

    public boolean isProfilingEnabled() {
        return this.profilingEnabled && this.instrumenterConfig.isProfilingEnabled();
    }

    public static boolean isDatadogProfilerEnablementOverridden() {
        return Platform.isJavaVersion(18) || Platform.isJavaVersion(16) || Platform.isJavaVersion(15) || Platform.isJavaVersion(14) || Platform.isJavaVersion(13) || Platform.isJavaVersion(12) || Platform.isJavaVersion(10) || Platform.isJavaVersion(9);
    }

    public static boolean isDatadogProfilerSafeInCurrentEnvironment() {
        boolean z = false;
        if (!Platform.isJ9() && Platform.isJavaVersion(8)) {
            String property = System.getProperty("os.arch");
            if ("aarch64".equalsIgnoreCase(property) || "arm64".equalsIgnoreCase(property)) {
                return false;
            }
        }
        if (Platform.isGraalVM()) {
            return false;
        }
        boolean z2 = Platform.isJ9() || !Platform.isJavaVersion(18) || Platform.isJavaVersionAtLeast(17, 0, 5) || (Platform.isJavaVersion(11) && Platform.isJavaVersionAtLeast(11, 0, 17)) || (Platform.isJavaVersion(8) && Platform.isJavaVersionAtLeast(8, 0, 352));
        if (!z2 || !Platform.isJ9()) {
            return z2;
        }
        if ((!Platform.isJavaVersion(11) || !Platform.isJavaVersionAtLeast(11, 0, 18)) && (!Platform.isJavaVersion(17) || !Platform.isJavaVersionAtLeast(17, 0, 6))) {
            z = true;
        }
        return z2 & z;
    }

    public boolean isClientIpEnabled() {
        return this.clientIpEnabled;
    }

    public boolean isAwsPropagationEnabled() {
        return this.awsPropagationEnabled;
    }

    public String getObfuscationQueryRegexp() {
        return this.obfuscationQueryRegexp;
    }

    public int getxDatadogTagsMaxLength() {
        return this.xDatadogTagsMaxLength;
    }

    public boolean isDebugEnabled() {
        return this.debugEnabled;
    }

    public boolean isDataStreamsEnabled() {
        return this.dataStreamsEnabled;
    }

    public IdGenerationStrategy getIdGenerationStrategy() {
        return this.idGenerationStrategy;
    }

    public Map<String, Object> getLocalRootSpanTags() {
        String hostName;
        Map<String, String> runtimeTags = getRuntimeTags();
        HashMap map = new HashMap(runtimeTags.size() + 2);
        map.putAll(runtimeTags);
        map.put(DDTags.LANGUAGE_TAG_KEY, DDTags.LANGUAGE_TAG_VALUE);
        map.put(DDTags.SCHEMA_VERSION_TAG_KEY, Integer.valueOf(SpanNaming.instance().version()));
        map.put(DDTags.PROFILING_ENABLED, Integer.valueOf(isProfilingEnabled() ? 1 : 0));
        if (this.reportHostName && (hostName = getHostName()) != null && !hostName.isEmpty()) {
            map.put("_dd.hostname", hostName);
        }
        if (this.azureAppServices) {
            map.putAll(getAzureAppServicesTags());
        }
        map.putAll(getProcessIdTag());
        return Collections.unmodifiableMap(map);
    }

    public String getPrimaryTag() {
        return this.primaryTag;
    }

    public String getEnv() {
        if (this.env == null) {
            String str = getMergedSpanTags().get("env");
            this.env = str;
            if (str == null) {
                this.env = "";
            }
        }
        return this.env;
    }

    public String getVersion() {
        if (this.version == null) {
            String str = getMergedSpanTags().get("version");
            this.version = str;
            if (str == null) {
                this.version = "";
            }
        }
        return this.version;
    }

    public Map<String, String> getMergedSpanTags() {
        Map<String, String> mapNewHashMap = newHashMap(getGlobalTags().size() + this.spanTags.size());
        mapNewHashMap.putAll(getGlobalTags());
        mapNewHashMap.putAll(this.spanTags);
        return Collections.unmodifiableMap(mapNewHashMap);
    }

    public Map<String, String> getGlobalTags() {
        return this.tags;
    }

    private Map<String, String> getRuntimeTags() {
        return Collections.singletonMap(DDTags.RUNTIME_ID_TAG, getRuntimeId());
    }

    private Map<String, Long> getProcessIdTag() {
        return Collections.singletonMap(DDTags.PID_TAG, getProcessId());
    }

    private Map<String, String> getAzureAppServicesTags() {
        String strSubstring;
        HashMap map = new HashMap();
        String env = getEnv("WEBSITE_SITE_NAME");
        if (env != null) {
            map.put("aas.site.name", env);
        }
        if (getEnv("FUNCTIONS_WORKER_RUNTIME") != null || getEnv("FUNCTIONS_EXTENSIONS_VERSION") != null) {
            map.put("aas.site.kind", "functionapp");
            map.put("aas.site.type", "function");
        } else {
            map.put("aas.site.kind", SessionEndedMetric.PROCESS_TYPE_VALUE);
            map.put("aas.site.type", SessionEndedMetric.PROCESS_TYPE_VALUE);
        }
        String env2 = getEnv("WEBSITE_RESOURCE_GROUP");
        if (env2 != null) {
            map.put("aas.resource.group", env2);
        }
        String env3 = getEnv("WEBSITE_OWNER_NAME");
        int iIndexOf = env3 == null ? -1 : env3.indexOf(Marker.ANY_NON_NULL_MARKER);
        if (iIndexOf > 0) {
            strSubstring = env3.substring(0, iIndexOf);
            map.put("aas.subscription.id", strSubstring);
        } else {
            strSubstring = null;
        }
        if (strSubstring != null && env != null && env2 != null) {
            map.put("aas.resource.id", ("/subscriptions/" + strSubstring + "/resourcegroups/" + env2 + "/providers/microsoft.web/sites/" + env).toLowerCase(Locale.ROOT));
        } else {
            log.warn("Unable to generate resource id subscription id: {}, site name: {}, resource group {}", strSubstring, env, env2);
        }
        String env4 = getEnv("WEBSITE_INSTANCE_ID");
        if (env4 == null) {
            env4 = "unknown";
        }
        map.put("aas.environment.instance_id", env4);
        String env5 = getEnv("COMPUTERNAME");
        if (env5 == null) {
            env5 = "unknown";
        }
        map.put("aas.environment.instance_name", env5);
        String env6 = getEnv("WEBSITE_OS");
        if (env6 == null) {
            env6 = "unknown";
        }
        map.put("aas.environment.os", env6);
        String env7 = getEnv("DD_AAS_JAVA_EXTENSION_VERSION");
        if (env7 == null) {
            env7 = "unknown";
        }
        map.put("aas.environment.extension_version", env7);
        map.put("aas.environment.runtime", getProp("java.vm.name", "unknown"));
        return map;
    }

    private int schemaVersionFromConfig() {
        String string = this.configProvider.getString(TracerConfig.TRACE_SPAN_ATTRIBUTE_SCHEMA, "v0", new String[0]);
        Matcher matcher = Pattern.compile("^v?(0|[1-9]\\d*)$").matcher(string);
        int i = matcher.matches() ? Integer.parseInt(matcher.group(1)) : -1;
        if (i >= 0 && i <= 1) {
            return i;
        }
        log.warn("Invalid attribute schema version {} invalid or out of range [v{}, v{}]. Defaulting to v{}", string, 0, 1, 0);
        return 0;
    }

    public boolean isJmxFetchIntegrationEnabled(Iterable<String> iterable, boolean z) {
        return this.configProvider.isEnabled(iterable, "jmxfetch.", ".enabled", z);
    }

    public boolean isRuleEnabled(String str, boolean z) {
        boolean z2 = this.configProvider.getBoolean("trace." + str + ".enabled", z, new String[0]);
        boolean z3 = this.configProvider.getBoolean("trace." + str.toLowerCase(Locale.ROOT) + ".enabled", z, new String[0]);
        if (z) {
            return z2 && z3;
        }
        return z2 || z3;
    }

    @Deprecated
    public static boolean jmxFetchIntegrationEnabled(SortedSet<String> sortedSet, boolean z) {
        return get().isJmxFetchIntegrationEnabled(sortedSet, z);
    }

    public boolean isEndToEndDurationEnabled(boolean z, String... strArr) {
        return this.configProvider.isEnabled(Arrays.asList(strArr), "", ".e2e.duration.enabled", z);
    }

    public boolean isPropagationEnabled(boolean z, String... strArr) {
        return this.configProvider.isEnabled(Arrays.asList(strArr), "", ".propagation.enabled", z);
    }

    public boolean isEnabled(boolean z, String str, String str2) {
        return this.configProvider.isEnabled(Collections.singletonList(str), "", str2, z);
    }

    private void logIgnoredSettingWarning(String str, String str2, String str3) {
        log.warn("Setting {} ignored since {}{} is enabled.", propertyNameToSystemPropertyName(str), propertyNameToSystemPropertyName(str2), str3);
    }

    private void logOverriddenSettingWarning(String str, String str2, Object obj) {
        log.warn("Setting {} is overridden by setting {} with value {}.", propertyNameToSystemPropertyName(str), propertyNameToSystemPropertyName(str2), obj);
    }

    private void logOverriddenDeprecatedSettingWarning(String str, String str2, Object obj) {
        log.warn("Setting {} is deprecated and overridden by setting {} with value {}.", propertyNameToSystemPropertyName(str), propertyNameToSystemPropertyName(str2), obj);
    }

    private void logDeprecatedConvertedSetting(String str, Object obj, String str2, Object obj2) {
        log.warn("Setting {} is deprecated and the value {} has been converted to {} for setting {}.", propertyNameToSystemPropertyName(str), obj, obj2, propertyNameToSystemPropertyName(str2));
    }

    public boolean isTraceAnalyticsIntegrationEnabled(SortedSet<String> sortedSet, boolean z) {
        return this.configProvider.isEnabled(sortedSet, "", ".analytics.enabled", z);
    }

    public boolean isSamplingMechanismValidationDisabled() {
        return this.configProvider.getBoolean(TracerConfig.SAMPLING_MECHANISM_VALIDATION_DISABLED, false, new String[0]);
    }

    public boolean isV2CompatibilityEnabled() {
        return this.configProvider.getBoolean("v2.compatibility.enabled", false, new String[0]);
    }

    @Deprecated
    public static boolean traceAnalyticsIntegrationEnabled(SortedSet<String> sortedSet, boolean z) {
        return get().isTraceAnalyticsIntegrationEnabled(sortedSet, z);
    }

    private <T> Set<T> getSettingsSetFromEnvironment(String str, Function<String, T> function, boolean z) {
        return convertStringSetToSet(str, parseStringIntoSetOfNonEmptyStrings(this.configProvider.getString(str, "", new String[0]), z), function);
    }

    private <F, T> Set<T> convertSettingsSet(Set<F> set, Function<F, Iterable<T>> function) {
        if (set.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(set.size());
        Iterator<F> it = set.iterator();
        while (it.hasNext()) {
            Iterator<T> it2 = function.apply(it.next()).iterator();
            while (it2.hasNext()) {
                linkedHashSet.add(it2.next());
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private static String propertyNameToSystemPropertyName(String str) {
        return PREFIX + str;
    }

    private static Map<String, String> newHashMap(int i) {
        return new HashMap(i + 1, 1.0f);
    }

    private Map<String, String> getMapWithPropertiesDefinedByEnvironment(Map<String, String> map, String... strArr) {
        HashMap map2 = new HashMap(map);
        for (String str : strArr) {
            String string = this.configProvider.getString(str);
            if (string != null) {
                map2.put(str, string);
            }
        }
        return Collections.unmodifiableMap(map2);
    }

    private static Set<String> parseStringIntoSetOfNonEmptyStrings(String str) {
        return parseStringIntoSetOfNonEmptyStrings(str, true);
    }

    private static Set<String> parseStringIntoSetOfNonEmptyStrings(String str, boolean z) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ',' || (z && Character.isWhitespace(cCharAt))) {
                if ((i - i2) - 1 > 0) {
                    linkedHashSet.add(str.substring(i2, i));
                }
                i2 = i + 1;
            }
            i++;
        }
        if ((i - i2) - 1 > 0) {
            linkedHashSet.add(str.substring(i2));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private static <T> Set<T> convertStringSetToSet(String str, Set<String> set, Function<String, T> function) {
        if (set.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : set) {
            try {
                linkedHashSet.add(function.apply(str2));
            } catch (IllegalArgumentException unused) {
                log.warn("Cannot recognize config string value {} for setting {}", str2, propertyNameToSystemPropertyName(str));
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    static String initHostName() {
        String env = getEnv("HOSTNAME");
        if (env != null && !env.isEmpty()) {
            log.debug("Determined hostname from environment variable");
            return env.trim();
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("hostname").getInputStream()));
            try {
                env = bufferedReader.readLine();
                bufferedReader.close();
                if (env != null && !env.isEmpty()) {
                    log.debug("Determined hostname from hostname command");
                    return env.trim();
                }
                try {
                    return InetAddress.getLocalHost().getHostName();
                } catch (UnknownHostException unused) {
                    return null;
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable unused2) {
        }
    }

    private static String getEnv(String str) {
        String str2 = System.getenv(str);
        if (str2 != null) {
            ConfigCollector.get().put(str, str2, ConfigOrigin.ENV);
        }
        return str2;
    }

    private static String getProp(String str) {
        return getProp(str, null);
    }

    private static String getProp(String str, String str2) {
        String property = System.getProperty(str, str2);
        if (property != null) {
            ConfigCollector.get().put(str, property, ConfigOrigin.JVM_PROP);
        }
        return property;
    }

    public static Config get() {
        return INSTANCE;
    }

    @Deprecated
    public static Config get(Properties properties) {
        if (properties == null || properties.isEmpty()) {
            return INSTANCE;
        }
        return new Config(ConfigProvider.withPropertiesOverride(properties));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Config{instrumenterConfig=");
        sb.append(this.instrumenterConfig);
        sb.append(", runtimeId='");
        sb.append(getRuntimeId());
        sb.append("', runtimeVersion='");
        sb.append(this.runtimeVersion);
        sb.append(", site='");
        sb.append(this.site);
        sb.append("', hostName='");
        sb.append(getHostName());
        sb.append("', serviceName='");
        sb.append(this.serviceName);
        sb.append("', serviceNameSetByUser=");
        sb.append(this.serviceNameSetByUser);
        sb.append(", rootContextServiceName=");
        sb.append(this.rootContextServiceName);
        sb.append(", integrationSynapseLegacyOperationName=");
        sb.append(this.integrationSynapseLegacyOperationName);
        sb.append(", writerType='");
        sb.append(this.writerType);
        sb.append("', agentConfiguredUsingDefault=");
        sb.append(this.agentConfiguredUsingDefault);
        sb.append(", agentUrl='");
        sb.append(this.agentUrl);
        sb.append("', agentHost='");
        sb.append(this.agentHost);
        sb.append("', agentPort=");
        sb.append(this.agentPort);
        sb.append("', agentTimeout=");
        sb.append(this.agentTimeout);
        sb.append(", noProxyHosts=");
        sb.append(this.noProxyHosts);
        sb.append(", prioritySamplingEnabled=");
        sb.append(this.prioritySamplingEnabled);
        sb.append(", prioritySamplingForce='");
        sb.append(this.prioritySamplingForce);
        sb.append("', traceResolverEnabled=");
        sb.append(this.traceResolverEnabled);
        sb.append(", serviceMapping=");
        sb.append(this.serviceMapping);
        sb.append(", tags=");
        sb.append(this.tags);
        sb.append(", spanTags=");
        sb.append(this.spanTags);
        sb.append(", requestHeaderTags=");
        sb.append(this.requestHeaderTags);
        sb.append(", responseHeaderTags=");
        sb.append(this.responseHeaderTags);
        sb.append(", baggageMapping=");
        sb.append(this.baggageMapping);
        sb.append(", httpServerErrorStatuses=");
        sb.append(this.httpServerErrorStatuses);
        sb.append(", httpClientErrorStatuses=");
        sb.append(this.httpClientErrorStatuses);
        sb.append(", httpServerTagQueryString=");
        sb.append(this.httpServerTagQueryString);
        sb.append(", httpServerRawQueryString=");
        sb.append(this.httpServerRawQueryString);
        sb.append(", httpServerRawResource=");
        sb.append(this.httpServerRawResource);
        sb.append(", httpServerRouteBasedNaming=");
        sb.append(this.httpServerRouteBasedNaming);
        sb.append(", httpServerPathResourceNameMapping=");
        sb.append(this.httpServerPathResourceNameMapping);
        sb.append(", httpClientPathResourceNameMapping=");
        sb.append(this.httpClientPathResourceNameMapping);
        sb.append(", httpClientTagQueryString=");
        sb.append(this.httpClientTagQueryString);
        sb.append(", httpClientSplitByDomain=");
        sb.append(this.httpClientSplitByDomain);
        sb.append(", httpResourceRemoveTrailingSlash");
        sb.append(this.httpResourceRemoveTrailingSlash);
        sb.append(", dbClientSplitByInstance=");
        sb.append(this.dbClientSplitByInstance);
        sb.append(", dbClientSplitByInstanceTypeSuffix=");
        sb.append(this.dbClientSplitByInstanceTypeSuffix);
        sb.append(", dbClientSplitByHost=");
        sb.append(this.dbClientSplitByHost);
        sb.append(", DBMPropagationMode=");
        sb.append(this.DBMPropagationMode);
        sb.append(", splitByTags=");
        sb.append(this.splitByTags);
        sb.append(", scopeDepthLimit=");
        sb.append(this.scopeDepthLimit);
        sb.append(", scopeStrictMode=");
        sb.append(this.scopeStrictMode);
        sb.append(", scopeInheritAsyncPropagation=");
        sb.append(this.scopeInheritAsyncPropagation);
        sb.append(", scopeIterationKeepAlive=");
        sb.append(this.scopeIterationKeepAlive);
        sb.append(", partialFlushMinSpans=");
        sb.append(this.partialFlushMinSpans);
        sb.append(", traceStrictWritesEnabled=");
        sb.append(this.traceStrictWritesEnabled);
        sb.append(", tracePropagationStylesToExtract=");
        sb.append(this.tracePropagationStylesToExtract);
        sb.append(", tracePropagationStylesToInject=");
        sb.append(this.tracePropagationStylesToInject);
        sb.append(", tracePropagationExtractFirst=");
        sb.append(this.tracePropagationExtractFirst);
        sb.append(", clockSyncPeriod=");
        sb.append(this.clockSyncPeriod);
        sb.append(", healthMetricsEnabled=");
        sb.append(this.healthMetricsEnabled);
        sb.append(", healthMetricsStatsdHost='");
        sb.append(this.healthMetricsStatsdHost);
        sb.append("', healthMetricsStatsdPort=");
        sb.append(this.healthMetricsStatsdPort);
        sb.append(", perfMetricsEnabled=");
        sb.append(this.perfMetricsEnabled);
        sb.append(", tracerMetricsEnabled=");
        sb.append(this.tracerMetricsEnabled);
        sb.append(", tracerMetricsBufferingEnabled=");
        sb.append(this.tracerMetricsBufferingEnabled);
        sb.append(", tracerMetricsMaxAggregates=");
        sb.append(this.tracerMetricsMaxAggregates);
        sb.append(", tracerMetricsMaxPending=");
        sb.append(this.tracerMetricsMaxPending);
        sb.append(", reportHostName=");
        sb.append(this.reportHostName);
        sb.append(", traceAnalyticsEnabled=");
        sb.append(this.traceAnalyticsEnabled);
        sb.append(", traceSamplingServiceRules=");
        sb.append(this.traceSamplingServiceRules);
        sb.append(", traceSamplingOperationRules=");
        sb.append(this.traceSamplingOperationRules);
        sb.append(", traceSamplingJsonRules=");
        sb.append(this.traceSamplingRules);
        sb.append(", traceSampleRate=");
        sb.append(this.traceSampleRate);
        sb.append(", traceRateLimit=");
        sb.append(this.traceRateLimit);
        sb.append(", spanSamplingRules=");
        sb.append(this.spanSamplingRules);
        sb.append(", spanSamplingRulesFile=");
        sb.append(this.spanSamplingRulesFile);
        sb.append(", profilingAgentless=");
        sb.append(this.profilingAgentless);
        sb.append(", profilingUrl='");
        sb.append(this.profilingUrl);
        sb.append("', profilingTags=");
        sb.append(this.profilingTags);
        sb.append(", profilingStartDelay=");
        sb.append(this.profilingStartDelay);
        sb.append(", profilingStartForceFirst=");
        sb.append(this.profilingStartForceFirst);
        sb.append(", profilingUploadPeriod=");
        sb.append(this.profilingUploadPeriod);
        sb.append(", profilingTemplateOverrideFile='");
        sb.append(this.profilingTemplateOverrideFile);
        sb.append("', profilingUploadTimeout=");
        sb.append(this.profilingUploadTimeout);
        sb.append(", profilingUploadCompression='");
        sb.append(this.profilingUploadCompression);
        sb.append("', profilingProxyHost='");
        sb.append(this.profilingProxyHost);
        sb.append("', profilingProxyPort=");
        sb.append(this.profilingProxyPort);
        sb.append(", profilingProxyUsername='");
        sb.append(this.profilingProxyUsername);
        sb.append("', profilingProxyPassword=");
        sb.append(this.profilingProxyPassword == null ? AbstractJsonLexerKt.NULL : "****");
        sb.append(", profilingExceptionSampleLimit=");
        sb.append(this.profilingExceptionSampleLimit);
        sb.append(", profilingExceptionHistogramTopItems=");
        sb.append(this.profilingExceptionHistogramTopItems);
        sb.append(", profilingExceptionHistogramMaxCollectionSize=");
        sb.append(this.profilingExceptionHistogramMaxCollectionSize);
        sb.append(", profilingExcludeAgentThreads=");
        sb.append(this.profilingExcludeAgentThreads);
        sb.append(", crashTrackingTags=");
        sb.append(this.crashTrackingTags);
        sb.append(", crashTrackingAgentless=");
        sb.append(this.crashTrackingAgentless);
        sb.append(", remoteConfigEnabled=");
        sb.append(this.remoteConfigEnabled);
        sb.append(", remoteConfigUrl=");
        sb.append(this.remoteConfigUrl);
        sb.append(", remoteConfigPollIntervalSeconds=");
        sb.append(this.remoteConfigPollIntervalSeconds);
        sb.append(", remoteConfigMaxPayloadSize=");
        sb.append(this.remoteConfigMaxPayloadSize);
        sb.append(", remoteConfigIntegrityCheckEnabled=");
        sb.append(this.remoteConfigIntegrityCheckEnabled);
        sb.append(", awsPropagationEnabled=");
        sb.append(this.awsPropagationEnabled);
        sb.append(", sqsPropagationEnabled=");
        sb.append(this.sqsPropagationEnabled);
        sb.append(", kafkaClientPropagationEnabled=");
        sb.append(this.kafkaClientPropagationEnabled);
        sb.append(", kafkaClientPropagationDisabledTopics=");
        sb.append(this.kafkaClientPropagationDisabledTopics);
        sb.append(", kafkaClientBase64DecodingEnabled=");
        sb.append(this.kafkaClientBase64DecodingEnabled);
        sb.append(", jmsPropagationEnabled=");
        sb.append(this.jmsPropagationEnabled);
        sb.append(", jmsPropagationDisabledTopics=");
        sb.append(this.jmsPropagationDisabledTopics);
        sb.append(", jmsPropagationDisabledQueues=");
        sb.append(this.jmsPropagationDisabledQueues);
        sb.append(", rabbitPropagationEnabled=");
        sb.append(this.rabbitPropagationEnabled);
        sb.append(", rabbitPropagationDisabledQueues=");
        sb.append(this.rabbitPropagationDisabledQueues);
        sb.append(", rabbitPropagationDisabledExchanges=");
        sb.append(this.rabbitPropagationDisabledExchanges);
        sb.append(", messageBrokerSplitByDestination=");
        sb.append(this.messageBrokerSplitByDestination);
        sb.append(", hystrixTagsEnabled=");
        sb.append(this.hystrixTagsEnabled);
        sb.append(", hystrixMeasuredEnabled=");
        sb.append(this.hystrixMeasuredEnabled);
        sb.append(", igniteCacheIncludeKeys=");
        sb.append(this.igniteCacheIncludeKeys);
        sb.append(", servletPrincipalEnabled=");
        sb.append(this.servletPrincipalEnabled);
        sb.append(", servletAsyncTimeoutError=");
        sb.append(this.servletAsyncTimeoutError);
        sb.append(", datadogTagsLimit=");
        sb.append(this.xDatadogTagsMaxLength);
        sb.append(", traceAgentV05Enabled=");
        sb.append(this.traceAgentV05Enabled);
        sb.append(", debugEnabled=");
        sb.append(this.debugEnabled);
        sb.append(", triageEnabled=");
        sb.append(this.triageEnabled);
        sb.append(", startLogsEnabled=");
        sb.append(this.startupLogsEnabled);
        sb.append(", configFile='");
        sb.append(this.configFileStatus);
        sb.append("', idGenerationStrategy=");
        sb.append(this.idGenerationStrategy);
        sb.append(", trace128bitTraceIdGenerationEnabled=");
        sb.append(this.trace128bitTraceIdGenerationEnabled);
        sb.append(", grpcIgnoredInboundMethods=");
        sb.append(this.grpcIgnoredInboundMethods);
        sb.append(", grpcIgnoredOutboundMethods=");
        sb.append(this.grpcIgnoredOutboundMethods);
        sb.append(", grpcServerErrorStatuses=");
        sb.append(this.grpcServerErrorStatuses);
        sb.append(", grpcClientErrorStatuses=");
        sb.append(this.grpcClientErrorStatuses);
        sb.append(", clientIpEnabled=");
        sb.append(this.clientIpEnabled);
        sb.append(", longRunningTraceEnabled=");
        sb.append(this.longRunningTraceEnabled);
        sb.append(", longRunningTraceFlushInterval=");
        sb.append(this.longRunningTraceFlushInterval);
        sb.append(", elasticsearchBodyEnabled=");
        sb.append(this.elasticsearchBodyEnabled);
        sb.append(", elasticsearchParamsEnabled=");
        sb.append(this.elasticsearchParamsEnabled);
        sb.append(", elasticsearchBodyAndParamsEnabled=");
        sb.append(this.elasticsearchBodyAndParamsEnabled);
        sb.append(", traceFlushInterval=");
        sb.append(this.traceFlushIntervalSeconds);
        sb.append(", injectBaggageAsTagsEnabled=");
        sb.append(this.injectBaggageAsTagsEnabled);
        sb.append(", logsInjectionEnabled=");
        sb.append(this.logsInjectionEnabled);
        sb.append(", sparkTaskHistogramEnabled=");
        sb.append(this.sparkTaskHistogramEnabled);
        sb.append(", jaxRsExceptionAsErrorsEnabled=");
        sb.append(this.jaxRsExceptionAsErrorsEnabled);
        sb.append(", peerServiceDefaultsEnabled=");
        sb.append(this.peerServiceDefaultsEnabled);
        sb.append(", peerServiceComponentOverrides=");
        sb.append(this.peerServiceComponentOverrides);
        sb.append(", removeIntegrationServiceNamesEnabled=");
        sb.append(this.removeIntegrationServiceNamesEnabled);
        sb.append(", spanAttributeSchemaVersion=");
        sb.append(this.spanAttributeSchemaVersion);
        sb.append(", telemetryDebugRequestsEnabled=");
        sb.append(this.telemetryDebugRequestsEnabled);
        sb.append(", telemetryMetricsEnabled=");
        sb.append(this.telemetryMetricsEnabled);
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
