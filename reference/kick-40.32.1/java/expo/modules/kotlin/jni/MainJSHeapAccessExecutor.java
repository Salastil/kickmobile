package expo.modules.kotlin.jni;

import com.facebook.react.bridge.ReactApplicationContext;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: compiled from: JSHeapAccessExecutor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0003\u0019\u001a\u001bB\u001b\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0017J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u001e\u0010\u0018\u001a\b\u0018\u00010\u000eR\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R^\u0010\f\u001aR\u0012\u0014\u0012\u0012 \u000f*\b\u0018\u00010\u000eR\u00020\u00000\u000eR\u00020\u0000\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00100\u0010 \u000f*(\u0012\u0014\u0012\u0012 \u000f*\b\u0018\u00010\u000eR\u00020\u00000\u000eR\u00020\u0000\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lexpo/modules/kotlin/jni/MainJSHeapAccessExecutor;", "Lexpo/modules/kotlin/jni/JSHeapAccessExecutor;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "syncTimeoutMillis", "", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;J)V", "accepting", "Ljava/util/concurrent/atomic/AtomicBoolean;", "admissionLock", "", "pending", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "Lexpo/modules/kotlin/jni/MainJSHeapAccessExecutor$PendingTask;", "kotlin.jvm.PlatformType", "", "runOnQueue", "runnable", "Ljava/lang/Runnable;", "onCancellation", "runOnQueueSync", "", "invalidate", "enqueue", "PendingTask", "TaskState", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MainJSHeapAccessExecutor implements JSHeapAccessExecutor {

    @Deprecated
    public static final long DEFAULT_SYNC_TIMEOUT_MILLIS = 5000;
    private final AtomicBoolean accepting;
    private final Object admissionLock;
    private final ConcurrentHashMap.KeySetView<PendingTask, Boolean> pending;
    private final ReactApplicationContext reactContext;
    private final long syncTimeoutMillis;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JSHeapAccessExecutor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/jni/MainJSHeapAccessExecutor$TaskState;", "", "<init>", "(Ljava/lang/String;I)V", "QUEUED", DebugCoroutineInfoImplKt.RUNNING, "CANCELLED", "FINISHED", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private enum TaskState {
        QUEUED,
        RUNNING,
        CANCELLED,
        FINISHED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<TaskState> getEntries() {
            return $ENTRIES;
        }
    }

    public MainJSHeapAccessExecutor(ReactApplicationContext reactContext, long j) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.syncTimeoutMillis = j;
        this.accepting = new AtomicBoolean(true);
        this.admissionLock = new Object();
        this.pending = ConcurrentHashMap.newKeySet();
    }

    public /* synthetic */ MainJSHeapAccessExecutor(ReactApplicationContext reactApplicationContext, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, (i & 2) != 0 ? 5000L : j);
    }

    @Override // expo.modules.kotlin.jni.JSHeapAccessExecutor
    public boolean runOnQueue(Runnable runnable, Runnable onCancellation) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Intrinsics.checkNotNullParameter(onCancellation, "onCancellation");
        return enqueue(runnable, onCancellation) != null;
    }

    @Override // expo.modules.kotlin.jni.JSHeapAccessExecutor
    public void runOnQueueSync(final Runnable runnable) throws Throwable {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (this.reactContext.isOnJSQueueThread()) {
            runnable.run();
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        PendingTask pendingTaskEnqueue = enqueue(new Runnable() { // from class: expo.modules.kotlin.jni.MainJSHeapAccessExecutor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MainJSHeapAccessExecutor.runOnQueueSync$lambda$0(runnable, atomicReference, countDownLatch);
            }
        }, new Runnable() { // from class: expo.modules.kotlin.jni.MainJSHeapAccessExecutor$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MainJSHeapAccessExecutor.runOnQueueSync$lambda$1(atomicReference, countDownLatch);
            }
        });
        if (pendingTaskEnqueue == null) {
            throw new IllegalStateException("Cannot schedule synchronous JavaScript task.");
        }
        try {
            if (!countDownLatch.await(this.syncTimeoutMillis, TimeUnit.MILLISECONDS)) {
                if (pendingTaskEnqueue.cancel()) {
                    throw new IllegalStateException("Timed out waiting to run synchronous JavaScript task. The JS thread may be blocked or shutting down.");
                }
                countDownLatch.await();
            }
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw e;
        }
    }

    static final void runOnQueueSync$lambda$0(Runnable runnable, AtomicReference atomicReference, CountDownLatch countDownLatch) {
        try {
            runnable.run();
            countDownLatch.countDown();
        } catch (Throwable th) {
            try {
                atomicReference.set(th);
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    static final void runOnQueueSync$lambda$1(AtomicReference atomicReference, CountDownLatch countDownLatch) {
        MainJSHeapAccessExecutor$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, new IllegalStateException("JavaScript heap work was cancelled before it could run."));
        countDownLatch.countDown();
    }

    @Override // expo.modules.kotlin.jni.JSHeapAccessExecutor
    public void invalidate() throws Throwable {
        List list;
        synchronized (this.admissionLock) {
            this.accepting.set(false);
            ConcurrentHashMap.KeySetView<PendingTask, Boolean> pending = this.pending;
            Intrinsics.checkNotNullExpressionValue(pending, "pending");
            list = CollectionsKt.toList(pending);
        }
        Iterator it = list.iterator();
        Throwable th = null;
        while (it.hasNext()) {
            try {
                ((PendingTask) it.next()).cancel();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
        }
        if (th != null) {
            throw th;
        }
    }

    private final PendingTask enqueue(Runnable runnable, Runnable onCancellation) {
        boolean z;
        PendingTask pendingTask = new PendingTask(this, runnable, onCancellation);
        synchronized (this.admissionLock) {
            if (this.accepting.get()) {
                this.pending.add(pendingTask);
                z = this.accepting.get();
            } else {
                z = false;
            }
        }
        if (!z) {
            onCancellation.run();
            return null;
        }
        if (!this.accepting.get()) {
            pendingTask.cancel();
            return null;
        }
        if (this.reactContext.runOnJSQueueThread(pendingTask)) {
            return pendingTask;
        }
        pendingTask.cancel();
        return null;
    }

    /* JADX INFO: compiled from: JSHeapAccessExecutor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/jni/MainJSHeapAccessExecutor$PendingTask;", "Ljava/lang/Runnable;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "onCancellation", "<init>", "(Lexpo/modules/kotlin/jni/MainJSHeapAccessExecutor;Ljava/lang/Runnable;Ljava/lang/Runnable;)V", "state", "Ljava/util/concurrent/atomic/AtomicReference;", "Lexpo/modules/kotlin/jni/MainJSHeapAccessExecutor$TaskState;", "kotlin.jvm.PlatformType", "run", "", "cancel", "", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private final class PendingTask implements Runnable {
        private final Runnable body;
        private final Runnable onCancellation;
        private final AtomicReference<TaskState> state;
        final /* synthetic */ MainJSHeapAccessExecutor this$0;

        public PendingTask(MainJSHeapAccessExecutor mainJSHeapAccessExecutor, Runnable body, Runnable onCancellation) {
            Intrinsics.checkNotNullParameter(body, "body");
            Intrinsics.checkNotNullParameter(onCancellation, "onCancellation");
            this.this$0 = mainJSHeapAccessExecutor;
            this.body = body;
            this.onCancellation = onCancellation;
            this.state = new AtomicReference<>(TaskState.QUEUED);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainJSHeapAccessExecutor$$ExternalSyntheticBackportWithForwarding0.m(this.state, TaskState.QUEUED, TaskState.RUNNING)) {
                try {
                    this.body.run();
                } finally {
                    this.state.set(TaskState.FINISHED);
                    this.this$0.pending.remove(this);
                }
            }
        }

        public final boolean cancel() {
            if (!MainJSHeapAccessExecutor$$ExternalSyntheticBackportWithForwarding0.m(this.state, TaskState.QUEUED, TaskState.CANCELLED)) {
                return false;
            }
            this.this$0.pending.remove(this);
            this.onCancellation.run();
            return true;
        }
    }

    /* JADX INFO: compiled from: JSHeapAccessExecutor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/jni/MainJSHeapAccessExecutor$Companion;", "", "<init>", "()V", "DEFAULT_SYNC_TIMEOUT_MILLIS", "", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
