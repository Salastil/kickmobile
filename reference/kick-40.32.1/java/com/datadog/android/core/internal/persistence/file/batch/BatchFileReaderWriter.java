package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.internal.telemetry.TelemetryContext;
import com.datadog.android.security.Encryption;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatchFileReaderWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReader;", "serializeToBytes", "", "data", "Lcom/datadog/android/api/storage/RawBatchEvent;", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "writeBinaryData", "", "file", "Ljava/io/File;", "bytes", "append", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BatchFileReaderWriter extends BatchFileReader {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    byte[] serializeToBytes(RawBatchEvent data, TelemetryContext telemetryContext);

    boolean writeBinaryData(File file, byte[] bytes, boolean append, TelemetryContext telemetryContext);

    /* JADX INFO: compiled from: BatchFileReaderWriter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter$Companion;", "", "()V", "create", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "encryption", "Lcom/datadog/android/security/Encryption;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final BatchFileReaderWriter create(InternalLogger internalLogger, Encryption encryption) {
            Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
            PlainBatchFileReaderWriter plainBatchFileReaderWriter = new PlainBatchFileReaderWriter(internalLogger);
            if (encryption == null) {
                return plainBatchFileReaderWriter;
            }
            return new EncryptedBatchReaderWriter(encryption, plainBatchFileReaderWriter, internalLogger);
        }
    }
}
