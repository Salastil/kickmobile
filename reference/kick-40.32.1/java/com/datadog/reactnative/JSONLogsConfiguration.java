package com.datadog.reactnative;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0006HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/datadog/reactnative/JSONLogsConfiguration;", "", "bundleLogsWithRum", "", "bundleLogsWithTraces", "customEndpoint", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getBundleLogsWithRum", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBundleLogsWithTraces", "getCustomEndpoint", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/datadog/reactnative/JSONLogsConfiguration;", "equals", "other", "hashCode", "", "toString", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class JSONLogsConfiguration {
    private final Boolean bundleLogsWithRum;
    private final Boolean bundleLogsWithTraces;
    private final String customEndpoint;

    public JSONLogsConfiguration() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ JSONLogsConfiguration copy$default(JSONLogsConfiguration jSONLogsConfiguration, Boolean bool, Boolean bool2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = jSONLogsConfiguration.bundleLogsWithRum;
        }
        if ((i & 2) != 0) {
            bool2 = jSONLogsConfiguration.bundleLogsWithTraces;
        }
        if ((i & 4) != 0) {
            str = jSONLogsConfiguration.customEndpoint;
        }
        return jSONLogsConfiguration.copy(bool, bool2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getBundleLogsWithRum() {
        return this.bundleLogsWithRum;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getBundleLogsWithTraces() {
        return this.bundleLogsWithTraces;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCustomEndpoint() {
        return this.customEndpoint;
    }

    public final JSONLogsConfiguration copy(Boolean bundleLogsWithRum, Boolean bundleLogsWithTraces, String customEndpoint) {
        return new JSONLogsConfiguration(bundleLogsWithRum, bundleLogsWithTraces, customEndpoint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JSONLogsConfiguration)) {
            return false;
        }
        JSONLogsConfiguration jSONLogsConfiguration = (JSONLogsConfiguration) other;
        return Intrinsics.areEqual(this.bundleLogsWithRum, jSONLogsConfiguration.bundleLogsWithRum) && Intrinsics.areEqual(this.bundleLogsWithTraces, jSONLogsConfiguration.bundleLogsWithTraces) && Intrinsics.areEqual(this.customEndpoint, jSONLogsConfiguration.customEndpoint);
    }

    public int hashCode() {
        Boolean bool = this.bundleLogsWithRum;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.bundleLogsWithTraces;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.customEndpoint;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "JSONLogsConfiguration(bundleLogsWithRum=" + this.bundleLogsWithRum + ", bundleLogsWithTraces=" + this.bundleLogsWithTraces + ", customEndpoint=" + this.customEndpoint + ")";
    }

    public JSONLogsConfiguration(Boolean bool, Boolean bool2, String str) {
        this.bundleLogsWithRum = bool;
        this.bundleLogsWithTraces = bool2;
        this.customEndpoint = str;
    }

    public /* synthetic */ JSONLogsConfiguration(Boolean bool, Boolean bool2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : str);
    }

    public final Boolean getBundleLogsWithRum() {
        return this.bundleLogsWithRum;
    }

    public final Boolean getBundleLogsWithTraces() {
        return this.bundleLogsWithTraces;
    }

    public final String getCustomEndpoint() {
        return this.customEndpoint;
    }
}
