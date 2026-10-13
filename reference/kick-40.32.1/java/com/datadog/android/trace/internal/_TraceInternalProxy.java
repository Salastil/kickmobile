package com.datadog.android.trace.internal;

import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.trace.ApmNetworkInstrumentationConfiguration;
import com.datadog.android.trace.api.scope.DatadogScope;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.span.DatadogSpanContext;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import com.datadog.android.trace.api.tracer.DatadogTracerBuilder;
import com.datadog.trace.core.propagation.Baggage;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: _TraceInternalProxy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0018\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010#2\u0006\u0010(\u001a\u00020#J\u000e\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rJ\u000e\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006/"}, d2 = {"Lcom/datadog/android/trace/internal/_TraceInternalProxy;", "", "()V", "<set-?>", "Lcom/datadog/android/trace/internal/DatadogPropagationHelper;", "propagationHelper", "getPropagationHelper", "()Lcom/datadog/android/trace/internal/DatadogPropagationHelper;", "setPropagationHelper$dd_sdk_android_trace_release", "(Lcom/datadog/android/trace/internal/DatadogPropagationHelper;)V", "spanIdConverter", "Lcom/datadog/android/trace/internal/DatadogSpanIdConverter;", "testBuilderProvider", "Lcom/datadog/android/trace/api/tracer/DatadogTracerBuilder;", "getTestBuilderProvider$dd_sdk_android_trace_release", "()Lcom/datadog/android/trace/api/tracer/DatadogTracerBuilder;", "setTestBuilderProvider$dd_sdk_android_trace_release", "(Lcom/datadog/android/trace/api/tracer/DatadogTracerBuilder;)V", "activateSpan", "Lcom/datadog/android/trace/api/scope/DatadogScope;", "tracer", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "asyncPropagating", "", "addThrowable", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "errorPriority", "", "createApmNetworkInstrumentation", "Lcom/datadog/android/trace/internal/ApmNetworkInstrumentation;", "name", "", "configuration", "Lcom/datadog/android/trace/ApmNetworkInstrumentationConfiguration;", "mergeBaggage", "oldHeader", "newHeader", "setSdkV2Compatible", "builder", "setTraceId128BitGenerationEnabled", "setTracingSamplingPriorityIfNecessary", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class _TraceInternalProxy {
    private static DatadogTracerBuilder testBuilderProvider;
    public static final _TraceInternalProxy INSTANCE = new _TraceInternalProxy();
    public static final DatadogSpanIdConverter spanIdConverter = new DatadogSpanIdConverter();
    private static DatadogPropagationHelper propagationHelper = new DatadogPropagationHelper();

    private _TraceInternalProxy() {
    }

    public final DatadogPropagationHelper getPropagationHelper() {
        return propagationHelper;
    }

    public final void setPropagationHelper$dd_sdk_android_trace_release(DatadogPropagationHelper datadogPropagationHelper) {
        Intrinsics.checkNotNullParameter(datadogPropagationHelper, "<set-?>");
        propagationHelper = datadogPropagationHelper;
    }

    public final DatadogTracerBuilder getTestBuilderProvider$dd_sdk_android_trace_release() {
        return testBuilderProvider;
    }

    public final void setTestBuilderProvider$dd_sdk_android_trace_release(DatadogTracerBuilder datadogTracerBuilder) {
        testBuilderProvider = datadogTracerBuilder;
    }

    public final void setTracingSamplingPriorityIfNecessary(DatadogSpanContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DatadogSpanContextAdapter datadogSpanContextAdapter = context instanceof DatadogSpanContextAdapter ? (DatadogSpanContextAdapter) context : null;
        if (datadogSpanContextAdapter != null) {
            datadogSpanContextAdapter.setTracingSamplingPriorityIfNecessary$dd_sdk_android_trace_release();
        }
    }

    public final DatadogTracerBuilder setTraceId128BitGenerationEnabled(DatadogTracerBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        DatadogTracerBuilderAdapter datadogTracerBuilderAdapter = builder instanceof DatadogTracerBuilderAdapter ? (DatadogTracerBuilderAdapter) builder : null;
        if (datadogTracerBuilderAdapter != null) {
            datadogTracerBuilderAdapter.setTraceId128BitGenerationEnabled$dd_sdk_android_trace_release(true);
        }
        return builder;
    }

    public final DatadogTracerBuilder setSdkV2Compatible(DatadogTracerBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        DatadogTracerBuilderAdapter datadogTracerBuilderAdapter = builder instanceof DatadogTracerBuilderAdapter ? (DatadogTracerBuilderAdapter) builder : null;
        if (datadogTracerBuilderAdapter != null) {
            datadogTracerBuilderAdapter.setSdkV2Compatible$dd_sdk_android_trace_release();
        }
        return builder;
    }

    @JvmStatic
    public static final void addThrowable(DatadogSpan span, Throwable throwable, byte errorPriority) {
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        DatadogSpanAdapter datadogSpanAdapter = span instanceof DatadogSpanAdapter ? (DatadogSpanAdapter) span : null;
        if (datadogSpanAdapter != null) {
            datadogSpanAdapter.addThrowable$dd_sdk_android_trace_release(throwable, errorPriority);
        }
    }

    @JvmStatic
    public static final DatadogScope activateSpan(DatadogTracer tracer, DatadogSpan span, boolean asyncPropagating) {
        Intrinsics.checkNotNullParameter(tracer, "tracer");
        Intrinsics.checkNotNullParameter(span, "span");
        DatadogTracerAdapter datadogTracerAdapter = tracer instanceof DatadogTracerAdapter ? (DatadogTracerAdapter) tracer : null;
        if (datadogTracerAdapter != null) {
            return datadogTracerAdapter.activateSpan$dd_sdk_android_trace_release(span, asyncPropagating);
        }
        return null;
    }

    public final String mergeBaggage(String oldHeader, String newHeader) {
        Intrinsics.checkNotNullParameter(newHeader, "newHeader");
        String string = Baggage.from(oldHeader).mergeWith(Baggage.from(newHeader)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "from(oldHeader)\n        …)\n            .toString()");
        return string;
    }

    public final ApmNetworkInstrumentation createApmNetworkInstrumentation(String name, ApmNetworkInstrumentationConfiguration configuration) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return ApmNetworkInstrumentationConfiguration.INSTANCE.createInstrumentation$dd_sdk_android_trace_release(configuration, name);
    }
}
