package com.datadog.android.rum.internal.domain;

import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.internal.domain.scope.RumViewType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b+\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0080\b\u0018\u0000 H2\u00020\u0001:\u0001HB±\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0010HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0014HÆ\u0003J\t\u00105\u001a\u00020\u0014HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\u0018HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\t\u0010?\u001a\u00020\u000eHÆ\u0003Jµ\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u0018HÆ\u0001J\u0013\u0010A\u001a\u00020\u00062\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010FJ\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001b¨\u0006I"}, d2 = {"Lcom/datadog/android/rum/internal/domain/RumContext;", "", "applicationId", "", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "isSessionActive", "", RumEventMeta.VIEW_ID_KEY, "viewName", "viewUrl", "actionId", "sessionState", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$State;", "sessionStartReason", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;", "viewType", "Lcom/datadog/android/rum/internal/domain/scope/RumViewType;", "syntheticsTestId", "syntheticsResultId", "viewTimestamp", "", "viewTimestampOffset", "hasReplay", RumSessionScope.RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY, "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$State;Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;Lcom/datadog/android/rum/internal/domain/scope/RumViewType;Ljava/lang/String;Ljava/lang/String;JJZF)V", "getActionId", "()Ljava/lang/String;", "getApplicationId", "getHasReplay", "()Z", "getSessionId", "getSessionSampleRate", "()F", "getSessionStartReason", "()Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;", "getSessionState", "()Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$State;", "getSyntheticsResultId", "getSyntheticsTestId", "getViewId", "getViewName", "getViewTimestamp", "()J", "getViewTimestampOffset", "getViewType", "()Lcom/datadog/android/rum/internal/domain/scope/RumViewType;", "getViewUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toMap", "", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RumContext {
    public static final String ACTION_ID = "action_id";
    public static final String APPLICATION_ID = "application_id";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String HAS_REPLAY = "view_has_replay";
    public static final String NULL_UUID = "00000000-0000-0000-0000-000000000000";
    public static final float SAMPLE_ALL_RATE = 100.0f;
    public static final String SESSION_ACTIVE = "session_active";
    public static final String SESSION_ID = "session_id";
    public static final String SESSION_SAMPLE_RATE = "session_sample_rate";
    public static final String SESSION_START_REASON = "session_start_reason";
    public static final String SESSION_STATE = "session_state";
    public static final String SYNTHETICS_RESULT_ID = "synthetics_result_id";
    public static final String SYNTHETICS_TEST_ID = "synthetics_test_id";
    public static final String VIEW_ID = "view_id";
    public static final String VIEW_NAME = "view_name";
    public static final String VIEW_TIMESTAMP = "view_timestamp";
    public static final String VIEW_TIMESTAMP_OFFSET = "view_timestamp_offset";
    public static final String VIEW_TYPE = "view_type";
    public static final String VIEW_URL = "view_url";
    private final String actionId;
    private final String applicationId;
    private final boolean hasReplay;
    private final boolean isSessionActive;
    private final String sessionId;
    private final float sessionSampleRate;
    private final RumSessionScope.StartReason sessionStartReason;
    private final RumSessionScope.State sessionState;
    private final String syntheticsResultId;
    private final String syntheticsTestId;
    private final String viewId;
    private final String viewName;
    private final long viewTimestamp;
    private final long viewTimestampOffset;
    private final RumViewType viewType;
    private final String viewUrl;

    public RumContext() {
        this(null, null, false, null, null, null, null, null, null, null, null, null, 0L, 0L, false, 0.0f, 65535, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final RumViewType getViewType() {
        return this.viewType;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSyntheticsTestId() {
        return this.syntheticsTestId;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getSyntheticsResultId() {
        return this.syntheticsResultId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getViewTimestamp() {
        return this.viewTimestamp;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final long getViewTimestampOffset() {
        return this.viewTimestampOffset;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getHasReplay() {
        return this.hasReplay;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final float getSessionSampleRate() {
        return this.sessionSampleRate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSessionActive() {
        return this.isSessionActive;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getViewId() {
        return this.viewId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getViewName() {
        return this.viewName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getViewUrl() {
        return this.viewUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getActionId() {
        return this.actionId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final RumSessionScope.State getSessionState() {
        return this.sessionState;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final RumSessionScope.StartReason getSessionStartReason() {
        return this.sessionStartReason;
    }

    public final RumContext copy(String applicationId, String sessionId, boolean isSessionActive, String viewId, String viewName, String viewUrl, String actionId, RumSessionScope.State sessionState, RumSessionScope.StartReason sessionStartReason, RumViewType viewType, String syntheticsTestId, String syntheticsResultId, long viewTimestamp, long viewTimestampOffset, boolean hasReplay, float sessionSampleRate) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(sessionStartReason, "sessionStartReason");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        return new RumContext(applicationId, sessionId, isSessionActive, viewId, viewName, viewUrl, actionId, sessionState, sessionStartReason, viewType, syntheticsTestId, syntheticsResultId, viewTimestamp, viewTimestampOffset, hasReplay, sessionSampleRate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RumContext)) {
            return false;
        }
        RumContext rumContext = (RumContext) other;
        return Intrinsics.areEqual(this.applicationId, rumContext.applicationId) && Intrinsics.areEqual(this.sessionId, rumContext.sessionId) && this.isSessionActive == rumContext.isSessionActive && Intrinsics.areEqual(this.viewId, rumContext.viewId) && Intrinsics.areEqual(this.viewName, rumContext.viewName) && Intrinsics.areEqual(this.viewUrl, rumContext.viewUrl) && Intrinsics.areEqual(this.actionId, rumContext.actionId) && this.sessionState == rumContext.sessionState && this.sessionStartReason == rumContext.sessionStartReason && this.viewType == rumContext.viewType && Intrinsics.areEqual(this.syntheticsTestId, rumContext.syntheticsTestId) && Intrinsics.areEqual(this.syntheticsResultId, rumContext.syntheticsResultId) && this.viewTimestamp == rumContext.viewTimestamp && this.viewTimestampOffset == rumContext.viewTimestampOffset && this.hasReplay == rumContext.hasReplay && Float.compare(this.sessionSampleRate, rumContext.sessionSampleRate) == 0;
    }

    public int hashCode() {
        int iHashCode = ((((this.applicationId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + Boolean.hashCode(this.isSessionActive)) * 31;
        String str = this.viewId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.viewName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.viewUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.actionId;
        int iHashCode5 = (((((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.sessionState.hashCode()) * 31) + this.sessionStartReason.hashCode()) * 31) + this.viewType.hashCode()) * 31;
        String str5 = this.syntheticsTestId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.syntheticsResultId;
        return ((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + Long.hashCode(this.viewTimestamp)) * 31) + Long.hashCode(this.viewTimestampOffset)) * 31) + Boolean.hashCode(this.hasReplay)) * 31) + Float.hashCode(this.sessionSampleRate);
    }

    public String toString() {
        return "RumContext(applicationId=" + this.applicationId + ", sessionId=" + this.sessionId + ", isSessionActive=" + this.isSessionActive + ", viewId=" + this.viewId + ", viewName=" + this.viewName + ", viewUrl=" + this.viewUrl + ", actionId=" + this.actionId + ", sessionState=" + this.sessionState + ", sessionStartReason=" + this.sessionStartReason + ", viewType=" + this.viewType + ", syntheticsTestId=" + this.syntheticsTestId + ", syntheticsResultId=" + this.syntheticsResultId + ", viewTimestamp=" + this.viewTimestamp + ", viewTimestampOffset=" + this.viewTimestampOffset + ", hasReplay=" + this.hasReplay + ", sessionSampleRate=" + this.sessionSampleRate + ")";
    }

    public RumContext(String applicationId, String sessionId, boolean z, String str, String str2, String str3, String str4, RumSessionScope.State sessionState, RumSessionScope.StartReason sessionStartReason, RumViewType viewType, String str5, String str6, long j, long j2, boolean z2, float f) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(sessionStartReason, "sessionStartReason");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        this.applicationId = applicationId;
        this.sessionId = sessionId;
        this.isSessionActive = z;
        this.viewId = str;
        this.viewName = str2;
        this.viewUrl = str3;
        this.actionId = str4;
        this.sessionState = sessionState;
        this.sessionStartReason = sessionStartReason;
        this.viewType = viewType;
        this.syntheticsTestId = str5;
        this.syntheticsResultId = str6;
        this.viewTimestamp = j;
        this.viewTimestampOffset = j2;
        this.hasReplay = z2;
        this.sessionSampleRate = f;
    }

    public /* synthetic */ RumContext(String str, String str2, boolean z, String str3, String str4, String str5, String str6, RumSessionScope.State state, RumSessionScope.StartReason startReason, RumViewType rumViewType, String str7, String str8, long j, long j2, boolean z2, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "00000000-0000-0000-0000-000000000000" : str, (i & 2) == 0 ? str2 : "00000000-0000-0000-0000-000000000000", (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? RumSessionScope.State.NOT_TRACKED : state, (i & 256) != 0 ? RumSessionScope.StartReason.USER_APP_LAUNCH : startReason, (i & 512) != 0 ? RumViewType.NONE : rumViewType, (i & 1024) != 0 ? null : str7, (i & 2048) == 0 ? str8 : null, (i & 4096) != 0 ? 0L : j, (i & 8192) == 0 ? j2 : 0L, (i & 16384) == 0 ? z2 : false, (i & 32768) != 0 ? 100.0f : f);
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final boolean isSessionActive() {
        return this.isSessionActive;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final String getViewName() {
        return this.viewName;
    }

    public final String getViewUrl() {
        return this.viewUrl;
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final RumSessionScope.State getSessionState() {
        return this.sessionState;
    }

    public final RumSessionScope.StartReason getSessionStartReason() {
        return this.sessionStartReason;
    }

    public final RumViewType getViewType() {
        return this.viewType;
    }

    public final String getSyntheticsTestId() {
        return this.syntheticsTestId;
    }

    public final String getSyntheticsResultId() {
        return this.syntheticsResultId;
    }

    public final long getViewTimestamp() {
        return this.viewTimestamp;
    }

    public final long getViewTimestampOffset() {
        return this.viewTimestampOffset;
    }

    public final boolean getHasReplay() {
        return this.hasReplay;
    }

    public final float getSessionSampleRate() {
        return this.sessionSampleRate;
    }

    public final Map<String, Object> toMap() {
        return MapsKt.mapOf(TuplesKt.to("application_id", this.applicationId), TuplesKt.to("session_id", this.sessionId), TuplesKt.to(SESSION_ACTIVE, Boolean.valueOf(this.isSessionActive)), TuplesKt.to(SESSION_STATE, this.sessionState.getAsString()), TuplesKt.to(SESSION_START_REASON, this.sessionStartReason.getAsString()), TuplesKt.to("view_id", this.viewId), TuplesKt.to(VIEW_NAME, this.viewName), TuplesKt.to(VIEW_URL, this.viewUrl), TuplesKt.to("view_type", this.viewType.getAsString()), TuplesKt.to(ACTION_ID, this.actionId), TuplesKt.to(SYNTHETICS_TEST_ID, this.syntheticsTestId), TuplesKt.to(SYNTHETICS_RESULT_ID, this.syntheticsResultId), TuplesKt.to("view_timestamp", Long.valueOf(this.viewTimestamp)), TuplesKt.to("view_has_replay", Boolean.valueOf(this.hasReplay)), TuplesKt.to(VIEW_TIMESTAMP_OFFSET, Long.valueOf(this.viewTimestampOffset)), TuplesKt.to("session_sample_rate", Float.valueOf(this.sessionSampleRate)));
    }

    /* JADX INFO: compiled from: RumContext.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/internal/domain/RumContext$Companion;", "", "()V", "ACTION_ID", "", "APPLICATION_ID", "HAS_REPLAY", "NULL_UUID", "SAMPLE_ALL_RATE", "", "SESSION_ACTIVE", "SESSION_ID", "SESSION_SAMPLE_RATE", "SESSION_START_REASON", "SESSION_STATE", "SYNTHETICS_RESULT_ID", "SYNTHETICS_TEST_ID", "VIEW_ID", "VIEW_NAME", "VIEW_TIMESTAMP", "VIEW_TIMESTAMP_OFFSET", "VIEW_TYPE", "VIEW_URL", "fromFeatureContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "featureContext", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumContext fromFeatureContext(Map<String, ? extends Object> featureContext) {
            Intrinsics.checkNotNullParameter(featureContext, "featureContext");
            Object obj = featureContext.get("application_id");
            String str = obj instanceof String ? (String) obj : null;
            Object obj2 = featureContext.get("session_id");
            String str2 = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = featureContext.get(RumContext.SESSION_ACTIVE);
            Boolean bool = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            RumSessionScope.State.Companion companion = RumSessionScope.State.Companion;
            Object obj4 = featureContext.get(RumContext.SESSION_STATE);
            RumSessionScope.State stateFromString = companion.fromString(obj4 instanceof String ? (String) obj4 : null);
            RumSessionScope.StartReason.Companion companion2 = RumSessionScope.StartReason.Companion;
            Object obj5 = featureContext.get(RumContext.SESSION_START_REASON);
            RumSessionScope.StartReason startReasonFromString = companion2.fromString(obj5 instanceof String ? (String) obj5 : null);
            Object obj6 = featureContext.get("view_id");
            String str3 = obj6 instanceof String ? (String) obj6 : null;
            Object obj7 = featureContext.get(RumContext.VIEW_NAME);
            String str4 = obj7 instanceof String ? (String) obj7 : null;
            Object obj8 = featureContext.get(RumContext.VIEW_URL);
            String str5 = obj8 instanceof String ? (String) obj8 : null;
            RumViewType.Companion companion3 = RumViewType.INSTANCE;
            Object obj9 = featureContext.get("view_type");
            RumViewType rumViewTypeFromString = companion3.fromString(obj9 instanceof String ? (String) obj9 : null);
            Object obj10 = featureContext.get(RumContext.ACTION_ID);
            String str6 = obj10 instanceof String ? (String) obj10 : null;
            Object obj11 = featureContext.get(RumContext.SYNTHETICS_TEST_ID);
            String str7 = obj11 instanceof String ? (String) obj11 : null;
            Object obj12 = featureContext.get(RumContext.SYNTHETICS_RESULT_ID);
            String str8 = obj12 instanceof String ? (String) obj12 : null;
            Object obj13 = featureContext.get("view_has_replay");
            Boolean bool2 = obj13 instanceof Boolean ? (Boolean) obj13 : null;
            boolean zBooleanValue = bool2 != null ? bool2.booleanValue() : false;
            Object obj14 = featureContext.get("view_timestamp");
            Long l = obj14 instanceof Long ? (Long) obj14 : null;
            long jLongValue = l != null ? l.longValue() : 0L;
            Object obj15 = featureContext.get(RumContext.VIEW_TIMESTAMP_OFFSET);
            Long l2 = obj15 instanceof Long ? (Long) obj15 : null;
            long jLongValue2 = l2 != null ? l2.longValue() : 0L;
            Object obj16 = featureContext.get("session_sample_rate");
            Number number = obj16 instanceof Number ? (Number) obj16 : null;
            float fFloatValue = number != null ? number.floatValue() : 100.0f;
            if (str == null) {
                str = "00000000-0000-0000-0000-000000000000";
            }
            String str9 = str2 == null ? "00000000-0000-0000-0000-000000000000" : str2;
            boolean zBooleanValue2 = bool != null ? bool.booleanValue() : false;
            if (stateFromString == null) {
                stateFromString = RumSessionScope.State.NOT_TRACKED;
            }
            RumSessionScope.State state = stateFromString;
            if (startReasonFromString == null) {
                startReasonFromString = RumSessionScope.StartReason.USER_APP_LAUNCH;
            }
            RumSessionScope.StartReason startReason = startReasonFromString;
            if (rumViewTypeFromString == null) {
                rumViewTypeFromString = RumViewType.NONE;
            }
            return new RumContext(str, str9, zBooleanValue2, str3, str4, str5, str6, state, startReason, rumViewTypeFromString, str7, str8, jLongValue, jLongValue2, zBooleanValue, fFloatValue);
        }
    }
}
