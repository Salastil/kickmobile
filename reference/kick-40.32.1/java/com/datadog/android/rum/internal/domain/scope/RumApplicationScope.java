package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry;
import com.datadog.android.rum.DdRumContentProvider;
import com.datadog.android.rum.GlobalRumMonitor;
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
import com.datadog.android.rum.internal.metric.slowframes.SlowFramesListener;
import com.datadog.android.rum.internal.startup.RumSessionScopeStartupManager;
import com.datadog.android.rum.internal.timeseries.TimeseriesCollector;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumApplicationScope.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001`B×\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0!\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&\u0012\u0006\u0010(\u001a\u00020)\u0012\b\u0010*\u001a\u0004\u0018\u00010+\u0012\u0006\u0010,\u001a\u00020-¢\u0006\u0002\u0010.JJ\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\"\u0010N\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020I0O\u0012\u0004\u0012\u00020I0Oj\u0002`Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SH\u0003J\u0016\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010T0VH\u0016J\b\u0010W\u001a\u00020DH\u0016JJ\u0010X\u001a\u00020\u00012\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\"\u0010N\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020I0O\u0012\u0004\u0012\u00020I0Oj\u0002`Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SH\u0017J\b\u0010Y\u001a\u00020\nH\u0016J\u0010\u0010Z\u001a\u00020I2\u0006\u0010[\u001a\u00020=H\u0016JJ\u0010\\\u001a\u00020I2\u0006\u0010]\u001a\u00020^2\u0006\u0010L\u001a\u00020M2\"\u0010N\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020I0O\u0012\u0004\u0012\u00020I0Oj\u0002`Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SH\u0003JJ\u0010_\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\"\u0010N\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020I0O\u0012\u0004\u0012\u00020I0Oj\u0002`Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SH\u0003R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010/\u001a\u0004\u0018\u0001008F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00104¨\u0006a"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumApplicationScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumViewChangedListener;", "applicationId", "", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "sessionSampler", "Lcom/datadog/android/core/sampling/Sampler;", "backgroundTrackingEnabled", "", "trackFrustrations", "firstPartyHostHeaderTypeResolver", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "memoryVitalMonitor", "frameRateVitalMonitor", "sessionEndedMetricDispatcher", "Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;", "sessionListener", "Lcom/datadog/android/rum/RumSessionListener;", "initialResourceIdentifier", "Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "lastInteractionIdentifier", "Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "slowFramesListener", "Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "accessibilitySnapshotManager", "Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;", "batteryInfoProvider", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "displayInfoProvider", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "rumSessionScopeStartupManagerFactory", "Lkotlin/Function0;", "Lcom/datadog/android/rum/internal/startup/RumSessionScopeStartupManager;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "heatmapIdentifierRegistry", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "timeseriesCollectorFactory", "Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector$Factory;", "(Ljava/lang/String;Lcom/datadog/android/core/InternalSdkCore;Lcom/datadog/android/core/sampling/Sampler;ZZLcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;Lcom/datadog/android/rum/RumSessionListener;Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;Lcom/datadog/android/rum/RumSessionType;Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lkotlin/jvm/functions/Function0;Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector$Factory;)V", "activeSession", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope;", "getActiveSession", "()Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope;", "getBackgroundTrackingEnabled$dd_sdk_android_rum_release", "()Z", "childScopes", "", "getChildScopes$dd_sdk_android_rum_release", "()Ljava/util/List;", "getInitialResourceIdentifier$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "isAppStartedEventSent", "lastActiveViewInfo", "Lcom/datadog/android/rum/internal/domain/scope/RumViewInfo;", "getLastInteractionIdentifier$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "parentScope", "getParentScope", "()Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "getSessionSampler$dd_sdk_android_rum_release", "()Lcom/datadog/android/core/sampling/Sampler;", "getTrackFrustrations$dd_sdk_android_rum_release", "delegateToChildren", "", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "writer", "Lcom/datadog/android/api/storage/DataWriter;", "", "getCustomAttributes", "", "getRumContext", "handleEvent", "isActive", "onViewChanged", "viewInfo", "sendApplicationStartEvent", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "startNewSession", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumApplicationScope implements RumScope, RumViewChangedListener {
    public static final String MULTIPLE_ACTIVE_SESSIONS_ERROR = "Application has multiple active sessions, this shouldn't happen.";
    public static final String MULTIPLE_ACTIVE_SESSIONS_SESSION_START_ERROR = "Application has multiple active sessions when starting a new session";
    private final AccessibilitySnapshotManager accessibilitySnapshotManager;
    private final boolean backgroundTrackingEnabled;
    private final InfoProvider<BatteryInfo> batteryInfoProvider;
    private final List<RumSessionScope> childScopes;
    private final VitalMonitor cpuVitalMonitor;
    private final InfoProvider<DisplayInfo> displayInfoProvider;
    private final FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver;
    private final VitalMonitor frameRateVitalMonitor;
    private final HeatmapIdentifierRegistry heatmapIdentifierRegistry;
    private final InitialResourceIdentifier initialResourceIdentifier;
    private final InsightsCollector insightsCollector;
    private boolean isAppStartedEventSent;
    private RumViewInfo lastActiveViewInfo;
    private final LastInteractionIdentifier lastInteractionIdentifier;
    private final VitalMonitor memoryVitalMonitor;
    private final RumScope parentScope;
    private RumContext rumContext;
    private final Function0<RumSessionScopeStartupManager> rumSessionScopeStartupManagerFactory;
    private final RumSessionType rumSessionTypeOverride;
    private final InternalSdkCore sdkCore;
    private final SessionMetricDispatcher sessionEndedMetricDispatcher;
    private final RumSessionListener sessionListener;
    private final Sampler<String> sessionSampler;
    private final SlowFramesListener slowFramesListener;
    private final TimeseriesCollector.Factory timeseriesCollectorFactory;
    private final boolean trackFrustrations;

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    /* JADX INFO: renamed from: isActive */
    public boolean getIsActive() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RumApplicationScope(String applicationId, InternalSdkCore sdkCore, Sampler<String> sessionSampler, boolean z, boolean z2, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, VitalMonitor cpuVitalMonitor, VitalMonitor memoryVitalMonitor, VitalMonitor frameRateVitalMonitor, SessionMetricDispatcher sessionEndedMetricDispatcher, RumSessionListener rumSessionListener, InitialResourceIdentifier initialResourceIdentifier, LastInteractionIdentifier lastInteractionIdentifier, SlowFramesListener slowFramesListener, RumSessionType rumSessionType, AccessibilitySnapshotManager accessibilitySnapshotManager, InfoProvider<BatteryInfo> batteryInfoProvider, InfoProvider<DisplayInfo> displayInfoProvider, Function0<? extends RumSessionScopeStartupManager> rumSessionScopeStartupManagerFactory, InsightsCollector insightsCollector, HeatmapIdentifierRegistry heatmapIdentifierRegistry, TimeseriesCollector.Factory timeseriesCollectorFactory) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(sessionSampler, "sessionSampler");
        Intrinsics.checkNotNullParameter(firstPartyHostHeaderTypeResolver, "firstPartyHostHeaderTypeResolver");
        Intrinsics.checkNotNullParameter(cpuVitalMonitor, "cpuVitalMonitor");
        Intrinsics.checkNotNullParameter(memoryVitalMonitor, "memoryVitalMonitor");
        Intrinsics.checkNotNullParameter(frameRateVitalMonitor, "frameRateVitalMonitor");
        Intrinsics.checkNotNullParameter(sessionEndedMetricDispatcher, "sessionEndedMetricDispatcher");
        Intrinsics.checkNotNullParameter(initialResourceIdentifier, "initialResourceIdentifier");
        Intrinsics.checkNotNullParameter(accessibilitySnapshotManager, "accessibilitySnapshotManager");
        Intrinsics.checkNotNullParameter(batteryInfoProvider, "batteryInfoProvider");
        Intrinsics.checkNotNullParameter(displayInfoProvider, "displayInfoProvider");
        Intrinsics.checkNotNullParameter(rumSessionScopeStartupManagerFactory, "rumSessionScopeStartupManagerFactory");
        Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
        Intrinsics.checkNotNullParameter(timeseriesCollectorFactory, "timeseriesCollectorFactory");
        this.sdkCore = sdkCore;
        this.sessionSampler = sessionSampler;
        this.backgroundTrackingEnabled = z;
        this.trackFrustrations = z2;
        this.firstPartyHostHeaderTypeResolver = firstPartyHostHeaderTypeResolver;
        this.cpuVitalMonitor = cpuVitalMonitor;
        this.memoryVitalMonitor = memoryVitalMonitor;
        this.frameRateVitalMonitor = frameRateVitalMonitor;
        this.sessionEndedMetricDispatcher = sessionEndedMetricDispatcher;
        this.sessionListener = rumSessionListener;
        this.initialResourceIdentifier = initialResourceIdentifier;
        this.lastInteractionIdentifier = lastInteractionIdentifier;
        this.slowFramesListener = slowFramesListener;
        this.rumSessionTypeOverride = rumSessionType;
        this.accessibilitySnapshotManager = accessibilitySnapshotManager;
        this.batteryInfoProvider = batteryInfoProvider;
        this.displayInfoProvider = displayInfoProvider;
        this.rumSessionScopeStartupManagerFactory = rumSessionScopeStartupManagerFactory;
        this.insightsCollector = insightsCollector;
        this.heatmapIdentifierRegistry = heatmapIdentifierRegistry;
        this.timeseriesCollectorFactory = timeseriesCollectorFactory;
        this.rumContext = new RumContext(applicationId, null, false, null, null, null, null, null, null, null, null, null, 0L, 0L, false, 0.0f, 65534, null);
        this.childScopes = CollectionsKt.mutableListOf(new RumSessionScope(this, sdkCore, sessionEndedMetricDispatcher, sessionSampler, z, z2, this, firstPartyHostHeaderTypeResolver, cpuVitalMonitor, memoryVitalMonitor, frameRateVitalMonitor, rumSessionListener, false, initialResourceIdentifier, lastInteractionIdentifier, slowFramesListener, accessibilitySnapshotManager, batteryInfoProvider, displayInfoProvider, 0L, 0L, rumSessionType, rumSessionScopeStartupManagerFactory, insightsCollector, heatmapIdentifierRegistry, timeseriesCollectorFactory, 1572864, null));
    }

    public final Sampler<String> getSessionSampler$dd_sdk_android_rum_release() {
        return this.sessionSampler;
    }

    /* JADX INFO: renamed from: getBackgroundTrackingEnabled$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getBackgroundTrackingEnabled() {
        return this.backgroundTrackingEnabled;
    }

    /* JADX INFO: renamed from: getTrackFrustrations$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getTrackFrustrations() {
        return this.trackFrustrations;
    }

    /* JADX INFO: renamed from: getInitialResourceIdentifier$dd_sdk_android_rum_release, reason: from getter */
    public final InitialResourceIdentifier getInitialResourceIdentifier() {
        return this.initialResourceIdentifier;
    }

    /* JADX INFO: renamed from: getLastInteractionIdentifier$dd_sdk_android_rum_release, reason: from getter */
    public final LastInteractionIdentifier getLastInteractionIdentifier() {
        return this.lastInteractionIdentifier;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope getParentScope() {
        return this.parentScope;
    }

    public final List<RumSessionScope> getChildScopes$dd_sdk_android_rum_release() {
        return this.childScopes;
    }

    public final RumSessionScope getActiveSession() {
        List<RumSessionScope> list = this.childScopes;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RumSessionScope) obj).getIsActive()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() > 1) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumApplicationScope$activeSession$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumApplicationScope.MULTIPLE_ACTIVE_SESSIONS_ERROR;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return (RumSessionScope) CollectionsKt.lastOrNull((List) arrayList2);
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope handleEvent(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (event instanceof RumRawEvent.SetSyntheticsTestAttribute) {
            RumContext rumContext = this.rumContext;
            RumRawEvent.SetSyntheticsTestAttribute setSyntheticsTestAttribute = (RumRawEvent.SetSyntheticsTestAttribute) event;
            this.rumContext = rumContext.copy((32377 & 1) != 0 ? rumContext.applicationId : null, (32377 & 2) != 0 ? rumContext.sessionId : null, (32377 & 4) != 0 ? rumContext.isSessionActive : false, (32377 & 8) != 0 ? rumContext.viewId : null, (32377 & 16) != 0 ? rumContext.viewName : null, (32377 & 32) != 0 ? rumContext.viewUrl : null, (32377 & 64) != 0 ? rumContext.actionId : null, (32377 & 128) != 0 ? rumContext.sessionState : null, (32377 & 256) != 0 ? rumContext.sessionStartReason : null, (32377 & 512) != 0 ? rumContext.viewType : null, (32377 & 1024) != 0 ? rumContext.syntheticsTestId : setSyntheticsTestAttribute.getTestId(), (32377 & 2048) != 0 ? rumContext.syntheticsResultId : setSyntheticsTestAttribute.getResultId(), (32377 & 4096) != 0 ? rumContext.viewTimestamp : 0L, (32377 & 8192) != 0 ? rumContext.viewTimestampOffset : 0L, (32377 & 16384) != 0 ? rumContext.hasReplay : false, (32377 & 32768) != 0 ? rumContext.sessionSampleRate : 0.0f);
        }
        boolean z = (event instanceof RumRawEvent.StartView) || (event instanceof RumRawEvent.StartAction);
        if (getActiveSession() == null && z) {
            startNewSession(event, datadogContext, writeScope, writer);
        }
        if (!(event instanceof RumRawEvent.SdkInit) && !this.isAppStartedEventSent) {
            sendApplicationStartEvent(event.getEventTime(), datadogContext, writeScope, writer);
        }
        delegateToChildren(event, datadogContext, writeScope, writer);
        return this;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumContext getRumContext() {
        return this.rumContext;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public Map<String, Object> getCustomAttributes() {
        return GlobalRumMonitor.get(this.sdkCore).getAttributes();
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumViewChangedListener
    public void onViewChanged(RumViewInfo viewInfo) {
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        if (viewInfo.isActive()) {
            this.lastActiveViewInfo = viewInfo;
        }
    }

    private final void delegateToChildren(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        Iterator<RumSessionScope> it = this.childScopes.iterator();
        while (it.hasNext()) {
            if (it.next().handleEvent(event, datadogContext, writeScope, writer) == null) {
                it.remove();
            }
        }
    }

    private final void startNewSession(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        RumViewInfo rumViewInfo;
        RumSessionScope rumSessionScope = new RumSessionScope(this, this.sdkCore, this.sessionEndedMetricDispatcher, this.sessionSampler, this.backgroundTrackingEnabled, this.trackFrustrations, this, this.firstPartyHostHeaderTypeResolver, this.cpuVitalMonitor, this.memoryVitalMonitor, this.frameRateVitalMonitor, this.sessionListener, true, this.initialResourceIdentifier, this.lastInteractionIdentifier, this.slowFramesListener, this.accessibilitySnapshotManager, this.batteryInfoProvider, this.displayInfoProvider, 0L, 0L, this.rumSessionTypeOverride, this.rumSessionScopeStartupManagerFactory, this.insightsCollector, this.heatmapIdentifierRegistry, this.timeseriesCollectorFactory, 1572864, null);
        this.childScopes.add(rumSessionScope);
        if (!(event instanceof RumRawEvent.StartView) && (rumViewInfo = this.lastActiveViewInfo) != null) {
            rumSessionScope.handleEvent(new RumRawEvent.StartView(rumViewInfo.getKey(), rumViewInfo.getAttributes(), Time.INSTANCE.now(this.sdkCore.getTimeProvider())), datadogContext, writeScope, writer);
        }
        List<RumSessionScope> list = this.childScopes;
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((RumSessionScope) it.next()).getIsActive() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i > 1) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumApplicationScope.startNewSession.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumApplicationScope.MULTIPLE_ACTIVE_SESSIONS_SESSION_START_ERROR;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    private final void sendApplicationStartEvent(Time eventTime, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (DdRumContentProvider.INSTANCE.getProcessImportance() == 100) {
            long appStartTimeNs = this.sdkCore.getAppStartTimeNs();
            long nanos = (TimeUnit.MILLISECONDS.toNanos(eventTime.getTimestamp()) - eventTime.getNanoTime()) + appStartTimeNs;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            delegateToChildren(new RumRawEvent.ApplicationStarted(eventTime.getNanoTime() - appStartTimeNs, new Time(nanos / 1000000, appStartTimeNs)), datadogContext, writeScope, writer);
            this.isAppStartedEventSent = true;
        }
    }
}
