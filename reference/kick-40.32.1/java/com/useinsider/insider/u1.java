package com.useinsider.insider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class u1 extends k3 implements t1 {
    private final ScheduledExecutorService b = (ScheduledExecutorService) b5.f317a.a();
    private final List c = new ArrayList();
    private boolean d = false;
    private final q3 e;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements q3 {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            u1.this.d = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            u1.this.d = false;
            u1.this.c.clear();
            u1.this.g();
        }

        @Override // com.useinsider.insider.q3
        public void e() {
            u1.this.b.execute(new Runnable() { // from class: com.useinsider.insider.u1$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            });
        }

        @Override // com.useinsider.insider.q3
        public void a(JSONObject jSONObject) {
            u1.this.b.execute(new Runnable() { // from class: com.useinsider.insider.u1$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }
    }

    u1(o3 o3Var) {
        a aVar = new a();
        this.e = aVar;
        o3Var.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InsiderEvent f() {
        if (this.c.isEmpty()) {
            return null;
        }
        List list = this.c;
        return (InsiderEvent) list.get(list.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        final ArrayList arrayList = new ArrayList(this.c);
        a(new Consumer() { // from class: com.useinsider.insider.u1$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((v1) obj).a(arrayList);
            }
        });
    }

    @Override // com.useinsider.insider.t1
    public CompletableFuture d() {
        return CompletableFuture.supplyAsync(new Supplier() { // from class: com.useinsider.insider.u1$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.f();
            }
        }, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(InsiderEvent insiderEvent) {
        if (this.d) {
            this.c.add(insiderEvent);
            g();
        }
    }

    @Override // com.useinsider.insider.t1
    public void a(final InsiderEvent insiderEvent) {
        this.b.execute(new Runnable() { // from class: com.useinsider.insider.u1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(insiderEvent);
            }
        });
    }
}
