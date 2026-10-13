package com.iab.omid.library.amazon2.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes8.dex */
public class c {
    private static c c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.amazon2.adsession.a> f190a = new ArrayList<>();
    private final ArrayList<com.iab.omid.library.amazon2.adsession.a> b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return c;
    }

    public Collection<com.iab.omid.library.amazon2.adsession.a> a() {
        return Collections.unmodifiableCollection(this.b);
    }

    public void a(com.iab.omid.library.amazon2.adsession.a aVar) {
        this.f190a.add(aVar);
    }

    public Collection<com.iab.omid.library.amazon2.adsession.a> b() {
        return Collections.unmodifiableCollection(this.f190a);
    }

    public void b(com.iab.omid.library.amazon2.adsession.a aVar) {
        boolean zD = d();
        this.f190a.remove(aVar);
        this.b.remove(aVar);
        if (!zD || d()) {
            return;
        }
        i.c().e();
    }

    public void c(com.iab.omid.library.amazon2.adsession.a aVar) {
        boolean zD = d();
        this.b.add(aVar);
        if (zD) {
            return;
        }
        i.c().d();
    }

    public boolean d() {
        return this.b.size() > 0;
    }
}
