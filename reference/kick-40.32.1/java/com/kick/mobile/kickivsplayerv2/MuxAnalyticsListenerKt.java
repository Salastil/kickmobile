package com.kick.mobile.kickivsplayerv2;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: MuxAnalyticsListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0007\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"MUX_APPLICATION_NAME", "", "optStringOrNull", "Lorg/json/JSONObject;", "key", "optLongOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "optBooleanOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "kick-ivs-player-v2_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MuxAnalyticsListenerKt {
    private static final String MUX_APPLICATION_NAME = "KICK Live Streaming";

    /* JADX INFO: Access modifiers changed from: private */
    public static final String optStringOrNull(JSONObject jSONObject, String str) {
        String strOptString = jSONObject.optString(str);
        if (StringsKt.isBlank(strOptString)) {
            strOptString = null;
        }
        return strOptString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long optLongOrNull(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return Long.valueOf(jSONObject.optLong(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean optBooleanOrNull(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return Boolean.valueOf(jSONObject.optBoolean(str));
    }
}
