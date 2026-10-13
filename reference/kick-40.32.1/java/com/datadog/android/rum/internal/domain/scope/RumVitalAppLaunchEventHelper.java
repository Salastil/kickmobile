package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.core.internal.utils.DdTagsUtils;
import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.internal.RumSessionTypeExtKt;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.battery.BatteryInfo;
import com.datadog.android.rum.internal.domain.display.DisplayInfo;
import com.datadog.android.rum.internal.startup.RumAppStartupTelemetryReporterImpl;
import com.datadog.android.rum.internal.startup.RumStartupScenario;
import com.datadog.android.rum.internal.utils.RuntimeUtilsKt;
import com.datadog.android.rum.model.VitalAppLaunchEvent;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RumVitalAppLaunchEventHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0087\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010$R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumVitalAppLaunchEventHelper;", "", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "batteryInfoProvider", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "displayInfoProvider", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "sampleRate", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/rum/RumSessionType;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/rum/internal/domain/InfoProvider;FLcom/datadog/android/api/InternalLogger;)V", "newVitalAppLaunchEvent", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent;", "timestampMs", "", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "eventAttributes", "", "", "customAttributes", "hasReplay", "", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "durationNs", RumAppStartupTelemetryReporterImpl.KEY_SCENARIO, "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "appLaunchMetric", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$AppLaunchMetric;", "profilingStatus", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ProfilingStatus;", "profilingQuotaReason", "(JLcom/datadog/android/api/context/DatadogContext;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Lcom/datadog/android/rum/internal/domain/RumContext;JLcom/datadog/android/rum/internal/startup/RumStartupScenario;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$AppLaunchMetric;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ProfilingStatus;Ljava/lang/String;)Lcom/datadog/android/rum/model/VitalAppLaunchEvent;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumVitalAppLaunchEventHelper {
    private final InfoProvider<BatteryInfo> batteryInfoProvider;
    private final InfoProvider<DisplayInfo> displayInfoProvider;
    private final InternalLogger internalLogger;
    private final RumSessionType rumSessionTypeOverride;
    private final float sampleRate;

    public RumVitalAppLaunchEventHelper(RumSessionType rumSessionType, InfoProvider<BatteryInfo> batteryInfoProvider, InfoProvider<DisplayInfo> displayInfoProvider, float f, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(batteryInfoProvider, "batteryInfoProvider");
        Intrinsics.checkNotNullParameter(displayInfoProvider, "displayInfoProvider");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.rumSessionTypeOverride = rumSessionType;
        this.batteryInfoProvider = batteryInfoProvider;
        this.displayInfoProvider = displayInfoProvider;
        this.sampleRate = f;
        this.internalLogger = internalLogger;
    }

    public final VitalAppLaunchEvent newVitalAppLaunchEvent(long timestampMs, DatadogContext datadogContext, Map<String, ? extends Object> eventAttributes, Map<String, ? extends Object> customAttributes, Boolean hasReplay, RumContext rumContext, long durationNs, RumStartupScenario scenario, VitalAppLaunchEvent.AppLaunchMetric appLaunchMetric, VitalAppLaunchEvent.ProfilingStatus profilingStatus, String profilingQuotaReason) {
        VitalAppLaunchEvent.VitalAppLaunchEventSessionType vitalAppLaunch;
        String syntheticsResultId;
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(eventAttributes, "eventAttributes");
        Intrinsics.checkNotNullParameter(customAttributes, "customAttributes");
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        Intrinsics.checkNotNullParameter(scenario, "scenario");
        Intrinsics.checkNotNullParameter(appLaunchMetric, "appLaunchMetric");
        String syntheticsTestId = rumContext.getSyntheticsTestId();
        VitalAppLaunchEvent.Synthetics synthetics = (syntheticsTestId == null || StringsKt.isBlank(syntheticsTestId) || (syntheticsResultId = rumContext.getSyntheticsResultId()) == null || StringsKt.isBlank(syntheticsResultId)) ? null : new VitalAppLaunchEvent.Synthetics(rumContext.getSyntheticsTestId(), rumContext.getSyntheticsResultId(), null, null, 12, null);
        RumSessionType rumSessionType = this.rumSessionTypeOverride;
        if (rumSessionType != null) {
            vitalAppLaunch = RumSessionTypeExtKt.toVitalAppLaunch(rumSessionType);
        } else if (synthetics == null) {
            vitalAppLaunch = VitalAppLaunchEvent.VitalAppLaunchEventSessionType.USER;
        } else {
            vitalAppLaunch = VitalAppLaunchEvent.VitalAppLaunchEventSessionType.SYNTHETICS;
        }
        BatteryInfo batteryInfo = (BatteryInfo) this.batteryInfoProvider.getCurrentState();
        DisplayInfo displayInfo = (DisplayInfo) this.displayInfoProvider.getCurrentState();
        UserInfo userInfo = datadogContext.getUserInfo();
        String viewId = rumContext.getViewId();
        if (viewId == null) {
            viewId = "00000000-0000-0000-0000-000000000000";
        }
        String viewUrl = rumContext.getViewUrl();
        if (viewUrl == null) {
            viewUrl = "";
        }
        VitalAppLaunchEvent.VitalAppLaunchEventView vitalAppLaunchEventView = new VitalAppLaunchEvent.VitalAppLaunchEventView(viewId, null, viewUrl, rumContext.getViewName());
        Map mutableMap = MapsKt.toMutableMap(customAttributes);
        mutableMap.putAll(eventAttributes);
        VitalAppLaunchEvent.Context context = new VitalAppLaunchEvent.Context(mutableMap);
        VitalAppLaunchEvent.Dd dd = new VitalAppLaunchEvent.Dd(new VitalAppLaunchEvent.DdSession(null, RumEventExtKt.toVitalAppLaunchSessionPrecondition(rumContext.getSessionStartReason()), 1, null), new VitalAppLaunchEvent.Configuration(Float.valueOf(this.sampleRate), null, null, null, null, 30, null), null, null, new VitalAppLaunchEvent.Profiling(profilingStatus, null, profilingQuotaReason, profilingStatus != null ? Long.valueOf(datadogContext.getTime().getServerTimeOffsetMs()) : null, 2, null), 12, null);
        VitalAppLaunchEvent.Application application = new VitalAppLaunchEvent.Application(rumContext.getApplicationId(), datadogContext.getDeviceInfo().getLocaleInfo().getCurrentLocale());
        VitalAppLaunchEvent.VitalAppLaunchEventSession vitalAppLaunchEventSession = new VitalAppLaunchEvent.VitalAppLaunchEventSession(rumContext.getSessionId(), vitalAppLaunch, hasReplay);
        VitalAppLaunchEvent.VitalAppLaunchEventSource vitalAppLaunchEventSourceTryFromSource = RumEventExtKt.tryFromSource(VitalAppLaunchEvent.VitalAppLaunchEventSource.INSTANCE, datadogContext.getSource(), this.internalLogger);
        AccountInfo accountInfo = datadogContext.getAccountInfo();
        VitalAppLaunchEvent.Account account = accountInfo != null ? new VitalAppLaunchEvent.Account(accountInfo.getId(), accountInfo.getName(), MapsKt.toMutableMap(accountInfo.getExtraInfo())) : null;
        VitalAppLaunchEvent.Usr usr = RuntimeUtilsKt.hasUserData(userInfo) ? new VitalAppLaunchEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAnonymousId(), MapsKt.toMutableMap(userInfo.getAdditionalProperties())) : null;
        VitalAppLaunchEvent.Device device = new VitalAppLaunchEvent.Device(RumEventExtKt.toVitalAppLaunchSchemaType(datadogContext.getDeviceInfo().getDeviceType()), datadogContext.getDeviceInfo().getDeviceName(), datadogContext.getDeviceInfo().getDeviceModel(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getArchitecture(), null, datadogContext.getDeviceInfo().getLocaleInfo().getLocales(), datadogContext.getDeviceInfo().getLocaleInfo().getTimeZone(), batteryInfo.getBatteryLevel(), batteryInfo.getLowPowerMode(), displayInfo.getScreenBrightness(), Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam(), 32, null);
        VitalAppLaunchEvent.Os os = new VitalAppLaunchEvent.Os(datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion(), null, datadogContext.getDeviceInfo().getOsMajorVersion(), 4, null);
        VitalAppLaunchEvent.Connectivity appLaunchVitalConnectivity = RumEventExtKt.toAppLaunchVitalConnectivity(datadogContext.getNetworkInfo());
        String version = datadogContext.getVersion();
        String service = datadogContext.getService();
        String ddTagsString = DdTagsUtils.INSTANCE.toDdTagsString(datadogContext);
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        return new VitalAppLaunchEvent(timestampMs, application, service, version, null, null, ddTagsString, vitalAppLaunchEventSession, vitalAppLaunchEventSourceTryFromSource, vitalAppLaunchEventView, usr, account, null, appLaunchVitalConnectivity, null, synthetics, null, os, device, dd, context, null, null, new VitalAppLaunchEvent.Vital(string, RumVitalAppLaunchEventHelperKt.vitalName(appLaunchMetric), null, appLaunchMetric, Long.valueOf(durationNs), RumEventExtKt.toVitalAppLaunchStartupType(scenario), null, Boolean.valueOf(scenario.getHasSavedInstanceStateBundle())), 6377520, null);
    }
}
