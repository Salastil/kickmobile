package com.useinsider.insider;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public final class InsiderAppCardCampaignsResponse extends d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f293a;
    private final List b = new ArrayList();

    InsiderAppCardCampaignsResponse(JSONObject jSONObject) throws JSONException {
        this.f293a = jSONObject;
        if (!jSONObject.has("items") || jSONObject.isNull("items")) {
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("items");
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.b.add(new InsiderAppCard(jSONArray.getJSONObject(i)));
            } catch (JSONException unused) {
            }
        }
    }

    public List<InsiderAppCard> getAppCards() {
        return this.b;
    }

    public JSONObject toJSONObject() {
        return this.f293a;
    }
}
