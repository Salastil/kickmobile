package com.amazonaws.ivs.player;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class SessionConfig {
    private final JSONObject data;

    public SessionConfig() {
        JSONObject jSONObject = new JSONObject();
        this.data = jSONObject;
        try {
            jSONObject.put("adaptiveBitrate", new JSONObject());
            jSONObject.put("analytics", new JSONObject().put("additionalEventProperties", new JSONObject()));
        } catch (JSONException e) {
            Logging.w("Could not construct session data", e);
        }
    }

    public <T> SessionConfig addAnalyticsProperty(String str, T t) {
        try {
            this.data.getJSONObject("analytics").getJSONObject("additionalEventProperties").put(str, t);
            return this;
        } catch (JSONException e) {
            Logging.w("Could not add an additional analytics property", e);
            return this;
        }
    }

    public SessionConfig addAnalyticsProperty(String str, Integer num) {
        try {
            this.data.getJSONObject("analytics").getJSONObject("additionalEventProperties").put(str, num);
            return this;
        } catch (JSONException e) {
            Logging.w("Could not add an additional analytics property", e);
            return this;
        }
    }

    public SessionConfig setAdaptiveBitrateSurfaceSizeFilterEnabled(boolean z) {
        try {
            this.data.getJSONObject("adaptiveBitrate").put("surfaceSizeFilterEnabled", z);
            return this;
        } catch (JSONException e) {
            Logging.w("Failed to update configuration ", e);
            return this;
        }
    }

    JSONObject get() {
        return this.data;
    }
}
