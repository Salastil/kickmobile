package androidx.camera.camera2.pipe.config;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.core.AndroidThreads;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: ThreadConfigModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/config/ThreadConfigModule;", "", "threadConfig", "Landroidx/camera/camera2/pipe/CameraPipe$ThreadConfig;", "<init>", "(Landroidx/camera/camera2/pipe/CameraPipe$ThreadConfig;)V", "lightweightThreadCount", "", "backgroundThreadCount", "cameraThreadPriority", "defaultThreadPriority", "provideThreads", "Landroidx/camera/camera2/pipe/core/Threads;", "cameraPipeLifetime", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "cameraPipeJob", "Lkotlinx/coroutines/Job;", "provideTestOnlyThreads", "testDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "testScope", "Lkotlinx/coroutines/CoroutineScope;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
public final class ThreadConfigModule {
    private final int backgroundThreadCount;
    private final int cameraThreadPriority;
    private final int defaultThreadPriority;
    private final int lightweightThreadCount;
    private final CameraPipe.ThreadConfig threadConfig;

    static final Executor provideTestOnlyThreads$lambda$1(Executor executor) {
        return executor;
    }

    public ThreadConfigModule(CameraPipe.ThreadConfig threadConfig) {
        Intrinsics.checkNotNullParameter(threadConfig, "threadConfig");
        this.threadConfig = threadConfig;
        this.lightweightThreadCount = Math.max(4, Runtime.getRuntime().availableProcessors() - 2);
        this.backgroundThreadCount = 4;
        this.cameraThreadPriority = -3;
        this.defaultThreadPriority = -1;
    }

