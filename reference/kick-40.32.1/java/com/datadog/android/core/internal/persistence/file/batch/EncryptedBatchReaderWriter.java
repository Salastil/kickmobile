package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.internal.telemetry.TelemetryContext;
import com.datadog.android.security.Encryption;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EncryptedBatchReaderWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/EncryptedBatchReaderWriter;", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;", "encryption", "Lcom/datadog/android/security/Encryption;", "delegate", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/security/Encryption;Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;Lcom/datadog/android/api/InternalLogger;)V", "getDelegate$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;", "getEncryption$dd_sdk_android_core_release", "()Lcom/datadog/android/security/Encryption;", "readData", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "file", "Ljava/io/File;", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "serializeToBytes", "", "data", "writeBinaryData", "", "bytes", "append", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EncryptedBatchReaderWriter implements BatchFileReaderWriter {
    public static final String BAD_ENCRYPTION_RESULT_MESSAGE = "Encryption of non-empty data produced empty result, aborting write operation.";
    private final BatchFileReaderWriter delegate;
    private final Encryption encryption;
    private final InternalLogger internalLogger;

    public EncryptedBatchReaderWriter(Encryption encryption, BatchFileReaderWriter delegate, InternalLogger internalLogger) {
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
    public final BatchFileReaderWriter getDelegate() {
        return this.delegate;
    }

    @Override // com.datadog.android.core.internal.persistence.file.batch.BatchFileReaderWriter
    public byte[] serializeToBytes(RawBatchEvent data, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        byte[] bArrEncrypt = this.encryption.encrypt(data.getData());
        if (!(data.getData().length == 0) && bArrEncrypt.length == 0) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.EncryptedBatchReaderWriter.serializeToBytes.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Encryption of non-empty data produced empty result, aborting write operation.";
                }
            }, (Throwable) null, false, TelemetryContext.asAttributesMap$default(telemetryContext, data.getData().length, null, 2, null), 24, (Object) null);
            return null;
        }
        return this.delegate.serializeToBytes(new RawBatchEvent(bArrEncrypt, this.encryption.encrypt(data.getMetadata())), telemetryContext);
    }

    @Override // com.datadog.android.core.internal.persistence.file.batch.BatchFileReaderWriter
    public boolean writeBinaryData(File file, byte[] bytes, boolean append, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        return this.delegate.writeBinaryData(file, bytes, append, telemetryContext);
    }

    @Override // com.datadog.android.core.internal.persistence.file.batch.BatchFileReader
    public List<RawBatchEvent> readData(File file, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        List<RawBatchEvent> data = this.delegate.readData(file, telemetryContext);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(data, 10));
        for (RawBatchEvent rawBatchEvent : data) {
            arrayList.add(new RawBatchEvent(!(rawBatchEvent.getData().length == 0) ? this.encryption.decrypt(rawBatchEvent.getData()) : rawBatchEvent.getData(), !(rawBatchEvent.getMetadata().length == 0) ? this.encryption.decrypt(rawBatchEvent.getMetadata()) : rawBatchEvent.getMetadata()));
        }
        return arrayList;
    }
}
