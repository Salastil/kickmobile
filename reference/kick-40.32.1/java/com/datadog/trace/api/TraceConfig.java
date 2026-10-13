package com.datadog.trace.api;

import com.datadog.trace.api.sampling.SamplingRule;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface TraceConfig {
    Map<String, String> getBaggageMapping();

    Map<String, String> getRequestHeaderTags();

    Map<String, String> getResponseHeaderTags();

    Map<String, String> getServiceMapping();

    List<? extends SamplingRule.SpanSamplingRule> getSpanSamplingRules();

    Double getTraceSampleRate();

    List<? extends SamplingRule.TraceSamplingRule> getTraceSamplingRules();

    boolean isDataStreamsEnabled();

    boolean isLogsInjectionEnabled();

    boolean isRuntimeMetricsEnabled();
}
