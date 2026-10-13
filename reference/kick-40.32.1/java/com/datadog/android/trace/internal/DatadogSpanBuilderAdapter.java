package com.datadog.android.trace.internal;

import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.span.DatadogSpanBuilder;
import com.datadog.android.trace.api.span.DatadogSpanContext;
import com.datadog.android.trace.api.span.DatadogSpanLink;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.bootstrap.instrumentation.api.AgentTracer;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogSpanBuilderAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0000H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0015\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001f\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\u001f\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogSpanBuilderAdapter;", "Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "delegate", "Lcom/datadog/trace/bootstrap/instrumentation/api/AgentTracer$SpanBuilder;", "spanLogger", "Lcom/datadog/android/trace/internal/DatadogSpanLogger;", "(Lcom/datadog/trace/bootstrap/instrumentation/api/AgentTracer$SpanBuilder;Lcom/datadog/android/trace/internal/DatadogSpanLogger;)V", "ignoreActiveSpan", ViewProps.START, "Lcom/datadog/android/trace/api/span/DatadogSpan;", "withLink", "link", "Lcom/datadog/android/trace/api/span/DatadogSpanLink;", "withOrigin", "origin", "", "withParentContext", "parentContext", "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "withParentSpan", "parentSpan", "withResourceName", "resourceName", "withStartTimestamp", "micros", "", "withTag", "key", "value", "", "", "(Ljava/lang/String;Ljava/lang/Double;)Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogSpanBuilderAdapter implements DatadogSpanBuilder {
    private final AgentTracer.SpanBuilder delegate;
    private final DatadogSpanLogger spanLogger;

    public DatadogSpanBuilderAdapter(AgentTracer.SpanBuilder delegate, DatadogSpanLogger spanLogger) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(spanLogger, "spanLogger");
        this.delegate = delegate;
        this.spanLogger = spanLogger;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilderAdapter ignoreActiveSpan() {
        this.delegate.ignoreActiveSpan();
        return this;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpan start() {
        AgentSpan agentSpanStart = this.delegate.start();
        Intrinsics.checkNotNullExpressionValue(agentSpanStart, "delegate.start()");
        return new DatadogSpanAdapter(agentSpanStart, this.spanLogger);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilderAdapter withOrigin(String origin) {
        this.delegate.withOrigin(origin);
        return this;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilderAdapter withStartTimestamp(long micros) {
        this.delegate.withStartTimestamp(micros);
        return this;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withTag(String key, Double value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.delegate.withTag(key, (Number) value);
        return this;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withTag(String key, Long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.delegate.withTag(key, (Number) value);
        return this;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withTag(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.delegate.withTag(key, value);
        return this;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withLink(DatadogSpanLink link) {
        Intrinsics.checkNotNullParameter(link, "link");
        this.delegate.withLink(new DatadogSpanLinkAdapter(link));
        return this;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withResourceName(String resourceName) {
        this.delegate.withResourceName(resourceName);
        return this;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withParentContext(DatadogSpanContext parentContext) {
        if (parentContext instanceof DatadogSpanContextAdapter) {
            this.delegate.asChildOf(((DatadogSpanContextAdapter) parentContext).getDelegate());
        }
        return this;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanBuilder
    public DatadogSpanBuilder withParentSpan(DatadogSpan parentSpan) {
        return withParentContext(parentSpan != null ? parentSpan.context() : null);
    }
}
