package com.useinsider.insider;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class y implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static y f447a;

    private y() {
    }

    public static synchronized y b() {
        if (f447a == null) {
            f447a = new y();
        }
        return f447a;
    }

    @Override // com.useinsider.insider.x
    public void a(String str) {
        h3.d(str);
    }

    @Override // com.useinsider.insider.x
    public void c(String str) {
        h3.e(str);
    }

    @Override // com.useinsider.insider.x
    public void a() {
        h3.c();
    }

    @Override // com.useinsider.insider.x
    public void b(String str) {
        h3.f(str);
    }
}
