package com.datadog.android.core.internal.persistence.file.single;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleFileOrchestrator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0017J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0017J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0017J\u0018\u0010\r\u001a\u0004\u0018\u00010\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0017J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0017J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/single/SingleFileOrchestrator;", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "file", "Ljava/io/File;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Ljava/io/File;Lcom/datadog/android/api/InternalLogger;)V", "decrementAndGetPendingFilesCount", "", "getAllFiles", "", "getFlushableFiles", "getMetadataFile", "getReadableFile", "excludeFiles", "", "getRootDir", "getWritableFile", "eventSize", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SingleFileOrchestrator implements FileOrchestrator {
    private final File file;
    private final InternalLogger internalLogger;

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public int decrementAndGetPendingFilesCount() {
        return 0;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getMetadataFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getRootDir() {
        return null;
    }

    public SingleFileOrchestrator(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.file = file;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getWritableFile(long eventSize) {
        File parentFile = this.file.getParentFile();
        if (parentFile != null) {
            FileExtKt.mkdirsSafe(parentFile, this.internalLogger);
        }
        return this.file;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getReadableFile(Set<? extends File> excludeFiles) {
        Intrinsics.checkNotNullParameter(excludeFiles, "excludeFiles");
        File parentFile = this.file.getParentFile();
        if (parentFile != null) {
            FileExtKt.mkdirsSafe(parentFile, this.internalLogger);
        }
        if (excludeFiles.contains(this.file)) {
            return null;
        }
        return this.file;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List<File> getAllFiles() {
        File parentFile = this.file.getParentFile();
        if (parentFile != null) {
            FileExtKt.mkdirsSafe(parentFile, this.internalLogger);
        }
        return CollectionsKt.listOf(this.file);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List<File> getFlushableFiles() {
        return getAllFiles();
    }
}
