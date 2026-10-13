package com.datadog.android.rum.internal.domain;

import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventBatchWriterKt;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.core.persistence.SerializerKt;
import com.datadog.android.internal.telemetry.TelemetryContext;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.TimeseriesCpuEvent;
import com.datadog.android.rum.model.TimeseriesMemoryEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.datadog.android.rum.model.VitalAppLaunchEvent;
import com.datadog.android.rum.model.VitalOperationStepEvent;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import com.datadog.android.telemetry.model.TelemetryDebugEvent;
import com.datadog.android.telemetry.model.TelemetryErrorEvent;
import com.datadog.android.telemetry.model.TelemetryUsageEvent;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumDataWriter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0015H\u0001¢\u0006\u0002\b\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0017R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/datadog/android/rum/internal/domain/RumDataWriter;", "Lcom/datadog/android/api/storage/DataWriter;", "", "eventSerializer", "Lcom/datadog/android/core/persistence/Serializer;", "eventMetaSerializer", "Lcom/datadog/android/rum/internal/domain/event/RumEventMeta;", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "(Lcom/datadog/android/core/persistence/Serializer;Lcom/datadog/android/core/persistence/Serializer;Lcom/datadog/android/core/InternalSdkCore;)V", "currentViewId", "", "getEventSerializer$dd_sdk_android_rum_release", "()Lcom/datadog/android/core/persistence/Serializer;", "onDataWritten", "", "data", Constants.MessagePayloadKeys.RAW_DATA, "", "onDataWritten$dd_sdk_android_rum_release", "onViewEventSubmitted", "Lcom/datadog/android/rum/model/ViewEvent;", "onViewEventSubmitted$dd_sdk_android_rum_release", "onViewEventWritten", "write", "", "writer", "Lcom/datadog/android/api/storage/EventBatchWriter;", "element", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Lcom/datadog/android/api/storage/EventType;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumDataWriter implements DataWriter<Object> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final long FIRST_VIEW_DOCUMENT_VERSION = 2;
    private static final String UNKNOWN_EVENT_TYPE = "unknown";
    private String currentViewId;
    private final Serializer<RumEventMeta> eventMetaSerializer;
    private final Serializer<Object> eventSerializer;
    private final InternalSdkCore sdkCore;

    public RumDataWriter(Serializer<Object> eventSerializer, Serializer<RumEventMeta> eventMetaSerializer, InternalSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(eventSerializer, "eventSerializer");
        Intrinsics.checkNotNullParameter(eventMetaSerializer, "eventMetaSerializer");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.eventSerializer = eventSerializer;
        this.eventMetaSerializer = eventMetaSerializer;
        this.sdkCore = sdkCore;
    }

    public final Serializer<Object> getEventSerializer$dd_sdk_android_rum_release() {
        return this.eventSerializer;
    }

    @Override // com.datadog.android.api.storage.DataWriter
    public boolean write(EventBatchWriter writer, Object element, EventType eventType) {
        RawBatchEvent rawBatchEvent;
        boolean zWrite;
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        boolean z = element instanceof ViewEvent;
        if (z) {
            onViewEventSubmitted$dd_sdk_android_rum_release((ViewEvent) element);
        }
        byte[] bArrSerializeToByteArray = SerializerKt.serializeToByteArray(this.eventSerializer, element, this.sdkCore.getInternalLogger());
        if (bArrSerializeToByteArray == null) {
            return false;
        }
        if (z) {
            ViewEvent viewEvent = (ViewEvent) element;
            byte[] bArrSerializeToByteArray2 = SerializerKt.serializeToByteArray(this.eventMetaSerializer, new RumEventMeta.View(viewEvent.getView().getId(), viewEvent.getDd().getDocumentVersion(), Boolean.valueOf(viewEvent.getView().getAccessibility() != null)), this.sdkCore.getInternalLogger());
            if (bArrSerializeToByteArray2 == null) {
                bArrSerializeToByteArray2 = EMPTY_BYTE_ARRAY;
            }
            rawBatchEvent = new RawBatchEvent(bArrSerializeToByteArray, bArrSerializeToByteArray2);
        } else {
            rawBatchEvent = new RawBatchEvent(bArrSerializeToByteArray, null, 2, null);
        }
        synchronized (this) {
            zWrite = EventBatchWriterKt.write(writer, rawBatchEvent, null, eventType, new TelemetryContext("rum", INSTANCE.resolveEventType(element)));
            if (zWrite) {
                onDataWritten$dd_sdk_android_rum_release(element, bArrSerializeToByteArray);
            }
        }
        return zWrite;
    }

    public final void onDataWritten$dd_sdk_android_rum_release(Object data, byte[] rawData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        if (data instanceof ViewEvent) {
            onViewEventWritten((ViewEvent) data, rawData);
        }
    }

    public final void onViewEventSubmitted$dd_sdk_android_rum_release(ViewEvent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        synchronized (this) {
            if (data.getDd().getDocumentVersion() == 2) {
                this.currentViewId = data.getView().getId();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void onViewEventWritten(ViewEvent data, byte[] rawData) {
        if (Intrinsics.areEqual(data.getView().getId(), this.currentViewId)) {
            this.sdkCore.writeLastViewEvent(rawData);
        }
    }

    /* JADX INFO: compiled from: RumDataWriter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0001H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/internal/domain/RumDataWriter$Companion;", "", "()V", "EMPTY_BYTE_ARRAY", "", "getEMPTY_BYTE_ARRAY", "()[B", "FIRST_VIEW_DOCUMENT_VERSION", "", "UNKNOWN_EVENT_TYPE", "", "resolveEventType", "event", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final byte[] getEMPTY_BYTE_ARRAY() {
            return RumDataWriter.EMPTY_BYTE_ARRAY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String resolveEventType(Object event) {
            if (event instanceof ActionEvent) {
                return ((ActionEvent) event).getType();
            }
            if (event instanceof ErrorEvent) {
                return ((ErrorEvent) event).getType();
            }
            if (event instanceof LongTaskEvent) {
                return ((LongTaskEvent) event).getType();
            }
            if (event instanceof ResourceEvent) {
                return ((ResourceEvent) event).getType();
            }
            if (event instanceof ViewEvent) {
                return ((ViewEvent) event).getType();
            }
            if (event instanceof VitalAppLaunchEvent) {
                return ((VitalAppLaunchEvent) event).getType();
            }
            if (event instanceof VitalOperationStepEvent) {
                return ((VitalOperationStepEvent) event).getType();
            }
            if (event instanceof TelemetryConfigurationEvent) {
                return ((TelemetryConfigurationEvent) event).getType();
            }
            if (event instanceof TelemetryDebugEvent) {
                return ((TelemetryDebugEvent) event).getType();
            }
            if (event instanceof TelemetryErrorEvent) {
                return ((TelemetryErrorEvent) event).getType();
            }
            if (event instanceof TelemetryUsageEvent) {
                return ((TelemetryUsageEvent) event).getType();
            }
            if (event instanceof TimeseriesCpuEvent) {
                return ((TimeseriesCpuEvent) event).getType();
            }
            return event instanceof TimeseriesMemoryEvent ? ((TimeseriesMemoryEvent) event).getType() : "unknown";
        }
    }
}
