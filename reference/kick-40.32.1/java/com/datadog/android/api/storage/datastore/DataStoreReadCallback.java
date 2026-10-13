package com.datadog.android.api.storage.datastore;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.core.persistence.datastore.DataStoreContent;
import kotlin.Metadata;

/* JADX INFO: compiled from: DataStoreReadCallback.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0018\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/datadog/android/api/storage/datastore/DataStoreReadCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onFailure", "", "onSuccess", "dataStoreContent", "Lcom/datadog/android/core/persistence/datastore/DataStoreContent;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DataStoreReadCallback<T> {
    void onFailure();

    void onSuccess(DataStoreContent<T> dataStoreContent);
}
