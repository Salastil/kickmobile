package com.datadog.android.core.internal.persistence.file;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.internal.telemetry.TelemetryContext;
import com.datadog.android.security.Encryption;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EncryptedFileReaderWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0017R\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/EncryptedFileReaderWriter;", "Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;", "encryption", "Lcom/datadog/android/security/Encryption;", "delegate", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/security/Encryption;Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;Lcom/datadog/android/api/InternalLogger;)V", "getDelegate$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;", "getEncryption$dd_sdk_android_core_release", "()Lcom/datadog/android/security/Encryption;", "readData", "", "file", "Ljava/io/File;", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "writeData", "", "data", "append", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EncryptedFileReaderWriter implements FileReaderWriter {
    public static final String APPEND_MODE_NOT_SUPPORTED_MESSAGE = "Append mode is not supported, use EncryptedBatchFileReaderWriter instead.";
    public static final String BAD_ENCRYPTION_RESULT_MESSAGE = "Encryption of non-empty data produced empty result, aborting write operation.";
    private final FileReaderWriter delegate;
    private final Encryption encryption;
    private final InternalLogger internalLogger;

    public EncryptedFileReaderWriter(Encryption encryption, FileReaderWriter delegate, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(encryption, "encryption");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.encryption = encryption;
        this.delegate = delegate;
        this.internalLogger = internalLogger;
    }

    /* JADX INFO: renamed from: getEncryption$dd_sdk_android_core_release, reason: from getter */
    public final Encryption getEncryption() {
        return this.encryption;
    }

    /* JADX INFO: renamed from: getDelegate$dd_sdk_android_core_release, reason: from getter */
    public final FileReaderWriter getDelegate() {
        return this.delegate;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileWriter
    public boolean writeData(File file, byte[] data, boolean append, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        if (append) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.EncryptedFileReaderWriter.writeData.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return EncryptedFileReaderWriter.APPEND_MODE_NOT_SUPPORTED_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        byte[] bArrEncrypt = this.encryption.encrypt(data);
        if (!(data.length == 0) && bArrEncrypt.length == 0) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.EncryptedFileReaderWriter.writeData.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Encryption of non-empty data produced empty result, aborting write operation.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        return this.delegate.writeData(file, bArrEncrypt, append, telemetryContext);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileReader
    public byte[] readData(File file, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        return this.encryption.decrypt(this.delegate.readData(file, telemetryContext));
    }
}
