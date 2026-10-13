package com.useinsider.insider;

import java.util.function.Consumer;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class p3 extends k3 implements o3 {
    private boolean b = false;
    private String c = null;

    p3() {
    }

    void c(final JSONObject jSONObject) {
        a(new Consumer() { // from class: com.useinsider.insider.p3$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((q3) obj).b(jSONObject);
            }
        });
    }

    void d(final JSONObject jSONObject) {
        synchronized (this) {
            this.b = true;
            if (jSONObject != null) {
                this.c = jSONObject.optString("session_id", null);
            } else {
                this.c = null;
            }
        }
        a(new Consumer() { // from class: com.useinsider.insider.p3$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((q3) obj).a(jSONObject);
            }
        });
    }

    void f() {
        synchronized (this) {
            this.b = false;
            this.c = null;
        }
        a(new Consumer() { // from class: com.useinsider.insider.p3$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((q3) obj).e();
            }
        });
    }

    @Override // com.useinsider.insider.o3
    public synchronized boolean c() {
        return this.b;
    }
}
