package com.useinsider.insider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class y2 extends k3 implements x2, q3, v1 {
    private final ScheduledExecutorService b = (ScheduledExecutorService) b5.f317a.a();
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final t3 e;

    public y2(o3 o3Var, t1 t1Var, t3 t3Var) {
        o3Var.a(this);
        t1Var.a(this);
        this.e = t3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        this.e.a(str);
        this.c.remove(str);
        this.d.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.e.b();
        this.d.clear();
        this.c.clear();
    }

    @Override // com.useinsider.insider.x2
    public void a(final b3 b3Var, final String str, final int i) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.y2$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, b3Var, i);
            }
        });
    }

    @Override // com.useinsider.insider.q3
    public void e() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final String str, final b3 b3Var, int i) {
        x1 x1VarA;
        if (this.e.b(str) || (x1VarA = a(b3Var)) == null) {
            return;
        }
        this.c.put(str, x1VarA);
        this.d.put(str, Integer.valueOf(i));
        this.e.a(str, new Runnable() { // from class: com.useinsider.insider.y2$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, b3Var);
            }
        }, ((long) b3Var.e().c()) * 1000);
    }

    @Override // com.useinsider.insider.x2
    public void b() {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.y2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list) {
        for (String str : this.c.keySet()) {
            if (a(str, list)) {
                a(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, final b3 b3Var) {
        a(str);
        a(new Consumer() { // from class: com.useinsider.insider.y2$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.a(b3Var, (z2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b3 b3Var, z2 z2Var) {
        z2Var.a(this, b3Var);
    }

    @Override // com.useinsider.insider.x2
    public void a(final String str) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.y2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(str);
            }
        });
    }

    private boolean a(String str, final List list) {
        final int iIntValue = ((Integer) Optional.ofNullable((Integer) this.d.get(str)).filter(new Predicate() { // from class: com.useinsider.insider.y2$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return y2.a(list, (Integer) obj);
            }
        }).orElse(0)).intValue();
        return ((Boolean) Optional.ofNullable((x1) this.c.get(str)).map(new Function() { // from class: com.useinsider.insider.y2$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return y2.a(list, iIntValue, (x1) obj);
            }
        }).orElse(Boolean.FALSE)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(List list, Integer num) {
        return num.intValue() >= 0 && num.intValue() < list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean a(List list, int i, x1 x1Var) {
        return Boolean.valueOf(x1Var.a(list, i));
    }

    private x1 a(b3 b3Var) {
        a3 a3VarE = b3Var.e();
        if (a3VarE == null) {
            return null;
        }
        return new y1().a(a3VarE.a()).a(a3VarE.b()).a();
    }

    @Override // com.useinsider.insider.v1
    public void a(final List list) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.y2$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(list);
            }
        });
    }
}
