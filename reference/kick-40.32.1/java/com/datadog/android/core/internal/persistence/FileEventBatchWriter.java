package com.datadog.android.core.internal.persistence;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.FileReaderWriter;
import com.datadog.android.core.internal.persistence.file.batch.BatchFileReaderWriter;
import com.datadog.android.core.internal.storage.TelemetryAwareEventBatchWriter;
import com.datadog.android.internal.telemetry.TelemetryContext;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileEventBatchWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J*\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0003R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/datadog/android/core/internal/persistence/FileEventBatchWriter;", "Lcom/datadog/android/core/internal/storage/TelemetryAwareEventBatchWriter;", "featureName", "", "fileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "eventsWriter", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;", "metadataReaderWriter", "Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;", "filePersistenceConfig", "Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "batchWriteEventListener", "Lcom/datadog/android/core/internal/persistence/BatchWriteEventListener;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Ljava/lang/String;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;Lcom/datadog/android/core/internal/persistence/BatchWriteEventListener;Lcom/datadog/android/api/InternalLogger;)V", "checkEventSize", "", "eventSize", "", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "write", "event", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMetadata", "", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Lcom/datadog/android/api/storage/EventType;", "writeBatchMetadata", "", "metadataFile", "Ljava/io/File;", "metadata", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileEventBatchWriter implements TelemetryAwareEventBatchWriter {
    public static final String ERROR_LARGE_DATA = "Can't write data - too big.";
    public static final String NO_BATCH_FILE_AVAILABLE = "No batch file available";
    public static final String WARNING_METADATA_WRITE_FAILED = "Unable to write metadata file: %s";
    private final BatchWriteEventListener batchWriteEventListener;
    private final BatchFileReaderWriter eventsWriter;
    private final String featureName;
    private final FileOrchestrator fileOrchestrator;
    private final FilePersistenceConfig filePersistenceConfig;
    private final InternalLogger internalLogger;
    private final FileReaderWriter metadataReaderWriter;

    public FileEventBatchWriter(String featureName, FileOrchestrator fileOrchestrator, BatchFileReaderWriter eventsWriter, FileReaderWriter metadataReaderWriter, FilePersistenceConfig filePersistenceConfig, BatchWriteEventListener batchWriteEventListener, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(eventsWriter, "eventsWriter");
        Intrinsics.checkNotNullParameter(metadataReaderWriter, "metadataReaderWriter");
        Intrinsics.checkNotNullParameter(filePersistenceConfig, "filePersistenceConfig");
        Intrinsics.checkNotNullParameter(batchWriteEventListener, "batchWriteEventListener");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.featureName = featureName;
        this.fileOrchestrator = fileOrchestrator;
        this.eventsWriter = eventsWriter;
        this.metadataReaderWriter = metadataReaderWriter;
        this.filePersistenceConfig = filePersistenceConfig;
        this.batchWriteEventListener = batchWriteEventListener;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.api.storage.EventBatchWriter
    public boolean write(RawBatchEvent event, byte[] batchMetadata, EventType eventType) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return write(event, batchMetadata, eventType, new TelemetryContext(this.featureName, null, 2, null));
    }

    @Override // com.datadog.android.core.internal.storage.TelemetryAwareEventBatchWriter
    public boolean write(RawBatchEvent event, byte[] batchMetadata, EventType eventType, TelemetryContext telemetryContext) {
        byte[] bArrSerializeToBytes;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        if (event.getData().length == 0) {
            return true;
        }
        if (!checkEventSize(event.getData().length, telemetryContext) || (bArrSerializeToBytes = this.eventsWriter.serializeToBytes(event, telemetryContext)) == null) {
            return false;
        }
        File writableFile = this.fileOrchestrator.getWritableFile(bArrSerializeToBytes.length);
        if (writableFile == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.FileEventBatchWriter.write.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return FileEventBatchWriter.NO_BATCH_FILE_AVAILABLE;
                }
            }, (Throwable) null, false, TelemetryContext.asAttributesMap$default(telemetryContext, event.getData().length, null, 2, null), 24, (Object) null);
            return false;
        }
        File metadataFile = this.fileOrchestrator.getMetadataFile(writableFile);
        if (!this.eventsWriter.writeBinaryData(writableFile, bArrSerializeToBytes, true, telemetryContext)) {
            return false;
        }
        this.batchWriteEventListener.onWriteEvent(event.getData().length);
        if (batchMetadata != null) {
            if ((!(batchMetadata.length == 0)) && metadataFile != null) {
                writeBatchMetadata(metadataFile, batchMetadata, telemetryContext);
            }
        }
        return true;
    }

    private final boolean checkEventSize(int eventSize, TelemetryContext telemetryContext) {
        if (eventSize <= this.filePersistenceConfig.getMaxItemSize()) {
            return true;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.FileEventBatchWriter.checkEventSize.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return FileEventBatchWriter.ERROR_LARGE_DATA;
            }
        }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(eventSize, TuplesKt.to(TelemetryContext.TELEMETRY_DATA_LIMIT, Long.valueOf(this.filePersistenceConfig.getMaxItemSize()))), 24, (Object) null);
        return false;
    }

    private final void writeBatchMetadata(final File metadataFile, byte[] metadata, TelemetryContext telemetryContext) {
        if (this.metadataReaderWriter.writeData(metadataFile, metadata, false, telemetryContext)) {
            return;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.FileEventBatchWriter.writeBatchMetadata.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, FileEventBatchWriter.WARNING_METADATA_WRITE_FAILED, Arrays.copyOf(new Object[]{metadataFile.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }
}
