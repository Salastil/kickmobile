package com.datadog.android.log;

import com.datadog.android.event.EventMapper;
import com.datadog.android.event.NoOpEventMapper;
import com.datadog.android.log.model.LogEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogsConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÀ\u0003¢\u0006\u0002\b\u000fJ%\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/log/LogsConfiguration;", "", "customEndpointUrl", "", "eventMapper", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/log/model/LogEvent;", "(Ljava/lang/String;Lcom/datadog/android/event/EventMapper;)V", "getCustomEndpointUrl$dd_sdk_android_logs_release", "()Ljava/lang/String;", "getEventMapper$dd_sdk_android_logs_release", "()Lcom/datadog/android/event/EventMapper;", "component1", "component1$dd_sdk_android_logs_release", "component2", "component2$dd_sdk_android_logs_release", "copy", "equals", "", "other", "hashCode", "", "toString", "Builder", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LogsConfiguration {
    private final String customEndpointUrl;
    private final EventMapper<LogEvent> eventMapper;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LogsConfiguration copy$default(LogsConfiguration logsConfiguration, String str, EventMapper eventMapper, int i, Object obj) {
        if ((i & 1) != 0) {
            str = logsConfiguration.customEndpointUrl;
        }
        if ((i & 2) != 0) {
            eventMapper = logsConfiguration.eventMapper;
        }
        return logsConfiguration.copy(str, eventMapper);
    }

    /* JADX INFO: renamed from: component1$dd_sdk_android_logs_release, reason: from getter */
    public final String getCustomEndpointUrl() {
        return this.customEndpointUrl;
    }

    public final EventMapper<LogEvent> component2$dd_sdk_android_logs_release() {
        return this.eventMapper;
    }

    public final LogsConfiguration copy(String customEndpointUrl, EventMapper<LogEvent> eventMapper) {
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        return new LogsConfiguration(customEndpointUrl, eventMapper);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogsConfiguration)) {
            return false;
        }
        LogsConfiguration logsConfiguration = (LogsConfiguration) other;
        return Intrinsics.areEqual(this.customEndpointUrl, logsConfiguration.customEndpointUrl) && Intrinsics.areEqual(this.eventMapper, logsConfiguration.eventMapper);
    }

    public int hashCode() {
        String str = this.customEndpointUrl;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.eventMapper.hashCode();
    }

    public String toString() {
        return "LogsConfiguration(customEndpointUrl=" + this.customEndpointUrl + ", eventMapper=" + this.eventMapper + ")";
    }

    public LogsConfiguration(String str, EventMapper<LogEvent> eventMapper) {
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        this.customEndpointUrl = str;
        this.eventMapper = eventMapper;
    }

    public final String getCustomEndpointUrl$dd_sdk_android_logs_release() {
        return this.customEndpointUrl;
    }

    public final EventMapper<LogEvent> getEventMapper$dd_sdk_android_logs_release() {
        return this.eventMapper;
    }

    /* JADX INFO: compiled from: LogsConfiguration.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/log/LogsConfiguration$Builder;", "", "()V", "customEndpointUrl", "", "logsEventMapper", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/log/model/LogEvent;", "build", "Lcom/datadog/android/log/LogsConfiguration;", "setEventMapper", "eventMapper", "useCustomEndpoint", "endpoint", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private String customEndpointUrl;
        private EventMapper<LogEvent> logsEventMapper = new NoOpEventMapper();

        public final Builder useCustomEndpoint(String endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            this.customEndpointUrl = endpoint;
            return this;
        }

        public final Builder setEventMapper(EventMapper<LogEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            this.logsEventMapper = eventMapper;
            return this;
        }

        public final LogsConfiguration build() {
            return new LogsConfiguration(this.customEndpointUrl, this.logsEventMapper);
        }
    }
}
