package com.datadog.android.api.storage;

import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import kotlin.Metadata;

/* JADX INFO: compiled from: EventBatchWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/datadog/android/api/storage/EventBatchWriter;", "", "write", "", "event", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMetadata", "", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Lcom/datadog/android/api/storage/EventType;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface EventBatchWriter {
    boolean write(RawBatchEvent event, byte[] batchMetadata, EventType eventType);
}
