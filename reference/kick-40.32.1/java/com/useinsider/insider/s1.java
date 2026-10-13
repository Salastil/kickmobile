package com.useinsider.insider;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class s1 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f423a;
    private final Object b;
    private final c c = new c();

    public s1(String str, Object obj) {
        this.f423a = str;
        this.b = obj;
    }

    private Boolean a(Object obj) {
        return (Boolean) this.c.b(obj);
    }

    @Override // com.useinsider.insider.k1
    public String getKey() {
        return this.f423a;
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        Boolean boolA;
        Boolean boolA2 = a(map.get(getKey()));
        return (boolA2 == null || (boolA = a(this.b)) == null || boolA2.booleanValue() != boolA.booleanValue()) ? false : true;
    }
}
