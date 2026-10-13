package com.datadog.android.core.internal.metrics;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpMetricsDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/core/internal/metrics/NoOpMetricsDispatcher;", "Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;", "()V", "sendBatchClosedMetric", "", "batchFile", "Ljava/io/File;", "batchMetadata", "Lcom/datadog/android/core/internal/metrics/BatchClosedMetadata;", "sendBatchDeletedMetric", "removalReason", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "numPendingBatches", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpMetricsDispatcher implements MetricsDispatcher {
    @Override // com.datadog.android.core.internal.metrics.MetricsDispatcher
    public void sendBatchClosedMetric(File batchFile, BatchClosedMetadata batchMetadata) {
        Intrinsics.checkNotNullParameter(batchFile, "batchFile");
        Intrinsics.checkNotNullParameter(batchMetadata, "batchMetadata");
    }

    @Override // com.datadog.android.core.internal.metrics.MetricsDispatcher
    public void sendBatchDeletedMetric(File batchFile, RemovalReason removalReason, int numPendingBatches) {
        Intrinsics.checkNotNullParameter(batchFile, "batchFile");
        Intrinsics.checkNotNullParameter(removalReason, "removalReason");
    }
}
