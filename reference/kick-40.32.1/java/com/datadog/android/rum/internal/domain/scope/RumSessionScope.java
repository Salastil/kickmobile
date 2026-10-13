package com.datadog.android.rum.internal.domain.scope;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry;
import com.datadog.android.rum.RumSessionListener;
import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.accessibility.AccessibilitySnapshotManager;
import com.datadog.android.rum.internal.domain.battery.BatteryInfo;
import com.datadog.android.rum.internal.domain.display.DisplayInfo;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.metric.SessionMetricDispatcher;
import com.datadog.android.rum.internal.metric.slowframes.DefaultUISlownessMetricDispatcher;
import com.datadog.android.rum.internal.metric.slowframes.SlowFramesListener;
import com.datadog.android.rum.internal.startup.RumSessionScopeStartupManager;
import com.datadog.android.rum.internal.timeseries.NoOpTimeseriesCollector;
import com.datadog.android.rum.internal.timeseries.NoOpTimeseriesCollectorFactory;
import com.datadog.android.rum.internal.timeseries.TimeseriesCollector;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RumSessionScope.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u0080\u00012\u00020\u0001:\u0006\u0080\u0001\u0081\u0001\u0082\u0001Bÿ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0!\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\u0010(\u001a\u0004\u0018\u00010)\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+\u0012\u0006\u0010-\u001a\u00020.\u0012\b\u0010/\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00101\u001a\u000202¢\u0006\u0002\u00103J\b\u0010f\u001a\u00020gH\u0002J\b\u0010h\u001a\u00020gH\u0016JL\u0010i\u001a\u0004\u0018\u00010\u00012\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020m2\"\u0010n\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u00020q0o\u0012\u0004\u0012\u00020q0oj\u0002`r2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020L0tH\u0017J\b\u0010D\u001a\u00020\u000bH\u0016J\b\u0010u\u001a\u00020\u000bH\u0002J\u0018\u0010v\u001a\u00020q2\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020cH\u0002J\b\u0010z\u001a\u00020qH\u0002J\b\u0010{\u001a\u00020qH\u0002J\r\u0010|\u001a\u00020qH\u0000¢\u0006\u0002\b}J\u0010\u0010~\u001a\u00020q2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010\u007f\u001a\u00020q2\u0006\u0010P\u001a\u00020\tH\u0002R\u0016\u00104\u001a\u0004\u0018\u0001058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\"\u0010:\u001a\u0004\u0018\u00010;X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00109\"\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020L0KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0010\u0010O\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010U\u001a\u00020VX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u000e\u0010[\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\\\u001a\u00020]X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u000e\u0010b\u001a\u00020cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0083\u0001"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "sessionEndedMetricDispatcher", "Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;", "sessionSampler", "Lcom/datadog/android/core/sampling/Sampler;", "", "backgroundTrackingEnabled", "", "trackFrustrations", "viewChangedListener", "Lcom/datadog/android/rum/internal/domain/scope/RumViewChangedListener;", "firstPartyHostHeaderTypeResolver", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "memoryVitalMonitor", "frameRateVitalMonitor", "sessionListener", "Lcom/datadog/android/rum/RumSessionListener;", "applicationDisplayed", "networkSettledResourceIdentifier", "Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "lastInteractionIdentifier", "Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "slowFramesListener", "Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;", "accessibilitySnapshotManager", "Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;", "batteryInfoProvider", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "displayInfoProvider", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "sessionInactivityNanos", "", "sessionMaxDurationNanos", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "rumSessionScopeStartupManagerFactory", "Lkotlin/Function0;", "Lcom/datadog/android/rum/internal/startup/RumSessionScopeStartupManager;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "heatmapIdentifierRegistry", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "timeseriesCollectorFactory", "Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector$Factory;", "(Lcom/datadog/android/rum/internal/domain/scope/RumScope;Lcom/datadog/android/core/InternalSdkCore;Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;Lcom/datadog/android/core/sampling/Sampler;ZZLcom/datadog/android/rum/internal/domain/scope/RumViewChangedListener;Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/RumSessionListener;ZLcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/rum/internal/domain/InfoProvider;JJLcom/datadog/android/rum/RumSessionType;Lkotlin/jvm/functions/Function0;Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector$Factory;)V", "activeView", "Lcom/datadog/android/rum/internal/domain/scope/RumViewScope;", "getActiveView$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumViewScope;", "getBackgroundTrackingEnabled$dd_sdk_android_rum_release", "()Z", "childScope", "Lcom/datadog/android/rum/internal/domain/scope/RumViewManagerScope;", "getChildScope$dd_sdk_android_rum_release$annotations", "()V", "getChildScope$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumViewManagerScope;", "setChildScope$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/domain/scope/RumViewManagerScope;)V", "getFirstPartyHostHeaderTypeResolver$dd_sdk_android_rum_release", "()Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "isActive", "isActive$dd_sdk_android_rum_release", "setActive$dd_sdk_android_rum_release", "(Z)V", "lastUserInteractionNs", "Ljava/util/concurrent/atomic/AtomicLong;", "noOpWriter", "Lcom/datadog/android/api/storage/NoOpDataWriter;", "", "getParentScope", "()Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "rumSessionScopeStartupManager", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "getSessionId$dd_sdk_android_rum_release", "()Ljava/lang/String;", "setSessionId$dd_sdk_android_rum_release", "(Ljava/lang/String;)V", RumSessionScope.RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY, "", "getSessionSampleRate$dd_sdk_android_rum_release", "()F", "getSessionSampler$dd_sdk_android_rum_release", "()Lcom/datadog/android/core/sampling/Sampler;", "sessionStartNs", "sessionState", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$State;", "getSessionState$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$State;", "setSessionState$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$State;)V", "startReason", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;", "timeseriesCollector", "Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector;", "getActiveRumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "getRumContext", "handleEvent", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "", "Lcom/datadog/android/api/feature/EventWriteScope;", "writer", "Lcom/datadog/android/api/storage/DataWriter;", "isSessionComplete", "renewSession", "time", "Lcom/datadog/android/rum/internal/domain/Time;", "reason", "startTimeseries", "stopSession", "stopTimeseries", "stopTimeseries$dd_sdk_android_rum_release", "updateSession", "updateSessionStateForSessionReplay", "Companion", "StartReason", "State", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumSessionScope implements RumScope {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long DEFAULT_SESSION_INACTIVITY_NS;
    private static final long DEFAULT_SESSION_MAX_DURATION_NS;
    public static final String RUM_KEEP_SESSION_BUS_MESSAGE_KEY = "keepSession";
    public static final String RUM_SESSION_ID_BUS_MESSAGE_KEY = "sessionId";
    public static final String RUM_SESSION_RENEWED_BUS_MESSAGE = "rum_session_renewed";
    public static final String RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY = "sessionSampleRate";
    public static final String SESSION_REPLAY_BUS_MESSAGE_TYPE_KEY = "type";
    private final boolean backgroundTrackingEnabled;
    private RumViewManagerScope childScope;
    private final FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver;
    private boolean isActive;
    private final AtomicLong lastUserInteractionNs;
    private final NoOpDataWriter<Object> noOpWriter;
    private final RumScope parentScope;
    private RumSessionScopeStartupManager rumSessionScopeStartupManager;
    private final Function0<RumSessionScopeStartupManager> rumSessionScopeStartupManagerFactory;
    private final RumSessionType rumSessionTypeOverride;
    private final InternalSdkCore sdkCore;
    private final SessionMetricDispatcher sessionEndedMetricDispatcher;
    private String sessionId;
    private final long sessionInactivityNanos;
    private final RumSessionListener sessionListener;
    private final long sessionMaxDurationNanos;
    private final float sessionSampleRate;
    private final Sampler<String> sessionSampler;
    private final AtomicLong sessionStartNs;
    private State sessionState;
    private StartReason startReason;
    private TimeseriesCollector timeseriesCollector;
    private final TimeseriesCollector.Factory timeseriesCollectorFactory;

    public static /* synthetic */ void getChildScope$dd_sdk_android_rum_release$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RumSessionScope(RumScope parentScope, InternalSdkCore sdkCore, SessionMetricDispatcher sessionEndedMetricDispatcher, Sampler<String> sessionSampler, boolean z, boolean z2, RumViewChangedListener rumViewChangedListener, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, VitalMonitor cpuVitalMonitor, VitalMonitor memoryVitalMonitor, VitalMonitor frameRateVitalMonitor, RumSessionListener rumSessionListener, boolean z3, InitialResourceIdentifier networkSettledResourceIdentifier, LastInteractionIdentifier lastInteractionIdentifier, SlowFramesListener slowFramesListener, AccessibilitySnapshotManager accessibilitySnapshotManager, InfoProvider<BatteryInfo> batteryInfoProvider, InfoProvider<DisplayInfo> displayInfoProvider, long j, long j2, RumSessionType rumSessionType, Function0<? extends RumSessionScopeStartupManager> rumSessionScopeStartupManagerFactory, InsightsCollector insightsCollector, HeatmapIdentifierRegistry heatmapIdentifierRegistry, TimeseriesCollector.Factory timeseriesCollectorFactory) {
        Intrinsics.checkNotNullParameter(parentScope, "parentScope");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(sessionEndedMetricDispatcher, "sessionEndedMetricDispatcher");
        Intrinsics.checkNotNullParameter(sessionSampler, "sessionSampler");
        Intrinsics.checkNotNullParameter(firstPartyHostHeaderTypeResolver, "firstPartyHostHeaderTypeResolver");
        Intrinsics.checkNotNullParameter(cpuVitalMonitor, "cpuVitalMonitor");
        Intrinsics.checkNotNullParameter(memoryVitalMonitor, "memoryVitalMonitor");
        Intrinsics.checkNotNullParameter(frameRateVitalMonitor, "frameRateVitalMonitor");
        Intrinsics.checkNotNullParameter(networkSettledResourceIdentifier, "networkSettledResourceIdentifier");
        Intrinsics.checkNotNullParameter(accessibilitySnapshotManager, "accessibilitySnapshotManager");
        Intrinsics.checkNotNullParameter(batteryInfoProvider, "batteryInfoProvider");
        Intrinsics.checkNotNullParameter(displayInfoProvider, "displayInfoProvider");
        Intrinsics.checkNotNullParameter(rumSessionScopeStartupManagerFactory, "rumSessionScopeStartupManagerFactory");
        Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
        Intrinsics.checkNotNullParameter(timeseriesCollectorFactory, "timeseriesCollectorFactory");
        this.parentScope = parentScope;
        this.sdkCore = sdkCore;
        this.sessionEndedMetricDispatcher = sessionEndedMetricDispatcher;
        this.sessionSampler = sessionSampler;
        this.backgroundTrackingEnabled = z;
        this.firstPartyHostHeaderTypeResolver = firstPartyHostHeaderTypeResolver;
        this.sessionListener = rumSessionListener;
        this.sessionInactivityNanos = j;
        this.sessionMaxDurationNanos = j2;
        this.rumSessionTypeOverride = rumSessionType;
        this.rumSessionScopeStartupManagerFactory = rumSessionScopeStartupManagerFactory;
        this.timeseriesCollectorFactory = timeseriesCollectorFactory;
        this.timeseriesCollector = new NoOpTimeseriesCollector();
        this.sessionId = "00000000-0000-0000-0000-000000000000";
        this.sessionState = State.NOT_TRACKED;
        Float sampleRate = sessionSampler.getSampleRate();
        float fFloatValue = sampleRate != null ? sampleRate.floatValue() : 100.0f;
        this.sessionSampleRate = fFloatValue;
        this.startReason = StartReason.USER_APP_LAUNCH;
        this.isActive = true;
        this.sessionStartNs = new AtomicLong(sdkCore.getTimeProvider().getDeviceElapsedTimeNanos());
        this.lastUserInteractionNs = new AtomicLong(0L);
        this.noOpWriter = new NoOpDataWriter<>();
        this.childScope = new RumViewManagerScope(this, sdkCore, sessionEndedMetricDispatcher, z, z2, rumViewChangedListener, firstPartyHostHeaderTypeResolver, cpuVitalMonitor, memoryVitalMonitor, frameRateVitalMonitor, z3, fFloatValue, networkSettledResourceIdentifier, slowFramesListener, lastInteractionIdentifier, rumSessionType, accessibilitySnapshotManager, batteryInfoProvider, displayInfoProvider, insightsCollector, heatmapIdentifierRegistry);
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public Map<String, Object> getCustomAttributes() {
        return RumScope.DefaultImpls.getCustomAttributes(this);
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope getParentScope() {
        return this.parentScope;
    }

    public final Sampler<String> getSessionSampler$dd_sdk_android_rum_release() {
        return this.sessionSampler;
    }

    /* JADX INFO: renamed from: getBackgroundTrackingEnabled$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getBackgroundTrackingEnabled() {
        return this.backgroundTrackingEnabled;
    }

    /* JADX INFO: renamed from: getFirstPartyHostHeaderTypeResolver$dd_sdk_android_rum_release, reason: from getter */
    public final FirstPartyHostHeaderTypeResolver getFirstPartyHostHeaderTypeResolver() {
        return this.firstPartyHostHeaderTypeResolver;
    }

    public /* synthetic */ RumSessionScope(RumScope rumScope, InternalSdkCore internalSdkCore, SessionMetricDispatcher sessionMetricDispatcher, Sampler sampler, boolean z, boolean z2, RumViewChangedListener rumViewChangedListener, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, VitalMonitor vitalMonitor, VitalMonitor vitalMonitor2, VitalMonitor vitalMonitor3, RumSessionListener rumSessionListener, boolean z3, InitialResourceIdentifier initialResourceIdentifier, LastInteractionIdentifier lastInteractionIdentifier, SlowFramesListener slowFramesListener, AccessibilitySnapshotManager accessibilitySnapshotManager, InfoProvider infoProvider, InfoProvider infoProvider2, long j, long j2, RumSessionType rumSessionType, Function0 function0, InsightsCollector insightsCollector, HeatmapIdentifierRegistry heatmapIdentifierRegistry, TimeseriesCollector.Factory factory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rumScope, internalSdkCore, sessionMetricDispatcher, sampler, z, z2, rumViewChangedListener, firstPartyHostHeaderTypeResolver, vitalMonitor, vitalMonitor2, vitalMonitor3, rumSessionListener, z3, initialResourceIdentifier, lastInteractionIdentifier, slowFramesListener, accessibilitySnapshotManager, infoProvider, infoProvider2, (i & 524288) != 0 ? DEFAULT_SESSION_INACTIVITY_NS : j, (i & 1048576) != 0 ? DEFAULT_SESSION_MAX_DURATION_NS : j2, rumSessionType, function0, insightsCollector, heatmapIdentifierRegistry, (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? new NoOpTimeseriesCollectorFactory() : factory);
    }

    /* JADX INFO: renamed from: getSessionId$dd_sdk_android_rum_release, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId$dd_sdk_android_rum_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    /* JADX INFO: renamed from: getSessionState$dd_sdk_android_rum_release, reason: from getter */
    public final State getSessionState() {
        return this.sessionState;
    }

    public final void setSessionState$dd_sdk_android_rum_release(State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.sessionState = state;
    }

    /* JADX INFO: renamed from: getSessionSampleRate$dd_sdk_android_rum_release, reason: from getter */
    public final float getSessionSampleRate() {
        return this.sessionSampleRate;
    }

    public final boolean isActive$dd_sdk_android_rum_release() {
        return this.isActive;
    }

    public final void setActive$dd_sdk_android_rum_release(boolean z) {
        this.isActive = z;
    }

    /* JADX INFO: renamed from: getChildScope$dd_sdk_android_rum_release, reason: from getter */
    public final RumViewManagerScope getChildScope() {
        return this.childScope;
    }

    public final void setChildScope$dd_sdk_android_rum_release(RumViewManagerScope rumViewManagerScope) {
        this.childScope = rumViewManagerScope;
    }

    public final RumViewScope getActiveView$dd_sdk_android_rum_release() {
        RumViewManagerScope rumViewManagerScope;
        if (!getIsActive() || (rumViewManagerScope = this.childScope) == null) {
            return null;
        }
        return rumViewManagerScope.getActiveView$dd_sdk_android_rum_release();
    }

    /* JADX INFO: compiled from: RumSessionScope.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$State;", "", "asString", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getAsString", "()Ljava/lang/String;", "NOT_TRACKED", WebViewReplayEventConsumer.SESSION_TRACKED_STATE, "EXPIRED", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum State {
        NOT_TRACKED("NOT_TRACKED"),
        TRACKED(WebViewReplayEventConsumer.SESSION_TRACKED_STATE),
        EXPIRED("EXPIRED");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String asString;

        State(String str) {
            this.asString = str;
        }

        public final String getAsString() {
            return this.asString;
        }

        /* JADX INFO: compiled from: RumSessionScope.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$State$Companion;", "", "()V", "fromString", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$State;", TypedValues.Custom.S_STRING, "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final State fromString(String string) {
                for (State state : State.values()) {
                    if (Intrinsics.areEqual(state.getAsString(), string)) {
                        return state;
                    }
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: RumSessionScope.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;", "", "asString", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getAsString", "()Ljava/lang/String;", "USER_APP_LAUNCH", "INACTIVITY_TIMEOUT", "MAX_DURATION", "BACKGROUND_LAUNCH", "PREWARM", "FROM_NON_INTERACTIVE_SESSION", "EXPLICIT_STOP", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum StartReason {
        USER_APP_LAUNCH("user_app_launch"),
        INACTIVITY_TIMEOUT("inactivity_timeout"),
        MAX_DURATION(DefaultUISlownessMetricDispatcher.KEY_MAX_DURATION),
        BACKGROUND_LAUNCH("background_launch"),
        PREWARM("prewarm"),
        FROM_NON_INTERACTIVE_SESSION("from_non_interactive_session"),
        EXPLICIT_STOP("explicit_stop");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String asString;

        StartReason(String str) {
            this.asString = str;
        }

        public final String getAsString() {
            return this.asString;
        }

        /* JADX INFO: compiled from: RumSessionScope.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason$Companion;", "", "()V", "fromString", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;", TypedValues.Custom.S_STRING, "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final StartReason fromString(String string) {
                for (StartReason startReason : StartReason.values()) {
                    if (Intrinsics.areEqual(startReason.getAsString(), string)) {
                        return startReason;
                    }
                }
                return null;
            }
        }
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope handleEvent(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        RumSessionScopeStartupManager rumSessionScopeStartupManager;
        RumSessionScopeStartupManager rumSessionScopeStartupManager2;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (event instanceof RumRawEvent.ResetSession) {
            renewSession(event.getEventTime(), StartReason.EXPLICIT_STOP);
        } else if (event instanceof RumRawEvent.StopSession) {
            stopSession();
        }
        updateSession(event);
        if (this.sessionState != State.TRACKED) {
            writer = this.noOpWriter;
        }
        DataWriter<Object> dataWriter = writer;
        RumContext activeRumContext = getActiveRumContext();
        if (event instanceof RumRawEvent.AppStartTTIDEvent) {
            RumSessionScopeStartupManager rumSessionScopeStartupManager3 = this.rumSessionScopeStartupManager;
            if (rumSessionScopeStartupManager3 != null) {
                rumSessionScopeStartupManager3.onTTIDEvent((RumRawEvent.AppStartTTIDEvent) event, this.sessionState == State.TRACKED, datadogContext, writeScope, dataWriter, activeRumContext, getCustomAttributes());
            }
        } else if (event instanceof RumRawEvent.AppStartEvent) {
            if (this.sessionState == State.TRACKED && (rumSessionScopeStartupManager2 = this.rumSessionScopeStartupManager) != null) {
                rumSessionScopeStartupManager2.onAppStartEvent((RumRawEvent.AppStartEvent) event);
            }
        } else if (event instanceof RumRawEvent.AppStartTTFDEvent) {
            if (this.sessionState == State.TRACKED && (rumSessionScopeStartupManager = this.rumSessionScopeStartupManager) != null) {
                rumSessionScopeStartupManager.onTTFDEvent((RumRawEvent.AppStartTTFDEvent) event, datadogContext, writeScope, dataWriter, activeRumContext, getCustomAttributes());
            }
        } else if (!(event instanceof RumRawEvent.SdkInit)) {
            RumViewManagerScope rumViewManagerScope = this.childScope;
            RumScope rumScopeHandleEvent = rumViewManagerScope != null ? rumViewManagerScope.handleEvent(event, datadogContext, writeScope, dataWriter) : null;
            this.childScope = rumScopeHandleEvent instanceof RumViewManagerScope ? (RumViewManagerScope) rumScopeHandleEvent : null;
        }
        TimeseriesCollector timeseriesCollector = this.timeseriesCollector;
        if (!(timeseriesCollector instanceof NoOpTimeseriesCollector)) {
            timeseriesCollector.onRumContextUpdate(getActiveRumContext());
        }
        if (isSessionComplete()) {
            return null;
        }
        return this;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumContext getRumContext() {
        RumContext rumContext = getParentScope().getRumContext();
        return rumContext.copy((32377 & 1) != 0 ? rumContext.applicationId : null, (32377 & 2) != 0 ? rumContext.sessionId : this.sessionId, (32377 & 4) != 0 ? rumContext.isSessionActive : this.isActive, (32377 & 8) != 0 ? rumContext.viewId : null, (32377 & 16) != 0 ? rumContext.viewName : null, (32377 & 32) != 0 ? rumContext.viewUrl : null, (32377 & 64) != 0 ? rumContext.actionId : null, (32377 & 128) != 0 ? rumContext.sessionState : this.sessionState, (32377 & 256) != 0 ? rumContext.sessionStartReason : this.startReason, (32377 & 512) != 0 ? rumContext.viewType : null, (32377 & 1024) != 0 ? rumContext.syntheticsTestId : null, (32377 & 2048) != 0 ? rumContext.syntheticsResultId : null, (32377 & 4096) != 0 ? rumContext.viewTimestamp : 0L, (32377 & 8192) != 0 ? rumContext.viewTimestampOffset : 0L, (32377 & 16384) != 0 ? rumContext.hasReplay : false, (32377 & 32768) != 0 ? rumContext.sessionSampleRate : this.sessionSampleRate);
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    /* JADX INFO: renamed from: isActive, reason: from getter */
    public boolean getIsActive() {
        return this.isActive;
    }

    private final RumContext getActiveRumContext() {
        RumContext rumContext;
        RumViewScope activeView$dd_sdk_android_rum_release = getActiveView$dd_sdk_android_rum_release();
        return (activeView$dd_sdk_android_rum_release == null || (rumContext = activeView$dd_sdk_android_rum_release.getRumContext()) == null) ? getRumContext() : rumContext;
    }

    private final void startTimeseries() {
        RumContext activeRumContext = getActiveRumContext();
        TimeseriesCollector timeseriesCollectorCreate = this.timeseriesCollectorFactory.create(INSTANCE.resolveSessionType$dd_sdk_android_rum_release(activeRumContext, this.rumSessionTypeOverride), activeRumContext);
        this.timeseriesCollector = timeseriesCollectorCreate;
        timeseriesCollectorCreate.onSessionStart();
    }

    public final void stopTimeseries$dd_sdk_android_rum_release() {
        this.timeseriesCollector.onSessionStop();
        this.timeseriesCollector = new NoOpTimeseriesCollector();
    }

    private final void stopSession() {
        this.isActive = false;
        stopTimeseries$dd_sdk_android_rum_release();
        this.sessionEndedMetricDispatcher.onSessionStopped(this.sessionId);
    }

    private final boolean isSessionComplete() {
        return !this.isActive && this.childScope == null;
    }

    private final void updateSession(RumRawEvent event) {
        StartReason startReason;
        long deviceElapsedTimeNanos = this.sdkCore.getTimeProvider().getDeviceElapsedTimeNanos();
        boolean zAreEqual = Intrinsics.areEqual(this.sessionId, "00000000-0000-0000-0000-000000000000");
        boolean z = deviceElapsedTimeNanos - this.lastUserInteractionNs.get() >= this.sessionInactivityNanos;
        boolean z2 = deviceElapsedTimeNanos - this.sessionStartNs.get() >= this.sessionMaxDurationNanos;
        boolean z3 = (event instanceof RumRawEvent.StartView) || (event instanceof RumRawEvent.StartAction);
        boolean zContains = ArraysKt.contains(RumViewManagerScope.INSTANCE.getValidBackgroundEventTypes$dd_sdk_android_rum_release(), event.getClass());
        boolean z4 = event instanceof RumRawEvent.SdkInit;
        boolean z5 = z4 && ((RumRawEvent.SdkInit) event).isAppInForeground();
        boolean z6 = z4 && !((RumRawEvent.SdkInit) event).isAppInForeground();
        boolean z7 = event instanceof RumRawEvent.AppStartEvent;
        if (z || z2 || !this.isActive) {
            this.sessionEndedMetricDispatcher.endMetric(this.sessionId, this.sdkCore.getTime().getServerTimeOffsetMs());
        }
        if (z3 || z5 || z7) {
            if (zAreEqual || z || z2) {
                if (zAreEqual) {
                    startReason = StartReason.USER_APP_LAUNCH;
                } else if (z) {
                    startReason = StartReason.INACTIVITY_TIMEOUT;
                } else {
                    startReason = StartReason.MAX_DURATION;
                }
                renewSession(event.getEventTime(), startReason);
            }
            this.lastUserInteractionNs.set(deviceElapsedTimeNanos);
        } else if (z) {
            if (this.backgroundTrackingEnabled && (zContains || z6)) {
                renewSession(event.getEventTime(), StartReason.BACKGROUND_LAUNCH);
                this.lastUserInteractionNs.set(deviceElapsedTimeNanos);
            } else {
                stopTimeseries$dd_sdk_android_rum_release();
                this.sessionState = State.EXPIRED;
            }
        } else if (z2) {
            renewSession(event.getEventTime(), StartReason.MAX_DURATION);
        }
        updateSessionStateForSessionReplay(this.sessionId);
    }

    private final void renewSession(Time time, StartReason reason) {
        stopTimeseries$dd_sdk_android_rum_release();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        boolean zSample = this.sessionSampler.sample(string);
        this.startReason = reason;
        this.sessionState = zSample ? State.TRACKED : State.NOT_TRACKED;
        this.sessionId = string;
        this.sessionStartNs.set(time.getNanoTime());
        this.rumSessionScopeStartupManager = this.rumSessionScopeStartupManagerFactory.invoke();
        RumViewManagerScope rumViewManagerScope = this.childScope;
        if (rumViewManagerScope != null) {
            rumViewManagerScope.renewViewScopes$dd_sdk_android_rum_release(time);
        }
        if (zSample) {
            this.sessionEndedMetricDispatcher.startMetric(this.sessionId, reason, this.sdkCore.getTime().getServerTimeOffsetMs(), this.backgroundTrackingEnabled);
            startTimeseries();
        }
        RumSessionListener rumSessionListener = this.sessionListener;
        if (rumSessionListener != null) {
            rumSessionListener.onSessionStarted(this.sessionId, !zSample);
        }
    }

    private final void updateSessionStateForSessionReplay(String sessionId) {
        FeatureScope feature = this.sdkCore.getFeature("session-replay");
        if (feature != null) {
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to("type", RUM_SESSION_RENEWED_BUS_MESSAGE);
            pairArr[1] = TuplesKt.to(RUM_SESSION_ID_BUS_MESSAGE_KEY, sessionId);
            pairArr[2] = TuplesKt.to(RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY, Float.valueOf(this.sessionSampleRate));
            pairArr[3] = TuplesKt.to(RUM_KEEP_SESSION_BUS_MESSAGE_KEY, Boolean.valueOf(this.sessionState == State.TRACKED));
            feature.sendEvent(MapsKt.mapOf(pairArr));
        }
    }

    /* JADX INFO: compiled from: RumSessionScope.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u0013R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$Companion;", "", "()V", "DEFAULT_SESSION_INACTIVITY_NS", "", "getDEFAULT_SESSION_INACTIVITY_NS$dd_sdk_android_rum_release", "()J", "DEFAULT_SESSION_MAX_DURATION_NS", "getDEFAULT_SESSION_MAX_DURATION_NS$dd_sdk_android_rum_release", "RUM_KEEP_SESSION_BUS_MESSAGE_KEY", "", "RUM_SESSION_ID_BUS_MESSAGE_KEY", "RUM_SESSION_RENEWED_BUS_MESSAGE", "RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY", "SESSION_REPLAY_BUS_MESSAGE_TYPE_KEY", "resolveSessionType", "Lcom/datadog/android/rum/RumSessionType;", "Lcom/datadog/android/rum/internal/domain/RumContext;", "rumSessionTypeOverride", "resolveSessionType$dd_sdk_android_rum_release", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getDEFAULT_SESSION_INACTIVITY_NS$dd_sdk_android_rum_release() {
            return RumSessionScope.DEFAULT_SESSION_INACTIVITY_NS;
        }

        public final long getDEFAULT_SESSION_MAX_DURATION_NS$dd_sdk_android_rum_release() {
            return RumSessionScope.DEFAULT_SESSION_MAX_DURATION_NS;
        }

        public final RumSessionType resolveSessionType$dd_sdk_android_rum_release(RumContext rumContext, RumSessionType rumSessionType) {
            String syntheticsResultId;
            Intrinsics.checkNotNullParameter(rumContext, "<this>");
            if (rumSessionType != null) {
                return rumSessionType;
            }
            String syntheticsTestId = rumContext.getSyntheticsTestId();
            return (syntheticsTestId == null || StringsKt.isBlank(syntheticsTestId) || (syntheticsResultId = rumContext.getSyntheticsResultId()) == null || StringsKt.isBlank(syntheticsResultId)) ? RumSessionType.USER : RumSessionType.SYNTHETICS;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        DEFAULT_SESSION_INACTIVITY_NS = 900000000000L;
        TimeUnit timeUnit2 = TimeUnit.HOURS;
        DEFAULT_SESSION_MAX_DURATION_NS = 14400000000000L;
    }
}
