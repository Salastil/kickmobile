package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileMover;
import com.datadog.android.core.internal.utils.MiscUtilsKt;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoveDataMigrationOperation.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0017R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/MoveDataMigrationOperation;", "Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrationOperation;", "fromDir", "Ljava/io/File;", "toDir", "fileMover", "Lcom/datadog/android/core/internal/persistence/file/FileMover;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Ljava/io/File;Ljava/io/File;Lcom/datadog/android/core/internal/persistence/file/FileMover;Lcom/datadog/android/api/InternalLogger;)V", "getFileMover$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileMover;", "getFromDir$dd_sdk_android_core_release", "()Ljava/io/File;", "getInternalLogger$dd_sdk_android_core_release", "()Lcom/datadog/android/api/InternalLogger;", "getToDir$dd_sdk_android_core_release", "run", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MoveDataMigrationOperation implements DataMigrationOperation {
    private static final int MAX_RETRY = 3;
    private static final long RETRY_DELAY_NS;
    public static final String WARN_NULL_DEST_DIR = "Can't move data to a null directory";
    public static final String WARN_NULL_SOURCE_DIR = "Can't move data from a null directory";
    private final FileMover fileMover;
    private final File fromDir;
    private final InternalLogger internalLogger;
    private final File toDir;

    public MoveDataMigrationOperation(File file, File file2, FileMover fileMover, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(fileMover, "fileMover");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.fromDir = file;
        this.toDir = file2;
        this.fileMover = fileMover;
        this.internalLogger = internalLogger;
    }

    /* JADX INFO: renamed from: getFromDir$dd_sdk_android_core_release, reason: from getter */
    public final File getFromDir() {
        return this.fromDir;
    }

    /* JADX INFO: renamed from: getToDir$dd_sdk_android_core_release, reason: from getter */
    public final File getToDir() {
        return this.toDir;
    }

    /* JADX INFO: renamed from: getFileMover$dd_sdk_android_core_release, reason: from getter */
    public final FileMover getFileMover() {
        return this.fileMover;
    }

    /* JADX INFO: renamed from: getInternalLogger$dd_sdk_android_core_release, reason: from getter */
    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.fromDir == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.advanced.MoveDataMigrationOperation.run.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return MoveDataMigrationOperation.WARN_NULL_SOURCE_DIR;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        File file = this.toDir;
        InternalLogger internalLogger = this.internalLogger;
        if (file == null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.advanced.MoveDataMigrationOperation.run.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return MoveDataMigrationOperation.WARN_NULL_DEST_DIR;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            MiscUtilsKt.retryWithDelay(3, RETRY_DELAY_NS, internalLogger, new Function0<Boolean>() { // from class: com.datadog.android.core.internal.persistence.file.advanced.MoveDataMigrationOperation.run.3
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(MoveDataMigrationOperation.this.getFileMover().moveFiles(MoveDataMigrationOperation.this.getFromDir(), MoveDataMigrationOperation.this.getToDir()));
                }
            });
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        RETRY_DELAY_NS = 500000000L;
    }
}
