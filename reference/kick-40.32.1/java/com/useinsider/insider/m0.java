package com.useinsider.insider;

import androidx.core.util.Supplier;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class m0 {
    private static volatile m0 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f387a = new HashMap();
    private final Map b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f388a;
        b b;

        a(Object obj, b bVar) {
            this.f388a = obj;
            this.b = bVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    enum b {
        SINGLETON,
        TRANSIENT
    }

    private m0() {
    }

    static m0 f() {
        if (c == null) {
            synchronized (m0.class) {
                if (c == null) {
                    c = new m0();
                }
            }
        }
        return c;
    }

    synchronized void a(Supplier supplier, Class cls, b bVar) {
        this.f387a.put(cls, new a(supplier, bVar));
        this.b.remove(cls);
    }

    z b() {
        return (z) a(z.class);
    }

    h c() {
        return (h) a(h.class);
    }

    t1 d() {
        return (t1) a(t1.class);
    }

    i0 e() {
        return (i0) a(i0.class);
    }

    h2 g() {
        return (h2) a(h2.class);
    }

    v2 h() {
        return (v2) a(v2.class);
    }

    x2 i() {
        return (x2) a(x2.class);
    }

    y3 j() {
        if (((a) this.f387a.get(y3.class)) == null) {
            return null;
        }
        return (y3) a(y3.class);
    }

    l3 k() {
        return (l3) a(l3.class);
    }

    p3 l() {
        return (p3) a(o3.class);
    }

    t3 m() {
        return (t3) a(t3.class);
    }

    v3 n() {
        return (v3) a(v3.class);
    }

    synchronized Object a(Class cls) {
        Object objA;
        a aVar = (a) this.f387a.get(cls);
        if (aVar == null) {
            Insider.Instance.putException(new IllegalStateException("No entry registered for type: " + cls));
            return null;
        }
        try {
            try {
                if (aVar.b == b.SINGLETON) {
                    objA = this.b.get(cls);
                    if (objA == null) {
                        objA = a(aVar, cls);
                        this.b.put(cls, objA);
                    }
                } else {
                    objA = a(aVar, cls);
                }
                return cls.cast(objA);
            } catch (Exception e) {
                Insider.Instance.putException(e);
                return null;
            }
        } catch (ClassCastException e2) {
            throw e2;
        }
    }

    private Object a(a aVar, Class cls) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Object obj = aVar.f388a;
        if (obj instanceof Class) {
            objNewInstance = ((Class) obj).getDeclaredConstructor(null).newInstance(null);
        } else if (obj instanceof Supplier) {
            objNewInstance = ((Supplier) obj).get();
        } else {
            throw new IllegalStateException("Unsupported provider type: " + aVar.f388a.getClass());
        }
        if (cls.isInstance(objNewInstance)) {
            return objNewInstance;
        }
        throw new ClassCastException("Registered type does not match instance type for: " + cls);
    }

    InsiderAppCards a() {
        return (InsiderAppCards) a(InsiderAppCards.class);
    }
}
