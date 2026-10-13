package com.datadog.trace.api;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes6.dex */
public final class EndpointCheckpointerHolder implements EndpointCheckpointer {
    private volatile EndpointCheckpointer endpointCheckpointer;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) EndpointCheckpointerHolder.class);
    private static final AtomicReferenceFieldUpdater<EndpointCheckpointerHolder, EndpointCheckpointer> ROOT_SPAN_CHECKPOINTER = AtomicReferenceFieldUpdater.newUpdater(EndpointCheckpointerHolder.class, EndpointCheckpointer.class, "endpointCheckpointer");

    public static EndpointCheckpointerHolder create() {
        return new EndpointCheckpointerHolder(NoOpCheckpointer.NO_OP);
    }

    public EndpointCheckpointerHolder(EndpointCheckpointer endpointCheckpointer) {
        this.endpointCheckpointer = endpointCheckpointer;
    }

    public void register(EndpointCheckpointer endpointCheckpointer) {
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(ROOT_SPAN_CHECKPOINTER, this, NoOpCheckpointer.NO_OP, endpointCheckpointer)) {
            log.debug("failed to register root span checkpointer {} - {} already registered", endpointCheckpointer.getClass(), this.endpointCheckpointer.getClass());
        } else {
            log.debug("Registered root span checkpointer implementation: {}", endpointCheckpointer);
        }
    }

    @Override // com.datadog.trace.api.EndpointCheckpointer
    public void onRootSpanFinished(AgentSpan agentSpan, EndpointTracker endpointTracker) {
        this.endpointCheckpointer.onRootSpanFinished(agentSpan, endpointTracker);
    }

    @Override // com.datadog.trace.api.EndpointCheckpointer
    public EndpointTracker onRootSpanStarted(AgentSpan agentSpan) {
        return this.endpointCheckpointer.onRootSpanStarted(agentSpan);
    }

    private static final class NoOpCheckpointer implements EndpointCheckpointer {
        static final NoOpCheckpointer NO_OP = new NoOpCheckpointer();

        @Override // com.datadog.trace.api.EndpointCheckpointer
        public void onRootSpanFinished(AgentSpan agentSpan, EndpointTracker endpointTracker) {
        }

        @Override // com.datadog.trace.api.EndpointCheckpointer
        public EndpointTracker onRootSpanStarted(AgentSpan agentSpan) {
            return null;
        }

        private NoOpCheckpointer() {
        }
    }
}
