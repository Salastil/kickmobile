package com.datadog.reactnative;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/datadog/reactnative/LogsConfiguration;", "", "bundleLogsWithRum", "", "bundleLogsWithTraces", "customEndpoint", "", "<init>", "(ZZLjava/lang/String;)V", "getBundleLogsWithRum", "()Z", "getBundleLogsWithTraces", "getCustomEndpoint", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LogsConfiguration {
    private final boolean bundleLogsWithRum;
    private final boolean bundleLogsWithTraces;
    private final String customEndpoint;

    public static /* synthetic */ LogsConfiguration copy$default(LogsConfiguration logsConfiguration, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = logsConfiguration.bundleLogsWithRum;
        }
        if ((i & 2) != 0) {
            z2 = logsConfiguration.bundleLogsWithTraces;
        }
        if ((i & 4) != 0) {
            str = logsConfiguration.customEndpoint;
        }
        return logsConfiguration.copy(z, z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getBundleLogsWithRum() {
        return this.bundleLogsWithRum;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getBundleLogsWithTraces() {
        return this.bundleLogsWithTraces;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCustomEndpoint() {
        return this.customEndpoint;
    }

    public final LogsConfiguration copy(boolean bundleLogsWithRum, boolean bundleLogsWithTraces, String customEndpoint) {
        return new LogsConfiguration(bundleLogsWithRum, bundleLogsWithTraces, customEndpoint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogsConfiguration)) {
            return false;
        }
        LogsConfiguration logsConfiguration = (LogsConfiguration) other;
        return this.bundleLogsWithRum == logsConfiguration.bundleLogsWithRum && this.bundleLogsWithTraces == logsConfiguration.bundleLogsWithTraces && Intrinsics.areEqual(this.customEndpoint, logsConfiguration.customEndpoint);
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.bundleLogsWithRum) * 31) + Boolean.hashCode(this.bundleLogsWithTraces)) * 31;
        String str = this.customEndpoint;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LogsConfiguration(bundleLogsWithRum=" + this.bundleLogsWithRum + ", bundleLogsWithTraces=" + this.bundleLogsWithTraces + ", customEndpoint=" + this.customEndpoint + ")";
    }

    public LogsConfiguration(boolean z, boolean z2, String str) {
        this.bundleLogsWithRum = z;
        this.bundleLogsWithTraces = z2;
        this.customEndpoint = str;
    }

    public /* synthetic */ LogsConfiguration(boolean z, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, (i & 4) != 0 ? null : str);
    }

    public final boolean getBundleLogsWithRum() {
        return this.bundleLogsWithRum;
    }

    public final boolean getBundleLogsWithTraces() {
        return this.bundleLogsWithTraces;
    }

    public final String getCustomEndpoint() {
        return this.customEndpoint;
    }
}
