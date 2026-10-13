package org.h.s;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f589a;
    public ScheduledExecutorService b;
    public volatile boolean c;
    public volatile ScheduledFuture d;

    public x3(final d4 expirationFunction) {
        Intrinsics.checkNotNullParameter(expirationFunction, "expirationFunction");
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewScheduledThreadPool, "newScheduledThreadPool(...)");
        this.b = scheduledExecutorServiceNewScheduledThreadPool;
        this.f589a = new Runnable() { // from class: org.h.s.x3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                x3.a(this.f$0, expirationFunction);
            }
        };
    }

    public static final void a(x3 this$0, Function0 expirationFunction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(expirationFunction, "$expirationFunction");
        this$0.c = false;
        expirationFunction.invoke();
    }

    public final synchronized void a(long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        a();
        if (this.b.isShutdown()) {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
            Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewScheduledThreadPool, "newScheduledThreadPool(...)");
            this.b = scheduledExecutorServiceNewScheduledThreadPool;
        }
        this.d = this.b.schedule(this.f589a, j, timeUnit);
        this.c = true;
    }

    public final synchronized void a() {
        ScheduledFuture scheduledFuture = this.d;
        if (scheduledFuture != null) {
            if (!scheduledFuture.isDone()) {
                scheduledFuture.cancel(false);
            }
            this.d = null;
        }
        this.c = false;
    }
}
