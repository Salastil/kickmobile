package com.datadog.android.rum.internal.vitals;

import androidx.metrics.performance.JankStats;
import kotlin.Metadata;

/* JADX INFO: compiled from: FrameStateListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/FrameStateListener;", "Landroidx/metrics/performance/JankStats$OnFrameListener;", "Lcom/datadog/android/rum/internal/vitals/FrameMetricsDataListener;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FrameStateListener extends JankStats.OnFrameListener, FrameMetricsDataListener {
}
