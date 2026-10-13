package com.useinsider.insider;

import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class z1 implements x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Predicate f453a;
    private final Predicate b;
    private final int c;

    z1(final String str, int i, final g1 g1Var) {
        this.f453a = new Predicate() { // from class: com.useinsider.insider.z1$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return z1.a(str, (InsiderEvent) obj);
            }
        };
        this.c = i;
        if (g1Var == null) {
            this.b = new Predicate() { // from class: com.useinsider.insider.z1$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return z1.a((InsiderEvent) obj);
                }
            };
        } else {
            this.b = new Predicate() { // from class: com.useinsider.insider.z1$$ExternalSyntheticLambda2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return z1.a(g1Var, (InsiderEvent) obj);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(InsiderEvent insiderEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(String str, InsiderEvent insiderEvent) {
        return str.equals(insiderEvent.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(g1 g1Var, InsiderEvent insiderEvent) {
        return g1Var.a(insiderEvent.getParameters());
    }

    @Override // com.useinsider.insider.x1
    public boolean a(List list, int i) {
        return i >= 0 && i < list.size() && list.size() - i >= this.c && list.stream().skip((long) i).filter(this.f453a.and(this.b)).limit((long) this.c).count() == ((long) this.c);
    }
}
