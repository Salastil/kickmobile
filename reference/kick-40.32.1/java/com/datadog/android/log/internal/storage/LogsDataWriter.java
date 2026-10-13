package com.datadog.android.log.internal.storage;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.core.persistence.SerializerKt;
import com.datadog.android.log.model.LogEvent;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogsDataWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/log/internal/storage/LogsDataWriter;", "Lcom/datadog/android/api/storage/DataWriter;", "Lcom/datadog/android/log/model/LogEvent;", "serializer", "Lcom/datadog/android/core/persistence/Serializer;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/core/persistence/Serializer;Lcom/datadog/android/api/InternalLogger;)V", "getSerializer$dd_sdk_android_logs_release", "()Lcom/datadog/android/core/persistence/Serializer;", "write", "", "writer", "Lcom/datadog/android/api/storage/EventBatchWriter;", "element", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Lcom/datadog/android/api/storage/EventType;", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LogsDataWriter implements DataWriter<LogEvent> {
    private final InternalLogger internalLogger;
    private final Serializer<LogEvent> serializer;

    public LogsDataWriter(Serializer<LogEvent> serializer, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.serializer = serializer;
        this.internalLogger = internalLogger;
    }

    public final Serializer<LogEvent> getSerializer$dd_sdk_android_logs_release() {
        return this.serializer;
    }

    @Override // com.datadog.android.api.storage.DataWriter
    public boolean write(EventBatchWriter writer, LogEvent element, EventType eventType) {
        boolean zWrite;
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        byte[] bArrSerializeToByteArray = SerializerKt.serializeToByteArray(this.serializer, element, this.internalLogger);
        if (bArrSerializeToByteArray == null) {
            return false;
        }
        synchronized (this) {
            zWrite = writer.write(new RawBatchEvent(bArrSerializeToByteArray, null, 2, null), null, eventType);
        }
        return zWrite;
    }
}
