package com.useinsider.insider;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
enum q2 {
    EQUAL("eq"),
    AND("and"),
    OR("or"),
    UNDEFINED("undefined");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f415a;

    q2(String str) {
        this.f415a = str;
    }

    String b() {
        return this.f415a;
    }

    static q2 a(String str) {
        for (q2 q2Var : values()) {
            if (q2Var.f415a.equalsIgnoreCase(str)) {
                return q2Var;
            }
        }
        return UNDEFINED;
    }
}
