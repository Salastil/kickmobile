package com.datadog.android.rum.internal.metric;

import kotlin.Metadata;

/* JADX INFO: compiled from: ViewMetricDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/metric/ViewMetricDispatcher;", "", "onDurationResolved", "", "newDuration", "", "onViewLoadingTimeResolved", "newLoadingTime", "sendViewEnded", "invState", "Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsState;", "tnsState", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ViewMetricDispatcher {
    void onDurationResolved(long newDuration);

    void onViewLoadingTimeResolved(long newLoadingTime);

    void sendViewEnded(ViewInitializationMetricsState invState, ViewInitializationMetricsState tnsState);
}
