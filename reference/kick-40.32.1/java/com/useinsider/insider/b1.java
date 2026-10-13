package com.useinsider.insider;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class b1 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f314a;
    private final e5 b = new f4();

    b1(String str) {
        this.f314a = str;
    }

    BigDecimal a(Object obj) {
        return (BigDecimal) this.b.b(obj);
    }

    @Override // com.useinsider.insider.k1
    public String getKey() {
        return this.f314a;
    }
}
