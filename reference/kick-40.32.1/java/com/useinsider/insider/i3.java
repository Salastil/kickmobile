package com.useinsider.insider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.URLUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class i3 {
    static Map a(Intent intent, i4 i4Var) {
        try {
            if (intent.hasExtra("camp_id") && intent.hasExtra("camp_type") && intent.hasExtra("variant_id")) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                int i = Integer.parseInt(intent.getStringExtra("camp_id"));
                int i2 = Integer.parseInt(intent.getStringExtra("camp_type"));
                int i3 = Integer.parseInt(intent.getStringExtra("variant_id"));
                int i4 = Integer.parseInt(intent.getStringExtra("received_at"));
                int i5 = Integer.parseInt(intent.getStringExtra("sent_at"));
                concurrentHashMap.put("camp_id", Integer.valueOf(i));
                concurrentHashMap.put("camp_type", Integer.valueOf(i2));
                concurrentHashMap.put("variant_id", Integer.valueOf(i3));
                if (i4Var == i4.EVENT && intent.hasExtra("buttonId")) {
                    concurrentHashMap.put("button_id", Integer.valueOf(intent.getIntExtra("buttonId", 0)));
                } else if (i4Var == i4.LOG) {
                    concurrentHashMap.put("received_at", Integer.valueOf(i4));
                    concurrentHashMap.put("sent_at", Integer.valueOf(i5));
                }
                if (intent.hasExtra("journey_id")) {
                    concurrentHashMap.put("journey_id", Integer.valueOf(Integer.parseInt(intent.getStringExtra("journey_id"))));
                }
                return concurrentHashMap;
            }
            return null;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    static void b(Intent intent, Activity activity) {
        try {
            if (intent == null) {
                f3.b("push", "Push Intent is null.", new JSONObject(), "InsiderActivity-setNotificationData");
                return;
            }
            Context applicationContext = activity != null ? activity.getApplicationContext() : null;
            a(intent);
            a(intent, applicationContext);
            c(intent, activity);
            f3.b("push", "Push Intent was handled, events were triggered and actions were run.", new JSONObject(), "InsiderActivity-setNotificationData");
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private static void c(Intent intent, Activity activity) {
        try {
            if (!intent.hasExtra(f.f329a) && !intent.hasExtra(f.b)) {
                if (!intent.hasExtra(f.m) && !intent.hasExtra(f.k)) {
                    if (intent.hasExtra(f.j) && Insider.Instance.shouldProceed()) {
                        w4.b(intent, (JSONObject) null);
                        d(intent, activity);
                        return;
                    } else if (intent.hasExtra(f.i)) {
                        w4.b(intent, (JSONObject) null);
                        e(intent, activity);
                        return;
                    } else if (!intent.hasExtra(f.l)) {
                        w4.b(intent, (JSONObject) null);
                        return;
                    } else {
                        w4.b(intent, (JSONObject) null);
                        f(intent, activity);
                        return;
                    }
                }
                a(intent, activity);
                return;
            }
            w4.b(intent, (JSONObject) null);
            intent.removeExtra(f.f329a);
            intent.removeExtra(f.b);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private static void d(Intent intent, Activity activity) {
        try {
            String stringExtra = intent.getStringExtra(f.j);
            if (stringExtra != null) {
                stringExtra = stringExtra.trim();
            }
            if (URLUtil.isValidUrl(stringExtra)) {
                intent.removeExtra(f.j);
                e.v = true;
                m0.f().n().a(activity, stringExtra);
                f3.b("push", "External browser activity is started.", new JSONObject(), "InsiderActivity-startExternalBrowser");
                return;
            }
            Insider.Instance.putException(new Exception("Invalid URL: " + stringExtra));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private static void e(Intent intent, Activity activity) {
        try {
            String stringExtra = intent.getStringExtra(f.i);
            if (stringExtra != null) {
                stringExtra = stringExtra.trim();
            }
            if (URLUtil.isValidUrl(stringExtra)) {
                e.u = new Intent().putExtras(intent);
                intent.removeExtra(f.i);
                m0.f().n().b(activity, stringExtra);
            } else {
                Insider.Instance.putException(new Exception("Invalid URL: " + stringExtra));
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private static void f(Intent intent, Activity activity) {
        try {
            String stringExtra = intent.getStringExtra(f.l);
            e.v = true;
            m0.f().n().a(activity, stringExtra);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private static void a(Intent intent) {
        try {
            if (intent.hasExtra("camp_id") && intent.hasExtra("camp_type") && intent.hasExtra("variant_id") && !intent.hasExtra("isSetPush")) {
                e.t = true;
                Map<String, Integer> mapA = a(intent, i4.LOG);
                Insider insider = Insider.Instance;
                insider.putPushLog(mapA);
                if (intent.hasExtra("carousel") || intent.hasExtra("slider") || intent.hasExtra("discovery")) {
                    insider.putInteractiveLog(intent, "camp_id", "camp_type", "variant_id");
                }
                intent.putExtra("isSetPush", true);
                f3.b("push", "Push clicked.", w4.g(mapA), "InsiderActivity-setNotificationData");
                return;
            }
            if (intent.hasExtra("thread-id") && intent.getStringExtra("thread-id").equals("insider-test-push")) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                concurrentHashMap.put("thread-id", String.valueOf(intent.getStringExtra("thread-id")));
                concurrentHashMap.put("title", String.valueOf(intent.getStringExtra("title")));
                concurrentHashMap.put("message", String.valueOf(intent.getStringExtra("message")));
                f3.b("push", "Push clicked.", w4.g(concurrentHashMap), "InsiderActivity-setNotificationData");
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private static void a(Intent intent, Context context) {
        try {
            boolean z = intent.hasExtra(f.f329a) || intent.hasExtra(f.b);
            f3.b("push", "setPushEvents method is triggered.", new JSONObject().put("isInternalBrowserOpen", e.r).put("isSessionStartFromPush", e.t).put("pushInapp", z), "InsiderActivity-setPushEvents");
            if (e.r || !e.t) {
                return;
            }
            if (context != null && w4.a(context, intent)) {
                f3.b("push", "push_session skipped due to permanent dedupe.", new JSONObject(), "InsiderActivity-setPushEvents");
                return;
            }
            if (z) {
                Insider.Instance.tagEvent(f.c).build();
            }
            Insider.Instance.tagEvent("push_session").addParameters(a(intent, i4.EVENT)).build();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private static void a(Intent intent, Activity activity) {
        JSONObject jSONObject;
        try {
            if (intent.hasExtra(f.m)) {
                jSONObject = new JSONObject(intent.getStringExtra(f.m));
            } else if (!intent.hasExtra(f.k)) {
                return;
            } else {
                jSONObject = new JSONObject(intent.getStringExtra(f.k));
            }
            if (jSONObject.has(f.j)) {
                String str = f.j;
                intent.putExtra(str, jSONObject.getString(str));
                w4.b(intent, jSONObject);
                intent.removeExtra(f.k);
                intent.removeExtra(f.m);
                d(intent, activity);
            } else if (jSONObject.has(f.i)) {
                String str2 = f.i;
                intent.putExtra(str2, jSONObject.getString(str2));
                w4.b(intent, jSONObject);
                intent.removeExtra(f.k);
                intent.removeExtra(f.m);
                e(intent, activity);
            } else if (jSONObject.has(f.l)) {
                String str3 = f.l;
                intent.putExtra(str3, jSONObject.getString(str3));
                w4.b(intent, jSONObject);
                intent.removeExtra(f.k);
                intent.removeExtra(f.m);
                f(intent, activity);
            } else {
                Iterator<String> itKeys = jSONObject.keys();
                intent.removeExtra(f.k);
                intent.removeExtra(f.m);
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    intent.putExtra(next, String.valueOf(jSONObject.get(next)));
                }
                w4.b(intent, jSONObject);
            }
            f3.a("push", "Interactive deep link has been handled.", jSONObject, "StaticUtils-getImageForPush");
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
