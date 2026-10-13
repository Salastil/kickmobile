package com.datadog.android.core.internal.persistence;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.internal.metrics.BenchmarkUploads;
import com.datadog.android.core.internal.metrics.MetricsDispatcher;
import com.datadog.android.core.internal.metrics.RemovalReason;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileMover;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.FileReaderWriter;
import com.datadog.android.core.internal.persistence.file.batch.BatchFileReaderWriter;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.internal.telemetry.TelemetryContext;
import com.datadog.android.privacy.TrackingConsent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentAwareStorage.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0002@AB_\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0017J\u0018\u0010)\u001a\u00020$2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020(H\u0003J\"\u0010)\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010,\u001a\u00020(H\u0003J\u0018\u00100\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0006\u0010,\u001a\u00020(H\u0003J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020.H\u0003J\b\u00103\u001a\u00020$H\u0017J,\u00104\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020$05\u0012\u0004\u0012\u00020$05j\u0002`72\u0006\u00108\u001a\u000209H\u0017J\u0010\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0017J\u0012\u0010?\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u000209H\u0003R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/datadog/android/core/internal/persistence/ConsentAwareStorage;", "Lcom/datadog/android/core/internal/persistence/Storage;", "Lcom/datadog/android/core/internal/persistence/BatchWriteEventListener;", "executorService", "Ljava/util/concurrent/ExecutorService;", "grantedOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "pendingOrchestrator", "batchEventsReaderWriter", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;", "batchMetadataReaderWriter", "Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;", "fileMover", "Lcom/datadog/android/core/internal/persistence/file/FileMover;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "filePersistenceConfig", "Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "metricsDispatcher", "Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;", "featureName", "", "benchmarkUploads", "Lcom/datadog/android/core/internal/metrics/BenchmarkUploads;", "(Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;Lcom/datadog/android/core/internal/persistence/file/FileMover;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;Ljava/lang/String;Lcom/datadog/android/core/internal/metrics/BenchmarkUploads;)V", "getFilePersistenceConfig$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "getGrantedOrchestrator$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "lockedReadBatches", "", "Lcom/datadog/android/core/internal/persistence/ConsentAwareStorage$Batch;", "getPendingOrchestrator$dd_sdk_android_core_release", "writeLock", "", "confirmBatchRead", "", "batchId", "Lcom/datadog/android/core/internal/persistence/BatchId;", "removalReason", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "deleteBatch", "", "batch", "reason", "batchFile", "Ljava/io/File;", "metaFile", "deleteBatchFile", "deleteBatchMetadataFile", "metadataFile", "dropAll", "getEventWriteScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "onWriteEvent", "bytes", "", "readNextBatch", "Lcom/datadog/android/core/internal/persistence/BatchData;", "resolveOrchestrator", "Batch", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConsentAwareStorage implements Storage, BatchWriteEventListener {
    public static final String WARNING_DELETE_FAILED = "Unable to delete file: %s";
    private final BatchFileReaderWriter batchEventsReaderWriter;
    private final FileReaderWriter batchMetadataReaderWriter;
    private final BenchmarkUploads benchmarkUploads;
    private final ExecutorService executorService;
    private final String featureName;
    private final FileMover fileMover;
    private final FilePersistenceConfig filePersistenceConfig;
    private final FileOrchestrator grantedOrchestrator;
    private final InternalLogger internalLogger;
    private final Set<Batch> lockedReadBatches;
    private final MetricsDispatcher metricsDispatcher;
    private final FileOrchestrator pendingOrchestrator;
    private final Object writeLock;

    /* JADX INFO: compiled from: ConsentAwareStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TrackingConsent.values().length];
            try {
                iArr[TrackingConsent.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TrackingConsent.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TrackingConsent.NOT_GRANTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ConsentAwareStorage(ExecutorService executorService, FileOrchestrator grantedOrchestrator, FileOrchestrator pendingOrchestrator, BatchFileReaderWriter batchEventsReaderWriter, FileReaderWriter batchMetadataReaderWriter, FileMover fileMover, InternalLogger internalLogger, FilePersistenceConfig filePersistenceConfig, MetricsDispatcher metricsDispatcher, String featureName, BenchmarkUploads benchmarkUploads) {
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(grantedOrchestrator, "grantedOrchestrator");
        Intrinsics.checkNotNullParameter(pendingOrchestrator, "pendingOrchestrator");
        Intrinsics.checkNotNullParameter(batchEventsReaderWriter, "batchEventsReaderWriter");
        Intrinsics.checkNotNullParameter(batchMetadataReaderWriter, "batchMetadataReaderWriter");
        Intrinsics.checkNotNullParameter(fileMover, "fileMover");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(filePersistenceConfig, "filePersistenceConfig");
        Intrinsics.checkNotNullParameter(metricsDispatcher, "metricsDispatcher");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(benchmarkUploads, "benchmarkUploads");
        this.executorService = executorService;
        this.grantedOrchestrator = grantedOrchestrator;
        this.pendingOrchestrator = pendingOrchestrator;
        this.batchEventsReaderWriter = batchEventsReaderWriter;
        this.batchMetadataReaderWriter = batchMetadataReaderWriter;
        this.fileMover = fileMover;
        this.internalLogger = internalLogger;
        this.filePersistenceConfig = filePersistenceConfig;
        this.metricsDispatcher = metricsDispatcher;
        this.featureName = featureName;
        this.benchmarkUploads = benchmarkUploads;
        this.lockedReadBatches = new LinkedHashSet();
        this.writeLock = new Object();
    }

    /* JADX INFO: renamed from: getGrantedOrchestrator$dd_sdk_android_core_release, reason: from getter */
    public final FileOrchestrator getGrantedOrchestrator() {
        return this.grantedOrchestrator;
    }

    /* JADX INFO: renamed from: getPendingOrchestrator$dd_sdk_android_core_release, reason: from getter */
    public final FileOrchestrator getPendingOrchestrator() {
        return this.pendingOrchestrator;
    }

    /* JADX INFO: renamed from: getFilePersistenceConfig$dd_sdk_android_core_release, reason: from getter */
    public final FilePersistenceConfig getFilePersistenceConfig() {
        return this.filePersistenceConfig;
    }

    public /* synthetic */ ConsentAwareStorage(ExecutorService executorService, FileOrchestrator fileOrchestrator, FileOrchestrator fileOrchestrator2, BatchFileReaderWriter batchFileReaderWriter, FileReaderWriter fileReaderWriter, FileMover fileMover, InternalLogger internalLogger, FilePersistenceConfig filePersistenceConfig, MetricsDispatcher metricsDispatcher, String str, BenchmarkUploads benchmarkUploads, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(executorService, fileOrchestrator, fileOrchestrator2, batchFileReaderWriter, fileReaderWriter, fileMover, internalLogger, filePersistenceConfig, metricsDispatcher, str, (i & 1024) != 0 ? new BenchmarkUploads(null, 1, null) : benchmarkUploads);
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public Function1<Function1<? super EventBatchWriter, Unit>, Unit> getEventWriteScope(DatadogContext datadogContext) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        FileOrchestrator fileOrchestratorResolveOrchestrator = resolveOrchestrator(datadogContext);
        if (fileOrchestratorResolveOrchestrator == null) {
            return new AsyncEventWriteScope(this.executorService, new NoOpEventBatchWriter(), this.writeLock, this.featureName, this.internalLogger);
        }
        return new AsyncEventWriteScope(this.executorService, new FileEventBatchWriter(this.featureName, fileOrchestratorResolveOrchestrator, this.batchEventsReaderWriter, this.batchMetadataReaderWriter, this.filePersistenceConfig, this, this.internalLogger), this.writeLock, this.featureName, this.internalLogger);
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public BatchData readNextBatch() {
        synchronized (this.lockedReadBatches) {
            FileOrchestrator fileOrchestrator = this.grantedOrchestrator;
            Set<Batch> set = this.lockedReadBatches;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(((Batch) it.next()).getFile());
            }
            File readableFile = fileOrchestrator.getReadableFile(CollectionsKt.toSet(arrayList));
            byte[] data = null;
            if (readableFile == null) {
                return null;
            }
            File metadataFile = this.grantedOrchestrator.getMetadataFile(readableFile);
            this.lockedReadBatches.add(new Batch(readableFile, metadataFile));
            Pair pair = TuplesKt.to(readableFile, metadataFile);
            File file = (File) pair.component1();
            File file2 = (File) pair.component2();
            BatchId batchIdFromFile = BatchId.INSTANCE.fromFile(file);
            TelemetryContext telemetryContext = new TelemetryContext(this.featureName, null, 2, null);
            if (file2 != null && FileExtKt.existsSafe(file2, this.internalLogger)) {
                data = this.batchMetadataReaderWriter.readData(file2, telemetryContext);
            }
            return new BatchData(batchIdFromFile, this.batchEventsReaderWriter.readData(file, telemetryContext), data);
        }
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public void confirmBatchRead(BatchId batchId, RemovalReason removalReason, boolean deleteBatch) {
        Object next;
        Batch batch;
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(removalReason, "removalReason");
        synchronized (this.lockedReadBatches) {
            Iterator<T> it = this.lockedReadBatches.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!batchId.matchesFile(((Batch) next).getFile()));
            batch = (Batch) next;
        }
        if (batch == null) {
            return;
        }
        if (deleteBatch) {
            deleteBatch(batch, removalReason);
        }
        synchronized (this.lockedReadBatches) {
            this.lockedReadBatches.remove(batch);
        }
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public void dropAll() {
        ConcurrencyExtKt.executeSafe(this.executorService, "ConsentAwareStorage.dropAll", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.ConsentAwareStorage$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConsentAwareStorage.dropAll$lambda$9(this.f$0);
            }
        });
    }

    static final void dropAll$lambda$9(ConsentAwareStorage consentAwareStorage) {
        synchronized (consentAwareStorage.lockedReadBatches) {
            Iterator<T> it = consentAwareStorage.lockedReadBatches.iterator();
            while (it.hasNext()) {
                consentAwareStorage.deleteBatch((Batch) it.next(), RemovalReason.Flushed.INSTANCE);
            }
            consentAwareStorage.lockedReadBatches.clear();
            Unit unit = Unit.INSTANCE;
        }
        FileOrchestrator[] fileOrchestratorArr = {consentAwareStorage.pendingOrchestrator, consentAwareStorage.grantedOrchestrator};
        for (int i = 0; i < 2; i++) {
            FileOrchestrator fileOrchestrator = fileOrchestratorArr[i];
            for (File file : fileOrchestrator.getAllFiles()) {
                consentAwareStorage.deleteBatch(file, fileOrchestrator.getMetadataFile(file), RemovalReason.Flushed.INSTANCE);
            }
        }
    }

    @Override // com.datadog.android.core.internal.persistence.BatchWriteEventListener
    public void onWriteEvent(long bytes) {
        this.benchmarkUploads.sendBenchmarkBytesWritten$dd_sdk_android_core_release(this.featureName, bytes);
    }

    private final FileOrchestrator resolveOrchestrator(DatadogContext datadogContext) {
        int i = WhenMappings.$EnumSwitchMapping$0[datadogContext.getTrackingConsent().ordinal()];
        if (i == 1) {
            return this.grantedOrchestrator;
        }
        if (i == 2) {
            return this.pendingOrchestrator;
        }
        if (i == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void deleteBatch(Batch batch, RemovalReason reason) {
        deleteBatch(batch.getFile(), batch.getMetaFile(), reason);
    }

    private final void deleteBatch(File batchFile, File metaFile, RemovalReason reason) {
        deleteBatchFile(batchFile, reason);
        if (metaFile == null || !FileExtKt.existsSafe(metaFile, this.internalLogger)) {
            return;
        }
        deleteBatchMetadataFile(metaFile);
    }

    private final void deleteBatchFile(final File batchFile, RemovalReason reason) {
        long jLengthSafe = FileExtKt.lengthSafe(batchFile, this.internalLogger);
        if (this.fileMover.delete(batchFile)) {
            this.metricsDispatcher.sendBatchDeletedMetric(batchFile, reason, this.grantedOrchestrator.decrementAndGetPendingFilesCount());
            if (!Intrinsics.areEqual(reason, new RemovalReason.IntakeCode(202)) || jLengthSafe <= 0) {
                return;
            }
            this.benchmarkUploads.sendBenchmarkBytesDeleted$dd_sdk_android_core_release(this.featureName, jLengthSafe);
            return;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.ConsentAwareStorage.deleteBatchFile.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "Unable to delete file: %s", Arrays.copyOf(new Object[]{batchFile.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    private final void deleteBatchMetadataFile(final File metadataFile) {
        if (this.fileMover.delete(metadataFile)) {
            return;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.ConsentAwareStorage.deleteBatchMetadataFile.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "Unable to delete file: %s", Arrays.copyOf(new Object[]{metadataFile.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ConsentAwareStorage.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/core/internal/persistence/ConsentAwareStorage$Batch;", "", "file", "Ljava/io/File;", "metaFile", "(Ljava/io/File;Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "getMetaFile", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final /* data */ class Batch {
        private final File file;
        private final File metaFile;

        public static /* synthetic */ Batch copy$default(Batch batch, File file, File file2, int i, Object obj) {
            if ((i & 1) != 0) {
                file = batch.file;
            }
            if ((i & 2) != 0) {
                file2 = batch.metaFile;
            }
            return batch.copy(file, file2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final File getMetaFile() {
            return this.metaFile;
        }

        public final Batch copy(File file, File metaFile) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new Batch(file, metaFile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Batch)) {
                return false;
            }
            Batch batch = (Batch) other;
            return Intrinsics.areEqual(this.file, batch.file) && Intrinsics.areEqual(this.metaFile, batch.metaFile);
        }

        public int hashCode() {
            int iHashCode = this.file.hashCode() * 31;
            File file = this.metaFile;
            return iHashCode + (file == null ? 0 : file.hashCode());
        }

        public String toString() {
            return "Batch(file=" + this.file + ", metaFile=" + this.metaFile + ")";
        }

        public Batch(File file, File file2) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
            this.metaFile = file2;
        }

        public final File getFile() {
            return this.file;
        }

        public final File getMetaFile() {
            return this.metaFile;
        }
    }
}
