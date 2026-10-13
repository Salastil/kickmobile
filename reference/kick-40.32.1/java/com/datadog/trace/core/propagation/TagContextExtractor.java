package com.datadog.trace.core.propagation;

import com.datadog.android.trace.internal.compat.function.Supplier;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.bootstrap.instrumentation.api.TagContext;

/* JADX INFO: loaded from: classes6.dex */
public class TagContextExtractor implements HttpCodec.Extractor {
    private final ThreadLocal<ContextInterpreter> ctxInterpreter = new ThreadLocal<>();
    private final ContextInterpreter.Factory factory;
    private final Supplier<TraceConfig> traceConfigSupplier;

    public TagContextExtractor(Supplier<TraceConfig> supplier, ContextInterpreter.Factory factory) {
        this.factory = factory;
        this.traceConfigSupplier = supplier;
    }

    @Override // com.datadog.trace.core.propagation.HttpCodec.Extractor
    public void cleanup() {
        this.ctxInterpreter.remove();
    }

    @Override // com.datadog.trace.core.propagation.HttpCodec.Extractor
    public <C> TagContext extract(C c, AgentPropagation.ContextVisitor<C> contextVisitor) {
        ContextInterpreter contextInterpreterReset = resolveContextInterpreter().reset(this.traceConfigSupplier.get());
        contextVisitor.forEachKey(c, contextInterpreterReset);
        return contextInterpreterReset.build();
    }

    private ContextInterpreter resolveContextInterpreter() {
        ContextInterpreter contextInterpreter = this.ctxInterpreter.get();
        if (contextInterpreter != null) {
            return contextInterpreter;
        }
        ContextInterpreter contextInterpreterCreate = this.factory.create();
        this.ctxInterpreter.set(contextInterpreterCreate);
        return contextInterpreterCreate;
    }
}
