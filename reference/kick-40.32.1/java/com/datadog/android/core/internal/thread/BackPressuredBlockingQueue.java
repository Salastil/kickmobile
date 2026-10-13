package com.datadog.android.core.internal.thread;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.BackPressureMitigation;
import com.datadog.android.core.configuration.BackPressureStrategy;
import com.datadog.android.internal.thread.NamedExecutionUnit;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackPressuredBlockingQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB[\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u0017J)\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u00002\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0\u0014H\u0002¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0012H\u0002J\u0015\u0010#\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010$J'\u0010#\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010)J\u0015\u0010*\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/datadog/android/core/internal/thread/BackPressuredBlockingQueue;", ExifInterface.LONGITUDE_EAST, "", "Lcom/datadog/android/core/internal/thread/ObservableLinkedBlockingQueue;", "logger", "Lcom/datadog/android/api/InternalLogger;", "executorContext", "", "backPressureStrategy", "Lcom/datadog/android/core/configuration/BackPressureStrategy;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "(Lcom/datadog/android/api/InternalLogger;Ljava/lang/String;Lcom/datadog/android/core/configuration/BackPressureStrategy;Lcom/datadog/android/internal/time/TimeProvider;)V", "notifyThreshold", "", "capacity", "onThresholdReached", "Lkotlin/Function0;", "", "onItemDropped", "Lkotlin/Function1;", "backpressureMitigation", "Lcom/datadog/android/core/configuration/BackPressureMitigation;", "(Lcom/datadog/android/api/InternalLogger;Ljava/lang/String;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/datadog/android/core/configuration/BackPressureMitigation;Lcom/datadog/android/internal/time/TimeProvider;)V", "getCapacity$dd_sdk_android_core_release", "()I", "addWithBackPressure", "", "e", "operation", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "notifyItemDropped", "item", "(Ljava/lang/Object;)V", "notifyThresholdReached", "offer", "(Ljava/lang/Object;)Z", InstrumentationTags.TIMEOUT, "", "unit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/lang/Object;JLjava/util/concurrent/TimeUnit;)Z", "put", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackPressuredBlockingQueue<E> extends ObservableLinkedBlockingQueue<E> {
    private final BackPressureMitigation backpressureMitigation;
    private final int capacity;
    private final String executorContext;
    private final InternalLogger logger;
    private final int notifyThreshold;
    private final Function1<Object, Unit> onItemDropped;
    private final Function0<Unit> onThresholdReached;
    private final TimeProvider timeProvider;

    /* JADX INFO: compiled from: BackPressuredBlockingQueue.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackPressureMitigation.values().length];
            try {
                iArr[BackPressureMitigation.DROP_OLDEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackPressureMitigation.IGNORE_NEWEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: getCapacity$dd_sdk_android_core_release, reason: from getter */
    public final int getCapacity() {
        return this.capacity;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BackPressuredBlockingQueue(InternalLogger logger, String executorContext, BackPressureStrategy backPressureStrategy, TimeProvider timeProvider) {
        this(logger, executorContext, backPressureStrategy.getCapacity(), backPressureStrategy.getCapacity(), backPressureStrategy.getOnThresholdReached(), backPressureStrategy.getOnItemDropped(), backPressureStrategy.getBackpressureMitigation(), timeProvider);
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        Intrinsics.checkNotNullParameter(backPressureStrategy, "backPressureStrategy");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackPressuredBlockingQueue(InternalLogger logger, String executorContext, int i, int i2, Function0<Unit> onThresholdReached, Function1<Object, Unit> onItemDropped, BackPressureMitigation backPressureMitigation, TimeProvider timeProvider) {
        super(i2);
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        Intrinsics.checkNotNullParameter(onThresholdReached, "onThresholdReached");
        Intrinsics.checkNotNullParameter(onItemDropped, "onItemDropped");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.logger = logger;
        this.executorContext = executorContext;
        this.capacity = i2;
        this.notifyThreshold = i;
        this.onThresholdReached = onThresholdReached;
        this.onItemDropped = onItemDropped;
        this.backpressureMitigation = backPressureMitigation;
        this.timeProvider = timeProvider;
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return addWithBackPressure(e, new Function1<E, Boolean>(this) { // from class: com.datadog.android.core.internal.thread.BackPressuredBlockingQueue.offer.1
            final /* synthetic */ BackPressuredBlockingQueue<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(E it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(BackPressuredBlockingQueue.super.offer(it));
            }
        });
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    public boolean offer(E e, long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!super.offer(e, timeout, unit)) {
            return offer(e);
        }
        if (size() != this.notifyThreshold) {
            return true;
        }
        notifyThresholdReached();
        return true;
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    public void put(E e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (size() + 1 == this.notifyThreshold) {
            notifyThresholdReached();
        }
        super.put(e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean addWithBackPressure(E e, Function1<? super E, Boolean> operation) {
        if (remainingCapacity() == 0) {
            BackPressureMitigation backPressureMitigation = this.backpressureMitigation;
            int i = backPressureMitigation == null ? -1 : WhenMappings.$EnumSwitchMapping$0[backPressureMitigation.ordinal()];
            if (i != -1) {
                if (i == 1) {
                    Object first = take();
                    Intrinsics.checkNotNullExpressionValue(first, "first");
                    notifyItemDropped(first);
                    return operation.invoke(e).booleanValue();
                }
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            notifyItemDropped(e);
            return true;
        }
        if (size() + 1 == this.notifyThreshold) {
            notifyThresholdReached();
        }
        return operation.invoke(e).booleanValue();
    }

    private final void notifyThresholdReached() {
        Map<String, Integer> mapDumpQueue = dumpQueue(this.timeProvider.getDeviceTimestampMillis());
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put("capacity", Integer.valueOf(this.capacity));
        if (mapDumpQueue != null && !mapDumpQueue.isEmpty()) {
            mapCreateMapBuilder.put("dump", mapDumpQueue);
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        this.onThresholdReached.invoke();
        this.logger.log(InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0<String>(this) { // from class: com.datadog.android.core.internal.thread.BackPressuredBlockingQueue.notifyThresholdReached.1
            final /* synthetic */ BackPressuredBlockingQueue<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "BackPressuredBlockingQueue reached capacity:" + ((BackPressuredBlockingQueue) this.this$0).notifyThreshold;
            }
        }, (Throwable) null, false, MapsKt.mapOf(TuplesKt.to("backpressure", mapBuild), TuplesKt.to("executor.context", this.executorContext)));
    }

    private final void notifyItemDropped(E item) {
        final String string;
        this.onItemDropped.invoke(item);
        NamedExecutionUnit namedExecutionUnit = item instanceof NamedExecutionUnit ? (NamedExecutionUnit) item : null;
        if (namedExecutionUnit == null || (string = namedExecutionUnit.getName()) == null) {
            string = item.toString();
        }
        this.logger.log(InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, new Function0<String>() { // from class: com.datadog.android.core.internal.thread.BackPressuredBlockingQueue.notifyItemDropped.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Dropped item in BackPressuredBlockingQueue queue: " + string;
            }
        }, (Throwable) null, false, MapsKt.mapOf(TuplesKt.to("backpressure.capacity", Integer.valueOf(this.capacity)), TuplesKt.to("executor.context", this.executorContext)));
    }
}
