package com.datadog.android.rum.internal.metric.slowframes;

import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.domain.state.ViewUIPerformanceReport;
import com.datadog.android.rum.internal.vitals.FrameStateListener;
import kotlin.Metadata;

/* JADX INFO: compiled from: SlowFramesListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;", "Lcom/datadog/android/rum/internal/vitals/FrameStateListener;", "onAddLongTask", "", "durationNs", "", "onViewCreated", RumEventMeta.VIEW_ID_KEY, "", "startedTimestampNs", "resolveReport", "Lcom/datadog/android/rum/internal/domain/state/ViewUIPerformanceReport$Snapshot;", "isViewCompleted", "", "viewDurationNs", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SlowFramesListener extends FrameStateListener {
    void onAddLongTask(long durationNs);

    void onViewCreated(String viewId, long startedTimestampNs);

    ViewUIPerformanceReport.Snapshot resolveReport(String viewId, boolean isViewCompleted, long viewDurationNs);
}
