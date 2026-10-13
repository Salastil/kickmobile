package com.useinsider.insider;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class d0 implements t3, b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t3 f321a;
    private final z b;
    private b0 c;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements b0 {
        a() {
        }

        @Override // com.useinsider.insider.b0
        public void c() {
            d0.this.b();
        }
    }

    d0(t3 t3Var, z zVar) {
        a aVar = new a();
        this.c = aVar;
        this.f321a = t3Var;
        this.b = zVar;
        zVar.a(aVar);
    }

    @Override // com.useinsider.insider.t3
    public void a(String str, Runnable runnable, long j) {
        if (this.b.a()) {
            return;
        }
        this.f321a.a(str, runnable, j);
    }

    @Override // com.useinsider.insider.t3
    public void b() {
        this.f321a.b();
    }

    @Override // com.useinsider.insider.t3
    public boolean b(String str) {
        return this.f321a.b(str);
    }

    @Override // com.useinsider.insider.t3
    public void a(String str) {
        this.f321a.a(str);
    }
}
