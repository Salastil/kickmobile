package com.iab.omid.library.amazon2.walking;

import android.view.View;
import com.iab.omid.library.amazon2.internal.e;
import com.iab.omid.library.amazon2.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f217a = new HashMap<>();
    private final HashMap<View, C0149a> b = new HashMap<>();
    private final HashMap<String, View> c = new HashMap<>();
    private final HashSet<View> d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();
    private final HashSet<String> f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private final HashSet<String> h = new HashSet<>();
    private final Map<View, Boolean> i = new WeakHashMap();
    private boolean j;

    /* JADX INFO: renamed from: com.iab.omid.library.amazon2.walking.a$a, reason: collision with other inner class name */
    public static class C0149a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f218a;
        private final ArrayList<String> b = new ArrayList<>();

        public C0149a(e eVar, String str) {
            this.f218a = eVar;
            a(str);
        }

        public e a() {
            return this.f218a;
        }

        public void a(String str) {
            this.b.add(str);
        }

        public ArrayList<String> b() {
            return this.b;
        }
    }

    private Boolean a(View view) {
        boolean zHasWindowFocus = view.hasWindowFocus();
        Map<View, Boolean> map = this.i;
        if (zHasWindowFocus) {
            map.remove(view);
            return Boolean.FALSE;
        }
        boolean zContainsKey = map.containsKey(view);
        Map<View, Boolean> map2 = this.i;
        if (zContainsKey) {
            return map2.get(view);
        }
        Boolean bool = Boolean.FALSE;
        map2.put(view, bool);
        return bool;
    }

    private String a(View view, boolean z) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (a(view).booleanValue() && !z) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String strA = h.a(view);
            if (strA != null) {
                return strA;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.d.addAll(hashSet);
        return null;
    }

    private void a(com.iab.omid.library.amazon2.adsession.a aVar) {
        Iterator<e> it = aVar.f().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.amazon2.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0149a c0149a = this.b.get(view);
        if (c0149a != null) {
            c0149a.a(aVar.c());
        } else {
            this.b.put(view, new C0149a(eVar, aVar.c()));
        }
    }

    public View a(String str) {
        return this.c.get(str);
    }

    public void a() {
        this.f217a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.j = false;
        this.h.clear();
    }

    public C0149a b(View view) {
        C0149a c0149a = this.b.get(view);
        if (c0149a != null) {
            this.b.remove(view);
        }
        return c0149a;
    }

    public String b(String str) {
        return this.g.get(str);
    }

    public HashSet<String> b() {
        return this.f;
    }

    public String c(View view) {
        if (this.f217a.size() == 0) {
            return null;
        }
        String str = this.f217a.get(view);
        if (str != null) {
            this.f217a.remove(view);
        }
        return str;
    }

    public HashSet<String> c() {
        return this.e;
    }

    public boolean c(String str) {
        return this.h.contains(str);
    }

    public c d(View view) {
        if (this.d.contains(view)) {
            return c.PARENT_VIEW;
        }
        return this.j ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void d() {
        this.j = true;
    }

    public void e() {
        com.iab.omid.library.amazon2.internal.c cVarC = com.iab.omid.library.amazon2.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.amazon2.adsession.a aVar : cVarC.a()) {
                View viewE = aVar.e();
                if (aVar.h()) {
                    String strC = aVar.c();
                    if (viewE != null) {
                        boolean zE = h.e(viewE);
                        if (zE) {
                            this.h.add(strC);
                        }
                        String strA = a(viewE, zE);
                        if (strA == null) {
                            this.e.add(strC);
                            this.f217a.put(viewE, strC);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f.add(strC);
                            this.c.put(strC, viewE);
                            this.g.put(strC, strA);
                        }
                    } else {
                        this.f.add(strC);
                        this.g.put(strC, "noAdView");
                    }
                }
            }
        }
    }

    public boolean e(View view) {
        if (!this.i.containsKey(view)) {
            return true;
        }
        this.i.put(view, Boolean.TRUE);
        return false;
    }
}
