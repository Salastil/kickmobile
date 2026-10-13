package com.useinsider.insider;

import android.app.Activity;
import android.content.SharedPreferences;
import com.android.billingclient.api.BillingClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f420a = "insider_inapp_frequency";
    private HashMap b = new HashMap();
    private HashMap c = new HashMap();
    private HashMap d = new HashMap();
    private ArrayList e = new ArrayList();
    private q3 f = new a();
    private m3 g = new m3() { // from class: com.useinsider.insider.s$$ExternalSyntheticLambda2
        @Override // com.useinsider.insider.m3
        public final void a(Map map) {
            this.f$0.a(map);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements q3 {
        a() {
        }

        @Override // com.useinsider.insider.q3
        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("enhanced_inapps");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            s.this.a(jSONArrayOptJSONArray);
        }

        @Override // com.useinsider.insider.q3
        public void b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("enhanced_inapps");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            s.this.a(jSONArrayOptJSONArray);
        }
    }

    s() {
    }

    private boolean e(String str) {
        HashMap map = this.d;
        return map != null && map.size() > 0 && this.d.containsKey(str) && this.d.get(str) != null;
    }

    boolean b(o oVar, SharedPreferences sharedPreferences) {
        if (oVar == null) {
            return false;
        }
        try {
            String strValueOf = String.valueOf(oVar.q());
            String string = sharedPreferences.getString("insider_inapp_frequency", "{}");
            if (!string.isEmpty() && !string.equals("{}")) {
                JSONObject jSONObject = new JSONObject(string);
                if (!jSONObject.has(strValueOf)) {
                    a(oVar, sharedPreferences);
                    return false;
                }
                if (!jSONObject.has(strValueOf)) {
                    return false;
                }
                if (jSONObject.getLong(strValueOf) == -1) {
                    return true;
                }
                boolean z = System.currentTimeMillis() >= jSONObject.getLong(strValueOf);
                if (z) {
                    a(oVar, sharedPreferences);
                }
                return !z;
            }
            a(oVar, sharedPreferences);
            return false;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return false;
        }
    }

    boolean c(String str) {
        HashMap map = this.c;
        return map != null && map.size() > 0 && this.c.containsKey(str) && this.c.get(str) != null;
    }

    boolean d(String str) {
        try {
            o oVar = (o) this.c.get(str);
            return oVar != null && oVar.x();
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray) {
        try {
            HashSet hashSet = new HashSet();
            for (int i = 0; i < this.e.size(); i++) {
                JSONObject jSONObject = (JSONObject) this.e.get(i);
                z4 z4Var = z4.INAPP_ID;
                if (jSONObject.has(z4Var.b())) {
                    hashSet.add(Integer.valueOf(jSONObject.getInt(z4Var.b())));
                }
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                z4 z4Var2 = z4.INAPP_ID;
                int i3 = jSONObject2.getInt(z4Var2.b());
                if (!hashSet.contains(Integer.valueOf(i3))) {
                    ArrayList arrayList = this.e;
                    JSONObject jSONObjectPut = new JSONObject().put(z4Var2.b(), i3);
                    z4 z4Var3 = z4.VARIANT_ID;
                    arrayList.add(jSONObjectPut.put(z4Var3.b(), jSONObject2.getInt(z4Var3.b())).put(z4.TIMESTAMP.b(), w4.b()));
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void c() {
        try {
            ArrayList arrayList = new ArrayList(m0.f().h().f());
            arrayList.addAll((Collection) this.b.values().stream().flatMap(new Function() { // from class: com.useinsider.insider.s$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((ArrayList) obj).stream();
                }
            }).collect(Collectors.toList()));
            arrayList.forEach(new Consumer() { // from class: com.useinsider.insider.s$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((o) obj).i();
                }
            });
            a();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private void a(o oVar, SharedPreferences sharedPreferences) {
        if (oVar == null) {
            return;
        }
        try {
            int iQ = oVar.q();
            boolean z = oVar.n() == -1;
            long jCurrentTimeMillis = System.currentTimeMillis() + ((long) (oVar.n() * 1000));
            if (z) {
                jCurrentTimeMillis = -1;
            }
            JSONObject jSONObject = new JSONObject();
            String string = sharedPreferences.getString("insider_inapp_frequency", "{}");
            if (string.length() > 0 && !string.equals("{}")) {
                jSONObject = new JSONObject(string);
            }
            jSONObject.put(String.valueOf(iQ), jCurrentTimeMillis);
            sharedPreferences.edit().putString("insider_inapp_frequency", String.valueOf(jSONObject)).apply();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void b(String str, q qVar) {
        o oVar;
        try {
            if (c(str)) {
                o oVar2 = (o) this.c.get(str);
                if (oVar2 != null) {
                    oVar2.l();
                    this.d.put(str, oVar2);
                    this.c.remove(str);
                }
            } else if (e(str) && (oVar = (o) this.d.get(str)) != null && oVar.v()) {
                oVar.l();
            }
            if (qVar != null) {
                qVar.a();
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(SharedPreferences sharedPreferences) {
        try {
            String string = sharedPreferences.getString("insider_inapp_frequency", "{}");
            JSONObject jSONObject = new JSONObject(string);
            JSONObject jSONObject2 = new JSONObject(string);
            if (jSONObject.length() != 0 && !string.equals("{}")) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (System.currentTimeMillis() >= jSONObject.getLong(next)) {
                        jSONObject2.remove(next);
                    }
                }
                sharedPreferences.edit().putString("insider_inapp_frequency", jSONObject2.toString()).apply();
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void b(String str) {
        try {
            if (c(str)) {
                ((o) this.c.get(str)).E();
                this.c.remove(str);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a() {
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
    }

    void a(String str) {
        o oVar;
        try {
            if (c(str)) {
                o oVar2 = (o) this.c.get(str);
                this.d.put(str, oVar2);
                oVar2.i();
                this.c.remove(str);
                return;
            }
            if (e(str) && (oVar = (o) this.d.get(str)) != null && oVar.v()) {
                oVar.a((q) null);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    boolean b(Activity activity) {
        int i;
        try {
            i = activity.getResources().getConfiguration().orientation;
            try {
                o oVar = (o) this.c.get(activity.getClass().getSimpleName());
                if (oVar != null) {
                    if (i == 1 && oVar.v()) {
                        Activity activityM = oVar.m();
                        if (activityM != null && !activity.equals(activityM)) {
                            oVar.h();
                        }
                        oVar.a(activity, false);
                        return false;
                    }
                    if (oVar.v()) {
                        return false;
                    }
                    this.c.remove(activity.getClass().getSimpleName());
                }
            } catch (Exception e) {
                e = e;
                Insider.Instance.putException(e);
            }
        } catch (Exception e2) {
            e = e2;
            i = 1;
        }
        return i != 2;
    }

    void a(String str, int i) {
        o oVar;
        try {
            if (c(str)) {
                o oVar2 = (o) this.c.get(str);
                if (oVar2 != null) {
                    if (e.z || !oVar2.o()) {
                        oVar2.a(i);
                        this.d.put(str, oVar2);
                        this.c.remove(str);
                        return;
                    }
                    return;
                }
                return;
            }
            if (e(str) && (oVar = (o) this.d.get(str)) != null && oVar.v()) {
                if (e.z || !oVar.o()) {
                    oVar.a(i);
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    ArrayList b() {
        return this.e;
    }

    void a(String str, q qVar) {
        o oVar;
        try {
            if (c(str)) {
                o oVar2 = (o) this.c.get(str);
                this.d.put(str, oVar2);
                oVar2.a(qVar);
                this.c.remove(str);
                return;
            }
            if (e(str) && (oVar = (o) this.d.get(str)) != null && oVar.v()) {
                oVar.a((q) null);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(o oVar, InsiderEvent insiderEvent, Activity activity) {
        try {
            if (!b(activity)) {
                f3.b(BillingClient.ProductType.INAPP, b.CURRENT_ACTIVITY_NOT_SUITABLE.b(), new JSONObject().put("event_name", insiderEvent.getName()).put("event_parameters", w4.g(insiderEvent.getParameters())).put("activity_name", activity.getClass().getSimpleName()), "InappFactory-startInapp");
                return;
            }
            if (oVar == null && this.b.isEmpty()) {
                f3.b(BillingClient.ProductType.INAPP, b.APP_TEMPLATE_LIST_IS_EMPTY.b(), new JSONObject().put("event_name", insiderEvent.getName()).put("event_parameters", w4.g(insiderEvent.getParameters())).put("activity_name", activity.getClass().getSimpleName()), "InappFactory-startInapp");
                return;
            }
            if (oVar == null && this.b.get(insiderEvent.getName()) == null) {
                f3.b(BillingClient.ProductType.INAPP, b.NO_APP_TEMPLATE_FOUND_MATCHING_EVENT.b(), new JSONObject().put("event_name", insiderEvent.getName()).put("event_parameters", w4.g(insiderEvent.getParameters())).put("activity_name", activity.getClass().getSimpleName()), "InappFactory-startInapp");
                return;
            }
            if (oVar != null) {
                Activity activityM = oVar.m();
                if (activityM != null) {
                    a(activityM.getClass().getSimpleName());
                }
                this.c.put(activity.getClass().getSimpleName(), oVar);
                if (!e.z && !oVar.o()) {
                    a(activity.getClass().getSimpleName(), 9);
                    return;
                }
                oVar.a(activity, true);
                return;
            }
            f3.b(BillingClient.ProductType.INAPP, b.NO_AVAILABLE_APP_TEMPLATE_FOUND.b(), new JSONObject().put("event_name", insiderEvent.getName()).put("event_parameters", w4.g(insiderEvent.getParameters())).put("activity_name", activity.getClass().getSimpleName()), "InappFactory-startInapp");
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(Activity activity) {
        b(activity);
    }

    public void a(o3 o3Var) {
        o3Var.a(this.f);
    }

    public void a(l3 l3Var) {
        l3Var.a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Map map) {
        JSONObject jSONObjectJ;
        String str = (String) map.get("enhanced_push_inapp");
        if (str == null || str.isEmpty() || (jSONObjectJ = w4.j(str)) == null) {
            return;
        }
        a(new JSONArray().put(jSONObjectJ));
    }
}
