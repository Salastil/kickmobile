package com.datadog.android.trace.api.span;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpDatadogSpanBuilder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0001H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001f\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\u001f\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/trace/api/span/NoOpDatadogSpanBuilder;", "Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "()V", "ignoreActiveSpan", ViewProps.START, "Lcom/datadog/android/trace/api/span/DatadogSpan;", "withLink", "link", "Lcom/datadog/android/trace/api/span/DatadogSpanLink;", "withOrigin", "origin", "", "withParentContext", "parentContext", "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "withParentSpan", "parentSpan", "withResourceName", "resourceName", "withStartTimestamp", "micros", "", "withTag", "key", "value", "", "", "(Ljava/lang/String;Ljava/lang/Double;)Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDatadogSpanBuilder implements DatadogSpanBuilder {
    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpan start() {
        return new NoOpDatadogSpan();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withOrigin(String origin) {
        return new NoOpDatadogSpanBuilder();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withTag(String key, Double value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new NoOpDatadogSpanBuilder();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withTag(String key, Long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new NoOpDatadogSpanBuilder();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withTag(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new NoOpDatadogSpanBuilder();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withResourceName(String resourceName) {
        return new NoOpDatadogSpanBuilder();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withParentContext(DatadogSpanContext parentContext) {
        return new NoOpDatadogSpanBuilder();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withParentSpan(DatadogSpan parentSpan) {
        return new NoOpDatadogSpanBuilder();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withStartTimestamp(long micros) {
        return new NoOpDatadogSpanBuilder();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder ignoreActiveSpan() {
        return new NoOpDatadogSpanBuilder();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withLink(DatadogSpanLink link) {
        Intrinsics.checkNotNullParameter(link, "link");
        return new NoOpDatadogSpanBuilder();
    }
}
