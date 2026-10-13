package androidx.camera.camera2.pipe.core;

import android.os.Process;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;

/* JADX INFO: compiled from: AndroidThreads.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\fJ\u0012\u0010\u0013\u001a\u00020\u0014*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\fJ\n\u0010\u0015\u001a\u00020\u0011*\u00020\u0007J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/pipe/core/AndroidThreads;", "", "<init>", "()V", "NICE_VALUES", "", "factory", "Ljava/util/concurrent/ThreadFactory;", "getFactory", "()Ljava/util/concurrent/ThreadFactory;", "withAndroidPriority", "androidPriority", "", "withPrefix", "namePrefix", "", "asFixedSizeThreadPool", "Ljava/util/concurrent/ExecutorService;", "threads", "asScheduledThreadPool", "Ljava/util/concurrent/ScheduledExecutorService;", "asCachedThreadPool", "androidToJavaPriority", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidThreads {
    public static final AndroidThreads INSTANCE = new AndroidThreads();
    private static final int[] NICE_VALUES = {19, 16, 13, 10, 0, -2, -4, -5, -6, -8};
    private static final ThreadFactory factory;

    private AndroidThreads() {
    }

    static {
        ThreadFactory threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        Intrinsics.checkNotNullExpressionValue(threadFactoryDefaultThreadFactory, "defaultThreadFactory(...)");
        factory = threadFactoryDefaultThreadFactory;
    }

    public final ThreadFactory getFactory() {
        return factory;
    }

    public final ThreadFactory withAndroidPriority(final ThreadFactory threadFactory, final int i) {
        Intrinsics.checkNotNullParameter(threadFactory, "<this>");
        return new ThreadFactory() { // from class: androidx.camera.camera2.pipe.core.AndroidThreads$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return AndroidThreads.withAndroidPriority$lambda$0(i, threadFactory, runnable);
            }
        };
    }

    static final Thread withAndroidPriority$lambda$0(final int i, ThreadFactory threadFactory, final Runnable runnable) {
        int iAndroidToJavaPriority = INSTANCE.androidToJavaPriority(i);
        Thread threadNewThread = threadFactory.newThread(new Runnable() { // from class: androidx.camera.camera2.pipe.core.AndroidThreads$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AndroidThreads.withAndroidPriority$lambda$0$0(i, runnable);
            }
        });
        Intrinsics.checkNotNullExpressionValue(threadNewThread, "newThread(...)");
        threadNewThread.setPriority(iAndroidToJavaPriority);
        return threadNewThread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void withAndroidPriority$lambda$0$0(int i, Runnable runnable) {
        Process.setThreadPriority(i);
        runnable.run();
    }

    public final ThreadFactory withPrefix(final ThreadFactory threadFactory, final String namePrefix) {
        Intrinsics.checkNotNullParameter(threadFactory, "<this>");
        Intrinsics.checkNotNullParameter(namePrefix, "namePrefix");
        final AtomicInt atomicIntAtomic = AtomicFU.atomic(0);
        return new ThreadFactory() { // from class: androidx.camera.camera2.pipe.core.AndroidThreads$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return AndroidThreads.withPrefix$lambda$0(threadFactory, namePrefix, atomicIntAtomic, runnable);
            }
        };
    }

    static final Thread withPrefix$lambda$0(ThreadFactory threadFactory, String str, AtomicInt atomicInt, Runnable runnable) {
        Thread threadNewThread = threadFactory.newThread(runnable);
        Intrinsics.checkNotNullExpressionValue(threadNewThread, "newThread(...)");
        threadNewThread.setName(str + StringsKt.padStart(String.valueOf(atomicInt.incrementAndGet()), 2, '0'));
        return threadNewThread;
    }

    public final ExecutorService asFixedSizeThreadPool(ThreadFactory threadFactory, int i) {
        Intrinsics.checkNotNullParameter(threadFactory, "<this>");
        if (i <= 0) {
            throw new IllegalArgumentException(("Threads (" + i + ") must be > 0").toString());
        }
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(i, threadFactory);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        return executorServiceNewFixedThreadPool;
    }

    public final ScheduledExecutorService asScheduledThreadPool(ThreadFactory threadFactory, int i) {
        Intrinsics.checkNotNullParameter(threadFactory, "<this>");
        if (i <= 0) {
            throw new IllegalArgumentException(("Threads (" + i + ") must be > 0").toString());
        }
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(i, threadFactory);
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewScheduledThreadPool, "newScheduledThreadPool(...)");
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    public final ExecutorService asCachedThreadPool(ThreadFactory threadFactory) {
        Intrinsics.checkNotNullParameter(threadFactory, "<this>");
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool(threadFactory);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewCachedThreadPool, "newCachedThreadPool(...)");
        return executorServiceNewCachedThreadPool;
    }

    private final int androidToJavaPriority(int androidPriority) {
        int length = NICE_VALUES.length;
        for (int i = 0; i < length; i++) {
            if (androidPriority >= NICE_VALUES[i]) {
                return i + 1;
            }
        }
        return 10;
    }
}
