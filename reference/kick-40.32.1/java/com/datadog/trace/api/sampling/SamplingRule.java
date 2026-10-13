package com.datadog.trace.api.sampling;

import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface SamplingRule {
    public static final String MATCH_ALL = "*";

    public interface SpanSamplingRule extends SamplingRule {
        int getMaxPerSecond();
    }

    public interface TraceSamplingRule extends SamplingRule {
    }

    String getName();

    String getResource();

    double getSampleRate();

    String getService();

    Map<String, String> getTags();

    static String normalizeGlob(String str) {
        return (str == null || "*".equals(str)) ? "*" : str;
    }
}
