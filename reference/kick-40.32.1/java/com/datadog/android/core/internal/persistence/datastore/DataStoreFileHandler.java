package com.datadog.android.core.internal.persistence.datastore;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.datastore.DataStoreHandler;
import com.datadog.android.api.storage.datastore.DataStoreReadCallback;
import com.datadog.android.api.storage.datastore.DataStoreWriteCallback;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStoreFileHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016JG\u0010\u0013\u001a\u00020\u000e\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00140\u001aH\u0016¢\u0006\u0002\u0010\u001bJK\u0010\u001c\u001a\u00020\u000e\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00140\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00140\u001fH\u0016¢\u0006\u0002\u0010 R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/datadog/android/core/internal/persistence/datastore/DataStoreFileHandler;", "Lcom/datadog/android/api/storage/datastore/DataStoreHandler;", "featureName", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "dataStoreFileReader", "Lcom/datadog/android/core/internal/persistence/datastore/DatastoreFileReader;", "datastoreFileWriter", "Lcom/datadog/android/core/internal/persistence/datastore/DatastoreFileWriter;", "(Ljava/lang/String;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/internal/persistence/datastore/DatastoreFileReader;Lcom/datadog/android/core/internal/persistence/datastore/DatastoreFileWriter;)V", "clearAllData", "", "removeValue", "key", "callback", "Lcom/datadog/android/api/storage/datastore/DataStoreWriteCallback;", "setValue", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "version", "", "serializer", "Lcom/datadog/android/core/persistence/Serializer;", "(Ljava/lang/String;Ljava/lang/Object;ILcom/datadog/android/api/storage/datastore/DataStoreWriteCallback;Lcom/datadog/android/core/persistence/Serializer;)V", "value", "Lcom/datadog/android/api/storage/datastore/DataStoreReadCallback;", "deserializer", "Lcom/datadog/android/core/internal/persistence/Deserializer;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/datadog/android/api/storage/datastore/DataStoreReadCallback;Lcom/datadog/android/core/internal/persistence/Deserializer;)V", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataStoreFileHandler implements DataStoreHandler {
    private final DatastoreFileReader dataStoreFileReader;
    private final DatastoreFileWriter datastoreFileWriter;
    private final ExecutorService executorService;
    private final String featureName;
    private final InternalLogger internalLogger;

    public DataStoreFileHandler(String featureName, ExecutorService executorService, InternalLogger internalLogger, DatastoreFileReader dataStoreFileReader, DatastoreFileWriter datastoreFileWriter) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(dataStoreFileReader, "dataStoreFileReader");
        Intrinsics.checkNotNullParameter(datastoreFileWriter, "datastoreFileWriter");
        this.featureName = featureName;
        this.executorService = executorService;
        this.internalLogger = internalLogger;
        this.dataStoreFileReader = dataStoreFileReader;
        this.datastoreFileWriter = datastoreFileWriter;
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public <T> void setValue(final String key, final T data, final int version, final DataStoreWriteCallback callback, final Serializer<T> serializer) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        ConcurrencyExtKt.executeSafe(this.executorService, "dataStoreWrite", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.datastore.DataStoreFileHandler$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DataStoreFileHandler dataStoreFileHandler = this.f$0;
                dataStoreFileHandler.datastoreFileWriter.write$dd_sdk_android_core_release(key, data, serializer, callback, version, new TelemetryContext(dataStoreFileHandler.featureName, null, 2, null));
            }
        });
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void removeValue(final String key, final DataStoreWriteCallback callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrencyExtKt.executeSafe(this.executorService, "dataStoreRemove", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.datastore.DataStoreFileHandler$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.datastoreFileWriter.delete$dd_sdk_android_core_release(key, callback);
            }
        });
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void clearAllData() {
        ConcurrencyExtKt.executeSafe(this.executorService, "dataStoreClearAllData", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.datastore.DataStoreFileHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.datastoreFileWriter.clearAllData$dd_sdk_android_core_release();
            }
        });
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public <T> void value(final String key, final Integer version, final DataStoreReadCallback<T> callback, final Deserializer<String, T> deserializer) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        ConcurrencyExtKt.executeSafe(this.executorService, "dataStoreRead", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.datastore.DataStoreFileHandler$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DataStoreFileHandler dataStoreFileHandler = this.f$0;
                dataStoreFileHandler.dataStoreFileReader.read$dd_sdk_android_core_release(key, deserializer, version, callback, new TelemetryContext(dataStoreFileHandler.featureName, null, 2, null));
            }
        });
    }
}
