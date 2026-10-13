package com.useinsider.insider;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class y0 extends r1 {
    y0(String str, Object obj) {
        super(str, obj);
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        Long lB;
        Long lA = a(map.get(this.f435a));
        if (lA == null || (lB = b(this.b)) == null) {
            return false;
        }
        Long lA2 = a();
        return lA.longValue() >= lA2.longValue() - lB.longValue() && lA.longValue() < lA2.longValue();
    }
}
