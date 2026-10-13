package com.useinsider.insider;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class b3 extends d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f315a;
    private int b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private r2 i;
    private a3 j;
    private JSONObject k;

    b3() {
    }

    void a(String str) {
        this.d = str;
    }

    void b(String str) {
        this.c = str;
    }

    void c(int i) {
        this.f315a = i;
    }

    void d(int i) {
        this.e = i;
    }

    void e(int i) {
        this.b = i;
    }

    int f() {
        return this.f;
    }

    boolean g() {
        return this.h;
    }

    int h() {
        return this.f315a;
    }

    int i() {
        return this.e;
    }

    String j() {
        return this.d;
    }

    String k() {
        return this.c;
    }

    int l() {
        return this.b;
    }

    boolean m() {
        return e() != null;
    }

    boolean n() {
        return this.d.equals("session");
    }

    void a(int i) {
        this.g = i;
    }

    void b(int i) {
        this.f = i;
    }

    JSONObject c() {
        return this.k;
    }

    int d() {
        return this.g;
    }

    a3 e() {
        return this.j;
    }

    void a(boolean z) {
        this.h = z;
    }

    JSONObject b() {
        r2 r2VarA = a();
        if (r2VarA == null) {
            return null;
        }
        try {
            return r2VarA.toJSONObject();
        } catch (JSONException unused) {
            return null;
        }
    }

    r2 a() {
        return this.i;
    }

    void a(r2 r2Var) {
        this.i = r2Var;
    }

    void a(JSONObject jSONObject) {
        this.k = jSONObject;
    }

    void a(a3 a3Var) {
        this.j = a3Var;
    }
}
