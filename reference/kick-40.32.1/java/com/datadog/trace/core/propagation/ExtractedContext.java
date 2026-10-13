package com.datadog.trace.core.propagation;

import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.TracePropagationStyle;
import com.datadog.trace.bootstrap.instrumentation.api.TagContext;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class ExtractedContext extends TagContext {
    private final long endToEndStartTime;
    private final PropagationTags propagationTags;
    private final long spanId;
    private final DDTraceId traceId;

    public ExtractedContext(DDTraceId dDTraceId, long j, int i, CharSequence charSequence, PropagationTags propagationTags, TracePropagationStyle tracePropagationStyle) {
        this(dDTraceId, j, i, charSequence, 0L, null, null, null, propagationTags, null, tracePropagationStyle);
    }

    public ExtractedContext(DDTraceId dDTraceId, long j, int i, CharSequence charSequence, long j2, Map<String, String> map, Map<String, String> map2, TagContext.HttpHeaders httpHeaders, PropagationTags propagationTags, TraceConfig traceConfig, TracePropagationStyle tracePropagationStyle) {
        super(charSequence, map2, httpHeaders, map, i, traceConfig, tracePropagationStyle);
        this.traceId = dDTraceId;
        this.spanId = j;
        this.endToEndStartTime = j2;
        this.propagationTags = propagationTags;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.TagContext, com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public final DDTraceId getTraceId() {
        return this.traceId;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.TagContext, com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public final long getSpanId() {
        return this.spanId;
    }

    public final long getEndToEndStartTime() {
        return this.endToEndStartTime;
    }

    public PropagationTags getPropagationTags() {
        return this.propagationTags;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.TagContext
    public String toString() {
        StringBuilder sb = new StringBuilder("ExtractedContext{");
        if (this.traceId != null) {
            sb.append("traceId=");
            sb.append(this.traceId);
            sb.append(", ");
        }
        if (this.spanId != 0) {
            sb.append("endToEndStartTime=");
            sb.append(this.spanId);
            sb.append(", ");
        }
        if (this.endToEndStartTime != 0) {
            sb.append("spanId=");
            sb.append(this.spanId);
            sb.append(", ");
        }
        if (getOrigin() != null) {
            sb.append("origin=");
            sb.append(getOrigin());
            sb.append(", ");
        }
        if (getTags() != null) {
            sb.append("tags=");
            sb.append(getTags());
            sb.append(", ");
        }
        if (getBaggage() != null) {
            sb.append("baggage=");
            sb.append(getBaggage());
            sb.append(", ");
        }
        if (getTraceSamplingPriority() != -128) {
            sb.append("samplingPriority=");
            sb.append(getTraceSamplingPriority());
            sb.append(", ");
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
