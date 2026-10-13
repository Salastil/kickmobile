package com.useinsider.insider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.billingclient.api.BillingClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.notifications.service.NotificationsService;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class g3 {
    private final Context q;
    private InsiderUser r;
    private long s;
    private long t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f334a = new ArrayList();
    private final Map b = new ConcurrentHashMap();
    private final Map c = new ConcurrentHashMap();
    private final ArrayList d = new ArrayList();
    private final ArrayList e = new ArrayList();
    private final ArrayList f = new ArrayList();
    private final ArrayList g = new ArrayList();
    private final ArrayList h = new ArrayList();
    private final ArrayList i = new ArrayList();
    private final Map j = new ConcurrentHashMap();
    private final Map k = new ConcurrentHashMap();
    private Map l = new ConcurrentHashMap();
    private final ArrayList m = new ArrayList();
    private ArrayList n = new ArrayList();
    private ArrayList o = new ArrayList();
    private Map p = new ConcurrentHashMap();
    private int u = 0;
    private final ArrayList v = new ArrayList(Arrays.asList("user_attributes", "custom_attributes", "removed_attributes", "custom_events", "content_variables", "content_logs", "abandoned_items", "removed_items", "purchased_items", "push_logs", "inapp_logs", "interactive_logs", "survey_results", "recommendation_logs", "universal_link", "blocked_inapps", "psinoza_logs"));
    private final ArrayList w = new ArrayList();

    g3(Context context, InsiderUser insiderUser) {
        this.q = context;
        this.r = insiderUser;
    }

    private boolean b(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (!f.e.equals(jSONArray.getJSONObject(i).getString("event_name"))) {
                    return true;
                }
            } catch (Exception e) {
                a(e);
            }
        }
        return false;
    }

    private void n() {
        boolean zIsEmpty = this.r.getUserIdentifiersForStopPayload().isEmpty();
        Map map = this.k;
        if (zIsEmpty) {
            map.remove("user_identifiers");
        } else {
            map.put("user_identifiers", new ConcurrentHashMap(this.r.getUserIdentifiersForStopPayload()));
        }
    }

    boolean a(JSONObject jSONObject) {
        try {
            ArrayList arrayList = this.v;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                String str = (String) obj;
                if (jSONObject.has(str)) {
                    if (str.equals("custom_events")) {
                        if (b(jSONObject.getJSONArray(str))) {
                            return true;
                        }
                    } else if (!str.equals("user_attributes") || b(jSONObject.getJSONObject(str))) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            a(e);
        }
        return false;
    }

    void c() {
        try {
            this.l.clear();
        } catch (Exception e) {
            a(e);
        }
    }

    void d() {
        try {
            this.j.clear();
            g();
            f();
        } catch (Exception e) {
            a(e);
        }
    }

    void e() {
        try {
            g();
            f();
        } catch (Exception e) {
            a(e);
        }
    }

    void f() {
        try {
            for (String str : this.k.keySet()) {
                if (!str.equals("logout_identifiers")) {
                    Object obj = this.k.get(str);
                    String simpleName = obj.getClass().getSimpleName();
                    int iHashCode = simpleName.hashCode();
                    if (iHashCode != 578806391) {
                        if (iHashCode == 1372295063 && simpleName.equals("ConcurrentHashMap")) {
                            ((Map) obj).clear();
                        }
                    } else if (simpleName.equals("ArrayList")) {
                        ((ArrayList) obj).clear();
                    }
                }
            }
            this.k.remove("universal_link");
        } catch (Exception e) {
            a(e);
        }
    }

    void g() {
        try {
            this.u = 0;
        } catch (Exception e) {
            a(e);
        }
    }

    void h() {
        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry entry : this.k.entrySet()) {
                Object value = entry.getValue();
                if (this.v.contains(entry.getKey())) {
                    if (value instanceof ConcurrentHashMap) {
                        concurrentHashMap.put((String) entry.getKey(), new ConcurrentHashMap((ConcurrentHashMap) value));
                    } else if (value instanceof ArrayList) {
                        concurrentHashMap.put((String) entry.getKey(), new ArrayList((ArrayList) value));
                    } else {
                        concurrentHashMap.put((String) entry.getKey(), value);
                    }
                }
            }
            this.l = concurrentHashMap;
        } catch (Exception e) {
            a(e);
        }
    }

    SharedPreferences i() {
        return h4.a().e(this.q, "InsiderCache");
    }

    int j() {
        try {
            return this.u;
        } catch (Exception e) {
            a(e);
            return 0;
        }
    }

    void k() {
        try {
            this.u++;
        } catch (Exception e) {
            a(e);
        }
    }

    void l() {
        try {
            for (Map.Entry entry : this.l.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                boolean zContainsKey = this.k.containsKey(str);
                Map map = this.k;
                if (zContainsKey) {
                    Object obj = map.get(str);
                    if ((obj instanceof ConcurrentHashMap) && (value instanceof ConcurrentHashMap)) {
                        ((ConcurrentHashMap) obj).putAll((ConcurrentHashMap) value);
                    } else if ((obj instanceof ArrayList) && (value instanceof ArrayList)) {
                        ((ArrayList) obj).addAll((ArrayList) value);
                    } else {
                        this.k.put(str, value);
                    }
                } else {
                    map.put(str, value);
                }
            }
            c();
        } catch (Exception e) {
            a(e);
        }
    }

    void m() {
        try {
            this.k.put("partner_name", e.b);
            this.k.put("udid", this.r.getUDID());
            this.k.put("user_attributes", this.r.getUserAttributes());
            this.k.put("custom_attributes", this.r.getCustomAttributes());
            this.k.put("device_attributes", this.r.getDeviceAttributes());
            this.k.put("removed_attributes", this.r.getUnsetCustomAttributes());
            this.k.put("custom_events", this.f334a);
            this.k.put("content_logs", this.c);
            this.k.put("content_variables", this.b);
            this.k.put("abandoned_items", this.d);
            this.k.put("removed_items", this.e);
            this.k.put("purchased_items", this.f);
            this.k.put("push_logs", this.g);
            this.k.put("interactive_logs", this.h);
            this.k.put("recommendation_logs", this.i);
            this.k.put("inapp_logs", this.n);
            this.k.put("survey_results", this.o);
            this.k.put("logout_identifiers", this.w);
            this.k.put("psinoza_logs", this.p);
        } catch (Exception e) {
            a(e);
        }
    }

    void o() {
        f();
        this.k.clear();
        m();
    }

    private boolean c(String str) {
        try {
            ArrayList arrayList = this.d;
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList arrayList2 = this.d;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) obj;
                    if (concurrentHashMap.containsKey(FirebaseAnalytics.Param.PRODUCT_ID) && concurrentHashMap.get(FirebaseAnalytics.Param.PRODUCT_ID).equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            a(e);
            return false;
        }
    }

    void e(String str) {
        try {
            if (!c(str)) {
                this.e.add(str);
                return;
            }
            ArrayList arrayList = this.d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) obj;
                if (concurrentHashMap.containsKey(FirebaseAnalytics.Param.PRODUCT_ID) && concurrentHashMap.get(FirebaseAnalytics.Param.PRODUCT_ID).equals(str)) {
                    this.d.remove(concurrentHashMap);
                    return;
                }
            }
        } catch (Exception e) {
            a(e);
        }
    }

    void d(String str) {
        try {
            this.k.put("universal_link", str);
        } catch (Exception e) {
            a(e);
        }
    }

    private boolean b(JSONObject jSONObject) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                if (!"mid".equals(itKeys.next())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            a(e);
            return false;
        }
    }

    void a(String str, Object obj, n0 n0Var, ContentOptimizerDataType contentOptimizerDataType) {
        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("variable_name", str);
            concurrentHashMap.put("default_value", String.valueOf(obj));
            concurrentHashMap.put("data_type", Integer.valueOf(contentOptimizerDataType.ordinal()));
            concurrentHashMap.put("data_class", Integer.valueOf(n0Var.ordinal()));
            this.b.put(str, w4.g(concurrentHashMap));
        } catch (Exception e) {
            a(e);
        }
    }

    void b(ArrayList arrayList) {
        try {
            this.w.clear();
            if (arrayList != null) {
                this.w.addAll(arrayList);
            }
        } catch (Exception e) {
            a(e);
        }
    }

    void a(String str, int i, int i2) {
        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("content_id", Integer.valueOf(i));
            concurrentHashMap.put("variant_id", Integer.valueOf(i2));
            this.c.put(str, w4.g(concurrentHashMap));
        } catch (Exception e) {
            a(e);
        }
    }

    void b(InsiderProduct insiderProduct) {
        try {
            if (c(insiderProduct.getProductID())) {
                return;
            }
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put(FirebaseAnalytics.Param.PRODUCT_ID, insiderProduct.getProductID());
            concurrentHashMap.put("title", insiderProduct.getName());
            concurrentHashMap.put(FirebaseAnalytics.Param.PRICE, Double.valueOf(insiderProduct.getUnitPrice()));
            concurrentHashMap.put(FirebaseAnalytics.Param.CURRENCY, insiderProduct.getCurrency());
            concurrentHashMap.put("image_url", insiderProduct.getImageURL());
            this.d.add(concurrentHashMap);
            this.e.remove(insiderProduct.getProductID());
        } catch (Exception e) {
            a(e);
        }
    }

    JSONObject a(String str, boolean z, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        try {
            concurrentHashMap.put(f.n, e.b);
            concurrentHashMap2.put("udid", str2);
            concurrentHashMap.put("insider_id", str3);
            concurrentHashMap.put(TypedValues.Attributes.S_TARGET, w4.g(concurrentHashMap2));
            concurrentHashMap.put(str, Boolean.valueOf(z));
            return w4.g(concurrentHashMap);
        } catch (Exception e) {
            a(e);
            return jSONObject;
        }
    }

    void b() {
        try {
            this.d.clear();
            this.e.clear();
        } catch (Exception e) {
            a(e);
        }
    }

    boolean b(String str) {
        try {
            if (s0.f422a.contains(str)) {
                return false;
            }
            k();
            return 100 < j();
        } catch (Exception e) {
            a(e);
            return true;
        }
    }

    JSONObject a(long j, long j2, int i, String str, String str2, InsiderIdentifiers insiderIdentifiers) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put(f.n, e.b).put(FirebaseAnalytics.Param.START_DATE, j).put(FirebaseAnalytics.Param.END_DATE, j2).put("limit", i);
            if (insiderIdentifiers != null && !insiderIdentifiers.getIdentifiers().isEmpty()) {
                jSONObjectPut.put(NotificationsService.IDENTIFIERS_KEY, w4.g(insiderIdentifiers.getIdentifiers()));
                return jSONObjectPut;
            }
            jSONObjectPut.put("insider_id", str2).put("udid", str);
            return jSONObjectPut;
        } catch (Exception e) {
            a(e);
            return new JSONObject();
        }
    }

    void b(Map map) {
        this.g.add(map);
    }

    void a(ConcurrentHashMap concurrentHashMap) {
        try {
            this.i.add(concurrentHashMap);
        } catch (Exception e) {
            a(e);
        }
    }

    public void a(int i, int i2) {
        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("timestamp", Long.valueOf(w4.b()));
            concurrentHashMap.put("inapp_id", Integer.valueOf(i));
            concurrentHashMap.put("variant_id", Integer.valueOf(i2));
            this.m.add(concurrentHashMap);
            this.k.put("blocked_inapps", this.m);
            Debugger.a(DebuggingTag.removeBlockedInapp, 4, concurrentHashMap);
            f3.b(BillingClient.ProductType.INAPP, "Blocked In-app log added.", "{ 'inappId': " + i + ", 'variantId': " + i2 + " }", "InsiderModel-addBlockedInappLog");
        } catch (Exception e) {
            a(e);
        }
    }

    void a(long j) {
        this.s = j;
        this.t = w4.b();
    }

    void a(InsiderEvent insiderEvent) {
        try {
            if (b(insiderEvent.getName())) {
                return;
            }
            this.f334a.add(insiderEvent.getEventPayload());
            InsiderEvent insiderEventCloneEvent = insiderEvent.cloneEvent();
            if (insiderEventCloneEvent != null) {
                Integer num = (Integer) this.j.get(insiderEventCloneEvent);
                Map map = this.j;
                if (num == null) {
                    map.put(insiderEventCloneEvent, 1);
                } else {
                    map.put(insiderEventCloneEvent, Integer.valueOf(num.intValue() + 1));
                }
            }
        } catch (Exception e) {
            a(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0028 A[Catch: Exception -> 0x0053, LOOP:0: B:13:0x0026->B:14:0x0028, LOOP_END, TryCatch #0 {Exception -> 0x0053, blocks: (B:3:0x0006, B:12:0x001f, B:14:0x0028, B:15:0x003c, B:6:0x0010, B:9:0x0018), top: B:20:0x0006 }] */
    void a(Intent intent, String... strArr) {
        ConcurrentHashMap concurrentHashMap;
        int i;
        String str = "discovery";
        try {
            String str2 = "";
            if (intent.hasExtra("carousel")) {
                str = "carousel";
            } else {
                if (!intent.hasExtra("slider")) {
                    if (intent.hasExtra("discovery")) {
                    }
                    concurrentHashMap = new ConcurrentHashMap();
                    for (String str3 : strArr) {
                        concurrentHashMap.put(str3, Integer.valueOf(Integer.parseInt(intent.getStringExtra(str3))));
                    }
                    concurrentHashMap.put("interactive_id", Integer.valueOf(Integer.parseInt(intent.getStringExtra(str2))));
                    this.h.add(concurrentHashMap);
                }
                str = "slider";
            }
            str2 = str;
            concurrentHashMap = new ConcurrentHashMap();
            while (i < r1) {
                concurrentHashMap.put(str3, Integer.valueOf(Integer.parseInt(intent.getStringExtra(str3))));
            }
            concurrentHashMap.put("interactive_id", Integer.valueOf(Integer.parseInt(intent.getStringExtra(str2))));
            this.h.add(concurrentHashMap);
        } catch (Exception e) {
            a(e);
        }
    }

    JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            m();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(this.k);
            a(str, concurrentHashMap);
            n();
            a((Map) concurrentHashMap);
            return w4.g(concurrentHashMap);
        } catch (Exception e) {
            a(e);
            return jSONObject;
        }
    }

    void a(String str, w wVar) {
        try {
            w wVar2 = (w) this.p.get(str);
            if (wVar2 != null) {
                wVar2.a(wVar);
            } else {
                this.p.put(str, wVar);
            }
            Debugger.putLog(DebuggingTag.appCardsLog, 4, w4.g(wVar.a()).toString());
        } catch (Exception e) {
            a(e);
        }
    }

    private Map a(String str, Map map) {
        boolean z;
        try {
            map.put("insider_id", str);
            if (a()) {
                z = false;
            } else {
                i().edit().putString("insider_attributes", this.r.getDeviceAttributes().toString()).apply();
                z = true;
            }
            map.put("did_attributes_change", Boolean.valueOf(z));
            map.put("timestamp", Long.valueOf(w4.b()));
            map.put("session_duration", Integer.valueOf(w4.a(this.s, SystemClock.elapsedRealtime())));
            map.put("session_id", f3.c);
            long j = this.t;
            if (j > 0) {
                map.put("session_start_timestamp", Long.valueOf(j));
            }
            return map;
        } catch (Exception e) {
            a(e);
            return map;
        }
    }

    private Map a(Map map) {
        try {
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                String simpleName = obj.getClass().getSimpleName();
                int iHashCode = simpleName.hashCode();
                if (iHashCode != 578806391) {
                    if (iHashCode == 1372295063 && simpleName.equals("ConcurrentHashMap") && ((ConcurrentHashMap) obj).size() == 0) {
                        map.remove(str);
                    }
                } else if (simpleName.equals("ArrayList") && ((ArrayList) obj).size() == 0) {
                    map.remove(str);
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }

    synchronized JSONObject a(String str, p4 p4Var) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            m();
            a(str, this.k);
            n();
            a(this.k);
            jSONObject = w4.g(this.k);
            if (jSONObject.has("custom_events")) {
                jSONObject.put("custom_events", a(jSONObject.getJSONArray("custom_events")));
            }
            jSONObject.put("reason", p4Var.b());
        } catch (Exception e) {
            a(e);
            return jSONObject;
        }
        return jSONObject;
    }

    private JSONArray a(JSONArray jSONArray) {
        boolean z;
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String strOptString = jSONObject.optString("event_name");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event_params");
                if (w4.e(strOptString)) {
                    f3.a("error", "Event name is empty.", jSONObject, "InsiderCore-filterInvalidEventParams");
                    z = false;
                } else {
                    z = true;
                }
                if (!(jSONObjectOptJSONObject instanceof JSONObject)) {
                    f3.a("error", "Invalid parameters structure.", jSONObject, "InsiderCore-filterInvalidEventParams");
                    z = false;
                }
                if (z) {
                    jSONArray2.put(jSONObject);
                }
            }
            return jSONArray2;
        } catch (Exception e) {
            a(e);
            return jSONArray;
        }
    }

    void a(o oVar) {
        try {
            this.n.addAll(oVar.r());
            this.o.addAll(oVar.t());
            oVar.e();
        } catch (Exception e) {
            a(e);
        }
    }

    synchronized void a(Exception exc) {
        try {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            Debugger.putLog(DebuggingTag.exception, 6, stringWriter.toString());
            f3.a("common", "An exception occurred.", new JSONObject().put("error", stringWriter.toString()), "InsiderModel-putException");
        } catch (Exception e) {
            a(e);
        }
    }

    void a(InsiderProduct insiderProduct) {
        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("sale_id", insiderProduct.getSaleID());
            concurrentHashMap.put(FirebaseAnalytics.Param.PRODUCT_ID, insiderProduct.getProductID());
            concurrentHashMap.put("name", insiderProduct.getName());
            concurrentHashMap.put("category", insiderProduct.getTaxonomyString());
            concurrentHashMap.put(FirebaseAnalytics.Param.PRICE, Double.valueOf(insiderProduct.getUnitPrice()));
            concurrentHashMap.put(FirebaseAnalytics.Param.CURRENCY, insiderProduct.getCurrency());
            concurrentHashMap.put(FirebaseAnalytics.Param.QUANTITY, Integer.valueOf(insiderProduct.getQuantity()));
            concurrentHashMap.put("img", insiderProduct.getImageURL());
            this.f.add(concurrentHashMap);
        } catch (Exception e) {
            a(e);
        }
    }

    void a(ArrayList arrayList) {
        try {
            this.k.put("received_inapps", new ArrayList(arrayList));
        } catch (Exception e) {
            a(e);
        }
    }

    private boolean a() {
        SharedPreferences sharedPreferencesI = i();
        return sharedPreferencesI.contains("insider_attributes") && sharedPreferencesI.getString("insider_attributes", "").equals(this.r.getDeviceAttributes().toString());
    }
}
