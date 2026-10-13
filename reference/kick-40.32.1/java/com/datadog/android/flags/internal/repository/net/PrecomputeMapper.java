package com.datadog.android.flags.internal.repository.net;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.flags.internal.model.JsonKeys;
import com.datadog.android.flags.internal.model.PrecomputedFlag;
import com.datadog.android.rum.internal.RumFeature;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PrecomputeMapper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/datadog/android/flags/internal/repository/net/PrecomputeMapper;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "map", "", "", "Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "rawJson", "map$dd_sdk_android_flags_release", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PrecomputeMapper {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String ERROR_FAILED_TO_PARSE_RESPONSE = "Failed to parse precomputed response";
    private final InternalLogger internalLogger;

    public PrecomputeMapper(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    public final Map<String, PrecomputedFlag> map$dd_sdk_android_flags_release(String rawJson) {
        String string;
        Intrinsics.checkNotNullParameter(rawJson, "rawJson");
        try {
            JSONObject jSONObject = new JSONObject(rawJson).getJSONObject("data").getJSONObject(RumFeature.EVENT_ATTRIBUTES_PROPERTY).getJSONObject("flags");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String flagKey = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(flagKey);
                String string2 = jSONObject2.getString(JsonKeys.VARIATION_TYPE.getValue());
                Intrinsics.checkNotNullExpressionValue(string2, "flagData.getString(JsonKeys.VARIATION_TYPE.value)");
                Object obj = jSONObject2.get(JsonKeys.VARIATION_VALUE.getValue());
                if (obj instanceof Boolean) {
                    string = obj.toString();
                } else if (obj instanceof String) {
                    string = (String) obj;
                } else {
                    string = obj instanceof Number ? obj.toString() : obj.toString();
                }
                boolean z = jSONObject2.getBoolean(JsonKeys.DO_LOG.getValue());
                String string3 = jSONObject2.getString(JsonKeys.ALLOCATION_KEY.getValue());
                Intrinsics.checkNotNullExpressionValue(string3, "flagData.getString(JsonKeys.ALLOCATION_KEY.value)");
                String string4 = jSONObject2.getString(JsonKeys.VARIATION_KEY.getValue());
                Intrinsics.checkNotNullExpressionValue(string4, "flagData.getString(JsonKeys.VARIATION_KEY.value)");
                JSONObject jSONObject3 = jSONObject2.getJSONObject(JsonKeys.EXTRA_LOGGING.getValue());
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "flagData.getJSONObject(J…Keys.EXTRA_LOGGING.value)");
                String string5 = jSONObject2.getString(JsonKeys.REASON.getValue());
                Intrinsics.checkNotNullExpressionValue(string5, "flagData.getString(JsonKeys.REASON.value)");
                Object objOpt = jSONObject2.opt(JsonKeys.SERIAL_ID.getValue());
                Long lValueOf = null;
                Number number = objOpt instanceof Number ? (Number) objOpt : null;
                if (number != null) {
                    lValueOf = Long.valueOf(number.longValue());
                }
                PrecomputedFlag precomputedFlag = new PrecomputedFlag(string2, string, z, string3, string4, jSONObject3, string5, lValueOf);
                Intrinsics.checkNotNullExpressionValue(flagKey, "flagKey");
                linkedHashMap.put(flagKey, precomputedFlag);
            }
            return linkedHashMap;
        } catch (JSONException e) {
            JSONException jSONException = e;
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.repository.net.PrecomputeMapper$map$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return PrecomputeMapper.ERROR_FAILED_TO_PARSE_RESPONSE;
                }
            }, (Throwable) jSONException, false, (Map) null, 48, (Object) null);
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.repository.net.PrecomputeMapper$map$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return PrecomputeMapper.ERROR_FAILED_TO_PARSE_RESPONSE;
                }
            }, (Throwable) jSONException, true, (Map) null, 32, (Object) null);
            return MapsKt.emptyMap();
        }
    }

    /* JADX INFO: compiled from: PrecomputeMapper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/flags/internal/repository/net/PrecomputeMapper$Companion;", "", "()V", "ERROR_FAILED_TO_PARSE_RESPONSE", "", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
