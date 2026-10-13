package com.datadog.android.trace.api.span;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatadogSpanBuilder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0000H&J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u0010\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&J\u001a\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H&J\u001f\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0002\u0010\u0019J\u001f\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "", "ignoreActiveSpan", ViewProps.START, "Lcom/datadog/android/trace/api/span/DatadogSpan;", "withLink", "link", "Lcom/datadog/android/trace/api/span/DatadogSpanLink;", "withOrigin", "origin", "", "withParentContext", "parentContext", "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "withParentSpan", "parentSpan", "withResourceName", "resourceName", "withStartTimestamp", "micros", "", "withTag", "key", "value", "", "(Ljava/lang/String;Ljava/lang/Double;)Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DatadogSpanBuilder {
    DatadogSpanBuilder ignoreActiveSpan();

    DatadogSpan start();

    DatadogSpanBuilder withLink(DatadogSpanLink link);

    DatadogSpanBuilder withOrigin(String origin);

    DatadogSpanBuilder withParentContext(DatadogSpanContext parentContext);

    DatadogSpanBuilder withParentSpan(DatadogSpan parentSpan);

    DatadogSpanBuilder withResourceName(String resourceName);

    DatadogSpanBuilder withStartTimestamp(long micros);

    DatadogSpanBuilder withTag(String key, Double value);

    DatadogSpanBuilder withTag(String key, Long value);

    DatadogSpanBuilder withTag(String key, Object value);
}
