package com.datadog.android.rum.internal.instrumentation.insights;

import com.datadog.android.api.feature.FeatureSdkCore;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpInsightsCollector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0017\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0017\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0017\u0010$\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010&\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006)"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/insights/NoOpInsightsCollector;", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "()V", "maxSize", "", "getMaxSize", "()I", "setMaxSize", "(I)V", "updateIntervalMs", "", "getUpdateIntervalMs", "()J", "setUpdateIntervalMs", "(J)V", "addUpdateListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsUpdatesListener;", "bindSdkCore", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "onAction", "onCpuVital", "cpuTicks", "", "(Ljava/lang/Double;)V", "onLongTask", "durationNs", "onMemoryVital", "memoryValue", "onNetworkRequest", "onNewView", "name", "", "onSlowFrame", "onSlowFrameRate", "rate", "onTimeseries", "removeUpdateListener", "unbindSdkCore", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpInsightsCollector implements InsightsCollector {
    private int maxSize;
    private long updateIntervalMs;

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void addUpdateListener(InsightsUpdatesListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void bindSdkCore(FeatureSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void onAction() {
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void onCpuVital(Double cpuTicks) {
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void onLongTask(long durationNs) {
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void onMemoryVital(Double memoryValue) {
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void onNetworkRequest(long durationNs) {
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void onNewView(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void onSlowFrame(long durationNs) {
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void onSlowFrameRate(Double rate) {
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void onTimeseries(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void removeUpdateListener(InsightsUpdatesListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void unbindSdkCore(FeatureSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void setMaxSize(int i) {
        this.maxSize = i;
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public long getUpdateIntervalMs() {
        return this.updateIntervalMs;
    }

    @Override // com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector
    public void setUpdateIntervalMs(long j) {
        this.updateIntervalMs = j;
    }
}
