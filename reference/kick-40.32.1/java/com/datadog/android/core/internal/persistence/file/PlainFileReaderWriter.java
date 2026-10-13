package com.datadog.android.core.internal.persistence.file;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlainFileReaderWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/PlainFileReaderWriter;", "Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "lockFileAndWriteData", "", "file", "Ljava/io/File;", "append", "", "data", "", "readData", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "writeData", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlainFileReaderWriter implements FileReaderWriter {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String ERROR_READ = "Unable to read data from file.";
    public static final String ERROR_WRITE = "Unable to write data to file.";
    private final InternalLogger internalLogger;

    public PlainFileReaderWriter(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileWriter
    public boolean writeData(File file, byte[] data, boolean append, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        try {
            lockFileAndWriteData(file, append, data);
            return true;
        } catch (IOException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.PlainFileReaderWriter.writeData.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to write data to file.";
                }
            }, (Throwable) e, false, (Map) telemetryContext.asAttributesMap(data.length, TuplesKt.to(TelemetryContext.TELEMETRY_FILE_PATH, file.getPath())), 16, (Object) null);
            return false;
        } catch (SecurityException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.PlainFileReaderWriter.writeData.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to write data to file.";
                }
            }, (Throwable) e2, false, (Map) telemetryContext.asAttributesMap(data.length, TuplesKt.to(TelemetryContext.TELEMETRY_FILE_PATH, file.getPath())), 16, (Object) null);
            return false;
        }
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileReader
    public byte[] readData(File file, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        try {
            if (!file.exists()) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.PlainFileReaderWriter.readData.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to read data from file.";
                    }
                }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(-1, TuplesKt.to(TelemetryContext.TELEMETRY_FILE_PATH, file.getPath())), 24, (Object) null);
                return EMPTY_BYTE_ARRAY;
            }
            if (file.isDirectory()) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.PlainFileReaderWriter.readData.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to read data from file.";
                    }
                }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(-1, TuplesKt.to(TelemetryContext.TELEMETRY_FILE_PATH, file.getPath())), 24, (Object) null);
                return EMPTY_BYTE_ARRAY;
            }
            return FilesKt.readBytes(file);
        } catch (IOException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.PlainFileReaderWriter.readData.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to read data from file.";
                }
            }, (Throwable) e, false, (Map) telemetryContext.asAttributesMap(-1, TuplesKt.to(TelemetryContext.TELEMETRY_FILE_PATH, file.getPath())), 16, (Object) null);
            return EMPTY_BYTE_ARRAY;
        } catch (SecurityException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.PlainFileReaderWriter.readData.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to read data from file.";
                }
            }, (Throwable) e2, false, (Map) telemetryContext.asAttributesMap(-1, TuplesKt.to(TelemetryContext.TELEMETRY_FILE_PATH, file.getPath())), 16, (Object) null);
            return EMPTY_BYTE_ARRAY;
        }
    }

    private final void lockFileAndWriteData(File file, boolean append, byte[] data) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file, append);
        try {
            FileOutputStream fileOutputStream2 = fileOutputStream;
            FileLock fileLockLock = fileOutputStream2.getChannel().lock();
            Intrinsics.checkNotNullExpressionValue(fileLockLock, "outputStream.channel.lock()");
            try {
                fileOutputStream2.write(data);
                Unit unit = Unit.INSTANCE;
                fileLockLock.release();
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
            } catch (Throwable th) {
                fileLockLock.release();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(fileOutputStream, th2);
                throw th3;
            }
        }
    }
}
