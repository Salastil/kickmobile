package com.useinsider.insider;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class o1 extends m1 {
    o1(String str) {
        super(str, null);
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        List listA = a(map.get(getKey()));
        if (listA == null) {
            return false;
        }
        return listA.isEmpty();
    }
}
