package com.useinsider.insider;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class o2 {
    static JSONObject a(JSONObject jSONObject) {
        Object objA;
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (obj != null && obj != JSONObject.NULL && (objA = a(obj)) != null) {
                    jSONObject2.put(next, objA);
                }
            }
            if (jSONObject2.length() == 0) {
                return null;
            }
            return jSONObject2;
        } catch (JSONException e) {
            Insider.Instance.putException(e);
            return jSONObject;
        }
    }

    private static Object a(Object obj) {
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        try {
            if (obj instanceof JSONObject) {
                JSONObject jSONObjectA = a((JSONObject) obj);
                if (jSONObjectA == null || jSONObjectA.length() <= 0) {
                    return null;
                }
                return jSONObjectA;
            }
            if (!(obj instanceof JSONArray)) {
                return obj;
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = (JSONArray) obj;
            for (int i = 0; i < jSONArray2.length(); i++) {
                Object objA = a(jSONArray2.get(i));
                if (objA != null) {
                    jSONArray.put(objA);
                }
            }
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
            return null;
        } catch (JSONException e) {
            Insider.Instance.putException(e);
            return obj;
        }
    }
}
