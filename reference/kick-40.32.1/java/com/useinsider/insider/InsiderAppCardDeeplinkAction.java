package com.useinsider.insider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public final class InsiderAppCardDeeplinkAction extends InsiderAppCardAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f295a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final HashMap f;
    private final List g;

    public InsiderAppCardDeeplinkAction(JSONObject jSONObject) throws JSONException {
        this.f295a = jSONObject;
        this.b = jSONObject.getString("type");
        this.c = jSONObject.optString("url_scheme");
        this.d = jSONObject.optString("internal_browser_url");
        this.e = jSONObject.optString("external_browser_url");
        if (!jSONObject.has("json") || jSONObject.isNull("json")) {
            this.f = null;
        } else {
            this.f = new HashMap();
            final JSONObject jSONObject2 = new JSONObject(jSONObject.getString("json"));
            jSONObject2.keys().forEachRemaining(new Consumer() { // from class: com.useinsider.insider.InsiderAppCardDeeplinkAction$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.a(jSONObject2, (String) obj);
                }
            });
        }
        if (!jSONObject.has("key_value") || jSONObject.isNull("key_value")) {
            this.g = null;
            return;
        }
        this.g = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("key_value");
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                if (jSONObject3.has("key") && jSONObject3.has("value")) {
                    String string = jSONObject3.getString("key");
                    String string2 = jSONObject3.getString("value");
                    HashMap map = new HashMap();
                    map.put(string, string2);
                    this.g.add(map);
                }
            } catch (JSONException e) {
                Insider.Instance.putException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(JSONObject jSONObject, String str) {
        try {
            this.f.put(str, jSONObject.get(str));
        } catch (JSONException e) {
            Insider.Instance.putException(e);
        }
    }

    public String getDeeplinkURLType() {
        String str = this.c;
        if (str != null && !str.isEmpty()) {
            return "url_scheme";
        }
        String str2 = this.d;
        if (str2 != null && !str2.isEmpty()) {
            return "internal";
        }
        String str3 = this.e;
        return (str3 == null || str3.isEmpty()) ? "unknown" : "external";
    }

    public HashMap<String, Object> getJson() {
        return this.f;
    }

    public List<HashMap<String, String>> getKeysAndValues() {
        return this.g;
    }

    @Override // com.useinsider.insider.InsiderAppCardAction
    public String getType() {
        return this.b;
    }

    public String getUrl() {
        String str = this.c;
        if (str != null && !str.isEmpty()) {
            return this.c;
        }
        String str2 = this.d;
        if (str2 != null && !str2.isEmpty()) {
            return this.d;
        }
        String str3 = this.e;
        if (str3 == null || str3.isEmpty()) {
            return null;
        }
        return this.e;
    }

    @Override // com.useinsider.insider.InsiderAppCardAction
    public void runAction() {
        v.a((InsiderAppCardAction) this);
    }

    public JSONObject toJSONObject() {
        return this.f295a;
    }
}
