package com.datadog.android.core.internal.persistence.datastore;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.storage.datastore.DataStoreHandler;
import com.datadog.android.api.storage.datastore.DataStoreReadCallback;
import com.datadog.android.api.storage.datastore.DataStoreWriteCallback;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.persistence.Serializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpDataStoreHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016JG\u0010\n\u001a\u00020\u0004\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u0002H\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0011H\u0016¢\u0006\u0002\u0010\u0012JK\u0010\u0013\u001a\u00020\u0004\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u000b0\u0016H\u0016¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/core/internal/persistence/datastore/NoOpDataStoreHandler;", "Lcom/datadog/android/api/storage/datastore/DataStoreHandler;", "()V", "clearAllData", "", "removeValue", "key", "", "callback", "Lcom/datadog/android/api/storage/datastore/DataStoreWriteCallback;", "setValue", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "version", "", "serializer", "Lcom/datadog/android/core/persistence/Serializer;", "(Ljava/lang/String;Ljava/lang/Object;ILcom/datadog/android/api/storage/datastore/DataStoreWriteCallback;Lcom/datadog/android/core/persistence/Serializer;)V", "value", "Lcom/datadog/android/api/storage/datastore/DataStoreReadCallback;", "deserializer", "Lcom/datadog/android/core/internal/persistence/Deserializer;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/datadog/android/api/storage/datastore/DataStoreReadCallback;Lcom/datadog/android/core/internal/persistence/Deserializer;)V", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDataStoreHandler implements DataStoreHandler {
    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void clearAllData() {
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void removeValue(String key, DataStoreWriteCallback callback) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public <T> void setValue(String key, T data, int version, DataStoreWriteCallback callback, Serializer<T> serializer) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public <T> void value(String key, Integer version, DataStoreReadCallback<T> callback, Deserializer<String, T> deserializer) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
    }
}
