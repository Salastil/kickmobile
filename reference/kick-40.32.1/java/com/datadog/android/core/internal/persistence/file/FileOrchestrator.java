package com.datadog.android.core.internal.persistence.file;

import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: FileOrchestrator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH'J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H'J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H'¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "", "decrementAndGetPendingFilesCount", "", "getAllFiles", "", "Ljava/io/File;", "getFlushableFiles", "getMetadataFile", "file", "getReadableFile", "excludeFiles", "", "getRootDir", "getWritableFile", "eventSize", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FileOrchestrator {
    int decrementAndGetPendingFilesCount();

    List<File> getAllFiles();

    List<File> getFlushableFiles();

    File getMetadataFile(File file);

    File getReadableFile(Set<? extends File> excludeFiles);

    File getRootDir();

    File getWritableFile(long eventSize);
}
