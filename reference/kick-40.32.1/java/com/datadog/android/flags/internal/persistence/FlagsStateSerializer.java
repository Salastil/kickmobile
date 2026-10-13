package com.datadog.android.flags.internal.persistence;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.flags.internal.model.FlagsStateEntry;
import com.datadog.android.flags.internal.model.JsonKeys;
import com.datadog.android.flags.internal.model.PrecomputedFlag;
import com.datadog.android.rum.internal.RumFeature;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FlagsStateSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/flags/internal/persistence/FlagsStateSerializer;", "Lcom/datadog/android/core/persistence/Serializer;", "Lcom/datadog/android/flags/internal/model/FlagsStateEntry;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "serialize", "", "model", "serializeAttributes", "Lorg/json/JSONObject;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "serializePrecomputedFlag", "flag", "Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlagsStateSerializer implements Serializer<FlagsStateEntry> {
    private final InternalLogger internalLogger;

    public FlagsStateSerializer(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.persistence.Serializer
    public String serialize(FlagsStateEntry model) {
        Intrinsics.checkNotNullParameter(model, "model");
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(JsonKeys.TARGETING_KEY.getValue(), model.getEvaluationContext().getTargetingKey());
            jSONObject2.put(JsonKeys.ATTRIBUTES.getValue(), serializeAttributes(model.getEvaluationContext().getAttributes()));
            jSONObject.put(JsonKeys.EVALUATION_CONTEXT.getValue(), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, PrecomputedFlag> entry : model.getFlags().entrySet()) {
                jSONObject3.put(entry.getKey(), serializePrecomputedFlag(entry.getValue()));
            }
            jSONObject.put(JsonKeys.FLAGS.getValue(), jSONObject3);
            jSONObject.put(JsonKeys.LAST_UPDATE_TIMESTAMP.getValue(), model.getLastUpdateTimestamp());
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "{\n        val json = JSO…    json.toString()\n    }");
            return string;
        } catch (JSONException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.persistence.FlagsStateSerializer.serialize.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to serialize FlagsStateEntry to JSON";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return "";
        }
    }

    private final JSONObject serializeAttributes(Map<String, ? extends Object> attributes) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : attributes.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    private final JSONObject serializePrecomputedFlag(PrecomputedFlag flag) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonKeys.VARIATION_TYPE.getValue(), flag.getVariationType());
        jSONObject.put(JsonKeys.VARIATION_VALUE.getValue(), flag.getVariationValue());
        jSONObject.put(JsonKeys.DO_LOG.getValue(), flag.getDoLog());
        jSONObject.put(JsonKeys.ALLOCATION_KEY.getValue(), flag.getAllocationKey());
        jSONObject.put(JsonKeys.VARIATION_KEY.getValue(), flag.getVariationKey());
        jSONObject.put(JsonKeys.EXTRA_LOGGING.getValue(), flag.getExtraLogging());
        jSONObject.put(JsonKeys.REASON.getValue(), flag.getReason());
        Long serialId = flag.getSerialId();
        if (serialId != null) {
            jSONObject.put(JsonKeys.SERIAL_ID.getValue(), serialId.longValue());
        }
        return jSONObject;
    }
}
