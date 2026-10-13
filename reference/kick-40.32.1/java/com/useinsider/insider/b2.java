package com.useinsider.insider;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class b2 extends g2 {

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    public interface a {
        d4 a(JSONObject jSONObject);
    }

    b2(final a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Model factory must not be null");
        }
        a(new g2.a() { // from class: com.useinsider.insider.b2$$ExternalSyntheticLambda0
            @Override // com.useinsider.insider.g2.a
            public final Object a(n2 n2Var, String str) {
                return b2.a(aVar, n2Var, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object a(a aVar, n2 n2Var, String str) throws i2 {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        try {
            return aVar.a(new JSONObject(str));
        } catch (Exception e) {
            throw new i2("Failed to create model instance from JSONObject", n2Var, str, e);
        }
    }
}
