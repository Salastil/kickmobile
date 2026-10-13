package com.datadog.android.trace.internal;

import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.trace.TracingHeaderType;
import com.datadog.android.trace.api.DatadogTracingConstants;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import com.datadog.android.trace.api.tracer.DatadogTracerBuilder;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.datadog.trace.api.IdGenerationStrategy;
import com.datadog.trace.core.CoreTracer;
import com.facebook.hermes.intl.Constants;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogTracerBuilderAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\r\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bJ\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\r\u0010\"\u001a\u00020#H\u0000¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\nH\u0000¢\u0006\u0002\b'J\u0012\u0010(\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010*\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0016J\u0016\u0010/\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogTracerBuilderAdapter;", "Lcom/datadog/android/trace/api/tracer/DatadogTracerBuilder;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "serviceName", "", "delegate", "Lcom/datadog/trace/core/CoreTracer$CoreTracerBuilder;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Ljava/lang/String;Lcom/datadog/trace/core/CoreTracer$CoreTracerBuilder;)V", "bundleWithRumEnabled", "", "globalTags", "", "partialFlushMinSpans", "", "sampleRate", "", "Ljava/lang/Double;", "sdkV2OTelCompatible", "traceRateLimit", "tracingHeadersTypes", "", "Lcom/datadog/android/trace/TracingHeaderType;", "build", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "properties", "Ljava/util/Properties;", "properties$dd_sdk_android_trace_release", "setBundleWithRumEnabled", "enabled", "setCustomIdGenerationStrategy", "strategy", "Lcom/datadog/trace/api/IdGenerationStrategy;", "setCustomIdGenerationStrategy$dd_sdk_android_trace_release", "setSdkV2Compatible", "", "setSdkV2Compatible$dd_sdk_android_trace_release", "setTraceId128BitGenerationEnabled", "traceId128BitGenerationEnabled", "setTraceId128BitGenerationEnabled$dd_sdk_android_trace_release", "setTraceRateLimit", "withPartialFlushMinSpans", "withSampleRate", "withServiceName", "withTag", "key", "value", "withTracingHeadersTypes", "Companion", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogTracerBuilderAdapter implements DatadogTracerBuilder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_PARTIAL_MIN_FLUSH = 5;
    public static final double DEFAULT_SAMPLE_RATE = 100.0d;
    public static final boolean DEFAULT_URL_AS_RESOURCE_NAME = false;
    private boolean bundleWithRumEnabled;
    private final CoreTracer.CoreTracerBuilder delegate;
    private final Map<String, String> globalTags;
    private int partialFlushMinSpans;
    private Double sampleRate;
    private final FeatureSdkCore sdkCore;
    private boolean sdkV2OTelCompatible;
    private String serviceName;
    private int traceRateLimit;
    private Set<? extends TracingHeaderType> tracingHeadersTypes;

    public DatadogTracerBuilderAdapter(FeatureSdkCore sdkCore, String serviceName, CoreTracer.CoreTracerBuilder delegate) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.sdkCore = sdkCore;
        this.serviceName = serviceName;
        this.delegate = delegate;
        this.bundleWithRumEnabled = true;
        this.traceRateLimit = Integer.MAX_VALUE;
        this.partialFlushMinSpans = 5;
        this.globalTags = new LinkedHashMap();
        this.tracingHeadersTypes = SetsKt.setOf((Object[]) new TracingHeaderType[]{TracingHeaderType.DATADOG, TracingHeaderType.TRACECONTEXT});
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public /* bridge */ /* synthetic */ DatadogTracerBuilder withTracingHeadersTypes(Set set) {
        return withTracingHeadersTypes((Set<? extends TracingHeaderType>) set);
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracer build() {
        CoreTracer coreTracer = this.delegate.withProperties(properties$dd_sdk_android_trace_release()).build();
        DatadogSpanLogger datadogSpanLogger = new DatadogSpanLogger(this.sdkCore);
        FeatureSdkCore featureSdkCore = this.sdkCore;
        Intrinsics.checkNotNullExpressionValue(coreTracer, "coreTracer");
        DatadogTracerAdapter datadogTracerAdapter = new DatadogTracerAdapter(featureSdkCore, coreTracer, this.bundleWithRumEnabled, datadogSpanLogger, null, 16, null);
        DatadogTracerAdapter datadogTracerAdapter2 = datadogTracerAdapter;
        datadogTracerAdapter.addScopeListener(new TracePropagationScopeListener(this.sdkCore, datadogTracerAdapter2));
        return datadogTracerAdapter2;
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilderAdapter withServiceName(String serviceName) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        this.serviceName = serviceName;
        return this;
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilderAdapter withTracingHeadersTypes(Set<? extends TracingHeaderType> tracingHeadersTypes) {
        Intrinsics.checkNotNullParameter(tracingHeadersTypes, "tracingHeadersTypes");
        this.tracingHeadersTypes = tracingHeadersTypes;
        return this;
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilderAdapter withSampleRate(double sampleRate) {
        this.sampleRate = Double.valueOf(sampleRate);
        return this;
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilderAdapter withPartialFlushMinSpans(int partialFlushMinSpans) {
        this.partialFlushMinSpans = partialFlushMinSpans;
        return this;
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilderAdapter withTag(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.globalTags.put(key, value);
        return this;
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilderAdapter setBundleWithRumEnabled(boolean enabled) {
        this.bundleWithRumEnabled = enabled;
        return this;
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilderAdapter setTraceRateLimit(int traceRateLimit) {
        this.traceRateLimit = traceRateLimit;
        return this;
    }

    public final DatadogTracerBuilderAdapter setTraceId128BitGenerationEnabled$dd_sdk_android_trace_release(boolean traceId128BitGenerationEnabled) {
        IdGenerationStrategy idGenerationStrategyFromName = IdGenerationStrategy.fromName("SECURE_RANDOM", traceId128BitGenerationEnabled);
        Intrinsics.checkNotNullExpressionValue(idGenerationStrategyFromName, "fromName(\"SECURE_RANDOM\"…d128BitGenerationEnabled)");
        return setCustomIdGenerationStrategy$dd_sdk_android_trace_release(idGenerationStrategyFromName);
    }

    public final void setSdkV2Compatible$dd_sdk_android_trace_release() {
        this.sdkV2OTelCompatible = true;
    }

    public final DatadogTracerBuilderAdapter setCustomIdGenerationStrategy$dd_sdk_android_trace_release(IdGenerationStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.delegate.idGenerationStrategy(strategy);
        return this;
    }

    public final Properties properties$dd_sdk_android_trace_release() {
        Properties properties = new Properties();
        String strJoinToString$default = CollectionsKt.joinToString$default(this.tracingHeadersTypes, WebViewLogEventConsumer.DDTAGS_SEPARATOR, null, null, 0, null, new Function1<TracingHeaderType, CharSequence>() { // from class: com.datadog.android.trace.internal.DatadogTracerBuilderAdapter$properties$propagationStyles$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(TracingHeaderType it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return DatadogTracerBuilderAdapter.INSTANCE.toPropagationStyle$dd_sdk_android_trace_release(it);
            }
        }, 30, null);
        properties.setProperty("trace.propagation.style.extract", strJoinToString$default);
        properties.setProperty("trace.propagation.style.inject", strJoinToString$default);
        properties.setProperty("service.name", this.serviceName);
        properties.setProperty("trace.rate.limit", String.valueOf(this.traceRateLimit));
        properties.setProperty("trace.partial.flush.min.spans", String.valueOf(this.partialFlushMinSpans));
        properties.setProperty(DatadogTracingConstants.TracerConfig.URL_AS_RESOURCE_NAME, Constants.CASEFIRST_FALSE);
        properties.setProperty("v2.compatibility.enabled", String.valueOf(this.sdkV2OTelCompatible));
        Double d = this.sampleRate;
        if (d != null) {
            properties.setProperty("trace.sample.rate", String.valueOf(d.doubleValue() / 100.0d));
        }
        Map<String, String> map = this.globalTags;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(((Object) entry.getKey()) + ServerSentEventKt.COLON + ((Object) entry.getValue()));
        }
        properties.setProperty("tags", CollectionsKt.joinToString$default(arrayList, WebViewLogEventConsumer.DDTAGS_SEPARATOR, null, null, 0, null, null, 62, null));
        return properties;
    }

    /* JADX INFO: compiled from: DatadogTracerBuilderAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\t\u001a\u00020\n*\u00020\u000bH\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogTracerBuilderAdapter$Companion;", "", "()V", "DEFAULT_PARTIAL_MIN_FLUSH", "", "DEFAULT_SAMPLE_RATE", "", "DEFAULT_URL_AS_RESOURCE_NAME", "", "toPropagationStyle", "", "Lcom/datadog/android/trace/TracingHeaderType;", "toPropagationStyle$dd_sdk_android_trace_release", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: DatadogTracerBuilderAdapter.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TracingHeaderType.values().length];
                try {
                    iArr[TracingHeaderType.B3.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toPropagationStyle$dd_sdk_android_trace_release(TracingHeaderType tracingHeaderType) {
            Intrinsics.checkNotNullParameter(tracingHeaderType, "<this>");
            if (WhenMappings.$EnumSwitchMapping$0[tracingHeaderType.ordinal()] == 1) {
                return "B3SINGLE";
            }
            return tracingHeaderType.name();
        }
    }
}
