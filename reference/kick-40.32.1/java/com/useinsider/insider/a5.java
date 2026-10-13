package com.useinsider.insider;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g3 f312a;
    private static InsiderUser b;
    private static InsiderProduct c;
    private static Context d;

    a5(g3 g3Var, InsiderUser insiderUser, Context context) {
        f312a = g3Var;
        b = insiderUser;
        d = context;
    }

    static Context a() {
        return d;
    }

    static JSONObject b() {
        InsiderUser insiderUser;
        try {
            g3 g3Var = f312a;
            if (g3Var != null && (insiderUser = b) != null) {
                return g3Var.a(insiderUser.getInsiderID());
            }
            return new JSONObject();
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return new JSONObject();
        }
    }

    static JSONObject c() {
        return w4.g(b.inflateDeviceAttributes());
    }

    static InsiderProduct d() {
        return c;
    }
}
