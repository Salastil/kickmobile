package com.useinsider.insider;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class f1 implements g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f330a;

    f1(List list) {
        this.f330a = list;
    }

    @Override // com.useinsider.insider.g1
    public boolean a(final Map map) {
        return this.f330a.stream().allMatch(new Predicate() { // from class: com.useinsider.insider.f1$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return f1.a(map, (g1) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(Map map, g1 g1Var) {
        return g1Var.a(map);
    }
}
