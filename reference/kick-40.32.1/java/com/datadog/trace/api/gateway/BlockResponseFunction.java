package com.datadog.trace.api.gateway;

import com.datadog.trace.api.internal.TraceSegment;
import com.datadog.trace.appsec.api.blocking.BlockingContentType;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface BlockResponseFunction {
    boolean tryCommitBlockingResponse(TraceSegment traceSegment, int i, BlockingContentType blockingContentType, Map<String, String> map);
}
