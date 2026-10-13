package com.useinsider.insider;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class k2 {
    private static final EnumSet f = EnumSet.of(l2.a.RUNNING, l2.a.READY);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final j2 f348a;
    private final Map b = new ConcurrentHashMap();
    private final Map c = new ConcurrentHashMap();
    private d2 d;
    private f2 e;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    interface a {
        void a(m2 m2Var, Object obj, Exception exc);
    }

    k2(j2 j2Var) {
        this.f348a = j2Var;
    }

    d2 a() {
        if (this.d == null) {
            this.d = new e2();
        }
        return this.d;
    }

    f2 b() {
        if (this.e == null) {
            this.e = new g2();
        }
        return this.e;
    }

    void a(f2 f2Var) {
        this.e = f2Var;
    }

    void a(String str) {
        this.b.remove(str);
        this.c.remove(str);
    }

    String a(m2 m2Var, JSONObject jSONObject, final a aVar) {
        try {
            final m2 m2VarA = a().a(m2Var, jSONObject);
            final AtomicReference atomicReference = new AtomicReference();
            l2 l2VarA = this.f348a.a(m2VarA, new j2.a() { // from class: com.useinsider.insider.k2$$ExternalSyntheticLambda0
                @Override // com.useinsider.insider.j2.a
                public final void a(String str, n2 n2Var, Exception exc) {
                    this.f$0.a(atomicReference, aVar, m2VarA, str, n2Var, exc);
                }
            });
            String strA = l2VarA.a();
            atomicReference.set(strA);
            this.b.put(strA, l2VarA);
            this.c.put(strA, l2.a.READY);
            l2VarA.b();
            this.c.put(strA, l2.a.RUNNING);
            return strA;
        } catch (i2 e) {
            aVar.a(m2Var, null, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AtomicReference atomicReference, a aVar, m2 m2Var, String str, n2 n2Var, Exception exc) {
        a((String) atomicReference.get());
        try {
            if (exc != null) {
                aVar.a(m2Var, null, exc);
            } else {
                aVar.a(m2Var, b().a(n2Var, str), null);
            }
        } catch (i2 e) {
            aVar.a(m2Var, null, e);
        }
    }
}
