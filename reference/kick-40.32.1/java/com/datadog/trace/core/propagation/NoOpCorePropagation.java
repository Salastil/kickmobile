package com.datadog.trace.core.propagation;

import com.datadog.trace.api.TracePropagationStyle;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;

/* JADX INFO: loaded from: classes6.dex */
public class NoOpCorePropagation implements AgentPropagation {
    private final HttpCodec.Extractor extractor;

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation
    public <C> void inject(AgentSpan.Context context, C c, AgentPropagation.Setter<C> setter) {
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation
    public <C> void inject(AgentSpan agentSpan, C c, AgentPropagation.Setter<C> setter) {
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation
    public <C> void inject(AgentSpan agentSpan, C c, AgentPropagation.Setter<C> setter, TracePropagationStyle tracePropagationStyle) {
    }

    public NoOpCorePropagation(HttpCodec.Extractor extractor) {
        this.extractor = extractor;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation
    public <C> AgentSpan.Context.Extracted extract(C c, AgentPropagation.ContextVisitor<C> contextVisitor) {
        return this.extractor.extract(c, contextVisitor);
    }
}
