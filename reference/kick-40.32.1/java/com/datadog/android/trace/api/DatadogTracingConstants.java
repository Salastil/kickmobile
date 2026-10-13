package com.datadog.android.trace.api;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: DatadogTracingConstants.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/datadog/android/trace/api/DatadogTracingConstants;", "", "()V", "DEFAULT_ASYNC_PROPAGATING", "", "ErrorPriorities", "LogAttributes", "PrioritySampling", "Tags", "TracerConfig", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogTracingConstants {
    public static final boolean DEFAULT_ASYNC_PROPAGATING = true;
    public static final DatadogTracingConstants INSTANCE = new DatadogTracingConstants();

    private DatadogTracingConstants() {
    }

    /* JADX INFO: compiled from: DatadogTracingConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/trace/api/DatadogTracingConstants$Tags;", "", "()V", "ERROR_MSG", "", "ERROR_TYPE", "KEY_ANALYTICS_SAMPLE_RATE", "KEY_ERROR_MSG", "KEY_ERROR_STACK", "KEY_ERROR_TYPE", "KEY_HTTP_METHOD", "KEY_HTTP_STATUS", "KEY_HTTP_URL", "KEY_SPAN_KIND", "RESOURCE_NAME", "VALUE_SPAN_KIND_CLIENT", "VALUE_SPAN_KIND_CONSUMER", "VALUE_SPAN_KIND_PRODUCER", "VALUE_SPAN_KIND_SERVER", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Tags {
        public static final String ERROR_MSG = "error.message";
        public static final String ERROR_TYPE = "error.type";
        public static final Tags INSTANCE = new Tags();
        public static final String KEY_ANALYTICS_SAMPLE_RATE = "_dd1.sr.eausr";
        public static final String KEY_ERROR_MSG = "error.msg";
        public static final String KEY_ERROR_STACK = "error.stack";
        public static final String KEY_ERROR_TYPE = "error.type";
        public static final String KEY_HTTP_METHOD = "http.method";
        public static final String KEY_HTTP_STATUS = "http.status_code";
        public static final String KEY_HTTP_URL = "http.url";
        public static final String KEY_SPAN_KIND = "span.kind";
        public static final String RESOURCE_NAME = "resource.name";
        public static final String VALUE_SPAN_KIND_CLIENT = "client";
        public static final String VALUE_SPAN_KIND_CONSUMER = "consumer";
        public static final String VALUE_SPAN_KIND_PRODUCER = "producer";
        public static final String VALUE_SPAN_KIND_SERVER = "server";

        private Tags() {
        }
    }

    /* JADX INFO: compiled from: DatadogTracingConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/datadog/android/trace/api/DatadogTracingConstants$PrioritySampling;", "", "()V", "SAMPLER_DROP", "", "SAMPLER_KEEP", "UNSET", "USER_DROP", "USER_KEEP", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PrioritySampling {
        public static final PrioritySampling INSTANCE = new PrioritySampling();
        public static final int SAMPLER_DROP = 0;
        public static final int SAMPLER_KEEP = 1;
        public static final int UNSET = Integer.MIN_VALUE;
        public static final int USER_DROP = -1;
        public static final int USER_KEEP = 2;

        private PrioritySampling() {
        }
    }

    /* JADX INFO: compiled from: DatadogTracingConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/trace/api/DatadogTracingConstants$TracerConfig;", "", "()V", "PARTIAL_FLUSH_MIN_SPANS", "", "PROPAGATION_STYLE_EXTRACT", "getPROPAGATION_STYLE_EXTRACT$annotations", "PROPAGATION_STYLE_INJECT", "getPROPAGATION_STYLE_INJECT$annotations", "SDK_V2_COMPATIBILITY_FLAG", "SERVICE_NAME", "SPAN_TAGS", "TAGS", "TRACE_PROPAGATION_STYLE_EXTRACT", "TRACE_PROPAGATION_STYLE_INJECT", "TRACE_RATE_LIMIT", "TRACE_SAMPLE_RATE", "URL_AS_RESOURCE_NAME", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TracerConfig {
        public static final TracerConfig INSTANCE = new TracerConfig();
        public static final String PARTIAL_FLUSH_MIN_SPANS = "trace.partial.flush.min.spans";
        public static final String PROPAGATION_STYLE_EXTRACT = "propagation.style.extract";
        public static final String PROPAGATION_STYLE_INJECT = "propagation.style.inject";
        public static final String SDK_V2_COMPATIBILITY_FLAG = "v2.compatibility.enabled";
        public static final String SERVICE_NAME = "service.name";
        public static final String SPAN_TAGS = "trace.span.tags";
        public static final String TAGS = "tags";
        public static final String TRACE_PROPAGATION_STYLE_EXTRACT = "trace.propagation.style.extract";
        public static final String TRACE_PROPAGATION_STYLE_INJECT = "trace.propagation.style.inject";
        public static final String TRACE_RATE_LIMIT = "trace.rate.limit";
        public static final String TRACE_SAMPLE_RATE = "trace.sample.rate";
        public static final String URL_AS_RESOURCE_NAME = "trace.URLAsResourceNameRule.enabled";

        @Deprecated(message = "Use TRACE_PROPAGATION_STYLE_EXTRACT instead.", replaceWith = @ReplaceWith(expression = "TRACE_PROPAGATION_STYLE_EXTRACT", imports = {}))
        public static /* synthetic */ void getPROPAGATION_STYLE_EXTRACT$annotations() {
        }

        @Deprecated(message = "Use TRACE_PROPAGATION_STYLE_INJECT instead.", replaceWith = @ReplaceWith(expression = "TRACE_PROPAGATION_STYLE_INJECT", imports = {}))
        public static /* synthetic */ void getPROPAGATION_STYLE_INJECT$annotations() {
        }

        private TracerConfig() {
        }
    }

    /* JADX INFO: compiled from: DatadogTracingConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/trace/api/DatadogTracingConstants$LogAttributes;", "", "()V", "ERROR_KIND", "", "ERROR_OBJECT", "EVENT", "MESSAGE", "STACK", "STATUS", "TIMESTAMP_MS", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LogAttributes {
        public static final String ERROR_KIND = "error.kind";
        public static final String ERROR_OBJECT = "error.object";
        public static final String EVENT = "event";
        public static final LogAttributes INSTANCE = new LogAttributes();
        public static final String MESSAGE = "message";
        public static final String STACK = "stack";
        public static final String STATUS = "status";
        public static final String TIMESTAMP_MS = "_dd.timestamp_ms";

        private LogAttributes() {
        }
    }

    /* JADX INFO: compiled from: DatadogTracingConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/trace/api/DatadogTracingConstants$ErrorPriorities;", "", "()V", "DEFAULT", "", "HTTP_SERVER_DECORATOR", "UNSET", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ErrorPriorities {
        public static final byte DEFAULT = 0;
        public static final byte HTTP_SERVER_DECORATOR = -1;
        public static final ErrorPriorities INSTANCE = new ErrorPriorities();
        public static final byte UNSET = -128;

        private ErrorPriorities() {
        }
    }
}
