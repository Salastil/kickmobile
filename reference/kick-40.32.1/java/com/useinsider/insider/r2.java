package com.useinsider.insider;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class r2 extends d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q2 f417a;
    private final List b;

    r2(q2 q2Var, List list) {
        this.f417a = q2Var;
        this.b = list;
    }

    List a() {
        return this.b;
    }

    q2 b() {
        return this.f417a;
    }

    JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("relationship", b().b());
        JSONArray jSONArray = new JSONArray();
        Iterator it = a().iterator();
        while (it.hasNext()) {
            jSONArray.put(((p2) it.next()).toJSONObject());
        }
        jSONObject.put("events", jSONArray);
        return jSONObject;
    }
}
