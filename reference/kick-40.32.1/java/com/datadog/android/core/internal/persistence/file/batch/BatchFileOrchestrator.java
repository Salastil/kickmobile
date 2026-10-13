package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.metrics.BatchClosedMetadata;
import com.datadog.android.core.internal.metrics.MetricsDispatcher;
import com.datadog.android.core.internal.metrics.RemovalReason;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.internal.time.TimeProvider;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BatchFileOrchestrator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\f\b\u0000\u0018\u0000 B2\u00020\u0001:\u0002ABB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u0003H\u0002J\b\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u001eH\u0002J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0002J\u0016\u00100\u001a\u0002012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0002J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0017J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0017J\u0012\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u0010,\u001a\u00020\u0003H\u0017J\u0018\u00105\u001a\u0004\u0018\u00010\u00032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000307H\u0017J\u0012\u00108\u001a\u0004\u0018\u00010\u00032\u0006\u00109\u001a\u00020\u0014H\u0002J\n\u0010:\u001a\u0004\u0018\u00010\u0003H\u0017J\u0012\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u00109\u001a\u00020\u0014H\u0017J\u0018\u0010<\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0014H\u0002J\b\u0010>\u001a\u00020\u001eH\u0002J\u000e\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0002J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0014X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0014X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001d\u001a\u00020\u001e*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR \u0010 \u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\u00020\u0003*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006C"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileOrchestrator;", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "rootDir", "Ljava/io/File;", "config", "Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "metricsDispatcher", "Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "pendingFiles", "Ljava/util/concurrent/atomic/AtomicInteger;", "(Ljava/io/File;Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;Lcom/datadog/android/internal/time/TimeProvider;Ljava/util/concurrent/atomic/AtomicInteger;)V", "getConfig$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "fileFilter", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileOrchestrator$BatchFileFilter;", "lastCleanupTimestamp", "", "lastFileAccessTimestamp", "previousFile", "previousFileItemCount", "recentReadDelayMs", "getRecentReadDelayMs$annotations", "()V", "recentWriteDelayMs", "getRecentWriteDelayMs$annotations", "isBatchFile", "", "(Ljava/io/File;)Z", "latestBatchFile", "", "getLatestBatchFile", "(Ljava/util/List;)Ljava/io/File;", "metadata", "getMetadata", "(Ljava/io/File;)Ljava/io/File;", "canDoCleanup", "createNewFile", "decrementAndGetPendingFilesCount", "", "deleteFile", "file", "sendMetric", "deleteObsoleteFiles", "files", "freeSpaceIfNeeded", "", "getAllFiles", "getFlushableFiles", "getMetadataFile", "getReadableFile", "excludeFiles", "", "getReusableWritableFile", "eventSize", "getRootDir", "getWritableFile", "isFileRecent", "delayMs", "isRootDirValid", "listBatchFiles", "listSortedBatchFiles", "BatchFileFilter", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BatchFileOrchestrator implements FileOrchestrator {
    public static final String DEBUG_DIFFERENT_ROOT = "The file provided (%s) doesn't belong to the current folder (%s)";
    public static final double DECREASE_PERCENT = 0.95d;
    public static final String ERROR_CANT_CREATE_ROOT = "The provided root dir can't be created: %s";
    public static final String ERROR_DISK_FULL = "Too much disk space used (%d/%d): cleaning up to free %d bytes…";
    public static final String ERROR_NOT_BATCH_FILE = "The file provided is not a batch file: %s";
    public static final String ERROR_ROOT_NOT_DIR = "The provided root file is not a directory: %s";
    public static final String ERROR_ROOT_NOT_WRITABLE = "The provided root dir is not writable: %s";
    public static final double INCREASE_PERCENT = 1.05d;
    private final FilePersistenceConfig config;
    private final BatchFileFilter fileFilter;
    private final InternalLogger internalLogger;
    private long lastCleanupTimestamp;
    private long lastFileAccessTimestamp;
    private final MetricsDispatcher metricsDispatcher;
    private final AtomicInteger pendingFiles;
    private File previousFile;
    private long previousFileItemCount;
    private final long recentReadDelayMs;
    private final long recentWriteDelayMs;
    private final File rootDir;
    private final TimeProvider timeProvider;

    private static /* synthetic */ void getRecentReadDelayMs$annotations() {
    }

    private static /* synthetic */ void getRecentWriteDelayMs$annotations() {
    }

    public BatchFileOrchestrator(File rootDir, FilePersistenceConfig config, InternalLogger internalLogger, MetricsDispatcher metricsDispatcher, TimeProvider timeProvider, AtomicInteger pendingFiles) {
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(metricsDispatcher, "metricsDispatcher");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(pendingFiles, "pendingFiles");
        this.rootDir = rootDir;
        this.config = config;
        this.internalLogger = internalLogger;
        this.metricsDispatcher = metricsDispatcher;
        this.timeProvider = timeProvider;
        this.pendingFiles = pendingFiles;
        this.fileFilter = new BatchFileFilter();
        this.recentReadDelayMs = MathKt.roundToLong(config.getRecentDelayMs() * 1.05d);
        this.recentWriteDelayMs = MathKt.roundToLong(config.getRecentDelayMs() * 0.95d);
    }

    /* JADX INFO: renamed from: getConfig$dd_sdk_android_core_release, reason: from getter */
    public final FilePersistenceConfig getConfig() {
        return this.config;
    }

    public /* synthetic */ BatchFileOrchestrator(File file, FilePersistenceConfig filePersistenceConfig, InternalLogger internalLogger, MetricsDispatcher metricsDispatcher, TimeProvider timeProvider, AtomicInteger atomicInteger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, filePersistenceConfig, internalLogger, metricsDispatcher, timeProvider, (i & 32) != 0 ? new AtomicInteger(0) : atomicInteger);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getWritableFile(long eventSize) {
        if (!isRootDirValid()) {
            return null;
        }
        if (canDoCleanup()) {
            freeSpaceIfNeeded(deleteObsoleteFiles(listBatchFiles()));
            this.lastCleanupTimestamp = this.timeProvider.getDeviceTimestampMillis();
        }
        File reusableWritableFile = getReusableWritableFile(eventSize);
        return reusableWritableFile == null ? createNewFile() : reusableWritableFile;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getReadableFile(Set<? extends File> excludeFiles) {
        Intrinsics.checkNotNullParameter(excludeFiles, "excludeFiles");
        Object obj = null;
        if (!isRootDirValid()) {
            return null;
        }
        List<File> listDeleteObsoleteFiles = deleteObsoleteFiles(listSortedBatchFiles());
        this.lastCleanupTimestamp = this.timeProvider.getDeviceTimestampMillis();
        this.pendingFiles.set(listDeleteObsoleteFiles.size());
        for (Object obj2 : listDeleteObsoleteFiles) {
            File file = (File) obj2;
            if (!excludeFiles.contains(file) && !isFileRecent(file, this.recentReadDelayMs)) {
                obj = obj2;
                break;
            }
        }
        return (File) obj;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List<File> getAllFiles() {
        if (!isRootDirValid()) {
            return CollectionsKt.emptyList();
        }
        return listSortedBatchFiles();
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List<File> getFlushableFiles() {
        return getAllFiles();
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getRootDir() {
        if (isRootDirValid()) {
            return this.rootDir;
        }
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getMetadataFile(final File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!Intrinsics.areEqual(file.getParent(), this.rootDir.getPath())) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.DEBUG, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator.getMetadataFile.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, BatchFileOrchestrator.DEBUG_DIFFERENT_ROOT, Arrays.copyOf(new Object[]{file.getPath(), this.rootDir.getPath()}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        if (isBatchFile(file)) {
            return getMetadata(file);
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator.getMetadataFile.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, BatchFileOrchestrator.ERROR_NOT_BATCH_FILE, Arrays.copyOf(new Object[]{file.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public int decrementAndGetPendingFilesCount() {
        return this.pendingFiles.decrementAndGet();
    }

    private final boolean isRootDirValid() {
        boolean zExistsSafe = FileExtKt.existsSafe(this.rootDir, this.internalLogger);
        File file = this.rootDir;
        if (zExistsSafe) {
            if (file.isDirectory()) {
                if (FileExtKt.canWriteSafe(this.rootDir, this.internalLogger)) {
                    return true;
                }
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator.isRootDirValid.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, BatchFileOrchestrator.ERROR_ROOT_NOT_WRITABLE, Arrays.copyOf(new Object[]{BatchFileOrchestrator.this.rootDir.getPath()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return false;
            }
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator.isRootDirValid.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, BatchFileOrchestrator.ERROR_ROOT_NOT_DIR, Arrays.copyOf(new Object[]{BatchFileOrchestrator.this.rootDir.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        synchronized (file) {
            if (FileExtKt.existsSafe(this.rootDir, this.internalLogger)) {
                return true;
            }
            if (FileExtKt.mkdirsSafe(this.rootDir, this.internalLogger)) {
                return true;
            }
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator$isRootDirValid$3$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, BatchFileOrchestrator.ERROR_CANT_CREATE_ROOT, Arrays.copyOf(new Object[]{this.this$0.rootDir.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
    }

    private final File createNewFile() {
        File file = new File(this.rootDir, String.valueOf(this.timeProvider.getDeviceTimestampMillis()));
        File file2 = this.previousFile;
        long j = this.lastFileAccessTimestamp;
        if (file2 != null) {
            this.metricsDispatcher.sendBatchClosedMetric(file2, new BatchClosedMetadata(j, this.previousFileItemCount));
        }
        this.previousFile = file;
        this.previousFileItemCount = 1L;
        this.lastFileAccessTimestamp = this.timeProvider.getDeviceTimestampMillis();
        this.pendingFiles.incrementAndGet();
        return file;
    }

    private final File getReusableWritableFile(long eventSize) {
        File latestBatchFile = getLatestBatchFile(listBatchFiles());
        if (latestBatchFile == null) {
            return null;
        }
        File file = this.previousFile;
        long j = this.previousFileItemCount;
        if (!Intrinsics.areEqual(file, latestBatchFile)) {
            return null;
        }
        boolean zIsFileRecent = isFileRecent(latestBatchFile, this.recentWriteDelayMs);
        boolean z = FileExtKt.lengthSafe(latestBatchFile, this.internalLogger) + eventSize <= this.config.getMaxBatchSize();
        boolean z2 = j < ((long) this.config.getMaxItemsPerBatch());
        if (!zIsFileRecent || !z || !z2) {
            return null;
        }
        this.previousFileItemCount = j + 1;
        this.lastFileAccessTimestamp = this.timeProvider.getDeviceTimestampMillis();
        return latestBatchFile;
    }

    private final boolean isFileRecent(File file, long delayMs) {
        long deviceTimestampMillis = this.timeProvider.getDeviceTimestampMillis();
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        Long longOrNull = StringsKt.toLongOrNull(name);
        return (longOrNull != null ? longOrNull.longValue() : 0L) >= deviceTimestampMillis - delayMs;
    }

    private final List<File> deleteObsoleteFiles(List<? extends File> files) {
        long deviceTimestampMillis = this.timeProvider.getDeviceTimestampMillis() - this.config.getOldFileThreshold();
        ArrayList arrayList = new ArrayList();
        for (File file : files) {
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            Long longOrNull = StringsKt.toLongOrNull(name);
            if ((longOrNull != null ? longOrNull.longValue() : 0L) < deviceTimestampMillis) {
                if (FileExtKt.deleteSafe(file, this.internalLogger)) {
                    this.metricsDispatcher.sendBatchDeletedMetric(file, RemovalReason.Obsolete.INSTANCE, this.pendingFiles.decrementAndGet());
                }
                if (FileExtKt.existsSafe(getMetadata(file), this.internalLogger)) {
                    FileExtKt.deleteSafe(getMetadata(file), this.internalLogger);
                }
                file = null;
            }
            if (file != null) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    private final void freeSpaceIfNeeded(List<? extends File> files) {
        List<? extends File> list = files;
        Iterator<T> it = list.iterator();
        final long jLengthSafe = 0;
        while (it.hasNext()) {
            jLengthSafe += FileExtKt.lengthSafe((File) it.next(), this.internalLogger);
        }
        final long maxDiskSpace = this.config.getMaxDiskSpace();
        final long jDeleteFile = jLengthSafe - maxDiskSpace;
        if (jDeleteFile > 0) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator.freeSpaceIfNeeded.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, BatchFileOrchestrator.ERROR_DISK_FULL, Arrays.copyOf(new Object[]{Long.valueOf(jLengthSafe), Long.valueOf(maxDiskSpace), Long.valueOf(jDeleteFile)}, 3));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            for (File file : CollectionsKt.sorted(list)) {
                if (jDeleteFile > 0) {
                    jDeleteFile = (jDeleteFile - deleteFile(file, true)) - deleteFile$default(this, getMetadata(file), false, 2, null);
                }
            }
        }
    }

    static /* synthetic */ long deleteFile$default(BatchFileOrchestrator batchFileOrchestrator, File file, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return batchFileOrchestrator.deleteFile(file, z);
    }

    private final long deleteFile(File file, boolean sendMetric) {
        if (!FileExtKt.existsSafe(file, this.internalLogger)) {
            return 0L;
        }
        long jLengthSafe = FileExtKt.lengthSafe(file, this.internalLogger);
        if (!FileExtKt.deleteSafe(file, this.internalLogger)) {
            return 0L;
        }
        if (sendMetric) {
            this.metricsDispatcher.sendBatchDeletedMetric(file, RemovalReason.Purged.INSTANCE, this.pendingFiles.decrementAndGet());
        }
        return jLengthSafe;
    }

    private final List<File> listBatchFiles() {
        File[] fileArrListFilesSafe = FileExtKt.listFilesSafe(this.rootDir, this.fileFilter, this.internalLogger);
        if (fileArrListFilesSafe == null) {
            fileArrListFilesSafe = new File[0];
        }
        return ArraysKt.toList(fileArrListFilesSafe);
    }

    private final List<File> listSortedBatchFiles() {
        return CollectionsKt.sorted(listBatchFiles());
    }

    private final boolean canDoCleanup() {
        return this.timeProvider.getDeviceTimestampMillis() - this.lastCleanupTimestamp > this.config.getCleanupFrequencyThreshold();
    }

    private final File getMetadata(File file) {
        return new File(file.getPath() + "_metadata");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBatchFile(File file) {
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt.toLongOrNull(name) != null;
    }

    private final File getLatestBatchFile(List<? extends File> list) {
        return (File) CollectionsKt.maxOrNull((Iterable) list);
    }

    /* JADX INFO: compiled from: BatchFileOrchestrator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileOrchestrator$BatchFileFilter;", "Ljava/io/FileFilter;", "(Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileOrchestrator;)V", "accept", "", "file", "Ljava/io/File;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BatchFileFilter implements FileFilter {
        public BatchFileFilter() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file == null) {
                return false;
            }
            return BatchFileOrchestrator.this.isBatchFile(file);
        }
    }
}
