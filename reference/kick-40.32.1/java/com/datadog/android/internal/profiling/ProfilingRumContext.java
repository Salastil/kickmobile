package com.datadog.android.internal.profiling;

import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfilingRumContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/internal/profiling/ProfilingRumContext;", "", "applicationId", "", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, RumEventMeta.VIEW_ID_KEY, "viewName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApplicationId", "()Ljava/lang/String;", "getSessionId", "getViewId", "getViewName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ProfilingRumContext {
    private final String applicationId;
    private final String sessionId;
    private final String viewId;
    private final String viewName;

    public static /* synthetic */ ProfilingRumContext copy$default(ProfilingRumContext profilingRumContext, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profilingRumContext.applicationId;
        }
        if ((i & 2) != 0) {
            str2 = profilingRumContext.sessionId;
        }
        if ((i & 4) != 0) {
            str3 = profilingRumContext.viewId;
        }
        if ((i & 8) != 0) {
            str4 = profilingRumContext.viewName;
        }
        return profilingRumContext.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getViewId() {
        return this.viewId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getViewName() {
        return this.viewName;
    }

    public final ProfilingRumContext copy(String applicationId, String sessionId, String viewId, String viewName) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new ProfilingRumContext(applicationId, sessionId, viewId, viewName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfilingRumContext)) {
            return false;
        }
        ProfilingRumContext profilingRumContext = (ProfilingRumContext) other;
        return Intrinsics.areEqual(this.applicationId, profilingRumContext.applicationId) && Intrinsics.areEqual(this.sessionId, profilingRumContext.sessionId) && Intrinsics.areEqual(this.viewId, profilingRumContext.viewId) && Intrinsics.areEqual(this.viewName, profilingRumContext.viewName);
    }

    public int hashCode() {
        int iHashCode = ((this.applicationId.hashCode() * 31) + this.sessionId.hashCode()) * 31;
        String str = this.viewId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.viewName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ProfilingRumContext(applicationId=" + this.applicationId + ", sessionId=" + this.sessionId + ", viewId=" + this.viewId + ", viewName=" + this.viewName + ")";
    }

    public ProfilingRumContext(String applicationId, String sessionId, String str, String str2) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.applicationId = applicationId;
        this.sessionId = sessionId;
        this.viewId = str;
        this.viewName = str2;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final String getViewName() {
        return this.viewName;
    }
}
