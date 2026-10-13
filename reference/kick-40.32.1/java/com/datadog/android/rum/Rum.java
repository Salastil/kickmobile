package com.datadog.android.rum;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.datastore.DataStoreHandler;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.sampling.DeterministicSampler;
import com.datadog.android.core.sampling.RateBasedSampler;
import com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry;
import com.datadog.android.internal.sampling.SessionSamplingIdProvider;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.internal.RumAnonymousIdentifierManager;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.datadog.android.rum.internal.domain.accessibility.AccessibilitySnapshotManager;
import com.datadog.android.rum.internal.domain.battery.BatteryInfo;
import com.datadog.android.rum.internal.domain.display.DisplayInfo;
import com.datadog.android.rum.internal.domain.scope.RumVitalAppLaunchEventHelper;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.metric.SessionEndedMetricDispatcher;
import com.datadog.android.rum.internal.metric.slowframes.SlowFramesListener;
import com.datadog.android.rum.internal.monitor.DatadogRumMonitor;
import com.datadog.android.rum.internal.startup.RumAppStartupTelemetryReporter;
import com.datadog.android.rum.internal.startup.RumSessionScopeStartupManager;
import com.datadog.android.rum.internal.timeseries.TimeseriesCollector;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.datadog.android.rum.timeseries.TimeseriesType;
import com.datadog.android.telemetry.internal.TelemetryEventHandler;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Rum.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\u0015H\u0007J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/Rum;", "", "()V", "INVALID_APPLICATION_ID_ERROR_MESSAGE", "", "RUM_FEATURE_ALREADY_ENABLED", "UNEXPECTED_SDK_CORE_TYPE", "createMonitor", "Lcom/datadog/android/rum/internal/monitor/DatadogRumMonitor;", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "rumFeature", "Lcom/datadog/android/rum/internal/RumFeature;", "createTelemetryEventHandler", "Lcom/datadog/android/telemetry/internal/TelemetryEventHandler;", "sessionEndedMetricDispatcher", "Lcom/datadog/android/rum/internal/metric/SessionEndedMetricDispatcher;", "enable", "", "rumConfiguration", "Lcom/datadog/android/rum/RumConfiguration;", "Lcom/datadog/android/api/SdkCore;", "isTimeseriesConfigured", "", "Lcom/datadog/android/rum/internal/RumFeature$Configuration;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Rum {
    public static final Rum INSTANCE = new Rum();
    public static final String INVALID_APPLICATION_ID_ERROR_MESSAGE = "You're trying to create a RumMonitor instance, but the RUM application id was empty. No RUM data will be sent.";
    public static final String RUM_FEATURE_ALREADY_ENABLED = "RUM Feature is already enabled in this SDK core, ignoring the call to enable it.";
    public static final String UNEXPECTED_SDK_CORE_TYPE = "SDK instance provided doesn't implement InternalSdkCore.";

    @JvmStatic
    public static final void enable(RumConfiguration rumConfiguration) {
        Intrinsics.checkNotNullParameter(rumConfiguration, "rumConfiguration");
        enable$default(rumConfiguration, null, 2, null);
    }

    private Rum() {
    }

    public static /* synthetic */ void enable$default(RumConfiguration rumConfiguration, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        enable(rumConfiguration, sdkCore);
    }

    @JvmStatic
    public static final void enable(RumConfiguration rumConfiguration, SdkCore sdkCore) {
        DataStoreHandler dataStore;
        InternalLogger unbound;
        Intrinsics.checkNotNullParameter(rumConfiguration, "rumConfiguration");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        if (!(sdkCore instanceof InternalSdkCore)) {
            FeatureSdkCore featureSdkCore = sdkCore instanceof FeatureSdkCore ? (FeatureSdkCore) sdkCore : null;
            if (featureSdkCore == null || (unbound = featureSdkCore.getInternalLogger()) == null) {
                unbound = InternalLogger.INSTANCE.getUNBOUND();
            }
            InternalLogger.DefaultImpls.log$default(unbound, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.Rum.enable.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Rum.UNEXPECTED_SDK_CORE_TYPE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        if (StringsKt.isBlank(rumConfiguration.getApplicationId$dd_sdk_android_rum_release())) {
            InternalLogger.DefaultImpls.log$default(((InternalSdkCore) sdkCore).getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.Rum.enable.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Rum.INVALID_APPLICATION_ID_ERROR_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        InternalSdkCore internalSdkCore = (InternalSdkCore) sdkCore;
        if (internalSdkCore.getFeature("rum") != null) {
            InternalLogger.DefaultImpls.log$default(internalSdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.Rum.enable.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Rum.RUM_FEATURE_ALREADY_ENABLED;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        FeatureSdkCore featureSdkCore2 = (FeatureSdkCore) sdkCore;
        RumFeature rumFeature = new RumFeature(featureSdkCore2, rumConfiguration.getApplicationId$dd_sdk_android_rum_release(), rumConfiguration.getFeatureConfiguration$dd_sdk_android_rum_release(), null, null, null, 56, null);
        internalSdkCore.registerFeature(rumFeature);
        FeatureScope feature = internalSdkCore.getFeature(rumFeature.getName());
        if (feature != null && (dataStore = feature.getDataStore()) != null) {
            new RumAnonymousIdentifierManager(dataStore, featureSdkCore2).manageAnonymousId(rumConfiguration.getFeatureConfiguration$dd_sdk_android_rum_release().getTrackAnonymousUser());
        }
        Rum rum = INSTANCE;
        DatadogRumMonitor datadogRumMonitorCreateMonitor = rum.createMonitor(internalSdkCore, rumFeature);
        if (Build.VERSION.SDK_INT >= 30) {
            rumFeature.consumeLastFatalAnr$dd_sdk_android_rum_release(datadogRumMonitorCreateMonitor.getExecutorService());
        }
        GlobalRumMonitor.INSTANCE.registerIfAbsent$dd_sdk_android_rum_release(datadogRumMonitorCreateMonitor, sdkCore);
        datadogRumMonitorCreateMonitor.start();
        if (rum.isTimeseriesConfigured(rumConfiguration.getFeatureConfiguration$dd_sdk_android_rum_release())) {
            InternalLogger.DefaultImpls.logApiUsage$default(internalSdkCore.getInternalLogger(), 0.0f, new Function0<InternalTelemetryEvent.ApiUsage>() { // from class: com.datadog.android.rum.Rum.enable.5
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final InternalTelemetryEvent.ApiUsage invoke() {
                    return new InternalTelemetryEvent.ApiUsage.Timeseries(null, 1, null);
                }
            }, 1, null);
        }
    }

    private final DatadogRumMonitor createMonitor(final InternalSdkCore sdkCore, RumFeature rumFeature) {
        SessionEndedMetricDispatcher sessionEndedMetricDispatcher = new SessionEndedMetricDispatcher(sdkCore.getInternalLogger(), rumFeature.getConfiguration().getSampleRate());
        final RumVitalAppLaunchEventHelper rumVitalAppLaunchEventHelper = new RumVitalAppLaunchEventHelper(rumFeature.getConfiguration().getRumSessionTypeOverride(), rumFeature.getBatteryInfoProvider$dd_sdk_android_rum_release(), rumFeature.getDisplayInfoProvider$dd_sdk_android_rum_release(), rumFeature.getSampleRate(), sdkCore.getInternalLogger());
        final RumAppStartupTelemetryReporter rumAppStartupTelemetryReporterCreate = RumAppStartupTelemetryReporter.INSTANCE.create(sdkCore);
        DeterministicSampler deterministicSampler = new DeterministicSampler((Function1) new Rum$createMonitor$sessionSampler$1(SessionSamplingIdProvider.INSTANCE), rumFeature.getSampleRate());
        String applicationId = rumFeature.getApplicationId();
        String packageName = rumFeature.getAppContext$dd_sdk_android_rum_release().getPackageName();
        DataWriter<Object> dataWriter$dd_sdk_android_rum_release = rumFeature.getDataWriter$dd_sdk_android_rum_release();
        Handler handler = new Handler(Looper.getMainLooper());
        TelemetryEventHandler telemetryEventHandlerCreateTelemetryEventHandler = createTelemetryEventHandler(sdkCore, rumFeature, sessionEndedMetricDispatcher);
        FirstPartyHostHeaderTypeResolver firstPartyHostResolver = sdkCore.getFirstPartyHostResolver();
        VitalMonitor cpuVitalMonitor = rumFeature.getCpuVitalMonitor();
        VitalMonitor memoryVitalMonitor = rumFeature.getMemoryVitalMonitor();
        VitalMonitor frameRateVitalMonitor = rumFeature.getFrameRateVitalMonitor();
        boolean backgroundEventTracking = rumFeature.getBackgroundEventTracking();
        boolean trackFrustrations = rumFeature.getTrackFrustrations();
        RumSessionListener sessionListener = rumFeature.getSessionListener();
        ExecutorService executorServiceCreateSingleThreadExecutorService = sdkCore.createSingleThreadExecutorService("rum-pipeline");
        InitialResourceIdentifier initialResourceIdentifier = rumFeature.getInitialResourceIdentifier();
        LastInteractionIdentifier lastInteractionIdentifier = rumFeature.getLastInteractionIdentifier();
        SlowFramesListener slowFramesListener = rumFeature.getSlowFramesListener();
        RumSessionType rumSessionTypeOverride = rumFeature.getConfiguration().getRumSessionTypeOverride();
        AccessibilitySnapshotManager accessibilitySnapshotManager = rumFeature.getAccessibilitySnapshotManager();
        InfoProvider<BatteryInfo> batteryInfoProvider$dd_sdk_android_rum_release = rumFeature.getBatteryInfoProvider$dd_sdk_android_rum_release();
        InfoProvider<DisplayInfo> displayInfoProvider$dd_sdk_android_rum_release = rumFeature.getDisplayInfoProvider$dd_sdk_android_rum_release();
        InsightsCollector insightsCollector = rumFeature.getInsightsCollector();
        HeatmapIdentifierRegistry heatmapIdentifierRegistry = rumFeature.getHeatmapIdentifierRegistry();
        TimeseriesCollector.Factory timeseriesCollectorFactory = rumFeature.getTimeseriesCollectorFactory();
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        return new DatadogRumMonitor(applicationId, sdkCore, packageName, deterministicSampler, backgroundEventTracking, trackFrustrations, dataWriter$dd_sdk_android_rum_release, handler, telemetryEventHandlerCreateTelemetryEventHandler, sessionEndedMetricDispatcher, firstPartyHostResolver, cpuVitalMonitor, memoryVitalMonitor, frameRateVitalMonitor, sessionListener, executorServiceCreateSingleThreadExecutorService, initialResourceIdentifier, lastInteractionIdentifier, slowFramesListener, rumSessionTypeOverride, accessibilitySnapshotManager, batteryInfoProvider$dd_sdk_android_rum_release, displayInfoProvider$dd_sdk_android_rum_release, new Function0<RumSessionScopeStartupManager>() { // from class: com.datadog.android.rum.Rum.createMonitor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RumSessionScopeStartupManager invoke() {
                return RumSessionScopeStartupManager.INSTANCE.create(rumVitalAppLaunchEventHelper, sdkCore, rumAppStartupTelemetryReporterCreate);
            }
        }, insightsCollector, heatmapIdentifierRegistry, timeseriesCollectorFactory);
    }

    private final TelemetryEventHandler createTelemetryEventHandler(InternalSdkCore sdkCore, RumFeature rumFeature, SessionEndedMetricDispatcher sessionEndedMetricDispatcher) {
        return new TelemetryEventHandler(sdkCore, new RateBasedSampler(rumFeature.getTelemetrySampleRate()), new RateBasedSampler(rumFeature.getTelemetryConfigurationSampleRate()), sessionEndedMetricDispatcher, 0, 16, null);
    }

    private final boolean isTimeseriesConfigured(RumFeature.Configuration configuration) {
        Set<TimeseriesType> enabledTypes$dd_sdk_android_rum_release;
        TimeseriesConfiguration timeseriesConfiguration = configuration.getTimeseriesConfiguration();
        return (timeseriesConfiguration == null || (enabledTypes$dd_sdk_android_rum_release = timeseriesConfiguration.getEnabledTypes$dd_sdk_android_rum_release()) == null || !(enabledTypes$dd_sdk_android_rum_release.isEmpty() ^ true)) ? false : true;
    }
}
