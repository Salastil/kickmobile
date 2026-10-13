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

/* JADX INFO: compiled from: WipeDataMigrationOperation.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/WipeDataMigrationOperation;", "Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrationOperation;", "targetDir", "Ljava/io/File;", "fileMover", "Lcom/datadog/android/core/internal/persistence/file/FileMover;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Ljava/io/File;Lcom/datadog/android/core/internal/persistence/file/FileMover;Lcom/datadog/android/api/InternalLogger;)V", "getFileMover$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileMover;", "getInternalLogger$dd_sdk_android_core_release", "()Lcom/datadog/android/api/InternalLogger;", "getTargetDir$dd_sdk_android_core_release", "()Ljava/io/File;", "run", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WipeDataMigrationOperation implements DataMigrationOperation {
    private static final int MAX_RETRY = 3;
    private static final long RETRY_DELAY_NS;
    public static final String WARN_NULL_DIR = "Can't wipe data from a null directory";
    private final FileMover fileMover;
    private final InternalLogger internalLogger;
    private final File targetDir;

    public WipeDataMigrationOperation(File file, FileMover fileMover, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(fileMover, "fileMover");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.targetDir = file;
        this.fileMover = fileMover;
        this.internalLogger = internalLogger;
    }

    /* JADX INFO: renamed from: getTargetDir$dd_sdk_android_core_release, reason: from getter */
    public final File getTargetDir() {
        return this.targetDir;
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
        File file = this.targetDir;
        InternalLogger internalLogger = this.internalLogger;
        if (file == null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.advanced.WipeDataMigrationOperation.run.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WipeDataMigrationOperation.WARN_NULL_DIR;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            MiscUtilsKt.retryWithDelay(3, RETRY_DELAY_NS, internalLogger, new Function0<Boolean>() { // from class: com.datadog.android.core.internal.persistence.file.advanced.WipeDataMigrationOperation.run.2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(WipeDataMigrationOperation.this.getFileMover().delete(WipeDataMigrationOperation.this.getTargetDir()));
                }
            });
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        RETRY_DELAY_NS = 500000000L;
    }
}
