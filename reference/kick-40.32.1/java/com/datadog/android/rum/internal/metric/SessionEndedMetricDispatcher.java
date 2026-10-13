package com.datadog.android.rum.internal.metric;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.internal.domain.scope.RumViewManagerScope;
import com.datadog.android.rum.model.ViewEvent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionEndedMetricDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u001c\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/datadog/android/rum/internal/metric/SessionEndedMetricDispatcher;", "Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "sessionSamplingRate", "", "(Lcom/datadog/android/api/InternalLogger;F)V", "metricsBySessionId", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/datadog/android/rum/internal/metric/SessionEndedMetric;", "buildSdkErrorTrackError", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "errorKind", "buildViewTrackError", "viewEvent", "Lcom/datadog/android/rum/model/ViewEvent;", "endMetric", "", "ntpOffsetAtEndMs", "", "onMissedEventTracked", "missedEventType", "Lcom/datadog/android/rum/internal/metric/SessionEndedMetric$MissedEventType;", "onSdkErrorTracked", "onSessionReplaySkippedFrameTracked", "onSessionStopped", "onViewTracked", "startMetric", "startReason", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;", "ntpOffsetAtStartMs", "backgroundEventTracking", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SessionEndedMetricDispatcher implements SessionMetricDispatcher {
    private final InternalLogger internalLogger;
    private final ConcurrentHashMap<String, SessionEndedMetric> metricsBySessionId;
    private final float sessionSamplingRate;

    public SessionEndedMetricDispatcher(InternalLogger internalLogger, float f) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
        this.sessionSamplingRate = f;
        this.metricsBySessionId = new ConcurrentHashMap<>();
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void startMetric(String sessionId, RumSessionScope.StartReason startReason, long ntpOffsetAtStartMs, boolean backgroundEventTracking) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(startReason, "startReason");
        this.metricsBySessionId.put(sessionId, new SessionEndedMetric(sessionId, startReason, ntpOffsetAtStartMs, backgroundEventTracking));
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void endMetric(String sessionId, long ntpOffsetAtEndMs) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SessionEndedMetric sessionEndedMetricRemove = this.metricsBySessionId.remove(sessionId);
        if (sessionEndedMetricRemove != null) {
            this.internalLogger.logMetric(new Function0<String>() { // from class: com.datadog.android.rum.internal.metric.SessionEndedMetricDispatcher$endMetric$1$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return SessionEndedMetric.RUM_SESSION_ENDED_METRIC_NAME;
                }
            }, sessionEndedMetricRemove.toMetricAttributes(ntpOffsetAtEndMs), 15.0f, Float.valueOf(this.sessionSamplingRate));
        }
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onSessionStopped(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SessionEndedMetric sessionEndedMetric = this.metricsBySessionId.get(sessionId);
        if (sessionEndedMetric != null) {
            sessionEndedMetric.onSessionStopped();
        }
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onViewTracked(final String sessionId, final ViewEvent viewEvent) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(viewEvent, "viewEvent");
        SessionEndedMetric sessionEndedMetric = this.metricsBySessionId.get(sessionId);
        if (sessionEndedMetric != null ? sessionEndedMetric.onViewTracked(viewEvent) : false) {
            return;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.metric.SessionEndedMetricDispatcher.onViewTracked.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return SessionEndedMetricDispatcher.this.buildViewTrackError(sessionId, viewEvent);
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onSdkErrorTracked(final String sessionId, final String errorKind) {
        Unit unit;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SessionEndedMetric sessionEndedMetric = this.metricsBySessionId.get(sessionId);
        if (sessionEndedMetric != null) {
            sessionEndedMetric.onErrorTracked(errorKind);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.metric.SessionEndedMetricDispatcher.onSdkErrorTracked.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return SessionEndedMetricDispatcher.this.buildSdkErrorTrackError(sessionId, errorKind);
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onMissedEventTracked(String sessionId, SessionEndedMetric.MissedEventType missedEventType) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(missedEventType, "missedEventType");
        SessionEndedMetric sessionEndedMetric = this.metricsBySessionId.get(sessionId);
        if (sessionEndedMetric != null) {
            sessionEndedMetric.onMissedEventTracked(missedEventType);
        }
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onSessionReplaySkippedFrameTracked(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SessionEndedMetric sessionEndedMetric = this.metricsBySessionId.get(sessionId);
        if (sessionEndedMetric != null) {
            sessionEndedMetric.onSessionReplaySkippedFrameTracked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildSdkErrorTrackError(String sessionId, String errorKind) {
        return "Failed to track " + errorKind + " error, session " + sessionId + " has ended";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildViewTrackError(String sessionId, ViewEvent viewEvent) {
        String str;
        String url = viewEvent.getView().getUrl();
        if (Intrinsics.areEqual(url, RumViewManagerScope.RUM_APP_LAUNCH_VIEW_URL)) {
            str = "AppLaunch";
        } else {
            str = Intrinsics.areEqual(url, RumViewManagerScope.RUM_BACKGROUND_VIEW_URL) ? RumViewManagerScope.RUM_BACKGROUND_VIEW_NAME : "Custom";
        }
        return "Failed to track " + str + " view in session with different UUID " + sessionId;
    }
}
