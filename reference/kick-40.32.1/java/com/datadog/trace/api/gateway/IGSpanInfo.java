package com.datadog.trace.api.gateway;

import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface IGSpanInfo {
    Flow.Action.RequestBlockingAction getRequestBlockingAction();

    long getSpanId();

    Map<String, Object> getTags();

    DDTraceId getTraceId();

    void setRequestBlockingAction(Flow.Action.RequestBlockingAction requestBlockingAction);

    AgentSpan setTag(String str, boolean z);
}
