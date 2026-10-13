package com.useinsider.insider;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class h implements q3, m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f335a = new ConcurrentHashMap();
    private final g3 b;
    private final Context c;

    h(g3 g3Var, Context context, o3 o3Var, l3 l3Var) {
        this.b = g3Var;
        this.c = context;
        o3Var.a(this);
        l3Var.a(this);
    }

    SharedPreferences a() {
        return h4.a().e(this.c, "Insider");
    }

    String b(String str, String str2, ContentOptimizerDataType contentOptimizerDataType) {
        try {
            HashMap map = new HashMap();
            map.put("variable_name", str);
            map.put("default_value", str2);
            map.put("data_type", contentOptimizerDataType != null ? contentOptimizerDataType.name() : null);
            Debugger.a(DebuggingTag.getStringWithNameWithoutCache, 4, map);
            a(str, str2, n0.String, contentOptimizerDataType);
            SharedPreferences sharedPreferencesA = a();
            if (sharedPreferencesA.contains("test_contents") && sharedPreferencesA.getString("test_contents", "").equals(str)) {
                a(str);
                JSONObject jSONObject = new JSONObject(sharedPreferencesA.getString(str, ""));
                f3.b("content_optimizer", "New string value received.", jSONObject, "ContentOptimizer-getStringWithNameWithoutCache");
                return jSONObject.getString("new_value");
            }
            if (this.f335a.containsKey(str)) {
                a(str);
                JSONObject jSONObject2 = new JSONObject((String) this.f335a.get(str));
                f3.b("content_optimizer", "New string value received.", jSONObject2, "ContentOptimizer-getStringWithNameWithoutCache");
                return jSONObject2.getString("new_value");
            }
            f3.b("content_optimizer", "There is no associated data.", "{ 'variable_name': '" + str + "' }", "ContentOptimizer-getStringWithNameWithoutCache");
            return str2;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return str2;
        }
    }

    void c(JSONArray jSONArray) {
        String str;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int i2 = jSONObject.getInt("content_id");
                int i3 = jSONObject.getInt("variant_id");
                JSONArray jSONArray2 = jSONObject.getJSONArray("variables");
                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                    HashMap map = new HashMap();
                    map.put("content_id", Integer.valueOf(i2));
                    map.put("variant_id", Integer.valueOf(i3));
                    map.put("variable_name", jSONObject2.getString("variable_name"));
                    map.put("new_value", jSONObject2.get("new_value"));
                    String string = w4.g(map).toString();
                    String string2 = jSONObject2.getString("variable_name");
                    if (!this.f335a.containsKey(string2) || (str = (String) this.f335a.get(string2)) == null || !str.equals(string)) {
                        this.f335a.put(string2, string);
                    }
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
                return;
            }
        }
    }

    @Override // com.useinsider.insider.q3
    public void e() {
        try {
            this.f335a.clear();
            SharedPreferences sharedPreferencesA = a();
            if (sharedPreferencesA.contains("test_contents")) {
                sharedPreferencesA.edit().remove(sharedPreferencesA.getString("test_contents", "")).remove("test_contents").apply();
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    String a(String str, String str2, ContentOptimizerDataType contentOptimizerDataType) {
        try {
            HashMap map = new HashMap();
            map.put("variable_name", str);
            map.put("default_value", str2);
            map.put("data_type", contentOptimizerDataType != null ? contentOptimizerDataType.name() : null);
            Debugger.a(DebuggingTag.getStringWithName, 4, map);
            a(str, str2, n0.String, contentOptimizerDataType);
            SharedPreferences sharedPreferencesA = a();
            if (sharedPreferencesA.contains(str)) {
                a(str);
                JSONObject jSONObject = new JSONObject(sharedPreferencesA.getString(str, ""));
                f3.b("content_optimizer", "New string value received.", jSONObject, "ContentOptimizer-getStringWithName");
                return jSONObject.getString("new_value");
            }
            f3.b("content_optimizer", "There is no associated data.", "{ 'variable_name': '" + str + "' }", "ContentOptimizer-getStringWithName");
            return str2;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return str2;
        }
    }

    int a(String str, int i, ContentOptimizerDataType contentOptimizerDataType) {
        try {
            HashMap map = new HashMap();
            map.put("variable_name", str);
            map.put("default_value", Integer.valueOf(i));
            map.put("data_type", contentOptimizerDataType != null ? contentOptimizerDataType.name() : null);
            Debugger.a(DebuggingTag.getIntWithName, 4, map);
            a(str, Integer.valueOf(i), n0.Integer, contentOptimizerDataType);
            SharedPreferences sharedPreferencesA = a();
            if (sharedPreferencesA.contains(str)) {
                a(str);
                JSONObject jSONObject = new JSONObject(sharedPreferencesA.getString(str, ""));
                f3.b("content_optimizer", "New int value received.", jSONObject, "ContentOptimizer-getIntWithName");
                return jSONObject.getInt("new_value");
            }
            f3.b("content_optimizer", "There is no associated data.", "{ 'variable_name': '" + str + "' }", "ContentOptimizer-getIntWithName");
            return i;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return i;
        }
    }

    int b(String str, int i, ContentOptimizerDataType contentOptimizerDataType) {
        try {
            HashMap map = new HashMap();
            map.put("variable_name", str);
            map.put("default_value", Integer.valueOf(i));
            map.put("data_type", contentOptimizerDataType != null ? contentOptimizerDataType.name() : null);
            Debugger.a(DebuggingTag.getIntWithNameWithoutCache, 4, map);
            a(str, Integer.valueOf(i), n0.Integer, contentOptimizerDataType);
            SharedPreferences sharedPreferencesA = a();
            if (sharedPreferencesA.contains("test_contents") && sharedPreferencesA.getString("test_contents", "").equals(str)) {
                a(str);
                JSONObject jSONObject = new JSONObject(sharedPreferencesA.getString(str, ""));
                f3.b("content_optimizer", "New int value received.", jSONObject, "ContentOptimizer-getIntWithNameWithoutCache");
                return jSONObject.getInt("new_value");
            }
            if (this.f335a.containsKey(str)) {
                a(str);
                JSONObject jSONObject2 = new JSONObject((String) this.f335a.get(str));
                f3.b("content_optimizer", "New int value received.", jSONObject2, "ContentOptimizer-getIntWithNameWithoutCache");
                return jSONObject2.getInt("new_value");
            }
            f3.b("content_optimizer", "There is no associated data.", "{ 'variable_name': '" + str + "' }", "ContentOptimizer-getIntWithNameWithoutCache");
            return i;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return i;
        }
    }

    boolean a(String str, boolean z, ContentOptimizerDataType contentOptimizerDataType) {
        try {
            HashMap map = new HashMap();
            map.put("variable_name", str);
            map.put("default_value", Boolean.valueOf(z));
            map.put("data_type", contentOptimizerDataType != null ? contentOptimizerDataType.name() : null);
            Debugger.a(DebuggingTag.getBoolWithName, 4, map);
            a(str, Boolean.valueOf(z), n0.Boolean, contentOptimizerDataType);
            SharedPreferences sharedPreferencesA = a();
            if (sharedPreferencesA.contains(str)) {
                a(str);
                JSONObject jSONObject = new JSONObject(sharedPreferencesA.getString(str, ""));
                f3.b("content_optimizer", "New boolean value received.", jSONObject, "ContentOptimizer-getBoolWithName");
                return jSONObject.getBoolean("new_value");
            }
            f3.b("content_optimizer", "There is no associated data.", "{ 'variable_name': '" + str + "' }", "ContentOptimizer-getBoolWithName");
            return z;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return z;
        }
    }

    boolean b(String str, boolean z, ContentOptimizerDataType contentOptimizerDataType) {
        try {
            HashMap map = new HashMap();
            map.put("variable_name", str);
            map.put("default_value", Boolean.valueOf(z));
            map.put("data_type", contentOptimizerDataType != null ? contentOptimizerDataType.name() : null);
            Debugger.a(DebuggingTag.getBoolWithNameWithoutCache, 4, map);
            a(str, Boolean.valueOf(z), n0.Boolean, contentOptimizerDataType);
            SharedPreferences sharedPreferencesA = a();
            if (sharedPreferencesA.contains("test_contents") && sharedPreferencesA.getString("test_contents", "").equals(str)) {
                a(str);
                JSONObject jSONObject = new JSONObject(sharedPreferencesA.getString(str, ""));
                f3.b("content_optimizer", "New boolean value received.", jSONObject, "ContentOptimizer-getBoolWithNameWithoutCache");
                return jSONObject.getBoolean("new_value");
            }
            if (this.f335a.containsKey(str)) {
                a(str);
                JSONObject jSONObject2 = new JSONObject((String) this.f335a.get(str));
                f3.b("content_optimizer", "New boolean value received.", jSONObject2, "ContentOptimizer-getBoolWithNameWithoutCache");
                return jSONObject2.getBoolean("new_value");
            }
            f3.b("content_optimizer", "There is no associated data.", "{ 'variable_name': '" + str + "' }", "ContentOptimizer-getBoolWithNameWithoutCache");
            return z;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return z;
        }
    }

    private void a(String str, Object obj, n0 n0Var, ContentOptimizerDataType contentOptimizerDataType) {
        if (e.h) {
            this.b.a(str, obj, n0Var, contentOptimizerDataType);
        }
        HashMap map = new HashMap();
        map.put("variable_name", str);
        map.put("default_value", obj);
        map.put("data_class", n0Var != null ? n0Var.name() : null);
        map.put("data_type", contentOptimizerDataType != null ? contentOptimizerDataType.name() : null);
        Debugger.a(DebuggingTag.addAsNewContentVariable, 4, map);
    }

    private void a(String str) {
        try {
            Debugger.putLog(DebuggingTag.addContentOptimizerLog, 4, str);
            SharedPreferences sharedPreferencesA = a();
            JSONObject jSONObject = new JSONObject(sharedPreferencesA.getString(str, ""));
            if (sharedPreferencesA.contains("test_contents")) {
                return;
            }
            this.b.a(str, jSONObject.getInt("content_id"), jSONObject.getInt("variant_id"));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(JSONArray jSONArray) {
        try {
            SharedPreferences sharedPreferencesA = a();
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if (sharedPreferencesA.contains(string) && (!sharedPreferencesA.contains("test_contents") || !sharedPreferencesA.getString("test_contents", "").equals(string))) {
                    sharedPreferencesA.edit().remove(string).apply();
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void b(JSONArray jSONArray) {
        try {
            SharedPreferences sharedPreferencesA = a();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int i2 = jSONObject.getInt("content_id");
                int i3 = jSONObject.getInt("variant_id");
                JSONArray jSONArray2 = jSONObject.getJSONArray("variables");
                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                    HashMap map = new HashMap();
                    map.put("content_id", Integer.valueOf(i2));
                    map.put("variant_id", Integer.valueOf(i3));
                    map.put("variable_name", jSONObject2.getString("variable_name"));
                    map.put("new_value", jSONObject2.get("new_value"));
                    String string = w4.g(map).toString();
                    if (!sharedPreferencesA.contains("test_contents") || !sharedPreferencesA.getString("test_contents", "").equals(jSONObject2.getString("variable_name"))) {
                        sharedPreferencesA.edit().putString(jSONObject2.getString("variable_name"), string).apply();
                    }
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // com.useinsider.insider.q3
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("passive_variables")) {
                a(jSONObject.getJSONArray("passive_variables"));
            }
            if (jSONObject.has("contents")) {
                b(jSONObject.getJSONArray("contents"));
                c(jSONObject.getJSONArray("contents"));
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // com.useinsider.insider.m3
    public void a(Map map) {
        try {
            if (map.containsKey("test_contents")) {
                b((String) map.get("test_contents"));
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void b(String str) {
        try {
            SharedPreferences sharedPreferencesA = a();
            if (sharedPreferencesA.getBoolean("debug_mode", false)) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    sharedPreferencesA.edit().putString(jSONObject.getString("variable_name"), jSONObject.toString()).putString("test_contents", jSONObject.getString("variable_name")).apply();
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
