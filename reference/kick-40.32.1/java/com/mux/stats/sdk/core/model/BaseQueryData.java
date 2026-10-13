package com.mux.stats.sdk.core.model;

import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseQueryData {
    protected JSONObject query = new JSONObject();

    public static boolean isKeyJsonArray(JSONObject jSONObject, String str) {
        return jSONObject.optJSONArray(str) != null;
    }

    public static boolean isKeyJsonObject(JSONObject jSONObject, String str) {
        return jSONObject.optJSONObject(str) != null;
    }

    public void clear() {
        this.query = new JSONObject();
    }

    public String get(String str) throws JSONException {
        if (!this.query.has(str)) {
            return null;
        }
        String string = this.query.getString(str);
        if (string.isEmpty()) {
            return null;
        }
        return string;
    }

    public String getAllowsEmpty(String str) {
        if (this.query.has(str)) {
            return this.query.getString(str);
        }
        return null;
    }

    public String getDebugString() {
        return "BaseQueryData: \n    query: \n" + this.query.toString(2);
    }

    public JSONObject getMuxDictionary() {
        return new JSONObject(this.query.toString());
    }

    public boolean isEqualTo(BaseQueryData baseQueryData) throws JSONException {
        if (baseQueryData == null) {
            return false;
        }
        JSONArray jSONArrayKeys = baseQueryData.keys();
        if (jSONArrayKeys.length() != this.query.names().length()) {
            return false;
        }
        for (int i = 0; i < jSONArrayKeys.length(); i++) {
            String str = (String) jSONArrayKeys.get(i);
            String str2 = (String) this.query.names().get(i);
            String str3 = baseQueryData.get(str);
            String str4 = get(str2);
            if (!str.equalsIgnoreCase(str2) || !str3.equalsIgnoreCase(str4)) {
                return false;
            }
        }
        return true;
    }

    public JSONArray keys() {
        return this.query.names() == null ? new JSONArray() : this.query.names();
    }

    public void put(String str, String str2) throws JSONException {
        this.query.put(str, str2);
    }

    public void put(String str, JSONArray jSONArray) throws JSONException {
        this.query.put(str, jSONArray);
    }

    public void put(String str, JSONObject jSONObject) throws JSONException {
        this.query.put(str, jSONObject);
    }

    public void remove(String str) {
        this.query.remove(str);
    }

    public void replace(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.query = new JSONObject(jSONObject.toString());
            sync();
        }
    }

    public abstract void sync();

    public void update(@Nullable BaseQueryData baseQueryData) {
        if (baseQueryData != null) {
            synchronized (this) {
                synchronized (baseQueryData) {
                    update(baseQueryData.query);
                }
            }
        }
    }

    public void update(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames == null) {
            return;
        }
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            String str = (String) jSONArrayNames.get(i);
            if (isKeyJsonObject(jSONObject, str)) {
                this.query.put(str, new JSONObject(jSONObject.getJSONObject(str).toString()));
            } else if (isKeyJsonArray(jSONObject, str)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    jSONArray2.put(jSONArray.get(i2));
                }
                this.query.put(str, jSONArray2);
            } else {
                put(str, jSONObject.getString(str));
            }
        }
    }
}
