package com.datadog.trace.bootstrap.instrumentation.api;

import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.gateway.IGSpanInfo;
import com.datadog.trace.api.gateway.RequestContext;
import com.datadog.trace.api.interceptor.MutableSpan;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface AgentSpan extends MutableSpan, IGSpanInfo {

    public interface Context {

        public interface Extracted extends Context {
            String getCfConnectingIp();

            String getCfConnectingIpv6();

            String getCustomIpHeader();

            String getFastlyClientIp();

            String getForwarded();

            String getForwardedFor();

            List<AgentSpanLink> getTerminatedContextLinks();

            String getTrueClientIp();

            String getUserAgent();

            String getXClientIp();

            String getXClusterClientIp();

            String getXForwarded();

            String getXForwardedFor();

            String getXForwardedHost();

            String getXForwardedPort();

            String getXForwardedProto();

            String getXRealIp();
        }

        Iterable<Map.Entry<String, String>> baggageItems();

        PathwayContext getPathwayContext();

        long getSpanId();

        AgentTrace getTrace();

        DDTraceId getTraceId();

        int getTraceSamplingPriority();

        default void mergePathwayContext(PathwayContext pathwayContext) {
        }
    }

    void addLink(AgentSpanLink agentSpanLink);

    AgentSpan addThrowable(Throwable th);

    AgentSpan addThrowable(Throwable th, byte b);

    void beginEndToEnd();

    Context context();

    boolean eligibleForDropping();

    void finish();

    void finish(long j);

    void finishWithDuration(long j);

    void finishWithEndToEnd();

    Integer forceSamplingDecision();

    String getBaggageItem(String str);

    short getHttpStatusCode();

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    AgentSpan getLocalRootSpan();

    RequestContext getRequestContext();

    byte getResourceNamePriority();

    @Override // com.datadog.trace.api.gateway.IGSpanInfo
    long getSpanId();

    CharSequence getSpanName();

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    Object getTag(String str);

    @Override // com.datadog.trace.api.gateway.IGSpanInfo
    DDTraceId getTraceId();

    @Deprecated
    boolean hasResourceName();

    boolean isSameTrace(AgentSpan agentSpan);

    boolean phasedFinish();

    void publish();

    AgentSpan setBaggageItem(String str, String str2);

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    AgentSpan setError(boolean z);

    AgentSpan setError(boolean z, byte b);

    AgentSpan setErrorMessage(String str);

    AgentSpan setHttpStatusCode(int i);

    AgentSpan setMeasured(boolean z);

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    AgentSpan setMetric(CharSequence charSequence, double d);

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    AgentSpan setMetric(CharSequence charSequence, int i);

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    AgentSpan setMetric(CharSequence charSequence, long j);

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    AgentSpan setResourceName(CharSequence charSequence);

    AgentSpan setResourceName(CharSequence charSequence, byte b);

    AgentSpan setSamplingPriority(int i, int i2);

    void setSpanName(CharSequence charSequence);

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    AgentSpan setSpanType(CharSequence charSequence);

    AgentSpan setTag(String str, double d);

    AgentSpan setTag(String str, int i);

    AgentSpan setTag(String str, long j);

    AgentSpan setTag(String str, CharSequence charSequence);

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    AgentSpan setTag(String str, Number number);

    AgentSpan setTag(String str, Object obj);

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    AgentSpan setTag(String str, String str2);

    @Override // com.datadog.trace.api.interceptor.MutableSpan
    AgentSpan setTag(String str, boolean z);

    TraceConfig traceConfig();
}
