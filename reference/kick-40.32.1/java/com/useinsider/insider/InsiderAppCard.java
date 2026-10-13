package com.useinsider.insider;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public final class InsiderAppCard extends d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f289a;
    private final String b;
    private final String c;
    private final boolean d;
    private final List e;
    private final InsiderAppCardContent f;
    private final InsiderAppCardDeeplinkAction g;
    private final List h;

    public InsiderAppCard(JSONObject jSONObject) throws JSONException {
        this.f289a = jSONObject;
        this.b = jSONObject.getString("id");
        this.c = jSONObject.getString("type");
        this.d = jSONObject.getBoolean("read");
        if (!jSONObject.has("images") || jSONObject.isNull("images")) {
            this.e = null;
        } else {
            this.e = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    this.e.add(new InsiderAppCardImage(jSONArray.getJSONObject(i)));
                } catch (JSONException e) {
                    Insider.Instance.putException(e);
                }
            }
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("content");
        this.f = jSONObjectOptJSONObject != null ? new InsiderAppCardContent(jSONObjectOptJSONObject) : null;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("action");
        this.g = jSONObjectOptJSONObject2 != null ? new InsiderAppCardDeeplinkAction(jSONObjectOptJSONObject2) : null;
        if (!jSONObject.has("buttons") || jSONObject.isNull("buttons")) {
            this.h = null;
            return;
        }
        this.h = new ArrayList();
        JSONArray jSONArray2 = jSONObject.getJSONArray("buttons");
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            try {
                this.h.add(new InsiderAppCardButton(this.b, jSONArray2.getJSONObject(i2)));
            } catch (JSONException e2) {
                Insider.Instance.putException(e2);
            }
        }
    }

    public void click() {
        m0.f().a().click(this);
    }

    public void delete(AppCardsDeleteCallback appCardsDeleteCallback) {
        m0.f().a().delete(new String[]{this.b}, appCardsDeleteCallback);
    }

    public InsiderAppCardDeeplinkAction getAction() {
        return this.g;
    }

    public List<InsiderAppCardButton> getButtons() {
        return this.h;
    }

    public InsiderAppCardContent getContent() {
        return this.f;
    }

    @Deprecated
    public JSONObject getCouponSettings() {
        return null;
    }

    public String getId() {
        return this.b;
    }

    public List<InsiderAppCardImage> getImages() {
        return this.e;
    }

    public String getType() {
        return this.c;
    }

    public boolean isRead() {
        return this.d;
    }

    public void markAsRead(AppCardsMarkAsReadCallback appCardsMarkAsReadCallback) {
        m0.f().a().markAsRead(new String[]{this.b}, appCardsMarkAsReadCallback);
    }

    public void markAsUnread(AppCardsMarkAsReadCallback appCardsMarkAsReadCallback) {
        m0.f().a().markAsUnread(new String[]{this.b}, appCardsMarkAsReadCallback);
    }

    public JSONObject toJSONObject() {
        return this.f289a;
    }

    public void view() {
        m0.f().a().view(this);
    }
}
