package com.useinsider.insider;

import com.facebook.react.uimanager.ViewProps;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f427a;
    private a b;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f428a;
        private float b;
        private float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private int i;
        private float j = 100.0f;

        a(JSONObject jSONObject) {
            this.f428a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 0.0f;
            try {
                if (jSONObject.has(ViewProps.WIDTH)) {
                    this.f428a = ((float) jSONObject.getDouble(ViewProps.WIDTH)) * this.j;
                }
                if (jSONObject.has(ViewProps.HEIGHT)) {
                    this.c = ((float) jSONObject.getDouble(ViewProps.HEIGHT)) * this.j;
                }
                if (jSONObject.has(ViewProps.POSITION)) {
                    this.i = jSONObject.getInt(ViewProps.POSITION);
                }
                if (jSONObject.has("verticalMargin")) {
                    this.e = (float) jSONObject.getDouble("verticalMargin");
                }
                if (jSONObject.has("horizontalMargin")) {
                    this.g = (float) jSONObject.getDouble("horizontalMargin");
                }
                if (jSONObject.has("width_in_px")) {
                    this.b = (float) jSONObject.getDouble("width_in_px");
                }
                if (jSONObject.has("height_in_px")) {
                    this.d = (float) jSONObject.getDouble("height_in_px");
                }
                if (jSONObject.has("vertical_margin_in_px")) {
                    this.f = (float) jSONObject.getDouble("vertical_margin_in_px");
                }
                if (jSONObject.has("horizontal_margin_in_px")) {
                    this.h = (float) jSONObject.getDouble("horizontal_margin_in_px");
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }

        public float a() {
            return this.c;
        }

        float b() {
            return this.d;
        }

        public float c() {
            return this.g;
        }

        float d() {
            return this.h;
        }

        public int e() {
            return this.i;
        }

        public float f() {
            return this.e;
        }

        float g() {
            return this.f;
        }

        public float h() {
            return this.f428a;
        }

        float i() {
            return this.b;
        }
    }

    t(JSONObject jSONObject) {
        this.b = null;
        try {
            this.f427a = jSONObject;
            if (jSONObject.has("template_layout")) {
                this.b = new a(this.f427a.getJSONObject("template_layout"));
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(JSONObject jSONObject) {
        try {
            this.b = new a(jSONObject);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    boolean b(String str) {
        try {
            if (this.f427a.has(str)) {
                return this.f427a.getBoolean(str);
            }
            return false;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return false;
        }
    }

    float c(String str) {
        try {
            return (float) this.f427a.getDouble(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return -1.0f;
        }
    }

    int d(String str) {
        try {
            return this.f427a.getInt(str);
        } catch (Exception unused) {
            return -1;
        }
    }

    String e(String str) {
        try {
            return this.f427a.getString(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return "";
        }
    }

    public a a() {
        return this.b;
    }

    boolean a(String str) {
        JSONObject jSONObject = this.f427a;
        return jSONObject != null && jSONObject.has(str);
    }
}
