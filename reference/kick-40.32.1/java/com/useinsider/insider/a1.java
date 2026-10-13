package com.useinsider.insider;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class a1 extends t0 {
    a1(String str, Object obj) {
        super(str, obj);
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        Long lA;
        Long lA2 = a(map.get(this.f435a));
        return (lA2 == null || (lA = a(this.b)) == null || lA2.longValue() >= lA.longValue()) ? false : true;
    }
}
