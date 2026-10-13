package com.datadog.trace.api.interceptor;

import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface MutableSpan {
    void drop();

    long getDurationNano();

    MutableSpan getLocalRootSpan();

    CharSequence getOperationName();

    CharSequence getResourceName();

    @Deprecated
    MutableSpan getRootSpan();

    String getServiceName();

    String getSpanType();

    long getStartTime();

    Map<String, Object> getTags();

    Integer getTraceSamplingPriority();

    boolean isError();

    MutableSpan setError(boolean z);

    MutableSpan setMetric(CharSequence charSequence, double d);

    MutableSpan setMetric(CharSequence charSequence, int i);

    MutableSpan setMetric(CharSequence charSequence, long j);

    MutableSpan setOperationName(CharSequence charSequence);

    MutableSpan setResourceName(CharSequence charSequence);

    @Deprecated
    MutableSpan setSamplingPriority(int i);

    MutableSpan setServiceName(String str);

    MutableSpan setSpanType(CharSequence charSequence);

    MutableSpan setTag(String str, Number number);

    MutableSpan setTag(String str, String str2);

    MutableSpan setTag(String str, boolean z);

    default Object getTag(String str) {
        Map<String, Object> tags = getTags();
        if (tags == null) {
            return null;
        }
        return tags.get(str);
    }
}
