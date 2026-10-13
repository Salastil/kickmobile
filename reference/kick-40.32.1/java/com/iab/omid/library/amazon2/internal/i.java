package com.iab.omid.library.amazon2.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.amazon2.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class i implements d.a, com.iab.omid.library.amazon2.devicevolume.c {
    private static i f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f197a = 0.0f;
    private final com.iab.omid.library.amazon2.devicevolume.e b;
    private final com.iab.omid.library.amazon2.devicevolume.b c;
    private com.iab.omid.library.amazon2.devicevolume.d d;
    private c e;

    public i(com.iab.omid.library.amazon2.devicevolume.e eVar, com.iab.omid.library.amazon2.devicevolume.b bVar) {
        this.b = eVar;
        this.c = bVar;
    }

    private c a() {
        if (this.e == null) {
            this.e = c.c();
        }
        return this.e;
    }

    public static i c() {
        if (f == null) {
            f = new i(new com.iab.omid.library.amazon2.devicevolume.e(), new com.iab.omid.library.amazon2.devicevolume.b());
        }
        return f;
    }

    @Override // com.iab.omid.library.amazon2.devicevolume.c
    public void a(float f2) {
        this.f197a = f2;
        Iterator<com.iab.omid.library.amazon2.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().d().a(f2);
        }
    }

    public void a(Context context) {
        this.d = this.b.a(new Handler(), context, this.c.a(), this);
    }

    @Override // com.iab.omid.library.amazon2.internal.d.a
    public void a(boolean z) {
        TreeWalker treeWalker = TreeWalker.getInstance();
        if (z) {
            treeWalker.h();
        } else {
            treeWalker.g();
        }
    }

    public float b() {
        return this.f197a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.d.b();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.d.c();
    }
}
