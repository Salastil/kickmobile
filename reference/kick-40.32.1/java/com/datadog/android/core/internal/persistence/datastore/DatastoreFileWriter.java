package com.datadog.android.core.internal.persistence.datastore;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.datastore.DataStoreWriteCallback;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileReaderWriter;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlock;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlockType;
import com.datadog.android.core.internal.utils.ByteArrayExtKt;
import com.datadog.android.core.internal.utils.NumberExtKt;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: DatastoreFileWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\r\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\b\u000fJ\u001f\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0002\b\u0014J/\u0010\u0015\u001a\u0004\u0018\u00010\u0016\"\b\b\u0000\u0010\u0017*\u00020\u00012\u0006\u0010\u0018\u001a\u0002H\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u001aH\u0002¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002JQ\u0010 \u001a\u00020\u000e\"\b\b\u0000\u0010\u0017*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u0002H\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0004\b#\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/datadog/android/core/internal/persistence/datastore/DatastoreFileWriter;", "", "dataStoreFileHelper", "Lcom/datadog/android/core/internal/persistence/datastore/DataStoreFileHelper;", "featureName", "", "storageDir", "Ljava/io/File;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "fileReaderWriter", "Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;", "(Lcom/datadog/android/core/internal/persistence/datastore/DataStoreFileHelper;Ljava/lang/String;Ljava/io/File;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;)V", "clearAllData", "", "clearAllData$dd_sdk_android_core_release", "delete", "key", "callback", "Lcom/datadog/android/api/storage/datastore/DataStoreWriteCallback;", "delete$dd_sdk_android_core_release", "getDataBlock", "", ExifInterface.GPS_DIRECTION_TRUE, "data", "serializer", "Lcom/datadog/android/core/persistence/Serializer;", "(Ljava/lang/Object;Lcom/datadog/android/core/persistence/Serializer;)[B", "getVersionCodeBlock", "version", "", "logFailedToSerializeDataError", "write", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "write$dd_sdk_android_core_release", "(Ljava/lang/String;Ljava/lang/Object;Lcom/datadog/android/core/persistence/Serializer;Lcom/datadog/android/api/storage/datastore/DataStoreWriteCallback;ILcom/datadog/android/internal/telemetry/TelemetryContext;)V", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatastoreFileWriter {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String FAILED_TO_SERIALIZE_DATA_ERROR = "Write error - Failed to serialize data for the datastore";
    private final DataStoreFileHelper dataStoreFileHelper;
    private final String featureName;
    private final FileReaderWriter fileReaderWriter;
    private final InternalLogger internalLogger;
    private final File storageDir;

    public DatastoreFileWriter(DataStoreFileHelper dataStoreFileHelper, String featureName, File storageDir, InternalLogger internalLogger, FileReaderWriter fileReaderWriter) {
        Intrinsics.checkNotNullParameter(dataStoreFileHelper, "dataStoreFileHelper");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(storageDir, "storageDir");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(fileReaderWriter, "fileReaderWriter");
        this.dataStoreFileHelper = dataStoreFileHelper;
        this.featureName = featureName;
        this.storageDir = storageDir;
        this.internalLogger = internalLogger;
        this.fileReaderWriter = fileReaderWriter;
    }

    public final <T> void write$dd_sdk_android_core_release(String key, T data, Serializer<T> serializer, DataStoreWriteCallback callback, int version, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        File dataStoreFile$dd_sdk_android_core_release = this.dataStoreFileHelper.getDataStoreFile$dd_sdk_android_core_release(this.storageDir, this.featureName, key);
        byte[] versionCodeBlock = getVersionCodeBlock(version);
        byte[] dataBlock = getDataBlock(data, serializer);
        if (versionCodeBlock == null || dataBlock == null) {
            if (callback != null) {
                callback.onFailure();
                return;
            }
            return;
        }
        if (this.fileReaderWriter.writeData(dataStoreFile$dd_sdk_android_core_release, ByteArrayExtKt.join$default(CollectionsKt.listOf((Object[]) new byte[][]{versionCodeBlock, dataBlock}), EMPTY_BYTE_ARRAY, null, null, this.internalLogger, 6, null), false, telemetryContext)) {
            if (callback != null) {
                callback.onSuccess();
            }
        } else if (callback != null) {
            callback.onFailure();
        }
    }

    public final void delete$dd_sdk_android_core_release(String key, DataStoreWriteCallback callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        File dataStoreFile$dd_sdk_android_core_release = this.dataStoreFileHelper.getDataStoreFile$dd_sdk_android_core_release(this.storageDir, this.featureName, key);
        if (FileExtKt.existsSafe(dataStoreFile$dd_sdk_android_core_release, this.internalLogger)) {
            if (FileExtKt.deleteSafe(dataStoreFile$dd_sdk_android_core_release, this.internalLogger)) {
                if (callback != null) {
                    callback.onSuccess();
                }
            } else if (callback != null) {
                callback.onFailure();
            }
        }
    }

    public final void clearAllData$dd_sdk_android_core_release() {
        File dataStoreDirectory$dd_sdk_android_core_release = this.dataStoreFileHelper.getDataStoreDirectory$dd_sdk_android_core_release(this.storageDir, this.featureName);
        if (FileExtKt.existsSafe(dataStoreDirectory$dd_sdk_android_core_release, this.internalLogger)) {
            FileExtKt.deleteDirectoryContentsSafe(dataStoreDirectory$dd_sdk_android_core_release, this.internalLogger);
        }
    }

    private final <T> byte[] getDataBlock(T data, Serializer<T> serializer) {
        byte[] bytes;
        String strSerialize = serializer.serialize(data);
        if (strSerialize != null) {
            bytes = strSerialize.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        } else {
            bytes = null;
        }
        if (bytes == null) {
            logFailedToSerializeDataError();
            return null;
        }
        return TLVBlock.serialize$dd_sdk_android_core_release$default(new TLVBlock(TLVBlockType.DATA, bytes, this.internalLogger), new TelemetryContext(this.featureName, null, 2, null), 0, 2, null);
    }

    private final byte[] getVersionCodeBlock(int version) {
        return TLVBlock.serialize$dd_sdk_android_core_release$default(new TLVBlock(TLVBlockType.VERSION_CODE, NumberExtKt.toByteArray(version), this.internalLogger), new TelemetryContext(this.featureName, null, 2, null), 0, 2, null);
    }

    private final void logFailedToSerializeDataError() {
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.datastore.DatastoreFileWriter.logFailedToSerializeDataError.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return DatastoreFileWriter.FAILED_TO_SERIALIZE_DATA_ERROR;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }
}
