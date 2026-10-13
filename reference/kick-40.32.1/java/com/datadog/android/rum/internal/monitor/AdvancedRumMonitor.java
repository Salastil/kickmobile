package com.datadog.android.rum.internal.monitor;

import android.app.Activity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.heatmaps.CrossPlatformHeatmapActionData;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumPerformanceMetric;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.debug.RumDebugListener;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.heatmaps.NativeHeatmapActionData;
import com.datadog.android.rum.internal.startup.RumAppStartupTelemetryReporterImpl;
import com.datadog.android.rum.internal.startup.RumStartupScenario;
import com.datadog.android.rum.internal.startup.RumTTIDInfo;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: AdvancedRumMonitor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u00012\u00020\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH&J6\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH&J.\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH&J\b\u0010\u001e\u001a\u00020\u0004H&J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H&J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H&J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H&J\n\u0010'\u001a\u0004\u0018\u00010\bH&J\b\u0010(\u001a\u00020\u0004H&J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+H&J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H&J\u0010\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u000201H&J\b\u00102\u001a\u00020\u0004H&J\u0012\u00103\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u000105H&J\u001a\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u00010\rH&J\u0018\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\bH&J\b\u0010<\u001a\u00020\u0004H&J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020?H&J\u0018\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020B2\u0006\u00108\u001a\u00020?H&¨\u0006C"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "Lcom/datadog/android/rum/RumMonitor;", "Lcom/datadog/android/rum/internal/monitor/AdvancedNetworkRumMonitor;", "addActionWithHeatmap", "", "type", "Lcom/datadog/android/rum/RumActionType;", "name", "", "nativeHeatmapActionData", "Lcom/datadog/android/rum/internal/heatmaps/NativeHeatmapActionData;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "addActionWithHeatmapAttributes", "crossPlatformHeatmapActionData", "Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;", "addCrash", "message", "source", "Lcom/datadog/android/rum/RumErrorSource;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "threads", "", "Lcom/datadog/android/core/feature/event/ThreadDump;", "addLongTask", "durationNs", "", TypedValues.Attributes.S_TARGET, "addSessionReplaySkippedFrame", "enableJankStatsTracking", "activity", "Landroid/app/Activity;", "eventDropped", RumEventMeta.VIEW_ID_KEY, "event", "Lcom/datadog/android/rum/internal/monitor/StorageEvent;", "eventSent", "getCurrentViewUrl", "resetSession", "sendAppStartEvent", RumAppStartupTelemetryReporterImpl.KEY_SCENARIO, "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "sendTTIDEvent", "info", "Lcom/datadog/android/rum/internal/startup/RumTTIDInfo;", "sendTelemetryEvent", "telemetryEvent", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "sendWebViewEvent", "setDebugListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/datadog/android/rum/internal/debug/RumDebugListener;", "setInternalViewAttribute", "key", "value", "setSyntheticsAttribute", "testId", "resultId", ViewProps.START, "updateExternalRefreshRate", "frameTimeSeconds", "", "updatePerformanceMetric", "metric", "Lcom/datadog/android/rum/RumPerformanceMetric;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AdvancedRumMonitor extends RumMonitor, AdvancedNetworkRumMonitor {
    void addActionWithHeatmap(RumActionType type, String name, NativeHeatmapActionData nativeHeatmapActionData, Map<String, ? extends Object> attributes);

    void addActionWithHeatmapAttributes(RumActionType type, String name, CrossPlatformHeatmapActionData crossPlatformHeatmapActionData, Map<String, ? extends Object> attributes);

    void addCrash(String message, RumErrorSource source, Throwable throwable, List<ThreadDump> threads);

    void addLongTask(long durationNs, String target);

    void addSessionReplaySkippedFrame();

    void enableJankStatsTracking(Activity activity);

    void eventDropped(String viewId, StorageEvent event);

    void eventSent(String viewId, StorageEvent event);

    String getCurrentViewUrl();

    void resetSession();

    void sendAppStartEvent(RumStartupScenario scenario);

    void sendTTIDEvent(RumTTIDInfo info);

    void sendTelemetryEvent(InternalTelemetryEvent telemetryEvent);

    void sendWebViewEvent();

    void setDebugListener(RumDebugListener listener);

    void setInternalViewAttribute(String key, Object value);

    void setSyntheticsAttribute(String testId, String resultId);

    void start();

    void updateExternalRefreshRate(double frameTimeSeconds);

    void updatePerformanceMetric(RumPerformanceMetric metric, double value);
}
