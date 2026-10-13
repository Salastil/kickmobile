package com.iab.omid.library.amazon2.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.amazon2.internal.k;
import com.iab.omid.library.amazon2.utils.f;
import com.iab.omid.library.amazon2.utils.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class TreeWalker implements com.iab.omid.library.amazon2.processor.a.InterfaceC0147a {
    private static TreeWalker i = new TreeWalker();
    private static Handler j = new Handler(Looper.getMainLooper());
    private static Handler k = null;
    private static final Runnable l = new b();
    private static final Runnable m = new c();
    private int b;
    private long h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f215a = new ArrayList();
    private boolean c = false;
    private final List<com.iab.omid.library.amazon2.weakreference.a> d = new ArrayList();
    private com.iab.omid.library.amazon2.walking.a f = new com.iab.omid.library.amazon2.walking.a();
    private com.iab.omid.library.amazon2.processor.b e = new com.iab.omid.library.amazon2.processor.b();
    private com.iab.omid.library.amazon2.walking.b g = new com.iab.omid.library.amazon2.walking.b(new com.iab.omid.library.amazon2.walking.async.c());

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.g.b();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.getInstance().l();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.k != null) {
                TreeWalker.k.post(TreeWalker.l);
                TreeWalker.k.postDelayed(TreeWalker.m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    private void a(long j2) {
        if (this.f215a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f215a) {
                int i2 = this.b;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                treeWalkerTimeLogger.onTreeProcessed(i2, j2 / 1000000);
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.b, j2);
                }
            }
        }
    }

    private void a(View view, com.iab.omid.library.amazon2.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.amazon2.walking.c cVar, boolean z) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.amazon2.walking.c.PARENT_VIEW, z);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.amazon2.processor.a aVarB = this.e.b();
        String strB = this.f.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.amazon2.utils.c.a(jSONObjectA, str);
            com.iab.omid.library.amazon2.utils.c.b(jSONObjectA, strB);
            com.iab.omid.library.amazon2.utils.c.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        com.iab.omid.library.amazon2.walking.a.C0149a c0149aB = this.f.b(view);
        if (c0149aB == null) {
            return false;
        }
        com.iab.omid.library.amazon2.utils.c.a(jSONObject, c0149aB);
        return true;
    }

    private boolean b(View view, JSONObject jSONObject) {
        String strC = this.f.c(view);
        if (strC == null) {
            return false;
        }
        com.iab.omid.library.amazon2.utils.c.a(jSONObject, strC);
        com.iab.omid.library.amazon2.utils.c.a(jSONObject, Boolean.valueOf(this.f.e(view)));
        com.iab.omid.library.amazon2.utils.c.b(jSONObject, Boolean.valueOf(this.f.c(strC)));
        this.f.d();
        return true;
    }

    private void d() {
        a(f.b() - this.h);
    }

    private void e() {
        this.b = 0;
        this.d.clear();
        this.c = false;
        Iterator<com.iab.omid.library.amazon2.adsession.a> it = com.iab.omid.library.amazon2.internal.c.c().a().iterator();
        while (it.hasNext()) {
            if (it.next().g()) {
                this.c = true;
                break;
            }
        }
        this.h = f.b();
    }

    public static TreeWalker getInstance() {
        return i;
    }

    private void i() {
        if (k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            k = handler;
            handler.post(l);
            k.postDelayed(m, 200L);
        }
    }

    private void k() {
        Handler handler = k;
        if (handler != null) {
            handler.removeCallbacks(m);
            k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e();
        f();
        d();
        k.b().a();
    }

    @Override // com.iab.omid.library.amazon2.processor.a.InterfaceC0147a
    public void a(View view, com.iab.omid.library.amazon2.processor.a aVar, JSONObject jSONObject, boolean z) {
        com.iab.omid.library.amazon2.walking.c cVarD;
        TreeWalker treeWalker;
        if (h.f(view) && (cVarD = this.f.d(view)) != com.iab.omid.library.amazon2.walking.c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.amazon2.utils.c.a(jSONObject, jSONObjectA);
            if (b(view, jSONObjectA)) {
                treeWalker = this;
            } else {
                boolean z2 = z || a(view, jSONObjectA);
                if (this.c && cVarD == com.iab.omid.library.amazon2.walking.c.OBSTRUCTION_VIEW && !z2) {
                    this.d.add(new com.iab.omid.library.amazon2.weakreference.a(view));
                }
                treeWalker = this;
                treeWalker.a(view, aVar, jSONObjectA, cVarD, z2);
            }
            treeWalker.b++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f215a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f215a.add(treeWalkerTimeLogger);
    }

    void f() {
        TreeWalker treeWalker;
        this.f.e();
        long jB = f.b();
        com.iab.omid.library.amazon2.processor.a aVarA = this.e.a();
        if (this.f.b().size() > 0) {
            for (String str : this.f.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.f.a(str), jSONObjectA);
                com.iab.omid.library.amazon2.utils.c.c(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.g.a(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f.c().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            treeWalker = this;
            treeWalker.a(null, aVarA, jSONObjectA2, com.iab.omid.library.amazon2.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.amazon2.utils.c.c(jSONObjectA2);
            treeWalker.g.b(jSONObjectA2, treeWalker.f.c(), jB);
            if (treeWalker.c) {
                Iterator<com.iab.omid.library.amazon2.adsession.a> it = com.iab.omid.library.amazon2.internal.c.c().a().iterator();
                while (it.hasNext()) {
                    it.next().a(treeWalker.d);
                }
            }
        } else {
            treeWalker = this;
            treeWalker.g.b();
        }
        treeWalker.f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f215a.clear();
        j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f215a.contains(treeWalkerTimeLogger)) {
            this.f215a.remove(treeWalkerTimeLogger);
        }
    }
}
