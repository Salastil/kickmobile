package com.datadog.android.rum.internal.metric.networksettled;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.metric.NoValueReason;
import com.datadog.android.rum.internal.metric.ViewInitializationMetricsConfig;
import com.datadog.android.rum.internal.metric.ViewInitializationMetricsState;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import com.datadog.android.rum.metric.networksettled.NetworkSettledResourceContext;
import com.datadog.android.rum.metric.networksettled.TimeBasedInitialResourceIdentifier;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkSettledMetricResolver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\r\u0010\u001a\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0015J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u001cR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/datadog/android/rum/internal/metric/networksettled/NetworkSettledMetricResolver;", "", "initialResourceIdentifier", "Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;Lcom/datadog/android/api/InternalLogger;)V", "currentViewDiagnostic", "Lcom/datadog/android/rum/internal/metric/networksettled/NetworkSettledMetricResolver$Companion$Diagnostic;", "lastComputedMetric", "", "Ljava/lang/Long;", "networkSettleMaxValue", "resourceStartedTimestamps", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCreatedTimestamp", "viewWasStopped", "", "computeMetric", "()Ljava/lang/Long;", "getResourceStartedCacheSize", "", "getState", "Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsState;", "resolveMetric", "resourceWasDropped", "", "resourceId", "resourceWasStarted", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/rum/internal/metric/networksettled/InternalResourceContext;", "resourceWasStopped", "viewWasCreated", "eventTimestampInNanos", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NetworkSettledMetricResolver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private volatile Companion.Diagnostic currentViewDiagnostic;
    private final InitialResourceIdentifier initialResourceIdentifier;
    private final InternalLogger internalLogger;
    private volatile Long lastComputedMetric;
    private volatile Long networkSettleMaxValue;
    private final HashSet<String> resourceStartedTimestamps;
    private volatile Long viewCreatedTimestamp;
    private volatile boolean viewWasStopped;

    public NetworkSettledMetricResolver(InitialResourceIdentifier initialResourceIdentifier, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(initialResourceIdentifier, "initialResourceIdentifier");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.initialResourceIdentifier = initialResourceIdentifier;
        this.internalLogger = internalLogger;
        this.resourceStartedTimestamps = new HashSet<>();
        this.currentViewDiagnostic = new Companion.Diagnostic(null, null, null, null, 15, null);
    }

    public /* synthetic */ NetworkSettledMetricResolver(TimeBasedInitialResourceIdentifier timeBasedInitialResourceIdentifier, InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new TimeBasedInitialResourceIdentifier(0L, 1, null) : timeBasedInitialResourceIdentifier, internalLogger);
    }

    public final void viewWasCreated(long eventTimestampInNanos) {
        this.viewCreatedTimestamp = Long.valueOf(eventTimestampInNanos);
        this.currentViewDiagnostic = new Companion.Diagnostic(null, null, null, null, 15, null);
    }

    public final void resourceWasStarted(InternalResourceContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.viewWasStopped) {
            return;
        }
        this.currentViewDiagnostic.getStarted().incrementAndGet();
        if (this.initialResourceIdentifier.validate(new NetworkSettledResourceContext(context.getResourceId$dd_sdk_android_rum_release(), context.getEventCreatedAtNanos$dd_sdk_android_rum_release(), this.viewCreatedTimestamp))) {
            this.currentViewDiagnostic.getInitial().incrementAndGet();
            this.resourceStartedTimestamps.add(context.getResourceId$dd_sdk_android_rum_release());
        }
    }

    public final void resourceWasStopped(InternalResourceContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.viewWasStopped) {
            return;
        }
        Long l = this.viewCreatedTimestamp;
        Long l2 = this.networkSettleMaxValue;
        long jLongValue = l2 != null ? l2.longValue() : 0L;
        boolean zRemove = this.resourceStartedTimestamps.remove(context.getResourceId$dd_sdk_android_rum_release());
        if (l == null || !zRemove) {
            return;
        }
        this.currentViewDiagnostic.getStopped().incrementAndGet();
        long eventCreatedAtNanos$dd_sdk_android_rum_release = context.getEventCreatedAtNanos$dd_sdk_android_rum_release() - l.longValue();
        if (eventCreatedAtNanos$dd_sdk_android_rum_release > jLongValue) {
            this.networkSettleMaxValue = Long.valueOf(eventCreatedAtNanos$dd_sdk_android_rum_release);
        }
    }

    public final void resourceWasDropped(String resourceId) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        if (this.viewWasStopped) {
            return;
        }
        this.currentViewDiagnostic.getDropped().incrementAndGet();
        this.resourceStartedTimestamps.remove(resourceId);
    }

    public final void viewWasStopped() {
        this.viewWasStopped = true;
        this.resourceStartedTimestamps.clear();
    }

    public final Long resolveMetric() {
        if (this.viewWasStopped) {
            return this.lastComputedMetric;
        }
        this.lastComputedMetric = computeMetric();
        return this.lastComputedMetric;
    }

    public final ViewInitializationMetricsState getState() {
        Long lResolveMetric = resolveMetric();
        return new ViewInitializationMetricsState(lResolveMetric, INSTANCE.toConfig(this.initialResourceIdentifier), lResolveMetric == null ? this.currentViewDiagnostic.resolveNoValueReason() : null);
    }

    public final int getResourceStartedCacheSize() {
        return this.resourceStartedTimestamps.size();
    }

    private final Long computeMetric() {
        if (this.viewCreatedTimestamp == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.metric.networksettled.NetworkSettledMetricResolver.computeMetric.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "[ViewNetworkSettledMetric] There was no view created yet for this resource";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
        if (this.resourceStartedTimestamps.size() > 0) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.metric.networksettled.NetworkSettledMetricResolver.computeMetric.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "[ViewNetworkSettledMetric] Not all the initial resources were stopped for this view";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
        return this.networkSettleMaxValue;
    }

    /* JADX INFO: compiled from: NetworkSettledMetricResolver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/metric/networksettled/NetworkSettledMetricResolver$Companion;", "", "()V", "toConfig", "Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsConfig;", "Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "Diagnostic", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ViewInitializationMetricsConfig toConfig(InitialResourceIdentifier initialResourceIdentifier) {
            if (!(initialResourceIdentifier instanceof TimeBasedInitialResourceIdentifier)) {
                return ViewInitializationMetricsConfig.CUSTOM;
            }
            if (((TimeBasedInitialResourceIdentifier) initialResourceIdentifier).defaultThresholdUsed$dd_sdk_android_rum_release()) {
                return ViewInitializationMetricsConfig.TIME_BASED_DEFAULT;
            }
            return ViewInitializationMetricsConfig.TIME_BASED_CUSTOM;
        }

        /* JADX INFO: compiled from: NetworkSettledMetricResolver.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/internal/metric/networksettled/NetworkSettledMetricResolver$Companion$Diagnostic;", "", "started", "Ljava/util/concurrent/atomic/AtomicInteger;", "initial", "stopped", "dropped", "(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;)V", "getDropped", "()Ljava/util/concurrent/atomic/AtomicInteger;", "getInitial", "getStarted", "getStopped", "resolveNoValueReason", "Lcom/datadog/android/rum/internal/metric/NoValueReason$TimeToNetworkSettle;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private static final class Diagnostic {
            private final AtomicInteger dropped;
            private final AtomicInteger initial;
            private final AtomicInteger started;
            private final AtomicInteger stopped;

            public Diagnostic() {
                this(null, null, null, null, 15, null);
            }

            public Diagnostic(AtomicInteger started, AtomicInteger initial, AtomicInteger stopped, AtomicInteger dropped) {
                Intrinsics.checkNotNullParameter(started, "started");
                Intrinsics.checkNotNullParameter(initial, "initial");
                Intrinsics.checkNotNullParameter(stopped, "stopped");
                Intrinsics.checkNotNullParameter(dropped, "dropped");
                this.started = started;
                this.initial = initial;
                this.stopped = stopped;
                this.dropped = dropped;
            }

            public /* synthetic */ Diagnostic(AtomicInteger atomicInteger, AtomicInteger atomicInteger2, AtomicInteger atomicInteger3, AtomicInteger atomicInteger4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? new AtomicInteger(0) : atomicInteger, (i & 2) != 0 ? new AtomicInteger(0) : atomicInteger2, (i & 4) != 0 ? new AtomicInteger(0) : atomicInteger3, (i & 8) != 0 ? new AtomicInteger(0) : atomicInteger4);
            }

            public final AtomicInteger getStarted() {
                return this.started;
            }

            public final AtomicInteger getInitial() {
                return this.initial;
            }

            public final AtomicInteger getStopped() {
                return this.stopped;
            }

            public final AtomicInteger getDropped() {
                return this.dropped;
            }

            public final NoValueReason.TimeToNetworkSettle resolveNoValueReason() {
                int i = this.started.get();
                int i2 = this.initial.get();
                int i3 = this.dropped.get();
                int i4 = this.stopped.get();
                if (i == 0) {
                    return NoValueReason.TimeToNetworkSettle.NO_RESOURCES;
                }
                if (i2 == 0) {
                    return NoValueReason.TimeToNetworkSettle.NO_INITIAL_RESOURCES;
                }
                if (i2 > i3 + i4) {
                    return NoValueReason.TimeToNetworkSettle.NOT_SETTLED_YET;
                }
                return NoValueReason.TimeToNetworkSettle.UNKNOWN;
            }
        }
    }
}
