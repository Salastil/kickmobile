package com.useinsider.insider;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class f3 {
    static Context e;
    static int g;
    static Handler h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONArray f331a = new JSONArray();
    static String b = "{}";
    static String c = "";
    static String d = "";
    static Boolean f = Boolean.FALSE;
    private static m4 i = null;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f332a;

        a(Context context) {
            this.f332a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            f3.a(this.f332a);
            f3.h.postDelayed(this, ((long) f3.g) * 1000);
        }
    }

    f3(Context context) {
        try {
            if (g > 0 && f.booleanValue()) {
                i = new m4(context);
                b(context);
                a(c);
                if (h != null) {
                    return;
                }
                h = new Handler();
                new Handler().postDelayed(new a(context), ((long) g) * 1000);
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    public static void a(String str) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            if (str == null || str.isEmpty()) {
                str = w4.a();
            }
            d = str + "-" + jCurrentTimeMillis;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    public static String b() {
        return d;
    }

    static void c() {
        c = "";
        d = "";
    }

    public static void d() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            if (d.isEmpty()) {
                a(c);
                return;
            }
            d = d.split("-")[0] + "-" + jCurrentTimeMillis;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static void b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String strI = TextUtils.isEmpty(e.e) ? w4.i() : e.e;
            jSONObject.put("session_id", c);
            jSONObject.put("flush_id", d);
            jSONObject.put("udid", w4.k(context));
            jSONObject.put("insider_id", Insider.Instance.getCurrentUser().getInsiderID());
            jSONObject.put("sdk_version", strI);
            jSONObject.put("platform", GetDeviceInfoUseCaseKt.PLATFORM);
            jSONObject.put("os_version", w4.g());
            jSONObject.put("app_version", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
            b = jSONObject.toString();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    public static void c(String str, String str2, JSONObject jSONObject, String str3) {
        try {
            a(str, str2, jSONObject, "warn", str3);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    public static void c(String str, String str2, String str3, String str4) {
        try {
            a(str, str2, b(str3), "warn", str4);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static void a() {
        try {
            String str = c;
            if (str != null && !str.isEmpty()) {
                return;
            }
            String strA = w4.a();
            c = strA;
            a(strA);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private static void a(String str, String str2, JSONObject jSONObject, String str3, String str4) {
        try {
            if (!e.h && !f.booleanValue()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String[] strArrSplit = str4.split("-");
            Context context = e;
            if (context != null) {
                b(context);
            }
            JSONObject jSONObjectPut = new JSONObject(b).put("log_type", str).put("message", str2).put("custom_attributes", jSONObject).put("timestamp", jCurrentTimeMillis).put("debug_info", new JSONObject().put("class_name", strArrSplit[0]).put("function_name", strArrSplit[1])).put("log_level", str3);
            if (f.booleanValue()) {
                f331a.put(jSONObjectPut);
            }
            Debugger.b(DebuggingTag.insiderLogServicePutLog, 4, jSONObjectPut);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private static JSONObject b(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2, JSONObject jSONObject, String str3) {
        try {
            a(str, str2, jSONObject, "info", str3);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static void b(String str, String str2, String str3, String str4) {
        try {
            a(str, str2, b(str3), "info", str4);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static void a(Context context) {
        try {
            if (f331a.length() <= 0 || !f.booleanValue()) {
                return;
            }
            JSONArray jSONArray = f331a;
            f331a = new JSONArray();
            d();
            if (i == null) {
                i = new m4(context);
            }
            i.a(c, jSONArray);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static void a(String str, String str2, JSONObject jSONObject, String str3) {
        try {
            a(str, str2, jSONObject, "error", str3);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static void a(String str, String str2, String str3, String str4) {
        try {
            a(str, str2, b(str3), "error", str4);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }
}
