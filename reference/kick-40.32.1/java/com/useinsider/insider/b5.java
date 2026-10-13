package com.useinsider.insider;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d3 f317a = new d3(new Supplier() { // from class: com.useinsider.insider.b5$$ExternalSyntheticLambda0
        @Override // java.util.function.Supplier
        public final Object get() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    });
    static final d3 b = new d3(new Supplier() { // from class: com.useinsider.insider.b5$$ExternalSyntheticLambda1
        @Override // java.util.function.Supplier
        public final Object get() {
            return b5.a();
        }
    });
    static final d3 c = new d3(new Supplier() { // from class: com.useinsider.insider.b5$$ExternalSyntheticLambda2
        @Override // java.util.function.Supplier
        public final Object get() {
            return b5.b();
        }
    });
    private static final d3 d = new d3(new Supplier() { // from class: com.useinsider.insider.b5$$ExternalSyntheticLambda3
        @Override // java.util.function.Supplier
        public final Object get() {
            return b5.c();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Executor a() {
        return new Executor() { // from class: com.useinsider.insider.b5$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                b5.a(runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ExecutorService b() {
        return Executors.newFixedThreadPool(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Handler c() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ((Handler) d.a()).post(runnable);
        }
    }
}
