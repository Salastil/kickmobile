package com.datadog.android.api.storage;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import kotlin.Metadata;

/* JADX INFO: compiled from: DataWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/api/storage/DataWriter;", ExifInterface.GPS_DIRECTION_TRUE, "", "write", "", "writer", "Lcom/datadog/android/api/storage/EventBatchWriter;", "element", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Lcom/datadog/android/api/storage/EventType;", "(Lcom/datadog/android/api/storage/EventBatchWriter;Ljava/lang/Object;Lcom/datadog/android/api/storage/EventType;)Z", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DataWriter<T> {
    boolean write(EventBatchWriter writer, T element, EventType eventType);
}
