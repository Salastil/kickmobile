package com.datadog.android.api.storage.datastore;

import kotlin.Metadata;

/* JADX INFO: compiled from: DataStoreWriteCallback.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/api/storage/datastore/DataStoreWriteCallback;", "", "onFailure", "", "onSuccess", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DataStoreWriteCallback {
    void onFailure();

    void onSuccess();
}
