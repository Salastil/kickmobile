package com.useinsider.insider;

import android.util.Log;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class Debugger {
    static void a(DebuggingTag debuggingTag, int i) {
        try {
            a(debuggingTag, i, new JSONObject());
        } catch (Exception e) {
            a(e);
        }
    }

    static void b(DebuggingTag debuggingTag, int i, JSONObject jSONObject) {
        try {
            a(debuggingTag, i, jSONObject);
        } catch (Exception e) {
            a(e);
        }
    }

    public static void putLog(DebuggingTag debuggingTag, int i, String str) {
        try {
            if (debuggingTag == DebuggingTag.exception) {
                a(debuggingTag, str, i);
            } else {
                a(debuggingTag, i, new JSONObject().put("value", str));
            }
        } catch (Exception e) {
            a(e);
        }
    }

    static void a(DebuggingTag debuggingTag, int i, Map map) {
        try {
            a(debuggingTag, i, w4.g(map));
        } catch (Exception e) {
            a(e);
        }
    }

    static void a(DebuggingTag debuggingTag, int i, Boolean bool) {
        try {
            a(debuggingTag, i, new JSONObject().put("value", bool));
        } catch (Exception e) {
            a(e);
        }
    }

    private static void a(DebuggingTag debuggingTag, int i, JSONObject jSONObject) {
        y3 y3VarJ;
        try {
            a(debuggingTag, jSONObject.toString(), i);
            if (debuggingTag.c() != DebuggingTag.a.ENABLED || (y3VarJ = m0.f().j()) == null) {
                return;
            }
            y3VarJ.a(debuggingTag, jSONObject);
        } catch (Exception e) {
            a(e);
        }
    }

    static void a(Exception exc) {
        a(DebuggingTag.exception, exc.toString(), 6);
    }

    private static void a(DebuggingTag debuggingTag, String str, int i) {
        if (e.h) {
            if (str == null) {
                str = "";
            }
            try {
                String str2 = String.format(debuggingTag.b(), str);
                String str3 = "[INSIDER][" + debuggingTag.name() + "]";
                if (i == 4) {
                    Log.i(str3, str2);
                } else if (i == 5) {
                    Log.w(str3, str2);
                } else {
                    if (i != 6) {
                        return;
                    }
                    Log.e(str3, str2);
                }
            } catch (Exception unused) {
            }
        }
    }
}
