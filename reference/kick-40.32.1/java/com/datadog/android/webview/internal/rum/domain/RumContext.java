package com.datadog.android.webview.internal.rum.domain;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/webview/internal/rum/domain/RumContext;", "", "applicationId", "", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "sessionState", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApplicationId", "()Ljava/lang/String;", "getSessionId", "getSessionState", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RumContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NULL_UUID;
    private final String applicationId;
    private final String sessionId;
    private final String sessionState;

    public static /* synthetic */ RumContext copy$default(RumContext rumContext, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rumContext.applicationId;
        }
        if ((i & 2) != 0) {
            str2 = rumContext.sessionId;
        }
        if ((i & 4) != 0) {
            str3 = rumContext.sessionState;
        }
        return rumContext.copy(str, str2, str3);
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
    public final String getSessionState() {
        return this.sessionState;
    }

    public final RumContext copy(String applicationId, String sessionId, String sessionState) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        return new RumContext(applicationId, sessionId, sessionState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RumContext)) {
            return false;
        }
        RumContext rumContext = (RumContext) other;
        return Intrinsics.areEqual(this.applicationId, rumContext.applicationId) && Intrinsics.areEqual(this.sessionId, rumContext.sessionId) && Intrinsics.areEqual(this.sessionState, rumContext.sessionState);
    }

    public int hashCode() {
        return (((this.applicationId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.sessionState.hashCode();
    }

    public String toString() {
        return "RumContext(applicationId=" + this.applicationId + ", sessionId=" + this.sessionId + ", sessionState=" + this.sessionState + ")";
    }

    public RumContext(String applicationId, String sessionId, String sessionState) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        this.applicationId = applicationId;
        this.sessionId = sessionId;
        this.sessionState = sessionState;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionState() {
        return this.sessionState;
    }

    /* JADX INFO: compiled from: RumContext.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/webview/internal/rum/domain/RumContext$Companion;", "", "()V", "NULL_UUID", "", "getNULL_UUID", "()Ljava/lang/String;", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getNULL_UUID() {
            return RumContext.NULL_UUID;
        }
    }

    static {
        String string = new UUID(0L, 0L).toString();
        Intrinsics.checkNotNullExpressionValue(string, "UUID(0, 0).toString()");
        NULL_UUID = string;
    }
}
