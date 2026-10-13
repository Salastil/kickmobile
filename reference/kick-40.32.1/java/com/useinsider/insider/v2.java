package com.useinsider.insider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class v2 extends k3 implements q3 {
    private final o3 h;
    private final x2 i;
    private final m3 o;
    private final v1 p;
    private final z2 q;
    private final ExecutorService b = Executors.newSingleThreadExecutor();
    private final Map c = new LinkedHashMap();
    private final Map d = new LinkedHashMap();
    private final Map e = new LinkedHashMap();
    private final HashSet f = new HashSet();
    private final Map g = new LinkedHashMap();
    private int j = 0;
    private boolean k = false;
    private boolean l = false;
    private b3 m = null;
    private JSONArray n = null;

    v2(o3 o3Var, l3 l3Var, t1 t1Var, x2 x2Var) {
        m3 m3Var = new m3() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda5
            @Override // com.useinsider.insider.m3
            public final void a(Map map) {
                this.f$0.c(map);
            }
        };
        this.o = m3Var;
        v1 v1Var = new v1() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda6
            @Override // com.useinsider.insider.v1
            public final void a(List list) {
                this.f$0.d(list);
            }
        };
        this.p = v1Var;
        z2 z2Var = new z2() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda7
            @Override // com.useinsider.insider.z2
            public final void a(y2 y2Var, b3 b3Var) {
                this.f$0.a(y2Var, b3Var);
            }
        };
        this.q = z2Var;
        o3Var.a(this);
        l3Var.a(m3Var);
        t1Var.a(v1Var);
        if (x2Var != null) {
            x2Var.a(z2Var);
        }
        this.i = x2Var;
        this.h = o3Var;
    }

    private boolean a(int i, int i2) {
        return i2 >= i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c(String str, p2 p2Var) {
        return str.equals(p2Var.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.c.remove(str);
        this.d.remove(str);
        this.e.remove(str);
        x2 x2Var = this.i;
        if (x2Var != null) {
            x2Var.a(str);
        }
    }

    private void e(final String str) {
        new ArrayList(this.c.keySet()).stream().filter(new Predicate() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda11
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f$0.a(str, (String) obj);
            }
        }).forEach(new v2$$ExternalSyntheticLambda15(this));
    }

    private String g() {
        b3 b3Var = this.m;
        if (b3Var != null) {
            return c(b3Var);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ArrayList h() {
        return new ArrayList(this.g.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        this.k = false;
        this.l = false;
        this.m = null;
        this.n = null;
        this.j = 0;
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.g.clear();
        this.f.clear();
        x2 x2Var = this.i;
        if (x2Var != null) {
            x2Var.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j() {
        Insider.Instance.tagEvent(f.f).build();
    }

    private void k() {
        if (this.k && this.h.c()) {
            ((Executor) b5.b.a()).execute(new Runnable() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    v2.j();
                }
            });
        }
    }

    void b(JSONArray jSONArray) {
        a(jSONArray, this.j);
    }

    public List f() {
        try {
            return (List) this.b.submit(new Callable() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.h();
                }
            }).get();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    private String b(List list) {
        b3 b3Var;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList(this.c.keySet());
        int size = arrayList.size();
        int i = Integer.MAX_VALUE;
        String str = null;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            String str2 = (String) obj;
            if (a(str2, list) && (b3Var = (b3) this.c.get(str2)) != null) {
                if (a(b3Var.i(), i)) {
                    hashSet.remove(str2);
                    if (str != null) {
                        hashSet.add(str);
                    }
                    i = b3Var.i();
                    str = str2;
                } else {
                    hashSet.add(str2);
                }
            }
        }
        if (str != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                a((String) it.next(), list.size());
            }
        }
        return str;
    }

    private static String c(b3 b3Var) {
        return String.valueOf(b3Var.h());
    }

    void a(JSONArray jSONArray, int i) {
        b3 b3Var;
        o oVarB;
        JSONArray jSONArrayA = a(jSONArray);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        for (int i3 = 0; i3 < jSONArrayA.length(); i3++) {
            try {
                b3 b3VarA = c3.a(jSONArrayA.getJSONObject(i3));
                x1 x1VarA = a(b3VarA);
                if (x1VarA != null && (oVarB = b(b3VarA)) != null) {
                    String strC = c(b3VarA);
                    boolean zEqualsIgnoreCase = "session".equalsIgnoreCase(b3VarA.j());
                    boolean zContains = this.f.contains(strC);
                    if (!zEqualsIgnoreCase || !zContains) {
                        if (!this.c.containsKey(strC)) {
                            this.c.put(strC, b3VarA);
                            this.d.put(strC, x1VarA);
                            this.e.put(strC, Integer.valueOf(i));
                            this.g.put(strC, oVarB);
                        }
                        hashSet.add(strC);
                        Debugger.putLog(DebuggingTag.updatedInAppList, 4, this.g.keySet().toString());
                    }
                }
            } catch (Exception unused) {
            }
        }
        ArrayList arrayList = new ArrayList(this.c.keySet());
        int size = arrayList.size();
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            String str = (String) obj;
            if (!hashSet.contains(str) && (b3Var = (b3) this.c.get(str)) != null && "architect".equalsIgnoreCase(b3Var.k())) {
                d(str);
            }
        }
        if (this.k) {
            e(f.f);
        }
        boolean zA = a(this.m, f.d);
        boolean zA2 = a(this.m, f.c);
        if (this.l) {
            if (zA || zA2) {
                b(f.d, g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(JSONObject jSONObject) {
        b(jSONObject != null ? jSONObject.optJSONArray("enhanced_inapps") : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Map map) {
        b(map);
        a(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        JSONObject jSONObjectK = w4.k(str);
        if (jSONObjectK == null) {
            return;
        }
        this.k = true;
        b(new JSONArray().put(jSONObjectK));
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(JSONObject jSONObject) {
        this.l = e.t || e.y;
        JSONArray jSONArrayOptJSONArray = jSONObject != null ? jSONObject.optJSONArray("enhanced_inapps") : null;
        if (this.l && this.m == null) {
            this.n = jSONArrayOptJSONArray;
        } else {
            b(jSONArrayOptJSONArray);
        }
        k();
    }

    @Override // com.useinsider.insider.q3
    public void e() {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.i();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(List list) {
        a(list, new Consumer() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda19
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.a((o) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(final List list) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(b3 b3Var) {
        String strC = c(b3Var);
        a(strC, this.j);
        final o oVar = (o) this.g.get(strC);
        a(new Consumer() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda16
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((w2) obj).a(oVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(String str, p2 p2Var) {
        return str.equals(p2Var.a());
    }

    private void b(final String str, final String str2) {
        new ArrayList(this.c.keySet()).stream().filter(new Predicate() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda17
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f$0.a(str2, str, (String) obj);
            }
        }).forEach(new v2$$ExternalSyntheticLambda15(this));
    }

    private static o b(b3 b3Var) {
        if (b3Var == null) {
            return null;
        }
        return new o.e().b(b3Var.c()).c(b3Var.l()).a(b3Var.f()).b(b3Var.h()).a(b3Var.j()).d(b3Var.d()).a(b3Var.b()).a(b3Var.g()).a();
    }

    @Override // com.useinsider.insider.q3
    public void b(final JSONObject jSONObject) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(jSONObject);
            }
        });
    }

    private void b(Map map) {
        final String str = (String) map.get("inapp_test");
        if (str == null || str.isEmpty()) {
            return;
        }
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        JSONObject jSONObjectJ;
        if (str != null && !str.isEmpty() && (jSONObjectJ = w4.j(str)) != null) {
            this.l = true;
            try {
                this.m = c3.a(jSONObjectJ);
            } catch (Exception unused) {
                this.m = null;
            }
            b(new JSONArray().put(jSONObjectJ));
        }
        JSONArray jSONArray = this.n;
        if (jSONArray != null) {
            a(jSONArray, 0);
            this.n = null;
        }
    }

    private void a(List list, Consumer consumer) {
        b3 b3Var;
        int size = list.size();
        this.j = size;
        String strB = b(list);
        if (strB == null || (b3Var = (b3) this.c.get(strB)) == null) {
            return;
        }
        if (b3Var.m() && this.i != null) {
            this.e.put(strB, Integer.valueOf(size));
            this.i.a(b3Var, strB, size);
        } else {
            a(strB, this.j);
            consumer.accept((o) this.g.get(strB));
        }
    }

    private void a(String str, int i) {
        b3 b3Var = (b3) this.c.get(str);
        if (b3Var == null) {
            return;
        }
        if (b3Var.n()) {
            d(str);
            this.f.add(str);
        } else {
            this.e.put(str, Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(final String str, String str2) {
        b3 b3Var = (b3) this.c.get(str2);
        if (b3Var == null || b3Var.a() == null) {
            return true;
        }
        return b3Var.a().a().stream().noneMatch(new Predicate() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda10
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return v2.b(str, (p2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(String str, final String str2, String str3) {
        b3 b3Var;
        if ((str != null && str.equals(str3)) || (b3Var = (b3) this.c.get(str3)) == null || b3Var.a() == null) {
            return false;
        }
        return b3Var.a().a().stream().anyMatch(new Predicate() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda18
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return v2.c(str2, (p2) obj);
            }
        });
    }

    private boolean a(b3 b3Var, final String str) {
        if (b3Var == null || b3Var.a() == null) {
            return false;
        }
        return b3Var.a().a().stream().anyMatch(new Predicate() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda9
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return v2.a(str, (p2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(String str, p2 p2Var) {
        return str.equals(p2Var.a());
    }

    private boolean a(String str, final List list) {
        final int iIntValue = ((Integer) Optional.ofNullable((Integer) this.e.get(str)).filter(new Predicate() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda12
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return v2.a(list, (Integer) obj);
            }
        }).orElse(0)).intValue();
        return ((Boolean) Optional.ofNullable((x1) this.d.get(str)).map(new Function() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda13
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return v2.a(list, iIntValue, (x1) obj);
            }
        }).orElse(Boolean.FALSE)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(List list, Integer num) {
        return num.intValue() >= 0 && num.intValue() < list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean a(List list, int i, x1 x1Var) {
        return Boolean.valueOf(x1Var.a(list, i));
    }

    private static x1 a(b3 b3Var) {
        r2 r2VarA = b3Var.a();
        if (r2VarA == null) {
            return null;
        }
        return new y1().a(r2VarA.a()).a(r2VarA.b()).a();
    }

    private static JSONArray a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < jSONArray.length(); i++) {
                    jSONArray2.put(jSONArray.getJSONObject(i));
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.getJSONObject(i2).optJSONObject("content");
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("connected_inapps")) {
                        JSONArray jSONArray3 = jSONObjectOptJSONObject.getJSONArray("connected_inapps");
                        if (jSONArray3.length() > 0) {
                            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                                jSONArray2.put(jSONArray3.getJSONObject(i3));
                            }
                        }
                    }
                }
                return jSONArray2;
            } catch (Exception e) {
                Insider.Instance.putException(e);
                return jSONArray;
            }
        }
        return new JSONArray();
    }

    @Override // com.useinsider.insider.q3
    public void a(final JSONObject jSONObject) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(jSONObject);
            }
        });
    }

    private void a(Map map) {
        final String str = (String) map.get("enhanced_push_inapp");
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final o oVar) {
        a(new Consumer() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda21
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((w2) obj).a(oVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(y2 y2Var, final b3 b3Var) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.v2$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(b3Var);
            }
        });
    }
}
