package com.datadog.android.core.internal.persistence.file;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.api.InternalLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileMover.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/FileMover;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "getInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "delete", "", TypedValues.Attributes.S_TARGET, "Ljava/io/File;", "moveFile", "file", "destDir", "moveFiles", "srcDir", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileMover {
    public static final String ERROR_DELETE = "Unable to delete file: %s";
    public static final String ERROR_MOVE_NOT_DIR = "Unable to move files; file is not a directory: %s";
    public static final String ERROR_MOVE_NO_DST = "Unable to move files; could not create directory: %s";
    public static final String INFO_MOVE_NO_SRC = "Unable to move files; source directory does not exist: %s";
    private final InternalLogger internalLogger;

    public FileMover(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    public final boolean delete(final File target) {
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            return FilesKt.deleteRecursively(target);
        } catch (FileNotFoundException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.delete.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to delete file: %s", Arrays.copyOf(new Object[]{target.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return false;
        } catch (SecurityException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.delete.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to delete file: %s", Arrays.copyOf(new Object[]{target.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return false;
        }
    }

    public final boolean moveFiles(final File srcDir, final File destDir) {
        Intrinsics.checkNotNullParameter(srcDir, "srcDir");
        Intrinsics.checkNotNullParameter(destDir, "destDir");
        boolean zExistsSafe = FileExtKt.existsSafe(srcDir, this.internalLogger);
        InternalLogger internalLogger = this.internalLogger;
        if (!zExistsSafe) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.moveFiles.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, FileMover.INFO_MOVE_NO_SRC, Arrays.copyOf(new Object[]{srcDir.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return true;
        }
        boolean zIsDirectorySafe = FileExtKt.isDirectorySafe(srcDir, internalLogger);
        InternalLogger internalLogger2 = this.internalLogger;
        if (!zIsDirectorySafe) {
            InternalLogger.DefaultImpls.log$default(internalLogger2, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.moveFiles.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, FileMover.ERROR_MOVE_NOT_DIR, Arrays.copyOf(new Object[]{srcDir.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        boolean zExistsSafe2 = FileExtKt.existsSafe(destDir, internalLogger2);
        InternalLogger internalLogger3 = this.internalLogger;
        if (!zExistsSafe2) {
            if (!FileExtKt.mkdirsSafe(destDir, internalLogger3)) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.moveFiles.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, FileMover.ERROR_MOVE_NO_DST, Arrays.copyOf(new Object[]{srcDir.getPath()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return false;
            }
        } else if (!FileExtKt.isDirectorySafe(destDir, internalLogger3)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.moveFiles.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, FileMover.ERROR_MOVE_NOT_DIR, Arrays.copyOf(new Object[]{destDir.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        File[] fileArrListFilesSafe = FileExtKt.listFilesSafe(srcDir, this.internalLogger);
        if (fileArrListFilesSafe == null) {
            fileArrListFilesSafe = new File[0];
        }
        for (File file : fileArrListFilesSafe) {
            if (!moveFile(file, destDir)) {
                return false;
            }
        }
        return true;
    }

    private final boolean moveFile(File file, File destDir) {
        return FileExtKt.renameToSafe(file, new File(destDir, file.getName()), this.internalLogger);
    }
}
