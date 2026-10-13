package com.datadog.android.trace.internal.net;

import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.instrumentation.network.HttpRequestInfo;
import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.span.DatadogSpanBuilder;
import com.datadog.android.trace.api.span.DatadogSpanContext;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import com.datadog.android.trace.internal.ApmNetworkInstrumentation;
import com.datadog.android.trace.internal.ParentContextSource;
import com.datadog.android.trace.internal._TraceInternalProxy;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ApmNetworkInstrumentationExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\"\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0000\u001a.\u0010\n\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a!\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0014\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\u0018\u001a\u00020\u0001*\u0004\u0018\u00010\u0019H\u0007\u001a\u0013\u0010\u001a\u001a\u00020\u0001*\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a*\u0010\u001d\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\"\u001a\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u001e"}, d2 = {"isRumEnabled", "", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;)Z", "applyPriority", "", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "isSampled", "traceSampler", "Lcom/datadog/android/core/sampling/Sampler;", "buildSpan", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "request", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "networkInstrumentationName", "", "traceOrigin", "ignoreLocalDroppedParent", "effectiveSampleRate", "", "span", "(Lcom/datadog/android/core/sampling/Sampler;Lcom/datadog/android/trace/api/span/DatadogSpan;)Ljava/lang/Float;", "finishRumAware", "canSendSpan", "isDropped", "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "isDroppedPriority", "", "(Ljava/lang/Integer;)Z", "sample", "dd-sdk-android-trace_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ApmNetworkInstrumentationExtKt {
    public static final boolean isRumEnabled(FeatureSdkCore featureSdkCore) {
        return (featureSdkCore != null ? featureSdkCore.getFeature("rum") : null) != null;
    }

    public static final Float effectiveSampleRate(Sampler<DatadogSpan> sampler, DatadogSpan span) {
        Intrinsics.checkNotNullParameter(sampler, "<this>");
        Intrinsics.checkNotNullParameter(span, "span");
        return sampler instanceof SpanAwareSampler ? ((SpanAwareSampler) sampler).getSampleRate(span) : sampler.getSampleRate();
    }

    public static final void applyPriority(DatadogSpan datadogSpan, boolean z, Sampler<DatadogSpan> traceSampler) {
        Intrinsics.checkNotNullParameter(datadogSpan, "<this>");
        Intrinsics.checkNotNullParameter(traceSampler, "traceSampler");
        DatadogSpanContext datadogSpanContextContext = datadogSpan.context();
        if (datadogSpanContextContext.setSamplingPriority(z ? 1 : 0)) {
            Float fEffectiveSampleRate = effectiveSampleRate(traceSampler, datadogSpan);
            datadogSpanContextContext.setMetric(charSequence, ((double) (fEffectiveSampleRate != null ? fEffectiveSampleRate.floatValue() : 0.0f)) / 100.0d);
        }
    }

    public static final boolean sample(DatadogSpan datadogSpan, HttpRequestInfo request, Sampler<DatadogSpan> traceSampler, boolean z) {
        Intrinsics.checkNotNullParameter(datadogSpan, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(traceSampler, "traceSampler");
        Integer samplingPriority = datadogSpan.getSamplingPriority();
        if (samplingPriority != null) {
            return samplingPriority.intValue() > 0;
        }
        Boolean boolExtractSamplingDecision = _TraceInternalProxy.INSTANCE.getPropagationHelper().extractSamplingDecision(request, z);
        return boolExtractSamplingDecision != null ? boolExtractSamplingDecision.booleanValue() : traceSampler.sample(datadogSpan);
    }

    public static final void finishRumAware(DatadogSpan datadogSpan, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(datadogSpan, "<this>");
        if (z2 && z) {
            datadogSpan.finish();
        } else {
            datadogSpan.drop();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002f  */
    public static final DatadogSpan buildSpan(DatadogTracer datadogTracer, HttpRequestInfo request, String networkInstrumentationName, String str, boolean z) {
        DatadogSpanContext datadogSpanContextContext;
        Intrinsics.checkNotNullParameter(datadogTracer, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(networkInstrumentationName, "networkInstrumentationName");
        ParentContextSource parentContextSourceExtractParentContext = _TraceInternalProxy.INSTANCE.getPropagationHelper().extractParentContext(datadogTracer, request);
        DatadogSpanContext context = parentContextSourceExtractParentContext != null ? parentContextSourceExtractParentContext.getContext() : null;
        if (parentContextSourceExtractParentContext instanceof ParentContextSource.FromTag) {
            datadogSpanContextContext = parentContextSourceExtractParentContext.getContext();
        } else if (parentContextSourceExtractParentContext instanceof ParentContextSource.FromHeaders) {
            datadogSpanContextContext = null;
        } else if (parentContextSourceExtractParentContext == null) {
            DatadogSpan datadogSpanActiveSpan = datadogTracer.activeSpan();
            if (datadogSpanActiveSpan != null) {
                datadogSpanContextContext = datadogSpanActiveSpan.context();
            } else {
                datadogSpanContextContext = null;
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (datadogSpanContextContext != null) {
            _TraceInternalProxy.INSTANCE.setTracingSamplingPriorityIfNecessary(datadogSpanContextContext);
        }
        boolean z2 = z && isDropped(datadogSpanContextContext);
        String str2 = String.format(Locale.US, ApmNetworkInstrumentation.SPAN_NAME, Arrays.copyOf(new Object[]{networkInstrumentationName}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        DatadogSpanBuilder datadogSpanBuilderWithOrigin = datadogTracer.buildSpan(str2).withOrigin(str);
        if (z2) {
            datadogSpanBuilderWithOrigin.ignoreActiveSpan();
        } else {
            datadogSpanBuilderWithOrigin.withParentContext(context);
        }
        DatadogSpan datadogSpanStart = datadogSpanBuilderWithOrigin.start();
        datadogSpanStart.setResourceName(StringsKt.substringBefore$default(request.getUrl(), ApmNetworkInstrumentation.URL_QUERY_PARAMS_BLOCK_SEPARATOR, (String) null, 2, (Object) null));
        datadogSpanStart.setTag("http.url", request.getUrl());
        datadogSpanStart.setTag("http.method", request.getMethod());
        datadogSpanStart.setTag("span.kind", "client");
        return datadogSpanStart;
    }

    public static final boolean isDropped(DatadogSpanContext datadogSpanContext) {
        return isDroppedPriority(datadogSpanContext != null ? Integer.valueOf(datadogSpanContext.getSamplingPriority()) : null);
    }

    public static final boolean isDroppedPriority(Integer num) {
        if (num != null && num.intValue() == 0) {
            return true;
        }
        return num != null && num.intValue() == -1;
    }
}
