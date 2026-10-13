package com.datadog.android.core.internal.thread;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.BackPressureStrategy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoggingScheduledThreadPoolExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/core/internal/thread/LoggingScheduledThreadPoolExecutor;", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "corePoolSize", "", "executorContext", "", "logger", "Lcom/datadog/android/api/InternalLogger;", "backPressureStrategy", "Lcom/datadog/android/core/configuration/BackPressureStrategy;", "(ILjava/lang/String;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/configuration/BackPressureStrategy;)V", "afterExecute", "", "r", "Ljava/lang/Runnable;", "t", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LoggingScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor implements AutoCloseable {
    private final BackPressureStrategy backPressureStrategy;
    private final InternalLogger logger;

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        UByte$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoggingScheduledThreadPoolExecutor(int i, final String executorContext, final InternalLogger logger, final BackPressureStrategy backPressureStrategy) {
        super(i, new DatadogThreadFactory(executorContext), new RejectedExecutionHandler() { // from class: com.datadog.android.core.internal.thread.LoggingScheduledThreadPoolExecutor$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                LoggingScheduledThreadPoolExecutor._init_$lambda$0(logger, executorContext, backPressureStrategy, runnable, threadPoolExecutor);
            }
        });
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(backPressureStrategy, "backPressureStrategy");
        this.logger = logger;
        this.backPressureStrategy = backPressureStrategy;
    }

    static final void _init_$lambda$0(InternalLogger internalLogger, String str, BackPressureStrategy backPressureStrategy, final Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (runnable != null) {
            internalLogger.log(InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0<String>() { // from class: com.datadog.android.core.internal.thread.LoggingScheduledThreadPoolExecutor$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Dropped scheduled item in LoggingScheduledThreadPoolExecutor queue: " + runnable;
                }
            }, (Throwable) null, false, MapsKt.mapOf(TuplesKt.to("executor.context", str)));
            backPressureStrategy.getOnItemDropped().invoke(runnable);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        ThreadExtKt.loggingAfterExecute(r, t, this.logger);
    }
}
