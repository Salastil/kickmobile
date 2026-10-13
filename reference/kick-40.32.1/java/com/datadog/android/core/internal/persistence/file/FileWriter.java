package com.datadog.android.core.internal.persistence.file;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: compiled from: FileWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH'¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/FileWriter;", ExifInterface.GPS_DIRECTION_TRUE, "", "writeData", "", "file", "Ljava/io/File;", "data", "append", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "(Ljava/io/File;Ljava/lang/Object;ZLcom/datadog/android/internal/telemetry/TelemetryContext;)Z", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FileWriter<T> {
    boolean writeData(File file, T data, boolean append, TelemetryContext telemetryContext);
}
