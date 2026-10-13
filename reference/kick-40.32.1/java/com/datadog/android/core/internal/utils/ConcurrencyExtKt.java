package com.datadog.android.core.internal.utils;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.thread.BackPressureExecutorService;
import com.datadog.android.core.internal.thread.ObservableLinkedBlockingQueue;
import com.datadog.android.internal.thread.NamedRunnable;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConcurrencyExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0007\u001a\u00020\b*\u00020\u00052\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007\u001a1\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f*\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0011\u001a:\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013*\u00020\u00142\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007\u001a*\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007\u001a8\u0010\u0019\u001a\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u000f*\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u001cH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u001d"}, d2 = {"ERROR_FUTURE_GET_FAILED", "", "ERROR_TASK_REJECTED", "isWithNamedExecutionUnits", "", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)Z", "executeSafe", "", "operationName", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "runnable", "Ljava/lang/Runnable;", "getSafe", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;Ljava/lang/String;Lcom/datadog/android/api/InternalLogger;)Ljava/lang/Object;", "scheduleSafe", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "delay", "", "unit", "Ljava/util/concurrent/TimeUnit;", "submitSafe", "Ljava/util/concurrent/ExecutorService;", "callable", "Ljava/util/concurrent/Callable;", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ConcurrencyExtKt {
    public static final String ERROR_FUTURE_GET_FAILED = "Unable to get result of the %s task";
    public static final String ERROR_TASK_REJECTED = "Unable to schedule %s task on the executor";

    public static final void executeSafe(Executor executor, final String operationName, InternalLogger internalLogger, Runnable runnable) {
        Intrinsics.checkNotNullParameter(executor, "<this>");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        try {
            if (isWithNamedExecutionUnits(executor) && !(runnable instanceof NamedRunnable)) {
                runnable = new NamedRunnable(operationName, runnable);
            }
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.ConcurrencyExtKt.executeSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, ConcurrencyExtKt.ERROR_TASK_REJECTED, Arrays.copyOf(new Object[]{operationName}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }

    public static final ScheduledFuture<?> scheduleSafe(ScheduledExecutorService scheduledExecutorService, final String operationName, long j, TimeUnit unit, InternalLogger internalLogger, Runnable runnable) {
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "<this>");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        try {
            return scheduledExecutorService.schedule(runnable, j, unit);
        } catch (RejectedExecutionException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.ConcurrencyExtKt.scheduleSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, ConcurrencyExtKt.ERROR_TASK_REJECTED, Arrays.copyOf(new Object[]{operationName}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final Future<?> submitSafe(ExecutorService executorService, final String operationName, InternalLogger internalLogger, Runnable runnable) {
        Intrinsics.checkNotNullParameter(executorService, "<this>");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        try {
            return executorService.submit(runnable);
        } catch (RejectedExecutionException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.ConcurrencyExtKt.submitSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, ConcurrencyExtKt.ERROR_TASK_REJECTED, Arrays.copyOf(new Object[]{operationName}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final <T> Future<T> submitSafe(ExecutorService executorService, final String operationName, InternalLogger internalLogger, Callable<T> callable) {
        Intrinsics.checkNotNullParameter(executorService, "<this>");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(callable, "callable");
        try {
            return executorService.submit(callable);
        } catch (RejectedExecutionException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.ConcurrencyExtKt.submitSafe.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, ConcurrencyExtKt.ERROR_TASK_REJECTED, Arrays.copyOf(new Object[]{operationName}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final <T> T getSafe(Future<T> future, final String operationName, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        if (future != null) {
            try {
                return future.get();
            } catch (InterruptedException e) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.ConcurrencyExtKt.getSafe.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, ConcurrencyExtKt.ERROR_FUTURE_GET_FAILED, Arrays.copyOf(new Object[]{operationName}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            } catch (CancellationException e2) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.ConcurrencyExtKt.getSafe.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, ConcurrencyExtKt.ERROR_FUTURE_GET_FAILED, Arrays.copyOf(new Object[]{operationName}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            } catch (ExecutionException e3) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.ConcurrencyExtKt.getSafe.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, ConcurrencyExtKt.ERROR_FUTURE_GET_FAILED, Arrays.copyOf(new Object[]{operationName}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) e3, false, (Map) null, 48, (Object) null);
            }
        }
        return null;
    }

    private static final boolean isWithNamedExecutionUnits(Executor executor) {
        if (executor instanceof BackPressureExecutorService) {
            return true;
        }
        return (executor instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) executor).getQueue() instanceof ObservableLinkedBlockingQueue);
    }
}
