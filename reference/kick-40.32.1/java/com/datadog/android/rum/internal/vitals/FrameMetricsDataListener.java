package com.datadog.android.rum.internal.vitals;

import com.datadog.android.rum.internal.domain.FrameMetricsData;
import kotlin.Metadata;

/* JADX INFO: compiled from: FrameMetricsDataListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/FrameMetricsDataListener;", "", "onFrameMetricsData", "", "data", "Lcom/datadog/android/rum/internal/domain/FrameMetricsData;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FrameMetricsDataListener {
    void onFrameMetricsData(FrameMetricsData data);
}
