package com.datadog.android.api.storage.datastore;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.persistence.Serializer;
import kotlin.Metadata;

/* JADX INFO: compiled from: DataStoreHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&JK\u0010\t\u001a\u00020\u0003\"\b\b\u0000\u0010\n*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u0002H\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH&¢\u0006\u0002\u0010\u0010JM\u0010\u0011\u001a\u00020\u0003\"\b\b\u0000\u0010\n*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\n0\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\n0\u0014H&¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/api/storage/datastore/DataStoreHandler;", "", "clearAllData", "", "removeValue", "key", "", "callback", "Lcom/datadog/android/api/storage/datastore/DataStoreWriteCallback;", "setValue", ExifInterface.GPS_DIRECTION_TRUE, "data", "version", "", "serializer", "Lcom/datadog/android/core/persistence/Serializer;", "(Ljava/lang/String;Ljava/lang/Object;ILcom/datadog/android/api/storage/datastore/DataStoreWriteCallback;Lcom/datadog/android/core/persistence/Serializer;)V", "value", "Lcom/datadog/android/api/storage/datastore/DataStoreReadCallback;", "deserializer", "Lcom/datadog/android/core/internal/persistence/Deserializer;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/datadog/android/api/storage/datastore/DataStoreReadCallback;Lcom/datadog/android/core/internal/persistence/Deserializer;)V", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DataStoreHandler {
    public static final int CURRENT_DATASTORE_VERSION = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void clearAllData();

    void removeValue(String key, DataStoreWriteCallback callback);

    <T> void setValue(String key, T data, int version, DataStoreWriteCallback callback, Serializer<T> serializer);

    <T> void value(String key, Integer version, DataStoreReadCallback<T> callback, Deserializer<String, T> deserializer);

    /* JADX INFO: compiled from: DataStoreHandler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void setValue$default(DataStoreHandler dataStoreHandler, String str, Object obj, int i, DataStoreWriteCallback dataStoreWriteCallback, Serializer serializer, int i2, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setValue");
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                dataStoreWriteCallback = null;
            }
            dataStoreHandler.setValue(str, obj, i3, dataStoreWriteCallback, serializer);
        }

        public static /* synthetic */ void value$default(DataStoreHandler dataStoreHandler, String str, Integer num, DataStoreReadCallback dataStoreReadCallback, Deserializer deserializer, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: value");
            }
            if ((i & 2) != 0) {
                num = null;
            }
            dataStoreHandler.value(str, num, dataStoreReadCallback, deserializer);
        }

        public static /* synthetic */ void removeValue$default(DataStoreHandler dataStoreHandler, String str, DataStoreWriteCallback dataStoreWriteCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeValue");
            }
            if ((i & 2) != 0) {
                dataStoreWriteCallback = null;
            }
            dataStoreHandler.removeValue(str, dataStoreWriteCallback);
        }
    }

    /* JADX INFO: compiled from: DataStoreHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/api/storage/datastore/DataStoreHandler$Companion;", "", "()V", "CURRENT_DATASTORE_VERSION", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CURRENT_DATASTORE_VERSION = 0;

        private Companion() {
        }
    }
}
