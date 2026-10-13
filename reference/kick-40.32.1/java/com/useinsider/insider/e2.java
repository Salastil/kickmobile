package com.useinsider.insider;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class e2 implements d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f326a = new HashMap();

    e2() {
        b();
    }

    private String a() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage() + "-" + locale.getCountry() + ",en;q=0.9";
    }

    private void b() {
        this.f326a.put("Accept-Language", a());
    }

    @Override // com.useinsider.insider.d2
    public m2 a(m2 m2Var, JSONObject jSONObject) throws i2 {
        JSONObject jSONObjectA;
        try {
            m2Var.a("Content-Type", "application/json; charset=UTF-8");
            if (jSONObject != null && (jSONObjectA = o2.a(jSONObject)) != null) {
                m2Var.a(jSONObjectA);
                m2Var.a("Content-Length", String.valueOf(jSONObjectA.toString().getBytes(StandardCharsets.UTF_8).length));
            }
            return m2Var;
        } catch (Exception e) {
            throw new i2("Request serialization failed", e);
        }
    }
}
