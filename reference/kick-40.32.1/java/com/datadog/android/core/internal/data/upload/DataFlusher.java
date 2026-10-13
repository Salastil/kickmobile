package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.ContextProvider;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileMover;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FileReader;
import com.datadog.android.core.internal.persistence.file.batch.BatchFileReader;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataFlusher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/datadog/android/core/internal/data/upload/DataFlusher;", "Lcom/datadog/android/core/internal/data/upload/Flusher;", "contextProvider", "Lcom/datadog/android/core/internal/ContextProvider;", "fileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "fileReader", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReader;", "metadataFileReader", "Lcom/datadog/android/core/internal/persistence/file/FileReader;", "", "fileMover", "Lcom/datadog/android/core/internal/persistence/file/FileMover;", "featureName", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/core/internal/ContextProvider;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReader;Lcom/datadog/android/core/internal/persistence/file/FileReader;Lcom/datadog/android/core/internal/persistence/file/FileMover;Ljava/lang/String;Lcom/datadog/android/api/InternalLogger;)V", "getContextProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/ContextProvider;", "getFileMover$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileMover;", "getFileOrchestrator$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "getFileReader$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReader;", "getMetadataFileReader$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileReader;", "flush", "", "uploader", "Lcom/datadog/android/core/internal/data/upload/DataUploader;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataFlusher implements Flusher {
    private final ContextProvider contextProvider;
    private final String featureName;
    private final FileMover fileMover;
    private final FileOrchestrator fileOrchestrator;
    private final BatchFileReader fileReader;
    private final InternalLogger internalLogger;
    private final FileReader<byte[]> metadataFileReader;

    public DataFlusher(ContextProvider contextProvider, FileOrchestrator fileOrchestrator, BatchFileReader fileReader, FileReader<byte[]> metadataFileReader, FileMover fileMover, String featureName, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(fileReader, "fileReader");
        Intrinsics.checkNotNullParameter(metadataFileReader, "metadataFileReader");
        Intrinsics.checkNotNullParameter(fileMover, "fileMover");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.contextProvider = contextProvider;
        this.fileOrchestrator = fileOrchestrator;
        this.fileReader = fileReader;
        this.metadataFileReader = metadataFileReader;
        this.fileMover = fileMover;
        this.featureName = featureName;
        this.internalLogger = internalLogger;
    }

    /* JADX INFO: renamed from: getContextProvider$dd_sdk_android_core_release, reason: from getter */
    public final ContextProvider getContextProvider() {
        return this.contextProvider;
    }

    /* JADX INFO: renamed from: getFileOrchestrator$dd_sdk_android_core_release, reason: from getter */
    public final FileOrchestrator getFileOrchestrator() {
        return this.fileOrchestrator;
    }

    /* JADX INFO: renamed from: getFileReader$dd_sdk_android_core_release, reason: from getter */
    public final BatchFileReader getFileReader() {
        return this.fileReader;
    }

    public final FileReader<byte[]> getMetadataFileReader$dd_sdk_android_core_release() {
        return this.metadataFileReader;
    }

    /* JADX INFO: renamed from: getFileMover$dd_sdk_android_core_release, reason: from getter */
    public final FileMover getFileMover() {
        return this.fileMover;
    }

    @Override // com.datadog.android.core.internal.data.upload.Flusher
    public void flush(DataUploader uploader) {
        Intrinsics.checkNotNullParameter(uploader, "uploader");
        DatadogContext context = this.contextProvider.getContext(SetsKt.emptySet());
        for (File file : this.fileOrchestrator.getFlushableFiles()) {
            byte[] data = null;
            TelemetryContext telemetryContext = new TelemetryContext(this.featureName, null, 2, null);
            List<RawBatchEvent> data2 = this.fileReader.readData(file, telemetryContext);
            File metadataFile = this.fileOrchestrator.getMetadataFile(file);
            if (metadataFile != null && FileExtKt.existsSafe(metadataFile, this.internalLogger)) {
                data = this.metadataFileReader.readData(metadataFile, telemetryContext);
            }
            DataUploader dataUploader = uploader;
            DataUploader.DefaultImpls.upload$default(dataUploader, context, data2, data, null, 8, null);
            this.fileMover.delete(file);
            if (metadataFile != null && FileExtKt.existsSafe(metadataFile, this.internalLogger)) {
                this.fileMover.delete(metadataFile);
            }
            uploader = dataUploader;
        }
    }
}
