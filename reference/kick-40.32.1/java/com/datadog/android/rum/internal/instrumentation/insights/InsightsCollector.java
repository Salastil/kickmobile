package com.datadog.android.rum.internal.instrumentation.insights;

import com.datadog.android.api.feature.FeatureSdkCore;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: compiled from: InsightsCollector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u000fH&J\u0017\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\tH&J\u0017\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\tH&J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\tH&J\u0017\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0002\u0010\u0019J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H&J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006("}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "", "maxSize", "", "getMaxSize", "()I", "setMaxSize", "(I)V", "updateIntervalMs", "", "getUpdateIntervalMs", "()J", "setUpdateIntervalMs", "(J)V", "addUpdateListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsUpdatesListener;", "bindSdkCore", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "onAction", "onCpuVital", "cpuTicks", "", "(Ljava/lang/Double;)V", "onLongTask", "durationNs", "onMemoryVital", "memoryValue", "onNetworkRequest", "onNewView", "name", "", "onSlowFrame", "onSlowFrameRate", "rate", "onTimeseries", "removeUpdateListener", "unbindSdkCore", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface InsightsCollector {
    void addUpdateListener(InsightsUpdatesListener listener);

    void bindSdkCore(FeatureSdkCore sdkCore);

    int getMaxSize();

    long getUpdateIntervalMs();

    void onAction();

    void onCpuVital(Double cpuTicks);

    void onLongTask(long durationNs);

    void onMemoryVital(Double memoryValue);

    void onNetworkRequest(long durationNs);

    void onNewView(String name);

    void onSlowFrame(long durationNs);

    void onSlowFrameRate(Double rate);

    void onTimeseries(String name);

    void removeUpdateListener(InsightsUpdatesListener listener);

    void setMaxSize(int i);

    void setUpdateIntervalMs(long j);

    void unbindSdkCore(FeatureSdkCore sdkCore);
}
