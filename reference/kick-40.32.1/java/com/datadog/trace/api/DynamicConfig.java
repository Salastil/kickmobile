package com.datadog.trace.api;

import com.datadog.android.trace.internal.compat.function.BiFunction;
import com.datadog.android.trace.internal.compat.function.Function;
import com.datadog.trace.api.DynamicConfig.Snapshot;
import com.datadog.trace.api.config.GeneralConfig;
import com.datadog.trace.api.config.TraceInstrumentationConfig;
import com.datadog.trace.api.config.TracerConfig;
import com.datadog.trace.api.sampling.SamplingRule;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.datadog.trace.util.CollectionUtils;
import com.datadog.trace.util.Strings;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public final class DynamicConfig<S extends Snapshot> {
    volatile S currentSnapshot;
    S initialSnapshot;
    BiFunction<DynamicConfig<S>.Builder, S, S> snapshotFactory;
    static final Logger rootLogger = LoggerFactory.getLogger("ROOT");
    static final Function<Map.Entry<String, String>, String> KEY = new Function() { // from class: com.datadog.trace.api.DynamicConfig$$ExternalSyntheticLambda0
        @Override // com.datadog.android.trace.internal.compat.function.Function
        public final Object apply(Object obj) {
            return DynamicConfig.key((Map.Entry) obj);
        }
    };
    static final Function<Map.Entry<String, String>, String> VALUE = new Function() { // from class: com.datadog.trace.api.DynamicConfig$$ExternalSyntheticLambda1
        @Override // com.datadog.android.trace.internal.compat.function.Function
        public final Object apply(Object obj) {
            return DynamicConfig.value((Map.Entry) obj);
        }
    };
    static final Function<Map.Entry<String, String>, String> LOWER_KEY = new Function() { // from class: com.datadog.trace.api.DynamicConfig$$ExternalSyntheticLambda2
        @Override // com.datadog.android.trace.internal.compat.function.Function
        public final Object apply(Object obj) {
            return DynamicConfig.lowerKey((Map.Entry) obj);
        }
    };
    static final Function<Map.Entry<String, String>, String> REQUEST_TAG = new Function() { // from class: com.datadog.trace.api.DynamicConfig$$ExternalSyntheticLambda3
        @Override // com.datadog.android.trace.internal.compat.function.Function
        public final Object apply(Object obj) {
            return DynamicConfig.requestTag((Map.Entry) obj);
        }
    };
    static final Function<Map.Entry<String, String>, String> RESPONSE_TAG = new Function() { // from class: com.datadog.trace.api.DynamicConfig$$ExternalSyntheticLambda4
        @Override // com.datadog.android.trace.internal.compat.function.Function
        public final Object apply(Object obj) {
            return DynamicConfig.responseTag((Map.Entry) obj);
        }
    };

    private DynamicConfig(BiFunction<DynamicConfig<S>.Builder, S, S> biFunction) {
        this.snapshotFactory = biFunction;
    }

    public static DynamicConfig<Snapshot>.Builder create() {
        return new Builder();
    }

    public static <S extends Snapshot> DynamicConfig<S>.Builder create(BiFunction<DynamicConfig<S>.Builder, S, S> biFunction) {
        return new Builder();
    }

    public S captureTraceConfig() {
        return this.currentSnapshot;
    }

    public DynamicConfig<S>.Builder initial() {
        return new Builder(this.initialSnapshot);
    }

    public DynamicConfig<S>.Builder current() {
        return new Builder(this.currentSnapshot);
    }

    public void resetTraceConfig() {
        this.currentSnapshot = this.initialSnapshot;
        reportConfigChange(this.initialSnapshot);
    }

    public String toString() {
        return this.currentSnapshot.toString();
    }

    public final class Builder {
        Map<String, String> baggageMapping;
        boolean dataStreamsEnabled;
        boolean logsInjectionEnabled;
        Map<String, String> requestHeaderTags;
        Map<String, String> responseHeaderTags;
        boolean runtimeMetricsEnabled;
        Map<String, String> serviceMapping;
        List<? extends SamplingRule.SpanSamplingRule> spanSamplingRules;
        Double traceSampleRate;
        List<? extends SamplingRule.TraceSamplingRule> traceSamplingRules;

        Builder() {
        }

        Builder(Snapshot snapshot) {
            this.runtimeMetricsEnabled = snapshot.runtimeMetricsEnabled;
            this.logsInjectionEnabled = snapshot.logsInjectionEnabled;
            this.dataStreamsEnabled = snapshot.dataStreamsEnabled;
            this.serviceMapping = snapshot.serviceMapping;
            this.requestHeaderTags = snapshot.requestHeaderTags;
            this.responseHeaderTags = snapshot.responseHeaderTags;
            this.baggageMapping = snapshot.baggageMapping;
            this.traceSampleRate = snapshot.traceSampleRate;
        }

        public DynamicConfig<S>.Builder setRuntimeMetricsEnabled(boolean z) {
            this.runtimeMetricsEnabled = z;
            return this;
        }

        public DynamicConfig<S>.Builder setLogsInjectionEnabled(boolean z) {
            this.logsInjectionEnabled = z;
            return this;
        }

        public DynamicConfig<S>.Builder setDataStreamsEnabled(boolean z) {
            this.dataStreamsEnabled = z;
            return this;
        }

        public DynamicConfig<S>.Builder setServiceMapping(Map<String, String> map) {
            return setServiceMapping(map.entrySet());
        }

        public DynamicConfig<S>.Builder setHeaderTags(Map<String, String> map) {
            if (Config.get().getRequestHeaderTags().equals(map) && !Config.get().getResponseHeaderTags().equals(map)) {
                this.requestHeaderTags = Config.get().getRequestHeaderTags();
                this.responseHeaderTags = Config.get().getResponseHeaderTags();
                return this;
            }
            return setHeaderTags(map.entrySet());
        }

        public DynamicConfig<S>.Builder setBaggageMapping(Map<String, String> map) {
            return setBaggageMapping(map.entrySet());
        }

        public DynamicConfig<S>.Builder setServiceMapping(Collection<? extends Map.Entry<String, String>> collection) {
            this.serviceMapping = DynamicConfig.cleanMapping(collection, DynamicConfig.KEY, DynamicConfig.VALUE);
            return this;
        }

        public DynamicConfig<S>.Builder setHeaderTags(Collection<? extends Map.Entry<String, String>> collection) {
            this.requestHeaderTags = DynamicConfig.cleanMapping(collection, DynamicConfig.LOWER_KEY, DynamicConfig.REQUEST_TAG);
            this.responseHeaderTags = DynamicConfig.cleanMapping(collection, DynamicConfig.LOWER_KEY, DynamicConfig.RESPONSE_TAG);
            return this;
        }

        public DynamicConfig<S>.Builder setBaggageMapping(Collection<? extends Map.Entry<String, String>> collection) {
            this.baggageMapping = DynamicConfig.cleanMapping(collection, DynamicConfig.LOWER_KEY, DynamicConfig.VALUE);
            return this;
        }

        public DynamicConfig<S>.Builder setTraceSampleRate(Double d) {
            this.traceSampleRate = d;
            return this;
        }

        public DynamicConfig<S>.Builder setSpanSamplingRules(List<? extends SamplingRule.SpanSamplingRule> list) {
            this.spanSamplingRules = list;
            return this;
        }

        public DynamicConfig<S>.Builder setTraceSamplingRules(List<? extends SamplingRule.TraceSamplingRule> list) {
            this.traceSamplingRules = list;
            return this;
        }

        public DynamicConfig<S> apply() {
            S s = DynamicConfig.this.currentSnapshot;
            S sApply = DynamicConfig.this.snapshotFactory.apply(this, s);
            DynamicConfig dynamicConfig = DynamicConfig.this;
            if (s == null) {
                dynamicConfig.initialSnapshot = sApply;
                DynamicConfig.this.currentSnapshot = sApply;
            } else {
                dynamicConfig.currentSnapshot = sApply;
                DynamicConfig.reportConfigChange(sApply);
            }
            return DynamicConfig.this;
        }
    }

    static Map<String, String> cleanMapping(Collection<? extends Map.Entry<String, String>> collection, Function<Map.Entry<String, String>, String> function, Function<Map.Entry<String, String>, String> function2) {
        HashMap map = new HashMap((collection.size() * 4) / 3);
        for (Map.Entry<String, String> entry : collection) {
            map.put(function.apply(entry), function2.apply(entry));
        }
        return CollectionUtils.tryMakeImmutableMap(map);
    }

    static String key(Map.Entry<String, String> entry) {
        return Strings.trim(entry.getKey());
    }

    static String value(Map.Entry<String, String> entry) {
        return Strings.trim(entry.getValue());
    }

    static String lowerKey(Map.Entry<String, String> entry) {
        return key(entry).toLowerCase(Locale.ROOT);
    }

    static String requestTag(Map.Entry<String, String> entry) {
        String strValue = value(entry);
        if (!strValue.isEmpty()) {
            return strValue;
        }
        return "http.request.headers." + Strings.normalizedHeaderTag(entry.getKey());
    }

    static String responseTag(Map.Entry<String, String> entry) {
        String strValue = value(entry);
        if (!strValue.isEmpty()) {
            return strValue;
        }
        return "http.response.headers." + Strings.normalizedHeaderTag(entry.getKey());
    }

    static void reportConfigChange(Snapshot snapshot) {
        HashMap map = new HashMap();
        map.put(GeneralConfig.TRACE_DEBUG, Boolean.valueOf(rootLogger.isDebugEnabled()));
        map.put(GeneralConfig.RUNTIME_METRICS_ENABLED, Boolean.valueOf(snapshot.runtimeMetricsEnabled));
        map.put(TraceInstrumentationConfig.LOGS_INJECTION_ENABLED, Boolean.valueOf(snapshot.logsInjectionEnabled));
        map.put(GeneralConfig.DATA_STREAMS_ENABLED, Boolean.valueOf(snapshot.dataStreamsEnabled));
        map.put(TracerConfig.SERVICE_MAPPING, snapshot.serviceMapping);
        map.put(TracerConfig.REQUEST_HEADER_TAGS, snapshot.requestHeaderTags);
        map.put(TracerConfig.RESPONSE_HEADER_TAGS, snapshot.responseHeaderTags);
        map.put(TracerConfig.BAGGAGE_MAPPING, snapshot.baggageMapping);
        maybePut(map, "trace.sample.rate", snapshot.traceSampleRate);
        ConfigCollector.get().putAll(map, ConfigOrigin.REMOTE);
    }

    private static void maybePut(Map<String, Object> map, String str, Object obj) {
        if (obj != null) {
            map.put(str, obj);
        }
    }

    public static class Snapshot implements TraceConfig {
        final Map<String, String> baggageMapping;
        final boolean dataStreamsEnabled;
        final boolean logsInjectionEnabled;
        final Map<String, String> requestHeaderTags;
        final Map<String, String> responseHeaderTags;
        final boolean runtimeMetricsEnabled;
        final Map<String, String> serviceMapping;
        final List<? extends SamplingRule.SpanSamplingRule> spanSamplingRules;
        final Double traceSampleRate;
        final List<? extends SamplingRule.TraceSamplingRule> traceSamplingRules;

        protected Snapshot(DynamicConfig<?>.Builder builder, Snapshot snapshot) {
            this.runtimeMetricsEnabled = builder.runtimeMetricsEnabled;
            this.logsInjectionEnabled = builder.logsInjectionEnabled;
            this.dataStreamsEnabled = builder.dataStreamsEnabled;
            this.serviceMapping = nullToEmpty(builder.serviceMapping);
            this.requestHeaderTags = nullToEmpty(builder.requestHeaderTags);
            this.responseHeaderTags = nullToEmpty(builder.responseHeaderTags);
            this.baggageMapping = nullToEmpty(builder.baggageMapping);
            this.traceSampleRate = builder.traceSampleRate;
            this.spanSamplingRules = builder.spanSamplingRules;
            this.traceSamplingRules = builder.traceSamplingRules;
        }

        private static <K, V> Map<K, V> nullToEmpty(Map<K, V> map) {
            return map != null ? map : Collections.EMPTY_MAP;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public boolean isRuntimeMetricsEnabled() {
            return this.runtimeMetricsEnabled;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public boolean isLogsInjectionEnabled() {
            return this.logsInjectionEnabled;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public boolean isDataStreamsEnabled() {
            return this.dataStreamsEnabled;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public Map<String, String> getServiceMapping() {
            return this.serviceMapping;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public Map<String, String> getRequestHeaderTags() {
            return this.requestHeaderTags;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public Map<String, String> getResponseHeaderTags() {
            return this.responseHeaderTags;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public Map<String, String> getBaggageMapping() {
            return this.baggageMapping;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public Double getTraceSampleRate() {
            return this.traceSampleRate;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public List<? extends SamplingRule.SpanSamplingRule> getSpanSamplingRules() {
            return this.spanSamplingRules;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public List<? extends SamplingRule.TraceSamplingRule> getTraceSamplingRules() {
            return this.traceSamplingRules;
        }

        public String toString() {
            return "DynamicConfig{debugEnabled=" + DynamicConfig.rootLogger.isDebugEnabled() + ", runtimeMetricsEnabled=" + this.runtimeMetricsEnabled + ", logsInjectionEnabled=" + this.logsInjectionEnabled + ", dataStreamsEnabled=" + this.dataStreamsEnabled + ", serviceMapping=" + this.serviceMapping + ", requestHeaderTags=" + this.requestHeaderTags + ", responseHeaderTags=" + this.responseHeaderTags + ", baggageMapping=" + this.baggageMapping + ", spanSamplingRules=" + this.spanSamplingRules + ", traceSamplingRules=" + this.traceSamplingRules + ", traceSampleRate=" + this.traceSampleRate + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
