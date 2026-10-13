package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.io.File;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: BatchFileReader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReader;", "", "readData", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "file", "Ljava/io/File;", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BatchFileReader {
    List<RawBatchEvent> readData(File file, TelemetryContext telemetryContext);
}
