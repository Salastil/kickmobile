package com.iab.omid.library.amazon2.attestation;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class c {
    private static final Map<String, k> d = new HashMap();
    private static volatile c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f177a = new d();
    private final Context b;
    private volatile List<b> c;

    private c(Context context) {
        this.b = context != null ? context.getApplicationContext() : null;
        c();
    }

    public static c a(Context context) {
        if (e == null) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c(context);
                }
            }
        }
        return e;
    }

    private void c() {
        d.put("FireTVFOSDAT", j.a(this.b));
    }

    public List<b> a() {
        List<b> list;
        b bVarA;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            if (this.c != null) {
                list = this.c;
            } else {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, k> entry : d.entrySet()) {
                        if (entry.getValue().a() && (bVarA = this.f177a.a(entry.getKey(), this.b)) != null) {
                            arrayList.add(bVarA);
                        }
                    }
                    this.c = arrayList;
                    list = this.c;
                } catch (Exception e2) {
                    com.iab.omid.library.amazon2.utils.d.a("Error getting supported attestation mechanisms", e2);
                    this.c = new ArrayList();
                    return this.c;
                }
            }
        }
        return list;
    }

    public boolean a(String str) {
        k kVar = d.get(str);
        if (kVar != null) {
            return kVar.a();
        }
        return false;
    }

    public boolean b() {
        return a().size() > 0;
    }
}
