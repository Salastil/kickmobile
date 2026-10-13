package com.useinsider.insider;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class g0 extends k3 implements e0 {
    private final i0 f;
    private final v1 h;
    private final k0 i;
    private final ExecutorService b = (ExecutorService) b5.f317a.a();
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final Map e = new HashMap();
    private int g = 0;

    g0(t1 t1Var, i0 i0Var) {
        v1 v1Var = new v1() { // from class: com.useinsider.insider.g0$$ExternalSyntheticLambda2
            @Override // com.useinsider.insider.v1
            public final void a(List list) {
                this.f$0.d(list);
            }
        };
        this.h = v1Var;
        k0 k0Var = new k0() { // from class: com.useinsider.insider.g0$$ExternalSyntheticLambda3
            public final void onConditionDispatched(i0 i0Var2, String str) {
                this.f$0.a(i0Var2, str);
            }
        };
        this.i = k0Var;
        this.f = i0Var;
        t1Var.a(v1Var);
        i0Var.a(k0Var);
    }

    private void a(List list, Consumer consumer) {
        Set<String> setB = b(list);
        for (String str : setB) {
            this.e.put(str, Integer.valueOf(this.g));
            f0.a(this.c.get(str));
        }
        if (setB.isEmpty()) {
            return;
        }
        consumer.accept(setB);
    }

    private Set b(final List list) {
        HashSet hashSet = new HashSet();
        for (String str : this.d.keySet()) {
            final int iIntValue = ((Integer) Optional.ofNullable((Integer) this.e.get(str)).filter(new Predicate() { // from class: com.useinsider.insider.g0$$ExternalSyntheticLambda4
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return g0.a(list, (Integer) obj);
                }
            }).orElse(0)).intValue();
            if (((Boolean) Optional.ofNullable((x1) this.d.get(str)).map(new Function() { // from class: com.useinsider.insider.g0$$ExternalSyntheticLambda5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return g0.a(list, iIntValue, (x1) obj);
                }
            }).orElse(Boolean.FALSE)).booleanValue()) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(List list) {
        this.g = list.size();
        a(list, new Consumer() { // from class: com.useinsider.insider.g0$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.a((Set) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(final List list) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.g0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final String str) {
        this.e.put(str, Integer.valueOf(this.g));
        a(new Consumer() { // from class: com.useinsider.insider.g0$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                g0.a(str, (h0) obj);
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final Set set) {
        a(new Consumer() { // from class: com.useinsider.insider.g0$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((h0) obj).a(set);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(i0 i0Var, final String str) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.g0$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, h0 h0Var) {
        h0Var.a(UByte$$ExternalSyntheticBackport0.m12760m(new Object[]{str}));
    }
}
