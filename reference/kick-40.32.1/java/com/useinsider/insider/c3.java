package com.useinsider.insider;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class c3 {
    static b3 a(JSONObject jSONObject) {
        b3 b3Var = new b3();
        b3Var.c(jSONObject.getInt("inapp_id"));
        b3Var.e(jSONObject.getInt("variant_id"));
        b3Var.b(jSONObject.optString("source"));
        b3Var.a(jSONObject.getString("show_type"));
        b3Var.d(jSONObject.getInt("priority"));
        b3Var.b(jSONObject.getInt("frequency"));
        b3Var.a(jSONObject.getInt("delay"));
        b3Var.a(jSONObject.optBoolean("ignore_inapp_blocking", false));
        b3Var.a(jSONObject.getJSONObject("content"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("condition");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("exclusion");
        if (jSONObjectOptJSONObject != null) {
            b3Var.a(new r2(q2.a(jSONObjectOptJSONObject.getString("relationship")), a(jSONObjectOptJSONObject.optJSONArray("events"))));
        }
        if (jSONObjectOptJSONObject2 != null) {
            b3Var.a(new a3(q2.a(jSONObjectOptJSONObject2.getString("relationship")), a(jSONObjectOptJSONObject2.optJSONArray("events")), jSONObjectOptJSONObject2.getInt("in_second")));
        }
        return b3Var;
    }

    private static List b(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                t2 t2VarA = t2.a(jSONObject.getString("operator"));
                arrayList.add(new s2(jSONObject.getString("key"), jSONObject.opt("value"), u2.a(jSONObject.getString("type")), t2VarA));
            }
        }
        return arrayList;
    }

    private static List a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                arrayList.add(new p2(jSONObject.getString("name"), jSONObject.optInt("repeats", 1), b(jSONObject.optJSONArray("parameters"))));
            }
        }
        return arrayList;
    }
}
