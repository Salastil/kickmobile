package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.datadog.android.telemetry.model.TelemetryDebugEvent;
import com.datadog.android.telemetry.model.TelemetryErrorEvent;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumEventDeserializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/internal/domain/event/RumEventDeserializer;", "Lcom/datadog/android/core/internal/persistence/Deserializer;", "Lcom/google/gson/JsonObject;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "deserialize", "model", "parseEvent", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumEventDeserializer implements Deserializer<JsonObject, Object> {
    public static final String DESERIALIZE_ERROR_MESSAGE_FORMAT = "Error while trying to deserialize the RumEvent: %s";
    public static final String EVENT_TELEMETRY_KEY_NAME = "telemetry";
    public static final String EVENT_TELEMETRY_STATUS_KEY_NAME = "status";
    public static final String EVENT_TYPE_ACTION = "action";
    public static final String EVENT_TYPE_ERROR = "error";
    public static final String EVENT_TYPE_KEY_NAME = "type";
    public static final String EVENT_TYPE_LONG_TASK = "long_task";
    public static final String EVENT_TYPE_RESOURCE = "resource";
    public static final String EVENT_TYPE_TELEMETRY = "telemetry";
    public static final String EVENT_TYPE_VIEW = "view";
    public static final String TELEMETRY_TYPE_DEBUG = "debug";
    public static final String TELEMETRY_TYPE_ERROR = "error";
    private final InternalLogger internalLogger;

    public RumEventDeserializer(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.Deserializer
    public Object deserialize(final JsonObject model) {
        Intrinsics.checkNotNullParameter(model, "model");
        try {
            JsonPrimitive asJsonPrimitive = model.getAsJsonPrimitive("type");
            return parseEvent(asJsonPrimitive != null ? asJsonPrimitive.getAsString() : null, model);
        } catch (JsonParseException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.event.RumEventDeserializer.deserialize.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Error while trying to deserialize the RumEvent: %s", Arrays.copyOf(new Object[]{model}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.event.RumEventDeserializer.deserialize.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Error while trying to deserialize the RumEvent: %s", Arrays.copyOf(new Object[]{model}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Object parseEvent(String eventType, JsonObject model) throws JsonParseException {
        if (eventType != null) {
            switch (eventType.hashCode()) {
                case -1422950858:
                    if (eventType.equals("action")) {
                        return ActionEvent.INSTANCE.fromJsonObject(model);
                    }
                    break;
                case -341064690:
                    if (eventType.equals("resource")) {
                        return ResourceEvent.INSTANCE.fromJsonObject(model);
                    }
                    break;
                case 3619493:
                    if (eventType.equals("view")) {
                        return ViewEvent.INSTANCE.fromJsonObject(model);
                    }
                    break;
                case 96784904:
                    if (eventType.equals("error")) {
                        return ErrorEvent.INSTANCE.fromJsonObject(model);
                    }
                    break;
                case 128111976:
                    if (eventType.equals("long_task")) {
                        return LongTaskEvent.INSTANCE.fromJsonObject(model);
                    }
                    break;
                case 780346297:
                    if (eventType.equals("telemetry")) {
                        String asString = model.getAsJsonObject("telemetry").getAsJsonPrimitive("status").getAsString();
                        if (Intrinsics.areEqual(asString, "debug")) {
                            return TelemetryDebugEvent.INSTANCE.fromJsonObject(model);
                        }
                        if (Intrinsics.areEqual(asString, "error")) {
                            return TelemetryErrorEvent.INSTANCE.fromJsonObject(model);
                        }
                        throw new JsonParseException("We could not deserialize the telemetry event with status: " + asString);
                    }
                    break;
            }
        }
        throw new JsonParseException("We could not deserialize the event with type: " + eventType);
    }
}
