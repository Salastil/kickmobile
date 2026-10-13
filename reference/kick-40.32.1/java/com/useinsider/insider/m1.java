package com.useinsider.insider;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class m1 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f390a;
    private final Object b;
    private final e4 c = new e4(new y4());

    protected m1(String str, Object obj) {
        this.f390a = str;
        this.b = obj;
    }

    protected List a(Object obj) {
        return (List) this.c.b(obj);
    }

    @Override // com.useinsider.insider.k1
    public String getKey() {
        return this.f390a;
    }

    protected Object a() {
        return this.b;
    }
}
