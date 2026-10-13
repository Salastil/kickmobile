package com.datadog.android.core.internal.persistence.file.single;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.FileWriter;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.core.persistence.SerializerKt;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleItemDataWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b\u0010\u0018\u0000 +*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001+BA\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00028\u0000H\u0003¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0017J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\nH\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/single/SingleItemDataWriter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "fileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "serializer", "Lcom/datadog/android/core/persistence/Serializer;", "fileWriter", "Lcom/datadog/android/core/internal/persistence/file/FileWriter;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "filePersistenceConfig", "Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "(Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/persistence/Serializer;Lcom/datadog/android/core/internal/persistence/file/FileWriter;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;Lcom/datadog/android/internal/telemetry/TelemetryContext;)V", "getFileOrchestrator$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "getFilePersistenceConfig$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "getFileWriter$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileWriter;", "getInternalLogger$dd_sdk_android_core_release", "()Lcom/datadog/android/api/InternalLogger;", "getSerializer$dd_sdk_android_core_release", "()Lcom/datadog/android/core/persistence/Serializer;", "getTelemetryContext$dd_sdk_android_core_release", "()Lcom/datadog/android/internal/telemetry/TelemetryContext;", "checkEventSize", "", "eventSize", "", "consume", "", "data", "(Ljava/lang/Object;)V", "write", "element", "", "writeData", "byteArray", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SingleItemDataWriter<T> implements DataWriter<T> {
    public static final String ERROR_LARGE_DATA = "Can't write data with size %d (max item size is %d)";
    private final FileOrchestrator fileOrchestrator;
    private final FilePersistenceConfig filePersistenceConfig;
    private final FileWriter<byte[]> fileWriter;
    private final InternalLogger internalLogger;
    private final Serializer<T> serializer;
    private final TelemetryContext telemetryContext;

    public SingleItemDataWriter(FileOrchestrator fileOrchestrator, Serializer<T> serializer, FileWriter<byte[]> fileWriter, InternalLogger internalLogger, FilePersistenceConfig filePersistenceConfig, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(fileWriter, "fileWriter");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(filePersistenceConfig, "filePersistenceConfig");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        this.fileOrchestrator = fileOrchestrator;
        this.serializer = serializer;
        this.fileWriter = fileWriter;
        this.internalLogger = internalLogger;
        this.filePersistenceConfig = filePersistenceConfig;
        this.telemetryContext = telemetryContext;
    }

    /* JADX INFO: renamed from: getFileOrchestrator$dd_sdk_android_core_release, reason: from getter */
    public final FileOrchestrator getFileOrchestrator() {
        return this.fileOrchestrator;
    }

    public final Serializer<T> getSerializer$dd_sdk_android_core_release() {
        return this.serializer;
    }

    public final FileWriter<byte[]> getFileWriter$dd_sdk_android_core_release() {
        return this.fileWriter;
    }

    /* JADX INFO: renamed from: getInternalLogger$dd_sdk_android_core_release, reason: from getter */
    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    /* JADX INFO: renamed from: getFilePersistenceConfig$dd_sdk_android_core_release, reason: from getter */
    public final FilePersistenceConfig getFilePersistenceConfig() {
        return this.filePersistenceConfig;
    }

    /* JADX INFO: renamed from: getTelemetryContext$dd_sdk_android_core_release, reason: from getter */
    public final TelemetryContext getTelemetryContext() {
        return this.telemetryContext;
    }

    @Override // com.datadog.android.core.internal.persistence.DataWriter
    public void write(T element) {
        Intrinsics.checkNotNullParameter(element, "element");
        consume(element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.datadog.android.core.internal.persistence.DataWriter
    public void write(List<? extends T> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Object objLastOrNull = CollectionsKt.lastOrNull((List<? extends Object>) data);
        if (objLastOrNull == null) {
            return;
        }
        consume(objLastOrNull);
    }

    private final void consume(T data) {
        byte[] bArrSerializeToByteArray = SerializerKt.serializeToByteArray(this.serializer, data, this.internalLogger);
        if (bArrSerializeToByteArray == null) {
            return;
        }
        synchronized (this) {
            writeData(bArrSerializeToByteArray);
        }
    }

    private final boolean writeData(byte[] byteArray) {
        File writableFile;
        if (checkEventSize(byteArray.length) && (writableFile = this.fileOrchestrator.getWritableFile(byteArray.length)) != null) {
            return this.fileWriter.writeData(writableFile, byteArray, false, this.telemetryContext);
        }
        return false;
    }

    private final boolean checkEventSize(final int eventSize) {
        if (eventSize <= this.filePersistenceConfig.getMaxItemSize()) {
            return true;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.single.SingleItemDataWriter.checkEventSize.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, SingleItemDataWriter.ERROR_LARGE_DATA, Arrays.copyOf(new Object[]{Integer.valueOf(eventSize), Long.valueOf(this.getFilePersistenceConfig().getMaxItemSize())}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return false;
    }
}
