package com.useinsider.insider;

import java.math.BigDecimal;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class e1 extends b1 {
    private final Object c;

    e1(String str, Object obj) {
        super(str);
        this.c = obj;
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        BigDecimal bigDecimalA;
        BigDecimal bigDecimalA2 = a(map.get(getKey()));
        return (bigDecimalA2 == null || (bigDecimalA = a(this.c)) == null || bigDecimalA2.compareTo(bigDecimalA) >= 0) ? false : true;
    }
}
