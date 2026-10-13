package com.useinsider.insider;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public final class InsiderAppCardAppSettingsAction extends InsiderAppCardAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f291a;
    private final String b;

    public InsiderAppCardAppSettingsAction(JSONObject jSONObject) {
        this.f291a = jSONObject;
        this.b = jSONObject.getString("type");
    }

    @Override // com.useinsider.insider.InsiderAppCardAction
    public String getType() {
        return this.b;
    }

    @Override // com.useinsider.insider.InsiderAppCardAction
    public void runAction() {
        v.a((InsiderAppCardAction) this);
    }

    public JSONObject toJSONObject() {
        return this.f291a;
    }
}
