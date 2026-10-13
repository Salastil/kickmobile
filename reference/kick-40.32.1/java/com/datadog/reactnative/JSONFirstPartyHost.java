package com.datadog.reactnative;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/datadog/reactnative/JSONFirstPartyHost;", "", "match", "", "propagatorTypes", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getMatch", "()Ljava/lang/String;", "getPropagatorTypes", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class JSONFirstPartyHost {
    private final String match;
    private final List<String> propagatorTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSONFirstPartyHost copy$default(JSONFirstPartyHost jSONFirstPartyHost, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jSONFirstPartyHost.match;
        }
        if ((i & 2) != 0) {
            list = jSONFirstPartyHost.propagatorTypes;
        }
        return jSONFirstPartyHost.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMatch() {
        return this.match;
    }

    public final List<String> component2() {
        return this.propagatorTypes;
    }

    public final JSONFirstPartyHost copy(String match, List<String> propagatorTypes) {
        Intrinsics.checkNotNullParameter(match, "match");
        Intrinsics.checkNotNullParameter(propagatorTypes, "propagatorTypes");
        return new JSONFirstPartyHost(match, propagatorTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JSONFirstPartyHost)) {
            return false;
        }
        JSONFirstPartyHost jSONFirstPartyHost = (JSONFirstPartyHost) other;
        return Intrinsics.areEqual(this.match, jSONFirstPartyHost.match) && Intrinsics.areEqual(this.propagatorTypes, jSONFirstPartyHost.propagatorTypes);
    }

    public int hashCode() {
        return (this.match.hashCode() * 31) + this.propagatorTypes.hashCode();
    }

    public String toString() {
        return "JSONFirstPartyHost(match=" + this.match + ", propagatorTypes=" + this.propagatorTypes + ")";
    }

    public JSONFirstPartyHost(String match, List<String> propagatorTypes) {
        Intrinsics.checkNotNullParameter(match, "match");
        Intrinsics.checkNotNullParameter(propagatorTypes, "propagatorTypes");
        this.match = match;
        this.propagatorTypes = propagatorTypes;
    }

    public final String getMatch() {
        return this.match;
    }

    public final List<String> getPropagatorTypes() {
        return this.propagatorTypes;
    }
}
