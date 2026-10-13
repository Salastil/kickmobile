package com.useinsider.insider;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class q1 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k1 f414a;

    q1(k1 k1Var) {
        this.f414a = k1Var;
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        if (map.containsKey(getKey())) {
            return !this.f414a.a(map);
        }
        return false;
    }

    @Override // com.useinsider.insider.k1
    public String getKey() {
        return this.f414a.getKey();
    }
}
