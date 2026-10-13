package io.github.expo.modules.v2.react;

import com.facebook.react.bridge.ReactContext;
import io.github.expo.modules.v2.async.JSScheduler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactJSScheduler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lio/github/expo/modules/v2/react/ReactJSScheduler;", "Lio/github/expo/modules/v2/async/JSScheduler;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "<init>", "(Lcom/facebook/react/bridge/ReactContext;)V", "drainMicrotasks", "Lkotlin/Function0;", "", "getDrainMicrotasks$react_release", "()Lkotlin/jvm/functions/Function0;", "setDrainMicrotasks$react_release", "(Lkotlin/jvm/functions/Function0;)V", "closed", "", "isOnJSThread", "()Z", "post", "job", "Ljava/lang/Runnable;", "close", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReactJSScheduler implements JSScheduler {
    private volatile boolean closed;
    private volatile Function0<Unit> drainMicrotasks;
    private final ReactContext reactContext;

    public ReactJSScheduler(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public boolean awaitJob(long j) {
        return super.awaitJob(j);
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public int drainPending() {
        return super.drainPending();
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public void postOrExecuteIfOnJsThread(Runnable runnable) {
        super.postOrExecuteIfOnJsThread(runnable);
    }

    public final Function0<Unit> getDrainMicrotasks$react_release() {
        return this.drainMicrotasks;
    }

    public final void setDrainMicrotasks$react_release(Function0<Unit> function0) {
        this.drainMicrotasks = function0;
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public boolean isOnJSThread() {
        return this.reactContext.isOnJSQueueThread();
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public void post(final Runnable job) {
        Intrinsics.checkNotNullParameter(job, "job");
        if (this.closed) {
            return;
        }
        this.reactContext.runOnJSQueueThread(new Runnable() { // from class: io.github.expo.modules.v2.react.ReactJSScheduler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ReactJSScheduler.post$lambda$0(job, this);
            }
        });
    }

    static final void post$lambda$0(Runnable runnable, ReactJSScheduler reactJSScheduler) {
        runnable.run();
        Function0<Unit> function0 = reactJSScheduler.drainMicrotasks;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // io.github.expo.modules.v2.async.JSScheduler
    public void close() {
        this.closed = true;
        this.drainMicrotasks = null;
    }
}
