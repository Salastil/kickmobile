package com.datadog.android.core.internal.thread;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.BackPressureStrategy;
import com.datadog.android.core.thread.FlushableExecutorService;
import com.datadog.android.internal.thread.NamedExecutionUnit;
import com.datadog.android.internal.time.TimeProvider;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackPressureExecutorService.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0016\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0016J)\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u0002H\u0019H\u0014¢\u0006\u0002\u0010\u001cJ\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\u0004\b\u0000\u0010\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001eH\u0014J\u0014\u0010\u001f\u001a\u00020\u000f2\n\u0010 \u001a\u00060!j\u0002`\"H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006$"}, d2 = {"Lcom/datadog/android/core/internal/thread/BackPressureExecutorService;", "Ljava/util/concurrent/ThreadPoolExecutor;", "Lcom/datadog/android/core/thread/FlushableExecutorService;", "logger", "Lcom/datadog/android/api/InternalLogger;", "executorContext", "", "backpressureStrategy", "Lcom/datadog/android/core/configuration/BackPressureStrategy;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "(Lcom/datadog/android/api/InternalLogger;Ljava/lang/String;Lcom/datadog/android/core/configuration/BackPressureStrategy;Lcom/datadog/android/internal/time/TimeProvider;)V", "getLogger", "()Lcom/datadog/android/api/InternalLogger;", "afterExecute", "", "r", "Ljava/lang/Runnable;", "t", "", "drainTo", FirebaseAnalytics.Param.DESTINATION, "", "newTaskFor", "Ljava/util/concurrent/RunnableFuture;", ExifInterface.GPS_DIRECTION_TRUE, "runnable", "value", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/RunnableFuture;", "callable", "Ljava/util/concurrent/Callable;", "onDrainException", "e", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackPressureExecutorService extends ThreadPoolExecutor implements FlushableExecutorService, AutoCloseable {
    private static final int CORE_POOL_SIZE = 1;
    private static final long THREAD_POOL_MAX_KEEP_ALIVE_MS;
    private final InternalLogger logger;

    @Override // com.datadog.android.core.thread.FlushableExecutorService, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        UByte$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }

    public final InternalLogger getLogger() {
        return this.logger;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackPressureExecutorService(InternalLogger logger, String executorContext, BackPressureStrategy backpressureStrategy, TimeProvider timeProvider) {
        super(1, 1, THREAD_POOL_MAX_KEEP_ALIVE_MS, TimeUnit.MILLISECONDS, new BackPressuredBlockingQueue(logger, executorContext, backpressureStrategy, timeProvider), new DatadogThreadFactory(executorContext));
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.logger = logger;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        NamedExecutionUnit namedExecutionUnit = callable instanceof NamedExecutionUnit ? (NamedExecutionUnit) callable : null;
        String name = namedExecutionUnit != null ? namedExecutionUnit.getName() : null;
        if (name != null) {
            return new NamedFutureTask(name, callable);
        }
        RunnableFuture<T> runnableFutureNewTaskFor = super.newTaskFor(callable);
        Intrinsics.checkNotNullExpressionValue(runnableFutureNewTaskFor, "super.newTaskFor(callable)");
        return runnableFutureNewTaskFor;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        NamedExecutionUnit namedExecutionUnit = runnable instanceof NamedExecutionUnit ? (NamedExecutionUnit) runnable : null;
        String name = namedExecutionUnit != null ? namedExecutionUnit.getName() : null;
        if (name != null) {
            return new NamedFutureTask(name, runnable, value);
        }
        RunnableFuture<T> runnableFutureNewTaskFor = super.newTaskFor(runnable, value);
        Intrinsics.checkNotNullExpressionValue(runnableFutureNewTaskFor, "super.newTaskFor(runnable, value)");
        return runnableFutureNewTaskFor;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        ThreadExtKt.loggingAfterExecute(r, t, this.logger);
    }

    @Override // com.datadog.android.core.thread.FlushableExecutorService
    public void drainTo(Collection<Runnable> destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        try {
            getQueue().drainTo(destination);
        } catch (ClassCastException e) {
            onDrainException(e);
        } catch (IllegalArgumentException e2) {
            onDrainException(e2);
        } catch (NullPointerException e3) {
            onDrainException(e3);
        } catch (UnsupportedOperationException e4) {
            onDrainException(e4);
        }
    }

    private final void onDrainException(RuntimeException e) {
        InternalLogger.DefaultImpls.log$default(this.logger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.thread.BackPressureExecutorService.onDrainException.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Unable to drain BackPressureExecutorService queue";
            }
        }, (Throwable) e, false, (Map) null, 48, (Object) null);
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        THREAD_POOL_MAX_KEEP_ALIVE_MS = 5000L;
    }
}
