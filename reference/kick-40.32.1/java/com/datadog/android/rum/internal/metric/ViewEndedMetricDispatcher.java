package com.datadog.android.rum.internal.metric;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.internal.attributes.ViewScopeInstrumentationType;
import com.datadog.android.rum.internal.domain.scope.RumViewType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewEndedMetricDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J&\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\fH\u0016J\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/datadog/android/rum/internal/metric/ViewEndedMetricDispatcher;", "Lcom/datadog/android/rum/internal/metric/ViewMetricDispatcher;", "viewType", "Lcom/datadog/android/rum/internal/domain/scope/RumViewType;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "instrumentationType", "Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType;", "samplingRate", "", "(Lcom/datadog/android/rum/internal/domain/scope/RumViewType;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType;F)V", "duration", "", "Ljava/lang/Long;", "loadingTime", "metricSent", "", "buildAttributesMap", "", "", "", "invState", "Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsState;", "tnsState", "buildMetricAttributesMap", "onDurationResolved", "", "newDuration", "onViewLoadingTimeResolved", "newLoadingTime", "sendViewEnded", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewEndedMetricDispatcher implements ViewMetricDispatcher {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float DEFAULT_SAMPLE_RATE = 0.75f;
    public static final String KEY_CONFIG = "config";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_INSTRUMENTATION_TYPE = "instrumentation_type";
    public static final String KEY_INTERACTION_TO_NEXT_VIEW = "inv";
    public static final String KEY_LOADING_TIME = "loading_time";
    public static final String KEY_METRIC_TYPE = "metric_type";
    public static final String KEY_NO_VALUE_REASON = "no_value_reason";
    public static final String KEY_RUM_VIEW_ENDED = "rve";
    public static final String KEY_TIME_TO_NETWORK_SETTLED = "tns";
    public static final String KEY_VALUE = "value";
    public static final String KEY_VIEW_TYPE = "view_type";
    private static final String VALUE_APPLICATION_LAUNCH = "application_launch";
    private static final String VALUE_BACKGROUND = "background";
    private static final String VALUE_CUSTOM = "custom";
    private static final String VALUE_DISABLED = "disabled";
    private static final String VALUE_METRIC_TYPE = "rum view ended";
    private static final String VALUE_NOT_SETTLED_YET = "not_settled_yet";
    private static final String VALUE_NO_ACTION = "no_action";
    private static final String VALUE_NO_ELIGIBLE_ACTION = "no_eligible_action";
    private static final String VALUE_NO_INITIAL_RESOURCES = "no_initial_resources";
    private static final String VALUE_NO_PREVIOUS_VIEW = "no_previous_view";
    private static final String VALUE_NO_RESOURCES = "no_resources";
    private static final String VALUE_TIME_BASED_CUSTOM = "time_based_custom";
    private static final String VALUE_TIME_BASED_DEFAULT = "time_based_default";
    private static final String VALUE_UNKNOWN = "unknown";
    public static final String VIEW_ENDED_MESSAGE = "[Mobile Metric] RUM View Ended";
    private Long duration;
    private final ViewScopeInstrumentationType instrumentationType;
    private final InternalLogger internalLogger;
    private Long loadingTime;
    private boolean metricSent;
    private final float samplingRate;
    private final RumViewType viewType;

    public ViewEndedMetricDispatcher(RumViewType viewType, InternalLogger internalLogger, ViewScopeInstrumentationType.Native r4, float f) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.viewType = viewType;
        this.internalLogger = internalLogger;
        this.samplingRate = f;
        this.instrumentationType = r4 == null ? ViewScopeInstrumentationType.Native.MANUAL : r4;
    }

    public /* synthetic */ ViewEndedMetricDispatcher(RumViewType rumViewType, InternalLogger internalLogger, ViewScopeInstrumentationType viewScopeInstrumentationType, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rumViewType, internalLogger, (i & 4) != 0 ? null : viewScopeInstrumentationType, (i & 8) != 0 ? 0.75f : f);
    }

    @Override // com.datadog.android.rum.internal.metric.ViewMetricDispatcher
    public void sendViewEnded(ViewInitializationMetricsState invState, ViewInitializationMetricsState tnsState) {
        Intrinsics.checkNotNullParameter(invState, "invState");
        Intrinsics.checkNotNullParameter(tnsState, "tnsState");
        boolean z = this.metricSent;
        InternalLogger internalLogger = this.internalLogger;
        if (z) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.metric.ViewEndedMetricDispatcher.sendViewEnded.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Trying to send 'view ended' more than once";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            InternalLogger.DefaultImpls.logMetric$default(internalLogger, new Function0<String>() { // from class: com.datadog.android.rum.internal.metric.ViewEndedMetricDispatcher.sendViewEnded.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return ViewEndedMetricDispatcher.VIEW_ENDED_MESSAGE;
                }
            }, buildMetricAttributesMap(invState, tnsState), this.samplingRate, null, 8, null);
            this.metricSent = true;
        }
    }

    @Override // com.datadog.android.rum.internal.metric.ViewMetricDispatcher
    public void onDurationResolved(long newDuration) {
        this.duration = Long.valueOf(newDuration);
    }

    @Override // com.datadog.android.rum.internal.metric.ViewMetricDispatcher
    public void onViewLoadingTimeResolved(long newLoadingTime) {
        this.loadingTime = Long.valueOf(newLoadingTime);
    }

    private final Map<String, Object> buildMetricAttributesMap(ViewInitializationMetricsState invState, ViewInitializationMetricsState tnsState) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put("metric_type", VALUE_METRIC_TYPE);
        mapCreateMapBuilder.put(KEY_RUM_VIEW_ENDED, buildAttributesMap(invState, tnsState));
        return MapsKt.build(mapCreateMapBuilder);
    }

    private final Map<String, Object> buildAttributesMap(ViewInitializationMetricsState invState, ViewInitializationMetricsState tnsState) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Companion companion = INSTANCE;
        companion.putNonNull(mapCreateMapBuilder, "duration", this.duration);
        Long l = this.loadingTime;
        if (l != null) {
            Map mapCreateMapBuilder2 = MapsKt.createMapBuilder();
            mapCreateMapBuilder2.put("value", l);
            Unit unit = Unit.INSTANCE;
            mapCreateMapBuilder.put(KEY_LOADING_TIME, MapsKt.build(mapCreateMapBuilder2));
        }
        mapCreateMapBuilder.put("view_type", companion.toAttributeValue$dd_sdk_android_rum_release(this.viewType));
        Map mapCreateMapBuilder3 = MapsKt.createMapBuilder();
        mapCreateMapBuilder3.put("value", tnsState.getInitializationTime());
        mapCreateMapBuilder3.put("config", companion.toAttributeValue$dd_sdk_android_rum_release(tnsState.getConfig()));
        if (tnsState.getInitializationTime() == null) {
            companion.putNonNull(mapCreateMapBuilder3, KEY_NO_VALUE_REASON, companion.toAttributeValue$dd_sdk_android_rum_release(tnsState.getNoValueReason()));
        }
        Unit unit2 = Unit.INSTANCE;
        mapCreateMapBuilder.put(KEY_TIME_TO_NETWORK_SETTLED, MapsKt.build(mapCreateMapBuilder3));
        Map mapCreateMapBuilder4 = MapsKt.createMapBuilder();
        mapCreateMapBuilder4.put("value", invState.getInitializationTime());
        mapCreateMapBuilder4.put("config", companion.toAttributeValue$dd_sdk_android_rum_release(invState.getConfig()));
        if (invState.getInitializationTime() == null) {
            companion.putNonNull(mapCreateMapBuilder4, KEY_NO_VALUE_REASON, companion.toAttributeValue$dd_sdk_android_rum_release(invState.getNoValueReason()));
        }
        Unit unit3 = Unit.INSTANCE;
        mapCreateMapBuilder.put(KEY_INTERACTION_TO_NEXT_VIEW, MapsKt.build(mapCreateMapBuilder4));
        mapCreateMapBuilder.put(KEY_INSTRUMENTATION_TYPE, this.instrumentationType.getValue());
        return MapsKt.build(mapCreateMapBuilder);
    }

    /* JADX INFO: compiled from: ViewEndedMetricDispatcher.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#J\u0017\u0010 \u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010%H\u0001¢\u0006\u0002\b#J\u0015\u0010 \u001a\u00020\u00062\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b#J;\u0010(\u001a\u00020)\"\u0004\b\u0000\u0010*\"\u0004\b\u0001\u0010+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H+0,2\u0006\u0010-\u001a\u0002H*2\b\u0010.\u001a\u0004\u0018\u0001H+H\u0002¢\u0006\u0002\u0010/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/datadog/android/rum/internal/metric/ViewEndedMetricDispatcher$Companion;", "", "()V", "DEFAULT_SAMPLE_RATE", "", "KEY_CONFIG", "", "KEY_DURATION", "KEY_INSTRUMENTATION_TYPE", "KEY_INTERACTION_TO_NEXT_VIEW", "KEY_LOADING_TIME", "KEY_METRIC_TYPE", "KEY_NO_VALUE_REASON", "KEY_RUM_VIEW_ENDED", "KEY_TIME_TO_NETWORK_SETTLED", "KEY_VALUE", "KEY_VIEW_TYPE", "VALUE_APPLICATION_LAUNCH", "VALUE_BACKGROUND", "VALUE_CUSTOM", "VALUE_DISABLED", "VALUE_METRIC_TYPE", "VALUE_NOT_SETTLED_YET", "VALUE_NO_ACTION", "VALUE_NO_ELIGIBLE_ACTION", "VALUE_NO_INITIAL_RESOURCES", "VALUE_NO_PREVIOUS_VIEW", "VALUE_NO_RESOURCES", "VALUE_TIME_BASED_CUSTOM", "VALUE_TIME_BASED_DEFAULT", "VALUE_UNKNOWN", "VIEW_ENDED_MESSAGE", "toAttributeValue", "viewType", "Lcom/datadog/android/rum/internal/domain/scope/RumViewType;", "toAttributeValue$dd_sdk_android_rum_release", "reason", "Lcom/datadog/android/rum/internal/metric/NoValueReason;", "config", "Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsConfig;", "putNonNull", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "key", "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: ViewEndedMetricDispatcher.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;
            public static final /* synthetic */ int[] $EnumSwitchMapping$2;
            public static final /* synthetic */ int[] $EnumSwitchMapping$3;

            static {
                int[] iArr = new int[RumViewType.values().length];
                try {
                    iArr[RumViewType.NONE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RumViewType.FOREGROUND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RumViewType.BACKGROUND.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RumViewType.APPLICATION_LAUNCH.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[ViewInitializationMetricsConfig.values().length];
                try {
                    iArr2[ViewInitializationMetricsConfig.DISABLED.ordinal()] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[ViewInitializationMetricsConfig.CUSTOM.ordinal()] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr2[ViewInitializationMetricsConfig.TIME_BASED_DEFAULT.ordinal()] = 3;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr2[ViewInitializationMetricsConfig.TIME_BASED_CUSTOM.ordinal()] = 4;
                } catch (NoSuchFieldError unused8) {
                }
                $EnumSwitchMapping$1 = iArr2;
                int[] iArr3 = new int[NoValueReason.InteractionToNextView.values().length];
                try {
                    iArr3[NoValueReason.InteractionToNextView.UNKNOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr3[NoValueReason.InteractionToNextView.NO_PREVIOUS_VIEW.ordinal()] = 2;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr3[NoValueReason.InteractionToNextView.NO_ACTION.ordinal()] = 3;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr3[NoValueReason.InteractionToNextView.NO_ELIGIBLE_ACTION.ordinal()] = 4;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr3[NoValueReason.InteractionToNextView.DISABLED.ordinal()] = 5;
                } catch (NoSuchFieldError unused13) {
                }
                $EnumSwitchMapping$2 = iArr3;
                int[] iArr4 = new int[NoValueReason.TimeToNetworkSettle.values().length];
                try {
                    iArr4[NoValueReason.TimeToNetworkSettle.UNKNOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr4[NoValueReason.TimeToNetworkSettle.NOT_SETTLED_YET.ordinal()] = 2;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr4[NoValueReason.TimeToNetworkSettle.NO_RESOURCES.ordinal()] = 3;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr4[NoValueReason.TimeToNetworkSettle.NO_INITIAL_RESOURCES.ordinal()] = 4;
                } catch (NoSuchFieldError unused17) {
                }
                $EnumSwitchMapping$3 = iArr4;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <K, V> void putNonNull(Map<K, V> map, K k, V v) {
            if (v != null) {
                map.put(k, v);
            }
        }

        public final String toAttributeValue$dd_sdk_android_rum_release(RumViewType viewType) {
            Intrinsics.checkNotNullParameter(viewType, "viewType");
            int i = WhenMappings.$EnumSwitchMapping$0[viewType.ordinal()];
            if (i == 1 || i == 2) {
                return ViewEndedMetricDispatcher.VALUE_CUSTOM;
            }
            if (i == 3) {
                return "background";
            }
            if (i == 4) {
                return ViewEndedMetricDispatcher.VALUE_APPLICATION_LAUNCH;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String toAttributeValue$dd_sdk_android_rum_release(ViewInitializationMetricsConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            int i = WhenMappings.$EnumSwitchMapping$1[config.ordinal()];
            if (i == 1) {
                return ViewEndedMetricDispatcher.VALUE_DISABLED;
            }
            if (i == 2) {
                return ViewEndedMetricDispatcher.VALUE_CUSTOM;
            }
            if (i == 3) {
                return ViewEndedMetricDispatcher.VALUE_TIME_BASED_DEFAULT;
            }
            if (i == 4) {
                return ViewEndedMetricDispatcher.VALUE_TIME_BASED_CUSTOM;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String toAttributeValue$dd_sdk_android_rum_release(NoValueReason reason) {
            if (reason == null) {
                return "unknown";
            }
            if (reason instanceof NoValueReason.InteractionToNextView) {
                int i = WhenMappings.$EnumSwitchMapping$2[((NoValueReason.InteractionToNextView) reason).ordinal()];
                if (i == 1) {
                    return "unknown";
                }
                if (i == 2) {
                    return ViewEndedMetricDispatcher.VALUE_NO_PREVIOUS_VIEW;
                }
                if (i == 3) {
                    return ViewEndedMetricDispatcher.VALUE_NO_ACTION;
                }
                if (i == 4) {
                    return ViewEndedMetricDispatcher.VALUE_NO_ELIGIBLE_ACTION;
                }
                if (i == 5) {
                    return ViewEndedMetricDispatcher.VALUE_DISABLED;
                }
                throw new NoWhenBranchMatchedException();
            }
            if (!(reason instanceof NoValueReason.TimeToNetworkSettle)) {
                throw new NoWhenBranchMatchedException();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$3[((NoValueReason.TimeToNetworkSettle) reason).ordinal()];
            if (i2 == 1) {
                return "unknown";
            }
            if (i2 == 2) {
                return ViewEndedMetricDispatcher.VALUE_NOT_SETTLED_YET;
            }
            if (i2 == 3) {
                return ViewEndedMetricDispatcher.VALUE_NO_RESOURCES;
            }
            if (i2 == 4) {
                return ViewEndedMetricDispatcher.VALUE_NO_INITIAL_RESOURCES;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
