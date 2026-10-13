package com.useinsider.insider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f400a;
    private final Map b = new HashMap();

    n2(int i, Map map) {
        this.f400a = i;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (str != null && list != null && !list.isEmpty()) {
                    this.b.put(str, (String) list.get(0));
                }
            }
        }
    }

    String a() {
        return (String) this.b.get("Content-Type");
    }

    int b() {
        return this.f400a;
    }
}
