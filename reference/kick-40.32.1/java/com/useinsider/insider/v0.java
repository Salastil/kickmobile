package com.useinsider.insider;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class v0 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f435a;
    protected final Object b;
    private final j c = new j();

    v0(String str, Object obj) {
        this.f435a = str;
        this.b = obj;
    }

    protected Long a(Object obj) {
        return (Long) this.c.b(obj);
    }

    @Override // com.useinsider.insider.k1
    public String getKey() {
        return this.f435a;
    }
}
