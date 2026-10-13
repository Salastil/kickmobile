package com.datadog.trace.bootstrap.instrumentation.api;

import com.datadog.trace.api.DDTraceId;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface AgentSpanLink {
    public static final byte DEFAULT_FLAGS = 0;
    public static final byte SAMPLED_FLAG = 1;

    public interface Attributes {
        Map<String, String> asMap();

        boolean isEmpty();
    }

    Attributes attributes();

    long spanId();

    byte traceFlags();

    DDTraceId traceId();

    String traceState();
}
