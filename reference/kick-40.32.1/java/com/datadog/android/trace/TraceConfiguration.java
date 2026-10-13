package com.datadog.android.trace;

import com.datadog.android.trace.event.NoOpSpanEventMapper;
import com.datadog.android.trace.event.SpanEventMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TraceConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB!\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u0014J)\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/trace/TraceConfiguration;", "", "customEndpointUrl", "", "eventMapper", "Lcom/datadog/android/trace/event/SpanEventMapper;", "networkInfoEnabled", "", "(Ljava/lang/String;Lcom/datadog/android/trace/event/SpanEventMapper;Z)V", "getCustomEndpointUrl$dd_sdk_android_trace_release", "()Ljava/lang/String;", "getEventMapper$dd_sdk_android_trace_release", "()Lcom/datadog/android/trace/event/SpanEventMapper;", "getNetworkInfoEnabled$dd_sdk_android_trace_release", "()Z", "component1", "component1$dd_sdk_android_trace_release", "component2", "component2$dd_sdk_android_trace_release", "component3", "component3$dd_sdk_android_trace_release", "copy", "equals", "other", "hashCode", "", "toString", "Builder", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TraceConfiguration {
    private final String customEndpointUrl;
    private final SpanEventMapper eventMapper;
    private final boolean networkInfoEnabled;

    public static /* synthetic */ TraceConfiguration copy$default(TraceConfiguration traceConfiguration, String str, SpanEventMapper spanEventMapper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = traceConfiguration.customEndpointUrl;
        }
        if ((i & 2) != 0) {
            spanEventMapper = traceConfiguration.eventMapper;
        }
        if ((i & 4) != 0) {
            z = traceConfiguration.networkInfoEnabled;
        }
        return traceConfiguration.copy(str, spanEventMapper, z);
    }

    /* JADX INFO: renamed from: component1$dd_sdk_android_trace_release, reason: from getter */
    public final String getCustomEndpointUrl() {
        return this.customEndpointUrl;
    }

    /* JADX INFO: renamed from: component2$dd_sdk_android_trace_release, reason: from getter */
    public final SpanEventMapper getEventMapper() {
        return this.eventMapper;
    }

    /* JADX INFO: renamed from: component3$dd_sdk_android_trace_release, reason: from getter */
    public final boolean getNetworkInfoEnabled() {
        return this.networkInfoEnabled;
    }

    public final TraceConfiguration copy(String customEndpointUrl, SpanEventMapper eventMapper, boolean networkInfoEnabled) {
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        return new TraceConfiguration(customEndpointUrl, eventMapper, networkInfoEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraceConfiguration)) {
            return false;
        }
        TraceConfiguration traceConfiguration = (TraceConfiguration) other;
        return Intrinsics.areEqual(this.customEndpointUrl, traceConfiguration.customEndpointUrl) && Intrinsics.areEqual(this.eventMapper, traceConfiguration.eventMapper) && this.networkInfoEnabled == traceConfiguration.networkInfoEnabled;
    }

    public int hashCode() {
        String str = this.customEndpointUrl;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.eventMapper.hashCode()) * 31) + Boolean.hashCode(this.networkInfoEnabled);
    }

    public String toString() {
        return "TraceConfiguration(customEndpointUrl=" + this.customEndpointUrl + ", eventMapper=" + this.eventMapper + ", networkInfoEnabled=" + this.networkInfoEnabled + ")";
    }

    public TraceConfiguration(String str, SpanEventMapper eventMapper, boolean z) {
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        this.customEndpointUrl = str;
        this.eventMapper = eventMapper;
        this.networkInfoEnabled = z;
    }

    public final String getCustomEndpointUrl$dd_sdk_android_trace_release() {
        return this.customEndpointUrl;
    }

    public final SpanEventMapper getEventMapper$dd_sdk_android_trace_release() {
        return this.eventMapper;
    }

    public final boolean getNetworkInfoEnabled$dd_sdk_android_trace_release() {
        return this.networkInfoEnabled;
    }

    /* JADX INFO: compiled from: TraceConfiguration.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/trace/TraceConfiguration$Builder;", "", "()V", "customEndpointUrl", "", "networkInfoEnabled", "", "spanEventMapper", "Lcom/datadog/android/trace/event/SpanEventMapper;", "build", "Lcom/datadog/android/trace/TraceConfiguration;", "setEventMapper", "eventMapper", "setNetworkInfoEnabled", "enabled", "useCustomEndpoint", "endpoint", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private String customEndpointUrl;
        private SpanEventMapper spanEventMapper = new NoOpSpanEventMapper();
        private boolean networkInfoEnabled = true;

        public final Builder useCustomEndpoint(String endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            this.customEndpointUrl = endpoint;
            return this;
        }

        public final Builder setEventMapper(SpanEventMapper eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            this.spanEventMapper = eventMapper;
            return this;
        }

        public final Builder setNetworkInfoEnabled(boolean enabled) {
            this.networkInfoEnabled = enabled;
            return this;
        }

        public final TraceConfiguration build() {
            return new TraceConfiguration(this.customEndpointUrl, this.spanEventMapper, this.networkInfoEnabled);
        }
    }
}
