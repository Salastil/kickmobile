package com.datadog.android.rum.internal.metric.slowframes;

import androidx.metrics.performance.FrameData;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.configuration.SlowFramesConfiguration;
import com.datadog.android.rum.internal.domain.FrameMetricsData;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.domain.state.ViewUIPerformanceReport;
import com.datadog.android.rum.internal.domain.state.ms;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SlowFramesListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0010H\u0016J\"\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/datadog/android/rum/internal/metric/slowframes/DefaultSlowFramesListener;", "Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;", "configuration", "Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;", "metricDispatcher", "Lcom/datadog/android/rum/internal/metric/slowframes/UISlownessMetricDispatcher;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "(Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;Lcom/datadog/android/rum/internal/metric/slowframes/UISlownessMetricDispatcher;Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;Lcom/datadog/android/internal/time/TimeProvider;)V", "getConfiguration$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;", "currentViewId", "", "currentViewStartedTimestampNs", "", "getInsightsCollector$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "getMetricDispatcher$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/metric/slowframes/UISlownessMetricDispatcher;", "slowFramesRecords", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/datadog/android/rum/internal/domain/state/ViewUIPerformanceReport;", "getViewPerformanceReport", RumEventMeta.VIEW_ID_KEY, "onAddLongTask", "", "durationNs", "onFrame", "volatileFrameData", "Landroidx/metrics/performance/FrameData;", "onFrameMetricsData", "data", "Lcom/datadog/android/rum/internal/domain/FrameMetricsData;", "onViewCreated", "startedTimestampNs", "resolveReport", "Lcom/datadog/android/rum/internal/domain/state/ViewUIPerformanceReport$Snapshot;", "isViewCompleted", "", "viewDurationNs", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultSlowFramesListener implements SlowFramesListener {
    private final SlowFramesConfiguration configuration;
    private volatile String currentViewId;
    private volatile long currentViewStartedTimestampNs;
    private final InsightsCollector insightsCollector;
    private final UISlownessMetricDispatcher metricDispatcher;
    private final ConcurrentHashMap<String, ViewUIPerformanceReport> slowFramesRecords;

    @Override // com.datadog.android.rum.internal.vitals.FrameMetricsDataListener
    public void onFrameMetricsData(FrameMetricsData data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public DefaultSlowFramesListener(SlowFramesConfiguration configuration, UISlownessMetricDispatcher metricDispatcher, InsightsCollector insightsCollector, TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(metricDispatcher, "metricDispatcher");
        Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.configuration = configuration;
        this.metricDispatcher = metricDispatcher;
        this.insightsCollector = insightsCollector;
        this.currentViewStartedTimestampNs = timeProvider.getDeviceElapsedTimeNanos();
        this.slowFramesRecords = new ConcurrentHashMap<>();
    }

    /* JADX INFO: renamed from: getConfiguration$dd_sdk_android_rum_release, reason: from getter */
    public final SlowFramesConfiguration getConfiguration() {
        return this.configuration;
    }

    /* JADX INFO: renamed from: getMetricDispatcher$dd_sdk_android_rum_release, reason: from getter */
    public final UISlownessMetricDispatcher getMetricDispatcher() {
        return this.metricDispatcher;
    }

    /* JADX INFO: renamed from: getInsightsCollector$dd_sdk_android_rum_release, reason: from getter */
    public final InsightsCollector getInsightsCollector() {
        return this.insightsCollector;
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.SlowFramesListener
    public void onViewCreated(String viewId, long startedTimestampNs) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        this.currentViewId = viewId;
        this.currentViewStartedTimestampNs = startedTimestampNs;
        this.metricDispatcher.onViewCreated(viewId);
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.SlowFramesListener
    public ViewUIPerformanceReport.Snapshot resolveReport(String viewId, boolean isViewCompleted, long viewDurationNs) {
        ViewUIPerformanceReport.Snapshot snapshot;
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        ConcurrentHashMap<String, ViewUIPerformanceReport> concurrentHashMap = this.slowFramesRecords;
        ViewUIPerformanceReport viewUIPerformanceReportRemove = isViewCompleted ? concurrentHashMap.remove(viewId) : concurrentHashMap.get(viewId);
        if (viewUIPerformanceReportRemove == null) {
            return null;
        }
        synchronized (viewUIPerformanceReportRemove) {
            if (isViewCompleted) {
                this.metricDispatcher.sendMetric(viewId, viewDurationNs);
            }
            snapshot = viewUIPerformanceReportRemove.snapshot();
        }
        return snapshot;
    }

    @Override // androidx.metrics.performance.JankStats.OnFrameListener
    public void onFrame(FrameData volatileFrameData) {
        Intrinsics.checkNotNullParameter(volatileFrameData, "volatileFrameData");
        String str = this.currentViewId;
        if (str == null || volatileFrameData.getFrameStartNanos() < this.currentViewStartedTimestampNs) {
            if (str != null) {
                this.metricDispatcher.incrementMissedFrameCount(str);
                return;
            }
            return;
        }
        long frameDurationUiNanos = volatileFrameData.getFrameDurationUiNanos();
        long frameStartNanos = volatileFrameData.getFrameStartNanos();
        ViewUIPerformanceReport viewPerformanceReport = getViewPerformanceReport(str);
        synchronized (viewPerformanceReport) {
            viewPerformanceReport.setTotalFramesDurationNs(viewPerformanceReport.getTotalFramesDurationNs() + frameDurationUiNanos);
            if (frameDurationUiNanos <= this.configuration.getMaxSlowFrameThresholdNs$dd_sdk_android_rum_release() && volatileFrameData.getIsJank()) {
                viewPerformanceReport.setSlowFramesDurationNs(viewPerformanceReport.getSlowFramesDurationNs() + frameDurationUiNanos);
                this.metricDispatcher.incrementSlowFrameCount(str);
                ms lastSlowFrameRecord = viewPerformanceReport.getLastSlowFrameRecord();
                long startTimestampNs = frameStartNanos - (lastSlowFrameRecord != null ? lastSlowFrameRecord.getStartTimestampNs() : frameStartNanos);
                if (lastSlowFrameRecord != null && startTimestampNs <= this.configuration.getContinuousSlowFrameThresholdNs$dd_sdk_android_rum_release()) {
                    lastSlowFrameRecord.setDurationNs(Math.min(lastSlowFrameRecord.getDurationNs() + frameDurationUiNanos, this.configuration.getMaxSlowFrameThresholdNs$dd_sdk_android_rum_release() - 1));
                    this.insightsCollector.onSlowFrame(frameDurationUiNanos);
                } else if (frameDurationUiNanos > 0) {
                    viewPerformanceReport.getSlowFramesRecords().add(new ms(frameStartNanos, frameDurationUiNanos));
                    this.insightsCollector.onSlowFrame(frameDurationUiNanos);
                }
                Unit unit = Unit.INSTANCE;
                return;
            }
            this.metricDispatcher.incrementIgnoredFrameCount(str);
        }
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.SlowFramesListener
    public void onAddLongTask(long durationNs) {
        String str = this.currentViewId;
        if (durationNs < this.configuration.getFreezeDurationThresholdNs$dd_sdk_android_rum_release() || str == null) {
            return;
        }
        ViewUIPerformanceReport viewPerformanceReport = getViewPerformanceReport(str);
        synchronized (viewPerformanceReport) {
            viewPerformanceReport.setFreezeFramesDuration(viewPerformanceReport.getFreezeFramesDuration() + durationNs);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final ViewUIPerformanceReport getViewPerformanceReport(String viewId) {
        final Function0<ViewUIPerformanceReport> function0 = new Function0<ViewUIPerformanceReport>() { // from class: com.datadog.android.rum.internal.metric.slowframes.DefaultSlowFramesListener$getViewPerformanceReport$createLambda$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewUIPerformanceReport invoke() {
                return new ViewUIPerformanceReport(this.this$0.currentViewStartedTimestampNs, this.this$0.getConfiguration().getMaxSlowFramesAmount$dd_sdk_android_rum_release(), this.this$0.getConfiguration().getMinViewLifetimeThresholdNs$dd_sdk_android_rum_release());
            }
        };
        ConcurrentHashMap<String, ViewUIPerformanceReport> concurrentHashMap = this.slowFramesRecords;
        final Function1<String, ViewUIPerformanceReport> function1 = new Function1<String, ViewUIPerformanceReport>() { // from class: com.datadog.android.rum.internal.metric.slowframes.DefaultSlowFramesListener.getViewPerformanceReport.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ViewUIPerformanceReport invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return function0.invoke();
            }
        };
        ViewUIPerformanceReport viewUIPerformanceReportComputeIfAbsent = concurrentHashMap.computeIfAbsent(viewId, new Function() { // from class: com.datadog.android.rum.internal.metric.slowframes.DefaultSlowFramesListener$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DefaultSlowFramesListener.getViewPerformanceReport$lambda$3(function1, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewUIPerformanceReportComputeIfAbsent, "createLambda = {\n       …mbda.invoke() }\n        }");
        return viewUIPerformanceReportComputeIfAbsent;
    }

    static final ViewUIPerformanceReport getViewPerformanceReport$lambda$3(Function1 function1, Object obj) {
        return (ViewUIPerformanceReport) function1.invoke(obj);
    }
}
