package com.datadog.android.rum.internal.metric.slowframes;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.configuration.SlowFramesConfiguration;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UISlownessMetricDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ4\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/rum/internal/metric/slowframes/DefaultUISlownessMetricDispatcher;", "Lcom/datadog/android/rum/internal/metric/slowframes/UISlownessMetricDispatcher;", "config", "Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "samplingRate", "", "(Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;Lcom/datadog/android/api/InternalLogger;F)V", "viewTelemetry", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/datadog/android/rum/internal/metric/slowframes/DefaultUISlownessMetricDispatcher$SlowFramesTelemetry;", "buildMetricAttributesMap", "", "", "slowFramesCount", "", "ignoredFramesCount", "missedFramesCount", "viewDurationNs", "", "incrementIgnoredFrameCount", "", RumEventMeta.VIEW_ID_KEY, "incrementMissedFrameCount", "incrementSlowFrameCount", "onViewCreated", "sendMetric", "Companion", "SlowFramesTelemetry", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultUISlownessMetricDispatcher implements UISlownessMetricDispatcher {
    private static final float DEFAULT_SAMPLING_RATE = 0.75f;
    public static final String KEY_CONFIG = "config";
    public static final String KEY_COUNT = "count";
    public static final String KEY_IGNORED_COUNT = "ignored_count";
    public static final String KEY_MAX_COUNT = "max_count";
    public static final String KEY_MAX_DURATION = "max_duration";
    public static final String KEY_METRIC_TYPE = "metric_type";
    public static final String KEY_MISSED_COUNT = "missed_count";
    public static final String KEY_RUM_UI_SLOWNESS = "rum_ui_slowness";
    public static final String KEY_SLOW_FRAMES = "slow_frames";
    public static final String KEY_SLOW_FRAME_THRESHOLD = "slow_frame_threshold";
    public static final String KEY_VIEW_DURATION = "view_duration";
    public static final String KEY_VIEW_MIN_DURATION = "view_min_duration";
    public static final String UI_SLOWNESS_MESSAGE = "[Mobile Metric] RUM UI Slowness";
    public static final String VALUE_METRIC_TYPE = "rum ui slowness";
    private final SlowFramesConfiguration config;
    private final InternalLogger internalLogger;
    private final float samplingRate;
    private final ConcurrentHashMap<String, SlowFramesTelemetry> viewTelemetry;

    public DefaultUISlownessMetricDispatcher(SlowFramesConfiguration config, InternalLogger internalLogger, float f) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.config = config;
        this.internalLogger = internalLogger;
        this.samplingRate = f;
        this.viewTelemetry = new ConcurrentHashMap<>();
    }

    public /* synthetic */ DefaultUISlownessMetricDispatcher(SlowFramesConfiguration slowFramesConfiguration, InternalLogger internalLogger, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(slowFramesConfiguration, internalLogger, (i & 4) != 0 ? 0.75f : f);
    }

    /* JADX INFO: compiled from: UISlownessMetricDispatcher.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/internal/metric/slowframes/DefaultUISlownessMetricDispatcher$SlowFramesTelemetry;", "", "slowFramesCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "ignoredFramesCount", "missedFrameCount", "(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;)V", "getIgnoredFramesCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "getMissedFrameCount", "getSlowFramesCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SlowFramesTelemetry {
        private final AtomicInteger ignoredFramesCount;
        private final AtomicInteger missedFrameCount;
        private final AtomicInteger slowFramesCount;

        public SlowFramesTelemetry() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SlowFramesTelemetry copy$default(SlowFramesTelemetry slowFramesTelemetry, AtomicInteger atomicInteger, AtomicInteger atomicInteger2, AtomicInteger atomicInteger3, int i, Object obj) {
            if ((i & 1) != 0) {
                atomicInteger = slowFramesTelemetry.slowFramesCount;
            }
            if ((i & 2) != 0) {
                atomicInteger2 = slowFramesTelemetry.ignoredFramesCount;
            }
            if ((i & 4) != 0) {
                atomicInteger3 = slowFramesTelemetry.missedFrameCount;
            }
            return slowFramesTelemetry.copy(atomicInteger, atomicInteger2, atomicInteger3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AtomicInteger getSlowFramesCount() {
            return this.slowFramesCount;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AtomicInteger getIgnoredFramesCount() {
            return this.ignoredFramesCount;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final AtomicInteger getMissedFrameCount() {
            return this.missedFrameCount;
        }

        public final SlowFramesTelemetry copy(AtomicInteger slowFramesCount, AtomicInteger ignoredFramesCount, AtomicInteger missedFrameCount) {
            Intrinsics.checkNotNullParameter(slowFramesCount, "slowFramesCount");
            Intrinsics.checkNotNullParameter(ignoredFramesCount, "ignoredFramesCount");
            Intrinsics.checkNotNullParameter(missedFrameCount, "missedFrameCount");
            return new SlowFramesTelemetry(slowFramesCount, ignoredFramesCount, missedFrameCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SlowFramesTelemetry)) {
                return false;
            }
            SlowFramesTelemetry slowFramesTelemetry = (SlowFramesTelemetry) other;
            return Intrinsics.areEqual(this.slowFramesCount, slowFramesTelemetry.slowFramesCount) && Intrinsics.areEqual(this.ignoredFramesCount, slowFramesTelemetry.ignoredFramesCount) && Intrinsics.areEqual(this.missedFrameCount, slowFramesTelemetry.missedFrameCount);
        }

        public int hashCode() {
            return (((this.slowFramesCount.hashCode() * 31) + this.ignoredFramesCount.hashCode()) * 31) + this.missedFrameCount.hashCode();
        }

        public String toString() {
            return "SlowFramesTelemetry(slowFramesCount=" + this.slowFramesCount + ", ignoredFramesCount=" + this.ignoredFramesCount + ", missedFrameCount=" + this.missedFrameCount + ")";
        }

        public SlowFramesTelemetry(AtomicInteger slowFramesCount, AtomicInteger ignoredFramesCount, AtomicInteger missedFrameCount) {
            Intrinsics.checkNotNullParameter(slowFramesCount, "slowFramesCount");
            Intrinsics.checkNotNullParameter(ignoredFramesCount, "ignoredFramesCount");
            Intrinsics.checkNotNullParameter(missedFrameCount, "missedFrameCount");
            this.slowFramesCount = slowFramesCount;
            this.ignoredFramesCount = ignoredFramesCount;
            this.missedFrameCount = missedFrameCount;
        }

        public /* synthetic */ SlowFramesTelemetry(AtomicInteger atomicInteger, AtomicInteger atomicInteger2, AtomicInteger atomicInteger3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new AtomicInteger(0) : atomicInteger, (i & 2) != 0 ? new AtomicInteger(0) : atomicInteger2, (i & 4) != 0 ? new AtomicInteger(0) : atomicInteger3);
        }

        public final AtomicInteger getSlowFramesCount() {
            return this.slowFramesCount;
        }

        public final AtomicInteger getIgnoredFramesCount() {
            return this.ignoredFramesCount;
        }

        public final AtomicInteger getMissedFrameCount() {
            return this.missedFrameCount;
        }
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.UISlownessMetricDispatcher
    public void onViewCreated(String viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        this.viewTelemetry.putIfAbsent(viewId, new SlowFramesTelemetry(null, null, null, 7, null));
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.UISlownessMetricDispatcher
    public void incrementSlowFrameCount(String viewId) {
        AtomicInteger slowFramesCount;
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        SlowFramesTelemetry slowFramesTelemetry = this.viewTelemetry.get(viewId);
        if (slowFramesTelemetry == null || (slowFramesCount = slowFramesTelemetry.getSlowFramesCount()) == null) {
            return;
        }
        slowFramesCount.incrementAndGet();
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.UISlownessMetricDispatcher
    public void incrementIgnoredFrameCount(String viewId) {
        AtomicInteger ignoredFramesCount;
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        SlowFramesTelemetry slowFramesTelemetry = this.viewTelemetry.get(viewId);
        if (slowFramesTelemetry == null || (ignoredFramesCount = slowFramesTelemetry.getIgnoredFramesCount()) == null) {
            return;
        }
        ignoredFramesCount.incrementAndGet();
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.UISlownessMetricDispatcher
    public void incrementMissedFrameCount(String viewId) {
        AtomicInteger missedFrameCount;
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        SlowFramesTelemetry slowFramesTelemetry = this.viewTelemetry.get(viewId);
        if (slowFramesTelemetry == null || (missedFrameCount = slowFramesTelemetry.getMissedFrameCount()) == null) {
            return;
        }
        missedFrameCount.incrementAndGet();
    }

    @Override // com.datadog.android.rum.internal.metric.slowframes.UISlownessMetricDispatcher
    public void sendMetric(final String viewId, long viewDurationNs) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        SlowFramesTelemetry slowFramesTelemetryRemove = this.viewTelemetry.remove(viewId);
        InternalLogger internalLogger = this.internalLogger;
        if (slowFramesTelemetryRemove == null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.metric.slowframes.DefaultUISlownessMetricDispatcher.sendMetric.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "No telemetry found for viewId=" + viewId;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        float f = this.samplingRate;
        InternalLogger.DefaultImpls.logMetric$default(internalLogger, new Function0<String>() { // from class: com.datadog.android.rum.internal.metric.slowframes.DefaultUISlownessMetricDispatcher.sendMetric.2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return DefaultUISlownessMetricDispatcher.UI_SLOWNESS_MESSAGE;
            }
        }, buildMetricAttributesMap(slowFramesTelemetryRemove.getSlowFramesCount().get(), slowFramesTelemetryRemove.getIgnoredFramesCount().get(), slowFramesTelemetryRemove.getMissedFrameCount().get(), viewDurationNs), f, null, 8, null);
    }

    private final Map<String, Object> buildMetricAttributesMap(int slowFramesCount, int ignoredFramesCount, int missedFramesCount, long viewDurationNs) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put("metric_type", VALUE_METRIC_TYPE);
        Map mapCreateMapBuilder2 = MapsKt.createMapBuilder();
        mapCreateMapBuilder2.put(KEY_VIEW_DURATION, Long.valueOf(viewDurationNs));
        Map mapCreateMapBuilder3 = MapsKt.createMapBuilder();
        mapCreateMapBuilder3.put("count", Integer.valueOf(slowFramesCount));
        mapCreateMapBuilder3.put(KEY_IGNORED_COUNT, Integer.valueOf(ignoredFramesCount));
        mapCreateMapBuilder3.put(KEY_MISSED_COUNT, Integer.valueOf(missedFramesCount));
        Map mapCreateMapBuilder4 = MapsKt.createMapBuilder();
        mapCreateMapBuilder4.put(KEY_MAX_COUNT, Integer.valueOf(this.config.getMaxSlowFramesAmount$dd_sdk_android_rum_release()));
        mapCreateMapBuilder4.put(KEY_SLOW_FRAME_THRESHOLD, Float.valueOf(2.0f));
        mapCreateMapBuilder4.put(KEY_MAX_DURATION, Long.valueOf(this.config.getMaxSlowFrameThresholdNs$dd_sdk_android_rum_release()));
        mapCreateMapBuilder4.put(KEY_VIEW_MIN_DURATION, Long.valueOf(this.config.getMinViewLifetimeThresholdNs$dd_sdk_android_rum_release()));
        Unit unit = Unit.INSTANCE;
        mapCreateMapBuilder3.put("config", MapsKt.build(mapCreateMapBuilder4));
        Unit unit2 = Unit.INSTANCE;
        mapCreateMapBuilder2.put(KEY_SLOW_FRAMES, MapsKt.build(mapCreateMapBuilder3));
        Unit unit3 = Unit.INSTANCE;
        mapCreateMapBuilder.put(KEY_RUM_UI_SLOWNESS, MapsKt.build(mapCreateMapBuilder2));
        return MapsKt.build(mapCreateMapBuilder);
    }
}
