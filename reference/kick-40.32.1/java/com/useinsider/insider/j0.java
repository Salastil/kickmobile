package com.useinsider.insider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class j0 extends k3 implements i0 {
    private final ScheduledExecutorService b = (ScheduledExecutorService) b5.f317a.a();
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final t3 e;
    private final v1 f;

    public j0(t1 t1Var, t3 t3Var) {
        v1 v1Var = new v1() { // from class: com.useinsider.insider.j0$$ExternalSyntheticLambda0
            @Override // com.useinsider.insider.v1
            public final void a(List list) {
                this.f$0.b(list);
            }
        };
        this.f = v1Var;
        t1Var.a(v1Var);
        this.e = t3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        this.e.a(str);
        this.c.remove(str);
        this.d.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(List list) {
        for (String str : this.c.keySet()) {
            if (a(str, list)) {
                a(str);
            }
        }
    }

    public void a(final String str) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.j0$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(str);
            }
        });
    }

    private boolean a(String str, final List list) {
        final int iIntValue = ((Integer) Optional.ofNullable((Integer) this.d.get(str)).filter(new Predicate() { // from class: com.useinsider.insider.j0$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return j0.a(list, (Integer) obj);
            }
        }).orElse(0)).intValue();
        return ((Boolean) Optional.ofNullable((x1) this.c.get(str)).map(new Function() { // from class: com.useinsider.insider.j0$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return j0.a(list, iIntValue, (x1) obj);
            }
        }).orElse(Boolean.FALSE)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final List list) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.j0$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(List list, Integer num) {
        return num.intValue() >= 0 && num.intValue() < list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean a(List list, int i, x1 x1Var) {
        return Boolean.valueOf(x1Var.a(list, i));
    }
}
