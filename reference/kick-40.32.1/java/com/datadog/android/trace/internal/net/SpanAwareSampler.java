package com.datadog.android.trace.internal.net;

import com.datadog.android.trace.api.span.DatadogSpan;
import kotlin.Metadata;

/* JADX INFO: compiled from: SpanAwareSampler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/trace/internal/net/SpanAwareSampler;", "", "getSampleRate", "", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "(Lcom/datadog/android/trace/api/span/DatadogSpan;)Ljava/lang/Float;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SpanAwareSampler {
    Float getSampleRate(DatadogSpan span);
}
