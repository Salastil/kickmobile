package com.datadog.trace.bootstrap.instrumentation.api;

import androidx.work.WorkInfo;
import com.datadog.android.trace.internal.compat.function.Consumer;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.EndpointCheckpointer;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.gateway.Flow;
import com.datadog.trace.api.gateway.RequestContext;
import com.datadog.trace.api.gateway.RequestContextSlot;
import com.datadog.trace.api.sampling.SamplingRule;
import com.datadog.trace.api.scopemanager.ScopeListener;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class AgentTracer {
    private static final String DEFAULT_INSTRUMENTATION_NAME = "datadog";

    public static class NoopAgentTrace implements AgentTrace {
        public static final NoopAgentTrace INSTANCE = new NoopAgentTrace();

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTrace
        public void cancelContinuation(AgentScope.Continuation continuation) {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentTrace
        public void registerContinuation(AgentScope.Continuation continuation) {
        }
    }

    public static class NoopPathwayContext implements PathwayContext {
        public static final NoopPathwayContext INSTANCE = new NoopPathwayContext();

        @Override // com.datadog.trace.bootstrap.instrumentation.api.PathwayContext
        public byte[] encode() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.PathwayContext
        public long getHash() {
            return 0L;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.PathwayContext
        public StatsPoint getSavedStats() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.PathwayContext
        public boolean isStarted() {
            return false;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.PathwayContext
        public void saveStats(StatsPoint statsPoint) {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.PathwayContext
        public void setCheckpoint(LinkedHashMap<String, String> linkedHashMap, Consumer<StatsPoint> consumer) {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.PathwayContext
        public void setCheckpoint(LinkedHashMap<String, String> linkedHashMap, Consumer<StatsPoint> consumer, long j) {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.PathwayContext
        public void setCheckpoint(LinkedHashMap<String, String> linkedHashMap, Consumer<StatsPoint> consumer, long j, long j2) {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.PathwayContext
        public String strEncode() {
            return null;
        }
    }

    public interface SpanBuilder {
        SpanBuilder asChildOf(AgentSpan.Context context);

        SpanBuilder ignoreActiveSpan();

        AgentSpan start();

        SpanBuilder withErrorFlag();

        SpanBuilder withLink(AgentSpanLink agentSpanLink);

        SpanBuilder withOrigin(String str);

        <T> SpanBuilder withRequestContextData(RequestContextSlot requestContextSlot, T t);

        SpanBuilder withResourceName(String str);

        SpanBuilder withServiceName(String str);

        SpanBuilder withSpanType(CharSequence charSequence);

        SpanBuilder withStartTimestamp(long j);

        SpanBuilder withTag(String str, Number number);

        SpanBuilder withTag(String str, Object obj);

        SpanBuilder withTag(String str, String str2);

        SpanBuilder withTag(String str, boolean z);
    }

    private AgentTracer() {
    }

    public interface TracerAPI extends EndpointCheckpointer {
        AgentScope activateSpan(AgentSpan agentSpan, ScopeSource scopeSource);

        AgentScope activateSpan(AgentSpan agentSpan, ScopeSource scopeSource, boolean z);

        AgentSpan activeSpan();

        void addScopeListener(ScopeListener scopeListener);

        SpanBuilder buildSpan(String str, CharSequence charSequence);

        TraceConfig captureTraceConfig();

        void close();

        String getSpanId(AgentSpan agentSpan);

        String getTraceId(AgentSpan agentSpan);

        AgentPropagation propagate();

        AgentSpan startSpan(String str, CharSequence charSequence);

        AgentSpan startSpan(String str, CharSequence charSequence, long j);

        AgentSpan startSpan(String str, CharSequence charSequence, AgentSpan.Context context);

        AgentSpan startSpan(String str, CharSequence charSequence, AgentSpan.Context context, long j);

        @Deprecated
        default SpanBuilder buildSpan(CharSequence charSequence) {
            return buildSpan(AgentTracer.DEFAULT_INSTRUMENTATION_NAME, charSequence);
        }
    }

    public static final class NoopAgentSpan implements AgentSpan {
        public static final NoopAgentSpan INSTANCE = new NoopAgentSpan();

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public void addLink(AgentSpanLink agentSpanLink) {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        /* JADX INFO: renamed from: addThrowable */
        public AgentSpan mo11180addThrowable(Throwable th) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public AgentSpan addThrowable(Throwable th, byte b) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public void beginEndToEnd() {
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public void drop() {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public boolean eligibleForDropping() {
            return true;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public void finish() {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public void finish(long j) {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public void finishWithDuration(long j) {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public void finishWithEndToEnd() {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public Integer forceSamplingDecision() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public String getBaggageItem(String str) {
            return null;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public long getDurationNano() {
            return 0L;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public short getHttpStatusCode() {
            return (short) 0;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
        /* JADX INFO: renamed from: getLocalRootSpan */
        public AgentSpan mo11181getLocalRootSpan() {
            return this;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public String getOperationName() {
            return null;
        }

        @Override // com.datadog.trace.api.gateway.IGSpanInfo
        public Flow.Action.RequestBlockingAction getRequestBlockingAction() {
            return null;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public CharSequence getResourceName() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public byte getResourceNamePriority() {
            return (byte) 127;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public AgentSpan getRootSpan() {
            return this;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public String getServiceName() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.gateway.IGSpanInfo
        public long getSpanId() {
            return 0L;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public String getSpanType() {
            return null;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public long getStartTime() {
            return 0L;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
        public Object getTag(String str) {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public boolean hasResourceName() {
            return false;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public boolean isError() {
            return false;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public boolean phasedFinish() {
            return false;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public void publish() {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public AgentSpan setBaggageItem(String str, String str2) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
        public AgentSpan setError(boolean z) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public AgentSpan setError(boolean z, byte b) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        /* JADX INFO: renamed from: setErrorMessage */
        public AgentSpan mo11182setErrorMessage(String str) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public AgentSpan setHttpStatusCode(int i) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        /* JADX INFO: renamed from: setMeasured */
        public AgentSpan mo11183setMeasured(boolean z) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
        /* JADX INFO: renamed from: setMetric */
        public AgentSpan mo11184setMetric(CharSequence charSequence, double d) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
        /* JADX INFO: renamed from: setMetric */
        public AgentSpan mo11185setMetric(CharSequence charSequence, int i) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
        /* JADX INFO: renamed from: setMetric */
        public AgentSpan mo11186setMetric(CharSequence charSequence, long j) {
            return this;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public AgentSpan setOperationName(CharSequence charSequence) {
            return this;
        }

        @Override // com.datadog.trace.api.gateway.IGSpanInfo
        public void setRequestBlockingAction(Flow.Action.RequestBlockingAction requestBlockingAction) {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
        public AgentSpan setResourceName(CharSequence charSequence) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public AgentSpan setResourceName(CharSequence charSequence, byte b) {
            return this;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public AgentSpan setSamplingPriority(int i) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        /* JADX INFO: renamed from: setSamplingPriority */
        public AgentSpan mo11187setSamplingPriority(int i, int i2) {
            return this;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public AgentSpan setServiceName(String str) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public void setSpanName(CharSequence charSequence) {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
        public AgentSpan setSpanType(CharSequence charSequence) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        /* JADX INFO: renamed from: setTag */
        public AgentSpan mo11188setTag(String str, double d) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        /* JADX INFO: renamed from: setTag */
        public AgentSpan mo11189setTag(String str, int i) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        /* JADX INFO: renamed from: setTag */
        public AgentSpan mo11190setTag(String str, long j) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        /* JADX INFO: renamed from: setTag */
        public AgentSpan mo11191setTag(String str, CharSequence charSequence) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
        /* JADX INFO: renamed from: setTag */
        public AgentSpan mo11192setTag(String str, Number number) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        /* JADX INFO: renamed from: setTag */
        public AgentSpan mo11193setTag(String str, Object obj) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
        /* JADX INFO: renamed from: setTag */
        public AgentSpan mo11194setTag(String str, String str2) {
            return this;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.interceptor.MutableSpan
        /* JADX INFO: renamed from: setTag */
        public AgentSpan mo11195setTag(String str, boolean z) {
            return this;
        }

        private NoopAgentSpan() {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan, com.datadog.trace.api.gateway.IGSpanInfo
        public DDTraceId getTraceId() {
            return DDTraceId.ZERO;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public RequestContext getRequestContext() {
            return RequestContext.Noop.INSTANCE;
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan
        public Integer getTraceSamplingPriority() {
            return Integer.valueOf(WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT);
        }

        @Override // com.datadog.trace.api.interceptor.MutableSpan, com.datadog.trace.api.gateway.IGSpanInfo
        public Map<String, Object> getTags() {
            return Collections.EMPTY_MAP;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public boolean isSameTrace(AgentSpan agentSpan) {
            return agentSpan == INSTANCE;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public AgentSpan.Context context() {
            return NoopContext.INSTANCE;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public String getSpanName() {
            return "";
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan
        public TraceConfig traceConfig() {
            return NoopTraceConfig.INSTANCE;
        }
    }

    public static final class NoopAgentScope implements AgentScope {
        public static final NoopAgentScope INSTANCE = new NoopAgentScope();

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope, com.datadog.trace.context.TraceScope, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // com.datadog.trace.context.TraceScope
        public boolean isAsyncPropagating() {
            return false;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope, com.datadog.trace.context.TraceScope
        public void setAsyncPropagation(boolean z) {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope
        public byte source() {
            return (byte) 0;
        }

        private NoopAgentScope() {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope
        public AgentSpan span() {
            return NoopAgentSpan.INSTANCE;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope, com.datadog.trace.context.TraceScope
        public AgentScope.Continuation capture() {
            return NoopContinuation.INSTANCE;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope, com.datadog.trace.context.TraceScope
        public AgentScope.Continuation captureConcurrent() {
            return NoopContinuation.INSTANCE;
        }
    }

    static class NoopContinuation implements AgentScope.Continuation {
        static final NoopContinuation INSTANCE = new NoopContinuation();

        @Override // com.datadog.trace.context.TraceScope.Continuation
        public void cancel() {
        }

        NoopContinuation() {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope.Continuation, com.datadog.trace.context.TraceScope.Continuation
        public AgentScope activate() {
            return NoopAgentScope.INSTANCE;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope.Continuation
        public AgentSpan getSpan() {
            return NoopAgentSpan.INSTANCE;
        }
    }

    public static final class NoopContext implements AgentSpan.Context.Extracted {
        public static final NoopContext INSTANCE = new NoopContext();

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getCfConnectingIp() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getCfConnectingIpv6() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getCustomIpHeader() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getFastlyClientIp() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getForwarded() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getForwardedFor() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
        public long getSpanId() {
            return 0L;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
        public int getTraceSamplingPriority() {
            return WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getTrueClientIp() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getUserAgent() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getXClientIp() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getXClusterClientIp() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getXForwarded() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getXForwardedFor() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getXForwardedHost() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getXForwardedPort() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getXForwardedProto() {
            return null;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public String getXRealIp() {
            return null;
        }

        private NoopContext() {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
        public DDTraceId getTraceId() {
            return DDTraceId.ZERO;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
        public AgentTrace getTrace() {
            return NoopAgentTrace.INSTANCE;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
        public Iterable<Map.Entry<String, String>> baggageItems() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context
        public PathwayContext getPathwayContext() {
            return NoopPathwayContext.INSTANCE;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpan.Context.Extracted
        public List<AgentSpanLink> getTerminatedContextLinks() {
            return Collections.EMPTY_LIST;
        }
    }

    public static final class NoopTraceConfig implements TraceConfig {
        public static final NoopTraceConfig INSTANCE = new NoopTraceConfig();

        @Override // com.datadog.trace.api.TraceConfig
        public Double getTraceSampleRate() {
            return null;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public boolean isDataStreamsEnabled() {
            return false;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public boolean isLogsInjectionEnabled() {
            return false;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public boolean isRuntimeMetricsEnabled() {
            return false;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public Map<String, String> getServiceMapping() {
            return Collections.EMPTY_MAP;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public Map<String, String> getRequestHeaderTags() {
            return Collections.EMPTY_MAP;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public Map<String, String> getResponseHeaderTags() {
            return Collections.EMPTY_MAP;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public Map<String, String> getBaggageMapping() {
            return Collections.EMPTY_MAP;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public List<? extends SamplingRule.SpanSamplingRule> getSpanSamplingRules() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.datadog.trace.api.TraceConfig
        public List<? extends SamplingRule.TraceSamplingRule> getTraceSamplingRules() {
            return Collections.EMPTY_LIST;
        }
    }
}
