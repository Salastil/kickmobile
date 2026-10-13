package com.datadog.reactnative;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/datadog/reactnative/JSONTraceConfiguration;", "", "customEndpoint", "", "<init>", "(Ljava/lang/String;)V", "getCustomEndpoint", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class JSONTraceConfiguration {
    private final String customEndpoint;

    /* JADX WARN: Multi-variable type inference failed */
    public JSONTraceConfiguration() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ JSONTraceConfiguration copy$default(JSONTraceConfiguration jSONTraceConfiguration, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jSONTraceConfiguration.customEndpoint;
        }
        return jSONTraceConfiguration.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCustomEndpoint() {
        return this.customEndpoint;
    }

    public final JSONTraceConfiguration copy(String customEndpoint) {
        return new JSONTraceConfiguration(customEndpoint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof JSONTraceConfiguration) && Intrinsics.areEqual(this.customEndpoint, ((JSONTraceConfiguration) other).customEndpoint);
    }

    public int hashCode() {
        String str = this.customEndpoint;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "JSONTraceConfiguration(customEndpoint=" + this.customEndpoint + ")";
    }

    public JSONTraceConfiguration(String str) {
        this.customEndpoint = str;
    }

    public /* synthetic */ JSONTraceConfiguration(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getCustomEndpoint() {
        return this.customEndpoint;
    }
}
