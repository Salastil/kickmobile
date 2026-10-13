package com.datadog.trace.api.gateway;

import com.datadog.trace.api.internal.TraceSegment;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public interface RequestContext extends Closeable {
    BlockResponseFunction getBlockResponseFunction();

    <T> T getData(RequestContextSlot requestContextSlot);

    TraceSegment getTraceSegment();

    void setBlockResponseFunction(BlockResponseFunction blockResponseFunction);

    public static class Noop implements RequestContext {
        public static final RequestContext INSTANCE = new Noop();

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // com.datadog.trace.api.gateway.RequestContext
        public BlockResponseFunction getBlockResponseFunction() {
            return null;
        }

        @Override // com.datadog.trace.api.gateway.RequestContext
        public <T> T getData(RequestContextSlot requestContextSlot) {
            return null;
        }

        @Override // com.datadog.trace.api.gateway.RequestContext
        public void setBlockResponseFunction(BlockResponseFunction blockResponseFunction) {
        }

        private Noop() {
        }

        @Override // com.datadog.trace.api.gateway.RequestContext
        public TraceSegment getTraceSegment() {
            return TraceSegment.NoOp.INSTANCE;
        }
    }
}
