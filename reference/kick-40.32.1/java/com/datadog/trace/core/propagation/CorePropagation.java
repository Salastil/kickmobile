package com.datadog.trace.core.propagation;

import com.datadog.trace.api.TracePropagationStyle;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.core.DDSpanContext;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class CorePropagation implements AgentPropagation {
    private final HttpCodec.Extractor extractor;
    private final HttpCodec.Injector injector;
    private final Map<TracePropagationStyle, HttpCodec.Injector> injectors;

    public CorePropagation(HttpCodec.Extractor extractor, HttpCodec.Injector injector, Map<TracePropagationStyle, HttpCodec.Injector> map) {
        this.extractor = extractor;
        this.injector = injector;
        this.injectors = map;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation
    public <C> void inject(AgentSpan agentSpan, C c, AgentPropagation.Setter<C> setter) {
        inject(agentSpan.context(), c, setter, (TracePropagationStyle) null);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation
    public <C> void inject(AgentSpan.Context context, C c, AgentPropagation.Setter<C> setter) {
        inject(context, c, setter, (TracePropagationStyle) null);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation
    public <C> void inject(AgentSpan agentSpan, C c, AgentPropagation.Setter<C> setter, TracePropagationStyle tracePropagationStyle) {
        inject(agentSpan.context(), c, setter, tracePropagationStyle);
    }

    private <C> void inject(AgentSpan.Context context, C c, AgentPropagation.Setter<C> setter, TracePropagationStyle tracePropagationStyle) {
        if (context instanceof DDSpanContext) {
            DDSpanContext dDSpanContext = (DDSpanContext) context;
            dDSpanContext.getTrace().setSamplingPriorityIfNecessary();
            if (tracePropagationStyle == null) {
                this.injector.inject(dDSpanContext, c, setter);
            } else {
                this.injectors.get(tracePropagationStyle).inject(dDSpanContext, c, setter);
            }
        }
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation
    public <C> AgentSpan.Context.Extracted extract(C c, AgentPropagation.ContextVisitor<C> contextVisitor) {
        return this.extractor.extract(c, contextVisitor);
    }
}
