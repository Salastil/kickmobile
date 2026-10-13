package org.h.s;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes11.dex */
public final class f2 {
    public static final void a(r0 r0Var) {
        synchronized (g2.e) {
            n4 n4Var = new n4(d2.f496a, new e2(r0Var));
            if (g2.f.getCount() == 0) {
                g2.f = new CountDownLatch(1);
            }
            if (!g2.g) {
                r0Var.a(n4Var);
                g2.g = true;
            }
        }
    }
}
