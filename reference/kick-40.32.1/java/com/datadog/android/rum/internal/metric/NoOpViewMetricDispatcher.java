package com.datadog.android.rum.internal.metric;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpViewMetricDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/internal/metric/NoOpViewMetricDispatcher;", "Lcom/datadog/android/rum/internal/metric/ViewMetricDispatcher;", "()V", "onDurationResolved", "", "newDuration", "", "onViewLoadingTimeResolved", "newLoadingTime", "sendViewEnded", "invState", "Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsState;", "tnsState", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpViewMetricDispatcher implements ViewMetricDispatcher {
    @Override // com.datadog.android.rum.internal.metric.ViewMetricDispatcher
    public void onDurationResolved(long newDuration) {
    }

    @Override // com.datadog.android.rum.internal.metric.ViewMetricDispatcher
    public void onViewLoadingTimeResolved(long newLoadingTime) {
    }

    @Override // com.datadog.android.rum.internal.metric.ViewMetricDispatcher
    public void sendViewEnded(ViewInitializationMetricsState invState, ViewInitializationMetricsState tnsState) {
        Intrinsics.checkNotNullParameter(invState, "invState");
        Intrinsics.checkNotNullParameter(tnsState, "tnsState");
    }
}
