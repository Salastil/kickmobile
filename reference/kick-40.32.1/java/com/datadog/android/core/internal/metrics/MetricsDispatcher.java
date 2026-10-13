package com.datadog.android.core.internal.metrics;

import java.io.File;
import kotlin.Metadata;

/* JADX INFO: compiled from: MetricsDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\ba\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;", "", "sendBatchClosedMetric", "", "batchFile", "Ljava/io/File;", "batchMetadata", "Lcom/datadog/android/core/internal/metrics/BatchClosedMetadata;", "sendBatchDeletedMetric", "removalReason", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "numPendingBatches", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MetricsDispatcher {
    void sendBatchClosedMetric(File batchFile, BatchClosedMetadata batchMetadata);

    void sendBatchDeletedMetric(File batchFile, RemovalReason removalReason, int numPendingBatches);
}
