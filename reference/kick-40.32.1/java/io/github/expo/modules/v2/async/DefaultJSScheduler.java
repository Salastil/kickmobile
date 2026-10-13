package io.github.expo.modules.v2.async;

import io.github.expo.modules.v2.logging.PlatformLoggerKt;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: DefaultJSScheduler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lio/github/expo/modules/v2/async/DefaultJSScheduler;", "Lio/github/expo/modules/v2/async/JSScheduler;", "<init>", "()V", "owner", "Ljava/lang/Thread;", "jobs", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/Runnable;", "arrivals", "Ljava/util/concurrent/Semaphore;", "closed", "", "isOnJSThread", "()Z", "post", "", "job", "drainPending", "", "awaitJob", "timeoutNanos", "", "close", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultJSScheduler implements JSScheduler {
    private final Semaphore arrivals;
    private volatile boolean closed;
    private final ConcurrentLinkedQueue<Runnable> jobs;
    private final Thread owner;

    public DefaultJSScheduler() {
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(threadCurrentThread, "currentThread(...)");
        this.owner = threadCurrentThread;
        this.jobs = new ConcurrentLinkedQueue<>();
        this.arrivals = new Semaphore(0);
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public void postOrExecuteIfOnJsThread(Runnable runnable) {
        super.postOrExecuteIfOnJsThread(runnable);
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public boolean isOnJSThread() {
        return Thread.currentThread() == this.owner;
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public void post(Runnable job) {
        Intrinsics.checkNotNullParameter(job, "job");
        if (this.closed) {
            return;
        }
        this.jobs.add(job);
        this.arrivals.release();
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public int drainPending() {
        if (!isOnJSThread()) {
            throw new IllegalStateException(("drainPending() ran on " + Thread.currentThread().getName() + ", but the JS thread is " + this.owner.getName()).toString());
        }
        int i = 0;
        while (true) {
            Runnable runnablePoll = this.jobs.poll();
            if (runnablePoll == null) {
                return i;
            }
            this.arrivals.tryAcquire();
            i++;
            try {
                runnablePoll.run();
            } catch (Throwable th) {
                PlatformLoggerKt.getPlatformLogger().error("a JS-thread job failed", th);
            }
        }
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public boolean awaitJob(long timeoutNanos) throws InterruptedException {
        if (this.closed) {
            return false;
        }
        boolean zTryAcquire = this.arrivals.tryAcquire(timeoutNanos, TimeUnit.NANOSECONDS);
        if (zTryAcquire) {
            this.arrivals.release();
        }
        return zTryAcquire;
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public void close() {
        this.closed = true;
        this.jobs.clear();
        this.arrivals.release(LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }
}
