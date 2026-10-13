package com.datadog.android.rum.internal.metric.slowframes;

import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpUISlownessMetricDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/internal/metric/slowframes/NoOpUISlownessMetricDispatcher;", "Lcom/datadog/android/rum/internal/metric/slowframes/UISlownessMetricDispatcher;", "()V", "incrementIgnoredFrameCount", "", RumEventMeta.VIEW_ID_KEY, "", "incrementMissedFrameCount", "incrementSlowFrameCount", "onViewCreated", "sendMetric", "viewDurationNs", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpUISlownessMetricDispatcher implements UISlownessMetricDispatcher {
    @Override // com.datadog.android.rum.internal.metric.slowframes.UISlownessMetricDispatcher
    public void incrementIgnoredFrameCount(String viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.UISlownessMetricDispatcher
    public void incrementMissedFrameCount(String viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.UISlownessMetricDispatcher
    public void incrementSlowFrameCount(String viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.UISlownessMetricDispatcher
    public void onViewCreated(String viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.UISlownessMetricDispatcher
    public void sendMetric(String viewId, long viewDurationNs) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
    }
}
