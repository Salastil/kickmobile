package com.useinsider.insider;

import com.google.android.gms.common.internal.ImagesContract;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public final class InsiderAppCardImage extends d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f296a;
    private final String b;

    InsiderAppCardImage(JSONObject jSONObject) {
        this.f296a = jSONObject;
        this.b = jSONObject.getString(ImagesContract.URL);
    }

    public String getUrl() {
        return this.b;
    }

    public JSONObject toJSONObject() {
        return this.f296a;
    }
}
