package com.useinsider.insider;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class s2 extends d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f424a;
    private final Object b;
    private final u2 c;
    private final t2 d;

    s2(String str, Object obj, u2 u2Var, t2 t2Var) {
        this.f424a = str;
        this.b = obj;
        this.d = t2Var;
        this.c = u2Var;
    }

    String a() {
        return this.f424a;
    }

    t2 b() {
        return this.d;
    }

    u2 c() {
        return this.c;
    }

    Object d() {
        return this.b;
    }

    g1 e() {
        return new h1().a(a()).a(d()).a(b()).a(c()).a();
    }

    JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", this.f424a);
        jSONObject.putOpt("value", this.b);
        jSONObject.put("type", this.c.b());
        jSONObject.put("operator", this.d.b());
        return jSONObject;
    }
}
