package com.datadog.android.flags.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.flags.internal.aggregation.EvaluationAggregationStats;
import com.datadog.android.flags.internal.aggregation.EvaluationAggregator;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationEventsProcessor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0002JR\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u00192\b\u0010 \u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0019J\b\u0010\"\u001a\u00020\u0015H\u0002J\u0006\u0010#\u001a\u00020\u0015R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/datadog/android/flags/internal/EvaluationEventsProcessor;", "", "writer", "Lcom/datadog/android/flags/internal/EvaluationEventWriter;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "scheduledExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "flushIntervalMs", "", "aggregator", "Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregator;", "periodicFlushEnabled", "", "(Lcom/datadog/android/flags/internal/EvaluationEventWriter;Lcom/datadog/android/internal/time/TimeProvider;Ljava/util/concurrent/ScheduledExecutorService;Lcom/datadog/android/api/InternalLogger;JLcom/datadog/android/flags/internal/aggregation/EvaluationAggregator;Z)V", "flushMutex", "Ljava/util/concurrent/locks/ReentrantLock;", "lastFlushTimeMs", "flush", "", "periodicFlushTask", "processEvaluation", "flagKey", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "rumApplicationId", "rumViewName", "variantKey", "allocationKey", "errorCode", "errorMessage", "startPeriodicFlush", "stop", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationEventsProcessor {
    private final EvaluationAggregator aggregator;
    private final long flushIntervalMs;
    private final ReentrantLock flushMutex;
    private final InternalLogger internalLogger;
    private volatile long lastFlushTimeMs;
    private final ScheduledExecutorService scheduledExecutor;
    private final TimeProvider timeProvider;
    private final EvaluationEventWriter writer;

    public EvaluationEventsProcessor(EvaluationEventWriter writer, TimeProvider timeProvider, ScheduledExecutorService scheduledExecutor, InternalLogger internalLogger, long j, EvaluationAggregator aggregator, boolean z) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(scheduledExecutor, "scheduledExecutor");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(aggregator, "aggregator");
        this.writer = writer;
        this.timeProvider = timeProvider;
        this.scheduledExecutor = scheduledExecutor;
        this.internalLogger = internalLogger;
        this.flushIntervalMs = j;
        this.aggregator = aggregator;
        this.flushMutex = new ReentrantLock();
        this.lastFlushTimeMs = timeProvider.getDeviceTimestampMillis();
        if (z) {
            startPeriodicFlush();
        }
    }

    public /* synthetic */ EvaluationEventsProcessor(EvaluationEventWriter evaluationEventWriter, TimeProvider timeProvider, ScheduledExecutorService scheduledExecutorService, InternalLogger internalLogger, long j, EvaluationAggregator evaluationAggregator, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(evaluationEventWriter, timeProvider, scheduledExecutorService, internalLogger, j, evaluationAggregator, (i & 64) != 0 ? true : z);
    }

    public final void processEvaluation(String flagKey, EvaluationContext context, String rumApplicationId, String rumViewName, String variantKey, String allocationKey, String errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(context, "context");
        List<EvaluationAggregationStats> listRecord = this.aggregator.record(this.timeProvider.getDeviceTimestampMillis(), flagKey, context, rumApplicationId, rumViewName, variantKey, allocationKey, errorCode, errorMessage);
        if (listRecord.isEmpty()) {
            return;
        }
        this.lastFlushTimeMs = this.timeProvider.getDeviceTimestampMillis();
        this.writer.writeAll(listRecord);
    }

    public final void flush() {
        if (this.flushMutex.tryLock()) {
            try {
                List<EvaluationAggregationStats> listDrain = this.aggregator.drain();
                this.lastFlushTimeMs = this.timeProvider.getDeviceTimestampMillis();
                this.flushMutex.unlock();
                if (listDrain.isEmpty()) {
                    return;
                }
                this.writer.writeAll(listDrain);
            } catch (Throwable th) {
                this.flushMutex.unlock();
                throw th;
            }
        }
    }

    private final void startPeriodicFlush() {
        try {
            ScheduledExecutorService scheduledExecutorService = this.scheduledExecutor;
            Runnable runnable = new Runnable() { // from class: com.datadog.android.flags.internal.EvaluationEventsProcessor$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.periodicFlushTask();
                }
            };
            long j = this.flushIntervalMs;
            scheduledExecutorService.scheduleWithFixedDelay(runnable, j, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.EvaluationEventsProcessor.startPeriodicFlush.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to schedule evaluation flush";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void periodicFlushTask() {
        if (this.timeProvider.getDeviceTimestampMillis() - this.lastFlushTimeMs >= this.flushIntervalMs) {
            flush();
        }
    }

    public final void stop() {
        this.scheduledExecutor.shutdown();
        ReentrantLock reentrantLock = this.flushMutex;
        reentrantLock.lock();
        try {
            this.lastFlushTimeMs = this.timeProvider.getDeviceTimestampMillis();
            List<EvaluationAggregationStats> listDrain = this.aggregator.drain();
            reentrantLock.unlock();
            if (!listDrain.isEmpty()) {
                this.writer.writeAll(listDrain);
            }
            try {
                if (this.scheduledExecutor.awaitTermination(1L, TimeUnit.SECONDS)) {
                    return;
                }
                this.scheduledExecutor.shutdownNow();
            } catch (InterruptedException unused) {
                this.scheduledExecutor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
