package com.datadog.trace.core.propagation;

import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.bootstrap.instrumentation.api.TagContext;
import com.datadog.trace.core.DDSpanContext;

/* JADX INFO: loaded from: classes6.dex */
public class NoneCodec {
    public static final HttpCodec.Injector INJECTOR = new HttpCodec.Injector() { // from class: com.datadog.trace.core.propagation.NoneCodec.1
        @Override // com.datadog.trace.core.propagation.HttpCodec.Injector
        public <C> void inject(DDSpanContext dDSpanContext, C c, AgentPropagation.Setter<C> setter) {
        }
    };
    public static final HttpCodec.Extractor EXTRACTOR = new HttpCodec.Extractor() { // from class: com.datadog.trace.core.propagation.NoneCodec.2
        @Override // com.datadog.trace.core.propagation.HttpCodec.Extractor
        public <C> TagContext extract(C c, AgentPropagation.ContextVisitor<C> contextVisitor) {
            return null;
        }
    };
}
