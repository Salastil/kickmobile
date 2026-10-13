package com.datadog.trace.bootstrap.instrumentation.api;

import com.datadog.trace.api.DDTraceId;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class SpanLink implements AgentSpanLink {
    private final AgentSpanLink.Attributes attributes;
    private final long spanId;
    private final byte traceFlags;
    private final DDTraceId traceId;
    private final String traceState;

    protected SpanLink(DDTraceId dDTraceId, long j, byte b, String str, AgentSpanLink.Attributes attributes) {
        this.traceId = dDTraceId;
        this.spanId = j;
        this.traceFlags = b;
        this.traceState = str;
        this.attributes = attributes;
    }

    public static SpanLink from(AgentSpan.Context context) {
        return from(context, (byte) 0, "", SpanLinkAttributes.EMPTY);
    }

    public static SpanLink from(AgentSpan.Context context, byte b, String str, AgentSpanLink.Attributes attributes) {
        if (context.getTraceSamplingPriority() > 0) {
            b = (byte) (b | 1);
        }
        return new SpanLink(context.getTraceId(), context.getSpanId(), b, str, attributes);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink
    public DDTraceId traceId() {
        return this.traceId;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink
    public long spanId() {
        return this.spanId;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink
    public byte traceFlags() {
        return this.traceFlags;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink
    public String traceState() {
        return this.traceState;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink
    public AgentSpanLink.Attributes attributes() {
        return this.attributes;
    }

    public String toString() {
        return "SpanLink{traceId=" + this.traceId + ", spanId=" + this.spanId + ", traceFlags=" + ((int) this.traceFlags) + ", traceState='" + this.traceState + "', attributes=" + this.attributes + AbstractJsonLexerKt.END_OBJ;
    }
}