    /* JADX WARN: Type inference failed for: r13v12, types: [T, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r13v4, types: [T, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r13v7, types: [T, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r14v2, types: [T, kotlinx.coroutines.CoroutineScope] */
    @Provides
    @Singleton
    public final Threads provideThreads(final CameraPipeLifetime cameraPipeLifetime, @CameraPipeJob Job cameraPipeJob) {
        Intrinsics.checkNotNullParameter(cameraPipeLifetime, "cameraPipeLifetime");
        Intrinsics.checkNotNullParameter(cameraPipeJob, "cameraPipeJob");
        final ArrayList arrayList = new ArrayList();
        ScheduledExecutorService defaultBlockingExecutor = this.threadConfig.getDefaultBlockingExecutor();
        if (defaultBlockingExecutor == null) {
            ScheduledExecutorService scheduledExecutorServiceAsScheduledThreadPool = AndroidThreads.INSTANCE.asScheduledThreadPool(AndroidThreads.INSTANCE.withAndroidPriority(AndroidThreads.INSTANCE.withPrefix(AndroidThreads.INSTANCE.getFactory(), "CXCP-IO-"), this.defaultThreadPriority), 8);
            arrayList.add(scheduledExecutorServiceAsScheduledThreadPool);
            defaultBlockingExecutor = scheduledExecutorServiceAsScheduledThreadPool;
        }
        Executor executor = defaultBlockingExecutor;
        CoroutineDispatcher coroutineDispatcherFrom = ExecutorsKt.from(executor);
        ScheduledExecutorService defaultBackgroundExecutor = this.threadConfig.getDefaultBackgroundExecutor();
        if (defaultBackgroundExecutor == null) {
            ScheduledExecutorService scheduledExecutorServiceAsScheduledThreadPool2 = AndroidThreads.INSTANCE.asScheduledThreadPool(AndroidThreads.INSTANCE.withAndroidPriority(AndroidThreads.INSTANCE.withPrefix(AndroidThreads.INSTANCE.getFactory(), "CXCP-BG-"), this.defaultThreadPriority), this.backgroundThreadCount);
            arrayList.add(scheduledExecutorServiceAsScheduledThreadPool2);
            defaultBackgroundExecutor = scheduledExecutorServiceAsScheduledThreadPool2;
        }
        Executor executor2 = defaultBackgroundExecutor;
        CoroutineDispatcher coroutineDispatcherFrom2 = ExecutorsKt.from(executor2);
        ScheduledExecutorService defaultLightweightExecutor = this.threadConfig.getDefaultLightweightExecutor();
        if (defaultLightweightExecutor == null) {
            ScheduledExecutorService scheduledExecutorServiceAsScheduledThreadPool3 = AndroidThreads.INSTANCE.asScheduledThreadPool(AndroidThreads.INSTANCE.withAndroidPriority(AndroidThreads.INSTANCE.withPrefix(AndroidThreads.INSTANCE.getFactory(), "CXCP-"), this.cameraThreadPriority), this.lightweightThreadCount);
            arrayList.add(scheduledExecutorServiceAsScheduledThreadPool3);
            defaultLightweightExecutor = scheduledExecutorServiceAsScheduledThreadPool3;
        }
        Executor executor3 = defaultLightweightExecutor;
        CoroutineDispatcher coroutineDispatcherFrom3 = ExecutorsKt.from(executor3);
        cameraPipeLifetime.addShutdownAction(CameraPipeLifetime.ShutdownType.THREAD, new Runnable() { // from class: androidx.camera.camera2.pipe.config.ThreadConfigModule$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                ThreadConfigModule.provideThreads$lambda$3(arrayList);
            }
        });
        Function0<Handler> defaultCameraHandlerFn = this.threadConfig.getDefaultCameraHandlerFn();
        if (defaultCameraHandlerFn == null) {
            defaultCameraHandlerFn = new Function0() { // from class: androidx.camera.camera2.pipe.config.ThreadConfigModule$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ThreadConfigModule.provideThreads$lambda$4(this.f$0, cameraPipeLifetime);
                }
            };
        }
        Function0<Handler> function0 = defaultCameraHandlerFn;
        Function0 function1 = new Function0() { // from class: androidx.camera.camera2.pipe.config.ThreadConfigModule$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ThreadConfigModule.provideThreads$lambda$5(this.f$0, cameraPipeLifetime);
            }
        };
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        if (this.threadConfig.getTestOnlyScope() != null) {
            objectRef.element = this.threadConfig.getTestOnlyScope();
            objectRef2.element = this.threadConfig.getTestOnlyScope();
        } else {
            objectRef.element = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob(cameraPipeJob).plus(coroutineDispatcherFrom3).plus(new CoroutineName(Log.TAG)));
            objectRef2.element = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob(cameraPipeJob).plus(new CoroutineName("CXCP-Dispatch")));
            cameraPipeLifetime.addShutdownAction(CameraPipeLifetime.ShutdownType.SCOPE, new Runnable() { // from class: androidx.camera.camera2.pipe.config.ThreadConfigModule$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    ThreadConfigModule.provideThreads$lambda$6(objectRef, objectRef2);
                }
            });
        }
        return new Threads((CoroutineScope) objectRef.element, (CoroutineScope) objectRef2.element, executor, coroutineDispatcherFrom, executor2, coroutineDispatcherFrom2, executor3, coroutineDispatcherFrom3, function0, function1);
    }

    static final void provideThreads$lambda$3(List list) throws InterruptedException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ExecutorService) it.next()).shutdownNow();
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((ExecutorService) it2.next()).awaitTermination(1L, TimeUnit.SECONDS);
        }
    }

    static final Handler provideThreads$lambda$4(ThreadConfigModule threadConfigModule, CameraPipeLifetime cameraPipeLifetime) {
        if (threadConfigModule.threadConfig.getDefaultCameraHandler() == null) {
            final HandlerThread handlerThread = new HandlerThread("CXCP-Camera-H", threadConfigModule.cameraThreadPriority);
            handlerThread.start();
            cameraPipeLifetime.addShutdownAction(CameraPipeLifetime.ShutdownType.THREAD, new Runnable() { // from class: androidx.camera.camera2.pipe.config.ThreadConfigModule$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ThreadConfigModule.provideThreads$lambda$4$1(handlerThread);
                }
            });
            return new Handler(handlerThread.getLooper());
        }
        return threadConfigModule.threadConfig.getDefaultCameraHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideThreads$lambda$4$1(HandlerThread handlerThread) {
        handlerThread.quit();
        handlerThread.join(1000L);
    }

    static final Executor provideThreads$lambda$5(ThreadConfigModule threadConfigModule, CameraPipeLifetime cameraPipeLifetime) {
        if (threadConfigModule.threadConfig.getDefaultCameraExecutor() == null) {
            final ExecutorService executorServiceAsFixedSizeThreadPool = AndroidThreads.INSTANCE.asFixedSizeThreadPool(AndroidThreads.INSTANCE.withAndroidPriority(AndroidThreads.INSTANCE.withPrefix(AndroidThreads.INSTANCE.getFactory(), "CXCP-Camera-E"), threadConfigModule.cameraThreadPriority), 1);
            cameraPipeLifetime.addShutdownAction(CameraPipeLifetime.ShutdownType.THREAD, new Runnable() { // from class: androidx.camera.camera2.pipe.config.ThreadConfigModule$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    ThreadConfigModule.provideThreads$lambda$5$0(executorServiceAsFixedSizeThreadPool);
                }
            });
            return executorServiceAsFixedSizeThreadPool;
        }
        return threadConfigModule.threadConfig.getDefaultCameraExecutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideThreads$lambda$5$0(ExecutorService executorService) throws InterruptedException {
        executorService.shutdownNow();
        executorService.awaitTermination(1L, TimeUnit.SECONDS);
    }

    static final void provideThreads$lambda$6(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        CoroutineScopeKt.cancel$default((CoroutineScope) objectRef.element, null, 1, null);
        CoroutineScopeKt.cancel$default((CoroutineScope) objectRef2.element, null, 1, null);
    }

    private final Threads provideTestOnlyThreads(CoroutineDispatcher testDispatcher, CoroutineScope testScope) {
        final Executor executorAsExecutor = ExecutorsKt.asExecutor(testDispatcher);
        return new Threads(testScope, testScope, executorAsExecutor, testDispatcher, executorAsExecutor, testDispatcher, executorAsExecutor, testDispatcher, new Function0() { // from class: androidx.camera.camera2.pipe.config.ThreadConfigModule$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ThreadConfigModule.provideTestOnlyThreads$lambda$0(this.f$0);
            }
        }, new Function0() { // from class: androidx.camera.camera2.pipe.config.ThreadConfigModule$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ThreadConfigModule.provideTestOnlyThreads$lambda$1(executorAsExecutor);
            }
        });
    }

    static final Handler provideTestOnlyThreads$lambda$0(ThreadConfigModule threadConfigModule) {
        HandlerThread handlerThread = new HandlerThread("CXCP-Camera-H", threadConfigModule.cameraThreadPriority);
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }
}
