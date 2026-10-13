package com.datadog.reactnative;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.flags.FlagsConfiguration;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.flags.model.UnparsedFlag;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.react.bridge.ReadableMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: DdFlagsImplementation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002\u001a&\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"buildFlagsConfiguration", "Lcom/datadog/android/flags/FlagsConfiguration;", "configuration", "", "", "", "buildEvaluationContext", "Lcom/datadog/android/flags/model/EvaluationContext;", "targetingKey", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "Lcom/facebook/react/bridge/ReadableMap;", "SERIAL_ID_KEY", "convertUnparsedFlagToMap", "flagKey", "flag", "Lcom/datadog/android/flags/model/UnparsedFlag;", "convertMapToUnparsedFlag", "map", "datadog_mobile-react-native_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DdFlagsImplementationKt {
    private static final String SERIAL_ID_KEY = "serialId";

    /* JADX INFO: Access modifiers changed from: private */
    public static final FlagsConfiguration buildFlagsConfiguration(Map<String, ? extends Object> map) {
        Object obj = map.get("enabled");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (!(bool != null ? bool.booleanValue() : false)) {
            return null;
        }
        Object obj2 = map.get("trackExposures");
        Boolean bool2 = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        boolean zBooleanValue = bool2 != null ? bool2.booleanValue() : true;
        Object obj3 = map.get("rumIntegrationEnabled");
        Boolean bool3 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
        boolean zBooleanValue2 = bool3 != null ? bool3.booleanValue() : true;
        FlagsConfiguration.Builder builder = new FlagsConfiguration.Builder();
        builder.gracefulModeEnabled(true);
        builder.trackExposures(zBooleanValue);
        builder.rumIntegrationEnabled(zBooleanValue2);
        Object obj4 = map.get("customFlagsEndpoint");
        String str = obj4 instanceof String ? (String) obj4 : null;
        if (str != null) {
            builder.useCustomFlagEndpoint(str + "/precompute-assignments");
        }
        Object obj5 = map.get("customExposureEndpoint");
        String str2 = obj5 instanceof String ? (String) obj5 : null;
        if (str2 != null) {
            builder.useCustomExposureEndpoint(str2 + "/api/v2/exposures");
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EvaluationContext buildEvaluationContext(String str, ReadableMap readableMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> entryIterator = readableMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            linkedHashMap.put(next.getKey(), String.valueOf(next.getValue()));
        }
        return new EvaluationContext(str, linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x007a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0083  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Map<String, Object> convertUnparsedFlagToMap(final String str, final UnparsedFlag unparsedFlag) {
        Object map;
        String variationType = unparsedFlag.getVariationType();
        switch (variationType.hashCode()) {
            case -1034364087:
                if (!variationType.equals("number")) {
                    map = null;
                } else {
                    map = StringsKt.toDoubleOrNull(unparsedFlag.getVariationValue());
                }
                break;
            case -1023368385:
                if (!variationType.equals("object")) {
                    map = null;
                } else {
                    try {
                        map = DdSdkBridgeExtKt.toMap(new JSONObject(unparsedFlag.getVariationValue()));
                    } catch (Exception unused) {
                        map = null;
                    }
                }
                break;
            case -891985903:
                if (!variationType.equals(TypedValues.Custom.S_STRING)) {
                    map = null;
                } else {
                    map = unparsedFlag.getVariationValue();
                }
                break;
            case 64711720:
                if (!variationType.equals(TypedValues.Custom.S_BOOLEAN)) {
                    map = null;
                } else {
                    String variationValue = unparsedFlag.getVariationValue();
                    Locale US = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    String lowerCase = variationValue.toLowerCase(US);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    map = StringsKt.toBooleanStrictOrNull(lowerCase);
                }
                break;
            case 97526364:
                if (!variationType.equals(TypedValues.Custom.S_FLOAT)) {
                    map = null;
                } else {
                    map = StringsKt.toDoubleOrNull(unparsedFlag.getVariationValue());
                }
                break;
            case 1958052158:
                if (!variationType.equals(TypedValues.Custom.S_INT)) {
                    map = null;
                } else {
                    map = StringsKt.toIntOrNull(unparsedFlag.getVariationValue());
                }
                break;
            default:
                map = null;
                break;
        }
        if (map == null) {
            InternalLogger.DefaultImpls.log$default(InternalLogger.INSTANCE.getUNBOUND(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.reactnative.DdFlagsImplementationKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DdFlagsImplementationKt.convertUnparsedFlagToMap$lambda$0(str, unparsedFlag);
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        Pair[] pairArr = new Pair[10];
        pairArr[0] = TuplesKt.to("key", str);
        if (map == null) {
            map = unparsedFlag.getVariationValue();
        }
        pairArr[1] = TuplesKt.to("value", map);
        pairArr[2] = TuplesKt.to("allocationKey", unparsedFlag.getAllocationKey());
        pairArr[3] = TuplesKt.to("variationKey", unparsedFlag.getVariationKey());
        pairArr[4] = TuplesKt.to("variationType", unparsedFlag.getVariationType());
        pairArr[5] = TuplesKt.to("variationValue", unparsedFlag.getVariationValue());
        pairArr[6] = TuplesKt.to("reason", unparsedFlag.getReason());
        pairArr[7] = TuplesKt.to("doLog", Boolean.valueOf(unparsedFlag.getDoLog()));
        pairArr[8] = TuplesKt.to("extraLogging", DdSdkBridgeExtKt.toMap(unparsedFlag.getExtraLogging()));
        Long serialId = unparsedFlag.getSerialId();
        pairArr[9] = TuplesKt.to(SERIAL_ID_KEY, serialId != null ? String.valueOf(serialId.longValue()) : null);
        return MapsKt.mapOf(pairArr);
    }

    static final String convertUnparsedFlagToMap$lambda$0(String str, UnparsedFlag unparsedFlag) {
        return "Flag '" + str + "': Failed to parse value '" + unparsedFlag.getVariationValue() + "' as '" + unparsedFlag.getVariationType() + "'";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UnparsedFlag convertMapToUnparsedFlag(Map<String, ? extends Object> map) {
        return new UnparsedFlag(map) { // from class: com.datadog.reactnative.DdFlagsImplementationKt.convertMapToUnparsedFlag.1
            private final String allocationKey;
            private final boolean doLog;
            private final JSONObject extraLogging;
            private final String reason;
            private final Long serialId;
            private final String variationKey;
            private final String variationType;
            private final String variationValue;

            {
                Long longOrNull;
                JSONObject jSONObject;
                Object obj = map.get("variationType");
                Long lValueOf = null;
                String str = obj instanceof String ? (String) obj : null;
                this.variationType = str == null ? "" : str;
                Object obj2 = map.get("variationValue");
                String str2 = obj2 instanceof String ? (String) obj2 : null;
                this.variationValue = str2 == null ? "" : str2;
                Object obj3 = map.get("doLog");
                Boolean bool = obj3 instanceof Boolean ? (Boolean) obj3 : null;
                this.doLog = bool != null ? bool.booleanValue() : false;
                Object obj4 = map.get("allocationKey");
                String str3 = obj4 instanceof String ? (String) obj4 : null;
                this.allocationKey = str3 == null ? "" : str3;
                Object obj5 = map.get("variationKey");
                String str4 = obj5 instanceof String ? (String) obj5 : null;
                this.variationKey = str4 == null ? "" : str4;
                Object obj6 = map.get("extraLogging");
                Map map2 = obj6 instanceof Map ? (Map) obj6 : null;
                this.extraLogging = (map2 == null || (jSONObject = DdSdkBridgeExtKt.toJSONObject((Map<String, ? extends Object>) map2)) == null) ? new JSONObject() : jSONObject;
                Object obj7 = map.get("reason");
                String str5 = obj7 instanceof String ? (String) obj7 : null;
                this.reason = str5 != null ? str5 : "";
                Object obj8 = map.get(DdFlagsImplementationKt.SERIAL_ID_KEY);
                String str6 = obj8 instanceof String ? (String) obj8 : null;
                if (str6 == null || (longOrNull = StringsKt.toLongOrNull(str6)) == null) {
                    Object obj9 = map.get(DdFlagsImplementationKt.SERIAL_ID_KEY);
                    Number number = obj9 instanceof Number ? (Number) obj9 : null;
                    if (number != null) {
                        lValueOf = Long.valueOf(number.longValue());
                    }
                } else {
                    lValueOf = longOrNull;
                }
                this.serialId = lValueOf;
            }

            @Override // com.datadog.android.flags.model.UnparsedFlag
            public String getVariationType() {
                return this.variationType;
            }

            @Override // com.datadog.android.flags.model.UnparsedFlag
            public String getVariationValue() {
                return this.variationValue;
            }

            @Override // com.datadog.android.flags.model.UnparsedFlag
            public boolean getDoLog() {
                return this.doLog;
            }

            @Override // com.datadog.android.flags.model.UnparsedFlag
            public String getAllocationKey() {
                return this.allocationKey;
            }

            @Override // com.datadog.android.flags.model.UnparsedFlag
            public String getVariationKey() {
                return this.variationKey;
            }

            @Override // com.datadog.android.flags.model.UnparsedFlag
            public JSONObject getExtraLogging() {
                return this.extraLogging;
            }

            @Override // com.datadog.android.flags.model.UnparsedFlag
            public String getReason() {
                return this.reason;
            }

            @Override // com.datadog.android.flags.model.UnparsedFlag
            public Long getSerialId() {
                return this.serialId;
            }
        };
    }
}
