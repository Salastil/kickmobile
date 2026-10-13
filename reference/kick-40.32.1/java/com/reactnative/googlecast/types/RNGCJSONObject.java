package com.reactnative.googlecast.types;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class RNGCJSONObject {
    public static JSONObject fromJson(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        return new JSONObject(readableMap.toHashMap());
    }

    public static WritableMap toJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if ((obj instanceof Float) || (obj instanceof Double)) {
                    writableMapCreateMap.putDouble(next, jSONObject.getDouble(next));
                } else if (obj instanceof Number) {
                    writableMapCreateMap.putInt(next, jSONObject.getInt(next));
                } else if (obj instanceof String) {
                    writableMapCreateMap.putString(next, jSONObject.getString(next));
                } else if (obj instanceof JSONObject) {
                    writableMapCreateMap.putMap(next, toJson(jSONObject.getJSONObject(next)));
                } else if (obj instanceof JSONArray) {
                    writableMapCreateMap.putArray(next, toJson(jSONObject.getJSONArray(next)));
                } else if (obj == JSONObject.NULL) {
                    writableMapCreateMap.putNull(next);
                }
            } catch (JSONException unused) {
            }
        }
        return writableMapCreateMap;
    }

    private static WritableArray toJson(JSONArray jSONArray) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if ((obj instanceof Float) || (obj instanceof Double)) {
                    writableArrayCreateArray.pushDouble(jSONArray.getDouble(i));
                } else if (obj instanceof Number) {
                    writableArrayCreateArray.pushInt(jSONArray.getInt(i));
                } else if (obj instanceof String) {
                    writableArrayCreateArray.pushString(jSONArray.getString(i));
                } else if (obj instanceof JSONObject) {
                    writableArrayCreateArray.pushMap(toJson(jSONArray.getJSONObject(i)));
                } else if (obj instanceof JSONArray) {
                    writableArrayCreateArray.pushArray(toJson(jSONArray.getJSONArray(i)));
                } else if (obj == JSONObject.NULL) {
                    writableArrayCreateArray.pushNull();
                }
            } catch (JSONException unused) {
            }
        }
        return writableArrayCreateArray;
    }
}
