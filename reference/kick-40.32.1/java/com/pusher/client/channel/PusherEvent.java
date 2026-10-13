package com.pusher.client.channel;

import com.datadog.trace.core.propagation.HttpCodec;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class PusherEvent {
    private JsonObject jsonObject;

    public Object getProperty(String str) {
        str.hashCode();
        switch (str) {
            case "user_id":
                return getUserId();
            case "data":
                return this.jsonObject.get("data");
            case "event":
                return getEventName();
            case "channel":
                return getChannelName();
            default:
                return null;
        }
    }

    public String getUserId() {
        if (this.jsonObject.has(HttpCodec.RUM_KEY_USER_ID)) {
            return this.jsonObject.get(HttpCodec.RUM_KEY_USER_ID).getAsString();
        }
        return null;
    }

    public String getChannelName() {
        if (this.jsonObject.has("channel")) {
            return this.jsonObject.get("channel").getAsString();
        }
        return null;
    }

    public String getEventName() {
        if (this.jsonObject.has("event")) {
            return this.jsonObject.get("event").getAsString();
        }
        return null;
    }

    public String getData() {
        JsonElement jsonElement = this.jsonObject.get("data");
        if (jsonElement.isJsonPrimitive()) {
            return jsonElement.getAsString();
        }
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create().toJson(jsonElement);
    }

    public String toString() {
        return toJson();
    }

    public PusherEvent(String str, String str2, String str3, String str4) {
        JsonObject jsonObject = new JsonObject();
        this.jsonObject = jsonObject;
        jsonObject.addProperty("event", str);
        this.jsonObject.addProperty("channel", str2);
        this.jsonObject.addProperty("userId", str3);
        this.jsonObject.addProperty("data", str4);
    }

    public PusherEvent(String str, String str2, String str3, Map<String, Object> map) {
        this(str, str2, str3, new Gson().toJson(map));
    }

    public PusherEvent(JsonObject jsonObject) {
        new JsonObject();
        this.jsonObject = jsonObject;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson((JsonElement) this.jsonObject);
    }

    public static PusherEvent fromJson(String str) {
        return new PusherEvent((JsonObject) new GsonBuilder().disableHtmlEscaping().create().fromJson(str, JsonObject.class));
    }
}
