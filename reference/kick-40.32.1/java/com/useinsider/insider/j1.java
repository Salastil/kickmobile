package com.useinsider.insider;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class j1 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f346a;
    private final Object b;
    private final e5 c = new y4();
    private final e4 d = new e4(new y4());

    j1(String str, Object obj) {
        this.f346a = str;
        this.b = obj;
    }

    private Object a(Object obj, e5 e5Var) {
        return e5Var.b(obj);
    }

    @Override // com.useinsider.insider.k1
    public String getKey() {
        return this.f346a;
    }

    @Override // com.useinsider.insider.g1
    public boolean a(Map map) {
        List list;
        final String str = (String) a(map.get(getKey()), this.c);
        if (str == null || (list = (List) a(this.b, this.d)) == null) {
            return false;
        }
        return list.stream().anyMatch(new Predicate() { // from class: com.useinsider.insider.j1$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return j1.a(str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(String str, String str2) {
        return str2.equalsIgnoreCase(str);
    }
}
