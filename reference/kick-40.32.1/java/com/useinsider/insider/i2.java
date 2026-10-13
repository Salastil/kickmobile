package com.useinsider.insider;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class i2 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n2 f343a;
    private final String b;

    i2(String str, Throwable th) {
        super(str, th);
        this.f343a = null;
        this.b = null;
    }

    n2 a() {
        return this.f343a;
    }

    i2(String str, n2 n2Var, String str2) {
        super(str);
        this.f343a = n2Var;
        this.b = str2;
    }

    i2(String str, n2 n2Var, String str2, Throwable th) {
        super(str, th);
        this.f343a = n2Var;
        this.b = str2;
    }
}
