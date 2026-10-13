package com.useinsider.insider;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class u3 implements t3, AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f432a = new ConcurrentHashMap();
    private final ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();

    u3() {
    }

    @Override // com.useinsider.insider.t3
    public void a(final String str, final Runnable runnable, long j) {
        a(str);
        this.f432a.put(str, this.b.schedule(new Runnable() { // from class: com.useinsider.insider.u3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(runnable, str);
            }
        }, j, TimeUnit.MILLISECONDS));
    }

    @Override // com.useinsider.insider.t3
    public void b() {
        Iterator it = this.f432a.entrySet().iterator();
        while (it.hasNext()) {
            ((ScheduledFuture) ((Map.Entry) it.next()).getValue()).cancel(true);
        }
        this.f432a.clear();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        b();
        this.b.shutdownNow();
    }

    @Override // com.useinsider.insider.t3
    public boolean b(String str) {
        return this.f432a.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Runnable runnable, String str) {
        try {
            runnable.run();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        } finally {
            a(str);
        }
    }

    @Override // com.useinsider.insider.t3
    public void a(String str) {
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f432a.remove(str);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }
}
