package com.datadog.trace.core.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class JsonObjectUtils {
    public static String getAsString(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || !jsonElement.isJsonPrimitive()) {
            return null;
        }
        return jsonElement.getAsJsonPrimitive().getAsString();
    }

    public static Map<String, String> safeGetAsMap(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return null;
        }
        return safeGetAsMap(jsonElement.getAsJsonObject());
    }

    private static Map<String, String> safeGetAsMap(JsonObject jsonObject) {
        HashMap map = new HashMap();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            JsonElement value = entry.getValue();
            if (value.isJsonPrimitive()) {
                map.put(entry.getKey(), value.getAsJsonPrimitive().getAsString());
            }
        }
        return map;
    }
}
