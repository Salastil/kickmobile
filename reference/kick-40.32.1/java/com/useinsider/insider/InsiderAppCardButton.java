package com.useinsider.insider;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public final class InsiderAppCardButton extends d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f292a;
    private String b;
    private final String c;
    private final String d;
    private final InsiderAppCardAction e;

    public InsiderAppCardButton(String str, JSONObject jSONObject) throws JSONException {
        this.f292a = jSONObject;
        this.b = str;
        this.c = jSONObject.getString("id");
        this.d = jSONObject.getString("text");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("action");
        if (jSONObjectOptJSONObject == null) {
            this.e = null;
        }
        String string = jSONObjectOptJSONObject.getString("type");
        string.getClass();
        string.hashCode();
        switch (string) {
            case "deep_link":
                this.e = new InsiderAppCardDeeplinkAction(jSONObjectOptJSONObject);
                break;
            case "open_settings":
                this.e = new InsiderAppCardAppSettingsAction(jSONObjectOptJSONObject);
                break;
            case "feedback":
                this.e = new InsiderAppCardAppReviewAction(jSONObjectOptJSONObject);
                break;
            default:
                this.e = null;
                break;
        }
    }

    String a() {
        return this.b;
    }

    public void click() {
        m0.f().a().clickButton(this);
    }

    public InsiderAppCardAction getAction() {
        return this.e;
    }

    public String getId() {
        return this.c;
    }

    public String getText() {
        return this.d;
    }

    public JSONObject toJSONObject() {
        return this.f292a;
    }
}
