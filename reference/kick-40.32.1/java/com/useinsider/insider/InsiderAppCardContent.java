package com.useinsider.insider;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public final class InsiderAppCardContent extends d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f294a;
    private final String b;
    private final String c;

    InsiderAppCardContent(JSONObject jSONObject) {
        this.f294a = jSONObject;
        this.b = jSONObject.getString("title");
        this.c = jSONObject.getString("description");
    }

    public String getDescription() {
        return this.c;
    }

    public String getTitle() {
        return this.b;
    }
}
