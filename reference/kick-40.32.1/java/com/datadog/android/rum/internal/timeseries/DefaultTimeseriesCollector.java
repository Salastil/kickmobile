package com.datadog.android.rum.internal.timeseries;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.scope.RumViewType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultTimeseriesCollector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0003J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\nH\u0017J\b\u0010\u0017\u001a\u00020\u0014H\u0017J\b\u0010\u0018\u001a\u00020\u0014H\u0017J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\nH\u0002J \u0010\u001f\u001a\u00020\u0014*\u00020\b2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/DefaultTimeseriesCollector;", "Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "pipelines", "", "Lcom/datadog/android/rum/internal/timeseries/Pipeline;", "scheduledExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "(Lcom/datadog/android/api/InternalLogger;Ljava/util/List;Ljava/util/concurrent/ScheduledExecutorService;Lcom/datadog/android/rum/internal/domain/RumContext;)V", "lastForegroundRumContext", "getPipelines$dd_sdk_android_rum_release", "()Ljava/util/List;", "getScheduledExecutorService$dd_sdk_android_rum_release", "()Ljava/util/concurrent/ScheduledExecutorService;", "state", "Lcom/datadog/android/rum/internal/timeseries/DefaultTimeseriesCollector$Companion$State;", "flushPipelines", "", "onRumContextUpdate", "newRumContext", "onSessionStart", "onSessionStop", "scheduleSampling", "generation", "", "scheduleStop", "stopRequestGeneration", "rumContextSnapshot", "schedulePipeline", "pipeline", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultTimeseriesCollector implements TimeseriesCollector {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ERROR_FLUSH_FAILED = "Timeseries flush failed.";
    public static final String ERROR_SAMPLING_FAILED = "Timeseries sampling iteration failed; rescheduling next sample.";
    public static final long SUSPEND_DELAY_MS = 200;
    public static final String SUSPEND_OPERATION_NAME = "Timeseries suspend";
    public static final String TIMESERIES_OPERATION_NAME = "Timeseries sampling";
    private final InternalLogger internalLogger;
    private volatile RumContext lastForegroundRumContext;
    private final List<Pipeline<?>> pipelines;
    private volatile RumContext rumContext;
    private final ScheduledExecutorService scheduledExecutorService;
    private final Companion.State state;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultTimeseriesCollector(InternalLogger internalLogger, List<? extends Pipeline<?>> pipelines, ScheduledExecutorService scheduledExecutorService, RumContext rumContext) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(pipelines, "pipelines");
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "scheduledExecutorService");
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        this.internalLogger = internalLogger;
        this.pipelines = pipelines;
        this.scheduledExecutorService = scheduledExecutorService;
        this.rumContext = rumContext;
        this.state = new Companion.State();
        this.lastForegroundRumContext = this.rumContext;
    }

    public final List<Pipeline<?>> getPipelines$dd_sdk_android_rum_release() {
        return this.pipelines;
    }

    /* JADX INFO: renamed from: getScheduledExecutorService$dd_sdk_android_rum_release, reason: from getter */
    public final ScheduledExecutorService getScheduledExecutorService() {
        return this.scheduledExecutorService;
    }

    @Override // com.datadog.android.rum.internal.timeseries.TimeseriesCollector
    public void onSessionStart() {
        Integer active = this.state.setActive(INSTANCE.isForeground(this.rumContext.getViewType()));
        if (active != null) {
            scheduleSampling(active.intValue());
        }
    }

    @Override // com.datadog.android.rum.internal.timeseries.TimeseriesCollector
    public void onSessionStop() {
        if (this.state.setActive(false) != null) {
            flushPipelines(this.lastForegroundRumContext);
        }
    }

    @Override // com.datadog.android.rum.internal.timeseries.TimeseriesCollector
    public void onRumContextUpdate(RumContext newRumContext) {
        Intrinsics.checkNotNullParameter(newRumContext, "newRumContext");
        RumViewType viewType = this.rumContext.getViewType();
        RumViewType viewType2 = newRumContext.getViewType();
        Companion companion = INSTANCE;
        boolean z = !companion.isForeground(viewType) && companion.isForeground(viewType2);
        boolean z2 = companion.isForeground(viewType) && !companion.isForeground(viewType2);
        this.rumContext = newRumContext;
        if (companion.isForeground(viewType2)) {
            this.lastForegroundRumContext = newRumContext;
        }
        if (z2) {
            scheduleStop(this.state.getCurrentGeneration(), this.lastForegroundRumContext);
        } else if (z) {
            scheduleSampling(this.state.startGeneration());
        }
    }

    private final void scheduleSampling(int generation) {
        Iterator<T> it = this.pipelines.iterator();
        while (it.hasNext()) {
            schedulePipeline(this.scheduledExecutorService, (Pipeline) it.next(), generation);
        }
    }

    private final void schedulePipeline(final ScheduledExecutorService scheduledExecutorService, final Pipeline<?> pipeline, final int i) {
        ConcurrencyExtKt.scheduleSafe(scheduledExecutorService, TIMESERIES_OPERATION_NAME, pipeline.getIntervalMs(), TimeUnit.MILLISECONDS, this.internalLogger, new Runnable() { // from class: com.datadog.android.rum.internal.timeseries.DefaultTimeseriesCollector$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DefaultTimeseriesCollector.schedulePipeline$lambda$2(this.f$0, i, pipeline, scheduledExecutorService);
            }
        });
    }

    static final void schedulePipeline$lambda$2(DefaultTimeseriesCollector defaultTimeseriesCollector, int i, Pipeline pipeline, ScheduledExecutorService scheduledExecutorService) {
        if (defaultTimeseriesCollector.state.isGenerationActive(i)) {
            try {
                RumContext rumContext = defaultTimeseriesCollector.rumContext;
                if (INSTANCE.isForeground(rumContext.getViewType())) {
                    pipeline.execute(rumContext);
                }
                if (defaultTimeseriesCollector.state.isGenerationActive(i)) {
                    defaultTimeseriesCollector.schedulePipeline(scheduledExecutorService, pipeline, i);
                }
            } catch (Throwable th) {
                try {
                    InternalLogger.DefaultImpls.log$default(defaultTimeseriesCollector.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.timeseries.DefaultTimeseriesCollector$schedulePipeline$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return DefaultTimeseriesCollector.ERROR_SAMPLING_FAILED;
                        }
                    }, th, false, (Map) null, 48, (Object) null);
                } finally {
                    if (defaultTimeseriesCollector.state.isGenerationActive(i)) {
                        defaultTimeseriesCollector.schedulePipeline(scheduledExecutorService, pipeline, i);
                    }
                }
            }
        }
    }

    private final void flushPipelines(RumContext rumContext) {
        Iterator<T> it = this.pipelines.iterator();
        while (it.hasNext()) {
            try {
                ((Pipeline) it.next()).flush(rumContext);
            } catch (Throwable th) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.timeseries.DefaultTimeseriesCollector$flushPipelines$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return DefaultTimeseriesCollector.ERROR_FLUSH_FAILED;
                    }
                }, th, false, (Map) null, 48, (Object) null);
            }
        }
    }

    private final void scheduleStop(final int stopRequestGeneration, final RumContext rumContextSnapshot) {
        ConcurrencyExtKt.scheduleSafe(this.scheduledExecutorService, SUSPEND_OPERATION_NAME, 200L, TimeUnit.MILLISECONDS, this.internalLogger, new Runnable() { // from class: com.datadog.android.rum.internal.timeseries.DefaultTimeseriesCollector$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DefaultTimeseriesCollector.scheduleStop$lambda$4(this.f$0, stopRequestGeneration, rumContextSnapshot);
            }
        });
    }

    static final void scheduleStop$lambda$4(DefaultTimeseriesCollector defaultTimeseriesCollector, int i, RumContext rumContext) {
        if (INSTANCE.isForeground(defaultTimeseriesCollector.rumContext.getViewType()) || !defaultTimeseriesCollector.state.stopGeneration(i)) {
            return;
        }
        defaultTimeseriesCollector.flushPipelines(rumContext);
    }

    /* JADX INFO: compiled from: DefaultTimeseriesCollector.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\u00020\u000b*\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\n\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/DefaultTimeseriesCollector$Companion;", "", "()V", "ERROR_FLUSH_FAILED", "", "ERROR_SAMPLING_FAILED", "SUSPEND_DELAY_MS", "", "SUSPEND_OPERATION_NAME", "TIMESERIES_OPERATION_NAME", "isForeground", "", "Lcom/datadog/android/rum/internal/domain/scope/RumViewType;", "(Lcom/datadog/android/rum/internal/domain/scope/RumViewType;)Z", "State", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: DefaultTimeseriesCollector.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RumViewType.values().length];
                try {
                    iArr[RumViewType.FOREGROUND.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RumViewType.APPLICATION_LAUNCH.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RumViewType.BACKGROUND.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RumViewType.NONE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isForeground(RumViewType rumViewType) {
            int i = rumViewType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[rumViewType.ordinal()];
            if (i == -1) {
                return false;
            }
            if (i == 1 || i == 2) {
                return true;
            }
            if (i == 3 || i == 4) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: compiled from: DefaultTimeseriesCollector.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u0015\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/DefaultTimeseriesCollector$Companion$State;", "", "()V", "active", "", "<set-?>", "", "currentGeneration", "getCurrentGeneration", "()I", "isGenerationActive", "generation", "setActive", "isActive", "(Z)Ljava/lang/Integer;", "startGeneration", "stopGeneration", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class State {
            private boolean active;
            private volatile int currentGeneration;

            public final int getCurrentGeneration() {
                return this.currentGeneration;
            }

            public final boolean isGenerationActive(int generation) {
                boolean z;
                synchronized (this) {
                    z = this.currentGeneration == generation && this.active;
                }
                return z;
            }

            public final int startGeneration() {
                int i;
                synchronized (this) {
                    this.active = true;
                    this.currentGeneration++;
                    i = this.currentGeneration;
                }
                return i;
            }

            public final boolean stopGeneration(int generation) {
                boolean z;
                synchronized (this) {
                    z = false;
                    if (this.currentGeneration == generation && setActive(false) != null) {
                        z = true;
                    }
                }
                return z;
            }

            public final Integer setActive(boolean isActive) {
                Integer numValueOf;
                synchronized (this) {
                    if (isActive == this.active) {
                        numValueOf = null;
                    } else {
                        this.active = isActive;
                        this.currentGeneration++;
                        numValueOf = Integer.valueOf(this.currentGeneration);
                    }
                }
                return numValueOf;
            }
        }
    }
}
