package com.datadog.trace.bootstrap.instrumentation.api;

import androidx.work.WorkInfo;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.TracePropagationStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class TagContext implements AgentSpan.Context.Extracted {
    private static final HttpHeaders EMPTY_HTTP_HEADERS = new HttpHeaders();
    private final Map<String, String> baggage;
    private Object ciVisibilityContextData;
    private final HttpHeaders httpHeaders;
    private final CharSequence origin;
    private PathwayContext pathwayContext;
    private final TracePropagationStyle propagationStyle;
    private Object requestContextDataAppSec;
    private Object requestContextDataIast;
    private final int samplingPriority;
    private final Map<String, String> tags;
    private List<AgentSpanLink> terminatedContextLinks;
    private final TraceConfig traceConfig;

    public static class HttpHeaders {
        public String cfConnectingIp;
        public String cfConnectingIpv6;
        public String customIpHeader;
        public String fastlyClientIp;
        public String forwarded;
        public String forwardedFor;
        public String trueClientIp;
        public String userAgent;
        public String xClientIp;
        public String xClusterClientIp;
        public String xForwarded;
        public String xForwardedFor;
        public String xForwardedHost;
        public String xForwardedPort;
        public String xForwardedProto;
        public String xRealIp;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public long getSpanId() {
        return 0L;
    }

    public TagContext() {
        this(null, null);
    }

    public TagContext(String str, Map<String, String> map) {
        this(str, map, null, null, WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, null, TracePropagationStyle.NONE);
    }

    public TagContext(CharSequence charSequence, Map<String, String> map, HttpHeaders httpHeaders, Map<String, String> map2, int i, TraceConfig traceConfig, TracePropagationStyle tracePropagationStyle) {
        this.origin = charSequence;
        this.tags = map;
        this.terminatedContextLinks = null;
        this.httpHeaders = httpHeaders == null ? EMPTY_HTTP_HEADERS : httpHeaders;
        this.baggage = map2 == null ? Collections.EMPTY_MAP : map2;
        this.samplingPriority = i;
        this.traceConfig = traceConfig;
        this.propagationStyle = tracePropagationStyle;
    }

    public TraceConfig getTraceConfig() {
        return this.traceConfig;
    }

    public TracePropagationStyle getPropagationStyle() {
        return this.propagationStyle;
    }

    public final CharSequence getOrigin() {
        return this.origin;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public List<AgentSpanLink> getTerminatedContextLinks() {
        List<AgentSpanLink> list = this.terminatedContextLinks;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public void addTerminatedContextLink(AgentSpanLink agentSpanLink) {
        if (this.terminatedContextLinks == null) {
            this.terminatedContextLinks = new ArrayList();
        }
        this.terminatedContextLinks.add(agentSpanLink);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getForwarded() {
        return this.httpHeaders.forwarded;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getFastlyClientIp() {
        return this.httpHeaders.fastlyClientIp;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getCfConnectingIp() {
        return this.httpHeaders.cfConnectingIp;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getCfConnectingIpv6() {
        return this.httpHeaders.cfConnectingIpv6;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getXForwardedProto() {
        return this.httpHeaders.xForwardedProto;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getXForwardedHost() {
        return this.httpHeaders.xForwardedHost;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getXForwardedPort() {
        return this.httpHeaders.xForwardedPort;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getForwardedFor() {
        return this.httpHeaders.forwardedFor;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getXForwarded() {
        return this.httpHeaders.xForwarded;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getXForwardedFor() {
        return this.httpHeaders.xForwardedFor;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getXClusterClientIp() {
        return this.httpHeaders.xClusterClientIp;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getXRealIp() {
        return this.httpHeaders.xRealIp;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getXClientIp() {
        return this.httpHeaders.xClientIp;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getUserAgent() {
        return this.httpHeaders.userAgent;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getTrueClientIp() {
        return this.httpHeaders.trueClientIp;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
    public String getCustomIpHeader() {
        return this.httpHeaders.customIpHeader;
    }

    public final Map<String, String> getTags() {
        return this.tags;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public final int getTraceSamplingPriority() {
        return this.samplingPriority;
    }

    public final Map<String, String> getBaggage() {
        return this.baggage;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public Iterable<Map.Entry<String, String>> baggageItems() {
        return this.baggage.entrySet();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public DDTraceId getTraceId() {
        return DDTraceId.ZERO;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public final AgentTrace getTrace() {
        return AgentTracer.NoopAgentTrace.INSTANCE;
    }

    public final Object getRequestContextDataAppSec() {
        return this.requestContextDataAppSec;
    }

    public final TagContext withRequestContextDataAppSec(Object obj) {
        this.requestContextDataAppSec = obj;
        return this;
    }

    public final Object getRequestContextDataIast() {
        return this.requestContextDataIast;
    }

    public final TagContext withRequestContextDataIast(Object obj) {
        this.requestContextDataIast = obj;
        return this;
    }

    public Object getCiVisibilityContextData() {
        return this.ciVisibilityContextData;
    }

    public TagContext withCiVisibilityContextData(Object obj) {
        this.ciVisibilityContextData = obj;
        return this;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
    public PathwayContext getPathwayContext() {
        return this.pathwayContext;
    }

    public TagContext withPathwayContext(PathwayContext pathwayContext) {
        this.pathwayContext = pathwayContext;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TagContext{");
        if (this.origin != null) {
            sb.append("origin=");
            sb.append(this.origin);
            sb.append(", ");
        }
        if (this.tags != null) {
            sb.append("tags=");
            sb.append(this.tags);
            sb.append(", ");
        }
        if (this.baggage != null) {
            sb.append("baggage=");
            sb.append(this.baggage);
            sb.append(", ");
        }
        if (this.samplingPriority != -128) {
            sb.append("samplingPriority=");
            sb.append(this.samplingPriority);
            sb.append(", ");
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
