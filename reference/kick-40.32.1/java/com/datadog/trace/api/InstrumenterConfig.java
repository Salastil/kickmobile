package com.datadog.trace.api;

import com.datadog.trace.api.config.GeneralConfig;
import com.datadog.trace.api.config.ProfilingConfig;
import com.datadog.trace.api.config.TraceInstrumentationConfig;
import com.datadog.trace.bootstrap.config.provider.ConfigProvider;
import com.datadog.trace.util.CollectionUtils;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class InstrumenterConfig {
    private static final InstrumenterConfig INSTANCE = new InstrumenterConfig(ConfigProvider.getInstance());
    private final ConfigProvider configProvider;
    private final boolean directAllocationProfilingEnabled;
    private final Set<String> excludedClassLoaders;
    private final List<String> excludedClasses;
    private final String excludedClassesFile;
    private final List<String> excludedCodeSources;
    private final String httpURLConnectionClassName;
    private final boolean integrationsEnabled;
    private final boolean internalExitOnFailure;
    private final String jdbcConnectionClassName;
    private final String jdbcPreparedStatementClassName;
    private final boolean logs128bTraceIdEnabled;
    private final Map<String, Set<String>> measureMethods;
    private final boolean profilingEnabled;
    private final ResolverCacheConfig resolverCacheConfig;
    private final String resolverCacheDir;
    private final boolean resolverNamesAreUnique;
    private final int resolverResetInterval;
    private final boolean resolverUseLoadClass;
    private final Boolean resolverUseUrlCaches;
    private final boolean runtimeContextFieldInjection;
    private final boolean serialVersionUIDFieldInjection;
    private final boolean telemetryEnabled;
    private final boolean traceAnnotationAsync;
    private final String traceAnnotations;
    private final boolean traceEnabled;
    private final List<String> traceExecutors;
    private final boolean traceExecutorsAll;
    private final Map<String, Set<String>> traceMethods;
    private final boolean traceOtelEnabled;
    private final Set<String> traceThreadPoolExecutorsExclude;

    private InstrumenterConfig() {
        this(ConfigProvider.createDefault());
    }

    InstrumenterConfig(ConfigProvider configProvider) {
        this.configProvider = configProvider;
        this.integrationsEnabled = configProvider.getBoolean(TraceInstrumentationConfig.INTEGRATIONS_ENABLED, true, new String[0]);
        this.traceEnabled = configProvider.getBoolean(TraceInstrumentationConfig.TRACE_ENABLED, true, new String[0]);
        this.traceOtelEnabled = configProvider.getBoolean(TraceInstrumentationConfig.TRACE_OTEL_ENABLED, false, new String[0]);
        this.logs128bTraceIdEnabled = configProvider.getBoolean(TraceInstrumentationConfig.TRACE_128_BIT_TRACEID_LOGGING_ENABLED, false, new String[0]);
        this.profilingEnabled = configProvider.getBoolean(ProfilingConfig.PROFILING_ENABLED, false, new String[0]);
        this.telemetryEnabled = configProvider.getBoolean(GeneralConfig.TELEMETRY_ENABLED, true, new String[0]);
        this.traceExecutorsAll = configProvider.getBoolean(TraceInstrumentationConfig.TRACE_EXECUTORS_ALL, false, new String[0]);
        this.traceExecutors = CollectionUtils.tryMakeImmutableList(configProvider.getList(TraceInstrumentationConfig.TRACE_EXECUTORS));
        this.traceThreadPoolExecutorsExclude = CollectionUtils.tryMakeImmutableSet(configProvider.getList(TraceInstrumentationConfig.TRACE_THREAD_POOL_EXECUTORS_EXCLUDE));
        this.jdbcPreparedStatementClassName = configProvider.getString(TraceInstrumentationConfig.JDBC_PREPARED_STATEMENT_CLASS_NAME, "", new String[0]);
        this.jdbcConnectionClassName = configProvider.getString(TraceInstrumentationConfig.JDBC_CONNECTION_CLASS_NAME, "", new String[0]);
        this.httpURLConnectionClassName = configProvider.getString(TraceInstrumentationConfig.HTTP_URL_CONNECTION_CLASS_NAME, "", new String[0]);
        this.directAllocationProfilingEnabled = configProvider.getBoolean(ProfilingConfig.PROFILING_DIRECT_ALLOCATION_ENABLED, false, new String[0]);
        this.excludedClasses = CollectionUtils.tryMakeImmutableList(configProvider.getList(TraceInstrumentationConfig.TRACE_CLASSES_EXCLUDE));
        this.excludedClassesFile = configProvider.getString(TraceInstrumentationConfig.TRACE_CLASSES_EXCLUDE_FILE);
        this.excludedClassLoaders = CollectionUtils.tryMakeImmutableSet(configProvider.getList(TraceInstrumentationConfig.TRACE_CLASSLOADERS_EXCLUDE));
        this.excludedCodeSources = CollectionUtils.tryMakeImmutableList(configProvider.getList(TraceInstrumentationConfig.TRACE_CODESOURCES_EXCLUDE));
        this.resolverCacheConfig = (ResolverCacheConfig) configProvider.getEnum(TraceInstrumentationConfig.RESOLVER_CACHE_CONFIG, ResolverCacheConfig.class, ResolverCacheConfig.MEMOS);
        this.resolverCacheDir = configProvider.getString(TraceInstrumentationConfig.RESOLVER_CACHE_DIR);
        this.resolverNamesAreUnique = configProvider.getBoolean(TraceInstrumentationConfig.RESOLVER_NAMES_ARE_UNIQUE, false, new String[0]);
        this.resolverUseLoadClass = configProvider.getBoolean(TraceInstrumentationConfig.RESOLVER_USE_LOADCLASS, true, new String[0]);
        this.resolverUseUrlCaches = configProvider.getBoolean(TraceInstrumentationConfig.RESOLVER_USE_URL_CACHES);
        this.resolverResetInterval = configProvider.getInteger(TraceInstrumentationConfig.RESOLVER_RESET_INTERVAL, 300, new String[0]);
        this.runtimeContextFieldInjection = configProvider.getBoolean(TraceInstrumentationConfig.RUNTIME_CONTEXT_FIELD_INJECTION, true, new String[0]);
        this.serialVersionUIDFieldInjection = configProvider.getBoolean(TraceInstrumentationConfig.SERIALVERSIONUID_FIELD_INJECTION, true, new String[0]);
        this.traceAnnotations = configProvider.getString(TraceInstrumentationConfig.TRACE_ANNOTATIONS, ConfigDefaults.DEFAULT_TRACE_ANNOTATIONS, new String[0]);
        this.traceAnnotationAsync = configProvider.getBoolean(TraceInstrumentationConfig.TRACE_ANNOTATION_ASYNC, false, new String[0]);
        this.traceMethods = MethodFilterConfigParser.parse(configProvider.getString(TraceInstrumentationConfig.TRACE_METHODS, ConfigDefaults.DEFAULT_TRACE_METHODS, new String[0]));
        this.measureMethods = MethodFilterConfigParser.parse(configProvider.getString(TraceInstrumentationConfig.MEASURE_METHODS, "", new String[0]));
        this.internalExitOnFailure = configProvider.getBoolean(GeneralConfig.INTERNAL_EXIT_ON_FAILURE, false, new String[0]);
    }

    public boolean isIntegrationsEnabled() {
        return this.integrationsEnabled;
    }

    public boolean isIntegrationEnabled(Iterable<String> iterable, boolean z) {
        return this.configProvider.isEnabled(iterable, "integration.", ".enabled", z);
    }

    public boolean isIntegrationShortcutMatchingEnabled(Iterable<String> iterable, boolean z) {
        return this.configProvider.isEnabled(iterable, "integration.", ".matching.shortcut.enabled", z);
    }

    public boolean isTraceEnabled() {
        return this.traceEnabled;
    }

    public boolean isTraceOtelEnabled() {
        return this.traceOtelEnabled;
    }

    public boolean isLogs128bTraceIdEnabled() {
        return this.logs128bTraceIdEnabled;
    }

    public boolean isProfilingEnabled() {
        return this.profilingEnabled;
    }

    public boolean isTelemetryEnabled() {
        return this.telemetryEnabled;
    }

    public boolean isTraceExecutorsAll() {
        return this.traceExecutorsAll;
    }

    public List<String> getTraceExecutors() {
        return this.traceExecutors;
    }

    public Set<String> getTraceThreadPoolExecutorsExclude() {
        return this.traceThreadPoolExecutorsExclude;
    }

    public String getJdbcPreparedStatementClassName() {
        return this.jdbcPreparedStatementClassName;
    }

    public String getJdbcConnectionClassName() {
        return this.jdbcConnectionClassName;
    }

    public String getHttpURLConnectionClassName() {
        return this.httpURLConnectionClassName;
    }

    public boolean isDirectAllocationProfilingEnabled() {
        return this.directAllocationProfilingEnabled;
    }

    public List<String> getExcludedClasses() {
        return this.excludedClasses;
    }

    public String getExcludedClassesFile() {
        return this.excludedClassesFile;
    }

    public Set<String> getExcludedClassLoaders() {
        return this.excludedClassLoaders;
    }

    public List<String> getExcludedCodeSources() {
        return this.excludedCodeSources;
    }

    public int getResolverNoMatchesSize() {
        return this.resolverCacheConfig.noMatchesSize();
    }

    public boolean isResolverMemoizingEnabled() {
        return this.resolverCacheConfig.memoPoolSize() > 0;
    }

    public int getResolverMemoPoolSize() {
        return this.resolverCacheConfig.memoPoolSize();
    }

    public boolean isResolverOutliningEnabled() {
        return this.resolverCacheConfig.outlinePoolSize() > 0;
    }

    public int getResolverOutlinePoolSize() {
        return this.resolverCacheConfig.outlinePoolSize();
    }

    public int getResolverTypePoolSize() {
        return this.resolverCacheConfig.typePoolSize();
    }

    public String getResolverCacheDir() {
        return this.resolverCacheDir;
    }

    public boolean isResolverNamesAreUnique() {
        return this.resolverNamesAreUnique;
    }

    public boolean isResolverUseLoadClass() {
        return this.resolverUseLoadClass;
    }

    public Boolean isResolverUseUrlCaches() {
        return this.resolverUseUrlCaches;
    }

    public int getResolverResetInterval() {
        return this.resolverResetInterval;
    }

    public boolean isRuntimeContextFieldInjection() {
        return this.runtimeContextFieldInjection;
    }

    public boolean isSerialVersionUIDFieldInjection() {
        return this.serialVersionUIDFieldInjection;
    }

    public String getTraceAnnotations() {
        return this.traceAnnotations;
    }

    public boolean isTraceAnnotationAsync() {
        return this.traceAnnotationAsync;
    }

    public Map<String, Set<String>> getTraceMethods() {
        return this.traceMethods;
    }

    public boolean isMethodMeasured(Method method) {
        if (this.measureMethods.isEmpty()) {
            return false;
        }
        Set<String> set = this.measureMethods.get(method.getDeclaringClass().getName());
        return set != null && (set.contains(method.getName()) || set.contains("*"));
    }

    public boolean isInternalExitOnFailure() {
        return this.internalExitOnFailure;
    }

    public static InstrumenterConfig get() {
        return INSTANCE;
    }

    public String toString() {
        return "InstrumenterConfig{integrationsEnabled=" + this.integrationsEnabled + ", traceEnabled=" + this.traceEnabled + ", traceOtelEnabled=" + this.traceOtelEnabled + ", logs128bTraceIdEnabled=" + this.logs128bTraceIdEnabled + ", profilingEnabled=" + this.profilingEnabled + ", telemetryEnabled=" + this.telemetryEnabled + ", traceExecutorsAll=" + this.traceExecutorsAll + ", traceExecutors=" + this.traceExecutors + ", jdbcPreparedStatementClassName='" + this.jdbcPreparedStatementClassName + "', jdbcConnectionClassName='" + this.jdbcConnectionClassName + "', httpURLConnectionClassName='" + this.httpURLConnectionClassName + "', excludedClasses=" + this.excludedClasses + ", excludedClassesFile=" + this.excludedClassesFile + ", excludedClassLoaders=" + this.excludedClassLoaders + ", excludedCodeSources=" + this.excludedCodeSources + ", resolverCacheConfig=" + this.resolverCacheConfig + ", resolverCacheDir=" + this.resolverCacheDir + ", resolverNamesAreUnique=" + this.resolverNamesAreUnique + ", resolverUseLoadClass=" + this.resolverUseLoadClass + ", resolverUseUrlCaches=" + this.resolverUseUrlCaches + ", resolverResetInterval=" + this.resolverResetInterval + ", runtimeContextFieldInjection=" + this.runtimeContextFieldInjection + ", serialVersionUIDFieldInjection=" + this.serialVersionUIDFieldInjection + ", traceAnnotations='" + this.traceAnnotations + "', traceAnnotationAsync=" + this.traceAnnotationAsync + ", traceMethods='" + this.traceMethods + "', measureMethods= '" + this.measureMethods + "', internalExitOnFailure=" + this.internalExitOnFailure + AbstractJsonLexerKt.END_OBJ;
    }
}
