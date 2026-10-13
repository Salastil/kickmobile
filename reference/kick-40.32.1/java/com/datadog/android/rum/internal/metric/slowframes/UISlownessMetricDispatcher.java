package com.datadog.android.rum.internal.metric.slowframes;

import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import kotlin.Metadata;

/* JADX INFO: compiled from: UISlownessMetricDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/metric/slowframes/UISlownessMetricDispatcher;", "", "incrementIgnoredFrameCount", "", RumEventMeta.VIEW_ID_KEY, "", "incrementMissedFrameCount", "incrementSlowFrameCount", "onViewCreated", "sendMetric", "viewDurationNs", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface UISlownessMetricDispatcher {
    void incrementIgnoredFrameCount(String viewId);

    void incrementMissedFrameCount(String viewId);

    void incrementSlowFrameCount(String viewId);

    void onViewCreated(String viewId);

    void sendMetric(String viewId, long viewDurationNs);
}
