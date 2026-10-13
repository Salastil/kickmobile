package com.datadog.android.core.internal.persistence.datastore;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.datastore.DataStoreReadCallback;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlock;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlockFileReader;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlockType;
import com.datadog.android.core.internal.utils.ByteArrayExtKt;
import com.datadog.android.core.persistence.datastore.DataStoreContent;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: DatastoreFileReader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J<\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0015\u0018\u00010\u0014\"\b\b\u0000\u0010\u0015*\u00020\u00012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00150\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002JW\u0010\u001b\u001a\u00020\u000e\"\b\b\u0000\u0010\u0015*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00150\u00172\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0004\b\"\u0010#J[\u0010$\u001a\u00020\u000e\"\b\b\u0000\u0010\u0015*\u00020\u00012\u0006\u0010%\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00150\u00172\u0006\u0010\n\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001f2\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0002\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/datadog/android/core/internal/persistence/datastore/DatastoreFileReader;", "", "dataStoreFileHelper", "Lcom/datadog/android/core/internal/persistence/datastore/DataStoreFileHelper;", "featureName", "", "storageDir", "Ljava/io/File;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "tlvBlockFileReader", "Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockFileReader;", "(Lcom/datadog/android/core/internal/persistence/datastore/DataStoreFileHelper;Ljava/lang/String;Ljava/io/File;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockFileReader;)V", "logBlocksInUnexpectedBlocksOrderError", "", "logInvalidNumberOfBlocksError", "numberBlocksFound", "", "numberBlocksExpected", "mapToDataStoreContents", "Lcom/datadog/android/core/persistence/datastore/DataStoreContent;", ExifInterface.GPS_DIRECTION_TRUE, "deserializer", "Lcom/datadog/android/core/internal/persistence/Deserializer;", "tlvBlocks", "", "Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlock;", "read", "key", "version", "callback", "Lcom/datadog/android/api/storage/datastore/DataStoreReadCallback;", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "read$dd_sdk_android_core_release", "(Ljava/lang/String;Lcom/datadog/android/core/internal/persistence/Deserializer;Ljava/lang/Integer;Lcom/datadog/android/api/storage/datastore/DataStoreReadCallback;Lcom/datadog/android/internal/telemetry/TelemetryContext;)V", "readFromDataStoreFile", "datastoreFile", "requestedVersion", "(Ljava/io/File;Lcom/datadog/android/core/internal/persistence/Deserializer;Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockFileReader;Ljava/lang/Integer;Lcom/datadog/android/api/storage/datastore/DataStoreReadCallback;Lcom/datadog/android/internal/telemetry/TelemetryContext;)V", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatastoreFileReader {
    public static final String INVALID_NUMBER_OF_BLOCKS_ERROR = "Read error - datastore entry has invalid number of blocks. Was: %d, expected: %d";
    public static final String UNEXPECTED_BLOCKS_ORDER_ERROR = "Read error - blocks are in an unexpected order";
    private final DataStoreFileHelper dataStoreFileHelper;
    private final String featureName;
    private final InternalLogger internalLogger;
    private final File storageDir;
    private final TLVBlockFileReader tlvBlockFileReader;

    public DatastoreFileReader(DataStoreFileHelper dataStoreFileHelper, String featureName, File storageDir, InternalLogger internalLogger, TLVBlockFileReader tlvBlockFileReader) {
        Intrinsics.checkNotNullParameter(dataStoreFileHelper, "dataStoreFileHelper");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(storageDir, "storageDir");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(tlvBlockFileReader, "tlvBlockFileReader");
        this.dataStoreFileHelper = dataStoreFileHelper;
        this.featureName = featureName;
        this.storageDir = storageDir;
        this.internalLogger = internalLogger;
        this.tlvBlockFileReader = tlvBlockFileReader;
    }

    public static /* synthetic */ void read$dd_sdk_android_core_release$default(DatastoreFileReader datastoreFileReader, String str, Deserializer deserializer, Integer num, DataStoreReadCallback dataStoreReadCallback, TelemetryContext telemetryContext, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        datastoreFileReader.read$dd_sdk_android_core_release(str, deserializer, num, dataStoreReadCallback, telemetryContext);
    }

    public final <T> void read$dd_sdk_android_core_release(String key, Deserializer<String, T> deserializer, Integer version, DataStoreReadCallback<T> callback, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        File dataStoreFile$dd_sdk_android_core_release = this.dataStoreFileHelper.getDataStoreFile$dd_sdk_android_core_release(this.storageDir, this.featureName, key);
        if (!FileExtKt.existsSafe(dataStoreFile$dd_sdk_android_core_release, this.internalLogger)) {
            callback.onSuccess(null);
        } else {
            readFromDataStoreFile(dataStoreFile$dd_sdk_android_core_release, deserializer, this.tlvBlockFileReader, version, callback, telemetryContext);
        }
    }

    private final <T> void readFromDataStoreFile(File datastoreFile, Deserializer<String, T> deserializer, TLVBlockFileReader tlvBlockFileReader, Integer requestedVersion, DataStoreReadCallback<T> callback, TelemetryContext telemetryContext) {
        List<TLVBlock> list = tlvBlockFileReader.read$dd_sdk_android_core_release(datastoreFile, telemetryContext);
        int size = list.size();
        int length = TLVBlockType.values().length;
        if (size != length) {
            logInvalidNumberOfBlocksError(size, length);
            callback.onFailure();
            return;
        }
        DataStoreContent<T> dataStoreContentMapToDataStoreContents = mapToDataStoreContents(deserializer, list);
        if (dataStoreContentMapToDataStoreContents == null) {
            callback.onFailure();
            return;
        }
        if (requestedVersion != null) {
            if (requestedVersion.intValue() != dataStoreContentMapToDataStoreContents.getVersionCode()) {
                callback.onSuccess(null);
                return;
            }
        }
        callback.onSuccess(dataStoreContentMapToDataStoreContents);
    }

    private final <T> DataStoreContent<T> mapToDataStoreContents(Deserializer<String, T> deserializer, List<TLVBlock> tlvBlocks) {
        if (tlvBlocks.get(0).getType() != TLVBlockType.VERSION_CODE && tlvBlocks.get(1).getType() != TLVBlockType.DATA) {
            logBlocksInUnexpectedBlocksOrderError();
            return null;
        }
        return new DataStoreContent<>(ByteArrayExtKt.toInt(tlvBlocks.get(0).getData()), deserializer.deserialize(new String(tlvBlocks.get(1).getData(), Charsets.UTF_8)));
    }

    private final void logInvalidNumberOfBlocksError(final int numberBlocksFound, final int numberBlocksExpected) {
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.datastore.DatastoreFileReader.logInvalidNumberOfBlocksError.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, DatastoreFileReader.INVALID_NUMBER_OF_BLOCKS_ERROR, Arrays.copyOf(new Object[]{Integer.valueOf(numberBlocksFound), Integer.valueOf(numberBlocksExpected)}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    private final void logBlocksInUnexpectedBlocksOrderError() {
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.datastore.DatastoreFileReader.logBlocksInUnexpectedBlocksOrderError.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return DatastoreFileReader.UNEXPECTED_BLOCKS_ORDER_ERROR;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }
}
