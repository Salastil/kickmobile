package com.datadog.android.rum.internal.metric;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.model.ViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpSessionMetricDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/internal/metric/NoOpSessionMetricDispatcher;", "Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;", "()V", "endMetric", "", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "", "ntpOffsetAtEndMs", "", "onMissedEventTracked", "missedEventType", "Lcom/datadog/android/rum/internal/metric/SessionEndedMetric$MissedEventType;", "onSdkErrorTracked", "errorKind", "onSessionReplaySkippedFrameTracked", "onSessionStopped", "onViewTracked", "viewEvent", "Lcom/datadog/android/rum/model/ViewEvent;", "startMetric", "startReason", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;", "ntpOffsetAtStartMs", "backgroundEventTracking", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpSessionMetricDispatcher implements SessionMetricDispatcher {
    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void endMetric(String sessionId, long ntpOffsetAtEndMs) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onMissedEventTracked(String sessionId, SessionEndedMetric.MissedEventType missedEventType) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(missedEventType, "missedEventType");
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onSdkErrorTracked(String sessionId, String errorKind) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onSessionReplaySkippedFrameTracked(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onSessionStopped(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onViewTracked(String sessionId, ViewEvent viewEvent) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(viewEvent, "viewEvent");
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void startMetric(String sessionId, RumSessionScope.StartReason startReason, long ntpOffsetAtStartMs, boolean backgroundEventTracking) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(startReason, "startReason");
    }
}
