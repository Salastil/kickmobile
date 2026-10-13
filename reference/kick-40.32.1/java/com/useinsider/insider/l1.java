package com.useinsider.insider;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class l1 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f383a;
    private final Object b;
    private final e4 c = new e4(new f4());

    l1(String str, Object obj) {
        this.f383a = str;
        this.b = obj;
    }

    private List a(Object obj) {
        return (List) this.c.b(obj);
    }

    @Override // com.useinsider.insider.k1
    public String getKey() {
        return this.f383a;
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        List listA;
        List<BigDecimal> listA2 = a(map.get(getKey()));
        if (listA2 != null && (listA = a(this.b)) != null && !listA.isEmpty()) {
            for (BigDecimal bigDecimal : listA2) {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    if (bigDecimal.compareTo((BigDecimal) it.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
