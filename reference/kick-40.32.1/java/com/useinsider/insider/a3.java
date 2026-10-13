package com.useinsider.insider;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class a3 extends r2 {
    private final int c;

    a3(q2 q2Var, List list, int i) {
        super(q2Var, list);
        this.c = i;
    }

    int c() {
        return this.c;
    }

    @Override // com.useinsider.insider.r2
    JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("in_second", c());
        return jSONObject;
    }
}
