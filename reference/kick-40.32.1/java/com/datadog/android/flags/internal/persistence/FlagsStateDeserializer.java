package com.datadog.android.flags.internal.persistence;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.flags.internal.model.FlagsStateEntry;
import com.datadog.android.flags.internal.model.JsonKeys;
import com.datadog.android.flags.internal.model.PrecomputedFlag;
import com.datadog.android.flags.model.EvaluationContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FlagsStateDeserializer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/flags/internal/persistence/FlagsStateDeserializer;", "Lcom/datadog/android/core/internal/persistence/Deserializer;", "", "Lcom/datadog/android/flags/internal/model/FlagsStateEntry;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "deserialize", "model", "deserializeAttributes", "", "attributesJson", "Lorg/json/JSONObject;", "deserializeEvaluationContext", "Lcom/datadog/android/flags/model/EvaluationContext;", "contextJson", "deserializeFlags", "Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "flagsJson", "deserializePrecomputedFlag", "flagJson", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlagsStateDeserializer implements Deserializer<String, FlagsStateEntry> {
    private final InternalLogger internalLogger;

    public FlagsStateDeserializer(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.Deserializer
    public FlagsStateEntry deserialize(String model) {
        Intrinsics.checkNotNullParameter(model, "model");
        try {
            JSONObject jSONObject = new JSONObject(model);
            JSONObject contextJson = jSONObject.getJSONObject(JsonKeys.EVALUATION_CONTEXT.getValue());
            Intrinsics.checkNotNullExpressionValue(contextJson, "contextJson");
            EvaluationContext evaluationContextDeserializeEvaluationContext = deserializeEvaluationContext(contextJson);
            JSONObject flagsJson = jSONObject.getJSONObject(JsonKeys.FLAGS.getValue());
            Intrinsics.checkNotNullExpressionValue(flagsJson, "flagsJson");
            return new FlagsStateEntry(evaluationContextDeserializeEvaluationContext, deserializeFlags(flagsJson), jSONObject.getLong(JsonKeys.LAST_UPDATE_TIMESTAMP.getValue()));
        } catch (JSONException e) {
            JSONException jSONException = e;
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.persistence.FlagsStateDeserializer.deserialize.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to deserialize FlagsStateEntry from JSON";
                }
            }, (Throwable) jSONException, false, (Map) null, 48, (Object) null);
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.persistence.FlagsStateDeserializer.deserialize.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to parse persisted flag state";
                }
            }, (Throwable) jSONException, true, (Map) null, 32, (Object) null);
            return null;
        }
    }

    private final EvaluationContext deserializeEvaluationContext(JSONObject contextJson) throws JSONException {
        Map<String, String> mapEmptyMap;
        String targetingKey = contextJson.getString(JsonKeys.TARGETING_KEY.getValue());
        try {
            JSONObject jSONObject = contextJson.getJSONObject(JsonKeys.ATTRIBUTES.getValue());
            Intrinsics.checkNotNullExpressionValue(jSONObject, "contextJson.getJSONObjec…sonKeys.ATTRIBUTES.value)");
            mapEmptyMap = deserializeAttributes(jSONObject);
        } catch (JSONException unused) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        Intrinsics.checkNotNullExpressionValue(targetingKey, "targetingKey");
        return new EvaluationContext(targetingKey, mapEmptyMap);
    }

    private final Map<String, String> deserializeAttributes(JSONObject attributesJson) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = attributesJson.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            String string = attributesJson.get(key).toString();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            linkedHashMap.put(key, string);
        }
        return linkedHashMap;
    }

    private final Map<String, PrecomputedFlag> deserializeFlags(JSONObject flagsJson) throws JSONException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = flagsJson.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            JSONObject flagJson = flagsJson.getJSONObject(key);
            Intrinsics.checkNotNullExpressionValue(flagJson, "flagJson");
            PrecomputedFlag precomputedFlagDeserializePrecomputedFlag = deserializePrecomputedFlag(flagJson);
            if (precomputedFlagDeserializePrecomputedFlag != null) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, precomputedFlagDeserializePrecomputedFlag);
            }
        }
        return linkedHashMap;
    }

    private final PrecomputedFlag deserializePrecomputedFlag(JSONObject flagJson) {
        try {
            String string = flagJson.getString(JsonKeys.VARIATION_TYPE.getValue());
            Intrinsics.checkNotNullExpressionValue(string, "flagJson.getString(JsonKeys.VARIATION_TYPE.value)");
            String string2 = flagJson.getString(JsonKeys.VARIATION_VALUE.getValue());
            Intrinsics.checkNotNullExpressionValue(string2, "flagJson.getString(JsonKeys.VARIATION_VALUE.value)");
            boolean z = flagJson.getBoolean(JsonKeys.DO_LOG.getValue());
            String string3 = flagJson.getString(JsonKeys.ALLOCATION_KEY.getValue());
            Intrinsics.checkNotNullExpressionValue(string3, "flagJson.getString(JsonKeys.ALLOCATION_KEY.value)");
            String string4 = flagJson.getString(JsonKeys.VARIATION_KEY.getValue());
            Intrinsics.checkNotNullExpressionValue(string4, "flagJson.getString(JsonKeys.VARIATION_KEY.value)");
            JSONObject jSONObject = flagJson.getJSONObject(JsonKeys.EXTRA_LOGGING.getValue());
            Intrinsics.checkNotNullExpressionValue(jSONObject, "flagJson.getJSONObject(J…Keys.EXTRA_LOGGING.value)");
            String string5 = flagJson.getString(JsonKeys.REASON.getValue());
            Intrinsics.checkNotNullExpressionValue(string5, "flagJson.getString(JsonKeys.REASON.value)");
            Object objOpt = flagJson.opt(JsonKeys.SERIAL_ID.getValue());
            Number number = objOpt instanceof Number ? (Number) objOpt : null;
            return new PrecomputedFlag(string, string2, z, string3, string4, jSONObject, string5, number != null ? Long.valueOf(number.longValue()) : null);
        } catch (JSONException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.persistence.FlagsStateDeserializer.deserializePrecomputedFlag.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to deserialize precomputed flag, skipping";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }
}
