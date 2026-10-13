package com.useinsider.insider;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class p1 extends m1 {
    p1(String str, Object obj) {
        super(str, obj);
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        List listA;
        List<String> listA2 = a(map.get(getKey()));
        if (listA2 != null && (listA = a(a())) != null && !listA.isEmpty()) {
            for (String str : listA2) {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    if (str.equalsIgnoreCase((String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
