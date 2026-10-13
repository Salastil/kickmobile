package com.datadog.android.core.internal.persistence.file;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: compiled from: FileReader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/FileReader;", ExifInterface.GPS_DIRECTION_TRUE, "", "readData", "file", "Ljava/io/File;", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "(Ljava/io/File;Lcom/datadog/android/internal/telemetry/TelemetryContext;)Ljava/lang/Object;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FileReader<T> {
    T readData(File file, TelemetryContext telemetryContext);
}
