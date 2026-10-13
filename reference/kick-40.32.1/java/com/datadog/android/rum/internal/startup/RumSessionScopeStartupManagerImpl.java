package com.datadog.android.rum.internal.startup;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.internal.profiling.ProfilerEvent;
import com.datadog.android.internal.profiling.ProfilingRumContext;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import com.datadog.android.rum.internal.domain.scope.RumVitalAppLaunchEventHelper;
import com.datadog.android.rum.internal.profiling.ProfilingFeatureContextKt;
import com.datadog.android.rum.internal.utils.SdkCoreExtKt;
import com.datadog.android.rum.model.VitalAppLaunchEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: RumSessionScopeStartupManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016Jh\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\"\u0010!\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001a0\"\u0012\u0004\u0012\u00020\u001a0\"j\u0002`$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150&2\u0006\u0010'\u001a\u00020(2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H\u0016Jp\u0010*\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\"\u0010!\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001a0\"\u0012\u0004\u0012\u00020\u001a0\"j\u0002`$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150&2\u0006\u0010'\u001a\u00020(2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H\u0016Jp\u0010-\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\"\u0010!\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001a0\"\u0012\u0004\u0012\u00020\u001a0\"j\u0002`$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150&2\u0006\u0010'\u001a\u00020(2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002JR\u0010.\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\"\u0010!\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001a0\"\u0012\u0004\u0012\u00020\u001a0\"j\u0002`$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150&2\u0006\u0010/\u001a\u0002002\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0016\u00101\u001a\u0004\u0018\u000102*\u00020 2\u0006\u00103\u001a\u00020\u0014H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumSessionScopeStartupManagerImpl;", "Lcom/datadog/android/rum/internal/startup/RumSessionScopeStartupManager;", "rumVitalAppLaunchEventHelper", "Lcom/datadog/android/rum/internal/domain/scope/RumVitalAppLaunchEventHelper;", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "rumAppStartupTelemetryReporter", "Lcom/datadog/android/rum/internal/startup/RumAppStartupTelemetryReporter;", "(Lcom/datadog/android/rum/internal/domain/scope/RumVitalAppLaunchEventHelper;Lcom/datadog/android/core/InternalSdkCore;Lcom/datadog/android/rum/internal/startup/RumAppStartupTelemetryReporter;)V", "appStartCount", "", "lastScenario", "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "ttfdReportedForScenario", "", "ttfdReportedForSession", "ttidReportedForScenario", "ttidSentForSession", "getTelemetryAttributes", "", "", "", "durationNs", "", RumAppStartupTelemetryReporterImpl.KEY_SCENARIO, "onAppStartEvent", "", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartEvent;", "onTTFDEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartTTFDEvent;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "writer", "Lcom/datadog/android/api/storage/DataWriter;", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "customAttributes", "onTTIDEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartTTIDEvent;", "isSessionTracked", "sendTTFDEvent", "sendTTIDEvent", "ttidEvent", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent;", "getProfilingStatus", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ProfilingStatus;", "currentSessionId", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumSessionScopeStartupManagerImpl implements RumSessionScopeStartupManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long MAX_TTFD_DURATION_NS;
    private static final long MAX_TTID_DURATION_NS;
    public static final String REPORT_APP_FULLY_DISPLAYED_CALLED_BEFORE_TTID_MESSAGE = "RumMonitor.reportAppFullyDisplayed was called before TTID was computed, will report TTID as TTFD.";
    public static final String REPORT_APP_FULLY_DISPLAYED_CALLED_TOO_EARLY_MESSAGE = "RumMonitor.reportAppFullyDisplayed was called before the application launch was detected, ignoring it.";
    public static final String TTFD_TOO_LARGE_MESSAGE = "TTFD value is too large, skipping it";
    public static final String TTID_TOO_LARGE_MESSAGE = "TTID value is too large, skipping it";
    private int appStartCount;
    private RumStartupScenario lastScenario;
    private final RumAppStartupTelemetryReporter rumAppStartupTelemetryReporter;
    private final RumVitalAppLaunchEventHelper rumVitalAppLaunchEventHelper;
    private final InternalSdkCore sdkCore;
    private boolean ttfdReportedForScenario;
    private boolean ttfdReportedForSession;
    private boolean ttidReportedForScenario;
    private boolean ttidSentForSession;

    public RumSessionScopeStartupManagerImpl(RumVitalAppLaunchEventHelper rumVitalAppLaunchEventHelper, InternalSdkCore sdkCore, RumAppStartupTelemetryReporter rumAppStartupTelemetryReporter) {
        Intrinsics.checkNotNullParameter(rumVitalAppLaunchEventHelper, "rumVitalAppLaunchEventHelper");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(rumAppStartupTelemetryReporter, "rumAppStartupTelemetryReporter");
        this.rumVitalAppLaunchEventHelper = rumVitalAppLaunchEventHelper;
        this.sdkCore = sdkCore;
        this.rumAppStartupTelemetryReporter = rumAppStartupTelemetryReporter;
    }

    @Override // com.datadog.android.rum.internal.startup.RumSessionScopeStartupManager
    public void onAppStartEvent(RumRawEvent.AppStartEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.lastScenario = event.getScenario();
        this.ttfdReportedForScenario = false;
        this.ttidReportedForScenario = false;
        this.appStartCount++;
    }

    @Override // com.datadog.android.rum.internal.startup.RumSessionScopeStartupManager
    public void onTTIDEvent(RumRawEvent.AppStartTTIDEvent event, boolean isSessionTracked, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer, RumContext rumContext, Map<String, ? extends Object> customAttributes) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        Intrinsics.checkNotNullParameter(customAttributes, "customAttributes");
        if (!isSessionTracked) {
            FeatureScope feature = this.sdkCore.getFeature("profiling");
            if (feature != null) {
                feature.sendEvent(ProfilerEvent.TTIDNotTracked.INSTANCE);
                return;
            }
            return;
        }
        this.ttidReportedForScenario = true;
        this.rumAppStartupTelemetryReporter.reportTTID(event.getInfo(), this.appStartCount - 1);
        if (this.ttidSentForSession) {
            return;
        }
        this.ttidSentForSession = true;
        VitalAppLaunchEvent.ProfilingStatus profilingStatus = getProfilingStatus(datadogContext, rumContext.getSessionId());
        VitalAppLaunchEvent vitalAppLaunchEventNewVitalAppLaunchEvent = this.rumVitalAppLaunchEventHelper.newVitalAppLaunchEvent(event.getInfo().getScenario().getInitialTime().getTimestamp() + this.sdkCore.getTime().getServerTimeOffsetMs(), datadogContext, MapsKt.emptyMap(), customAttributes, null, rumContext, event.getInfo().getDurationNs(), event.getInfo().getScenario(), VitalAppLaunchEvent.AppLaunchMetric.TTID, profilingStatus, profilingStatus == VitalAppLaunchEvent.ProfilingStatus.STOPPED ? ProfilingFeatureContextKt.resolveProfilingQuotaReason(datadogContext, rumContext.getSessionId()) : null);
        FeatureScope feature2 = this.sdkCore.getFeature("profiling");
        if (feature2 != null) {
            feature2.sendEvent(new ProfilerEvent.RumVitalEvent(vitalAppLaunchEventNewVitalAppLaunchEvent.getVital().getId(), vitalAppLaunchEventNewVitalAppLaunchEvent.getVital().getName(), ProfilerEvent.RumVitalEvent.Type.TTID, vitalAppLaunchEventNewVitalAppLaunchEvent.getDate(), event.getInfo().getDurationNs(), new ProfilingRumContext(rumContext.getApplicationId(), rumContext.getSessionId(), rumContext.getViewId(), rumContext.getViewName())));
        }
        sendTTIDEvent(datadogContext, writeScope, writer, vitalAppLaunchEventNewVitalAppLaunchEvent, event.getInfo().getScenario());
        if (this.ttfdReportedForScenario) {
            sendTTFDEvent(datadogContext, writeScope, writer, rumContext, customAttributes, event.getInfo().getDurationNs(), event.getInfo().getScenario());
        }
    }

    @Override // com.datadog.android.rum.internal.startup.RumSessionScopeStartupManager
    public void onTTFDEvent(RumRawEvent.AppStartTTFDEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer, RumContext rumContext, Map<String, ? extends Object> customAttributes) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        Intrinsics.checkNotNullParameter(customAttributes, "customAttributes");
        if (this.ttfdReportedForSession) {
            return;
        }
        this.ttfdReportedForSession = true;
        RumStartupScenario rumStartupScenario = this.lastScenario;
        if (rumStartupScenario == null) {
            this.sdkCore.getInternalLogger().log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0<String>) new Function0<String>() { // from class: com.datadog.android.rum.internal.startup.RumSessionScopeStartupManagerImpl.onTTFDEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumSessionScopeStartupManagerImpl.REPORT_APP_FULLY_DISPLAYED_CALLED_TOO_EARLY_MESSAGE;
                }
            }, (Throwable) null, false, (Map<String, ? extends Object>) null);
            return;
        }
        this.ttfdReportedForScenario = true;
        if (!this.ttidReportedForScenario) {
            this.sdkCore.getInternalLogger().log(InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0<String>) new Function0<String>() { // from class: com.datadog.android.rum.internal.startup.RumSessionScopeStartupManagerImpl.onTTFDEvent.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumSessionScopeStartupManagerImpl.REPORT_APP_FULLY_DISPLAYED_CALLED_BEFORE_TTID_MESSAGE;
                }
            }, (Throwable) null, false, (Map<String, ? extends Object>) null);
        } else {
            sendTTFDEvent(datadogContext, writeScope, writer, rumContext, customAttributes, event.getEventTime().getNanoTime() - rumStartupScenario.getInitialTime().getNanoTime(), rumStartupScenario);
        }
    }

    private final void sendTTFDEvent(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer, RumContext rumContext, Map<String, ? extends Object> customAttributes, long durationNs, RumStartupScenario scenario) {
        if (durationNs > MAX_TTFD_DURATION_NS) {
            this.sdkCore.getInternalLogger().log(InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0<String>) new Function0<String>() { // from class: com.datadog.android.rum.internal.startup.RumSessionScopeStartupManagerImpl.sendTTFDEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumSessionScopeStartupManagerImpl.TTFD_TOO_LARGE_MESSAGE;
                }
            }, (Throwable) null, false, getTelemetryAttributes(durationNs, scenario));
            return;
        }
        VitalAppLaunchEvent.ProfilingStatus profilingStatus = getProfilingStatus(datadogContext, rumContext.getSessionId());
        final VitalAppLaunchEvent vitalAppLaunchEventNewVitalAppLaunchEvent = this.rumVitalAppLaunchEventHelper.newVitalAppLaunchEvent(scenario.getInitialTime().getTimestamp() + this.sdkCore.getTime().getServerTimeOffsetMs(), datadogContext, MapsKt.emptyMap(), customAttributes, null, rumContext, durationNs, scenario, VitalAppLaunchEvent.AppLaunchMetric.TTFD, profilingStatus, profilingStatus == VitalAppLaunchEvent.ProfilingStatus.STOPPED ? ProfilingFeatureContextKt.resolveProfilingQuotaReason(datadogContext, rumContext.getSessionId()) : null);
        FeatureScope feature = this.sdkCore.getFeature("profiling");
        if (feature != null) {
            feature.sendEvent(new ProfilerEvent.RumVitalEvent(vitalAppLaunchEventNewVitalAppLaunchEvent.getVital().getId(), vitalAppLaunchEventNewVitalAppLaunchEvent.getVital().getName(), ProfilerEvent.RumVitalEvent.Type.TTFD, vitalAppLaunchEventNewVitalAppLaunchEvent.getDate(), durationNs, new ProfilingRumContext(rumContext.getApplicationId(), rumContext.getSessionId(), rumContext.getViewId(), rumContext.getViewName())));
        }
        SdkCoreExtKt.newRumEventWriteOperation$default(this.sdkCore, datadogContext, writeScope, writer, null, new Function0<Object>() { // from class: com.datadog.android.rum.internal.startup.RumSessionScopeStartupManagerImpl.sendTTFDEvent.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return vitalAppLaunchEventNewVitalAppLaunchEvent;
            }
        }, 8, null).submit();
    }

    private final void sendTTIDEvent(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer, final VitalAppLaunchEvent ttidEvent, RumStartupScenario scenario) {
        long jLongValue = ttidEvent.getVital().getDuration().longValue();
        long j = MAX_TTID_DURATION_NS;
        InternalSdkCore internalSdkCore = this.sdkCore;
        if (jLongValue > j) {
            internalSdkCore.getInternalLogger().log(InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0<String>) new Function0<String>() { // from class: com.datadog.android.rum.internal.startup.RumSessionScopeStartupManagerImpl.sendTTIDEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumSessionScopeStartupManagerImpl.TTID_TOO_LARGE_MESSAGE;
                }
            }, (Throwable) null, false, getTelemetryAttributes(jLongValue, scenario));
        } else {
            SdkCoreExtKt.newRumEventWriteOperation$default(internalSdkCore, datadogContext, writeScope, writer, null, new Function0<Object>() { // from class: com.datadog.android.rum.internal.startup.RumSessionScopeStartupManagerImpl.sendTTIDEvent.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ttidEvent;
                }
            }, 8, null).submit();
        }
    }

    private final Map<String, Object> getTelemetryAttributes(long durationNs, RumStartupScenario scenario) {
        return MapsKt.mapOf(TuplesKt.to(RumAppStartupTelemetryReporterImpl.KEY_DURATION_NS, Long.valueOf(durationNs)), TuplesKt.to(RumAppStartupTelemetryReporterImpl.KEY_SCENARIO, RumStartupScenarioKt.getName(scenario)));
    }

    private final VitalAppLaunchEvent.ProfilingStatus getProfilingStatus(DatadogContext datadogContext, String str) {
        if (ProfilingFeatureContextKt.isProfilerRunning(datadogContext)) {
            return VitalAppLaunchEvent.ProfilingStatus.RUNNING;
        }
        if (ProfilingFeatureContextKt.resolveProfilingQuotaReason(datadogContext, str) != null) {
            return VitalAppLaunchEvent.ProfilingStatus.STOPPED;
        }
        return null;
    }

    /* JADX INFO: compiled from: RumSessionScopeStartupManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumSessionScopeStartupManagerImpl$Companion;", "", "()V", "MAX_TTFD_DURATION_NS", "", "getMAX_TTFD_DURATION_NS$dd_sdk_android_rum_release", "()J", "MAX_TTID_DURATION_NS", "getMAX_TTID_DURATION_NS$dd_sdk_android_rum_release", "REPORT_APP_FULLY_DISPLAYED_CALLED_BEFORE_TTID_MESSAGE", "", "REPORT_APP_FULLY_DISPLAYED_CALLED_TOO_EARLY_MESSAGE", "TTFD_TOO_LARGE_MESSAGE", "TTID_TOO_LARGE_MESSAGE", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getMAX_TTID_DURATION_NS$dd_sdk_android_rum_release() {
            return RumSessionScopeStartupManagerImpl.MAX_TTID_DURATION_NS;
        }

        public final long getMAX_TTFD_DURATION_NS$dd_sdk_android_rum_release() {
            return RumSessionScopeStartupManagerImpl.MAX_TTFD_DURATION_NS;
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        MAX_TTID_DURATION_NS = Duration.m14077getInWholeNanosecondsimpl(DurationKt.toDuration(1, DurationUnit.MINUTES));
        Duration.Companion companion2 = Duration.INSTANCE;
        MAX_TTFD_DURATION_NS = Duration.m14077getInWholeNanosecondsimpl(DurationKt.toDuration(90, DurationUnit.SECONDS));
    }
}
