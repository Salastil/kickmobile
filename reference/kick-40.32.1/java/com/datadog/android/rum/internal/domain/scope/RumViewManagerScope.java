package com.datadog.android.rum.internal.domain.scope;

import androidx.camera.camera2.pipe.CameraGraph;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.metrics.MethodCallSamplingRate;
import com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.DdRumContentProvider;
import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.internal.anr.ANRException;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.accessibility.AccessibilitySnapshotManager;
import com.datadog.android.rum.internal.domain.battery.BatteryInfo;
import com.datadog.android.rum.internal.domain.display.DisplayInfo;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.datadog.android.rum.internal.metric.SessionMetricDispatcher;
import com.datadog.android.rum.internal.metric.ViewEndedMetricDispatcher;
import com.datadog.android.rum.internal.metric.interactiontonextview.InteractionToNextViewMetricResolver;
import com.datadog.android.rum.internal.metric.networksettled.NetworkSettledMetricResolver;
import com.datadog.android.rum.internal.metric.slowframes.SlowFramesListener;
import com.datadog.android.rum.internal.vitals.NoOpVitalMonitor;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumViewManagerScope.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 c2\u00020\u0001:\u0001cBÃ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0 \u0012\u0006\u0010$\u001a\u00020%\u0012\b\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010(J\u0010\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020<H\u0002J\u0010\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020HH\u0002JJ\u0010I\u001a\u00020J2\u0006\u0010G\u001a\u00020H2\u0006\u0010K\u001a\u00020L2\"\u0010M\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020J0N\u0012\u0004\u0012\u00020J0Nj\u0002`P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RH\u0003J\b\u0010T\u001a\u00020UH\u0016JJ\u0010V\u001a\u00020J2\u0006\u0010G\u001a\u00020H2\u0006\u0010K\u001a\u00020L2\"\u0010M\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020J0N\u0012\u0004\u0012\u00020J0Nj\u0002`P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RH\u0003JL\u0010W\u001a\u0004\u0018\u00010\u00012\u0006\u0010G\u001a\u00020H2\u0006\u0010K\u001a\u00020L2\"\u0010M\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020J0N\u0012\u0004\u0012\u00020J0Nj\u0002`P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RH\u0017JJ\u0010X\u001a\u00020J2\u0006\u0010G\u001a\u00020H2\u0006\u0010K\u001a\u00020L2\"\u0010M\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020J0N\u0012\u0004\u0012\u00020J0Nj\u0002`P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RH\u0003J\b\u0010Y\u001a\u00020\bH\u0016J\b\u0010Z\u001a\u00020\bH\u0002J\u0015\u0010[\u001a\u00020J2\u0006\u0010\\\u001a\u00020<H\u0000¢\u0006\u0002\b]JJ\u0010^\u001a\u00020J2\u0006\u0010G\u001a\u00020H2\u0006\u0010K\u001a\u00020L2\"\u0010M\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020J0N\u0012\u0004\u0012\u00020J0Nj\u0002`P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RH\u0002JJ\u0010_\u001a\u00020J2\u0006\u0010G\u001a\u00020`2\u0006\u0010K\u001a\u00020L2\"\u0010M\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020J0N\u0012\u0004\u0012\u00020J0Nj\u0002`P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RH\u0003J\u0010\u0010a\u001a\u00020J2\u0006\u0010G\u001a\u00020bH\u0003R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\u0004\u0018\u00010*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001a\u0010\u0012\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020*02X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010.\"\u0004\bC\u00100R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumViewManagerScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "sessionEndedMetricDispatcher", "Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;", "backgroundTrackingEnabled", "", "trackFrustrations", "viewChangedListener", "Lcom/datadog/android/rum/internal/domain/scope/RumViewChangedListener;", "firstPartyHostHeaderTypeResolver", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "memoryVitalMonitor", "frameRateVitalMonitor", "applicationDisplayed", "sampleRate", "", "initialResourceIdentifier", "Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "slowFramesListener", "Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;", "lastInteractionIdentifier", "Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "accessibilitySnapshotManager", "Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;", "batteryInfoProvider", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "displayInfoProvider", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "heatmapIdentifierRegistry", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "(Lcom/datadog/android/rum/internal/domain/scope/RumScope;Lcom/datadog/android/core/InternalSdkCore;Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;ZZLcom/datadog/android/rum/internal/domain/scope/RumViewChangedListener;Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;ZFLcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;Lcom/datadog/android/rum/RumSessionType;Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;)V", "activeView", "Lcom/datadog/android/rum/internal/domain/scope/RumViewScope;", "getActiveView$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumViewScope;", "getApplicationDisplayed$dd_sdk_android_rum_release", "()Z", "setApplicationDisplayed$dd_sdk_android_rum_release", "(Z)V", "childrenScopes", "", "getChildrenScopes$dd_sdk_android_rum_release", "()Ljava/util/List;", "getFirstPartyHostHeaderTypeResolver$dd_sdk_android_rum_release", "()Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "getInitialResourceIdentifier$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "interactionToNextViewMetricResolver", "Lcom/datadog/android/rum/internal/metric/interactiontonextview/InteractionToNextViewMetricResolver;", "lastStoppedViewTime", "Lcom/datadog/android/rum/internal/domain/Time;", "getParentScope", "()Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "getSampleRate$dd_sdk_android_rum_release", "()F", "stopped", "getStopped$dd_sdk_android_rum_release", "setStopped$dd_sdk_android_rum_release", "createAppLaunchViewScope", "time", "createBackgroundViewScope", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "delegateToChildren", "", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "writer", "Lcom/datadog/android/api/storage/DataWriter;", "", "getRumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "handleBackgroundEvent", "handleEvent", "handleOrphanEvent", "isActive", "isViewManagerComplete", "renewViewScopes", "eventTime", "renewViewScopes$dd_sdk_android_rum_release", "sendViewUpdateToChildren", "startApplicationLaunchView", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ApplicationStarted;", "startForegroundView", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartView;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumViewManagerScope implements RumScope {
    public static final String ATTR_GAP_BETWEEN_VIEWS = "view_gap";
    private static final String MESSAGE_GAP_BETWEEN_VIEWS = "[Mobile Metric] Gap between views";
    public static final String MESSAGE_MISSING_VIEW = "A RUM event was detected, but no view is active. To track views automatically, try calling the RumConfiguration.Builder.useViewTrackingStrategy() method.\nYou can also track views manually using the RumMonitor.startView() and RumMonitor.stopView() methods.";
    private static final String MESSAGE_NEG_GAP_BETWEEN_VIEWS = "[Mobile Metric] Negative gap between views";
    public static final String MESSAGE_UNKNOWN_MISSED_TYPE = "An RUM event was detected, but no view is active, its missed type is unknown";
    public static final String MULTIPLE_ACTIVE_VIEWS_ERROR = "Multiple views are active at the same time, this shouldn't happen.";
    public static final String NO_ACTIVE_VIEW_FOR_LOADING_TIME_WARNING_MESSAGE = "No active view found to add the loading time.";
    public static final String RUM_APP_LAUNCH_VIEW_ID = "com.datadog.application-launch.view";
    public static final String RUM_APP_LAUNCH_VIEW_NAME = "ApplicationLaunch";
    public static final String RUM_APP_LAUNCH_VIEW_URL = "com/datadog/application-launch/view";
    public static final String RUM_BACKGROUND_VIEW_ID = "com.datadog.background.view";
    public static final String RUM_BACKGROUND_VIEW_NAME = "Background";
    public static final String RUM_BACKGROUND_VIEW_URL = "com/datadog/background/view";
    private static final long THREE_SECONDS_GAP_NS;
    private final AccessibilitySnapshotManager accessibilitySnapshotManager;
    private boolean applicationDisplayed;
    private final boolean backgroundTrackingEnabled;
    private final InfoProvider<BatteryInfo> batteryInfoProvider;
    private final List<RumViewScope> childrenScopes;
    private final VitalMonitor cpuVitalMonitor;
    private final InfoProvider<DisplayInfo> displayInfoProvider;
    private final FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver;
    private final VitalMonitor frameRateVitalMonitor;
    private final HeatmapIdentifierRegistry heatmapIdentifierRegistry;
    private final InitialResourceIdentifier initialResourceIdentifier;
    private final InsightsCollector insightsCollector;
    private final InteractionToNextViewMetricResolver interactionToNextViewMetricResolver;
    private Time lastStoppedViewTime;
    private final VitalMonitor memoryVitalMonitor;
    private final RumScope parentScope;
    private final RumSessionType rumSessionTypeOverride;
    private final float sampleRate;
    private final InternalSdkCore sdkCore;
    private final SessionMetricDispatcher sessionEndedMetricDispatcher;
    private final SlowFramesListener slowFramesListener;
    private boolean stopped;
    private final boolean trackFrustrations;
    private final RumViewChangedListener viewChangedListener;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Class<?>[] validBackgroundEventTypes = {RumRawEvent.AddError.class, RumRawEvent.StartAction.class, RumRawEvent.StartResource.class, RumRawEvent.StartOperation.class, RumRawEvent.StopOperation.class};
    private static final Class<?>[] silentOrphanEventTypes = {RumRawEvent.ApplicationStarted.class, RumRawEvent.ResetSession.class, RumRawEvent.StopView.class, RumRawEvent.ActionDropped.class, RumRawEvent.ActionSent.class, RumRawEvent.ErrorDropped.class, RumRawEvent.ErrorSent.class, RumRawEvent.LongTaskDropped.class, RumRawEvent.LongTaskSent.class, RumRawEvent.ResourceDropped.class, RumRawEvent.ResourceSent.class, RumRawEvent.UpdatePerformanceMetric.class, RumRawEvent.UpdateExternalRefreshRate.class};

    public RumViewManagerScope(RumScope parentScope, InternalSdkCore sdkCore, SessionMetricDispatcher sessionEndedMetricDispatcher, boolean z, boolean z2, RumViewChangedListener rumViewChangedListener, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, VitalMonitor cpuVitalMonitor, VitalMonitor memoryVitalMonitor, VitalMonitor frameRateVitalMonitor, boolean z3, float f, InitialResourceIdentifier initialResourceIdentifier, SlowFramesListener slowFramesListener, LastInteractionIdentifier lastInteractionIdentifier, RumSessionType rumSessionType, AccessibilitySnapshotManager accessibilitySnapshotManager, InfoProvider<BatteryInfo> batteryInfoProvider, InfoProvider<DisplayInfo> displayInfoProvider, InsightsCollector insightsCollector, HeatmapIdentifierRegistry heatmapIdentifierRegistry) {
        Intrinsics.checkNotNullParameter(parentScope, "parentScope");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(sessionEndedMetricDispatcher, "sessionEndedMetricDispatcher");
        Intrinsics.checkNotNullParameter(firstPartyHostHeaderTypeResolver, "firstPartyHostHeaderTypeResolver");
        Intrinsics.checkNotNullParameter(cpuVitalMonitor, "cpuVitalMonitor");
        Intrinsics.checkNotNullParameter(memoryVitalMonitor, "memoryVitalMonitor");
        Intrinsics.checkNotNullParameter(frameRateVitalMonitor, "frameRateVitalMonitor");
        Intrinsics.checkNotNullParameter(initialResourceIdentifier, "initialResourceIdentifier");
        Intrinsics.checkNotNullParameter(accessibilitySnapshotManager, "accessibilitySnapshotManager");
        Intrinsics.checkNotNullParameter(batteryInfoProvider, "batteryInfoProvider");
        Intrinsics.checkNotNullParameter(displayInfoProvider, "displayInfoProvider");
        Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
        this.parentScope = parentScope;
        this.sdkCore = sdkCore;
        this.sessionEndedMetricDispatcher = sessionEndedMetricDispatcher;
        this.backgroundTrackingEnabled = z;
        this.trackFrustrations = z2;
        this.viewChangedListener = rumViewChangedListener;
        this.firstPartyHostHeaderTypeResolver = firstPartyHostHeaderTypeResolver;
        this.cpuVitalMonitor = cpuVitalMonitor;
        this.memoryVitalMonitor = memoryVitalMonitor;
        this.frameRateVitalMonitor = frameRateVitalMonitor;
        this.applicationDisplayed = z3;
        this.sampleRate = f;
        this.initialResourceIdentifier = initialResourceIdentifier;
        this.slowFramesListener = slowFramesListener;
        this.rumSessionTypeOverride = rumSessionType;
        this.accessibilitySnapshotManager = accessibilitySnapshotManager;
        this.batteryInfoProvider = batteryInfoProvider;
        this.displayInfoProvider = displayInfoProvider;
        this.insightsCollector = insightsCollector;
        this.heatmapIdentifierRegistry = heatmapIdentifierRegistry;
        this.interactionToNextViewMetricResolver = new InteractionToNextViewMetricResolver(sdkCore.getInternalLogger(), null, lastInteractionIdentifier, 2, null);
        this.childrenScopes = new ArrayList();
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public Map<String, Object> getCustomAttributes() {
        return RumScope.DefaultImpls.getCustomAttributes(this);
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope getParentScope() {
        return this.parentScope;
    }

    /* JADX INFO: renamed from: getFirstPartyHostHeaderTypeResolver$dd_sdk_android_rum_release, reason: from getter */
    public final FirstPartyHostHeaderTypeResolver getFirstPartyHostHeaderTypeResolver() {
        return this.firstPartyHostHeaderTypeResolver;
    }

    /* JADX INFO: renamed from: getApplicationDisplayed$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getApplicationDisplayed() {
        return this.applicationDisplayed;
    }

    public final void setApplicationDisplayed$dd_sdk_android_rum_release(boolean z) {
        this.applicationDisplayed = z;
    }

    /* JADX INFO: renamed from: getSampleRate$dd_sdk_android_rum_release, reason: from getter */
    public final float getSampleRate() {
        return this.sampleRate;
    }

    /* JADX INFO: renamed from: getInitialResourceIdentifier$dd_sdk_android_rum_release, reason: from getter */
    public final InitialResourceIdentifier getInitialResourceIdentifier() {
        return this.initialResourceIdentifier;
    }

    public final List<RumViewScope> getChildrenScopes$dd_sdk_android_rum_release() {
        return this.childrenScopes;
    }

    public final RumViewScope getActiveView$dd_sdk_android_rum_release() {
        if (!getIsActive()) {
            return null;
        }
        List<RumViewScope> list = this.childrenScopes;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RumViewScope) obj).getIsActive()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() > 1) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewManagerScope$activeView$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumViewManagerScope.MULTIPLE_ACTIVE_VIEWS_ERROR;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return (RumViewScope) CollectionsKt.lastOrNull((List) arrayList2);
    }

    /* JADX INFO: renamed from: getStopped$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getStopped() {
        return this.stopped;
    }

    public final void setStopped$dd_sdk_android_rum_release(boolean z) {
        this.stopped = z;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope handleEvent(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
        Intrinsics.checkNotNullParameter(writer, "writer");
        if ((event instanceof RumRawEvent.ApplicationStarted) && !this.applicationDisplayed && !this.stopped) {
            startApplicationLaunchView((RumRawEvent.ApplicationStarted) event, datadogContext, writeScope, writer);
            return this;
        }
        delegateToChildren(event, datadogContext, writeScope, writer);
        if ((event instanceof RumRawEvent.StartView) && !this.stopped) {
            startForegroundView((RumRawEvent.StartView) event);
            sendViewUpdateToChildren(event, datadogContext, writeScope, writer);
            Time time = this.lastStoppedViewTime;
            if (time != null) {
                final long nanoTime = event.getEventTime().getNanoTime() - time.getNanoTime();
                if (1 <= nanoTime && nanoTime < THREE_SECONDS_GAP_NS) {
                    InternalLogger.DefaultImpls.logMetric$default(this.sdkCore.getInternalLogger(), new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewManagerScope$handleEvent$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str = String.format(Locale.US, "[Mobile Metric] Gap between views", Arrays.copyOf(new Object[]{Long.valueOf(nanoTime)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            return str;
                        }
                    }, MapsKt.mapOf(TuplesKt.to(ATTR_GAP_BETWEEN_VIEWS, Long.valueOf(nanoTime))), MethodCallSamplingRate.MEDIUM.getRate(), null, 8, null);
                } else if (nanoTime < 0) {
                    InternalLogger.DefaultImpls.logMetric$default(this.sdkCore.getInternalLogger(), new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewManagerScope$handleEvent$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str = String.format(Locale.US, "[Mobile Metric] Negative gap between views", Arrays.copyOf(new Object[]{Long.valueOf(nanoTime)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            return str;
                        }
                    }, MapsKt.mapOf(TuplesKt.to(ATTR_GAP_BETWEEN_VIEWS, Long.valueOf(nanoTime))), MethodCallSamplingRate.MEDIUM.getRate(), null, 8, null);
                }
            }
            this.lastStoppedViewTime = null;
        } else if (event instanceof RumRawEvent.StopSession) {
            this.stopped = true;
        } else {
            List<RumViewScope> list = this.childrenScopes;
            int i = 0;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((RumViewScope) it.next()).getIsActive() && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (i == 0) {
                handleOrphanEvent(event, datadogContext, writeScope, writer);
            }
        }
        if (isViewManagerComplete()) {
            return null;
        }
        return this;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    /* JADX INFO: renamed from: getRumContext */
    public RumContext getInitialContext() {
        return getParentScope().getInitialContext();
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    /* JADX INFO: renamed from: isActive */
    public boolean getIsActive() {
        return !this.stopped;
    }

    public final void renewViewScopes$dd_sdk_android_rum_release(Time eventTime) {
        Intrinsics.checkNotNullParameter(eventTime, "eventTime");
        List<RumViewScope> list = this.childrenScopes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((RumViewScope) it.next()).renew$dd_sdk_android_rum_release(eventTime));
        }
        this.childrenScopes.clear();
        this.childrenScopes.addAll(arrayList);
    }

    private final boolean isViewManagerComplete() {
        return this.stopped && this.childrenScopes.isEmpty();
    }

    private final void startApplicationLaunchView(RumRawEvent.ApplicationStarted event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        RumViewScope rumViewScopeCreateAppLaunchViewScope = createAppLaunchViewScope(event.getEventTime());
        this.applicationDisplayed = true;
        rumViewScopeCreateAppLaunchViewScope.handleEvent(event, datadogContext, writeScope, writer);
        this.childrenScopes.add(rumViewScopeCreateAppLaunchViewScope);
    }

    private final void sendViewUpdateToChildren(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        Iterator<T> it = this.childrenScopes.iterator();
        while (it.hasNext()) {
            RumViewScope.sendViewUpdate$dd_sdk_android_rum_release$default((RumViewScope) it.next(), event, datadogContext, writeScope, writer, null, 16, null);
        }
    }

    private final void delegateToChildren(final RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        RumScopeKey key;
        final boolean zIsEmpty = this.childrenScopes.isEmpty();
        Iterator<RumViewScope> it = this.childrenScopes.iterator();
        boolean isActive = false;
        while (true) {
            String id = null;
            if (!it.hasNext()) {
                break;
            }
            RumViewScope next = it.next();
            isActive |= next.getIsActive();
            if ((event instanceof RumRawEvent.StopView) && next.getIsActive()) {
                RumViewScope rumViewScope = next instanceof RumViewScope ? next : null;
                if (rumViewScope != null && (key = rumViewScope.getKey()) != null) {
                    id = key.getId();
                }
                if (Intrinsics.areEqual(id, ((RumRawEvent.StopView) event).getKey().getId())) {
                    this.lastStoppedViewTime = event.getEventTime();
                }
            }
            if (next.handleEvent(event, datadogContext, writeScope, writer) == null) {
                it.remove();
            }
        }
        if (!(event instanceof RumRawEvent.AddViewLoadingTime) || isActive) {
            return;
        }
        InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewManagerScope.delegateToChildren.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return RumViewManagerScope.NO_ACTIVE_VIEW_FOR_LOADING_TIME_WARNING_MESSAGE;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        InternalLogger.DefaultImpls.logApiUsage$default(this.sdkCore.getInternalLogger(), 0.0f, new Function0<InternalTelemetryEvent.ApiUsage>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewManagerScope.delegateToChildren.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InternalTelemetryEvent.ApiUsage invoke() {
                boolean overwrite = ((RumRawEvent.AddViewLoadingTime) event).getOverwrite();
                boolean z = zIsEmpty;
                return new InternalTelemetryEvent.ApiUsage.AddViewLoadingTime(overwrite, z, !z, null, 8, null);
            }
        }, 1, null);
    }

    private final void handleOrphanEvent(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        Unit unit;
        boolean z = DdRumContentProvider.INSTANCE.getProcessImportance() == 100;
        if (event instanceof RumRawEvent.AddViewLoadingTime) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewManagerScope.handleOrphanEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumViewManagerScope.MESSAGE_MISSING_VIEW;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        if (this.applicationDisplayed || !z) {
            handleBackgroundEvent(event, datadogContext, writeScope, writer);
        } else if (!ArraysKt.contains(silentOrphanEventTypes, event.getClass())) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewManagerScope.handleOrphanEvent.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumViewManagerScope.MESSAGE_MISSING_VIEW;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        SessionEndedMetric.MissedEventType missedEventTypeFromRawEvent = SessionEndedMetric.MissedEventType.INSTANCE.fromRawEvent(event);
        if (missedEventTypeFromRawEvent != null) {
            this.sessionEndedMetricDispatcher.onMissedEventTracked(getParentScope().getInitialContext().getSessionId(), missedEventTypeFromRawEvent);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewManagerScope.handleOrphanEvent.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumViewManagerScope.MESSAGE_UNKNOWN_MISSED_TYPE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    private final void startForegroundView(RumRawEvent.StartView event) {
        RumViewScope rumViewScopeFromEvent$dd_sdk_android_rum_release = RumViewScope.INSTANCE.fromEvent$dd_sdk_android_rum_release(this, this.sessionEndedMetricDispatcher, this.sdkCore, event, this.viewChangedListener, this.firstPartyHostHeaderTypeResolver, this.cpuVitalMonitor, this.memoryVitalMonitor, this.frameRateVitalMonitor, this.trackFrustrations, this.sampleRate, this.interactionToNextViewMetricResolver, this.initialResourceIdentifier, this.slowFramesListener, this.rumSessionTypeOverride, this.accessibilitySnapshotManager, this.batteryInfoProvider, this.displayInfoProvider, this.insightsCollector, this.heatmapIdentifierRegistry);
        this.applicationDisplayed = true;
        this.childrenScopes.add(rumViewScopeFromEvent$dd_sdk_android_rum_release);
        RumViewChangedListener rumViewChangedListener = this.viewChangedListener;
        if (rumViewChangedListener != null) {
            rumViewChangedListener.onViewChanged(new RumViewInfo(event.getKey(), event.getAttributes(), true));
        }
    }

    private final void handleBackgroundEvent(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if ((event instanceof RumRawEvent.AddError) && (((RumRawEvent.AddError) event).getThrowable() instanceof ANRException)) {
            return;
        }
        boolean zContains = ArraysKt.contains(validBackgroundEventTypes, event.getClass());
        boolean zContains2 = ArraysKt.contains(silentOrphanEventTypes, event.getClass());
        if (!zContains || !this.backgroundTrackingEnabled) {
            if (zContains2) {
                return;
            }
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewManagerScope.handleBackgroundEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumViewManagerScope.MESSAGE_MISSING_VIEW;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            RumViewScope rumViewScopeCreateBackgroundViewScope = createBackgroundViewScope(event);
            rumViewScopeCreateBackgroundViewScope.handleEvent(event, datadogContext, writeScope, writer);
            this.childrenScopes.add(rumViewScopeCreateBackgroundViewScope);
            this.lastStoppedViewTime = null;
        }
    }

    private final RumViewScope createBackgroundViewScope(RumRawEvent event) {
        RumViewType rumViewType = RumViewType.BACKGROUND;
        NetworkSettledMetricResolver networkSettledMetricResolver = new NetworkSettledMetricResolver(this.initialResourceIdentifier, this.sdkCore.getInternalLogger());
        ViewEndedMetricDispatcher viewEndedMetricDispatcher = new ViewEndedMetricDispatcher(rumViewType, this.sdkCore.getInternalLogger(), null, 0.0f, 12, null);
        InternalSdkCore internalSdkCore = this.sdkCore;
        SessionMetricDispatcher sessionMetricDispatcher = this.sessionEndedMetricDispatcher;
        RumScopeKey rumScopeKey = new RumScopeKey(RUM_BACKGROUND_VIEW_ID, RUM_BACKGROUND_VIEW_URL, RUM_BACKGROUND_VIEW_NAME);
        Time eventTime = event.getEventTime();
        Map mapEmptyMap = MapsKt.emptyMap();
        RumViewChangedListener rumViewChangedListener = this.viewChangedListener;
        FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver = this.firstPartyHostHeaderTypeResolver;
        NoOpVitalMonitor noOpVitalMonitor = new NoOpVitalMonitor();
        NoOpVitalMonitor noOpVitalMonitor2 = new NoOpVitalMonitor();
        return new RumViewScope(this, internalSdkCore, sessionMetricDispatcher, rumScopeKey, eventTime, mapEmptyMap, rumViewChangedListener, firstPartyHostHeaderTypeResolver, noOpVitalMonitor, noOpVitalMonitor2, new NoOpVitalMonitor(), null, rumViewType, this.trackFrustrations, this.sampleRate, this.interactionToNextViewMetricResolver, networkSettledMetricResolver, this.slowFramesListener, viewEndedMetricDispatcher, this.rumSessionTypeOverride, this.accessibilitySnapshotManager, this.batteryInfoProvider, this.displayInfoProvider, this.insightsCollector, this.heatmapIdentifierRegistry, 2048, null);
    }

    private final RumViewScope createAppLaunchViewScope(Time time) {
        RumViewType rumViewType = RumViewType.APPLICATION_LAUNCH;
        NetworkSettledMetricResolver networkSettledMetricResolver = new NetworkSettledMetricResolver(this.initialResourceIdentifier, this.sdkCore.getInternalLogger());
        ViewEndedMetricDispatcher viewEndedMetricDispatcher = new ViewEndedMetricDispatcher(rumViewType, this.sdkCore.getInternalLogger(), null, 0.0f, 12, null);
        InternalSdkCore internalSdkCore = this.sdkCore;
        SessionMetricDispatcher sessionMetricDispatcher = this.sessionEndedMetricDispatcher;
        RumScopeKey rumScopeKey = new RumScopeKey(RUM_APP_LAUNCH_VIEW_ID, RUM_APP_LAUNCH_VIEW_URL, RUM_APP_LAUNCH_VIEW_NAME);
        Map mapEmptyMap = MapsKt.emptyMap();
        RumViewChangedListener rumViewChangedListener = this.viewChangedListener;
        FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver = this.firstPartyHostHeaderTypeResolver;
        NoOpVitalMonitor noOpVitalMonitor = new NoOpVitalMonitor();
        NoOpVitalMonitor noOpVitalMonitor2 = new NoOpVitalMonitor();
        return new RumViewScope(this, internalSdkCore, sessionMetricDispatcher, rumScopeKey, time, mapEmptyMap, rumViewChangedListener, firstPartyHostHeaderTypeResolver, noOpVitalMonitor, noOpVitalMonitor2, new NoOpVitalMonitor(), null, rumViewType, this.trackFrustrations, this.sampleRate, this.interactionToNextViewMetricResolver, networkSettledMetricResolver, this.slowFramesListener, viewEndedMetricDispatcher, this.rumSessionTypeOverride, this.accessibilitySnapshotManager, this.batteryInfoProvider, this.displayInfoProvider, this.insightsCollector, this.heatmapIdentifierRegistry, 2048, null);
    }

    /* JADX INFO: compiled from: RumViewManagerScope.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumViewManagerScope$Companion;", "", "()V", "ATTR_GAP_BETWEEN_VIEWS", "", "MESSAGE_GAP_BETWEEN_VIEWS", "MESSAGE_MISSING_VIEW", "MESSAGE_NEG_GAP_BETWEEN_VIEWS", "MESSAGE_UNKNOWN_MISSED_TYPE", "MULTIPLE_ACTIVE_VIEWS_ERROR", "NO_ACTIVE_VIEW_FOR_LOADING_TIME_WARNING_MESSAGE", "RUM_APP_LAUNCH_VIEW_ID", "RUM_APP_LAUNCH_VIEW_NAME", "RUM_APP_LAUNCH_VIEW_URL", "RUM_BACKGROUND_VIEW_ID", "RUM_BACKGROUND_VIEW_NAME", "RUM_BACKGROUND_VIEW_URL", "THREE_SECONDS_GAP_NS", "", "getTHREE_SECONDS_GAP_NS$dd_sdk_android_rum_release", "()J", "silentOrphanEventTypes", "", "Ljava/lang/Class;", "getSilentOrphanEventTypes$dd_sdk_android_rum_release", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "validBackgroundEventTypes", "getValidBackgroundEventTypes$dd_sdk_android_rum_release", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Class<?>[] getValidBackgroundEventTypes$dd_sdk_android_rum_release() {
            return RumViewManagerScope.validBackgroundEventTypes;
        }

        public final Class<?>[] getSilentOrphanEventTypes$dd_sdk_android_rum_release() {
            return RumViewManagerScope.silentOrphanEventTypes;
        }

        public final long getTHREE_SECONDS_GAP_NS$dd_sdk_android_rum_release() {
            return RumViewManagerScope.THREE_SECONDS_GAP_NS;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        THREE_SECONDS_GAP_NS = CameraGraph.Constants3A.DEFAULT_TIME_LIMIT_NS;
    }
}
