package com.datadog.android.core.internal.persistence.file.advanced;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import kotlin.Metadata;

/* JADX INFO: compiled from: DataMigrator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J/\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u0007H'¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;", ExifInterface.LATITUDE_SOUTH, "", "migrateData", "", "previousState", "previousFileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "newState", "newFileOrchestrator", "(Ljava/lang/Object;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Ljava/lang/Object;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;)V", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DataMigrator<S> {
    void migrateData(S previousState, FileOrchestrator previousFileOrchestrator, S newState, FileOrchestrator newFileOrchestrator);
}
