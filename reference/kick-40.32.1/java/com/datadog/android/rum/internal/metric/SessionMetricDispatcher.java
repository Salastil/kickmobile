package com.datadog.android.rum.internal.metric;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.model.ViewEvent;
import kotlin.Metadata;

/* JADX INFO: compiled from: SessionMetricDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\ba\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;", "", "endMetric", "", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "", "ntpOffsetAtEndMs", "", "onMissedEventTracked", "missedEventType", "Lcom/datadog/android/rum/internal/metric/SessionEndedMetric$MissedEventType;", "onSdkErrorTracked", "errorKind", "onSessionReplaySkippedFrameTracked", "onSessionStopped", "onViewTracked", "viewEvent", "Lcom/datadog/android/rum/model/ViewEvent;", "startMetric", "startReason", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;", "ntpOffsetAtStartMs", "backgroundEventTracking", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SessionMetricDispatcher {
    void endMetric(String sessionId, long ntpOffsetAtEndMs);

    void onMissedEventTracked(String sessionId, SessionEndedMetric.MissedEventType missedEventType);

    void onSdkErrorTracked(String sessionId, String errorKind);

    void onSessionReplaySkippedFrameTracked(String sessionId);

    void onSessionStopped(String sessionId);

    void onViewTracked(String sessionId, ViewEvent viewEvent);

    void startMetric(String sessionId, RumSessionScope.StartReason startReason, long ntpOffsetAtStartMs, boolean backgroundEventTracking);
}
