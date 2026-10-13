package com.datadog.android.api.storage;

import com.datadog.android.core.internal.storage.TelemetryAwareEventBatchWriter;
import com.datadog.android.internal.telemetry.TelemetryContext;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventBatchWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"write", "", "Lcom/datadog/android/api/storage/EventBatchWriter;", "event", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMetadata", "", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Lcom/datadog/android/api/storage/EventType;", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EventBatchWriterKt {
    public static final boolean write(EventBatchWriter eventBatchWriter, RawBatchEvent event, byte[] bArr, EventType eventType, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(eventBatchWriter, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        TelemetryAwareEventBatchWriter telemetryAwareEventBatchWriter = eventBatchWriter instanceof TelemetryAwareEventBatchWriter ? (TelemetryAwareEventBatchWriter) eventBatchWriter : null;
        if (telemetryAwareEventBatchWriter != null) {
            return telemetryAwareEventBatchWriter.write(event, bArr, eventType, telemetryContext);
        }
        return eventBatchWriter.write(event, bArr, eventType);
    }
}
